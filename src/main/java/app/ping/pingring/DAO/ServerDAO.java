package app.ping.pingring.DAO;

import app.ping.pingring.Entity.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerDAO extends JpaRepository<Server, Long> {

    Server findByIpAddress(String ipAddress);
}
