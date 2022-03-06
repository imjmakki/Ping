package app.ping.pingring.API;

import app.ping.pingring.Utility.Implementation.ServerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servers")
public class ServerAPI {

    private ServerServiceImpl serverService;

    @Autowired
    public ServerAPI(ServerServiceImpl serverService) {
        this.serverService = serverService;
    }
}
