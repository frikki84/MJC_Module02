package com.epam.esm.controller;

import com.epam.esm.entity.GiftCertificateDTO;
import com.epam.esm.entity.Tag;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestingMain {
    public static void main(String[] args) {
        List<Tag> list = new ArrayList<>();
        list.add(new Tag("sport"));
        list.add(new Tag("comfort"));

        GiftCertificateDTO dto = new GiftCertificateDTO("my cert", "My dreams certificate", new BigDecimal("45"), 70, list);

        System.out.println("My dto: " + dto);



    }
}

