package com.springboot.club_house_api_server.club.controller;

import com.springboot.club_house_api_server.club.dto.ClubRequestDto;
import com.springboot.club_house_api_server.club.dto.ModifyTagDto;
import com.springboot.club_house_api_server.club.dto.SearchClubResponseDto;
import com.springboot.club_house_api_server.club.entity.ClubEntity;
import com.springboot.club_house_api_server.club.service.ClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/club")
public class ClubController {
    private final ClubService clubService;

    @PostMapping("/add")
    public ResponseEntity<?> addClub(@RequestBody ClubRequestDto clubRequestDto){
        return clubService.addClub(
                clubRequestDto.getUserId(),
                clubRequestDto.getClubName(),
                clubRequestDto.getClubDescription(),
                clubRequestDto.getClubLogoURL(),
                clubRequestDto.getClubBackgroundURL()
        );
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<SearchClubResponseDto>> findAllClubs(){

       return clubService.getAllClubs();
    }

    @GetMapping("/find/by-name")
    public ResponseEntity<?> findClubByName(@RequestParam String clubName){
        return clubService.getClubByName(clubName);
    }

    @GetMapping("/find/all-members")
    public ResponseEntity<?> findAllMembers(@RequestParam long clubId){
        return clubService.findAllClubMembers(clubId);
    }
    //유저 ID로 가입한 모든 동호회 조회
    @GetMapping("/find/by-user_id")
    public ResponseEntity<?> findClubByUserId(@RequestParam long userId){
        return clubService.findAllClubsByUserId(userId);
    }

    //ClubId로 클럽 상세정보 조회
    @GetMapping("/find/by-club_id")
    public ResponseEntity<?> findClubByClubId(@RequestParam long clubId){
        return clubService.findClubById(clubId);
    }

    @PostMapping("/set/main-account")
    public ResponseEntity<?> setMainAccount(@RequestParam long clubId, @RequestParam long accountId){
        return clubService.setMainAccount(clubId, accountId);
    }

    @GetMapping("/get/main-account")
    public ResponseEntity<?> getMainAccount(@RequestParam long clubId){
        return clubService.getMainAccount(clubId);
    }

    @GetMapping("/get/tags")
    public ResponseEntity<?> getTags(@RequestParam long clubId){
        return clubService.findAllTagsByClubId(clubId);
    }

    @PostMapping("/update/tags")
    public ResponseEntity<?> modifyTags(@RequestBody ModifyTagDto modifyTagDto){
        return clubService.setClubTagsByClubId(modifyTagDto);
    }
}
