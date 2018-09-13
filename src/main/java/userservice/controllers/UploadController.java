package userservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;
import userservice.common.JWTUtils;
import userservice.model.Route;
import userservice.model.User;
import userservice.model.User;
import userservice.model.UserCoord;
import userservice.model.forapp.RouteForTransfer;
import userservice.service.RouteService;
import userservice.service.UserService;

@Controller
public class UploadController {
    UserService userService;
    RouteService routeService;
    //@PostMapping(value = "/upload")
   // public @ResponseBody String handleFileUpload(@RequestParam("Accept") String post){
     //   System.out.println(post);
      //  return null;
   // }
    @Autowired
    public UploadController(UserService userService, RouteService routeService){
        this.routeService = routeService;
        this.userService = userService;
    }


    @Qualifier("userService")
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> readCoord(@RequestBody RouteForTransfer routeForTransfer){
        Long userId = new Long(JWTUtils.getAudience(routeForTransfer.getToken()).get(0));
        for(Route route : routeForTransfer.getUserCoords()){
            Route toSafe = new Route(route);
            toSafe.setDateOfCreation(route.getCoordinates().get(0).getTimestamp().getTime());
            toSafe.setUserID(userId);
            routeService.saveRoute(toSafe);
        }
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
