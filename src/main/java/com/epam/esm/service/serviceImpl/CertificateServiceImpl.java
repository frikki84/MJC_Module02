package com.epam.esm.service.serviceImpl;

import com.epam.esm.dao.CertificateDao;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.GiftCertificateDataTransferObject;
import com.epam.esm.entity.Tag;
import com.epam.esm.service.CertificateService;
import com.epam.esm.service.entitydtomapper.CertificateMapper;
import com.epam.esm.service.entitydtomapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.List;

@Component
public class CertificateServiceImpl implements CertificateService {
    private final CertificateDao certificateDao;
    private final CertificateMapper certificateMapper;
    private final TagMapper tagMapper;

    @Autowired
    public CertificateServiceImpl(CertificateDao certificateDao, CertificateMapper certificateMapper, TagMapper tagMapper) {
        this.certificateDao = certificateDao;
        this.certificateMapper = certificateMapper;
        this.tagMapper = tagMapper;
    }

    public List<GiftCertificate> findAllCertificates() {
        return certificateDao.findAllCertificates();
    }

    public GiftCertificate findCertificateById(int id) {
        return certificateDao.findCertificateById(id);
    }

    public void createNewCertificate(GiftCertificateDataTransferObject certificateDto) {
       GiftCertificate giftCertificate = certificateMapper.changeDtoToCertificate(certificateDto);
       addCurrentDateToCertificateInCreation(giftCertificate);
       certificateDao.createNewCertificate(giftCertificate);

       List<Tag> tagList = tagMapper.changeCertificateDtoToTagList(certificateDto);





    }

    public void updateCertificate(GiftCertificate certificate, int id) {
        LocalDateTime currentDate = LocalDateTime.now();
        certificate.setLastUpdateDate(currentDate);
        certificateDao.updateCertificate(certificate, id);
    }

    public void deleteCertificate(int id) {
        certificateDao.deleteCertificate(id);
    }

    private GiftCertificate addCurrentDateToCertificateInCreation(GiftCertificate certificate) {
        LocalDateTime currentDate = LocalDateTime.now();
        certificate.setCreateDate(currentDate);
        certificate.setLastUpdateDate(currentDate);
        return  certificate;
    }









}
