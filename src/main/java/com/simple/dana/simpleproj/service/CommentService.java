package com.simple.dana.simpleproj.service;

import com.simple.dana.simpleproj.model.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(Comment comment);

    Comment getCommentById(int id);

    List<Comment> getAllComments();

    Comment updateComment(Comment comment);

    void deleteComment(int id);

}
