package com.info.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe Entity JPA représentant la table "person" dans la base de données
 */
@Entity
@Table(name = "person")
public class Person {

    // Clé primaire de la table
    @Id
    // Génération automatique de l'ID
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // Colonne Age dans la table person
    @Column(name = "Age")
    private int age;

    // Colonne Name dans la table person
    @Column(name = "Name")
    private String name;

    // Constructeur vide obligatoire pour JPA
    public Person() {
    }

    // Constructeur avec paramètres
    public Person(int age, int id, String name) {
        this.age = age;
        this.id = id;
        this.name = name;
    }

    // Getter de l'id
    public int getId() {
        return id;
    }

    // Setter de l'id
    public void setId(int id) {
        this.id = id;
    }

    // Getter de l'âge
    public int getAge() {
        return age;
    }

    // Setter de l'âge
    public void setAge(int age) {
        this.age = age;
    }

    // Getter du nom
    public String getName() {
        return name;
    }

    // Setter du nom
    public void setName(String name) {
        this.name = name;
    }
}
