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
    private String name;

    public Tag() {
    }

    public Tag(long id, @NotBlank(message = "The field can't be empty") @Size(min = 3, max = 32, message = "The certificate name could be between 3 and 20 symbols") String name) {
        this.id = id;
        this.name = name;
    }

    public Tag(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return id == tag.id && Objects.equals(name, tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
