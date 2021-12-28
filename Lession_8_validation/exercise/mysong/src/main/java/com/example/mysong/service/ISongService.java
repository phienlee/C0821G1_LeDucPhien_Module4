package com.example.mysong.service;


import com.example.mysong.dto.SongDTO;
import com.example.mysong.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ISongService {

    List<SongDTO> getAll();

    SongDTO findById(Integer id);

    void save(SongDTO songDTO);

    List<Song> findByName(String name);

    void remove(Integer id);

    Page<Song> findAll(PageRequest of);
}
