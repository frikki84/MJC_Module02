package com.epam.esm.dao.impl;

import com.epam.esm.dao.CertificateTagDao;
import com.epam.esm.entity.dto.CertificateWithTagFromDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.cert.Certificate;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class CertificateTagDaoImpl implements CertificateTagDao {
    public static final String SQL_QUERY_INSERT_CERTIFICATE_TAG_RELATION = "insert into gift_certificate_has_tag (gift_certicicate_id_gift_certicicate, tag_id_tag) values (?, ?) ";


    private final JdbcTemplate template;

    @Autowired
    public CertificateTagDaoImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public long createNewCertificateTagRelation(long certificateId, long tagId) {
        long updatedField = template.update(SQL_QUERY_INSERT_CERTIFICATE_TAG_RELATION, certificateId, tagId);
        return  updatedField;

    }

}
