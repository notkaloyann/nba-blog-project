package com.example.ownwebsite.web;


import com.example.ownwebsite.models.binding.ArticleAddBindingModel;
import com.example.ownwebsite.models.service.ArticleServiceModel;
import com.example.ownwebsite.models.view.ArticleViewModel;
import com.example.ownwebsite.services.ArticleService;
import com.example.ownwebsite.services.TeamService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    private final ModelMapper modelMapper;
    private final ArticleService articleService;

    private final TeamService teamService;

    public ArticleController(ModelMapper modelMapper, ArticleService articleService, TeamService teamService) {
        this.modelMapper = modelMapper;
        this.articleService = articleService;
        this.teamService = teamService;
    }

    @ModelAttribute("articleAddBindingModel")
    public ArticleAddBindingModel createBindingModel(){
        return new ArticleAddBindingModel();
    }

    @GetMapping("/all")
    public String allArticles(){
        return "all-articles";
    }


    @GetMapping("/add")
    public String addArticle(){

        return "add-article";
    }

    @PostMapping("/add")
    public String addArticle(@Valid ArticleAddBindingModel articleAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("articleAddBindingModel",articleAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.articleAddBindingModel",bindingResult);
            return "redirect:/articles/add";

        }

        if (this.teamService.returnTeamByName(articleAddBindingModel.getHomeTeam()).isEmpty()
        || this.teamService.returnTeamByName(articleAddBindingModel.getAwayTeam()).isEmpty()){
            redirectAttributes.addFlashAttribute("articleAddBindingModel",articleAddBindingModel);
            redirectAttributes.addFlashAttribute("teamDoesNotExist",true);
            return "redirect:/articles/add";
        }

        ArticleServiceModel articleServiceModel = this.modelMapper.map(articleAddBindingModel, ArticleServiceModel.class);
        articleServiceModel.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        this.articleService.addArticle(articleServiceModel);


        return "redirect:/all";
    }

    @GetMapping("/{id}")
    public String showArticleDetails (@PathVariable Long id, Model model){

        ArticleViewModel article = this.articleService.returnArticleById(id);
        model.addAttribute("article", article);

        return "details";
    }


}
