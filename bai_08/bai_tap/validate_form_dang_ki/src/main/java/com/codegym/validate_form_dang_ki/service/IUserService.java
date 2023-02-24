package com.codegym.validate_form_dang_ki.service;

import com.codegym.validate_form_dang_ki.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void save(User user);
    void delete(int id);
    User findById(int id);
    Page<User> findUserByFirstName(String firstName, Pageable pageable);
}
