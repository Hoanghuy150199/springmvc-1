package com.example.springmvc1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {
    @GetMapping("/index")
    public String ViewForm(Model model){
        model.addAttribute("moneyConverter", new Calculator());
        return "index";
    }

    @PostMapping("/convert")
    public String convertCurrency(@ModelAttribute Calculator cal, BindingResult result, Model model){
        model.addAttribute("USD", String.format("%,.0f", cal.getNum1()));
        model.addAttribute("convertToVND", String.format("%,.0f", cal.mul()));
        return "convert";
    }
}
