package com.epam.esm.entity;

import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;


@ResponseBody
public class Tag {
    private long id;

    @NotBlank(message = "The field can't be empty")
    @Size(min = 3, max = 32, message = "The certificate name could be between 3 and 20 symbols")
    private String nameTag;

    public Tag() {
    }

    public Tag(long id, @NotBlank(message = "The field can't be empty") @Size(min = 3, max = 32, message = "The certificate name could be between 3 and 20 symbols") String nameTag) {
        this.id = id;
        this.nameTag = nameTag;
    }

    public Tag(String name) {
        this.nameTag = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameTag() {
        return nameTag;
    }

    public void setNameTag(String nameTag) {
        this.nameTag = nameTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return id == tag.id && Objects.equals(nameTag, tag.nameTag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameTag);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + nameTag + '\'' +
                '}';
    }
}
