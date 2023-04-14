# Jeu du Pendu

## Exécution du jeu et principe de fonctionnement 
Pour lancer le jeu, il faut exécuter le main qui se situe dans la classe `HangmanGame`.  
Le principe est simple : le jeu choisi un mot et vous devez le deviner en proposant des lettres. 
Si la proposition est bonne, la lettre est affichée dans le mot masqué, sinon le pendu sera de 
plus en plus proche de la mort (on aimerait éviter, c'est embêtant à nettoyer après). Si le pendu 
est complètement pendu, c'est la défaite, si vous devinez le mot, c'est la victoire.  

## Patrons de conception utilisés dans le projet 
#### 1. Patron MVC
Le patron MVC divise le programme en trois parties principales :  

Modèle (Model) : Le modèle représente les données et la logique métier du programme. Dans ce cas, `HangmanModel` contient les informations sur le mot à deviner, les tentatives, et les lettres déjà devinées. Le modèle est responsable de la gestion de l'état du jeu et de l'évaluation des tentatives de l'utilisateur pour deviner les lettres.

Vue (View) : La vue est responsable de l'affichage et de la présentation des informations à l'utilisateur. Dans ce programme, `HangmanView` est une interface qui définit les méthodes nécessaires pour afficher les messages et les informations sur le jeu. La classe `ConsoleHangmanView` est une implémentation spécifique de cette interface pour afficher le jeu dans la console. En séparant la vue, il serait facile de créer d'autres implémentations de la vue pour différentes interfaces utilisateur, comme une interface graphique, sans modifier la logique métier.

Contrôleur (Controller) : Le contrôleur fait le lien entre le modèle et la vue et gère les interactions entre eux. Dans ce programme, `HangmanController` est responsable de gérer le déroulement du jeu en utilisant les méthodes de la vue pour afficher les informations et les méthodes du modèle pour mettre à jour l'état du jeu.

L'utilité du patron MVC dans ce programme est de séparer clairement les responsabilités entre ces trois parties, facilitant la compréhension du code, la maintenance et l'extension du programme avec de nouvelles fonctionnalités ou interfaces utilisateur.
#### 2. Patron Singleton 

L'objectif principal de l'utilisation du singleton ici est d'assurer que le programme n'ait qu'une seule instance de cette classe, qui gère la configuration et l'exécution du jeu.

Voici les avantages de l'utilisation du singleton dans ce programme :

Accès centralisé : Le singleton permet d'accéder à l'instance unique de `HangmanGame` de n'importe où dans le programme. Cela peut être utile pour partager des informations ou des états communs entre différentes parties du code.

Contrôle sur les instances : Le singleton garantit qu'il n'y a qu'une seule instance de `HangmanGame` dans le programme, évitant ainsi les problèmes potentiels causés par la présence de multiples instances. Cela est particulièrement utile si l'on souhaite s'assurer qu'il n'y a qu'un seul jeu en cours à tout moment.

Facilité d'utilisation : Le singleton permet d'éviter de passer explicitement des instances de `HangmanGame` entre les différentes parties du programme. Au lieu de cela, les parties du code peuvent accéder directement à l'instance unique via le singleton.
#### 3. Patron Strategy

Dans ce programme de jeu de pendu, le patron Strategy est utilisé pour gérer différentes méthodes d'entrée utilisateur. L'interface `InputStrategy` définit une méthode `getInput()` pour obtenir l'entrée de l'utilisateur sous la forme d'un caractère. La classe `ConsoleInputStrategy` est une implémentation spécifique de cette interface pour obtenir l'entrée de l'utilisateur à partir de la console.

L'utilité du patron Strategy dans ce programme est de :

Flexibilité : Il permet de facilement ajouter ou modifier des méthodes d'entrée utilisateur sans affecter le reste du code. Par exemple, si vous voulez ajouter une nouvelle méthode d'entrée utilisateur, comme lire à partir d'un fichier ou d'une interface graphique, vous pouvez simplement créer une nouvelle classe qui implémente l'interface `InputStrategy`.

Évolutivité : Le patron Strategy rend le programme plus évolutif en permettant l'ajout d'autres méthodes d'entrée utilisateur sans modifier le code existant. Cela facilite le développement et la maintenance du programme.

Testabilité : Le patron Strategy permet d'améliorer la testabilité du programme en fournissant un moyen d'isoler les différentes parties du code pour les tests. Par exemple, vous pouvez créer une implémentation de test de `InputStrategy` qui fournit des entrées pré-définies pour vérifier si le programme fonctionne correctement avec différentes entrées.

## Tests
Des jeux de tests sont disponibles dans le projet. 