package pl.project.instruktor.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.project.instruktor.model.Category;
import pl.project.instruktor.model.CurrentUser;
import pl.project.instruktor.model.Offer;
import pl.project.instruktor.model.User;
import pl.project.instruktor.repository.CategoryRepository;
import pl.project.instruktor.repository.OfferRepository;
import pl.project.instruktor.repository.UserRepository;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/panel/offer")
public class OfferController {

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public OfferController(OfferRepository offerRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @ModelAttribute("currentUser")
    public void getCurrentUser(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        User currentUser = userRepository.getOne(customUser.getUser().getId());
        model.addAttribute("currentUser", currentUser);
    }

    @ModelAttribute("categories")
    public void categories(Model model) {
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categories", categoryList);
    }


    @GetMapping("")
    public String listOffers(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        List<Offer> allByUserId = offerRepository.getAllByUserIdSortByDate(customUser.getUser().getId());
        model.addAttribute("offers", allByUserId);
        return "offer";
    }

    @GetMapping("/view")
    public String viewOffer() {
        return "offer/offerView";
    }

    @GetMapping("/add")
    public String addOffer(@ModelAttribute Offer offer) {
        return "offer/offerAdd";
    }

    @PostMapping("/add")
    public String addOfferSuccess(@AuthenticationPrincipal CurrentUser customUser, @Valid Offer offer, BindingResult result) {
        if (result.hasErrors()) {
            return "offer/offerAdd";
        }
        offer.setUser(customUser.getUser());
        offerRepository.save(offer);
        return "redirect:/panel/offer";
    }

    @GetMapping("/edit/{id}")
    public String editOffer(@PathVariable long id, Model model) {
        Offer offerToEdit = offerRepository.getOne(id);
        model.addAttribute("offer", offerToEdit);
        return "offer/offerEdit";
    }

    @PostMapping("/edit/{id}")
    public String editOfferSuccess(@AuthenticationPrincipal CurrentUser customUser, @Valid Offer offer, BindingResult result, @PathVariable long id) {
        if (result.hasErrors()) {
            return "offer/offerEdit";
        }
        offer.setId(id);
        offer.setUser(customUser.getUser());
        offer.setCategory(offerRepository.getOne(id).getCategory());
        offer.setCreated(LocalDateTime.now());
        offerRepository.save(offer);
        return "redirect:/panel/offer";
    }

    @GetMapping("/delete/{id}")
    public String removeOffer(@PathVariable long id, Model model) {
        Offer offerToDelete = offerRepository.getOne(id);
        model.addAttribute("offerToDelete", offerToDelete);
        return "offer/offerDelete";
    }

    @PostMapping("/delete/{id}")
    public String removeOfferSuccess(@PathVariable long id) {
        offerRepository.deleteById(id);
        return "redirect:/panel/offer";
    }
}
