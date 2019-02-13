package pl.project.instruktor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public User getCurrentUser(){
        return userRepository.getOne(1l);
    }

    @GetMapping("/{id}")
    public String messageBox() {
        return "messageBox";
    }

    @GetMapping("/received/{id}")
    public String receivedList(@PathVariable long id, Model model) {
        model.addAttribute("messageList", messageRepository.findAllByRecipientUserId(id));
        return "messageReceived";
    }

    @GetMapping("/send/{id}")
    public String sendList(@PathVariable long id, Model model) {
        model.addAttribute("messageList", messageRepository.findAllBySenderUserId(id));
        return "messageSend";
    }

    @GetMapping("/view/{id}")
    public String messageView(@PathVariable long id, Model model) {
        Message toView = messageRepository.getOne(id);
        model.addAttribute("messageToView", toView);
        return "messageView";
    }

    @GetMapping("/response/{id}")
    public String messageResponse(@PathVariable long id, Model model) {
        Message toResponse = messageRepository.getOne(id);
        model.addAttribute("messageToResponse", toResponse);
        model.addAttribute("message", new Message());

        return "messageResponse";
    }

    @PostMapping("/response/{id}")
    public String messageResponseSuccess(@Valid Message message, BindingResult result, @PathVariable long id) {
        if (result.hasErrors()) {
            return "messageResponse";
        }
        messageRepository.save(message);
        return "redirect:/panel/message/"+id;
    }

    @GetMapping("/delete/{id}")
    public String messageRemove(@PathVariable long id, Model model) {
        Message toRemove = messageRepository.getOne(id);
        model.addAttribute("messageToRemove", toRemove);
        return "messageDelete";
    }

    @PostMapping("/delete/{id}")
    public String messageRemoveSuccess(@PathVariable long id) {
        Message toRemove = messageRepository.getOne(id);
        messageRepository.delete(toRemove);
        return "redirect:/panel/message/"+id;
    }

    @GetMapping("/add")
    public String messageAdd(@ModelAttribute Message message){
        return "messageAdd";
    }

    @PostMapping("/add")
    public String messageSuccess(@Valid Message message, BindingResult result){
        if (result.hasErrors()) {
            return "messageAdd";
        }
        messageRepository.save(message);
        return "redirect:/panel/message/{id}";
    }

}
