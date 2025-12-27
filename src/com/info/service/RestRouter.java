package com.info.service;

import java.util.HashMap;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Classe REST exposant les services via HTTP
 */
@Path("/users")
public class RestRouter {

    // Instance du service
    PersonServiceImpl p = new PersonServiceImpl();

    // Récupérer tous les utilisateurs
    @GET
    @Path("/affiche")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllVisitors() {
        List<Person> visitors = p.getAllPersons();
        HashMap<String, Object> result = new HashMap<>();
        result.put("state", "ok");
        result.put("data", visitors);
        return Response.ok(result).build();
    }

    // Ajouter un utilisateur
    @POST
    @Path("/add/{age}/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public HashMap<String, Object> addUser(@PathParam("age") int age,
                                           @PathParam("name") String name) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Person user = new Person();
        user.setAge(age);
        user.setName(name);
        p.addPerson(user);
        hashMap.put("state", "ok");
        hashMap.put("user", user);
        return hashMap;
    }

    // Supprimer un utilisateur
    @DELETE
    @Path("/remove/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public HashMap<String, Object> deleteUser(@PathParam("id") int id) {
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            if (p.deletePerson(id)) {
                hashMap.put("state", "ok");
                return hashMap;
            }
            hashMap.put("state", "id doesn't exist");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("state", "no");
            hashMap.put("msg", e.getMessage());
            return hashMap;
        }
    }

    // Récupérer un utilisateur par ID
    @GET
    @Path("/getid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public HashMap<String, Object> getIdUser(@PathParam("id") int id) {
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            Person visitor = p.getPerson(id);
            if (visitor != null) {
                hashMap.put("state", "ok");
                hashMap.put("data", visitor);
                return hashMap;
            }
            hashMap.put("state", "id doesn't exist");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("state", "no");
            hashMap.put("msg", e.getMessage());
            return hashMap;
        }
    }

    // Mettre à jour un utilisateur
    @PUT
    @Path("/update/{id}/{age}/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public HashMap<String, Object> updateUser(@PathParam("id") int id,
                                               @PathParam("age") int age,
                                               @PathParam("name") String name) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Person user = new Person();
        user.setId(id);
        user.setAge(age);
        user.setName(name);
        if (p.updatePerson(user)) {
            hashMap.put("state", "ok");
            return hashMap;
        }
        hashMap.put("state", "id doesn't exist");
        return hashMap;
    }

    // Recherche par nom
    @GET
    @Path("/getname/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public HashMap<String, Object> getPersonByName(@PathParam("name") String name) {
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            List<Person> persons = p.getPersonByName(name);
            if (persons != null && !persons.isEmpty()) {
                hashMap.put("state", "ok");
                hashMap.put("data", persons);
                return hashMap;
            }
            hashMap.put("state", "Name doesn't exist");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("state", "no");
            hashMap.put("msg", e.getMessage());
            return hashMap;
        }
    }
}
