package com.epam.esm.service.entitydtomapper.impl;

import com.epam.esm.dao.CertificateTagDao;
import com.epam.esm.dao.impl.CertificateTagDaoImpl;
import com.epam.esm.entity.CertificateWithTagFromDb;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.GiftCertificateDTO;
import com.epam.esm.entity.Tag;
import com.epam.esm.service.entitydtomapper.CertificateDtoMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CertificateDtoMapperImpl implements CertificateDtoMapper {

    @Override
    public GiftCertificate changeDtoToCertificate(GiftCertificateDTO dto) {
        GiftCertificate certificate = new GiftCertificate(dto.getName(), dto.getDescription(), dto.getPrice()
                , dto.getDuration());
        return certificate;
    }

    @Override
    public GiftCertificateDTO changeCertificateToDto(GiftCertificate certificate, List<Tag> tagList) {
        return null;
    }

    @Override
    public List<GiftCertificateDTO> createDTOList(List<CertificateWithTagFromDb> list) {
        List<GiftCertificateDTO> dtoList = new ArrayList<>();

        GiftCertificateDTO certificateDTO = new GiftCertificateDTO(list.get(0).getCertificateId(), list.get(0).getCertificateName(), list.get(0).getDescription(), list.get(0).getPrice(), list.get(0).getDuration(),  list.get(0).getCreateDate(), list.get(0).getLastUpdateDate());
        Tag tag = new Tag(list.get(0).getTagId(), list.get(0).getTagName());
        certificateDTO.getTagList().add(tag);
        dtoList.add(certificateDTO);
        list.remove(0);

        int dtoIndex = 0;
        for (CertificateWithTagFromDb item : list) {
            if (item.getCertificateId() == dtoList.get(dtoIndex).getId()) {
                Tag innerTeg = new Tag(item.getTagId(), item.getTagName());
                dtoList.get(dtoIndex).getTagList().add(innerTeg);
            } else {
                dtoIndex ++;
                GiftCertificateDTO certificate = new GiftCertificateDTO(item.getCertificateId(), item.getCertificateName(), item.getDescription(), item.getPrice(), item.getDuration(), item.getCreateDate(), item.getLastUpdateDate());
                Tag newTag = new Tag(item.getTagId(), item.getTagName());
                certificate.getTagList().add(newTag);
                dtoList.add(certificate);
            }

        }

        return dtoList;
    }


}
