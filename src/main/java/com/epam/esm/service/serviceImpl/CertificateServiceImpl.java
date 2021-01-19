package com.epam.esm.service.serviceImpl;

import com.epam.esm.dao.CertificateDao;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.service.CertificateService;
import com.epam.esm.service.entitydtomapper.CertificateDtoMapper;
import com.epam.esm.service.entitydtomapper.TagDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.List;

@Component
public class CertificateServiceImpl implements CertificateService {
    private final CertificateDao certificateDao;
    private final CertificateDtoMapper certificateMapper;
    private final TagDtoMapper tagDtoMapper;

    @Autowired
    public CertificateServiceImpl(CertificateDao certificateDao, CertificateDtoMapper certificateMapper, TagDtoMapper tagDtoMapper) {
        this.certificateDao = certificateDao;
        this.certificateMapper = certificateMapper;
        this.tagDtoMapper = tagDtoMapper;
    }

    public List<GiftCertificate> findAllCertificates() {
        return certificateDao.findAllCertificates();
    }

    public GiftCertificate findCertificateById(int id) {
        return certificateDao.findCertificateById(id);
    }

    public long createNewCertificate(GiftCertificate certificate) {
        LocalDateTime currentDate = LocalDateTime.now();
        certificate.setCreateDate(currentDate);
        certificate.setLastUpdateDate(currentDate);
        long certificateId =  certificateDao.createNewCertificate(certificate);

        return  certificateId;
    }

    public void updateCertificate(GiftCertificate certificate, int id) {
        LocalDateTime currentDate = LocalDateTime.now();
        certificate.setLastUpdateDate(currentDate);
        certificateDao.updateCertificate(certificate, id);
    }

    public void deleteCertificate(int id) {
        certificateDao.deleteCertificate(id);
    }

    @Override
    public int findcertificateIdByCertificateInformation(GiftCertificate certificate) {
        return 0;
    }


}

