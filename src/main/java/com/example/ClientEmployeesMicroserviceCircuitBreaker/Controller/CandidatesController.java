package com.example.ClientEmployeesMicroserviceCircuitBreaker.Controller;

import com.example.ClientEmployeesMicroserviceCircuitBreaker.Model.Candidate;
import com.example.ClientEmployeesMicroserviceCircuitBreaker.Service.ICandidatesService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CandidatesController {

    private final ICandidatesService candidatesService;

    public CandidatesController(ICandidatesService candidatesService) {
        this.candidatesService = candidatesService;
    }

    @GetMapping(value = "candidates/{position}")
    public List<Candidate> candidatesPosition(@PathVariable(name = "position") String position){
        return candidatesService.candidatesPosition(position);
    }
}
