package com.example.mysong.service.impl;

import com.example.mysong.dto.SongDTO;
import com.example.mysong.model.Song;
import com.example.mysong.repository.ISongRepository;
import com.example.mysong.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    ISongRepository iSongRepository;

    @Override
    public List<SongDTO> getAll() {
        List<Song> songList = iSongRepository.findAll();
        List<SongDTO> songDTOList = new ArrayList<>();
        for (Song song : songList) {
            SongDTO songDTO = new SongDTO(song.getId(), song.getName(), song.getSinger(), song.getTypeOfMusic());
            songDTOList.add(songDTO);
        }
        return songDTOList;
    }

    @Override
    public SongDTO findById(Integer id) {
        Song song = iSongRepository.findById(id).orElse(null);
        SongDTO songDTO = new SongDTO(song.getId(), song.getName(), song.getSinger(), song.getTypeOfMusic());
        return songDTO;
    }

    @Override
    public void save(SongDTO songDTO) {
        Song song = new Song(songDTO.getId(), songDTO.getName(), songDTO.getSinger(), songDTO.getTypeOfMusic());
        iSongRepository.save(song);
    }

    @Override
    public List<Song> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {
        iSongRepository.deleteById(id);
    }

    @Override
    public Page<Song> findAll(PageRequest of) {
       return iSongRepository.findAll(of);
    }
}
