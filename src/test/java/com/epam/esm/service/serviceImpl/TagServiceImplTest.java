package com.epam.esm.service.serviceImpl;

import com.epam.esm.dao.TagDao;
import com.epam.esm.dao.impl.TagDaoImpl;
import com.epam.esm.entity.Tag;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import static org.junit.jupiter.api.Assertions.*;

class TagServiceImplTest {
    private EmbeddedDatabase embeddedDatabase;

    private JdbcTemplate jdbcTemplate;

    private TagDao tagDao;

    @BeforeEach
    public void setUp() {
        // Создадим базу данных для тестирования
        embeddedDatabase = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)// Используем базу H2
                .addScript("/db/tag.sql")
                .build();

        // Создадим JdbcTemplate
        jdbcTemplate = new JdbcTemplate(embeddedDatabase);

        // Создадим TagDao
        tagDao = new TagDaoImpl(jdbcTemplate);
    }

    @Test
    public  void findAllTagList() {
        Assert.assertNotNull(tagDao.findAllTagList());
        assertEquals(4, tagDao.findAllTagList().size());
    }

    @Test
    public void findTag() {
        Assert.assertNotNull(tagDao.findTag("spa"));
        Assert.assertNull(tagDao.findTag("lalala"));
    }

    @Test
    public void findTagID() {
        Assert.assertNotNull(tagDao.findTag(1));
        Assert.assertNull(tagDao.findTag(130));
    }

    @Test
    public void addNewTag() {
        Tag tag = tagDao.addNewTag(new Tag(5,"swimming"));
        Assert.assertNotNull(tag);
        Assert.assertNotNull(tag.getId());
        Assert.assertEquals(tag, new Tag(5, "swimming"));


    }



    @AfterEach
    public void endTest() {
        embeddedDatabase.shutdown();
    }


}