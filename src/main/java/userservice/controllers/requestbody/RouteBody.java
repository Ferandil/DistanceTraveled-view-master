package userservice.controllers.requestbody;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RouteBody {
    private Long dateBegin;
    private Long dateEnd;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public RouteBody(@JsonProperty("dateBegin") Long dateBegin, @JsonProperty("dateEnd") Long dateEnd){
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
    }

    public void setDateBegin(Long dateBegin){
        this.dateBegin = dateBegin;
    }

    public Long getDateBegin(){
        return this.dateBegin;
    }

    public void setDateEnd(Long dateEnd){ this.dateEnd = dateEnd; }

    public Long getDateEnd(){ return this.dateEnd; }
}
