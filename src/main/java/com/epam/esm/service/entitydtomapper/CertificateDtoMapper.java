package com.epam.esm.service.entitydtomapper;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.GiftCertificateDataTransferObject;
import com.epam.esm.entity.Tag;
import org.springframework.stereotype.Component;

import java.util.List;


public interface CertificateDtoMapper {
    public GiftCertificate changeDtoToCertificate(GiftCertificateDataTransferObject dto);

    public GiftCertificateDataTransferObject changeCertificateToDto(GiftCertificate certificate, List<Tag> tagList);



}
