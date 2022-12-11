package com.example.ownwebsite.services;

import com.example.ownwebsite.models.entities.Comment;
import com.example.ownwebsite.models.service.CommentServiceModel;

public interface CommentService {

    Comment addComment(CommentServiceModel commentServiceModel);

}
