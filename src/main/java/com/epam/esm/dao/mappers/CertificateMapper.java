package com.epam.esm.dao.mappers;

import com.epam.esm.entity.GiftCertificate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Component
public class CertificateMapper implements RowMapper<GiftCertificate> {
    @Override
    public GiftCertificate mapRow(ResultSet rs, int rowNum) throws SQLException {
        GiftCertificate certificate = new GiftCertificate();

        certificate.setId(rs.getInt("id_gift_certicicate"));
        certificate.setName(rs.getString("name"));
        certificate.setPrice(rs.getBigDecimal("price"));
        certificate.setDescription(rs.getString("description"));
        certificate.setDaysDuration(rs.getInt("duration"));
        certificate.setCreateDate(rs.getTimestamp("create_date").toLocalDateTime());
        certificate.setCreateDate(rs.getTimestamp("last_update_date").toLocalDateTime());

        return certificate;
    }
}
