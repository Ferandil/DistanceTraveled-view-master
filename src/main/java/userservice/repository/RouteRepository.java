package userservice.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import userservice.model.Route;
/**
 * repository for Route Node Entity
 */
public interface RouteRepository extends Neo4jRepository<Route, Long> {
    public Iterable<Route> findAllByUserIDEquals(Long userId);

    public Iterable<Route> findAllBydateOfCreationBetween(Long dateBegin, Long dateEnd);
}
