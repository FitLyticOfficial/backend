package com.fitlytic.backend.repository;

import com.fitlytic.backend.model.Post;
import com.fitlytic.backend.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId(Long userId);
}
