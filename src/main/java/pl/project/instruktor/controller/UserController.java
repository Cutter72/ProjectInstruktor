package pl.project.instruktor.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.project.instruktor.model.CurrentUser;
import pl.project.instruktor.model.User;
import pl.project.instruktor.repository.UserRepository;
import pl.project.instruktor.service.UserServiceImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/panel/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserServiceImpl userService;

    public UserController(UserRepository userRepository, UserServiceImpl userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @ModelAttribute("currentUser")
    public void getCurrentUser(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        User currentUser = userRepository.getOne(customUser.getUser().getId());
        model.addAttribute("currentUser", currentUser);
    }

    @GetMapping("")
    public String viewUser() {
        return "profile";
    }

    @GetMapping("/all")
    public String listUsers(Model model) {
        List<User> userList = userRepository.findAll();
        model.addAttribute("allUsers", userList);
        return "#";
    }

    @GetMapping("/add")
    public String addUser(@ModelAttribute User user) {
        return "userAdd";
    }

    @PostMapping("/add")
    public String addUserSuccess(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "#";
        }
        userRepository.save(user);
        return "redirect:/#";
    }

    @GetMapping("/edit")
    public String editUser() {
        return "profile/profileEdit";
    }

    @PostMapping("/edit")
    public String editCategorySuccess(@AuthenticationPrincipal CurrentUser customUser, @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "profile/profileEdit";
        }
        userService.updateUser(customUser, user);
        return "redirect:/panel/user";
    }

    @GetMapping("/delete")
    public String removeCategory(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        User userToDelete = userRepository.getOne(customUser.getUser().getId());
        model.addAttribute("userToDelete", userToDelete);
        return "#";
    }

    @PostMapping("/delete")
    public String removeCategorySuccess(@AuthenticationPrincipal CurrentUser customUser) {
        User userToDelete = userRepository.getOne(customUser.getUser().getId());
        userRepository.delete(userToDelete);
        return "redirect:/#";
    }
}
