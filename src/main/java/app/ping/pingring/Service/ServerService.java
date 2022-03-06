package app.ping.pingring.Service;

import app.ping.pingring.Entity.Server;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;

@Service
public interface ServerService {

    Server addServer(Server server);
    Server ping(String ipAddress) throws IOException;
    Collection<Server> all(Integer limit);
    Server getServer(Long id);
    Server editServer(Server server);
    Boolean deleteServer(Long id);
}
