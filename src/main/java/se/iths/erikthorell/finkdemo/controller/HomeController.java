package se.iths.erikthorell.finkdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.iths.erikthorell.finkdemo.repository.BirdPostRepository;

@Controller
public class HomeController {

    private final BirdPostRepository birdPostRepo;

    public HomeController(BirdPostRepository birdPostRepo) {
        this.birdPostRepo = birdPostRepo;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("posts", birdPostRepo.findAll());
        return "home"; // home.html
    }
}