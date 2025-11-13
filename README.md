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

Et la classe ``
