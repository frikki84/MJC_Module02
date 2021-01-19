package com.epam.esm.service;

import com.epam.esm.entity.GiftCertificateDTO;
import org.springframework.stereotype.Component;

@Component
public interface CertificateTagService {
    public void createNewCertificateWithTags(GiftCertificateDTO dto);


}
