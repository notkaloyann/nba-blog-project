package com.example.ownwebsite.web;

import com.example.ownwebsite.models.binding.UserRegisterBindingModel;
import com.example.ownwebsite.models.service.UserRegistrationServiceModel;
import com.example.ownwebsite.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;

    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){
        //Test current user:
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //System.out.println(auth.getPrincipal());
        return "login";
    }

    @GetMapping("/register")
    public String register(){

        return "register";
    }

    //Initialize attribute for GetMapping
    @ModelAttribute("userRegisterBindingModel")
    public UserRegisterBindingModel createBindingModel(){
        return new UserRegisterBindingModel();
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserRegisterBindingModel userRegisterBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){

            if (this.userService.alreadyExist(userRegisterBindingModel.getUsername())){
                redirectAttributes.addFlashAttribute("userRegisterBindingModel",userRegisterBindingModel);
                redirectAttributes.addFlashAttribute("userOccupied",true);
            }

            redirectAttributes.addFlashAttribute("userRegisterBindingModel",userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",bindingResult);
            return "redirect:register";

        }


        this.userService.registerUser(this.modelMapper.map(
                userRegisterBindingModel, UserRegistrationServiceModel.class)
        );


        return "redirect:/";
    }

    @PostMapping("/logging-error")
    public ModelAndView failedLogin(@ModelAttribute
                                                (UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String username){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("bad_credentials",true);
        modelAndView.addObject("username",username);
        modelAndView.setViewName("/login");

        return modelAndView;
    }


}
