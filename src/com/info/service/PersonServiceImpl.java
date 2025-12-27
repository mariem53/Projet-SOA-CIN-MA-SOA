package com.info.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Implémentation du service Person
 * Utilise JPA (Hibernate)
 */
public class PersonServiceImpl implements PersonService {

    // Création de l'EntityManagerFactory
    private EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("persistence");

    // EntityManager pour gérer les transactions JPA
    private EntityManager entityManager =
            entityManagerFactory.createEntityManager();

    // Ajouter une personne
    @Override
    public boolean addPerson(Person p) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(p);
            entityManager.getTransaction().commit();
            entityManager.clear();
            System.out.println("Record Successfully Inserted In The Database");
            return true;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            System.out.println("Erreur add");
            return false;
        }
    }

    // Supprimer une personne par ID
    @Override
    public boolean deletePerson(int id) {
        try {
            Person p = entityManager.find(Person.class, id);
            if (p == null) {
                System.out.println("Person not found");
                return false;
            }
            entityManager.getTransaction().begin();
            entityManager.remove(p);
            entityManager.getTransaction().commit();
            System.out.println("Delete Successfully In The Database");
            return true;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    // Récupérer une personne par ID
    @Override
    public Person getPerson(int id) {
        try {
            return entityManager.find(Person.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Mettre à jour une personne
    @Override
    public boolean updatePerson(Person p) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(p);
            entityManager.getTransaction().commit();
            entityManager.clear();
            System.out.println("Update Successfully In The Database");
            return true;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            System.out.println("Erreur update");
            return false;
        }
    }

    // Récupérer toutes les personnes
    @Override
    public List<Person> getAllPersons() {
        try {
            List<Person> listp =
                entityManager.createQuery("SELECT p FROM Person p", Person.class)
                             .getResultList();
            if (listp.isEmpty()) {
                System.out.println("No person found.");
            }
            return listp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Recherche des personnes par nom
    @Override
    public List<Person> getPersonByName(String name) {
        try {
            return entityManager
                .createQuery("SELECT p FROM Person p WHERE p.name = :name", Person.class)
                .setParameter("name", name)
                .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
