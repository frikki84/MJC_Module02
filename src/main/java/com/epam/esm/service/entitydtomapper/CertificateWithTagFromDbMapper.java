package com.epam.esm.service.entitydtomapper;

import com.epam.esm.entity.dto.CertificateWithTagFromDb;
import com.epam.esm.entity.dto.CertificateDto;

import java.util.List;

public interface CertificateWithTagFromDbMapper {
    public List<CertificateDto> createDTOList(List<CertificateWithTagFromDb> list);
}
