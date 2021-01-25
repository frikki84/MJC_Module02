package com.epam.esm.service;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.dto.GiftCertificateDto;

import java.util.List;

public interface CertificateService {
    public List<GiftCertificate> findAllCertificates();
    public GiftCertificate findCertificateById(long id);
    public long createNewCertificate(GiftCertificate certificate);
    public void updateCertificate(GiftCertificate certificate, long id);
    public void deleteCertificate(long id);
    public List<GiftCertificateDto> findCertificatesWithTags();
    public List<GiftCertificateDto> findAllCertificatesWithTagsByTagName(String tagName);
    public List<GiftCertificateDto> sortAllCertificatesByNameAsc();
    public List<GiftCertificateDto> sortAllCertificatesByNameDesc();
    public List<GiftCertificateDto> sortAllCertificatesByNameTime();
    public List<GiftCertificateDto> findAllCertificatesWithTagsByNameOrDescriptionPart(String namePart);


}
