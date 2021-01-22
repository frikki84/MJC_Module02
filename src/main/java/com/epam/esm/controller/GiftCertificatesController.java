package com.epam.esm.controller;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.GiftCertificateDTO;
import com.epam.esm.exception.InvalidDataException;
import com.epam.esm.exception.NoSuchResourceException;
import com.epam.esm.service.CertificateService;
import com.epam.esm.service.CertificateTagService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/certificates")
public class GiftCertificatesController {
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
        if (certificate == null) {
            throw  new NoSuchResourceException("There is no cerfificate with id " + id);
        }
        return certificate;
    }

    @PostMapping()
    @ResponseBody
    public long createNewCertificate(@RequestBody @Valid GiftCertificateDTO certificateDto) {
       Long id =  certificateTagService.createNewCertificateWithTags(certificateDto);
        System.out.println("id "  + id);
       if (id == null || id == 0) {
           throw  new InvalidDataException("Gift certificate has invalid data");
       }

       return  id;
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


