package com.epam.esm.controller;

import com.epam.esm.entity.Tag;
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
        System.out.println("Tag Controller get");
        List<Tag> fullTagList = tagService.findAllTagList();
        return fullTagList;
    }

//    @GetMapping("/{id}")
//    public Tag findTag(@PathVariable("id") int id) {
//        Tag tag = tagService.findTag(id);
//        return tag;
//    }

    @GetMapping("/{name}")
    public Tag findTag(@PathVariable("name") String name) {
        Tag tag = tagService.findTag(name);
        return tag;
    }

    @PostMapping()
    @ResponseBody
    public void createNewTag(@RequestBody @Valid Tag tag) {
        System.out.println("Controller tag post");

        tagService.addNewTag(tag);
    }

    @DeleteMapping("/{id}")
    public void deleteCertificate(@PathVariable("id")int id) {
        tagService.deleteTag(id);

    }


}
