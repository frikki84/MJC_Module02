package com.epam.esm.service.entitydtomapper.impl;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.GiftCertificateDTO;
import com.epam.esm.entity.Tag;
import com.epam.esm.service.entitydtomapper.CertificateDtoMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CertificateDtoMapperImpl implements CertificateDtoMapper {

    @Override
    public GiftCertificate changeDtoToCertificate(GiftCertificateDTO dto) {
        GiftCertificate certificate = new GiftCertificate(dto.getName(), dto.getDescription(), dto.getPrice()
                , dto.getDuration());
        System.out.println("service mapping" + certificate);

        return certificate;
    }

    @Override
    public GiftCertificateDTO changeCertificateToDto(GiftCertificate certificate, List<Tag> tagList) {
        return null;
    }
}
