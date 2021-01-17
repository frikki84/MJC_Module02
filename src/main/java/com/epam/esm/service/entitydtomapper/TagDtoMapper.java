package com.epam.esm.service.entitydtomapper;

import com.epam.esm.entity.GiftCertificateDataTransferObject;
import com.epam.esm.entity.Tag;
import org.springframework.stereotype.Component;

import java.util.List;


public interface TagDtoMapper {
    public List<Tag> changeCertificateDtoToTagList(GiftCertificateDataTransferObject dto);

}
