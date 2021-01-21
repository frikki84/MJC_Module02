package com.epam.esm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@ResponseBody
public class GiftCertificateDTO {
    private long id;

    @NotBlank(message = "The field can't be empty")
    @Size(min = 3, max = 32, message = "The certificate name could be between 3 and 20 symbols")
    private String name;

    @NotEmpty(message = "Please, write the certificate description")
    @Size(min = 5, max = 128, message = "Description could be between 5 and 100 symbols")
    private String description;

    @DecimalMin(value = "0", message = "Enter certificate price")
    private BigDecimal price;

    @DecimalMin(value = "1", message = "Enter certificate duration more than 1 day")
    private int duration;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime createDate;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime lastUpdateDate;

    List<Tag> tagList = new ArrayList<>();

    public GiftCertificateDTO() {
    }

    public GiftCertificateDTO(@NotBlank(message = "The field can't be empty") @Size(min = 3, max = 20, message = "The certificate name could be between 3 and 20 symbols") String name, @NotEmpty(message = "Please, write the certificate description") @Size(min = 5, max = 100, message = "Description could be between 5 and 100 symbols") String description, @DecimalMin(value = "0", message = "Enter certificate price") BigDecimal price, @DecimalMin(value = "1", message = "Enter certificate duration more than 1 day") int duration) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
    }

    public GiftCertificateDTO(@NotBlank(message = "The field can't be empty") @Size(min = 3, max = 20, message = "The certificate name could be between 3 and 20 symbols") String name, @NotEmpty(message = "Please, write the certificate description") @Size(min = 5, max = 100, message = "Description could be between 5 and 100 symbols") String description, @DecimalMin(value = "0", message = "Enter certificate price") BigDecimal price, @DecimalMin(value = "1", message = "Enter certificate duration more than 1 day") int duration, List<Tag> tagList) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.tagList = tagList;
    }

    public GiftCertificateDTO(long id, @NotBlank(message = "The field can't be empty") @Size(min = 3, max = 32, message = "The certificate name could be between 3 and 20 symbols") String name, @NotEmpty(message = "Please, write the certificate description") @Size(min = 5, max = 128, message = "Description could be between 5 and 100 symbols") String description, @DecimalMin(value = "0", message = "Enter certificate price") BigDecimal price, @DecimalMin(value = "1", message = "Enter certificate duration more than 1 day") int duration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
    }

    public GiftCertificateDTO(long id, @NotBlank(message = "The field can't be empty") @Size(min = 3, max = 32, message = "The certificate name could be between 3 and 20 symbols") String name, @NotEmpty(message = "Please, write the certificate description") @Size(min = 5, max = 128, message = "Description could be between 5 and 100 symbols") String description, @DecimalMin(value = "0", message = "Enter certificate price") BigDecimal price, @DecimalMin(value = "1", message = "Enter certificate duration more than 1 day") int duration, LocalDateTime createDate, LocalDateTime lastUpdateDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiftCertificateDTO that = (GiftCertificateDTO) o;
        return id == that.id && duration == that.duration && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(price, that.price) && Objects.equals(createDate, that.createDate) && Objects.equals(lastUpdateDate, that.lastUpdateDate) && Objects.equals(tagList, that.tagList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, duration, createDate, lastUpdateDate, tagList);
    }

    @Override
    public String toString() {
        return "GiftCertificateDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", duration=" + duration +
                ", createDate=" + createDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", tagList=" + tagList +
                '}';
    }
}
