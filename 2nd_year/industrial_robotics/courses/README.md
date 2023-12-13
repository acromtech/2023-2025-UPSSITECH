# Fiche de Résumé pour l'examen Modélisation Robotique du 5 décembre 2023

## Les attendus
- **MGD** : repères, paramètres DHM, matrices élémentaires, questions de compréhension.
- **MDD** : savoir calculer une jacobienne (pas de jacobienne analytique). Calculer une jacobienne (ou une jacobienne préférentielle qui utilise le même raisonnement et des formules similaires, voir poly).
- **MDI** : savoir calculer un MDI et/ou appliquer condition de compatibilité
- **Redondance**
- **Dynamique** : pas de calcul de la matrice C(q, dq) qui est trop complexe (calcul des dérivées) mais question sur A(q) ou G(q) ou de compréhension
- **Génération de mouvement**

# Généralités sur les Bras Manipulateurs

## Tâche Robotique

- Une tâche robotique englobe le placement d'objets dans l'environnement et la manipulation des repères attachés à ces objets.
- Il est nécessaire de définir un formalisme pour faciliter les opérations de changement de repères et savoir définir un repère attaché à un objet.
- Conventions
   - Utilisation de repères directs (règle de la main droite).
   - Sens positif pour une rotation dans le sens trigonométrique.

## Pourquoi Construire des Modèles ?

- L'utilisateur décrit la tâche robotique sous forme de mouvements et d'actions que doit effectuer l'outil porté par le robot.
- Le robot doit coordonner le mouvement de l'ensemble de ses liaisons pour réaliser le mouvement désiré tout en respectant les contraintes liées à sa mécanique.
- La tâche est décrite dans l'espace opérationnel (X), tandis que le robot est contrôlé dans l'espace articulaire (Q). Il faut donc construire des modèles entre ces espaces.
   - Modèle géométrique direct ou inverse
   - Modèle différentiel direct ou inverse
   - Modèle dynamique direct ou inverse

## Définitions

- **Structure Mécanique Articulée (SMA)**
   - Assemblage de n corps rigides reliés par des liaisons.
   - Chaque liaison est caractérisée par une coordonnée généralisée $q_i$ (espace généralisé Q).
- **Organe Terminal (OT)**
   - Dernier corps destiné à manipuler l'outil.
   - Interface permettant au robot d'agir sur son environnement.
- **Type d'assemblage**
   - Chaînes série (simple) : 1 antécédent et 1 successeur.
   - Chaînes arborescentes : 1 antécédent et 1 ou plusieurs successeurs.
   - Chaînes complexes (parallèles) : 1 ou plusieurs antécédent et 1 ou plusieurs successeurs. (Dans ce cours, limité aux structures séries).
- **Situation**
   - position + orientation d'un corps par rapport à un repère de référence.
- **Liaison**
   - lie deux corps successifs en limitant le nombre de degrés de liberté (ddl) de l'un par rapport à l'autre.
- **Espace Généralisé (Q)**
   - Ensemble de toutes les coordonnées généralisées d'un bras manipulateur. 
   - Chaque coordonnée généralisée représente la position ou l'angle d'une liaison dans le système. Pour un bras manipulateur avec N liaisons, il y a N coordonnées généralisées. 
   - Le vecteur $q = (q_1, q_2, ..., q_n)^T$ représente ces N coordonnées généralisées sous forme d'un vecteur colonne.
- **L'espace opérationnel (X)**
   - Espace dans lequel l'organe terminal (OT) d'un bras manipulateur évolue. 
   - Là où se trouvent les positions et orientations de l'outil ou de l'extrémité du robot.
- **Degré de liberté (ddl)** 
   - Nombre de paramètres indépendants nécessaires pour décrire complètement la position et l'orientation de l'organe terminal.
   - Peuvent inclure les coordonnées de position (par exemple, x, y, z) et les paramètres d'orientation (par exemple, angles d'Euler).
- **Redondance**
   - Un bras manipulateur est redondant si D < M (nombre de ddl de l'OT inférieur au nombre de ddl du bras).
- **Configuration Singulière**
   - Dans certaines configurations, le nombre de ddl de l'OT peut être inférieur à D, conduisant à des configurations singulières.
- **Espace de Travail d'un Robot**
   - Ensemble des positions et orientations accessibles par un repère lié à l'organe terminal lorsque les paramètres articulaires prennent toutes les valeurs permises.
      - Espace de travail primaire.
      - Dexterous workspace : Positions accessibles avec toutes les orientations possibles.
- **Caractéristiques des Bras Manipulateurs**
   - **Volume de Travail** : Étendue des positions et orientations que le robot peut atteindre.
   - **Charge Utile** : Capacité maximale de charge que le robot peut manipuler.
   - **Vitesse et Accélérations Maximales** : Contraintes sur la vitesse et les accélérations pour respecter le temps de cycle.
   - **Précision** : Écart moyen entre la position réelle et la position souhaitée.
   - **Répétabilité** : Dispersion des positions répétées pour la même tâche.


# Modèle Géométrique Direct (MGD)

**Objectif du MGD**
- Cherche le modèle permettant de passer de l’espace généralisé Q à l’espace opérationnel X.
- X peut décrire la situation de l’OT ou de l’outil.
- Calcul à réaliser : X = F(q).

**Méthodoologie**
1. **Calcul de T0,n(q) :** Ne dépend que du robot.
2. **Calcul de X en fonction de T0,n(q) :** Ne dépend que du choix des coordonnées opérationnelles.

## Etape 1 : Calcul de T0,n
### 1.1 Mettre en place les repères
   - Pour $R_0$ : imposé ou choisi selon la convention ($x0$ perpendiculaire à la liaison 1 et $z0$ porté par l’axe de la liaison)
   - Pour $R_{i-1}$ avec $i=2 ... n$
      1. Numéroter les corps de $0$ à $n$ et les liaisons de $1$ à $n$
      2. Mettre en place les axes des liaisons $\Delta_i$ → DIRECTION DU MOUVEMENT
      3. Mettre en place les perpendiculaires $\perp_{i-1},i$ communes à $\Delta_{i-1}$ et $\Delta_i$ → GÉOMÉTRIE
      4. $O_{i-1}$ est le point d’intersection entre $\Delta_{i-1}$ et $\perp_{i-1},i$
      5. $x_{i-1}$ porté par $\perp_{i-1},i$ et orienté de $\Delta_{i-1}$ vers $\Delta_i$. Si $\Delta_{i-1}$ vers $\Delta_i$ sont concourantes, convention (AVANT, DROITE, HAUT).
      6. $z_{i-1}$ porté par $\Delta_{i-1}$ et orienté selon la convention (AVANT, DROITE, HAUT)
      7. ($y_{i-1}$ donné par le produit vectoriel de $z_{i-1}$ par $x_{i-1}$)
   - Pour $R_n$
      - $O_n$ est choisi arbitrairement sur la liaison.
      - $z_n$ est porté par la liaison.
      - $x_n$ est choisi, si possible, dans le plan défini par l’axe de la liaison $n$ et par le point $O_{n+1}$ (point particulier de l’OT).

### 1.2 Constuire le tableau des paramètres de DHM

<div align="center">

| $i$   | $1$   | $2$   | $3$   | ... | $n$   |
| --- | --- | --- | --- | --- | --- |
| $\sigma_i$  | $\sigma_1$  | $\sigma_2$  | $\sigma_3$  | ... | $\sigma_n$  |
| $a_{i-1}$| $a_0$  | $a_1$  | $a_2$  | ... | $a_{n-1}$|
| $\alpha_{i-1}$| $\alpha_0$  | $\alpha_1$  | $\alpha_2$  | ... | $\alpha_{n-1}$|
| $r_i$  | $r_1$  | $r_2$  | $r_3$  | ... | $r_n$  |
| $\theta_i$  | $\theta_1$  | $\theta_2$  | $\theta_3$  | ... | $\theta_n$  |
| $q_{i fig}$  | $q_1$  | $q_2$  | $q_3$  | ... | $q_n$  |

</div>

- $i$ : Numéro du corps
- $\sigma_i$ : Type de liaison ($1$ pour liaison prismatique, $0$ pour liaison rotoïde)
- $a_{i-1}$ : $dist(O_{i-1},Oi)$ suivant l'axe $X_{i-1}$
- $\alpha_{i-1}$ : $ang(Z_{i-1},Zi)$ selon l'axe $X_{i-1}$
- $r_i$ : $dist(O_{i-1},Oi)$ suivant l'axe $Z_{i-1}$
- $\theta_i$ : $ang(X_{i-1},Xi)$ selon l'axe $Z_{i-1}$
- $q_i$ : $q_i=\theta_i$ si $\sigma_i=0$ ou $q_i=r_i$ si $\sigma_i=1$

### 1.3 Construire les matrices $T_{i-1,i}$
A l’aide de la matrice générale de passage entre repères associées aux paramètres de DHM.

$$
T_{i-1,i} =
\begin{bmatrix}
\cos(\theta_i) & -\sin(\theta_i) & 0 & a_{i-1} \\
\cos(\alpha_{i-1}) \sin(\theta_i) & \cos(\alpha_{i-1}) \cos(\theta_i) & -\sin(\alpha_{i-1}) & -r_i \sin(\alpha_{i-1}) \\
\sin(\alpha_{i-1}) \sin(\theta_i) & \sin(\alpha_{i-1}) \cos(\theta_i) & \cos(\alpha_{i-1}) & r_i \cos(\alpha_{i-1}) \\
0 & 0 & 0 & 1 \\
\end{bmatrix}
$$

*Note : Pour la configuration de la figure vérifier chaque matrice. Cette étape permet de trouver la quasi totalité des erreurs (placement de repères, écriture du tableau ou de la matrice).*

### 1.4 Calculer $T_{0,n}$

Pour calculer la transformation $T_{0,n}(q)$ d'un bras manipulateur, on utilise la relation $T_{0,n}(q)= T_{0,1}(q_1) \cdot T_{1,2}(q_2) \cdot \ldots \cdot T_{n-1,n}(q_n)$. Cette transformation peut être représentée sous forme matricielle comme suit :

$$
T_{0,n}(q) = \begin{bmatrix}
t_{11} & t_{12} & t_{13} & t_{14} \\
t_{21} & t_{22} & t_{23} & t_{24} \\
t_{31} & t_{32} & t_{33} & t_{34} \\
0 & 0 & 0 & 1
\end{bmatrix}
= \begin{bmatrix}
R_{0,n} & P_{0,n} \\
0 & 1
\end{bmatrix}
$$

**Attention**
- Ne pas calculer la deuxième colonne de $T_{0,n}(q)$
- Calculer les produits de la **droite vers la gauche**.
- Regrouper les rotations consécutives.
- Dès qu'un coefficient apparaît, le mémoriser dans une variable intermédiaire $\Delta_{i-1}$.

Une fois cette matrice obtenue, la situation du repère $R_n$ en fonction des coordonnées généralisées $q_i$ est calculée. Il reste ensuite à déterminer la transformation rigide pour passer du repère $R_n$ au repère de l'organe terminal (OT).

## Calcul de $X$
(...)

# Modèle Différentiel Direct (MDD)

Le Modèle Différentiel Direct (MDD) est une représentation dynamique qui lie les mouvements des coordonnées de configuration $ q $ à ceux des coordonnées opérationnelles $X$. Il fait intervenir le temps, mais ne prend pas en compte les effets dynamiques tels que les masses, les frottements, ou les inerties.

**Utilité du MDD :**
- **Analyse du Comportement :** Permet d'analyser le comportement du robot, y compris la détection de singularités et l'évaluation du domaine de travail.
- **Commande :** Utilisé dans le contexte de la commande du robot, notamment pour la commande référencée tâche.
- **Relation Statique :** Établit une relation statique entre les actions extérieures et les couples moteurs.

## Définition de la Jacobienne

Le Modèle Géométrique Direct (MGD) traduit la fonction $q = (q_1, ..., q_n)^{T}$ vers $X = (x_1, ..., x_m)^{T} = f(q) $, où les $ f_i $ sont des fonctions non-linéaires complexes.

Le Modèle Différentiel Direct (MDD) est la différentielle du MGD :
$$
\frac{dX}{dt}=
\begin{bmatrix}
\frac{dx_1}{dt} \\
\vdots \\
\frac{dx_m}{dt}
\end{bmatrix}
=
\begin{bmatrix}
\frac{\partial f_1}{\partial q_1} & \dots & \frac{\partial f_1}{\partial q_n} \\
\vdots & \ddots & \vdots \\
\frac{\partial f_m}{\partial q_1} & \dots & \frac{\partial f_m}{\partial q_n}
\end{bmatrix}
\begin{bmatrix}
\frac{dq_1}{dt} \\
\vdots \\
\frac{dq_n}{dt}
\end{bmatrix} 
= J(q) \cdot \frac{dq}{dt}
$$

Où $J(q)$ est la matrice jacobienne de $f$ en $q$.

- Si $\frac{dX}{dt}$ représente la vitesse de l'Effecteur Opérationnel (OT), la matrice $J(q)$ est appelée la **jacobienne analytique ($ J_a(q) $)**, étant la dérivée analytique du MGD. Ce calcul dépend du choix des coordonnées pour le MGD.
  
- Si $\frac{dX}{dt}$ représente la vitesse linéaire du point $O_n$ et la vitesse de rotation du repère $R_n$ par rapport au repère fixe $R_0$, la matrice $J(q)$ est appelée la **jacobienne géométrique** ou simplement la **jacobienne**.

Le calcul de $J(q)$ dépend explicitement de $q$. Notez que la matrice $J(q)$ peut ne pas être carrée ni inversible dans tous les cas.

## Méthodes de calcul du MDD

Le calcul du Modèle Différentiel Direct (MDD) peut être effectué de différentes manières :

1. **Différentiation du MGD :** C'est une méthode simple lorsque le manipulateur est petit (n petit), mais elle peut devenir complexe pour des manipulateurs plus grands (n grand).

2. **Méthode directe :** Cette méthode utilise un schéma similaire à celui du Modèle Géométrique Direct (MGD). On sépare la partie robot du choix des coordonnées de l'Effecteur Opérationnel (OT), puis on calcule :
    - La vitesse linéaire du point $O_n$ et la vitesse de rotation du repère $R_n$ par rapport au repère de base à partir de la jacobienne géométrique $J_g$.
    - La vitesse de l'OT en fonction de $J_g$ et du choix des coordonnées de situation utilisé.

## Jacobienne (géométrique)

Pour calculer la **vitesse linéaire du point $O_n$** et la **vitesse de rotation du repère $R_n$** par rapport au repère fixe $R_0$, on souhaite exprimer la vitesse opérationnelle $\dot{X}=(\dot{p}, \omega) = (v, \omega)$ en fonction de $\dot{q}$.

### Relations cinématiques pour une liaison

On examine l'effet du mouvement de la liaison $i$ sur les autres liaisons en considérant que seule la liaison $i$ bouge, les autres étant fixes.

<div align="center">

| **Type de Liaison** | **Prismatique**   | **Rotoïde**  | **Détail** |
|----------------------|----------------|-----------------|----------------|
| **Vitesse Linéaire $\dot{p}_i$** | $\dot{p}_i = \dot{q}_i \cdot z_i$    | $\dot{p}_i = \dot{q}_i \cdot (z_i \times p_{i,n})$ |Pour une liaison prismatique, la vitesse linéaire du point $O_n$ ($\dot{p}_i$) est donnée par $\dot{q}_i$ multiplié par la direction de la liaison $z_i$, et la vitesse de rotation $\omega_i$ est nulle. |
| **Vitesse de Rotation $\omega_i$** | $\omega_i = 0$   | $\omega_i = \bar{\sigma}_i \cdot (z_i \cdot \dot{q}_i)$  | Pour une liaison rotoïde, la vitesse linéaire du point $O_n$ ($\dot{p}_i$) est donnée par $\dot{q}_i$ multiplié par le produit vectoriel de la direction de la liaison $z_i$ et du vecteur reliant $O_n$ à $P_{i,n}$ ($ p_{i,n}$), et la vitesse de rotation $\omega_i$ est donnée par $\dot{q}_i$ multiplié par la direction de la liaison $z_i$.|

</div>

On utilise le symbole $\sigma_i$ (et son complémentaire $\bar{\sigma}_i = 1 - \sigma_i$ pour une liaison P / R) pour exprimer ces relations de manière compacte :

$$\boxed{\dot{p}_i = (\sigma_i z_i + \bar{\sigma}_i (z_i \times p_{i,n})) \dot{q}_i, \quad \omega_i = \bar{\sigma}_i \cdot (z_i \cdot \dot{q}_i)}$$

### Calcul de la Jacobienne (géométrique)

On calcule séparément la vitesse linéaire du point $O_n$ et la vitesse de rotation du repère $R_n$ en utilisant le principe de superposition des vitesses :

$$\dot{p} = \sum_{i=1}^{n} (\sigma_i z_i + \bar{\sigma}_i z_i \times p_{i,n}) \dot{q}_i, \quad \omega = \sum_{i=1}^{n} \bar{\sigma}_i z_i \cdot \dot{q}_i$$

Ces relations peuvent être écrites de manière matricielle : 

$$ \begin{bmatrix}\dot{p} \\ \omega \end{bmatrix} = J_g(q) \dot{q} = \begin{bmatrix} J_P \\ J_O \end{bmatrix} \dot{q} = \begin{bmatrix} J_{P1} & J_{P2} & \ldots & J_{Pn} \\ J_{O1} & J_{O2} & \ldots & J_{On} \end{bmatrix} \dot{q} $$

Avec les blocs de la jacobienne définis comme suit :

<div align="center">

| Liaison Prismatique                      | Liaison Rotoïde                           |
|-----------------------------------------|------------------------------------------|
| $J_{Pi}=\begin{bmatrix} z_i \\ 0 \end{bmatrix}$ | $J_{Pi}=\begin{bmatrix} z_i \times (p_{i,n} - p_i) \\ z_i \end{bmatrix}$ |

</div>

Plus génériquement : 
$$ J(q) = \begin{bmatrix} \sigma_1z_1 + \bar{\sigma}_1 z_1 \wedge O_1O_n & \sigma_2z_2 + \bar{\sigma}_2 z_2 \wedge O_2O_n & \ldots & \sigma_nz_n + \bar{\sigma}_n z_n \wedge O_nO_n \\ \bar{\sigma}_1 z_1 & \bar{\sigma}_2 z_2 & \ldots & \bar{\sigma}_n z_n \end{bmatrix} $$

## Exemple sur un robot RRR

### Consigne

Soit un robot de type $RRR$ avec les matrices homogènes suivantes :

$T_{01}(q_1) = \begin{bmatrix} c_1 & -s_1 & 0 & 0 \\ s_1 & c_1 & 0 & 0 \\ 0 & 0 & 1 & 0 \\ 0 & 0 & 0 & 1 \end{bmatrix}$
$T_{12}(q_2) = \begin{bmatrix} c_2 & -s_2 & 0 & 0 \\ 0 & 0 & -1 & 0 \\ s_2 & c_2 & 0 & 0 \\ 0 & 0 & 0 & 1 \end{bmatrix}$
$T_{23}(q_3) = \begin{bmatrix} c_3 & -s_3 & 0 & a \\ s_3 & c_3 & 0 & 0 \\ 0 & 0 & 1 & 0 \\ 0 & 0 & 0 & 1 \end{bmatrix}$

On récupère les différents termes des matrice de rotations qu'on notera :

Pour $T_{01}$ : 
$x_{1(0)} = \begin{bmatrix} c_1 \\ s_1 \\ 0 \end{bmatrix}$
$y_{1(0)} = \begin{bmatrix} -s_1 \\ c_1 \\ 0 \end{bmatrix}$
$z_{1(0)} = \begin{bmatrix} 0 \\ 0 \\ 1 \end{bmatrix}$
$O_0O_{1(0)} = \begin{bmatrix} 0 \\ 0 \\ 0 \end{bmatrix}$

Pour $T_{12}$ : 
$x_{2(1)} = \begin{bmatrix} c_2 \\ 0 \\ s_2\end{bmatrix}$
$y_{2(1)} = \begin{bmatrix} -s_2 \\ 0 \\ c_2 \end{bmatrix}$
$z_{2(1)} = \begin{bmatrix} 0 \\ -1 \\ 0 \end{bmatrix}$
$O_1O_{2(1)} = \begin{bmatrix} 0 \\ 0 \\ 0 \end{bmatrix}$

Pour $T_{23}$ : 
$x_{3(2)} = \begin{bmatrix} c_3 \\ s_3 \\ 0 \end{bmatrix}$
$y_{3(2)} = \begin{bmatrix} -s_3 \\ c_3 \\ 0 \end{bmatrix}$
$z_{3(2)} = \begin{bmatrix} 0 \\ 0 \\ 1 \end{bmatrix}$
$O_2O_{3(2)} = \begin{bmatrix} a \\ 0 \\ 0 \end{bmatrix}$

### Etape 1 : Mise au point et recherche des différents termes
D'après la formule du cours, pour un robot de type $RRR$ on a donc 
$$ J(q) = \begin{bmatrix} \sigma_1z_1 + \bar{\sigma}_1 z_1 \wedge O_1O_3 & \sigma_2z_2 + \bar{\sigma}_2 z_2 \wedge O_2O_3 &  \sigma_3z_3 + \bar{\sigma}_3 z_3 \wedge O_3O_3 \\ \bar{\sigma}_1 z_1 & \bar{\sigma}_2 z_2 & \bar{\sigma}_3 z_3 \end{bmatrix} $$

D'après la convention $1$ pour liaison prismatique et $0$ pour liaison rotoïde on obtient la matrice suivante
$$ J(q) = \begin{bmatrix}  z_1 \wedge O_1O_3 & z_2 \wedge O_2O_3 & z_3 \wedge O_3O_3 \\ z_1 & z_2 & z_3 \end{bmatrix} $$

Donc si on cherche $J(q)_{(0)}$
$$ J(q)_{(0)} = \begin{bmatrix} z_{1(0)} \wedge O_1O_3 & z_{2(0)} \wedge O_2O_3 & z_{3(0)} \wedge O_3O_3 \\ z_{1(0)} & z_{2(0)} & z_{3(0)} \end{bmatrix} $$

- **On cherche $z_{1(0)}$**
   - $z_{1(0)}=\begin{bmatrix} 0 & 0 & 1 \end{bmatrix}^T$
- **On cherche $z_{2(0)}$**
   - $z_{2(1)}=\begin{bmatrix} 0 & -1 & 0 \end{bmatrix}^T = -y_{1(0)}$
   - $z_{2(0)}=\begin{bmatrix} s_1 & -c_1 & 0 \end{bmatrix}^T$
- **Inutile de chercher $z_{3(0)}$ car $O_3O_3=0$, ainsi $z_{3(0)} \wedge O_3O_3=\begin{bmatrix} 0 \\ 0 \\ 0 \end{bmatrix}$**
- **On cherche $O_2O_{3(0)}$ (calcul des longueur de droite à gauche)**
   - $O_2O_{3(0)}=\begin{bmatrix} a \\ 0 \\ 0 \end{bmatrix}=a.x_{2(0)} \rightarrow x_{2(0)}=???$
      - $x_{2(1)}=\begin{bmatrix} c_2 \\ 0 \\ s_2 \end{bmatrix}=c_2.x_1+s_2.z_1$
      - $x_{2(0)}=c_2.x_{1(0)}+s_2.z_{1(0)}=c_2\begin{bmatrix} c_1 \\ s_1 \\ 0 \end{bmatrix}+s_2\begin{bmatrix} 0 \\ 0 \\ 1 \end{bmatrix}=\begin{bmatrix} c_1c_2 \\ s_1c_2 \\ s_2 \end{bmatrix}$
      - $O_2O_{3(0)}=a\begin{bmatrix} c_1c_2 \\ s_1c_2 \\ s_2 \end{bmatrix}$
- **On cherche $O_1O_{3(0)}$**
   - $O_1O_{3(0)}=O_1O_{2(0)}+O_2O_{3(0)}=\begin{bmatrix} 0 \\ 0 \\ 0 \end{bmatrix}+\begin{bmatrix} a \\ 0 \\ 0 \end{bmatrix}=0+a.x_{2(0)}=a\begin{bmatrix} c_1c_2 \\ s_1c_2 \\ s_2 \end{bmatrix}$

### Etape 2 : Calcul des produits vectoriels
Les termes de la matrice jacobienne correspondent aux produits vectoriels des vecteurs $z_i$ avec les vecteurs de translation $O_iO_{3(0)}$. Les produits vectoriels peuvent être calculés comme suit :

1. Pour la première colonne de la matrice jacobienne :
   - $z_{1(0)} \wedge O_{1}O_{3(0)} = \begin{bmatrix} 0 \\ 0 \\ 1 \end{bmatrix} \wedge a\begin{bmatrix} c_1c_2 \\ s_1c_2 \\ s_2 \end{bmatrix} = \begin{bmatrix} 0 \times s_2 - 1 \times as_1c_2 \\ 1 \times ac_1c_2 - 0 \times s_2 \\ 0 \times s_1c_2 - 0 \times c_1c_2 \end{bmatrix} = \begin{bmatrix} -as_1c_2 \\ ac_1c_2 \\ 0 \end{bmatrix}$
   
2. Pour la deuxième colonne de la matrice jacobienne :
   - $z_{2(0)} \wedge O_{2}O_{3(0)} = \begin{bmatrix} s_1 \\ -c_1 \\ 0 \end{bmatrix} \wedge a\begin{bmatrix} c_1c_2 \\ s_1c_2 \\ s_2 \end{bmatrix} = \begin{bmatrix} -ac_1s_2 \\ -as_1s_2 \\ as_1s_1c_2+ac_1c_1c_2 \end{bmatrix} = \begin{bmatrix} -ac_1s_2 \\ -as_1s_2 \\ ac_2(s_1^2c_1^2) \end{bmatrix} = \begin{bmatrix} -ac_1s_2 \\ -as_1s_2 \\ ac_2 \end{bmatrix}$
   
   *Rappel : d'après les formules trigonométrie : $sin² x + cos² x = 1$*
   
3. Pour la troisième colonne de la matrice jacobienne :
   - $z_{3(0)} \wedge O_{3}O_{3(0)} = \begin{bmatrix} 0 \\ 0 \\ 0 \end{bmatrix}$

### Etape 3 : Construction de la Jacobienne
Ainsi on peut alors construire la Jacobienne tel que :

$$J(q)_{(0)}=\begin{bmatrix} -as_1c_2 & -ac_1s_2 & 0 \\ ac_1c_2 & -as_1s_2 & 0 \\ 0 & ac_2 & 0\end{bmatrix}$$


## Exemple sur un robot RRPRR
Pour un robot de type $RRPRR$, la matrice de la jacobienne $ J(q) $ serait la suivante 

$$ J(q) = \begin{bmatrix} z_1 \wedge O_1O_5 & z_2 \wedge O_2O_5 & z_3 &  z_4 \wedge O_4O_5 & z_5 \wedge O_5O_5 \\ z_1 & z_2 & 0 & z_4 & z_5 \end{bmatrix} $$

Plus précisément et comme $O_5O_5=0$
$$ J(q) = \begin{bmatrix} 
(z_1 \wedge O_1O_5).x & (z_2 \wedge O_2O_5).x & (z_3).x &  (z_4 \wedge O_4O_5).x & 0 \\
(z_1 \wedge O_1O_5).y & (z_2 \wedge O_2O_5).y & (z_3).x &  (z_4 \wedge O_4O_5).y & 0 \\
(z_1 \wedge O_1O_5).z & (z_2 \wedge O_2O_5).z & (z_3).x &  (z_4 \wedge O_4O_5).z & 0 \\
(z_1).x & (z_2).x & 0 & (z_4).x & (z_5).x \\
(z_1).y & (z_2).y & 0 & (z_4).y & (z_5).y \\
(z_1).z & (z_2).z & 0 & (z_4).z & (z_5).z
\end{bmatrix} $$

## Exercice sur un robot PRPRR : Tiré de l'annale d'avril 2022

On considère un robot manipulateur représenté de type $PRPRR$ pour lequel l’opérateur décrit la tâche à l’aide des coordonnées (cartésiennes) de position du point $O_6$ dans le repère $R_0$ et de l’orientation de $R_5$ par rapport à $R_0$ (cosinus directeurs partiels). La modélisation du robot donne les résultats suivants :

Le tableau des **paramètres de DHM** du robot considéré :
<div align="center">

| $i$ | $1$ | $2$ | $3$ | $4$ | $5$ |
| --- | --- | --- | --- | --- | --- |
| $\sigma_i$ | $0$ | $0$ | $0$ | $0$ | $0$ |
| $a_{i-1}$ | $1$ | $0$ | $0$ | $0$ | $0$ |
| $\alpha_{i-1}$ | $0$ | $0$ | $1$ | $0$ | $0$ |
| $r_i$ | $0$ | $0$ | $0$ | $\frac{\Pi}{2}$ | $0$ |
| $\theta_i$ | $q_1$ | $q_2$ | $-\frac{\Pi}{2}$ | $0$ | $-\frac{\Pi}{2}$ |
| $q_{i fig}$ | $0$ | $0$ | $q_3$ | $q_4$ | $0$ |

</div>

Les **matrices de transformation homogène** sont données par les expressions suivantes :
<div align="center">

$T_{01} = \begin{bmatrix} c_1 & -s_1 & 0 & 0 \\ s_1 & c_1 & 0 & 0 \\ 0 & 0 & 1 & 0 \\ 0 & 0 & 0 & 1 \end{bmatrix}$
$T_{12} = \begin{bmatrix} c_2 & -s_2 & 0 & 0 \\ s_2 & c_2 & 0 & 0 \\ 0 & 0 & 1 & 0 \\ 0 & 0 & 0 & 1 \end{bmatrix}$
$T_{23} = \begin{bmatrix} 0 & -1 & 0 & 0 \\ 1 & 0 & 0 & 0 \\ 0 & 0 & 1 & q_3 \\ 0 & 0 & 0 & 1 \end{bmatrix}$

$T_{34} = \begin{bmatrix} c_4 & -s_4 & 0 & 0 \\ s_4 & c_4 & 0 & 0 \\ 0 & 0 & 1 & 0 \\ 0 & 0 & 0 & 1 \end{bmatrix}$
$T_{45} = \begin{bmatrix} c_5 & -s_5 & 0 & 0 \\ s_5 & c_5 & 0 & 0 \\ 0 & 0 & 1 & q_5 \\ 0 & 0 & 0 & 1 \end{bmatrix}$

</div>

Calculer la matrice jacobienne préférentielle $J_{3(2)}(q)$




# Modèle Différentiel Inverse

Déterminer le rang de la matrice jacobienne $J(q)$ à la main peut être accompli en suivant ces étapes :

1. **Écriture de la Matrice Jacobienne :** Commencez par écrire la matrice jacobienne $J(q)$. Elle aura $m$ lignes (correspondant aux degrés de liberté de l'effecteur) et $n$ colonnes (correspondant aux degrés de liberté des articulations).

2. **Calcul des Dérivées Partielles :** Chaque élément de $J(q)$ est une dérivée partielle par rapport à une variable articulaire. Calculez chaque dérivée partielle en utilisant les équations cinématiques qui décrivent la relation entre les coordonnées articulaires $q$ et les coordonnées de l'effecteur $X$.

3. **Élimination des Éventuelles Symétries :** Assurez-vous que les colonnes de $J(q)$ ne présentent pas de dépendances linéaires significatives. Si une colonne est une combinaison linéaire des autres, cela indique une redondance dans les articulations et peut réduire le rang.

4. **Détermination du Rang :** Utilisez des méthodes standard pour déterminer le rang de $J(q)$. Cela peut inclure la réduction de la matrice à sa forme échelonnée réduite par lignes (REF) ou à sa forme échelonnée par blocs (RREF). Le rang est égal au nombre maximum de colonnes linéairement indépendantes dans $J(q)$.

5. **Interprétation :** Comparez le rang obtenu ($r$) avec le nombre de degrés de liberté de l'effecteur ($m$). Si $r = m$, alors la matrice jacobienne est de rang complet, et son inverse existe dans la plupart des régions de l'espace des articulations. Si $r < m$, cela indique une singularité ou une redondance partielle dans le système.

6. **Analyse des Configurations Singulières :** Identifiez les configurations singulières en examinant les valeurs propres ou en analysant les zones de l'espace des articulations où $J(q)$ peut perdre son rang maximal.



# Dynamique

1. **Matrice d'inertie ($A(q)$) :**
   - **Définition :** La matrice d'inertie, souvent notée $A(q)$, représente la distribution des masses et des moments d'inertie du robot par rapport à ses articulations.
   - **Impact :** Elle intervient dans l'équation dynamique $A(q)\ddot{q} + C(q, \dot{q})\dot{q} + G(q) = \tau$, où $\ddot{q}$ est le vecteur des accélérations articulaires, $\dot{q}$ est le vecteur des vitesses articulaires, $C(q, \dot{q})$ est la matrice des termes d'inertie et de Coriolis, $G(q)$ est le vecteur des termes de gravité, et $\tau$ est le vecteur des couples appliqués.

2. **Termes de Coriolis-Centrifuge ($C(q, \dot{q})$) :**
   - **Définition :** Ces termes représentent les forces et les moments générés en raison de la combinaison des mouvements relatifs entre les différentes parties du robot.
   - **Impact :** Ils sont impliqués dans la compensation des forces centrifuges et des effets de Coriolis lors de la planification de trajectoires et du contrôle en boucle fermée.

3. **Termes de Gravité ($G(q)$) :**
   - **Définition :** Ces termes représentent les forces et les moments dus à la gravité.
   - **Impact :** Ils doivent être compensés pour maintenir le robot en équilibre sous l'effet de la gravité.

4. **Équation Dynamique :**
   - **Définition :** L'équation dynamique du robot relie les efforts articulaires ($\tau$) aux mouvements articulaires ($\ddot{q}$) et aux vitesses ($\dot{q}$) à travers l'équation $A(q)\ddot{q} + C(q, \dot{q})\dot{q} + G(q) = \tau$.
   - **Impact :** Comprendre cette équation est crucial pour concevoir des lois de commande robustes et pour planifier des trajectoires dynamiquement réalisables.

5. **Énergie Cinétique et Potentielle :**
   - **Définition :** L'énergie cinétique est liée au mouvement du robot, tandis que l'énergie potentielle est liée à sa position dans un champ gravitationnel.
   - **Impact :** Ces concepts peuvent être utilisés pour analyser l'énergie totale du système et optimiser les performances.

6. **Principes de Conservation :**
   - **Définition :** Les principes de conservation de l'énergie, du moment cinétique, etc., peuvent être appliqués pour analyser le mouvement du robot.
   - **Impact :** Ils fournissent des informations sur la stabilité, la consommation d'énergie et d'autres aspects du comportement dynamique.



# Génération de trajectoires (mouvements)

- Input = $q_0$, $q_f$ , $K_v$, $K_a$
- Output = $\tau$ , $tf$ , $q(t)$, $\dot{q}(t)$, $\ddot{q}(t)$

## Calcul de $t_f$
La vitesse est maximale pour $t=\frac{t_f}{2}$ et ne doit pas dépasser $K_v$

$$t_{Kv}mimimal = \frac{2}{3}.\frac{\Delta q}{K_v}$$

L’accélération est maximale pour $t = 0$ et $t = t_f$ et ne doit pas dépasser $\pm Ka$
$$t_{Ka}mimimal = \sqrt{\frac{6\Delta q}{K_a}}$$

$$t_f=max(tK_v,tK_a)$$

Sur un robot il faut faire ce calcul pour tous les axes $i$ et prendre $t_f = max(t_{f_i})$

## Exemple 1 : mouvement linéaire en position

$$t_1=\frac{L}{V_M}$$
$$t_f=\frac{L}{V_M}+\frac{V_M}{A_M}$$

- Pour $0 \leq t \leq t_1$, la fonction $s(t)$ est définie comme $\frac{A_M}{2}\cdot t^2$.
- Pour $t_1 \leq t \leq (t_f - t_1)$, la fonction $s(t)$ est définie comme $V_M \cdot t - \frac{V_M^2}{2 \cdot AM}$.
- Pour $(t_f - t_1) \leq t \leq t_f$, la fonction $s(t)$ est définie comme $-\frac{A_M}{2}\cdot(t - t_f)^2 + V_M \cdot t - \frac{V_M^2}{A_M}$.

## Exemple 2 : trajectoire en ligne brisée avec point de passage