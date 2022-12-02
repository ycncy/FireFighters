# **Projet Programmation et Conception**
***
#### **Membres du groupe :** TALHAOUI Yacine et LIZERO Matteo
***
### **Explications  et indications générales**
****
**Il y a trois packages dans le projet :**
* `generalstructure` : Correspond aux classes "générales", notre but était de créer une structure
**Model/Vue/Controller** qui pourra être utilisé pour n'importe quel modèle d'automate cellulaire. Ainsi
ce package contient : essentiellement des classes abstraites ou des interfaces qui pourront être étendues
ou implémentées pour chaque modèle, les classes concrètes `Model`, `Position` et `App` et le 
package de l'implémentation du patron de conception `Visitor` pour peindre les cases. La classe
`Grid` est abstraite pour pouvoir effectuer des initialisations différentes en fonction de chaque nouveau modèle.

  
* `firefightersgame` et `rockpaperscissors` : Correspondent respectivement à l'implémentation de la tâche 1 et 
de la tâche 2 du projet, ces packages contiennent toutes les classes concrètes qui étendent ou implémentes les
classes et les interface de la structure générale.

Nous n'avons pas séparé les classes utilisées pour l'implémentation de patron de conception dans des packages
séparés, car la structure actuelle semble être la plus claire pour nous.

**Patrons de conception utilisés :**
* **Visitor :** Utilisant l'interface `PaintingVisitor` et `ConcretePaintingVisitor` pour dessiner les entités sur la grille.
Et une deuxième implémentation avec l'interface `ObstacleVisitor` pour vérifier si une `Entity` peut ou non se déplacer vers
une case, toutes les `Entity` implémentent l'interface `ObstacleVisitor`.


* **Template Method :** Utilisant la classe `Grid` et ses classes filles `FireFightersGrid` et `RpsGrid`.


* **Strategy :** Utilisé par `Model`, on délègue l'initialisation et l'actualisation des entités et des obstacles à
deux interfaces correspondant à deux implémentations de Strategy : `ObstacleManager` et `EntityManager`.
****

### Fonctionnalité manquante
***
Nous n'avons pas réussi à ajouter la rocaille au projet, les classes implémentant l'obstacle et son `Manager` sont 
présentes dans le dossier source, mais le comportement n'a pas été implémenté. Nous n'avons pas trouvé de moyen respectant
au mieux les principes SOLID pour modifier le comportement du feu lorsqu'il est sur une rocaille.