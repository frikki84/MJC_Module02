package com.epam.esm.service;

import com.epam.esm.entity.Tag;
import org.springframework.stereotype.Component;

import java.util.List;


public interface TagService {
    public List<Tag> findAllTagList();
    public Tag findTagById(int id);
    public void addNewTag(Tag tag);
    public void deleteTag(int id);

}
