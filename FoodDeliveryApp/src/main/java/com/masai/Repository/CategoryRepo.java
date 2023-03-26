package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
