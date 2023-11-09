package java6bai4.java6_bai4.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class Student {

    String email;

    String fullname;

    Double marks;

    Boolean gender;

    String country;
}
