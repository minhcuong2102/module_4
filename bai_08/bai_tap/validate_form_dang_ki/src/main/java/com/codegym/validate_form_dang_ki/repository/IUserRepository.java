package com.codegym.validate_form_dang_ki.repository;

import com.codegym.validate_form_dang_ki.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    Page<User> findUserByFirstNameContaining(String firstName, Pageable pageable);
}
