package com.epam.esm.service.entitydtomapper;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.GiftCertificateDTO;
import com.epam.esm.entity.Tag;

import java.util.List;


public interface CertificateDtoMapper {
    public GiftCertificate changeDtoToCertificate(GiftCertificateDTO dto);

    public GiftCertificateDTO changeCertificateToDto(GiftCertificate certificate, List<Tag> tagList);



}
