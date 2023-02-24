package com.codegym.validate_form_dang_ki.service;

import com.codegym.validate_form_dang_ki.model.User;
import com.codegym.validate_form_dang_ki.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public void delete(int id) {
        iUserRepository.deleteById(id);
    }

    @Override
    public User findById(int id) {
        return iUserRepository.findById(id).orElse(null);
    }

    @Override
    public Page<User> findUserByFirstName(String firstName, Pageable pageable) {
        return iUserRepository.findUserByFirstNameContaining(firstName, pageable);
    }
}
