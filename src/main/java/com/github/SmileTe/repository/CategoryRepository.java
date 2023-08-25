package com.github.SmileTe.repository;

import com.github.SmileTe.entity.Category;
import com.github.SmileTe.entity.Feed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByName(String name);
}
