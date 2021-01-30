package com.epam.esm.service.serviceImpl;

import com.epam.esm.dao.CertificateTagDao;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.dto.CertificateDto;
import com.epam.esm.entity.Tag;
import com.epam.esm.service.CertificateService;
import com.epam.esm.service.CertificateTagService;
import com.epam.esm.service.TagService;
import com.epam.esm.service.mapper.CertificateDtoMapper;
import com.epam.esm.service.mapper.TagDtoMapper;
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
    public Integer createNewCertificateWithTags(CertificateDto dto) {
        GiftCertificate certificate = certificateMapper.changeDtoToCertificate(dto);
        long certificateId = certificateService.createNewCertificate(certificate);

        System.out.println("CertificateTagServiceImpl createNewCertificate " + certificateId);
        List<Tag> tagList = tagDtoMapper.changeCertificateDtoToTagList(dto);
        System.out.println("taglist " + tagList);

        Integer resultField = 0;

        for (Tag tag : tagList) {
            long tagId = 0;
            System.out.println("tag = " + tag.getNameTag() + " tagService = " + tagService.findTag(tag.getNameTag()));
            if (tagService.findTag(tag.getNameTag()) == null) {
                tagId = tagService.addNewTag(tag).getId();

            } else {
                tagId = tagService.findTag(tag.getNameTag()).getId();
            }

           resultField += certificateTagDao.createNewCertificateTagRelation(certificateId, tagId);


        }
        return resultField;
    }
}




