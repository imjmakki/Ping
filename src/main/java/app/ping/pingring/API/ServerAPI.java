package app.ping.pingring.API;

import app.ping.pingring.Entity.HttpResponse;
import app.ping.pingring.Utility.Implementation.ServerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/server")
public class ServerAPI {

    private ServerServiceImpl serverService;

    @Autowired
    public ServerAPI(ServerServiceImpl serverService) {
        this.serverService = serverService;
    }

    @GetMapping("/all")
    public ResponseEntity<HttpResponse> getServers() {
        return ResponseEntity.ok(
          HttpResponse.builder()
                  .timeStamp(now())
                  .data(Map.of("servers", serverService.all(30)))
                  .message("server found")
                  .status(OK)
                  .statusCode(OK.value())
                  .build()
        );
    }
}
