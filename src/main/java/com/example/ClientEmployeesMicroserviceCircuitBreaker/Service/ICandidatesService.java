package com.example.ClientEmployeesMicroserviceCircuitBreaker.Service;

import com.example.ClientEmployeesMicroserviceCircuitBreaker.Model.Candidate;

import java.util.List;

public interface ICandidatesService {

    List<Candidate> candidatesPosition(String position);
}
