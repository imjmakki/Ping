package app.ping.pingring.Utility.Implementation;

import app.ping.pingring.DAO.ServerDAO;
import app.ping.pingring.Entity.Server;
import app.ping.pingring.Service.ServerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;

import static app.ping.pingring.Utility.enums.Status.*;

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
        log.info("adding new ip to ping on: {}", server.getName());
        server.setImageUrl(setServerImageUrl());
        return serverDAO.save(server);
    }

    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("pinging the server: {}", ipAddress);
        Server server = serverDAO.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10000) ? SERVER_UP : SERVER_DOWN);
        serverDAO.save(server);
        return server;
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

    private String setServerImageUrl() {
        return null;
    }
}
