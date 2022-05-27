package dev.ranieri.app;

import lombok.*;

// lombok will use reflection to read these annotations and make it a reality
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

    private int id;

    @NonNull
    private String fname;

    @NonNull
    private String lname;

}
