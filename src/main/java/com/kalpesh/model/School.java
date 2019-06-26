package com.kalpesh.model;

import javax.persistence.*;

@Entity
@Table(name = "school")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String name ;

    public void setName(String name) {
        this.name = name;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    private String standard ;

}
