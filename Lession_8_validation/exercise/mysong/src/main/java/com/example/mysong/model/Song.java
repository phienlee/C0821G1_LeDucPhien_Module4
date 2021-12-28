package com.example.mysong.model;


import javax.persistence.*;

@Entity(name = "my_song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "singer")
    private String singer;

    @Column(name = "type_of_music")
    private String typeOfMusic;


    public Song() {
    }

    public Song(Integer id, String name, String singer, String typeOfMusic) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.typeOfMusic = typeOfMusic;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTypeOfMusic() {
        return typeOfMusic;
    }

    public void setTypeOfMusic(String typeOfMusic) {
        this.typeOfMusic = typeOfMusic;
    }
}
