package local.ts3snet.booklibrary_test_webapp.controller;

import local.ts3snet.booklibrary_test_webapp.config.validator.UserValidator;
import local.ts3snet.booklibrary_test_webapp.dto.UserDataTransferObject;
import local.ts3snet.booklibrary_test_webapp.entity.UserEntity;
import local.ts3snet.booklibrary_test_webapp.service.UserService;
import local.ts3snet.booklibrary_test_webapp.service.security.SecurityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private UserValidator userValidator;
    @Autowired
    public void setUserValidator(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

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

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") UserDataTransferObject userDataTransferObject, BindingResult bindingResult) {

        UserEntity userForm = new UserEntity();
        BeanUtils.copyProperties(userDataTransferObject, userForm);

        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/";
    }
}
