package com.example.openfeign.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ListEmployeeResponse {
    Integer page;

    @JsonProperty("per_page")
    Integer perPage;

    Long total;

    @JsonProperty("total_pages")
    Integer totalPages;

    @JsonProperty("data")
    List<Employee> employee;


}
