package userservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import userservice.controllers.UploadController;
import userservice.model.Coordinate;
import userservice.model.Route;
import userservice.model.User;
import userservice.service.CoordinateService;
import userservice.service.RouteService;
import userservice.service.UserService;
import userservice.service.UserService;

import java.util.Arrays;
import java.util.List;

/**
 * main application class
 */
@SpringBootApplication
@EnableNeo4jRepositories
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        log.info("Starting context");
        SpringApplication.run(Application.class);
        log.info("Finishing context");
    }

    /**
     * command line to test application
     * @param service
     * @return
     */
    @Bean
    public CommandLineRunner demo(RouteService service, UserService userService, CoordinateService coordinateService) {
        return (args) -> {
            log.info("Application is running");
            Coordinate coord1 = new Coordinate(12.36, 14.15);
            Coordinate coord2 = new Coordinate(12.89, 14.5);
            Coordinate coord3 = new Coordinate(13.4, 14.98);
            List<Coordinate> listCoordinates = Arrays.asList(coord1, coord2, coord3);
            service.saveRoute(listCoordinates, 1L, 1000101010L);
            coord1 = new Coordinate(15.36, 17.15);
            coord2 = new Coordinate(17.89, 20.5);
            coord3 = new Coordinate(20.4, 25.98);
            listCoordinates = Arrays.asList(coord1, coord2, coord3);
            service.saveRoute(listCoordinates, 1L, 10012342534530L);
            service.saveRoute(listCoordinates, 1L, 234324235236123L);
            service.saveRoute(listCoordinates, 1L, 46457567456345150L);

            Iterable<Route> list = service.findRutesForCurentDates(1536791916000L, 1536794606000L);
            userService.saveUser("alex", "1234");
            User user = userService.findByLogin("alex");
            log.info("-------------------------------");
        };
    }
}
