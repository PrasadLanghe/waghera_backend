package com.moonlite.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.moonlite.model.TeamMember;
import com.moonlite.payload.dto.TeamMemberDTO;
import com.moonlite.repository.TeamMemberRepository;
import com.moonlite.service.TeamService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamMemberRepository teamRepo;
    private final Cloudinary cloudinary;
    
    public TeamServiceImpl(TeamMemberRepository teamRepo,Cloudinary cloudinary)
    {
    	this.teamRepo=teamRepo;
    	this.cloudinary=cloudinary;

    }
    
   

    @Override
    public List<TeamMemberDTO> getAllTeamMembers() {
        return teamRepo.findAll().stream()
                .map(member -> new TeamMemberDTO(
                        member.getId(),
                        member.getName(),
                        member.getRole(),
                        member.getImageUrl()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public TeamMemberDTO saveTeamMemberFormData(String name, String role, MultipartFile image) throws IOException {

        // Upload image to Cloudinary
        Map uploadResult = cloudinary.uploader().upload(image.getBytes(),
                ObjectUtils.asMap("folder", "team_members"));

        String imageUrl = uploadResult.get("secure_url").toString();

        // Create team member
        TeamMember member = new TeamMember();
        member.setName(name);
        member.setRole(role);
        member.setImageUrl(imageUrl);

        TeamMember saved = teamRepo.save(member);

        return new TeamMemberDTO(
                saved.getId(),
                saved.getName(),
                saved.getRole(),
                saved.getImageUrl()
        );
    }
}
