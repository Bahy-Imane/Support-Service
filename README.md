Support Service IT

Ce projet est un système de gestion des équipements informatiques. Le système permet de suivre l'état des équipements, de gérer les pannes et de traiter les tickets de support pour une gestion efficace des ressources informatiques.

Table des matières
Aperçu
Fonctionnalités
Architecture du Projet
Technologies Utilisées
Installation
Utilisation
Structure de la Base de Données
Tests
Contributions
Licence
Auteurs
Aperçu


Le système de gestion des équipements informatiques est conçu pour les administrateurs IT afin de faciliter la gestion des équipements, le suivi des pannes, et la gestion des tickets de support. Les utilisateurs peuvent signaler des pannes, et les techniciens peuvent gérer les tickets qui leur sont attribués.

Fonctionnalités

Gestion des Équipements Informatiques
Ajouter des équipements : Les administrateurs peuvent ajouter de nouveaux équipements au système.
Modifier des équipements : Les administrateurs peuvent mettre à jour les informations des équipements existants.
Supprimer des équipements : Les administrateurs peuvent supprimer des équipements obsolètes ou hors service.
Lister les équipements : Les administrateurs peuvent voir une liste complète des équipements avec leur état actuel.

Gestion et Suivi des Pannes
Ajouter, modifier et supprimer des pannes : Les administrateurs peuvent gérer les pannes associées aux équipements.
Consulter l'historique des pannes : Les administrateurs peuvent consulter l'historique des pannes pour chaque équipement.

Gestion des Tickets de Support
Création de tickets : Les utilisateurs peuvent créer des tickets de support pour signaler des pannes.
Attribution des tickets : Les administrateurs peuvent attribuer des tickets de support aux techniciens.
Suivi des tickets : Les techniciens peuvent consulter et traiter les tickets qui leur sont attribués.
Suivi de l'état des tickets : Les utilisateurs peuvent suivre l'état de leurs tickets pour voir l'avancement de la résolution.

Rapports et Statistiques (Bonus)
Notifications des tickets en attente : Les administrateurs reçoivent des notifications pour les tickets en attente.
Statistiques sur les pannes : Les administrateurs peuvent consulter des statistiques pour identifier les tendances et problèmes récurrents.
Rapports sur l'état des équipements : Les administrateurs peuvent générer des rapports détaillés sur l'état des équipements.
Rapports sur les performances du support : Les administrateurs peuvent générer des rapports sur les performances du service de support.
Architecture du Projet
Le projet est structuré en deux parties principales : le backend et le frontend.

Backend

Langage : Java 17
Framework : Spring Boot
Sécurité : Spring Security
Persistance : Spring Data JPA
Base de données : MySQL

Frontend

Framework : Angular 17
Conteneurisation
Docker : Utilisé pour la conteneurisation des services backend et frontend.

Technologies Utilisées

Java 17
Spring Boot
Spring Data JPA
Spring Security
Angular 17
PostgreSQL / MySQL
Docker
JUnit (pour les tests unitaires)
Installation
Prérequis
Java 17
Node.js et npm
Docker
PostgreSQL ou MySQL
Backend
Clonez le dépôt :


Auteurs
Bahy Imane - Développeur Full Stack java/angular
