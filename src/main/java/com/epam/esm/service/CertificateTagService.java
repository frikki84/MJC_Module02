package com.epam.esm.service;

import com.epam.esm.entity.GiftCertificateDataTransferObject;
import org.springframework.stereotype.Component;

@Component
public interface CertificateTagService {
    public void createNewCertificateWithTags(GiftCertificateDataTransferObject dto);


}
