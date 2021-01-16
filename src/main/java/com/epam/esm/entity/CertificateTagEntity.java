package com.epam.esm.entity;

import java.util.Objects;

public class CertificateTagEntity {
    private int certificateId;
    private int tagId;

    public CertificateTagEntity() {
    }

    public CertificateTagEntity(int certificateId, int tagId) {
        this.certificateId = certificateId;
        this.tagId = tagId;
    }

    public int getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(int certificateId) {
        this.certificateId = certificateId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CertificateTagEntity that = (CertificateTagEntity) o;
        return certificateId == that.certificateId && tagId == that.tagId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(certificateId, tagId);
    }

    @Override
    public String toString() {
        return "CertificateTagEntity{" +
                "certificateId=" + certificateId +
                ", tagId=" + tagId +
                '}';
    }
}
