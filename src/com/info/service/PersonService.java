package com.info.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import java.util.List;

/**
 * Interface du service Person
 * Définit les méthodes métier
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface PersonService {

    // Retourne la liste de toutes les personnes
    public List<Person> getAllPersons();

    // Ajoute une personne
    public boolean addPerson(Person p);

    // Supprime une personne par ID
    public boolean deletePerson(int id);

    // Récupère une personne par ID
    public Person getPerson(int id);

    // Met à jour une personne
    public boolean updatePerson(Person p);

    // Recherche des personnes par nom
    public List<Person> getPersonByName(String name);
}
