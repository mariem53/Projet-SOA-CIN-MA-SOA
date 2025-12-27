# Projet SOA – Frontend REST (JEE / JAX-RS)

## Gestion des Personnes


---

## Description du projet

Ce projet implique le développement du **frontend d’une application web** pour la **gestion des personnes** avec un **backend RESTful** créé en **JEE avec JAX-RS**. 

Le frontend utilise uniquement les **services REST** fournis par le backend et suit l'architecture **Client / Serveur**.

> **Important** : Le frontend ne se connecte **jamais directement à la base de données**.

---

## Objectifs pédagogiques

* Comprendre et utiliser des services REST existants
* Utiliser correctement les méthodes HTTP : `GET`, `POST`, `PUT`, `DELETE`
* Manipuler des données **JSON** côté client
* Créer une interface web dynamique et responsive
* Publier un projet académique sur **GitHub**
* Présenter le projet avec une **vidéo explicative**

---

## Fonctionnalités réalisées

### Gestion des personnes

* Affichage de la liste des personnes
* Ajout d’une nouvelle personne
* Modification des informations d’une personne
* Suppression d’une personne avec confirmation
* Recherche d’une personne par :

  * ID
  * Nom

### Interface utilisateur

* Tableau dynamique des personnes
* Formulaires avec validation des champs
* Messages visuels (succès / erreur)
* Interface **responsive** grâce à Bootstrap

---

## Technologies utilisées

### Frontend

* **HTML5**
* **CSS3**
* **JavaScript (ES6)**
* **Bootstrap 5**
* **Fetch API**

### Backend (déjà développé)

* **Java 8**
* **JAX-RS**
* **JDBC / JPA (Hibernate)**
* **Apache Tomcat**
* **API REST (JSON)**

---

## Architecture du projet

```text
Frontend (HTML / CSS / JavaScript)
        |
        | HTTP (JSON)
        v
Backend REST (JAX-RS)
        |
        v
Base de données
```

✔️ Le frontend fonctionne uniquement comme **client REST**.

---

## Endpoints REST utilisés

| Fonction               | Méthode | URL                                   |
| ---------------------- | ------- | ------------------------------------- |
| Liste des personnes    | GET     | `/api/users/affiche`                  |
| Ajouter une personne   | POST    | `/api/users/add/{age}/{name}`         |
| Modifier une personne  | PUT     | `/api/users/update/{id}/{age}/{name}` |
| Supprimer une personne | DELETE  | `/api/users/remove/{id}`              |
| Recherche par ID       | GET     | `/api/users/getid/{id}`               |
| Recherche par nom      | GET     | `/api/users/getname/{name}`           |

---

## Instructions d’exécution (Étape par étape)

### 1️⃣ Lancer le backend

1. Démarrer **Apache Tomcat**
2. Déployer le projet backend JAX-RS
3. Vérifier l’accessibilité de l’API via :

   ```
   http://localhost:8080/TestRS/api/users
   ```

---

### 2️⃣ Lancer le frontend

Deux méthodes sont possibles :

#### Méthode 1 : via navigateur

* Ouvrir directement le fichier `cinema.html`

#### Méthode 2 : via Tomcat

* Placer le fichier `cinema.html` dans le dossier web de Tomcat
* Accéder à l’URL :

  ```
  http://localhost:8081/TestRS/cinema.html
  ```

---

## Vidéo de démonstration

Lien YouTube :

```
https://youtu.be/XXXXXXXX a changeeee***
```

---

## Dépôt GitHub

Lien du projet :

```
https://github.com/mariem53/Projet-SOA-CIN-MA-SOA.git
```

---

## Auteurs
* **Mariem Baccouch** (Groupe TP 6)
* **Yosra Regaieg** (Groupe TP 7)
* **Module** : SOA
* **Année universitaire** : 2025 / 2026

---
