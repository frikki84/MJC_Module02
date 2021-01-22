package com.epam.esm.service.serviceImpl;

import com.epam.esm.dao.CertificateDao;
import com.epam.esm.dao.CertificateTagDao;
import com.epam.esm.entity.CertificateWithTagFromDb;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.GiftCertificateDTO;
import com.epam.esm.entity.Tag;
import com.epam.esm.service.CertificateService;
import com.epam.esm.service.entitydtomapper.CertificateDtoMapper;
import com.epam.esm.service.entitydtomapper.TagDtoMapper;
import com.fasterxml.jackson.databind.util.ClassUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CertificateServiceImpl implements CertificateService {
    private final CertificateDao certificateDao;
    private final CertificateTagDao certificateTagDao;
    private final CertificateDtoMapper certificateMapper;


    @Autowired
    public CertificateServiceImpl(CertificateDao certificateDao, CertificateTagDao certificateTagDao, CertificateDtoMapper certificateMapper, TagDtoMapper tagDtoMapper) {
        this.certificateDao = certificateDao;
        this.certificateTagDao = certificateTagDao;
        this.certificateMapper = certificateMapper;
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

        long certificateId = certificateDao.createNewCertificate(certificate);

        return certificateId;
    }

    @Override
    public void updateCertificate(GiftCertificate certificate, long id) {
        GiftCertificate certificateFromDb = certificateDao.findCertificateById(id);
        if (certificate.getName() != null) {
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

    @Override
    public List<GiftCertificateDTO> findCertificatesWithTags() {
        List<CertificateWithTagFromDb> list = certificateTagDao.findAllCertificatesWithTagsFromDb();
        List<GiftCertificateDTO> resultList = certificateMapper.createDTOList(list);
        return resultList;
    }

    @Override
    public List<GiftCertificateDTO> findAllCertificatesWithTagsByTagName(String tagName) {
        List<GiftCertificateDTO> list = findCertificatesWithTags();

        List<GiftCertificateDTO> resultList = list.stream()
                .filter(giftCertificateDTO -> giftCertificateDTO.getTagList()
                        .stream().anyMatch(tag -> tagName.equalsIgnoreCase(tag.getNameTag()))
                ).collect(Collectors.toList());

        return resultList;
    }

    @Override
    public List<GiftCertificateDTO> sortAllCertificatesByNameAsc() {
        List<GiftCertificateDTO> list = findCertificatesWithTags();

        List<GiftCertificateDTO> resultList = list.stream()
                .sorted(((o1, o2) -> o1.getName().compareTo(o2.getName()))
                ).collect(Collectors.toList());

        return resultList;
    }

    @Override
    public List<GiftCertificateDTO> sortAllCertificatesByNameDesc() {
        List<GiftCertificateDTO> list = findCertificatesWithTags();

        List<GiftCertificateDTO> resultList = list.stream()
                .sorted(((o1, o2) -> o2.getName().compareTo(o1.getName()))
                ).collect(Collectors.toList());

        return resultList;
    }

    @Override
    public List<GiftCertificateDTO> sortAllCertificatesByNameTime() {
        List<GiftCertificateDTO> list = findCertificatesWithTags();

        List<GiftCertificateDTO> resultList = list.stream()
                .sorted((o1, o2) -> o1.getName() != o2.getName() ? o1.getName().
                        compareTo(o2.getName()) : o1.getCreateDate().compareTo(o2.getCreateDate())
                ).collect(Collectors.toList());

        return resultList;
    }

    @Override
    public List<GiftCertificateDTO> findAllCertificatesWithTagsByNameOrDescriptionPart(String namePart) {
        List<CertificateWithTagFromDb> list = certificateTagDao.findAllCertificatesWithTagsByNameOrDescriptionPart(namePart);
        List<GiftCertificateDTO> resultList = certificateMapper.createDTOList(list);
        return resultList;
    }
}

