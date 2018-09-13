package userservice.model.forapp;

import com.fasterxml.jackson.annotation.JsonGetter;
import userservice.model.Route;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class RouteForTransfer {
    private List<Route> userRoutes;
    private String token;

    public RouteForTransfer(){
        userRoutes = new ArrayList<Route>();
    }
    public RouteForTransfer(List<Route> userRoutes){
        this.userRoutes = userRoutes;
    }

    public void addRouteToList(Route route){
        if(route != null){
            userRoutes.add(route);
        }
    }

    public void addAllroutesToList(List<Route> routes){
        if(routes != null){
            for (Route route: routes) {
                userRoutes.add(route);
            }
        }
    }
    public void setToken(String token){
        this.token = token;
    }

    @JsonGetter
    public List<Route> getUserCoords(){
        return this.userRoutes;
    }
    @JsonGetter
    public String getToken(){
        return this.token;
    }
}
