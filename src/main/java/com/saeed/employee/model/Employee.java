package com.saeed.employee.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
public record Employee(@Id Long id, String fullName){
}
