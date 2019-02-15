package pl.project.instruktor.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.project.instruktor.model.CurrentUser;
import pl.project.instruktor.model.Offer;
import pl.project.instruktor.repository.CategoryRepository;
import pl.project.instruktor.repository.OfferRepository;
import pl.project.instruktor.repository.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public HomeController(OfferRepository offerRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @ModelAttribute("offers")
    public void offers(Model model) {
        List<Offer> offerList = offerRepository.findAll();
        model.addAttribute("offers", offerList);
    }


    @GetMapping("")
    public String home(Model model){

        return "home";
    }
}
