package com.kalpesh.model;

import javax.persistence.*;

@Entity
@Table(name = "physique")
public class Physical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;


    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private String name ;

    private String height ;

    private String age ;


}
