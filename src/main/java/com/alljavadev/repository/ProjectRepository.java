package com.alljavadev.repository;

import com.alljavadev.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project findByProjectCode(String code);


}
