package com.epam.esm.service.serviceImpl;

import com.epam.esm.dao.CertificateTagDao;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.GiftCertificateDataTransferObject;
import com.epam.esm.entity.Tag;
import com.epam.esm.service.CertificateService;
import com.epam.esm.service.CertificateTagService;
import com.epam.esm.service.TagService;
import com.epam.esm.service.entitydtomapper.CertificateDtoMapper;
import com.epam.esm.service.entitydtomapper.TagDtoMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class CertificateTagServiceImpl implements CertificateTagService {
    public static final String SQL_QUERY_INSERT_NEW_CERTIFICATE_WITH_TAGS = "insert into gift_certicicate_has_tag (gift_certicicate_id_gift_certicicate, tag_id_tag) values (?,?) ON CONFLICT(gift_certificates_id, tags_id) DO NOTHING;";

    private final CertificateDtoMapper certificateMapper;
    private final TagDtoMapper tagDtoMapper;
    private final CertificateService certificateService;
    private final TagService tagService;
    private final CertificateTagDao certificateTagDao;


    public CertificateTagServiceImpl(CertificateDtoMapper certificateMapper, TagDtoMapper tagDtoMapper, CertificateService certificateService, TagService tagService, CertificateTagDao certificateTagDao) {
        this.certificateMapper = certificateMapper;
        this.tagDtoMapper = tagDtoMapper;
        this.certificateService = certificateService;
        this.tagService = tagService;
        this.certificateTagDao = certificateTagDao;
    }

    @Override
    public void createNewCertificateWithTags(GiftCertificateDataTransferObject dto) {

        GiftCertificate certificate = certificateMapper.changeDtoToCertificate(dto);
        certificateService.createNewCertificate(certificate);


        List<Tag> tagList = tagDtoMapper.changeCertificateDtoToTagList(dto);

        for(Tag tag : tagList) {
            if (tagService.findTagByName(tag.getName())== null) {
                tagService.addNewTag(tag);


            }

        }
    }

    private void addNewCertificateTagRelation() {}
}
