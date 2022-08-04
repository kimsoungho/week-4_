package com.example.week4.Controller;


import com.example.week4.Dto.DetailDto;
import com.example.week4.Dto.ListDto;
import com.example.week4.Dto.UpdateDto;
import com.example.week4.Dto.WriteDto;
import com.example.week4.Repository.PostRepository;
import com.example.week4.Service.*;
import com.example.week4.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final WriteService writeService;
    private final ListService listService;
    private final DetailSevice detailSevice;

    private final PutService putService;

    private final DeleteService deleteService;


    public PostController(WriteService writeService, DeleteService deleteService, ListService listService, DetailSevice detailSevice, PutService putService) {
        this.writeService = writeService;
        this.listService = listService;
        this.detailSevice = detailSevice;
        this.putService = putService;
        this.deleteService=deleteService;
    }
    //포스팅
    @PostMapping("/post")
    @ResponseBody
    public String posting(@RequestBody WriteDto writeDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return writeService.Write(writeDto,userDetails);
    }
    //목록
    @GetMapping("/post")
    @ResponseBody
    private List<ListDto> List() {
        return listService.ListGet();
    }
    //검색
    @GetMapping("/post/{id}")
    @ResponseBody
    private DetailDto detail(@PathVariable long id){
        return detailSevice.detailDto(id);
    }
    //수정
    @PutMapping("/post/{id}")
    @ResponseBody
    private String update(@PathVariable long id, @RequestBody UpdateDto updateDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return putService.Update(id, updateDto, userDetails);
    }
    //삭제
    @DeleteMapping("/post/{id}")
    @ResponseBody
    private String remove(@PathVariable long id,@AuthenticationPrincipal UserDetailsImpl userDetails){
        return deleteService.DeletePost(id,userDetails);
    }
}

