package com.epam.esm.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class GiftCertificate {
    private int id;
    private String name;
    private BigDecimal price;
    private int daysDuration;
    private SimpleDateFormat createDate;
    private SimpleDateFormat lastUpdateDate;

    public GiftCertificate() {
    }

    public GiftCertificate(String name, BigDecimal price, int daysDuration, SimpleDateFormat createDate, SimpleDateFormat lastUpdateDate) {
        this.name = name;
        this.price = price;
        this.daysDuration = daysDuration;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public GiftCertificate(int id, String name, BigDecimal price, int daysDuration, SimpleDateFormat createDate
            , SimpleDateFormat lastUpdateDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.daysDuration = daysDuration;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getDaysDuration() {
        return daysDuration;
    }

    public void setDaysDuration(int daysDuration) {
        this.daysDuration = daysDuration;
    }

    public SimpleDateFormat getCreateDate() {
        return createDate;
    }

    public void setCreateDate(SimpleDateFormat createDate) {
        this.createDate = createDate;
    }

    public SimpleDateFormat getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(SimpleDateFormat lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiftCertificate that = (GiftCertificate) o;
        return id == that.id && daysDuration == that.daysDuration && Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(createDate, that.createDate) && Objects.equals(lastUpdateDate, that.lastUpdateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, daysDuration, createDate, lastUpdateDate);
    }

    @Override
    public String toString() {
        return "GiftCertificate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", daysDuration=" + daysDuration +
                ", createDate=" + createDate +
                ", lastupdateDate=" + lastUpdateDate +
                '}';
    }
}
