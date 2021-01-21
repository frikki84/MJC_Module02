package com.epam.esm.service;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.GiftCertificateDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CertificateTagService {
    public void createNewCertificateWithTags(GiftCertificateDTO dto);





}
