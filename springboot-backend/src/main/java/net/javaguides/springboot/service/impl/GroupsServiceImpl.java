package net.javaguides.springboot.service.impl;

import jakarta.transaction.Transactional;
import net.javaguides.springboot.dto.request.GroupsRequest;
import net.javaguides.springboot.dto.response.GroupsResponse;
import net.javaguides.springboot.model.*;
import net.javaguides.springboot.repository.GroupsRepository;
import net.javaguides.springboot.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class GroupsServiceImpl implements GroupsService {

    @Autowired
    private GroupsRepository groupsRepository;

    //------------- GET ALL -------------
    @Override
    public List<GroupsResponse> getAllGroups() {
        List<Groups> groupsList = groupsRepository.findAll();

        return groupsList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());

    }

    //------------- GET BY ID -------------
    @Override
    public Optional<GroupsResponse> getGroupById(Long id) {
        Optional<Groups> group = groupsRepository.findById(id);

        return group.map(this::mapToDto);
    }

    private GroupsResponse mapToDto(Groups groups) {
        GroupsResponse response = new GroupsResponse();
        response.setId(groups.getId());
        response.setName(groups.getName());
        response.setDescription(groups.getDescription());
        response.setLink(groups.getLink());

        return response;
    }

    //------------- POST AND PUT -------------
    @Override
    public Groups saveOrUpdate(GroupsRequest groupsRequest) {
        if (groupsRequest.getId() != null) {
            Optional<Groups> existingGroup = groupsRepository.findById(groupsRequest.getId());
            if (existingGroup.isPresent()) {
                return updateExistingGroup(existingGroup.get(), groupsRequest);
            }
        }

        return createNewGroup(groupsRequest);
    }

    private Groups createNewGroup(GroupsRequest groupsRequest) {
        Groups group = new Groups();
        group.setName(groupsRequest.getName());
        group.setDescription(groupsRequest.getDescription());
        group.setLink(groupsRequest.getLink());
        return groupsRepository.save(group);
    }

    private Groups updateExistingGroup(Groups existingGroup, GroupsRequest groupsRequest) {
        existingGroup.setName(groupsRequest.getName());
        existingGroup.setDescription(groupsRequest.getDescription());
        existingGroup.setLink(groupsRequest.getLink());
        return groupsRepository.save(existingGroup);
    }

    //------------- DELETE -------------
    @Override
    public void deleteGroup(Long id) {
        groupsRepository.deleteById(id);
    }
}
