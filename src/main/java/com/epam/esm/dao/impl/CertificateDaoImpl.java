package com.epam.esm.dao.impl;

import com.epam.esm.dao.CertificateDao;
import com.epam.esm.entity.GiftCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;


import java.io.Serializable;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

@Component

public class CertificateDaoImpl implements CertificateDao {
    public static final String SQL_QUERY_READ_CERTIFICATES_LIST = "Select * from gift_certicicate;";
    public static final String SQL_QUERY_READ_ONE_CERTIFICATE = "select * from gift_certicicate where id = ?";
    public static final String SQL_QUERY_INSERT_CERTIFICATE = "insert into gift_certicicate (name, description, price" +
            ", duration, create_date, last_update_date) values (?, ?, ?, ?, ?, ?);";
    public static final String SQL_QUERY_UPDATE_CERTIFICATE = "update gift_certicicate set name=?, description=?" +
            ", price=?, duration=?, create_date=?, last_update_date=? where id = ?;";
    public static final String SQL_QUERY_DELETE_CERTIFICATE = "delete from gift_certicicate where id = ?;";
    public static final String SQL_QUERY_FIND_CERTIFICATE_ID = "select id from gift_certicicate where create_date = ? and name like ?";


    private final JdbcTemplate template;


//
//    @Autowired
//    public CertificateDaoImpl(NamedParameterJdbcTemplate template) {
//        this.template = template;
//    }

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

    public long createNewCertificate(GiftCertificate certificate) {
       KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        template.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(SQL_QUERY_INSERT_CERTIFICATE, Statement.RETURN_GENERATED_KEYS);


            ps.setString(1, certificate.getName());
            ps.setString(2, certificate.getDescription());
            ps.setBigDecimal(3, certificate.getPrice());
            ps.setInt(4, certificate.getDuration());
            ps.setTimestamp(5, Timestamp.valueOf(certificate.getCreateDate()));
            ps.setTimestamp(6, Timestamp.valueOf(certificate.getLastUpdateDate()));
            return ps;

        }, generatedKeyHolder);

        long key = ((BigInteger)generatedKeyHolder.getKey()).longValue();

        return key;
    }

    public void updateCertificate(GiftCertificate updatedCertificate, int id) {
//        template.update(SQL_QUERY_UPDATE_CERTIFICATE, updatedCertificate.getName(), updatedCertificate.getDescription()
//                , updatedCertificate.getPrice(), updatedCertificate.getDaysDuration(), updatedCertificate.getCreateDate()
//                , updatedCertificate.getLastUpdateDate(), id);

    }

    public void deleteCertificate(int id) {
//        template.update(SQL_QUERY_DELETE_CERTIFICATE, id);

    }

    @Override
    public int findcertificateIdByCertificateInformation(GiftCertificate certificate) {
//        int id = template.query(SQL_QUERY_FIND_CERTIFICATE_ID
//                , new Object[]{certificate.getCreateDate(), certificate.getName()}, new BeanPropertyRowMapper<>(GiftCertificate.class))
//                .stream().findAny().orElse(null).getId();
//
        return 0;
    }


}
