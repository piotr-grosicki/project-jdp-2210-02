package com.kodilla.ecommercee.group;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "groups")
public class Group {

    @Id
    @GeneratedValue
    @Column(name = "group_id", unique = true)
    private Long id;

    @Column(name = "name")
    private String name;
}