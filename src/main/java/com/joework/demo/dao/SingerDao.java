package com.joework.demo.dao;

import com.joework.demo.models.Singer;

import java.util.List;

public interface SingerDao {
        List<Singer> findAll();
        List<Singer> findAllWithAlbum();
        Singer findById(Long id);
        Singer save(Singer contact);
        void delete(Singer contact);
    }

