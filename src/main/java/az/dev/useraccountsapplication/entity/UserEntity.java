package az.dev.useraccountsapplication.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String username;
    @JsonIgnore
    private String password;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String phone;
    private LocalDate dob;




    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public UserEntity(Long id, String username, String password, String name, String surname, String email, String address, String phone, LocalDate dob) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.dob = dob;
    }

    public UserEntity() {

    }
}
