package com.kodilla.ecommercee.group;

import com.kodilla.ecommercee.product.Product;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GroupTestSuite {

    @Autowired
    private GroupRepository groupRepository;

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
        Group group1 = new Group("group1", products1);
        Group group2 = new Group("group2", products2);
        Group group3 = new Group("group3", products3);
        //When
        groupRepository.save(group1);
        groupRepository.save(group2);
        groupRepository.save(group3);
        List<Group> testList = groupRepository.findAll();
        //Then
        assertEquals(3, testList.size());
        //CleanUp
        groupRepository.deleteById(group1.getId());
        groupRepository.deleteById(group2.getId());
        groupRepository.deleteById(group3.getId());
    }

    @Test
    public void testFingGroupById() {
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
        Group group1 = new Group("group1", products1);
        Group group2 = new Group("group2", products2);
        Group group3 = new Group("group3", products3);
        //When
        groupRepository.save(group1);
        groupRepository.save(group2);
        groupRepository.save(group3);
        Optional<Group> testGroup1 = groupRepository.findById(group1.getId());
        Optional<Group> testGroup2 = groupRepository.findById(group2.getId());
        Optional<Group> testGroup3 = groupRepository.findById(group3.getId());
        //Then
        assertEquals("group1", testGroup1.get().getName());
        assertEquals("group2", testGroup2.get().getName());
        assertEquals("group3", testGroup3.get().getName());
        //CleanUp
        groupRepository.deleteById(group1.getId());
        groupRepository.deleteById(group2.getId());
        groupRepository.deleteById(group3.getId());
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
        Group group1 = new Group("group1", products1);
        Group group2 = new Group("group2", products2);
        Group group3 = new Group("group3", products3);
        //When
        groupRepository.save(group1);
        groupRepository.save(group2);
        groupRepository.save(group3);
        groupRepository.deleteById(group3.getId());
        List<Group> testList = groupRepository.findAll();
        //Then
        assertEquals(2, testList.size());
        //CleanUp
        groupRepository.deleteById(group1.getId());
        groupRepository.deleteById(group2.getId());
    }
}