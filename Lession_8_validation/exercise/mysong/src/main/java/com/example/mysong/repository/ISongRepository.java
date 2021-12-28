package com.example.mysong.repository;


import com.example.mysong.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song,Integer> {

}
