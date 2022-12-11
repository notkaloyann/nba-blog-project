package com.example.ownwebsite.web;

import com.example.ownwebsite.models.view.CommentViewModel;
import com.example.ownwebsite.repositories.ArticleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("articles/")
public class CommentRestController {

    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;

    public CommentRestController(ArticleRepository articleRepository, ModelMapper modelMapper) {
        this.articleRepository = articleRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping("{id}/comments")
    ResponseEntity <List<CommentViewModel>> comments (@PathVariable Long id){

        List<CommentViewModel> articleComments = this.articleRepository.findById(id).orElse(null).getComments()
                .stream().map(comment -> {
                   CommentViewModel commentViewModel = this.modelMapper.map(comment,CommentViewModel.class);
                   commentViewModel.setUser(comment.getUser().getUsername());
                   return commentViewModel;
                }).collect(Collectors.toList());
        return ResponseEntity.ok().body(articleComments);

    }



}
