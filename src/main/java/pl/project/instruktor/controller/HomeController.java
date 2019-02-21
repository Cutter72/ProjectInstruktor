package pl.project.instruktor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.project.instruktor.model.Offer;
import pl.project.instruktor.model.User;
import pl.project.instruktor.repository.OfferRepository;
import pl.project.instruktor.repository.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;


    public HomeController(OfferRepository offerRepository, UserRepository userRepository) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
    }

    @ModelAttribute("offers")
    public void offers(Model model) {
        List<Offer> offerList = offerRepository.getAllAndOrderByCreated();
        model.addAttribute("offers", offerList);

        int size = offerList.size();
        model.addAttribute("offersize", size);

        List<User> all = userRepository.findAll();
        int size1 = all.size();
        model.addAttribute("userssize", size1);
    }

    @GetMapping("")
    public String home(Model model) {

        return "home";
    }

    @GetMapping("/offer/{id}")
    public String editOffer(@PathVariable long id, Model model) {
        Offer offerToEdit = offerRepository.getOne(id);
        model.addAttribute("offer", offerToEdit);
        return "offer/offerView";
    }
}
