package com.epam.esm.service.entitydtomapper;

import com.epam.esm.entity.dto.CertificateWithTagFromDb;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.dto.GiftCertificateDto;
import com.epam.esm.entity.Tag;

import java.util.List;


public interface CertificateDtoMapper {
    public GiftCertificate changeDtoToCertificate(GiftCertificateDto dto);

    public GiftCertificateDto changeCertificateToDto(GiftCertificate certificate, List<Tag> tagList);




}
