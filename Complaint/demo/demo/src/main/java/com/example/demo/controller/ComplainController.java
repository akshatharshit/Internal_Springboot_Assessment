package com.example.demo.controller;

import com.example.demo.model.Complain;
import com.example.demo.service.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ComplainController {

    @Autowired
    private ComplainService complainService;

    // Home page - List all complains
    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("complains", complainService.getAllComplains());
        return "home";  // View: home.html
    }

    // Show form to add complain
    @GetMapping("/complain/add")
    public String addComplainForm(Model model) {
        model.addAttribute("complain", new Complain());
        return "complain_form";  // View: complain_form.html
    }

    // Save new complain
    @PostMapping("/complain/save")
    public String saveComplain(@ModelAttribute("complain") Complain complain) {
        complainService.saveComplain(complain);
        return "redirect:/home";
    }

    // Show form to update complain
    @GetMapping("/complain/edit/{id}")
    public String editComplainForm(@PathVariable Long id, Model model) {
        Complain complain = complainService.getComplainById(id);
        if (complain == null) {
            return "redirect:/home";  // Avoid 500 error if not found
        }
        model.addAttribute("complain", complain);
        return "complain_form";
    }


    // Delete complain
    @GetMapping("/complain/delete/{id}")
    public String deleteComplain(@PathVariable Long id) {
        complainService.deleteComplain(id);
        return "redirect:/home";
    }


    // View single complain detail
    @GetMapping("/complain/view/{id}")
    public String viewComplain(@PathVariable Long id, Model model) {
        Complain complain = complainService.getComplainById(id);
        if (complain == null) {
            return "redirect:/home";
        }
        model.addAttribute("complain", complain);
        return "complain_view"; // New template for viewing details
    }
}
