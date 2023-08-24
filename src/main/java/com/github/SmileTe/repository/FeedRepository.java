package com.github.SmileTe.repository;

import com.github.SmileTe.entity.Feed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface FeedRepository extends JpaRepository<Feed,Long> {

    List<Feed> findAllByName(String name);

}
