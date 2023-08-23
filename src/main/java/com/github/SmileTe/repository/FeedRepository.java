package com.github.SmileTe.repository;

import com.github.SmileTe.entity.Feed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedRepository extends JpaRepository<Feed,Long> {
}
