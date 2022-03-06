package app.ping.pingring.Utility.Implementation;

import app.ping.pingring.DAO.ServerDAO;
import app.ping.pingring.Entity.Server;
import app.ping.pingring.Service.ServerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
@Slf4j
public class ServerServiceImpl implements ServerService {

    private ServerDAO serverDAO;

    @Autowired
    public ServerServiceImpl(ServerDAO serverDAO) {
        this.serverDAO = serverDAO;
    }

    @Override
    public Server addServer(Server server) {
        return null;
    }

    @Override
    public Server ping(String ipAddress) {
        return null;
    }

    @Override
    public Collection<Server> all(Integer limit) {
        return null;
    }

    @Override
    public Server getServer(Long id) {
        return null;
    }

    @Override
    public Server editServer(Server server) {
        return null;
    }

    @Override
    public Boolean deleteServer(Long id) {
        return null;
    }
}
