package com.epam.esm.service.serviceImpl;

import com.epam.esm.dao.CertificateTagDao;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.GiftCertificateDTO;
import com.epam.esm.entity.Tag;
import com.epam.esm.service.CertificateService;
import com.epam.esm.service.CertificateTagService;
import com.epam.esm.service.TagService;
import com.epam.esm.service.entitydtomapper.CertificateDtoMapper;
import com.epam.esm.service.entitydtomapper.TagDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class CertificateTagServiceImpl implements CertificateTagService {

    private final CertificateDtoMapper certificateMapper;
    private final TagDtoMapper tagDtoMapper;
    private final CertificateService certificateService;
    private final TagService tagService;
    private final CertificateTagDao certificateTagDao;

    @Autowired
    public CertificateTagServiceImpl(CertificateDtoMapper certificateMapper, TagDtoMapper tagDtoMapper, CertificateService certificateService, TagService tagService, CertificateTagDao certificateTagDao) {
        this.certificateMapper = certificateMapper;
        this.tagDtoMapper = tagDtoMapper;
        this.certificateService = certificateService;
        this.tagService = tagService;
        this.certificateTagDao = certificateTagDao;
    }

    @Override
    public void createNewCertificateWithTags(GiftCertificateDTO dto) {
        GiftCertificate certificate = certificateMapper.changeDtoToCertificate(dto);
        long certificateId = certificateService.createNewCertificate(certificate);

        List<Tag> tagList = tagDtoMapper.changeCertificateDtoToTagList(dto);

        for(Tag tag : tagList) {
            long tagId = 0;

            if (tagService.findTag(tag.getName())== null) {
                tagId = tagService.addNewTag(tag);

            } else {
                tagId = tagService.findTag(tag.getName()).getId();
            }

            certificateTagDao.createNewCertificateTagRelation(certificateId, tagId);
        }
    }

    @Override
    public void deleteCertificateWithTags(int id) {

    }


}
