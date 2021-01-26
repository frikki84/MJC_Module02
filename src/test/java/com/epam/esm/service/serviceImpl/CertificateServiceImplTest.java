package com.epam.esm.service.serviceImpl;

import com.epam.esm.dao.CertificateDao;
import com.epam.esm.dao.CertificateTagDao;
import com.epam.esm.dao.TagDao;
import com.epam.esm.service.CertificateService;
import com.epam.esm.service.mapper.CertificateDtoMapper;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

class CertificateServiceImplTest {

    private final CertificateDao certificateDao;
    private final CertificateTagDao certificateTagDao;
    private final TagDao tagDao;
    private final CertificateDtoMapper certificateMapper;

    private EmbeddedDatabase embeddedDatabase;
    private JdbcTemplate jdbcTemplate;
    private CertificateService certificateService;


    @Autowired
    CertificateServiceImplTest(CertificateDao certificateDao, CertificateTagDao certificateTagDao, TagDao tagDao, CertificateDtoMapper certificateMapper) {
        this.certificateDao = certificateDao;
        this.certificateTagDao = certificateTagDao;
        this.tagDao = tagDao;
        this.certificateMapper = certificateMapper;
    }


    @BeforeEach
  public void setUp() {
        embeddedDatabase = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)// Используем базу H2
                .addScript("/db/mydb.sql")
                .build();
        jdbcTemplate = new JdbcTemplate(embeddedDatabase);

   }


    @Test
    void findAllCertificates() {


    }

    @Test
    void findCertificateById() {
         Assert.assertNotNull(certificateService.findCertificateById(1));
         Assert.assertNull(certificateService.findCertificateById(150));
    }

    @Test
    void createNewCertificate() {
    }

    @Test
    void updateCertificate() {
    }

    @Test
    void deleteCertificate() {
    }

    @Test
    void findCertificatesWithTags() {
    }

    @Test
    void findCertificatesByTagName() {

    }

    @Test
    void sortAllCertificatesByNameAsc() {
    }

    @Test
    void sortAllCertificatesByNameDesc() {
    }

    @Test
    void sortAllCertificatesByNameTime() {
    }

    @Test
    void findAllCertificatesWithTagsByNameOrDescriptionPart() {
    }

    @AfterEach
    public void endTest() {
        embeddedDatabase.shutdown();
    }
}