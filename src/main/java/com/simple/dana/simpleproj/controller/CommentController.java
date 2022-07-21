package com.simple.dana.simpleproj.controller;

import com.simple.dana.simpleproj.model.Comment;
import com.simple.dana.simpleproj.repository.CommentRepository;
import com.simple.dana.simpleproj.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins="http://localhost:8443")
@RestController

public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getAllComments(){
        return ResponseEntity.ok().body(commentService.getAllComments());
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable int id){
        return ResponseEntity.ok().body(commentService.getCommentById(id));
    }

    @PostMapping("/comments")
    public ResponseEntity<Comment> createProduct(@RequestBody Comment comment){
        return ResponseEntity.ok().body(this.commentService.createComment(comment));
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<List<Comment>> deleteComment(@PathVariable int id){
        commentService.deleteComment(id);
        //poate mesaj?
        return ResponseEntity.ok().body(commentService.getAllComments());
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable int id, @RequestBody Comment comment){
        comment.setId(id);
        return ResponseEntity.ok().body(commentService.updateComment(comment));
    }



}
