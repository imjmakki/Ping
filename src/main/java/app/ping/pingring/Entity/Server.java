package app.ping.pingring.Entity;

import app.ping.pingring.Utility.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "servers")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Server implements Serializable {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @NotEmpty(message = "IP address is required can not be empty or null")
    @Column(name = "ip", unique = true)
    private String ipAddress;

    @Column(name = "server_name")
    private String name;
    private String memory;

    @Column(name = "server_type")
    private String type;

    @Column(name = "image")
    private String imageUrl;
    private Status status;
}
