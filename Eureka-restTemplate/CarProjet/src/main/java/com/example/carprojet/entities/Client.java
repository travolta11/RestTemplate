package com.example.carprojet.entities;

public class Client {
    private Long id;
    private String nom;
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Client() {
    }

    public Client(Long id, String nom, Integer age) {
        this.id = id;
        this.nom = nom;
        this.age = age;
    }

}
