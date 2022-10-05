package com.kodilla.ecommercee.group;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "GROUPS")
public class Group {

    @Id
    @GeneratedValue
    @Column(name = "GROUP_ID", unique = true)
    private Long id;

    @Column(name = "NAME")
    private String name;
}