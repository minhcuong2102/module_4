package com.codegym.validate_form_dang_ki.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    private int id;
    @NotEmpty
    @Size(min = 5, max = 45, message = "Tên dài từ 5 - 45 kí tự!")
    private String firstName;
    @NotEmpty
    @Size(min = 5, max = 45, message = "Tên dài từ 5 - 45 kí tự!")
    private String lastName;
    @NotEmpty
    private String phoneNumber;
    @Min(value = 18, message = "Tuổi phải trên 18!")
    private int age;
    @NotEmpty
    @Email(message = "Email phải theo định dạng ***@***.***")
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        String phoneNumber = userDto.getPhoneNumber();
        if (!phoneNumber.matches("^\\d+$")) {
            errors.rejectValue("phoneNumber", null, "Số điện thoại chỉ chứa ký tự số");
        } else if (phoneNumber.length() <= 9 && phoneNumber.length() >= 12) {
            errors.rejectValue("phoneNumber", null, "Số điện thoại phải dài 10 hoặc 11 chữ số");
        }
    }
}
