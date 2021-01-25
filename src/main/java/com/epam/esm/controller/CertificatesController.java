package com.epam.esm.controller;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.dto.GiftCertificateDto;
import com.epam.esm.exception.CustomErrorCode;
import com.epam.esm.exception.InvalidDataException;
import com.epam.esm.exception.NoSuchResourceException;
import com.epam.esm.service.CertificateService;
import com.epam.esm.service.CertificateTagService;
import com.epam.esm.service.validation.CertificateDTOChecking;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certificates")
public class CertificatesController {
    private final CertificateService certificateService;
    private final CertificateTagService certificateTagService;

    public CertificatesController(CertificateService certificateService, CertificateTagService certificateTagService) {
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
            throw new NoSuchResourceException("There is no cerfificate with id " + id, CustomErrorCode.CERTIFICATE);
        }
        return certificate;
    }

    @PostMapping()
    @ResponseBody
    public long createNewCertificate(@RequestBody GiftCertificateDto certificateDto) {
        String dtoChecking = CertificateDTOChecking.chechCertificateDtoFormat(certificateDto);
        if (dtoChecking != null) {
            throw  new InvalidDataException(dtoChecking, CustomErrorCode.CERTIFICATE);
        }
       Long id =  certificateTagService.createNewCertificateWithTags(certificateDto);
       return  id;
    }

    @PatchMapping("/{id}")
    @ResponseBody
    public void updateCertificate(@RequestBody GiftCertificate certificate, @PathVariable("id") long id) {
        certificateService.updateCertificate(certificate, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCertificate(@PathVariable("id") int id) {
        certificateService.deleteCertificate(id);
    }

    @GetMapping("/info")
    public List<GiftCertificateDto> findCertificatesWithTags() {
        List<GiftCertificateDto> certificateList = certificateService.findCertificatesWithTags();
        return certificateList;
    }

    @GetMapping("/info/{tagName}")
    public List<GiftCertificateDto> findCertificatesByTag(@PathVariable("tagName") String tagName) {
        List<GiftCertificateDto> certificateList = certificateService.findAllCertificatesWithTagsByTagName(tagName);
        return certificateList;
    }

    @GetMapping("/info/sort_name_asc")
    public List<GiftCertificateDto> sortCertificatesByNameAsc() {
        List<GiftCertificateDto> certificateList = certificateService.sortAllCertificatesByNameAsc();
        return certificateList;
    }

    @GetMapping("/info/sort_name_decs")
    public List<GiftCertificateDto> sortCertificatesByNameDecs() {
        List<GiftCertificateDto> certificateList = certificateService.sortAllCertificatesByNameDesc();
        return certificateList;
    }

    @GetMapping("/info/sort_name+time")
    public List<GiftCertificateDto> sortCertificatesByNameTime() {
        List<GiftCertificateDto> certificateList = certificateService.sortAllCertificatesByNameTime();
        return certificateList;
    }

    @GetMapping("/info/find/{namePart}")
    public List<GiftCertificateDto> findAllCertificatesWithTagsByNameOrDescriptionPart(@PathVariable("namePart") String namePart) {
        List<GiftCertificateDto> certificateList = certificateService.findAllCertificatesWithTagsByNameOrDescriptionPart(namePart);
        return certificateList;
    }


}


