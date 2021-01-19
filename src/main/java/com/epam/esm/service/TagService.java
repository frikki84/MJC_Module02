package com.epam.esm.service;

import com.epam.esm.entity.Tag;
import org.springframework.stereotype.Component;

import java.util.List;


public interface TagService {
    public List<Tag> findAllTagList();
    public Tag findTag(int id);
    public Tag findTag(String name);
    public long addNewTag(Tag tag);
    public void deleteTag(int id);

}
