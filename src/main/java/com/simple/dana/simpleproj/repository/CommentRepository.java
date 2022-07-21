package com.simple.dana.simpleproj.repository;

import com.simple.dana.simpleproj.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository <Comment, Integer> {
//    @Query(value = "SELECT * FROM comments t WHERE t.author LIKE %?1%")
//    List<Comment> findByAuthor(String author);

}
