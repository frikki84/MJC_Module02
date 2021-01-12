package com.epam.esm.service;

import com.epam.esm.dao.CertificateDao;
import com.epam.esm.model.GiftCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.List;

@Component
public class CertificateService {
    private final CertificateDao certificateDao;

    @Autowired
    public CertificateService(CertificateDao certificateDao) {
        this.certificateDao = certificateDao;
    }

    public List<GiftCertificate> readCertificates() {
        return certificateDao.readCertificates();
    }

    public GiftCertificate findCertificateById(int id) {
        return certificateDao.findCertificateById(id);
    }

    public void createNewCertificate(GiftCertificate certificate) {
        LocalDateTime currentDate = LocalDateTime.now();
        certificate.setCreateDate(currentDate);
        certificate.setLastUpdateDate(currentDate);
        certificateDao.createNewCertificate(certificate);
    }

    public void updateCertificate(GiftCertificate certificate, int id) {
        LocalDateTime currentDate = LocalDateTime.now();
        certificate.setLastUpdateDate(currentDate);
        certificateDao.updateCertificate(certificate, id);
    }



}
