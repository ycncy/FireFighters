<br/>
<p align="center">
  <a href="https://github.com/ycncy/FireFighters">
    <img src="https://png.pngtree.com/png-clipart/20211031/original/pngtree-cute-handdraw-cartoon-fireman-illustrations-png-image_6894191.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">Fire Fighters</h3>

</p>



## À propos du projet

Le but de ce projet est d'implémenter un proto-simulateur d'automate cellulaire. À chaque tour, chaque pompier éteindra soit tous les feux autour de lui soit se dirigera vers le feu le plus proche et éteindra ensuite le feu autour de lui. Le feu de son côté s'étendra autour de lui tous les deux tours. Le but est de voir en combien de tours les pompiers arriveront à éteindre le feu.

<strong>Le but principal de ce projet est de rendre du code qui respecte les principes SOLID.</strong>

## Les tâches à réaliser à partir de la base du projet

- <strong>Tâche 1 : </strong><br>Ce modèle devra être étendu avec les fonctionnalités supplémentaires :
   - Des nuages qui se déplacent aléatoirement et qui éteignent les feux.
   - Des pompiers motorisés qui peuvent se déplacer de deux cases.
   - Des cases montagnes qui en sont pas franchissable par le feu ni par les pompiers.
   - Des cases routes qui ne sont franchissables que par les pompiers.
   - Des cases rocailles sur lesquelles le feu mets quatre tours à se propager.
<br><br>
- <strong>Tâche 2 : </strong><br>Implémenter un autre modèle de votre choix avec de nouvelles règles, mais que vous
garderez simples :
   - Pierre-feuille-ciseau : si un élément pierre atteint une case avec un ciseau, le ciseau est détruit etc... le premier type à éliminer toutes ses cibles gagne.

## Description du code
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

**Patrons de conception utilisés :**
* **Visitor :** Utilisant l'interface `PaintingVisitor` et `ConcretePaintingVisitor` pour dessiner les entités sur la grille.
Et une deuxième implémentation avec l'interface `ObstacleVisitor` pour vérifier si une `Entity` peut ou non se déplacer vers
une case, toutes les `Entity` implémentent l'interface `ObstacleVisitor`.


* **Template Method :** Utilisant la classe `Grid` et ses classes filles `FireFightersGrid` et `RpsGrid`.


* **Strategy :** Utilisé par `Model`, on délègue l'initialisation et l'actualisation des entités et des obstacles à
deux interfaces correspondant à deux implémentations de Strategy : `ObstacleManager` et `EntityManager`.
****

## Langage et outil utilisés

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)

💻 IDE : <br>
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)

## Contribteurs

* [Yacine Talhaoui](https://github.com/ycncy/)
* [Mattéo Lizero](https://github.com/AngryWalrusss)
