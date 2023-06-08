package command;


import lombok.Getter;

@Getter
public class ConnectionCommand {
    private String userName;
    private String password;
    private String virtualHost;
    private String host;
    private Integer port;
}
