package com.epam.esm.service;

import com.epam.esm.dao.CertificateDao;
import com.epam.esm.dao.TagDao;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.exception.CustomErrorCode;
import com.epam.esm.exception.NoSuchResourceException;
import com.epam.esm.service.mapper.CertificateDtoMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class CertificateServiceTest {
    @InjectMocks
    private CertificateService certificateService;

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
    void findCertificateByIdTest() {
        GiftCertificate expectedCertificate = new GiftCertificate(6, "Twist", "Twist Cource for 2 persons for a month", new BigDecimal(100), 40
                , LocalDateTime.of(2021, 01, 20, 13, 06, 22), LocalDateTime.of(2021, 01, 20, 13, 06, 22));
        Mockito.when(certificateDao.findCertificateById(6)).thenReturn(expectedCertificate);

        GiftCertificate certificate = certificateService.findCertificateById(6);
        Assertions.assertNotNull(certificate);
        Assertions.assertEquals(certificate, expectedCertificate);
    }

    @Test
    void findCertificateByIdException() {
        Mockito.when(certificateDao.findCertificateById(1000)).thenThrow(new NoSuchResourceException("No certificates", CustomErrorCode.CERTIFICATE));
        Throwable throwable = Assertions.assertThrows(NoSuchResourceException.class, () -> {
            certificateService.findCertificateById(1000);
        });
        Assertions.assertEquals(NoSuchResourceException.class, throwable.getClass());
    }

    @Test
    void createNewCertificateTest() {
        GiftCertificate newCertificate = new GiftCertificate("Twist", "Twist Cource for 2 persons for a month", new BigDecimal(100), 40);
        Mockito.when(certificateDao.createNewCertificate(newCertificate)).thenReturn(1);
        Integer number = certificateService.createNewCertificate(newCertificate);
        Assertions.assertNotNull(number);
        Assertions.assertEquals(1, number);
    }

    @Test
    void updateCertificateTest() {

        GiftCertificate dbCertificate = new GiftCertificate(10, "Twist", "Twist Cource for 2 persons for a month"
                , new BigDecimal(100), 40, LocalDateTime.of(2021, 01, 20, 13
                , 06, 22), LocalDateTime.of(2021, 01, 20, 13, 06, 22));

        GiftCertificate newCertificate = new GiftCertificate();
        newCertificate.setPrice(new BigDecimal(150));
        newCertificate.setDuration(50);

        Mockito.when(certificateDao.findCertificateById(10)).thenReturn(dbCertificate);
        Mockito.when(certificateDao.updateCertificate(dbCertificate, 10)).thenReturn(1);

        Integer number = certificateService.updateCertificate(newCertificate, 10);
        Assertions.assertNotNull(number);
        Assertions.assertEquals(certificateDao.updateCertificate(dbCertificate, 10), number);
    }

    @Test
    void updateCertificateNoSuchResourceExceptionTest() {
        GiftCertificate newCertificate = new GiftCertificate();
        newCertificate.setPrice(new BigDecimal(150));

        Mockito.when(certificateDao.findCertificateById(10)).thenThrow(new NoSuchResourceException("No id 10"
                , CustomErrorCode.CERTIFICATE));

        Throwable throwable = Assertions.assertThrows(NoSuchResourceException.class, () -> {
            certificateService.updateCertificate(newCertificate, 10);
        });
        Assertions.assertEquals(NoSuchResourceException.class, throwable.getClass());
    }

    @Test
    void deleteCertificateTest() {
        Mockito.when(certificateDao.deleteCertificate(10)).thenReturn(1);
        Integer number = certificateService.deleteCertificate(10);
        Assertions.assertNotNull(number);
        Assertions.assertEquals(1, number);
    }

    @Test
    void deleteCertificateNoSuchResourceExceptionTest() {
        long id = 100;
        Mockito.when(certificateDao.findCertificateById(id)).thenThrow(new NoSuchResourceException("No id " + id, CustomErrorCode.CERTIFICATE));
        Throwable throwable = Assertions.assertThrows(NoSuchResourceException.class, () -> {
            certificateService.deleteCertificate(id);
        });
        Assertions.assertEquals(NoSuchResourceException.class, throwable.getClass());
    }


    @Test
    void findCertificatesByTagName() {
//        String tagName = "spa";
//
//        List<GiftCertificate> certificateList = new ArrayList<>();
//        certificateList.add(new GiftCertificate(1, "Spa-comlex", "Spa-complex for 1 person for 3 hours"
//                , new BigDecimal(150), 40, LocalDateTime.of(2021, 01, 20, 13
//                , 06, 22), LocalDateTime.of(2021, 01, 20, 13, 06, 22)));
//        certificateList.add(new GiftCertificate(2, "Spa-comlex", "Spa-complex for 2 persons for 3 hours"
//                , new BigDecimal(250), 40, LocalDateTime.of(2021, 01, 20, 13
//                , 06, 22), LocalDateTime.of(2021, 01, 20, 13, 06, 22)));
//        certificateList.add(new GiftCertificate(3, "Spa-comlex", "Spa-complex for 4 persons for 3 hours"
//                , new BigDecimal(350), 40, LocalDateTime.of(2021, 01, 20, 13
//                , 06, 22), LocalDateTime.of(2021, 01, 20, 13, 06, 22)));
//
//        List<Tag> tagList = Arrays.asList(new Tag(1, "spa"), new Tag(2, "relax"), new Tag(3, "group"));
//
//        List<CertificateDto> dtoList = new ArrayList<>();
//        certificateList.stream().forEach(
//                certificate ->
//                dtoList.add(new CertificateDto(certificate, tagList))
//        );
//
//        System.out.println("dto\n" + dtoList);
//
//        Mockito.when(certificateMapper.changeCertificateToDto(certificateList.get(0), tagList)).thenReturn(dtoList.get(0));
//        Mockito.when(certificateMapper.changeCertificateToDto(certificateList.get(1), tagList)).thenReturn(dtoList.get(1));
//        Mockito.when(certificateMapper.changeCertificateToDto(certificateList.get(2), tagList)).thenReturn(dtoList.get(2));
//
//        List<CertificateDto> resultList = certificateService.findCertificatesByTagName(tagName);
//        System.out.println(resultList);
//        Assertions.assertEquals(3, resultList.size());
    }


    @Test
    void sortAllCertificatesByNameAsc() {

    }


    @Test
    void findAllCertificatesWithTagsByNameOrDescriptionPart() {
    }
}