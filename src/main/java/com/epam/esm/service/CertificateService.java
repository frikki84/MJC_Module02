package com.epam.esm.service;

import com.epam.esm.entity.GiftCertificate;

import java.util.List;

public interface CertificateService {
    public List<GiftCertificate> findAllCertificates();
    public GiftCertificate findCertificateById(int id);
    public long createNewCertificate(GiftCertificate certificate);
    public void updateCertificate(GiftCertificate certificate, int id);
    public void deleteCertificate(int id);
    public int findcertificateIdByCertificateInformation(GiftCertificate certificate);

}
