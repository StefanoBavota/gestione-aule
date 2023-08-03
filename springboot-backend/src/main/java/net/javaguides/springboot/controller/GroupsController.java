package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.request.GroupsRequest;
import net.javaguides.springboot.dto.response.GroupsResponse;
import net.javaguides.springboot.model.Groups;
import net.javaguides.springboot.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/groups")
public class GroupsController {

    @Autowired
    private GroupsService groupsService;

    @GetMapping
    public ResponseEntity<List<GroupsResponse>> getAllGroups(){
        return ResponseEntity.ok(groupsService.getAllGroups());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<GroupsResponse>> groupById(@PathVariable Long id) {
        return ResponseEntity.ok(groupsService.getGroupById(id));
    }

    @PostMapping
    public ResponseEntity<Groups> createGroup(@RequestBody GroupsRequest groupsRequest) {
        Groups createdGroup = groupsService.saveOrUpdate(groupsRequest);
        return ResponseEntity.ok(createdGroup);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Groups> updateGroup(@PathVariable Long id, @RequestBody GroupsRequest groupsRequest) {
        groupsRequest.setId(id);
        Groups updatedGroup = groupsService.saveOrUpdate(groupsRequest);
        return ResponseEntity.ok(updatedGroup);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroupById(@PathVariable Long id) {
        groupsService.deleteGroup(id);
        return ResponseEntity.noContent().build();
    }
}
