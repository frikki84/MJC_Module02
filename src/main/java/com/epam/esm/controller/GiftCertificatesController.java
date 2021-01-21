package com.epam.esm.controller;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.GiftCertificateDTO;
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
        return fullCertificateList;
    }

    @GetMapping("/{id}")
    public GiftCertificate findCertificateById(@PathVariable("id") long id) {
        GiftCertificate certificate = certificateService.findCertificateById(id);
        return certificate;
    }

    @PostMapping()
    @ResponseBody
    public void createNewCertificate(@RequestBody @Valid GiftCertificateDTO certificateDto) {
        certificateTagService.createNewCertificateWithTags(certificateDto);
    }

    @PatchMapping("/{id}")
    @ResponseBody
    public void updateCertificate(@RequestBody @Valid GiftCertificate certificate, @PathVariable("id") long id) {
        certificateService.updateCertificate(certificate, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCertificate(@PathVariable("id") int id) {
        certificateService.deleteCertificate(id);
    }

    @GetMapping("/info")
    public List<GiftCertificateDTO> findCertificatesWithTags() {
        List<GiftCertificateDTO> certificateList = certificateService.findCertificatesWithTags();
        return certificateList;
    }

    @GetMapping("/info/{tagName}")
    public List<GiftCertificateDTO> findCertificatesByTag(@PathVariable("tagName") String tagName) {
        List<GiftCertificateDTO> certificateList = certificateService.findAllCertificatesWithTagsByTagName(tagName);
        return certificateList;
    }

    @GetMapping("/info/sort_name_asc")
    public List<GiftCertificateDTO> sortCertificatesByNameAsc() {
        List<GiftCertificateDTO> certificateList = certificateService.sortAllCertificatesByNameAsc();
        return certificateList;
    }

    @GetMapping("/info/sort_name_decs")
    public List<GiftCertificateDTO> sortCertificatesByNameDecs() {
        List<GiftCertificateDTO> certificateList = certificateService.sortAllCertificatesByNameDesc();
        return certificateList;
    }

    @GetMapping("/info/sort_name+time")
    public List<GiftCertificateDTO> sortCertificatesByNameTime() {
        List<GiftCertificateDTO> certificateList = certificateService.sortAllCertificatesByNameTime();
        return certificateList;
    }

    @GetMapping("/info/find/{namePart}")
    public List<GiftCertificateDTO> findAllCertificatesWithTagsByNameOrDescriptionPart(@PathVariable("namePart") String namePart) {
        List<GiftCertificateDTO> certificateList = certificateService.findAllCertificatesWithTagsByNameOrDescriptionPart(namePart);
        return certificateList;
    }


}


