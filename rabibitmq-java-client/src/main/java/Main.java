import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import connection.RabbitMqConnection;
import lombok.SneakyThrows;
import com.rabbitmq.client.MessageProperties;

public class Main {
    private final static String EXCHANGE_NAME = "test-exchange";

    // exchange type: direct and Topic, routing keys for publisher to send test message
    private final String[] routingKeyDirect = {"error", "debug", "info"};
    private final String[] routingKeyTopic = {"error.app1", "error.app2", "debug.app1", "debug.app2", "info.app1", "info.app2"};
    public static void main(String[] args) {
    }

    public Thread send(final String type, final String msg, final int count){
        Thread thread = new Thread(new Runnable() {

            private Connection connection = null;
            private Channel channel = null;
            @SneakyThrows
            @Override
            public void run() {

                try {
                    connection = RabbitMqConnection.createConnection();
                    channel = connection.createChannel();

                    channel.exchangeDeclare(EXCHANGE_NAME, type);

                    int i = 0;
                    String[] routingKey = type.equals("direct") ? routingKeyDirect : routingKeyTopic;
                    while(!Thread.currentThread().isInterrupted()) {
                        if (i++ >= count) break;

                        String newMsg = msg + ": " + i;

                        channel.basicPublish(EXCHANGE_NAME, routingKey[i%routingKey.length], MessageProperties.PERSISTENT_TEXT_PLAIN, newMsg.getBytes());
                        System.out.println("Sent " + routingKey[i%routingKey.length] + ": '" + newMsg + "'");
                        Thread.sleep(1000);
                    }
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    try {
                        channel.close();
                        connection.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                System.out.println("Publisher thread exists");
            }
        });
        thread.start();
        return thread;
    }
}
