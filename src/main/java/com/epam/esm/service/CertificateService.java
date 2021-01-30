package com.epam.esm.service;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.dto.CertificateDto;

import java.util.List;

public interface CertificateService {
    public List<GiftCertificate> findAllCertificates();
    public GiftCertificate findCertificateById(long id);
    public Integer createNewCertificate(GiftCertificate certificate);
    public Integer updateCertificate(GiftCertificate certificate, long id);
    public Integer deleteCertificate(long id);
    public List<CertificateDto> findCertificatesByTagName(String tagName);
    public List<CertificateDto> sortAllCertificatesByNameAsc();
    public List<CertificateDto> findAllCertificatesByNameDescriptionPart(String namePart);


}
