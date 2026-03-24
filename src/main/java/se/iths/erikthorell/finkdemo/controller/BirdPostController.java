package se.iths.erikthorell.finkdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import se.iths.erikthorell.finkdemo.model.BirdPost;
import se.iths.erikthorell.finkdemo.repository.BirdPostRepository;

@Controller
public class BirdPostController {
    private final BirdPostRepository birdPostRepo;

    public BirdPostController(BirdPostRepository birdPostRepo) {
        this.birdPostRepo = birdPostRepo;
    }

    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("post", new BirdPost());
        return "form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BirdPost post) {
        birdPostRepo.save(post);
        return "redirect:/home"; // tillbaka till home
    }
}