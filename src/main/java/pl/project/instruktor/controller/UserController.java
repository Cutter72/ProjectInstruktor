package pl.project.instruktor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.project.instruktor.model.User;
import pl.project.instruktor.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/panel/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ModelAttribute("currentUser")
    public User getCurrentUser() {
        return userRepository.getOne(1l);
    }

    @GetMapping("/all")
    public String listUsers(Model model) {
        List<User> userList = userRepository.findAll();
        model.addAttribute("allUsers", userList);
        return "#";
    }

    @GetMapping("/add")
    public String addUser(@ModelAttribute User user) {
        return "#";
    }

    @PostMapping("/add")
    public String addUserSuccess(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "#";
        }
        userRepository.save(user);
        return "redirect:/#";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable long id, Model model) {
        User userToEdit = userRepository.getOne(id);
        model.addAttribute("user", userToEdit);
        return "profile";
    }

    @PostMapping("/edit/{id}")
    public String editCategorySuccess(@Valid User user, BindingResult result, @PathVariable long id) {
        if (result.hasErrors()) {
            return "profile";
        }
        userRepository.save(user);
        return "redirect:/panel/user/edit/"+id;
    }

    @GetMapping("/delete/{id}")
    public String removeCategory(@PathVariable long id, Model model) {
        User userToDelete = userRepository.getOne(id);
        model.addAttribute("userToDelete", userToDelete);
        return "#";
    }

    @PostMapping("/delete/{id}")
    public String removeCategorySuccess(@PathVariable long id) {
        User userToDelete = userRepository.getOne(id);
        userRepository.delete(userToDelete);
        return "redirect:/#";
    }
}
