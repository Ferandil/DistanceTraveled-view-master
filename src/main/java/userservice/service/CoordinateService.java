package userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userservice.repository.CoordinateRepository;

@Service
public class CoordinateService {
    private CoordinateRepository repository;

    @Autowired
    public CoordinateService(CoordinateRepository coordinateRepository){
        this.repository = coordinateRepository;
    }

    public void deletAll(){
        repository.deleteAll();
    }
}
