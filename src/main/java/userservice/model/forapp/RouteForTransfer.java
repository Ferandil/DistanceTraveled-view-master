package userservice.model.forapp;

import com.fasterxml.jackson.annotation.JsonGetter;
import userservice.model.UserCoord;

import java.util.ArrayList;
import java.util.List;

public class RouteForTransfer {
    private List<UserCoord> userCoords;
    private String token;

    public RouteForTransfer(){
        userCoords = new ArrayList<UserCoord>();
    }
    public RouteForTransfer(List<UserCoord> userCoords, String token) {
        this.userCoords = userCoords;
        this.token = token;
    }

    public void addCoordsToList(List<UserCoord> userCoordList){
        if(!userCoordList.isEmpty()){
            userCoordList.forEach(userCoords::add);
        }
    }

    public void addCoordsToList(UserCoord[] userCoordArray){
        if(userCoordArray.length != 0){
            for (UserCoord userCoord : userCoordArray) {
                userCoords.add(userCoord);
            }
        }
    }

    @JsonGetter
    public List<UserCoord> getUserCoords(){
        return this.userCoords;
    }
    @JsonGetter
    public String getToken(){
        return this.token;
    }
}
