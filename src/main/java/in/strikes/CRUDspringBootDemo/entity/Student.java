package in.strikes.CRUDspringBootDemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//In this class we don't have @Component because it is not handled by IOC container.
//Instead it is handled by Spring JPA
@Entity //Tells the springboot that add this class to database but it is not directly connected..The jpa maps the class to the database table.
public class Student  {
    @Id //The primary key.
    private Long id;
    private String name;
    private String email;
    private int age;
    private int rollNo;
    private String subject;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
