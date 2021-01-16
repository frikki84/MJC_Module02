package com.epam.esm.service;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.GiftCertificateDataTransferObject;

import java.util.List;

public interface CertificateService {
    public List<GiftCertificate> findAllCertificates();
    public GiftCertificate findCertificateById(int id);
    public void createNewCertificate(GiftCertificateDataTransferObject certificateDto);
    public void updateCertificate(GiftCertificate certificate, int id);
    public void deleteCertificate(int id);

}
