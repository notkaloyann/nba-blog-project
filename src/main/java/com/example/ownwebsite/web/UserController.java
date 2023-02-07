package com.example.ownwebsite.web;

import com.example.ownwebsite.models.binding.UserRegisterBindingModel;
import com.example.ownwebsite.models.entities.User;
import com.example.ownwebsite.models.service.UserRegistrationServiceModel;
import com.example.ownwebsite.models.view.UserViewModel;
import com.example.ownwebsite.repositories.UserRepository;
import com.example.ownwebsite.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(ModelMapper modelMapper, UserService userService, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.userRepository = userRepository;
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
    public String failedLogin(@ModelAttribute
                                                (UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String username,
                                    RedirectAttributes redirectAttributes){


        redirectAttributes.addFlashAttribute("bad_credentials",true);
        redirectAttributes.addFlashAttribute("username",username);


        return "redirect:/users/login";
    }

    @GetMapping("/profile")
        public String userProfile (Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        UserViewModel userViewModel = this.userService.returnUserViewModel(username);
        model.addAttribute("userViewModel", userViewModel);
        return "profile";
        }

        @PostMapping("/profile")
        public String updateUserProfile(@Valid UserViewModel userViewModel,
                                        BindingResult bindingResult,RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("namesError", true);
            return "redirect:profile";
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

            User user = userService.returnUserEntity(username);
            user.setEmail(userViewModel.getEmail()).setBio(userViewModel.getBio()).setFirstAndLastName(userViewModel.getFirstAndLastName());
            userRepository.save(user);
        return "redirect:/users/profile";
        }


}
