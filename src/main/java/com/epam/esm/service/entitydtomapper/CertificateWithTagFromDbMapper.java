package com.epam.esm.service.entitydtomapper;

import com.epam.esm.entity.dto.CertificateWithTagFromDb;
import com.epam.esm.entity.dto.GiftCertificateDto;

import java.util.List;

public interface CertificateWithTagFromDbMapper {
    public List<GiftCertificateDto> createDTOList(List<CertificateWithTagFromDb> list);
}
