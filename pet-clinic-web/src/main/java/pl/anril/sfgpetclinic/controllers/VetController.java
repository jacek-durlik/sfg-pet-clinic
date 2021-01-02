package pl.anril.sfgpetclinic.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.anril.sfgpetclinic.services.VetService;

@Controller
@RequiredArgsConstructor
public class VetController {
    private final VetService vetService;
    @RequestMapping({"/vets", "/vets/index", "/vets/index.html"})
    public String listVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}
