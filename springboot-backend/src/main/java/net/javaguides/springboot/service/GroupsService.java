package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.request.GroupsRequest;
import net.javaguides.springboot.dto.response.GroupsResponse;
import net.javaguides.springboot.model.Groups;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GroupsService {

    public List<GroupsResponse> getAllGroups();

    Optional<GroupsResponse> getGroupById(Long idGroup);

    Groups saveOrUpdate(GroupsRequest groupsRequest);

    void deleteGroup(Long idGroup);
}
