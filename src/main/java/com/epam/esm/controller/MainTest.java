package com.epam.esm.controller;

import com.epam.esm.dao.CertificateDao;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.service.CertificateService;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
       CertificateService controller = new CertificateService(new CertificateDao(new JdbcTemplate()));
       GiftCertificate certificate = new GiftCertificate("Dinner", "Dinner", new BigDecimal("50"), 50, null, null);
        controller.createNewCertificate(certificate);
        System.out.println("ok");

    }
}

