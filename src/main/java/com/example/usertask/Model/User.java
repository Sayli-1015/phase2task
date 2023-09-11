package com.example.usertask.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import jakarta.persistence.*;
//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import java.io.Serializable;




@Entity
@Table(name = "users")
@Data
public class User implements Serializable {
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


//    for file upload
//    @Lob
//    @Column(name = "file_content")
//    private byte[] fileContent;

    @Transient
//    @Getter @Setter
    private MultipartFile userFile;

    // Getter for userFile
    public MultipartFile getUserFile() {
        return userFile;
    }

    // Setter for userFile
    public void setUserFile(MultipartFile userFile) {
        this.userFile = userFile;
    }




    //getters and setters

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
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
