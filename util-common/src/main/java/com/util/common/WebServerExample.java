package com.util.common;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebServerExample {
    private static final Logger logger = Logger.getLogger(WebServerExample.class.getName());

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/get", new HelloWorldHandler());
        server.createContext("/post", new DataHandler());

        server.start();

        logger.log(Level.INFO, "Server started on port 8080.");
    }

    static class HelloWorldHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Hello, World!";
            sendResponse(exchange, response);
            logger.log(Level.INFO, "Handled request for /hello");
        }
    }

    static class DataHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("POST".equals(exchange.getRequestMethod())) {
                String requestData = getRequestData(exchange);

                String response = "Received POST data: " + requestData;
                sendResponse(exchange, response);
                logger.log(Level.INFO, "Handled POST request for /data");
            } else if ("PUT".equals(exchange.getRequestMethod())) {
                String id = extractIdFromUri(exchange.getRequestURI().toString());
                String requestData = getRequestData(exchange);

                String response = "Received PUT data for ID " + id + ": " + requestData;
                sendResponse(exchange, response);
                logger.log(Level.INFO, "Handled PUT request for /data with ID: " + id);
            } else if ("PATCH".equals(exchange.getRequestMethod())) {
                String id = extractIdFromUri(exchange.getRequestURI().toString());
                String requestData = getRequestData(exchange);

                String response = "Received PATCH data for ID " + id + ": " + requestData;
                sendResponse(exchange, response);
                logger.log(Level.INFO, "Handled PATCH request for /data with ID: " + id);
            } else {
                String response = "Invalid request method";
                sendResponse(exchange, response);
                logger.log(Level.WARNING, "Invalid request method: " + exchange.getRequestMethod());
            }
        }
    }

    static String extractIdFromUri(String uri) {
        String[] parts = uri.split("/");
        return parts[parts.length - 1];
    }

    static String getRequestData(HttpExchange exchange) throws IOException {
        byte[] buffer = new byte[1024];
        StringBuilder requestData = new StringBuilder();
        int bytesRead;
        while ((bytesRead = exchange.getRequestBody().read(buffer)) != -1) {
            requestData.append(new String(buffer, 0, bytesRead));
        }
        return requestData.toString();
    }

    static void sendResponse(HttpExchange exchange, String response) throws IOException {
        exchange.sendResponseHeaders(200, response.length());
        OutputStream output = exchange.getResponseBody();
        output.write(response.getBytes());
        output.close();
    }
}

