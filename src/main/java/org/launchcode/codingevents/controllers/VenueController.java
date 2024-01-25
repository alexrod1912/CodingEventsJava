package org.launchcode.codingevents.controllers;

import jakarta.validation.Valid;
import org.launchcode.codingevents.models.Tag;
import org.launchcode.codingevents.models.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.launchcode.codingevents.data.VenueRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("venues")
public class VenueController {
    @Autowired
    VenueRepository venueRepository;

    @GetMapping("index")
    public String displayVenues(Model model){
        model.addAttribute("title", "All Values");
        model.addAttribute("venues", venueRepository.findAll());
        return "venues/index";
    }

    @GetMapping("create")
    public String displayCreateVenueForm(Model model) {
        model.addAttribute("title", "Create Venue");
        model.addAttribute(new Venue());
        return "venues/create";
    }

    @PostMapping("create")
    public String processCreateVenueForm(@ModelAttribute @Valid Venue venue,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Venue");
            model.addAttribute(venue);
            return "venues/create";
        }

        venueRepository.save(venue);
        return "redirect:/venues/index";
    }
}
