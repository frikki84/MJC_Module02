package com.epam.esm.service;

import com.epam.esm.entity.Tag;
import com.epam.esm.entity.dto.TagDto;
import org.springframework.stereotype.Component;

import java.util.List;


public interface TagService {
    public List<Tag> findAllTagList();
    public Tag findTag(long id);
    public Tag findTag(String name);
    public Tag addNewTag(TagDto tag);
    public Tag addNewTag(Tag tag);
    public void deleteTag(long id);

}
