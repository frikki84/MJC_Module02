package com.epam.esm.dao.impl;

import com.epam.esm.dao.TagDao;
import com.epam.esm.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Component
public class TagDaoImpl implements TagDao {
    public static final String SQL_QUERY_READ_TAG_LIST = "Select * from tag;";
    public static final String SQL_QUERY_READ_ONE_TAG_BY_ID = "select * from tag where id = ?;";
    public static final String SQL_QUERY_READ_ONE_TAG_BY_NAME = "select * from tag where name like ?;";
    public static final String SQL_QUERY_INSERT_TAG = "insert into tag (name) values (?);";
    public static final String SQL_QUERY_DELETE_TAG = "delete from tag where id = ?;";


    private final JdbcTemplate template;

    @Autowired
    public TagDaoImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Tag> findAllTagList() {
        List<Tag> tagList = template.query(SQL_QUERY_READ_TAG_LIST
                , new BeanPropertyRowMapper<>(Tag.class));
        return  tagList;
    }

    @Override
    public Tag findTag(long id) {
        Tag tag = template.query(SQL_QUERY_READ_ONE_TAG_BY_ID
                , new Object[]{id}, new BeanPropertyRowMapper<>(Tag.class))
                .stream().findAny().orElse(null);
        return  tag;
    }

    @Override
    public Tag findTag(String name) {
        Tag tag = template.query(SQL_QUERY_READ_ONE_TAG_BY_NAME
                , new Object[]{name}, new BeanPropertyRowMapper<>(Tag.class))
                .stream().findAny().orElse(null);
        return  tag;
    }

    @Override
    public long addNewTag(Tag tag) {
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        template.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(SQL_QUERY_INSERT_TAG, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, tag.getName());
            return ps;

        }, generatedKeyHolder);

        long key = ((BigInteger)generatedKeyHolder.getKey()).longValue();

        return key;
    }

    @Override
    public void deleteTag(long id) {
        template.update(SQL_QUERY_DELETE_TAG, id);

    }
}