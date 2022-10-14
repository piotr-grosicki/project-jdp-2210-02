package com.kodilla.ecommercee.group;

import com.kodilla.ecommercee.product.Product;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name =  "\"GROUPS\"")
public class Group {

    @Id
    @GeneratedValue
    @Column(name = "GROUP_ID", unique = true)
    private Long id;

    @Column(name = "NAME")

    private String name;
    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Product> products;
}