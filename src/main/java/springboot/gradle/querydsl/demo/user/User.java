package springboot.gradle.querydsl.demo.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
