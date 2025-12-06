package com.moonlite.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.moonlite.payload.dto.TeamMemberDTO;
import com.moonlite.service.TeamService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/team")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TeamController {

    private final TeamService teamService;
    
    
    
    public TeamController(TeamService teamService)
    {
    	this.teamService=teamService;
    }
    

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TeamMemberDTO> getTeam() {
        return teamService.getAllTeamMembers();
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public TeamMemberDTO addTeamMember(
            @RequestParam("name") String name,
            @RequestParam("role") String role,
            @RequestParam("image") MultipartFile image
    ) throws IOException {
        return teamService.saveTeamMemberFormData(name, role, image);
    }
}
