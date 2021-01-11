package com.epam.esm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/certificates")
public class GiftCertificatesController {

    @GetMapping()
    public String readCertificates(Model model) {
        return  null;
    }

    @GetMapping("/{id}")
    public String findCertificateById(@PathVariable("id") int id, Model model) {
        return  null;
    }


}


