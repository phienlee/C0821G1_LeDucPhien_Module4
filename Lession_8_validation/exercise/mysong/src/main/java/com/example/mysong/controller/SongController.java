package com.example.mysong.controller;

import com.example.mysong.dto.SongDTO;
import com.example.mysong.model.Song;
import com.example.mysong.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    ISongService iSongService;

    @GetMapping(value = {"","/list"})
    public String listPageable(Model model, @RequestParam(value = "page", defaultValue = "0")int page) {
        Sort sort = Sort.by("name").descending().and(Sort.by("id").ascending());
        Page<Song> songList = iSongService.findAll(PageRequest.of(page,1));
        model.addAttribute("songList", songList);
        return "song/index";
    }


    @GetMapping("{id}/view")
    public String view(@PathVariable("id") Integer id, Model model) {
        SongDTO songDTO = iSongService.findById(id);
        model.addAttribute("song", songDTO);
        return "song/view";
    }

    @GetMapping("{id}/delete")
    public String showDelete(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("song", iSongService.findById(id));
        return "song/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("song") SongDTO songDTO, RedirectAttributes redirectAttributes) {
        iSongService.remove(songDTO.getId());
        redirectAttributes.addFlashAttribute("message", "Removed product successfully!");
        return "redirect:/song/list";
    }


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("song", new SongDTO());
        return "song/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("song") SongDTO songDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()){
            return "/song/create";
        }
        redirectAttributes.addFlashAttribute("message", "Create success");
        iSongService.save(songDTO);
        return "redirect:/song/list";
    }

    @GetMapping("{id}/edit")
    public String showEdit(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("song", iSongService.findById(id));
        return "song/edit";
    }


    @GetMapping("/edit_param")
    public String showEditParam(@RequestParam(name = "id") int id, Model model) {
        model.addAttribute("song", iSongService.findById(id));
        return "song/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("song") SongDTO songDTO,BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()){
            model.addAttribute("song",songDTO);
            return "song/edit";
        }

        iSongService.save(songDTO);
        redirectAttributes.addFlashAttribute("message", "Edit success");
        return "redirect:/song/list";
    }

}
