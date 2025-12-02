"# Project_GestionRestaurant.java" 
# 🍽️ Application de Gestion d’un Restaurant

## 🎯 Objectif du projet
Ce projet consiste à développer une application Java permettant de gérer les **clients**, **plats** et **commandes** d’un restaurant.  
L’application inclut également des outils d’analyse : **calcul des recettes**, **filtrage**, et **statistiques** sur les plats les plus vendus.

---

## 🚀 Fonctionnalités du projet

### ✔ Gestion des Clients
- Ajouter / Modifier / Supprimer un client  
- Attributs : nom, téléphone, adresse

### ✔ Gestion des Plats
- CRUD sur les plats  
- Filtrage par **catégorie**  
- Attributs : nom, catégorie, prix

### ✔ Gestion des Commandes
- Créer une commande  
- Associer un client + un plat  
- Définir quantité + date  
- Calcul automatique du total d'une commande

### ✔ Statistiques & Analyse
- Calcul du **chiffre d’affaires**  
- Chiffre d’affaires **par plat**   
- Graphique : ** Chiffre d’affaires par plat**
---

## 🗄️ Modèle Conceptuel de Données (MCD)

### ✔ Entité : Client
- idClient  
- nom  
- telephone  
- adresse  

### ✔ Entité : Plat
- idPlat  
- nom  
- categorie  
- prix  

### ✔ Entité : Commande
- idCommande  
- quantite  
- dateCommande  

### ✔ Associations
- **PASSER** → Client (1,N) — Commande (1,1)  
- **CONTENIR** → Plat (1,N) — Commande (1,1)

---

## 🏗️ Technologies et outils

- **Java SE**
- **Swing** (Formulaires : Form.java)
- **JDBC** (Connexion.java)
- **DAO Pattern**
- **NetBeans IDE**
- **MySQL / db**

---


## 💻 Démonstration dans NetBeans

🎥 [Voir la vidéo NetBeans : ](https://drive.google.com/file/d/1n6Hqovu4oeCeh4K810G-UUcWSrTrBcq0/view?usp=drive_link)

## 💻 Installation et Execution

🎥 [Voir la vidéo : ](https://drive.google.com/file/d/1JslVJoHGSYj-fSKZVpVNCjRLHDXcd3_T/view?usp=drive_link)




---

## 🖊️ Auteur

**Nom :** NOUHAYLA SABIQ 
**Cours :** java  
**Date :** 2 Décembre 2025  
**Encadré par :** Pr. Mohamed LACHGAR
