package org.mentorbridge.entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "students")
public class StudentEntity {
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private int age;
    private String course;
    private String city;
}


