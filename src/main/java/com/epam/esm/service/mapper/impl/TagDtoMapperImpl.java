package com.epam.esm.service.entitydtomapper.impl;

import com.epam.esm.entity.dto.CertificateDto;
import com.epam.esm.entity.Tag;
import com.epam.esm.entity.dto.TagDto;
import com.epam.esm.service.entitydtomapper.TagDtoMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TagDtoMapperImpl implements TagDtoMapper {
    @Override
    public Tag changeTagDtoToTag(TagDto tagDto) {
        Tag tag = new Tag(tagDto.getIdTag(), tagDto.getNameTag());
        return tag;
    }

    @Override
    public TagDto changeTagTpTagDto(Tag tag) {
        TagDto tagDto = new TagDto(tag.getId(), tag.getNameTag());
        return tagDto;
    }

    @Override
    public List<Tag> changeCertificateDtoToTagList(CertificateDto dto) {
        List<Tag> tagList = dto.getTagList();
        return tagList;

    }
}
