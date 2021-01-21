package com.epam.esm.dao;

import com.epam.esm.entity.CertificateWithTagFromDb;
import com.epam.esm.entity.GiftCertificateDTO;

import java.util.List;

public interface CertificateTagDao {

    public void createNewCertificateTagRelation(long certificateId, long tagId);
    public List<CertificateWithTagFromDb> findAllCertificatesWithTagsFromDb();
    public List<CertificateWithTagFromDb> findAllCertificatesWithTagsByNameOrDescriptionPart(String namePart);


}
