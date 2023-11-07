package java6bai3.java6_bai3.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    String email;

    String fullName;

    Double marks;

    Boolean gender;

    String country;
}
