package app.ping.pingring.API;

import app.ping.pingring.Entity.HttpResponse;
import app.ping.pingring.Entity.Server;
import app.ping.pingring.Utility.Implementation.ServerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

import static app.ping.pingring.Utility.enums.Status.*;
import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
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

    @GetMapping("/ping/{ipAddress}")
    public ResponseEntity<HttpResponse> pingServer(@PathVariable("ipAddress") String ipAddress) throws IOException {
        Server server = serverService.ping(ipAddress);
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(now())
                        .data(Map.of("server", server))
                        .message(server.getStatus() == SERVER_UP ? "Ping Reply" : "Server Down")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<HttpResponse> pingServer(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(now())
                        .data(Map.of("server", serverService.getServer(id)))
                        .message("Server Founded")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/add")
    public ResponseEntity<HttpResponse> addServer(@RequestBody @Valid Server server) {
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(now())
                        .data(Map.of("server", serverService.addServer(server)))
                        .message("server added to the system")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<HttpResponse> editServer(@RequestBody @Valid Server server) {
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(now())
                        .data(Map.of("server", serverService.editServer(server)))
                        .message("server updated successfully")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpResponse> deleteServer(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(now())
                        .data(Map.of("server", serverService.deleteServer(id)))
                        .message("Server Deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/image/{fileName}")
    public byte[] getServerImage(@PathVariable("fileName") String fileName) {
        return
    }
}
