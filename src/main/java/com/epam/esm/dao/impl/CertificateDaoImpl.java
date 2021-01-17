package com.epam.esm.dao.impl;

import com.epam.esm.dao.CertificateDao;
import com.epam.esm.entity.GiftCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component

public class CertificateDaoImpl implements CertificateDao {
    public static final String SQL_QUERY_READ_CERTIFICATES_LIST = "Select * from gift_certicicate;";
    public static final String SQL_QUERY_READ_ONE_CERTIFICATE = "select * from gift_certicicate where id = ?";
    public static final String SQL_QUERY_INSERT_CERTIFICATE = "insert into gift_certicicate (name, description, price" +
            ", duration, create_date, last_update_date) values (?, ?, ?, ?, ?, ?)";
    public static final String SQL_QUERY_UPDATE_CERTIFICATE = "update gift_certicicate set name=?, description=?" +
            ", price=?, duration=?, create_date=?, last_update_date=? where id = ?;";
    public static final String SQL_QUERY_DELETE_CERTIFICATE = "delete from gift_certicicate where id = ?;";
    public static final String SQL_QUERY_FIND_CERTIFICATE_ID = "select id from gift_certicicate where create_date = ? and name like ?";


    private final JdbcTemplate template;

    @Autowired
    public CertificateDaoImpl(JdbcTemplate template) {
        this.template = template;
    }

    public List<GiftCertificate> findAllCertificates() {
        List<GiftCertificate> certificateList = template.query(SQL_QUERY_READ_CERTIFICATES_LIST
                , new BeanPropertyRowMapper<>(GiftCertificate.class));
        return certificateList;
    }


    public GiftCertificate findCertificateById(int id) {
        GiftCertificate certificate = template.query(SQL_QUERY_READ_ONE_CERTIFICATE
                , new Object[]{id}, new BeanPropertyRowMapper<>(GiftCertificate.class))
                .stream().findAny().orElse(null);

        return certificate;
    }

    public int createNewCertificate(GiftCertificate certificate) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        int id = template.update(SQL_QUERY_INSERT_CERTIFICATE, certificate.getName(), certificate.getDescription()
                , certificate.getPrice(), certificate.getDaysDuration(), certificate.getCreateDate()
                , certificate.getLastUpdateDate());

        System.out.println("dao createNewCertificate " + id);

        return id;
    }

    public void updateCertificate(GiftCertificate updatedCertificate, int id) {
        template.update(SQL_QUERY_UPDATE_CERTIFICATE, updatedCertificate.getName(), updatedCertificate.getDescription()
                , updatedCertificate.getPrice(), updatedCertificate.getDaysDuration(), updatedCertificate.getCreateDate()
                , updatedCertificate.getLastUpdateDate(), id);

    }

    public void deleteCertificate(int id) {
        template.update(SQL_QUERY_DELETE_CERTIFICATE, id);

    }

    @Override
    public int findcertificateIdByCertificateInformation(GiftCertificate certificate) {
        int id = template.query(SQL_QUERY_FIND_CERTIFICATE_ID
                , new Object[]{certificate.getCreateDate(), certificate.getName()}, new BeanPropertyRowMapper<>(GiftCertificate.class))
                .stream().findAny().orElse(null).getId();

        return id;
    }


}
