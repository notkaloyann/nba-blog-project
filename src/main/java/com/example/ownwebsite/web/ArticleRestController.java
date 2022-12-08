package com.example.ownwebsite.web;


import com.example.ownwebsite.models.view.ArticleViewModel;
import com.example.ownwebsite.services.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/articles")
public class ArticleRestController {

    private final ModelMapper modelMapper;
    private final ArticleService articleService;

    public ArticleRestController(ModelMapper modelMapper, ArticleService articleService) {
        this.modelMapper = modelMapper;
        this.articleService = articleService;
    }

    @GetMapping("/api")
    ResponseEntity<List<ArticleViewModel>> articles (){
        List<ArticleViewModel> articleViewModels =
                this.articleService.allArticles()
                        .stream().map(article -> this.modelMapper.map(article, ArticleViewModel.class))
                        .collect(Collectors.toList());

        return ResponseEntity.ok().body(articleViewModels);

    }



}
