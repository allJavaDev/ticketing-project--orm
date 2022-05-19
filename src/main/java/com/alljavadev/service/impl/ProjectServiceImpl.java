package com.alljavadev.service.impl;

import com.alljavadev.dto.ProjectDTO;
import com.alljavadev.entity.Project;
import com.alljavadev.entity.User;
import com.alljavadev.enums.Status;
import com.alljavadev.mapper.ProjectMapper;
import com.alljavadev.repository.ProjectRepository;
import com.alljavadev.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }


    @Override
    public ProjectDTO getByProjectCode(String code) {
        Project project=projectRepository.findByProjectCode(code);
        return projectMapper.convertToDTO(project);
    }

    @Override
    public List<ProjectDTO> listAllProjects() {
        List<Project> list= projectRepository.findAll(); //returns entity

        //convert entity to dto - mapper
        return list.stream().map(projectMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public void save(ProjectDTO dto) {
    dto.setProjectStatus(Status.OPEN);
    Project project=projectMapper.convertToEntity(dto);
    projectRepository.save(project);
    }

    @Override
    public void update(ProjectDTO dto) {

        Project project = projectRepository.findByProjectCode(dto.getProjectCode());

        Project convertedProject=projectMapper.convertToEntity(dto);

        convertedProject.setId(project.getId());
        convertedProject.setProjectStatus(project.getProjectStatus());
        projectRepository.save(convertedProject);
    }

    @Override
    public void delete(String code) {
    Project project = projectRepository.findByProjectCode(code);
    project.setIsDeleted(true);
    projectRepository.save(project);
    }

    @Override
    public void complete(String code) {
        Project project = projectRepository.findByProjectCode(code);
        project.setProjectStatus(Status.COMPLETE);
        projectRepository.save(project);
    }
}
