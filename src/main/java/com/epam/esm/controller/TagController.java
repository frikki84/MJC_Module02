package com.epam.esm.controller;

import com.epam.esm.entity.Tag;
import com.epam.esm.exception.NoSuchResourceException;
import com.epam.esm.exception.TagAlreadyExistsException;
import com.epam.esm.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {
    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping()
    public List<Tag> findAllCertificates() {
        List<Tag> fullTagList = tagService.findAllTagList();

        if (fullTagList == null || fullTagList.isEmpty()) {
            throw new NoSuchResourceException("There are no tags in DataBase");
        }
        return fullTagList;
    }

    @GetMapping("/{name}")
    public Tag findTag(@PathVariable("name") String name) {
        Tag tag = tagService.findTag(name);

        if (tag == null) {
            throw  new NoSuchResourceException("There is no tag with name " + name);
        }
        return tag;
    }

    @PostMapping()
    @ResponseBody
    public void createNewTag(@RequestBody @Valid Tag tag) {
         Tag createdTag = tagService.addNewTag(tag);

         if (createdTag == null)
             throw new TagAlreadyExistsException("This tag " + createdTag.getNameTag() + " already exists in DataBase");
    }

    @DeleteMapping("/{id}")
    public void deleteCertificate(@PathVariable("id") int id) {
        tagService.deleteTag(id);

    }


}
