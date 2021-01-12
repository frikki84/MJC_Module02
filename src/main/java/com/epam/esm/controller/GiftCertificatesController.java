package com.epam.esm.controller;

import com.epam.esm.model.GiftCertificate;
import com.epam.esm.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/certificates")
public class GiftCertificatesController {
    public static final String PATH_TO_CERTIFICATE_LIST_PAGE = "certificates/index";
    public static final String PATH_TO_ONE_CERTIFICATE = "certificates/show";
    public static final String PATH_TO_ADDING_NEW_CERTIFICATE = "certificates/new";
    public static final String PATH_TO_MAIN_PAGE = "redirect:/certificates";
    public static final String PATH_TO_EDIT_CERTIFICATE = "certificates/edit";

    private final CertificateService certificateService;

    @Autowired
    public GiftCertificatesController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    @GetMapping()
    public String readCertificates(Model model) {
        List<GiftCertificate> fullCertificateList = certificateService.readCertificates();
        model.addAttribute("certificateList", fullCertificateList);
        return PATH_TO_CERTIFICATE_LIST_PAGE;
    }

    @GetMapping("/{id}")
    public String findCertificateById(@PathVariable("id") int id, Model model) {
        GiftCertificate certificate = certificateService.findCertificateById(id);
        model.addAttribute("certificate", certificate);
        return PATH_TO_ONE_CERTIFICATE;
    }

    @GetMapping("/new")
    public String addNewCertificate(@ModelAttribute("certificate") GiftCertificate certificate) {
        return PATH_TO_ADDING_NEW_CERTIFICATE;
    }

    @PostMapping()
    public String createNewCertificate(@ModelAttribute("certificate") GiftCertificate certificate) {
        certificateService.createNewCertificate(certificate);
        return PATH_TO_MAIN_PAGE;
    }

    @GetMapping("/{id}/edit")
    public String editSertificate(Model model, @PathVariable("id") int id) {
        GiftCertificate certificate = certificateService.findCertificateById(id);
        model.addAttribute("certificate", certificate);
        return PATH_TO_EDIT_CERTIFICATE;
    }

    @PatchMapping("/{id}")
    public String updateCertificate(@ModelAttribute("certificate") GiftCertificate certificate, @PathVariable("id") int id) {
        certificateService.updateCertificate(certificate, id);
        return PATH_TO_MAIN_PAGE;
    }


}


