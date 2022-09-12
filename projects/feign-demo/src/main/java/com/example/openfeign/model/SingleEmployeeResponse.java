package com.example.openfeign.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SingleEmployeeResponse {

    @JsonProperty("data")
    Employee employee;
}
