package com.epam.esm.dao.impl;

import com.epam.esm.dao.TagDao;
import com.epam.esm.dao.impl.TagDaoImpl;
import com.epam.esm.entity.Tag;
import com.epam.esm.exception.TagAlreadyExistsException;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import static org.junit.jupiter.api.Assertions.*;

class TagDaoImplTest {
    private EmbeddedDatabase embeddedDatabase;

    private JdbcTemplate jdbcTemplate;

    private TagDao tagDao;

    @BeforeEach
    public void setUp() {
        // Создадим базу данных для тестирования
        embeddedDatabase = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("/db/mydb.sql")
                .build();

        // Создадим JdbcTemplate
        jdbcTemplate = new JdbcTemplate(embeddedDatabase);

        // Создадим TagDao
        tagDao = new TagDaoImpl(jdbcTemplate);
    }

    @Test
    public  void findAllTagList() {
        Assertions.assertNotNull(tagDao.findAllTagList());
        Assertions.assertEquals(6, tagDao.findAllTagList().size());
    }

    @Test
    public void findTag() {
        Assertions.assertNotNull(tagDao.findTag("spa"));
        Assertions.assertNull(tagDao.findTag("lalala"));
    }

    @Test
    public void findTagID() {
        Assertions.assertNotNull(tagDao.findTag(1));
        Assertions.assertNull(tagDao.findTag(130));
    }

    @Test
    public void addNewTag() {
        Tag tag = tagDao.addNewTag(new Tag(7,"swimming"));
        Assertions.assertNotNull(tag);
        Assertions.assertNotNull(tag.getId());
        Assertions.assertEquals(tag, new Tag(7, "swimming"));
//        Assertions.assertThrows(RuntimeException.class, () -> {
//            tagDao.addNewTag(new Tag("spa"));
//        });
    }



    @AfterEach
    public void endTest() {
        embeddedDatabase.shutdown();
    }

    }
