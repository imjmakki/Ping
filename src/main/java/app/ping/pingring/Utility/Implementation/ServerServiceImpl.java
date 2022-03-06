package app.ping.pingring.Utility.Implementation;

import app.ping.pingring.DAO.ServerDAO;
import app.ping.pingring.Entity.Server;
import app.ping.pingring.Service.ServerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Random;

import static app.ping.pingring.Utility.enums.Status.*;
import static java.lang.Boolean.*;
import static org.springframework.data.domain.PageRequest.*;

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
        log.info("Adding new ip to ping on: {}", server.getName());
        server.setImageUrl(setServerImageUrl());
        return serverDAO.save(server);
    }

    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Pinging the server: {}", ipAddress);
        Server server = serverDAO.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10000) ? SERVER_UP : SERVER_DOWN);
        serverDAO.save(server);
        return server;
    }

    @Override
    public Collection<Server> all(Integer limit) {
        log.info("Grabbing all servers in the system");
        return serverDAO.findAll(of(0, limit)).toList();
    }

    @Override
    public Server getServer(Long id) {
        log.info("Grabbing server in the system with specific id: {}", id);
        return serverDAO.findById(id).get();
    }

    @Override
    public Server editServer(Server server) {
        log.info("Update and existing server: {}", server.getName());
        return serverDAO.save(server);
    }

    @Override
    public Boolean deleteServer(Long id) {
        log.info("Removing server from the system: {}", id);
        serverDAO.deleteById(id);
        return TRUE;
    }

    private String setServerImageUrl() {
        String[] imageNames = { "server1.png", "server2.png", "server3.png", "server4.png" };
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image" + imageNames[new Random().nextInt(4)]).toUriString();
    }
}
