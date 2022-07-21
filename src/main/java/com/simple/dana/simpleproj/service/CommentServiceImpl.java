package com.simple.dana.simpleproj.service;

import com.simple.dana.simpleproj.model.Comment;
import com.simple.dana.simpleproj.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment getCommentById(int id) {
        Optional<Comment> commentDb = commentRepository.findById(id);

        if(commentDb.isPresent()) {
            return commentDb.get();
        } else {
            throw new RuntimeException("Comment not found with id : " + id);
        }
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public void deleteComment(int id) {
        Optional<Comment> commentDb = commentRepository.findById(id);

        if (commentDb.isPresent()) {
            commentRepository.delete(commentDb.get());
        } else {
            throw new RuntimeException("Comment not found with id : " + id);
        }
    }

    @Override
    public Comment updateComment(Comment comment) {
        Optional<Comment> commentDb = commentRepository.findById(comment.getId());

        if(commentDb.isPresent()) {
            Comment commentUpdate = commentDb.get();
            commentUpdate.setId(comment.getId());
            commentUpdate.setAuthor(comment.getAuthor());
            commentUpdate.setText(comment.getText());
            commentRepository.save(commentUpdate);
            return commentUpdate;
        } else {
            throw new RuntimeException("Comment not found with id : " + comment.getId());
        }
    }


}
