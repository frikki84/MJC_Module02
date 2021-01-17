package com.epam.esm.service.entitydtomapper.impl;

import com.epam.esm.entity.GiftCertificateDataTransferObject;
import com.epam.esm.entity.Tag;
import com.epam.esm.service.entitydtomapper.TagDtoMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TagDtoMapperImpl implements TagDtoMapper {
    @Override
    public List<Tag> changeCertificateDtoToTagList(GiftCertificateDataTransferObject dto) {
        List<Tag> tagList = dto.getTagList();
        return tagList;

    }
}
