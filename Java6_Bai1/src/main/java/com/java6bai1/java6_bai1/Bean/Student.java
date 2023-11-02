package com.java6bai1.java6_bai1.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    String name;

    Boolean gender = false;

    Double marks = 0.0;

}
