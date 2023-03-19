package com.example.quan_ly_dien_thoai.repository;

import com.example.quan_ly_dien_thoai.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartphoneRepository extends JpaRepository<Smartphone, Integer> {
}
