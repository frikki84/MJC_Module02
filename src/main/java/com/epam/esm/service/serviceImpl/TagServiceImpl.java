package com.epam.esm.service.serviceImpl;

import com.epam.esm.dao.TagDao;
import com.epam.esm.entity.Tag;
import com.epam.esm.service.TagService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TagServiceImpl implements TagService {
    private final TagDao tagDao;

    public TagServiceImpl(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    @Override
    public List<Tag> findAllTagList() {
        List<Tag> tagList = tagDao.findAllTagList();
        return tagList;
    }

    @Override
    public Tag findTagById(int id) {
        Tag tag = tagDao.findTagById(id);
        return tag;
    }

    @Override
    public Tag findTagByName(String name) {
        Tag tag = tagDao.findTagByName(name);
        return  tag;
    }

    @Override
    public void deleteTag(int id) {
        tagDao.deleteTag(id);
    }

    @Override
    public void addNewTag(Tag tag) {

        tagDao.addNewTag(tag);
    }


}
