package com.example.ownwebsite.services;

import com.example.ownwebsite.models.entities.Article;
import com.example.ownwebsite.models.service.ArticleServiceModel;
import com.example.ownwebsite.models.view.ArticleViewModel;

import java.util.List;

public interface ArticleService {

    public void addArticle(ArticleServiceModel articleServiceModel);
    List<Article> allArticles();
    ArticleViewModel returnArticleById(Long id);

}
