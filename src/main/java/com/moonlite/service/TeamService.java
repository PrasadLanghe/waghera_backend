package com.moonlite.service;


import org.springframework.web.multipart.MultipartFile;

import com.moonlite.payload.dto.TeamMemberDTO;

import java.io.IOException;
import java.util.List;

public interface TeamService {

    List<TeamMemberDTO> getAllTeamMembers();

    TeamMemberDTO saveTeamMemberFormData(String name, String role, MultipartFile image) throws IOException;
}
