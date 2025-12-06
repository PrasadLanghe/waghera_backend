package com.moonlite.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.moonlite.model.TeamMember;

public interface TeamMemberRepository  extends JpaRepository<TeamMember, Long> {

}
