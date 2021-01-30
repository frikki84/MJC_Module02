package com.epam.esm.service;

import com.epam.esm.entity.dto.CertificateDto;
import org.springframework.stereotype.Component;

@Component
public interface CertificateTagService {
    public Integer createNewCertificateWithTags(CertificateDto dto);





}
