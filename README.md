# ProjetRPG
## Création d'un jeu RPG sous forme de ligne de texte

### Menu
- Créer un personnage
- Jouer --> 3 donjons, choix du donjon, choix de 3 personnages
- Voir ses personnages
- Optionnel : Importer des personnages (fichier avec 5 personnages de 5 classes diff)

### 1 - Créer un Personnage
- Nom
- Classe (Tank, Mage, Guerrier, Healer, Voleur)

#### Caractéristiques de base (attributs du personnage)
- PV
- Attaque
- Défense
- Energie : pour utiliser des capacités
- Esquive : nombre à 100 max, pourcentage chance d’esquiver une ATQ
- Précision : nombre à 100 max, pourcentage chance de réussir une ATQ
- Utilisation d'une capacité : soigner, boost ATQ, boost esquive, précision, bouclier…

#### Classe : influence les caractéristiques de base
-	Healer : + de PV | Capacité de soin (choix d'UN perso à heal, restaure selon 20% des PV max du healer)
-	Tank : + de DEF et de PV | Capacité bouclier (=> esquive de chacun = 100 pendant 1 tour)
-	Voleur : + d’esquive et de précision, - d'ATQ | Capacité voler des PV à un ennemi
-	Mage : + d'ATQ (moins que guerrier), + d’énergie | Capacité peut attaquer tous les ennemis à la fois (dgt divisés par 2)
- Guerrier : + d'ATQ et de précision, - d'esquive, de PV et de DEF | Capacité attaquer deux fois de suite (double valeurAttaque)

### 2 - Parcourir un Donjon
- Un Donjon est un ensemble de Salles (3 salles)
- Une Salle contient plusieurs Ennemis (ennemis lvl random ou bien de plus en plus forts)
- Combat contre l'ennemi tour à tour :
  - Victoire = Récompense (restauration PV, objets...)
  - Défaite de tous les héros = Fin du jeu
- Lorsqu'on a fini une salle, on passe à la suivante jusqu'à la dernière salle du donjon qui nous fera affronter un Boss

#### Après un combat
- Récompense : Récupération de 30% de nos PV, OU gain d’un Objet
- Objet :
  -	Equipement qui augmente une caractéristique (à voir si on implémente ou non, à équiper après avoir fini une salle)
  -	Ou bien un Consommable (potion de soin (pour soi), potion régénération d'un allié, potion énergisante)

### Combat tour à tour :
-	Choix d’actions (une action par tour) : attaquer, utiliser une capacité, utiliser un objet
-	Valeur d'une ATQ : La différence entre notre ATQ et la DEF de l'adversaire
-	L’ennemi doit agir selon un algorithme :
  - 70% de chance d’attaquer (héros random)
  - 30% d’utiliser une ATQ spéciale (Le boss attaque tous les héros en même temps, comme le mage)
-	Ennemis vaincus ou personnages vaincus

Donjon fini : enchaînement au prochain donjon
