package com.epam.esm.service.entitydtomapper.impl;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.GiftCertificateDataTransferObject;
import com.epam.esm.entity.Tag;
import com.epam.esm.service.entitydtomapper.CertificateDtoMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CertificateDtoMapperImpl implements CertificateDtoMapper {
    @Override
    public GiftCertificate changeDtoToCertificate(GiftCertificateDataTransferObject dto) {
        GiftCertificate certificate = new GiftCertificate(dto.getName(), dto.getDescription(), dto.getPrice()
                , dto.getDaysDuration(), dto.getCreateDate(), dto.getLastUpdateDate());

        return certificate;
    }

    @Override
    public GiftCertificateDataTransferObject changeCertificateToDto(GiftCertificate certificate, List<Tag> tagList) {
        return null;
    }
}
