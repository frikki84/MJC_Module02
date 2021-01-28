package com.epam.esm.service.serviceImpl;

import com.epam.esm.dao.CertificateDao;
import com.epam.esm.dao.TagDao;
import com.epam.esm.dao.impl.CertificateDaoImpl;
import com.epam.esm.dao.impl.TagDaoImpl;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.service.CertificateService;
import com.epam.esm.service.mapper.CertificateDtoMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class CertificateServiceImplTest {
    @InjectMocks
    private CertificateServiceImpl certificateService;

    @Mock
    private CertificateDao certificateDao;
    @Mock
    private TagDao tagDao;
    @Mock
    private CertificateDtoMapper certificateMapper;

    @Test
    void findAllCertificatesSuccess() {
        List<GiftCertificate> list = new ArrayList<>();
        list.add(new GiftCertificate("Spa-comlex", "Spa-complex for 1 person for 3 hours", new BigDecimal(150), 40));
        list.add(new GiftCertificate("Spa-comlex", "Spa-complex for 2 persons for 3 hours", new BigDecimal(250), 40));
        list.add(new GiftCertificate("Spa-comlex", "Spa-complex for 4 persons for 3 hours", new BigDecimal(350), 40));

        Mockito.when(certificateDao.findAllCertificates()).thenReturn(list);
        List<GiftCertificate> certificates = certificateService.findAllCertificates();
        Assertions.assertNotNull(certificates);
        Assertions.assertEquals(3, certificates.size());
    }

    @Test
    void findCertificateById() {
        GiftCertificate expectedCertificate = new GiftCertificate(6, "Twist", "Twist Cource for 2 persons for a month", new BigDecimal(100), 40
                , LocalDateTime.of(2021, 01, 20, 13, 06, 22), LocalDateTime.of(2021, 01, 20, 13, 06, 22));
        Mockito.when(certificateDao.findCertificateById(6)).thenReturn(expectedCertificate);

        GiftCertificate certificate = certificateService.findCertificateById(6);
        Assertions.assertNotNull(certificate);
        Assertions.assertEquals(certificate, expectedCertificate);
    }

    @Test
    void findCertificateByIdException() {
        Mockito.when(certificateDao.findCertificateById(1000)).thenThrow(new NoSuchFieldException("No certificates"));
        GiftCertificate certificate = certificateService.findCertificateById(1000);
        Assertions.assertNotNull(certificate);
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
}