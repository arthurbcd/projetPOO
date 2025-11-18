Groupe Q
- MONTEIRO MIRANDA Arthur
- DOS SANTOS GOUVEA Bianka

Le 13 novembre 2025.

Ce jour on a commencé le Diagramme UML en utilisant lucid.app online.

Le Diagramme UML:
https://lucid.app/lucidchart/e46da43f-c3aa-4029-8d17-bec364b97417/edit?viewport_loc=860%2C-1119%2C3021%2C1774%2C0_0&invitationId=inv_7855069e-d831-4f74-ac9f-9d01c65e1a49

Aprés on a commencé a créer les classes suivantes:

- Category
- Course
- Inscription
- Session
- Student
- Teacher

Et aussi le State Design Pattern

L'interface `SessionState` avec les state suivantes:

- EndedSessionState
- FullSessionState
- OpenSessionState
- StartedSessionState
- CanceledSessionState

Pour utiliser ses états pour notifier les utilisateurs on a aussi implementé le Observer pattern.

Pour ça, on a crée:

- Observer
- Observable

Et la classe `Observable` a été modifiée pour inclure les méthodes `subscribe` et `unsubscribe` pour gérer les abonnements des observateurs.

## Compte Rendu des Séances

### Le 16 novembre 2025
**Participants:** Arthur
**Travail effectué :**
1.  **Analyse et Restructuration du Projet :**
    *   Évaluation de la nouvelle structure de classes créée par l'utilisateur, avec une nomenclature en anglais.
    *   Création des packages manquants pour les Design Patterns et l'architecture MVC : `manager`, `factory`, `decorator`, `controller`, `view`.

2.  **Complétion et Correction de la Couche Modèle (`model`) :**
    *   **`Category.java`**: Transformée en `enum` pour représenter les catégories fixes de formation.
    *   **`Course.java`**: Ajout des attributs (titre, durée, prérequis), du constructeur et des méthodes de gestion.
    *   **`Student.java`** et **`Teacher.java`**: Implémentation de l'interface `Observer` et ajout des attributs et méthodes nécessaires pour la gestion des inscriptions et des spécialités.
    *   **`Inscription.java`**: Complétée pour lier un `Student` à une `Session`.
    *   **`Session.java`**: Modifiée pour hériter d'`Observable` et intégrer le pattern `State`, permettant de notifier les observateurs et de gérer son cycle de vie.
        - Ajout des méthodes `subscribe()` et `unsubscribe()` pour gérer les inscriptions avec validation de l'état.
        - Implémentation des méthodes `cancelSession()`, `startSession(Teacher)`, et `endSession(Teacher)` pour contrôler le cycle de vie complet d'une session.
        - La méthode `unsubscribe()` vérifie l'état de la session et permet uniquement la désinscription dans les états `Open` et `Full`.
        - La méthode `endSession()` vérifie que seul le professeur qui a démarré la session peut la terminer.
        - Changement de `courseId` pour un objet `Course` complet, améliorant la cohésion du modèle.

3.  **Implémentation des Design Patterns :**
    *   **Observer**: Correction de `Observer` (devenu une interface) et implémentation de la classe `Observable` pour gérer les notifications.
    *   **State**: Définition de l'interface `SessionState` et implémentation de la logique pour les états concrets (`OpenSessionState`, `FullSessionState`, etc.) afin de gérer les transitions de la session.
        - Ajout de la méthode `getNotifyMessage()` à l'interface `SessionState` pour personnaliser les messages de notification par état.
        - Ajout de la méthode `getInvalidMessage(String action)` pour gérer les messages d'erreur lorsqu'une action n'est pas permise dans l'état actuel.
        - Les états `StartedSessionState` et `EndedSessionState` contiennent maintenant une référence au `Teacher` et un timestamp pour tracer qui et quand la session a été démarrée/terminée.
        - Validation des transitions d'état : seules certaines actions sont permises dans chaque état.
    *   **Singleton**: Création d'un `CourseManager` comme exemple de gestionnaire à instance unique.
    *   **Factory**: Ébauche d'une `CourseFactory` pour la création d'objets `Course`.
    *   **Decorator**: Proposition d'une structure pour le `CourseOptionDecorator` afin d'ajouter dynamiquement des fonctionnalités aux cours.

**Objectifs pour la prochaine séance :**
*   Finaliser l'implémentation des classes `Manager` pour toutes les entités du modèle.
*   Développer la couche `Controller` pour gérer la logique métier et les interactions.
*   Commencer le développement de la `View` en mode console pour tester les fonctionnalités.
*   Implémenter la liste d'attente (waiting list) pour les sessions complètes.
*   Ajouter la validation des pré-requis pour les formations.

### Le 15 novembre 2025
**Participants:** Arthur, Bianka
**Travail effectué :**
1.  **Finalisation du Modèle Conceptuel :**
    *   Achèvement du diagramme de classes UML.
    *   Validation des attributs et méthodes pour chaque classe.
    *   Définition des relations entre les classes (associations, héritages).

2.  **Mise en Place de l'Environnement de Développement :**
    *   Installation et configuration des outils nécessaires (IDE, JDK, etc.).
    *   Création du dépôt Git pour le versionnage du projet.
    *   Organisation du projet en modules/packages selon l'architecture choisie.

3.  **Début de l'Implémentation :**
    *   Codage des premières versions des classes `Category`, `Course`, `Session`.
    *   Mise en place des interfaces pour les Design Patterns `Observer` et `State`.
    *   Rédaction de tests unitaires pour les fonctionnalités de base.

**Objectifs pour la prochaine séance :**
*   Poursuivre l'implémentation des classes restantes du modèle.
*   Intégrer les Design Patterns dans le code.
*   Commencer à travailler sur la couche `Controller` pour la logique métier.
