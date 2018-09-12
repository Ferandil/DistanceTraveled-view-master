package userservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import userservice.common.JWTUtils;
import userservice.model.User;
import userservice.service.UserService;

public class AppLoginController {
    UserService userService;

    @Autowired
    @Qualifier("userService")
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/upload/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public  @ResponseBody
    ResponseEntity<User> clientLogin(@RequestBody User user){
        User userDataToCheck;
        HttpHeaders headers = new HttpHeaders();
        if((userDataToCheck = userService.findByLogin(user.getLogin())) != null){
            if(user.getHashPassword().equals(userDataToCheck.getHashPassword())){
                String token = JWTUtils.generateToken(userDataToCheck.getUserID(), null, null, null, null);
                ResponseEntity<User> response = new ResponseEntity<User>(new User(token, null), headers, HttpStatus.OK);
                return response;
            }
            else{
                return null;//new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
            }
        }else{
            return null;//new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
    }
}
