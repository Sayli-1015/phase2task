package com.example.usertask.Model;

import lombok.Data;

import jakarta.persistence.*;
//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;



@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


//    @NotBlank(message = "Name is required")
    @NotEmpty(message = "Name is required")
    @Size(max = 50, message = "Name must be at most 50 characters")
    @Column(name = "name")
    private String name;




//    @NotBlank(message = "Last name is required")
    @NotEmpty(message = "Name is required")
    @Size(max = 50, message = "Last name must be at most 50 characters")
    @Column(name = "lastname")
    private String lastname;


    //    @NotBlank(message = "Phone is required")
    @NotEmpty(message = "Name is required")
    @Pattern(regexp = "\\d{10}", message = "Phone must be 10 digits")
    @Column(name = "phone")
    private String phone;


//    @NotBlank(message = "Address is required")
    @NotEmpty(message = "Name is required")
    @Size(max = 255, message = "Address must be at most 255 characters")
    @Column(name = "address")
    private String address;



    //getters and setters

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//
//
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
}
