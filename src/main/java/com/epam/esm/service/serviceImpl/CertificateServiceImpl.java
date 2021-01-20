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

    public GiftCertificate findCertificateById(long id) {
        return certificateDao.findCertificateById(id);
    }

    public long createNewCertificate(GiftCertificate certificate) {
        LocalDateTime currentDate = LocalDateTime.now();
        certificate.setCreateDate(currentDate);
        certificate.setLastUpdateDate(currentDate);
        long certificateId =  certificateDao.createNewCertificate(certificate);
        return  certificateId;
    }

    @Override
    public void updateCertificate(GiftCertificate certificate, long id) {
        GiftCertificate certificateFromDb = certificateDao.findCertificateById(id);

        if (certificate.getName() != null ) {
            certificateFromDb.setName(certificate.getName());
        }
        if (certificate.getDescription() != null) {
            certificateFromDb.setDescription(certificate.getDescription());
        }
        if (certificate.getPrice() != null) {
            certificateFromDb.setPrice(certificate.getPrice());
        }
        if (certificate.getDuration() != 0) {
            certificateFromDb.setDuration(certificate.getDuration());
        }
        if (certificate.getCreateDate() != null) {
            certificateFromDb.setCreateDate(certificate.getCreateDate());
        }

        LocalDateTime currentDate = LocalDateTime.now();
        certificateFromDb.setLastUpdateDate(currentDate);

        certificateDao.updateCertificate(certificateFromDb, id);
    }

    @Override
    public void deleteCertificate(long id) {
        certificateDao.deleteCertificate(id);
    }





}

