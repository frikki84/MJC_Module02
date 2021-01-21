package com.epam.esm.service;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.GiftCertificateDTO;

import java.util.List;

public interface CertificateService {
    public List<GiftCertificate> findAllCertificates();
    public GiftCertificate findCertificateById(long id);
    public long createNewCertificate(GiftCertificate certificate);
    public void updateCertificate(GiftCertificate certificate, long id);
    public void deleteCertificate(long id);
    public List<GiftCertificateDTO> findCertificatesWithTags();
    public List<GiftCertificateDTO> findAllCertificatesWithTagsByTagName(String tagName);
    public List<GiftCertificateDTO> sortAllCertificatesByNameAsc();
    public List<GiftCertificateDTO> sortAllCertificatesByNameDesc();
    public List<GiftCertificateDTO> sortAllCertificatesByNameTime();
    public List<GiftCertificateDTO> findAllCertificatesWithTagsByNameOrDescriptionPart(String namePart);


}
