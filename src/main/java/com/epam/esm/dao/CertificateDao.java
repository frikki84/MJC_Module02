package com.epam.esm.dao;

import com.epam.esm.entity.GiftCertificate;

import java.util.List;

public interface CertificateDao {
    public List<GiftCertificate> findAllCertificates();
    public GiftCertificate findCertificateById(long id);
    public long createNewCertificate(GiftCertificate certificate);
    public void updateCertificate(GiftCertificate certificate, long id);
    public void deleteCertificate(long id);

}
