package connection;


import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import command.ConnectionCommand;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RabbitMqConnection {

    private String userName; // Default guest
    private String password; // Default guest
    private String virtualHost; // Default "/"
    private String host; // Default "localhost"
    private Integer port; // Default "15671"

    @SneakyThrows
    public static Connection connectionFactory(ConnectionCommand command){
        ConnectionFactory factory = new ConnectionFactory();

        factory.setUsername(command.getUserName());
        factory.setPassword(command.getPassword());
        factory.setVirtualHost(command.getVirtualHost());
        factory.setHost(command.getHost());
        factory.setPort(command.getPort());

        return factory.newConnection();
    }
    @SneakyThrows
    public static Connection createConnection(){
        ConnectionFactory factory = new ConnectionFactory();

        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        factory.setHost("localhost");
        factory.setPort(15671);

        return factory.newConnection();
    }
    @SneakyThrows
    public void closeConnection(){
        createConnection().close();
    }
}
