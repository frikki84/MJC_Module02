package com.epam.esm.service.serviceImpl;

import com.epam.esm.dao.TagDao;
import com.epam.esm.entity.Tag;
import com.epam.esm.entity.dto.TagDto;
import com.epam.esm.service.TagService;
import com.epam.esm.service.mapper.TagDtoMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TagServiceImpl implements TagService {
    private final TagDtoMapper tagDtoMapper;
    private final TagDao tagDao;

    public TagServiceImpl(TagDtoMapper tagDtoMapper, TagDao tagDao) {
        this.tagDtoMapper = tagDtoMapper;
        this.tagDao = tagDao;
    }

    @Override
    public List<Tag> findAllTagList() {
        List<Tag> tagList = tagDao.findAllTagList();
        return tagList;
    }

    @Override
    public Tag findTag(long id) {
        Tag tag = tagDao.findTag(id);
        return tag;
    }

    @Override
    public Tag findTag(String name) {
        Tag tag = tagDao.findTag(name);
        return  tag;
    }

    @Override
    public void deleteTag(long id) {
        tagDao.deleteTag(id);
    }

    @Override
    public Tag addNewTag(TagDto tagDto) {
        Tag tag = tagDtoMapper.changeTagDtoToTag(tagDto);
        Tag newTag = tagDao.addNewTag(tag);
        return newTag;
    }

    @Override
    public Tag addNewTag(Tag tag) {
        Tag newTag = tagDao.addNewTag(tag);
        return newTag;
    }


}
