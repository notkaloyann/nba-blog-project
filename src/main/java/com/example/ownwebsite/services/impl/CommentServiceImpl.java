package com.example.ownwebsite.services.impl;

import com.example.ownwebsite.models.entities.Comment;
import com.example.ownwebsite.models.service.CommentServiceModel;
import com.example.ownwebsite.repositories.CommentRepository;
import com.example.ownwebsite.services.CommentService;
import com.example.ownwebsite.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class CommentServiceImpl implements CommentService {

    private final ModelMapper modelMapper;
    private final CommentRepository commentRepository;
    private final UserService userService;

    public CommentServiceImpl(ModelMapper modelMapper, CommentRepository commentRepository, UserService userService) {
        this.modelMapper = modelMapper;
        this.commentRepository = commentRepository;
        this.userService = userService;
    }


    @Override
    public Comment addComment(CommentServiceModel commentServiceModel) {

        Comment comment = this.modelMapper.map(commentServiceModel, Comment.class);
        comment.setPostedOn(Instant.now());
        comment.setUser(this.userService.returnUserEntity(commentServiceModel.getUser()));
        this.commentRepository.save(comment);
        return comment;

    }
}
