package pl.project.instruktor.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.project.instruktor.model.CurrentUser;
import pl.project.instruktor.model.Message;
import pl.project.instruktor.model.Offer;
import pl.project.instruktor.model.User;
import pl.project.instruktor.repository.MessageRepository;
import pl.project.instruktor.repository.OfferRepository;
import pl.project.instruktor.repository.UserRepository;

import java.util.List;


@Controller
@RequestMapping("/panel")
public class PanelController {
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;
    private final OfferRepository offerRepository;

    public PanelController(UserRepository userRepository, MessageRepository messageRepository, OfferRepository offerRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
        this.offerRepository = offerRepository;
    }

    @ModelAttribute("currentUser")
    public void getCurrentUser(@AuthenticationPrincipal CurrentUser customUser, Model model){
        User currentUser = userRepository.getOne(customUser.getUser().getId());
        model.addAttribute("currentUser", currentUser);
    }

    @RequestMapping("")
    public String panel(@AuthenticationPrincipal CurrentUser customUser, Model model){
        List<Offer> allByUserId = offerRepository.getAllByUserId(customUser.getUser().getId());
        int size = allByUserId.size();
        model.addAttribute("numberOffers", size);

        List<Message> allByRecipientUserId = messageRepository.findAllByRecipientUserId(customUser.getUser().getId());
        int size1 = allByRecipientUserId.size();
        model.addAttribute("numberOfMessages", size1);

        return "panel";
    }

}
