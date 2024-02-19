package com.sparta.spring0402myselectshop.controller;


import com.sparta.spring0402myselectshop.dto.FolderRequestDto;
import com.sparta.spring0402myselectshop.dto.FolderResponseDto;
import com.sparta.spring0402myselectshop.security.UserDetailsImpl;
import com.sparta.spring0402myselectshop.service.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FolderController {

    private final FolderService folderService;
    //폴더 생성
    @PostMapping("/folders")
    public void addFolders(@RequestBody FolderRequestDto folderRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        List<String> folderNames = folderRequestDto.getFolderNames();
        folderService.addFolders(folderNames,userDetails.getUser());
    }

    // 회원이 등록한 모든 폴더 조회
    @GetMapping("/folders")
    public List<FolderResponseDto> getFolders(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return folderService.getFolders(userDetails.getUser());
    }
}
