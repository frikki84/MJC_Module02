package com.epam.esm.dao;

import com.epam.esm.model.GiftCertificate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class CertificateDao {
    private List<GiftCertificate> certificateList;

    {
        certificateList = new ArrayList<>();
        certificateList.add(new GiftCertificate(1, "spa", "for 2 person", new BigDecimal(150),
                60, LocalDateTime.now(),
                LocalDateTime.now()));
        certificateList.add(new GiftCertificate(2, "ralli", "for 2 person", new BigDecimal(500),
                60, LocalDateTime.now(),
                LocalDateTime.now()));
        certificateList.add(new GiftCertificate(3, "dinner", "for 2 person", new BigDecimal(100),
                60, LocalDateTime.now(),
                LocalDateTime.now()));
    }

    public  List<GiftCertificate> readCertificates(){
        return  certificateList;
    }

    public GiftCertificate findCertificateById(int id) {
        return certificateList.stream().filter(giftCertificate -> giftCertificate.getId() == id).findAny().orElse(null);
    }

    public void createNewCertificate(GiftCertificate certificate) {
        certificateList.add(certificate);
    }

    public  void updateCertificate(GiftCertificate updatedCertificate, int id) {
        GiftCertificate certificateFromDb = findCertificateById(id);
        certificateFromDb.setName(updatedCertificate.getName());
        certificateFromDb.setDescription(updatedCertificate.getDescription());
        certificateFromDb.setPrice(updatedCertificate.getPrice());
        certificateFromDb.setDaysDuration(updatedCertificate.getDaysDuration());
        certificateFromDb.setCreateDate(updatedCertificate.getCreateDate());
        certificateFromDb.setLastUpdateDate(updatedCertificate.getLastUpdateDate());
    }




}
