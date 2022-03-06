package app.ping.pingring;

import app.ping.pingring.DAO.ServerDAO;
import app.ping.pingring.Entity.Server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static app.ping.pingring.Utility.enums.Status.*;

@SpringBootApplication
public class PingRingApplication {

    public static void main(String[] args) {
        SpringApplication.run(PingRingApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ServerDAO serverDAO) {
        return args -> {
          serverDAO.save(new Server(null, "192.168.1.160", "Ubuntu Linux", "1 TB", "Marketing",
                  "http://localhost:8080/server/image/server2.png", SERVER_UP));
          serverDAO.save(new Server(null, "192.168.1.56", "Redhat Linux", "2 TB", "HR",
                    "http://localhost:8080/server/image/server5.png", SERVER_DOWN));
          serverDAO.save(new Server(null, "192.168.1.21", "Fedora Linux", "1.5 TB", "Accounting",
                    "http://localhost:8080/server/image/server6.png", SERVER_UP));
          serverDAO.save(new Server(null, "192.168.1.16", "Ubuntu Linux", "10 TB", "Software",
                    "http://localhost:8080/server/image/server8.png", SERVER_DOWN));
        };
    }
}
