package org.sid.web;

import org.sid.entities.AppUser;
import org.sid.entities.RegisterForm;
import org.sid.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {
    @Autowired AccountService accountService;
    @GetMapping("/register")
    public AppUser register(@RequestBody RegisterForm userForm){
        if (!userForm.getPassword().equals(userForm.getRepassword()))
            throw new RuntimeException("You must confirm your password");
        AppUser user =accountService.findUserByUsername(userForm.getUsername());
        if(user != null) throw new RuntimeException("This user alrady exists");
        AppUser appUser = new AppUser();
        appUser.setUsername(userForm.getUsername());
        appUser.setPassword(userForm.getPassword());
        return accountService.saveUser(appUser);
    }
}
