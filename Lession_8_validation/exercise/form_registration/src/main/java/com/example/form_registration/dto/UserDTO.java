package com.example.form_registration.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;

public class UserDTO {

    @NotNull(message = "id không được bỏ trống")
    private Integer id;

    @NotBlank(message = "Tên không được bỏ trống ")
    @Pattern(regexp = "^[a-zA-z]{5,}$", message = "Tên không được có ký tự đặc biệt")
    @Size(min = 5, max = 45, message = "Tên phải có độ dài 5-45")
    private String firstName;

    @NotBlank(message = "Tên không được bỏ trống ")
    @Pattern(regexp = "^[a-zA-z]{5,}$", message = "Tên không được có ký tự đặc biệt")
    @Size(min = 5, max = 45, message = "Tên phải có độ dài 5-45")
    private String lastName;

    @NotBlank(message = "Số điện thoại không được bỏ trống ")
    @Size(min = 8, max = 15)
    private String phoneNumber;

    @NotNull(message = "Tuổi không được bỏ trống")
    @Min(value = 18, message = "Tuối phải lớn hơn 18")
    @Max(value = 120, message = "Tuổi phải nhỏ hơn 120")
    private String age;


    @NotBlank(message = "Email không được bỏ trống")
    @Email
    private String email;

    public UserDTO(Integer id, String firstName, String lastName, String phoneNumber, String age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public UserDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
