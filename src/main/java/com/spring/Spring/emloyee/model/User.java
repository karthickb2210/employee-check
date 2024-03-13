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
public class User {
    @Id

    private Long id;
    private String name;
    private String Date;
    private String inTime;
    private String logOut;
    private  String workdone;
    private String workTime;
    private String email;
}
