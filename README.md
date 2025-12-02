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

## 🗂️ Architecture du projet

Voici l’architecture exacte telle qu’elle apparaît dans ton projet :


GestionRestaurant/
│
├── app/
│ ├── AppClient.java
│ ├── AppCommande.java
│ └── AppPlat.java
│
├── connexion/
│ └── Connexion.java # Gestion de la connexion à la base de données
│
├── dao/
│ ├── IDao.java
│ └── UserDAO.java
│
├── entities/
│ ├── Client.java
│ ├── Commande.java
│ ├── Plat.java
│ └── User.java
│
├── services/
│ ├── Clientservice.java
│ ├── Commandeservice.java
│ ├── Platservice.java
│ └── Userservice.java
│
├── ul/ # Interface utilisateur (Swing)
│ ├── CalculDesRecettesForm.java
│ ├── ClientForm.java
│ ├── CommandeForm.java
│ ├── FiltrageForm.java
│ ├── LginForm.java
│ ├── Main.java
│ └── PlatForm.java
│
└── ul/images/


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

[![Demo NetBeans] (./videos/demo.mp4)


---

## 🖊️ Auteur

**Nom :** NOUHAYLA SABIQ 
**Cours :** java  
**Date :** 2 Décembre 2025  
**Encadré par :** Pr. Mohamed LACHGAR
