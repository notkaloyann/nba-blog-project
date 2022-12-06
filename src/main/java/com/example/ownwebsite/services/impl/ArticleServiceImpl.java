package com.example.ownwebsite.services.impl;

import com.example.ownwebsite.models.entities.Article;
import com.example.ownwebsite.models.service.ArticleServiceModel;
import com.example.ownwebsite.repositories.ArticleRepository;
import com.example.ownwebsite.services.ArticleService;
import com.example.ownwebsite.services.MatchupService;
import com.example.ownwebsite.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    private final ModelMapper modelMapper;
    private final ArticleRepository articleRepository;
    private final MatchupService matchupService;
    private final UserService userService;

    public ArticleServiceImpl(ModelMapper modelMapper, ArticleRepository articleRepository, MatchupService matchupService, UserService userService) {
        this.modelMapper = modelMapper;
        this.articleRepository = articleRepository;
        this.matchupService = matchupService;
        this.userService = userService;
    }


    @Override
    public void addArticle(ArticleServiceModel articleServiceModel) {

        Article article = this.modelMapper.map(articleServiceModel, Article.class);
        article.setMatchup(this.matchupService.addMatchup(articleServiceModel));
        article.setCreatedOn(Instant.now());
        article.setUserEntity(this.userService.returnUserEntity(articleServiceModel.getUsername()));
        this.articleRepository.save(article);


    }

    @Override
    public List<Article> allArticles() {
        return this.articleRepository.findAll();
    }
}
