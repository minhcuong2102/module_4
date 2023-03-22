package com.codegym.quan_ly_blog.repository;

import com.codegym.quan_ly_blog.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<AppUser,Integer> {
    AppUser findByUserName(String name);
}
