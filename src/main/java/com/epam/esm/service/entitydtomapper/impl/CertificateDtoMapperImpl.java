package com.epam.esm.service.entitydtomapper.impl;

import com.epam.esm.entity.dto.CertificateWithTagFromDb;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.dto.GiftCertificateDto;
import com.epam.esm.entity.Tag;
import com.epam.esm.service.entitydtomapper.CertificateDtoMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CertificateDtoMapperImpl implements CertificateDtoMapper {

    @Override
    public GiftCertificate changeDtoToCertificate(GiftCertificateDto dto) {
        GiftCertificate certificate = new GiftCertificate(dto.getName(), dto.getDescription(), dto.getPrice()
                , dto.getDuration());
        return certificate;
    }

    @Override
    public GiftCertificateDto changeCertificateToDto(GiftCertificate certificate, List<Tag> tagList) {
        GiftCertificateDto dto = new GiftCertificateDto(certificate, tagList);
        return dto;
    }

//    @Override
//    public List<GiftCertificateDto> createDTOList(List<CertificateWithTagFromDb> list) {
//        List<GiftCertificateDto> dtoList = new ArrayList<>();
//
//        GiftCertificateDto certificateDTO = new GiftCertificateDto(list.get(0).getCertificateId(), list.get(0).getCertificateName(), list.get(0).getDescription(), list.get(0).getPrice(), list.get(0).getDuration(),  list.get(0).getCreateDate(), list.get(0).getLastUpdateDate());
//        Tag tag = new Tag(list.get(0).getTagId(), list.get(0).getTagName());
//        certificateDTO.getTagList().add(tag);
//        dtoList.add(certificateDTO);
//        list.remove(0);
//
//        int dtoIndex = 0;
//        for (CertificateWithTagFromDb item : list) {
//            if (item.getCertificateId() == dtoList.get(dtoIndex).getId()) {
//                Tag innerTeg = new Tag(item.getTagId(), item.getTagName());
//                dtoList.get(dtoIndex).getTagList().add(innerTeg);
//            } else {
//                dtoIndex ++;
//                GiftCertificateDto certificate = new GiftCertificateDto(item.getCertificateId(), item.getCertificateName(), item.getDescription(), item.getPrice(), item.getDuration(), item.getCreateDate(), item.getLastUpdateDate());
//                Tag newTag = new Tag(item.getTagId(), item.getTagName());
//                certificate.getTagList().add(newTag);
//                dtoList.add(certificate);
//            }
//
//        }
//
//        return dtoList;
//    }


}
