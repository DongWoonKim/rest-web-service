package com.example.restfulwebservice.user;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
//@JsonIgnoreProperties(value = {"password", "ssn"})
//@JsonFilter("UserInfo")
@NoArgsConstructor
public class User {

    private Integer id;
    @Size(min = 2, message = "Name은 2글자 이상입력하세요")
    private String name;
    @Past
    private Date date;

//    @JsonIgnore
    private String password;
//    @JsonIgnore
    private String ssn;
}
