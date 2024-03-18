package com.example.ClientEmployeesMicroserviceCircuitBreaker.Service;

import com.example.ClientEmployeesMicroserviceCircuitBreaker.Model.Candidate;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatesServiceImpl implements ICandidatesService {

    private final RestTemplate restTemplate;

    private final CircuitBreakerFactory circuitBreakerFactory;

    private String url = "http://localhost:8080/";


    public CandidatesServiceImpl(RestTemplate restTemplate, CircuitBreakerFactory circuitBreakerFactory) {
        this.restTemplate = restTemplate;
        this.circuitBreakerFactory = circuitBreakerFactory;
    }

    @Override
    public List<Candidate> candidatesPosition(String position) {

        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuit1");
        return circuitBreaker.run(() -> {
                    List<Candidate> candidates =
                            Arrays.asList(restTemplate.getForObject(url + "employees", Candidate[].class));
                    return candidates.stream()
                            .filter(c -> c.getPosition().equals(position))
                            .collect(Collectors.toList());

                },

                t -> new ArrayList<>());

    }
}
