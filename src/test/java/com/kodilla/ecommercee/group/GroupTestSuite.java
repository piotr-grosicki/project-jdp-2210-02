package com.kodilla.ecommercee.group;

import com.kodilla.ecommercee.product.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GroupTestSuite {

    @Autowired
    private GroupService groupService;

    @Test
    public void testFindAllGroups() {
        //Given
        Product product1 = new Product("product1", "description1", 5, 24.30);
        Product product2 = new Product("product2", "description2", 12, 7.55);
        Product product3 = new Product("product3", "description3", 2, 112.47);
        List<Product> products1 = new ArrayList<>();
        List<Product> products2 = new ArrayList<>();
        List<Product> products3 = new ArrayList<>();
        products1.add(product1);
        products2.add(product2);
        products3.add(product3);
        Group group1 = new Group("group1");
        Group group2 = new Group("group2");
        Group group3 = new Group("group3");
        //When
        groupService.saveGroup(group1);
        groupService.saveGroup(group2);
        groupService.saveGroup(group3);
        List<Group> testList = groupService.getAllGroups();
        //Then
        assertEquals(3, testList.size());
        //CleanUp
        groupService.deleteGroup(group1.getId());
        groupService.deleteGroup(group2.getId());
        groupService.deleteGroup(group3.getId());
    }

    @Test
    public void testFingGroupById() throws GroupNotFoundException {
        //Given
        Product product1 = new Product("product1", "description1", 5, 24.30);
        Product product2 = new Product("product2", "description2", 12, 7.55);
        Product product3 = new Product("product3", "description3", 2, 112.47);
        List<Product> products1 = new ArrayList<>();
        List<Product> products2 = new ArrayList<>();
        List<Product> products3 = new ArrayList<>();
        products1.add(product1);
        products2.add(product2);
        products3.add(product3);
        Group group1 = new Group("group1");
        Group group2 = new Group("group2");
        Group group3 = new Group("group3");
        //When
        groupService.saveGroup(group1);
        groupService.saveGroup(group2);
        groupService.saveGroup(group3);
        Group testGroup1 = groupService.getGroup(group1.getId());
        Group testGroup2 = groupService.getGroup(group2.getId());
        Group testGroup3 = groupService.getGroup(group3.getId());
        //Then
        assertEquals("group1", testGroup1.getName());
        assertEquals("group2", testGroup2.getName());
        assertEquals("group3", testGroup3.getName());
        //CleanUp
        groupService.deleteGroup(group1.getId());
        groupService.deleteGroup(group2.getId());
        groupService.deleteGroup(group3.getId());
    }

    @Test
    public void testDeleteGroupById() {
        //Given
        Product product1 = new Product("product1", "description1", 5, 24.30);
        Product product2 = new Product("product2", "description2", 12, 7.55);
        Product product3 = new Product("product3", "description3", 2, 112.47);
        List<Product> products1 = new ArrayList<>();
        List<Product> products2 = new ArrayList<>();
        List<Product> products3 = new ArrayList<>();
        products1.add(product1);
        products2.add(product2);
        products3.add(product3);
        Group group1 = new Group("group1");
        Group group2 = new Group("group2");
        Group group3 = new Group("group3");
        //When
        groupService.saveGroup(group1);
        groupService.saveGroup(group2);
        groupService.saveGroup(group3);
        groupService.deleteGroup(group3.getId());
        List<Group> testList = groupService.getAllGroups();
        //Then
        assertEquals(2, testList.size());
        //CleanUp
        groupService.deleteGroup(group1.getId());
        groupService.deleteGroup(group2.getId());
    }
}
