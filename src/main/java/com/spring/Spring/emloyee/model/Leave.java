package com.spring.Spring.emloyee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Leave {
    @Id
    private Long id;
    private String name;
    private String date;
    private Boolean status;
    private String days;
    private String details;
}
