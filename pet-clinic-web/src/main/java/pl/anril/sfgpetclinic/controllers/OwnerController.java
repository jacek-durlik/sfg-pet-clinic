package pl.anril.sfgpetclinic.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.anril.sfgpetclinic.services.OwnerService;

@Controller
@RequiredArgsConstructor
public class OwnerController {
    private final OwnerService ownerService;

    @RequestMapping({"/owners", "/owners/index", "/owners/index.html"})
    public String listOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping({"/owners/find", "oups"})
    public String findOwners() {
        return "notimplemented";
    }
}
