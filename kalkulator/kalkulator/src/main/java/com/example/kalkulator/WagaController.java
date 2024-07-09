package com.example.kalkulator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WagaController {

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("wagaForm", new WagaForm());
        return "wagaForm";
    }

    @PostMapping("/calculate")
    public String calculateWeight(@ModelAttribute WagaForm wagaForm, Model model) {
        double wagaNaZiemi = wagaForm.getWagaNaZiemi();

        // Współczynniki grawitacyjne
        double merkury = 0.38;
        double wenus = 0.91;
        double mars = 0.38;
        double jowisz = 2.34;
        double saturn = 1.06;
        double uran = 0.92;
        double neptun = 1.19;

        // Oblicz wagę na innych planetach
        double wagaNaMerkurym = wagaNaZiemi * merkury;
        double wagaNaWenus = wagaNaZiemi * wenus;
        double wagaNaMarsie = wagaNaZiemi * mars;
        double wagaNaJowiszu = wagaNaZiemi * jowisz;
        double wagaNaSaturnie = wagaNaZiemi * saturn;
        double wagaNaUranie = wagaNaZiemi * uran;
        double wagaNaNeptunie = wagaNaZiemi * neptun;

        // Dodaj wyniki do modelu
        model.addAttribute("wagaNaZiemi", wagaNaZiemi);
        model.addAttribute("wagaNaMerkurym", wagaNaMerkurym);
        model.addAttribute("wagaNaWenus", wagaNaWenus);
        model.addAttribute("wagaNaMarsie", wagaNaMarsie);
        model.addAttribute("wagaNaJowiszu", wagaNaJowiszu);
        model.addAttribute("wagaNaSaturnie", wagaNaSaturnie);
        model.addAttribute("wagaNaUranie", wagaNaUranie);
        model.addAttribute("wagaNaNeptunie", wagaNaNeptunie);

        return "wagaWynik";
    }
}
