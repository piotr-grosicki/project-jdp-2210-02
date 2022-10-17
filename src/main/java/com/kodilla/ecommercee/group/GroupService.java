package com.kodilla.ecommercee.group;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    @Autowired
    private final GroupRepository groupRepository;

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group getGroup(final Long id) throws GroupNotFoundException{
        return groupRepository.findById(id).orElseThrow(GroupNotFoundException::new);
    }

    public Group saveGroup(final Group group) {
        return groupRepository.save(group);
    }

    public Group updateGroup(Group group) throws GroupNotFoundException {

        Group groupToUpdate = groupRepository.findById(group.getId()).orElseThrow(GroupNotFoundException::new);
        if (group.getName() != null) {
            groupToUpdate.setName(group.getName());
        }
        saveGroup(groupToUpdate);
        return groupToUpdate;
    }

    public void deleteGroup(final Long groupId) {
        groupRepository.deleteById(groupId);
    }
}
