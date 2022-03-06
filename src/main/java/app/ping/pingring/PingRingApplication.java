package app.ping.pingring;

import app.ping.pingring.DAO.ServerDAO;
import app.ping.pingring.Entity.Server;
import app.ping.pingring.Utility.enums.Status;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PingRingApplication {

    public static void main(String[] args) {
        SpringApplication.run(PingRingApplication.class, args);
    }

    CommandLineRunner run(ServerDAO serverDAO) {
        return args -> {
          serverDAO.save(new Server(null, "192.168.1.160", "Ubuntu Linux", "1 TB", "PC",
                  "http://localhost:8080/server/image/server2.png", Status.SERVER_UP));
        };
    }
}
