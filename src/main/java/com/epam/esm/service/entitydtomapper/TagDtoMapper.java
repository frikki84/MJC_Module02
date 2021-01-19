package com.epam.esm.service.entitydtomapper;

import com.epam.esm.entity.GiftCertificateDTO;
import com.epam.esm.entity.Tag;

import java.util.List;


public interface TagDtoMapper {
    public List<Tag> changeCertificateDtoToTagList(GiftCertificateDTO dto);

}
