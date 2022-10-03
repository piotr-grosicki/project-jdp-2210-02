package com.kodilla.ecommercee.group;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/groups")
public class GroupController {

    @GetMapping
    public List<GroupDto> getGroups() {

        return new ArrayList<>();
    }

    @GetMapping(value = "{groupId}")
    public GroupDto getGroup(@PathVariable Long groupId) {

        return new GroupDto(1L, "test_group");
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createGroup() {

    }

    @PutMapping
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {

        return new GroupDto(1L, "updated_test_group");
    }

    @DeleteMapping(value = "{groupId}")
    public void deleteGroup(Long groupId) {

    }
}
