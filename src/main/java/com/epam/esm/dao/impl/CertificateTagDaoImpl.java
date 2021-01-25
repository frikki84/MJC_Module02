package com.epam.esm.dao.impl;

import com.epam.esm.dao.CertificateTagDao;
import com.epam.esm.entity.dto.CertificateWithTagFromDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class CertificateTagDaoImpl implements CertificateTagDao {
    public static final String SQL_QUERY_INSERT_CERTIFICATE_TAG_RELATION = "insert into gift_certificate_has_tag (gift_certicicate_id_gift_certicicate, tag_id_tag) values (?, ?) ";
    public static final String SQL_QUERY_FIND_ALL_CERTIFICATES_WITH_TAGS = "select gc.*, t.* from gift_certificate gc join gift_certificate_has_tag gct on gc.id=gct.gift_certicicate_id_gift_certicicate join tag t on t.id=gct.tag_id_tag order by gc.id;";
    public static final String DB_PROCEDURE_CALL = "call DescriptionNameSearch(?);";
    public static final String MAP_KEY_NAME_PROCEDURE = "#result-set-1";

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
    @Override
    public List<CertificateWithTagFromDb> findAllCertificatesWithTagsFromDb() {
        List<CertificateWithTagFromDb> resultList = template.query(
                SQL_QUERY_FIND_ALL_CERTIFICATES_WITH_TAGS,
                (rs, rowNum) ->
                        new CertificateWithTagFromDb(
                                rs.getLong(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getBigDecimal(4),
                                rs.getInt(5),
                                rs.getTimestamp(6).toLocalDateTime(),
                                rs.getTimestamp(7).toLocalDateTime(),
                                rs.getLong(8),
                                rs.getString(9)
                        )
        );
        return resultList;
    }

    @Override
    public List<CertificateWithTagFromDb> findAllCertificatesWithTagsByNameOrDescriptionPart(String namePart) {
        Map<String, Object> out = searchCertificatesWithTags(namePart);
        List<CertificateWithTagFromDb> certificateList = new ArrayList<>();
        List<Map<String, Object>> results = (List<Map<String, Object>>) out.get(MAP_KEY_NAME_PROCEDURE);

        results.forEach(c -> {
            CertificateWithTagFromDb ct = new CertificateWithTagFromDb();
            ct.setCertificateId((int) c.get("id"));
            ct.setCertificateName((String) c.get("name"));
            ct.setDescription((String) c.get("description"));
            ct.setPrice((BigDecimal) c.get("price"));
            ct.setDuration((Integer)c.get("duration"));
            ct.setCreateDate(((Timestamp) c.get("create_date")).toLocalDateTime());
            ct.setLastUpdateDate(((Timestamp)c.get("last_update_date")).toLocalDateTime());
            //ct.setTagId((long) c.get(8));
            ct.setTagName((String) c.get("nameTag"));
            certificateList.add(ct);
        });
         return certificateList;
    }


    private Map<String, Object> searchCertificatesWithTags(String namePart) {
        List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.NVARCHAR));
        return template.call(new CallableStatementCreator() {
            @Override
            public CallableStatement createCallableStatement(Connection con) throws SQLException {
                CallableStatement cs = con.prepareCall(DB_PROCEDURE_CALL);
                cs.setString(1, namePart);
                return cs;
            }
        }, parameters);
    }
}
