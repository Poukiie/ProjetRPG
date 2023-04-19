# ProjetRPG
## Création d'un jeu RPG sous forme de ligne de texte

### 1 - Créer un Personnage
- Nom
- Classe (Prêtre, Tank, Mage, Guerrier, Healer, Voleur etc.)

#### Caractéristiques de base (attributs du personnage)
- PV
- Attaque
- Défense (j’ai 5 de DEF, l’ennemi tape 12, je me prends 7 de DGT, différence)
- Energie : pour utiliser des capacités
- Esquive : nombre à 100 max, pourcentage chance d’esquiver une ATQ
- Précision : nombre à 100 max, pourcentage chance de réussir une ATQ
- Capacité : soigner, boost ATQ, boost esquive, précision, bouclier…

#### Classe : influence les caractéristiques de base
Certaines capacités sont spécifiques à une ou plusieurs classes
-	Healer : plus de PV, capacité de soin
-	Tank : plus de DEF, plus lent, pas de capacité de soin, capacité bouclier
-	Voleur : plus d’esquive
-	Mage : peut attaquer deux fois, plus d’énergie…
- Guerrier : plus d'ATQ

### 2 - Parcourir un Donjon
- Un Donjon est un ensemble de Salles
- Une Salle contient plusieurs Ennemis (ennemis lvl random ou bien de plus en plus fort)
- Combat contre l'ennemi tour à tour :
  - Victoire = Récompense (gagner XP, lvl up avec rewards, objets...)
  - Défaite : Fin du jeu
- Lorsqu'on a fini une salle, on passe à la suivante jusqu'à la dernière salle du donjon qui nous fera affronter un Boss

#### Après un combat
- Récompense : Récupération de 30% de nos PV OU gain d’un Objet
- Objet :
  -	Equipement qui augmente une caractéristique
  -	Ou bien un Consommable (potions qui permet d’attaquer 2 fois à chaque tour, potion de soin…)

### Combat tour à tour :
-	Choix d’actions (une action par tour) : attaquer, utiliser un objet, fuite
-	L’ennemi doit agir selon un algorithme
  - 70% de chance d’attaquer
  - 20% chance de soigner (à condition que ses PV soient bas par exemple)
  - 10% d’utiliser une ATQ spéciale
-	Ennemis vaincus ou personnages vaincus

Donjon fini : retour à la map et choix d’un donjon (marqué ceux qui ont été complétés)
