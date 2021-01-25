package com.epam.esm.service;

import com.epam.esm.entity.dto.GiftCertificateDto;
import org.springframework.stereotype.Component;

@Component
public interface CertificateTagService {
    public long createNewCertificateWithTags(GiftCertificateDto dto);





}
