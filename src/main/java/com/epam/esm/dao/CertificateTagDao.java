package com.epam.esm.dao;

import com.epam.esm.entity.dto.CertificateWithTagFromDb;

import java.util.List;

public interface CertificateTagDao {

    public long createNewCertificateTagRelation(long certificateId, long tagId);
    public List<CertificateWithTagFromDb> findAllCertificatesWithTagsFromDb();
    public List<CertificateWithTagFromDb> findAllCertificatesWithTagsByNameOrDescriptionPart(String namePart);


}
