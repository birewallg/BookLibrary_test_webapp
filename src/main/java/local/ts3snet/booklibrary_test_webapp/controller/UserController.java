package local.ts3snet.booklibrary_test_webapp.controller;

import local.ts3snet.booklibrary_test_webapp.config.UserValidator;
import local.ts3snet.booklibrary_test_webapp.dto.UserDTO;
import local.ts3snet.booklibrary_test_webapp.entity.UserEntity;
import local.ts3snet.booklibrary_test_webapp.service.SecurityService;
import local.ts3snet.booklibrary_test_webapp.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private SecurityService securityService;
    @Autowired
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

    private UserValidator userValidator;
    @Autowired
    public void setUserValidator(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new UserEntity());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") UserDTO userDTO, BindingResult bindingResult) {

        UserEntity userForm = new UserEntity();
        BeanUtils.copyProperties(userDTO, userForm);

        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
    @GetMapping("/loguot")
    public String logout(Model model, String error, String logout) {
        return "loguot";
    }

    @GetMapping("/welcome")
    public String welcome(Model model) {
        return "welcome";
    }

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/news")
    public String news() {
        return "news";
    }
}