package com.epam.esm.service.entitydtomapper;

import com.epam.esm.entity.dto.GiftCertificateDto;
import com.epam.esm.entity.Tag;
import com.epam.esm.entity.dto.TagDto;

import java.util.List;


public interface TagDtoMapper {
    public Tag changeTagDtoToTag(TagDto tagDto);
    public TagDto changeTagTpTagDto(Tag tag);
    public List<Tag> changeCertificateDtoToTagList(GiftCertificateDto dto);


}
