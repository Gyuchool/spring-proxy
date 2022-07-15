package com.tecotalk.proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Orders")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int count;

    protected Order() {
    }

    public Long getId() {
        return id;
    }

    public int getCount() {
        return count;
    }
}
