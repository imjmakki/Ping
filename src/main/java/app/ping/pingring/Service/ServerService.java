package app.ping.pingring.Service;

import app.ping.pingring.Entity.Server;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface ServerService {

    Server add(Server server);
    Collection<Server> all(Integer limit);
}
