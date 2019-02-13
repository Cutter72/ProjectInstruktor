package pl.project.instruktor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.project.instruktor.model.Offer;
import pl.project.instruktor.model.User;
import pl.project.instruktor.repository.OfferRepository;
import pl.project.instruktor.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/panel/offer")
public class OfferController {

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;

    public OfferController(OfferRepository offerRepository, UserRepository userRepository) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
    }

    @ModelAttribute("currentUser")
    public User getCurrentUser() {
        return userRepository.getOne(1l);
    }

    @GetMapping("/all")
    public String listUsers(Model model) {
        List<Offer> allByUserId = offerRepository.getAllByUserId(getCurrentUser().getId());
        model.addAttribute("offers", allByUserId);
        return "offer";
    }

    @GetMapping("/add")
    public String addOffer(@ModelAttribute Offer offer) {
        return "#";
    }

    @PostMapping("/add")
    public String addOfferSuccess(@Valid Offer offer, BindingResult result) {
        if (result.hasErrors()) {
            return "#";
        }
        offerRepository.save(offer);
        return "redirect:/#";
    }

    @GetMapping("/edit/{id}")
    public String editOffer(@PathVariable long id, Model model) {
        Offer offerToEdit = offerRepository.getOne(id);
        model.addAttribute("offer", offerToEdit);
        return "#";
    }

    @PostMapping("/edit/{id}")
    public String editOfferSuccess(@Valid Offer offer, BindingResult result, @PathVariable long id) {
        if (result.hasErrors()) {
            return "#";
        }
        offerRepository.save(offer);
        return "redirect:/offer/edit/"+id;
    }

    @GetMapping("/delete/{id}")
    public String removeOffer(@PathVariable long id, Model model) {
        Offer offerToDelete = offerRepository.getOne(id);
        model.addAttribute("offerToDelete", offerToDelete);
        return "#";
    }

    @PostMapping("/delete/{id}")
    public String removeOfferSuccess(@PathVariable long id) {
        Offer offerToDelete = offerRepository.getOne(id);
        offerRepository.delete(offerToDelete);
        return "redirect:/#";
    }
}
