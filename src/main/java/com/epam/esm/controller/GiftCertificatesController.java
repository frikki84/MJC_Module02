package com.epam.esm.controller;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.GiftCertificateDataTransferObject;
import com.epam.esm.service.CertificateService;
import com.epam.esm.service.CertificateTagService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@Controller
@RequestMapping("/certificates")
public class GiftCertificatesController {
//    public static final String PATH_TO_CERTIFICATE_LIST_PAGE = "certificates/index";
//    public static final String PATH_TO_ONE_CERTIFICATE = "certificates/show";
//    public static final String PATH_TO_ADDING_NEW_CERTIFICATE = "certificates/new";
//    public static final String PATH_TO_MAIN_PAGE = "redirect:/certificates";
//    public static final String PATH_TO_EDIT_CERTIFICATE = "certificates/edit";
//    public static final String PATH_TO_ERROR_PAGE = "certificates/error";

    private final CertificateService certificateService;
    private final CertificateTagService certificateTagService;

    public GiftCertificatesController(CertificateService certificateService, CertificateTagService certificateTagService) {
        this.certificateService = certificateService;
        this.certificateTagService = certificateTagService;
    }


    @GetMapping()
    public List<GiftCertificate> findAllCertificates() {
        List<GiftCertificate> fullCertificateList = certificateService.findAllCertificates();
        //model.addAttribute("certificateList", fullCertificateList);

        return fullCertificateList;
    }

    @GetMapping("/{id}")
    public GiftCertificate findCertificateById(@PathVariable("id") int id) {
        GiftCertificate certificate = certificateService.findCertificateById(id);
       //model.addAttribute("certificate", certificate);
        return certificate;
    }

//    @GetMapping("/new")
//    public String  addNewCertificate(@ModelAttribute("certificate") GiftCertificate certificate) {
//        return PATH_TO_ADDING_NEW_CERTIFICATE;
//    }

    @PostMapping()
    @ResponseBody
    public void createNewCertificate(@RequestBody @Valid GiftCertificateDataTransferObject certificateDto) {
        certificateTagService.createNewCertificateWithTags(certificateDto);
    }

//    @GetMapping("/{id}/edit")
//    public String editCertificate(Model model, @PathVariable("id") int id) {
//        GiftCertificate certificate = certificateService.findCertificateById(id);
//        model.addAttribute("certificate", certificate);
//        return PATH_TO_EDIT_CERTIFICATE;
//    }

    @PatchMapping("/{id}")
    @ResponseBody
    public void updateCertificate(@RequestBody @Valid GiftCertificate certificate, BindingResult bindingResult, @PathVariable("id") int id) {
//        if (bindingResult.hasErrors()) {
//            return PATH_TO_ERROR_PAGE;
//        }
        certificateService.updateCertificate(certificate, id);
       // return PATH_TO_MAIN_PAGE;
    }

    @DeleteMapping("/{id}")
    public void deleteCertificate(@PathVariable("id") int id) {
        certificateService.deleteCertificate(id);
    }


}


