package com.epam.esm.dao;

public interface CertificateTagDao {

    public void createNewCertificateTagRelation(long certificateId, long tagId);
    public void deleteCertificateWithTags(long certificateId);
}
