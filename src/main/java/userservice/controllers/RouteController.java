package userservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import userservice.controllers.requestbody.RouteBody;
import userservice.model.Route;
import userservice.service.RouteService;

import java.util.List;

@Controller
public class RouteController {

    private RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService){
        this.routeService = routeService;
    }

    @GetMapping(value = "/routes")
    public @ResponseBody Iterable<Route> getRoutes(@RequestBody RouteBody routeBody){
        Iterable<Route> list = routeService.findRutesForCurentDates(routeBody.getDateBegin(), routeBody.getDateEnd());
        return list;
    }
}
