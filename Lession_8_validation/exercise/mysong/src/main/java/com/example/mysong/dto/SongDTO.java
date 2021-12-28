package com.example.mysong.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class SongDTO {
    private Integer id;
    @NotBlank(message = "Tên bài hát không chứa các ký tự đặc biệt và tối đa 800 ký tự" )
    @Pattern(regexp = "^[a-zA-Z0-9 ]{1,800}$",message = "Tên bài hát không được chứa các ký tự đặc biệt và tối đa 800 ký tự")
    private String name;

    @NotBlank(message = "Tên bài hát không chứa các ký tự đặc biệt và tối đa 800 ký tự" )
    @Pattern(regexp = "^[a-zA-Z0-9 ]{1,300}$",message = "Tên Nghệ sỹ không được chứa các ký tự đặc biệt và tối đa 300 ký tự")
    private String singer;

    @NotBlank(message = "Tên bài hát không chứa các ký tự đặc biệt và tối đa 800 ký tự" )
    @Pattern(regexp = "^[a-zA-Z0-9 ,]{1,1000}$",message = "Tên thể loại không được chứa các ký tự đặc biệt và tối đa 1000 ký tự")
    private String typeOfMusic;

    public SongDTO() {
    }

    public SongDTO(Integer id, String name, String singer, String typeOfMusic) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.typeOfMusic = typeOfMusic;
    }

    public Integer getId() {
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
