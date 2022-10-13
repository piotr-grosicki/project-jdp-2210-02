package com.kodilla.ecommercee.group;

import com.kodilla.ecommercee.product.Product;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "\"GROUPS\"")
public class Group {

    public Group(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    @Id
    @NotNull
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