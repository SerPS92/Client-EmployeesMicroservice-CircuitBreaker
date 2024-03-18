package com.example.ClientEmployeesMicroserviceCircuitBreaker.Model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Candidate {

    private String name;
    private int dni;
    private String position;
}
