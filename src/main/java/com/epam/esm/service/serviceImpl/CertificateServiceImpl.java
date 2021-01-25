package com.epam.esm.service.serviceImpl;

import com.epam.esm.dao.CertificateDao;
import com.epam.esm.dao.CertificateTagDao;
import com.epam.esm.entity.dto.CertificateWithTagFromDb;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.dto.GiftCertificateDto;
import com.epam.esm.service.CertificateService;
import com.epam.esm.service.entitydtomapper.CertificateDtoMapper;
import com.epam.esm.service.entitydtomapper.CertificateWithTagFromDbMapper;
import com.epam.esm.service.entitydtomapper.TagDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CertificateServiceImpl implements CertificateService {
    private final CertificateDao certificateDao;
    private final CertificateTagDao certificateTagDao;
    private final CertificateDtoMapper certificateMapper;
    private final CertificateWithTagFromDbMapper certificateWithTagFromDbMapper;


    @Autowired
    public CertificateServiceImpl(CertificateDao certificateDao, CertificateTagDao certificateTagDao, CertificateDtoMapper certificateMapper, TagDtoMapper tagDtoMapper, CertificateWithTagFromDbMapper certificateWithTagFromDbMapper) {
        this.certificateDao = certificateDao;
        this.certificateTagDao = certificateTagDao;
        this.certificateMapper = certificateMapper;
        this.certificateWithTagFromDbMapper = certificateWithTagFromDbMapper;
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
    public List<GiftCertificateDto> findCertificatesWithTags() {
        List<CertificateWithTagFromDb> list = certificateTagDao.findAllCertificatesWithTagsFromDb();
        List<GiftCertificateDto> resultList = certificateWithTagFromDbMapper.createDTOList(list);
        return resultList;
    }

    @Override
    public List<GiftCertificateDto> findAllCertificatesWithTagsByTagName(String tagName) {
        List<GiftCertificateDto> list = findCertificatesWithTags();

        List<GiftCertificateDto> resultList = list.stream()
                .filter(giftCertificateDTO -> giftCertificateDTO.getTagList()
                        .stream().anyMatch(tag -> tagName.equalsIgnoreCase(tag.getNameTag()))
                ).collect(Collectors.toList());

        return resultList;
    }

    @Override
    public List<GiftCertificateDto> sortAllCertificatesByNameAsc() {
        List<GiftCertificateDto> list = findCertificatesWithTags();

        List<GiftCertificateDto> resultList = list.stream()
                .sorted(((o1, o2) -> o1.getName().compareTo(o2.getName()))
                ).collect(Collectors.toList());

        return resultList;
    }

    @Override
    public List<GiftCertificateDto> sortAllCertificatesByNameDesc() {
        List<GiftCertificateDto> list = findCertificatesWithTags();

        List<GiftCertificateDto> resultList = list.stream()
                .sorted(((o1, o2) -> o2.getName().compareTo(o1.getName()))
                ).collect(Collectors.toList());

        return resultList;
    }

    @Override
    public List<GiftCertificateDto> sortAllCertificatesByNameTime() {
        List<GiftCertificateDto> list = findCertificatesWithTags();

        List<GiftCertificateDto> resultList = list.stream()
                .sorted((o1, o2) -> o1.getName() != o2.getName() ? o1.getName().
                        compareTo(o2.getName()) : o1.getCreateDate().compareTo(o2.getCreateDate())
                ).collect(Collectors.toList());

        return resultList;
    }

    @Override
    public List<GiftCertificateDto> findAllCertificatesWithTagsByNameOrDescriptionPart(String namePart) {
        List<CertificateWithTagFromDb> list = certificateTagDao.findAllCertificatesWithTagsByNameOrDescriptionPart(namePart);
        List<GiftCertificateDto> resultList = certificateWithTagFromDbMapper.createDTOList(list);
        return resultList;
    }
}

