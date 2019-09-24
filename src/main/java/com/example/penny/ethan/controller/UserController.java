package com.example.penny.ethan.controller;

import com.example.penny.ethan.model.Login;
import com.example.penny.ethan.model.User;
import com.example.penny.ethan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "ethan")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public String displaySignupForm(Model model) {
        model.addAttribute(new User());
        model.addAttribute("title", "user");
        return "signup";
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String processSignupForm(Model model, @ModelAttribute @Valid User user, Error error) {

        userRepository.save(user);

        //Solution 1: add the model attributes
//        model.addAttribute(new Login());
//        model.addAttribute("title","login");
//        return "login";
        //solution 2: call the existing get login method
        return displayLoginForm(model);
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String displayLoginForm(Model model) {
        model.addAttribute(new Login());
        model.addAttribute("title", "login");
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String processLoginForm(Model model, @ModelAttribute @Valid Login login, Errors errors) {
        //1 go to db search user with email/username
        //2 if user exists the password match
        //Add validation here

        if (errors.hasErrors()) {
            model.addAttribute(new Login());
            model.addAttribute("title", "login");
            return "login";
        }

        User user = userRepository.findByUserName(login.getUserName());

        if (user != null) {
            if (user.getPassword().equals(login.getPassword())) {
                System.out.println("yaaaaaaas! Logged in");
                return "homepage";
            }
        }
        return displayLoginForm(model);
    }
    @RequestMapping (value = "home", method = RequestMethod.GET)
    public String displayHomePage(){
        return "homepage";
    }
}
