package com.assesment.develup.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "assessment")
public class Products {
    @Id
    @Column(name = "barcode")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "item_desc")
    private String itemDescription;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "sizee")
    private String size;
    @Column(name = "price")
    private double price;
    @Column(name = "qty")
    private double quantity;
    @Column(name = "profit")
    private double profit;
    @Column(name = "remain_qty")
    private double remainingQuantity;

}
