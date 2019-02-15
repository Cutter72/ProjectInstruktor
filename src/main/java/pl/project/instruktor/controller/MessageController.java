package pl.project.instruktor.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import pl.project.instruktor.model.CurrentUser;
import pl.project.instruktor.model.Message;
import pl.project.instruktor.model.User;
import pl.project.instruktor.repository.MessageRepository;
import pl.project.instruktor.repository.UserRepository;


import javax.validation.Valid;



@Controller
@RequestMapping("/panel/message")
public class MessageController {


    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public MessageController(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    @ModelAttribute("currentUser")
    public void getCurrentUser(@AuthenticationPrincipal CurrentUser customUser, Model model){
        User currentUser = userRepository.getOne(customUser.getUser().getId());
        model.addAttribute("currentUser", currentUser);
    }

    @GetMapping("")
    public String messageBox(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        model.addAttribute("messageReceived", messageRepository.findAllByRecipientUserId(customUser.getUser().getId()));
        model.addAttribute("messageSend", messageRepository.findAllBySenderUserId(customUser.getUser().getId()));
        return "message";
    }

    @GetMapping("/view/{id}")
    public String messageView(@PathVariable long id, Model model) {
        Message toView = messageRepository.getOne(id);
        model.addAttribute("messageToView", toView);
        return "message/messageView";
    }

    @GetMapping("/response/{id}")
    public String messageResponse(@PathVariable long id, Model model) {
        Message toResponse = messageRepository.getOne(id);
        model.addAttribute("messageToResponse", toResponse);
        model.addAttribute("message", new Message());

        return "message/messageResponse";
    }

    @PostMapping("/response/{id}")
    public String messageResponseSuccess(@Valid Message message, BindingResult result, @PathVariable long id) {
        if (result.hasErrors()) {
            return "message/messageResponse";
        }
        messageRepository.save(message);
        return "redirect:/panel/message";
    }

    @GetMapping("/delete/{id}")
    public String messageRemove(@PathVariable long id, Model model) {
        Message toRemove = messageRepository.getOne(id);
        model.addAttribute("messageToRemove", toRemove);
        return "message/messageDelete";
    }

    @PostMapping("/delete/{id}")
    public String messageRemoveSuccess(@PathVariable long id) {
        Message toRemove = messageRepository.getOne(id);
        messageRepository.delete(toRemove);
        return "redirect:/panel/message";
    }

    @GetMapping("/add")
    public String messageAdd(@ModelAttribute Message message){
        return "messageAdd";
    }

    @PostMapping("/add")
    public String messageSuccess(@Valid Message message, BindingResult result){
        if (result.hasErrors()) {
            return "message/messageAdd";
        }
        messageRepository.save(message);
        return "redirect:/panel/message";
    }

}
