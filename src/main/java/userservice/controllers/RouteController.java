package userservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import userservice.model.Route;
import userservice.service.RouteService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RouteController {

    private RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService){
        this.routeService = routeService;
    }

    @GetMapping(value = "/routes")
    public @ResponseBody List<Route> getRoutes(WebRequest request){
        List<Route> routesList = new ArrayList<>();
        List<Long> dateList = new ArrayList<>();

        request.getParameterMap().forEach((name, date) -> {
            dateList.add(Long.valueOf(date[0]));
        });
        routeService.findRutesForCurentDates(dateList.get(0), dateList.get(1)).forEach(routesList::add);
        return routesList;
    }
}
