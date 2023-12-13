# Chapitre 4 : Modèle Géométrique Inverse (MGI)
La définition d’une tâche robotique en situation se fait dans l’espace de la tâche (opérationnel) en décrivant les X = (Xp , Xr )t à atteindre. Il faut pouvoir calculer la(s) configuration(s) correspondante(s)

Résolution du MGI : trouver q solution de X = f (q) pour X donnée.
Il faut résoudre
$$q = g(X)$$

Problème : $f(q)$ est une fonction non-linéaire en d'autres termes : 
* existence ou non de solution (workspace)
* une ou plusieurs solutions pour une même situation X
* méthodes de résolution analytique ou numérique

## Deux manière de résoudre le problème
### Résolution analytique
* Toutes les solutions sont calculées
* Implémentation temps réel
* Facile à résoudre pour des robots simples (industriels, poignets axes concourants)
* Complexe voire impossible, pour robots quelconques.
### Résolution numérique
* Méthode générale qui s’applique à tous les robots
* Une seule solution est calculée (fonction des conditions initiales)
* Problème de convergence de l’algorithme d’optimisation
* Temps de calcul.
Pas de résultat général sur le nombre de solution ou la possibilité de trouver une solution analytique

Un bras manipulateur est **résoluble** s’il est possible de calculer toutes les
configurations $q$ permettant d’atteindre une situation $X$.
Tous les BM série avec n = 6, non redondants, sont considérés comme résolubles.

Le nombre de solution dépend de l’architecture du BM :
* pour un robot 6R ou 5R1P, le nombre maximum de MGI est égal à 16,
* pour un robot avec 3 liaisons rotoïdes d’axes concourants, ce nombre maximum est égal à 8,
* pour un robot 3P3R, ce nombre maximum est égal à 2

Remarques : Si n < 6, on ne peut pas décrire librement la situation de l’OT sinon il peut ne pas y avoir de solution au calcul du MGI. (exemple : robot SCARA). Si dim(X) < 6, on a des contraintes sur la situation de l’OT, il faudra penser à introduire ces contraintes dans le choix de la situation à atteindre X.

Dans le calcul du MGI, trois cas peuvent se présenter :
* **Absence de solution** : lorsque la situation est inaccessible pour le bras
manipulateur (en dehors du volume de travail, butées articulaires,...)
* **Infinité de solution** : le robot est redondant (globalement ou par rapport à la
tâche robotique) ou le robot se trouve dans une configuration singulière
* **Nombre fini de solutions**

### Méthode Analytique du MGI
Pour déterminer les configurations $ q $ permettant d'atteindre une position donnée de l'organe terminal (OT), le problème de géométrie inverse (MGI) peut être résolu de manière analytique. Il existe plusieurs approches différentes (méthode de Paul, Pieper, Rahavan et
Roth,.....) qui vont toutes se ramener à écrire un système d’équations non linéaires pour ensuite le résoudre.

#### Trois étapes

1. **Expression de $ T_{0,n}(X^*)$** en fonction de la position souhaitée de l'OT, $ X^* $: indépendant du BM considéré
2. **Ecriture du système d’équations non linéaires** liant $X^*$ à q : possible d’écrire le système pour un bras manipulateur donné
3. **Résolution du Système d'Équations Non Linéaires:**  peut échouer car elle est liée au SMA constituant le BM

#### Etape 1 : Expression de $T_{0,n}^{*}$
On souhaite exprimer la matrice de transformation $ T_{\ast 0,n} $ en fonction de la position désirée $ X^* $. Cette matrice est définie comme suit:

$$
T_{\ast 0,n} = 
\begin{bmatrix}
R_{0,n} & P_{0,n} \\
0 & 1
\end{bmatrix}
$$

##### Calcul de $ R_{0,n} $

En fonction de la paramétrisation choisie pour l'orientation (angles de Bryant, etc.), $ R_{0,n} $ est obtenu en appliquant directement les formules de changement de paramétrisation pour obtenir les cosinus directeurs constituant $ R_{0,n} $.

##### Calcul de $ P_{0,n} $

La position désirée du point $ O_{n+1} $, représentant l'organe terminal (OT), est connue ($ P_{0,n+1} $). Cependant, les coordonnées du point $ O_n $ ne sont pas connues. En se basant sur le modèle géométrique direct (MGD), on sait que $ O_0O_{n+1} = O_0O_n + O_nO_{n+1} $. Ainsi, $ P_{0,n+1} = O_0O_{n+1}(0) = O_0O_n(0) + R_{0,n} \cdot O_nO_{n+1}(n) $.

Par conséquent, $ P_{0,n} = P_{0,n+1} - R_{0,n} \cdot O_nO_{n+1}(n) $. Les valeurs de $ P_{0,n} $ et $ R_{0,n} $ (donc $ T_{\ast 0,n} $) sont indépendantes du robot et sont entièrement déterminées par la géométrie désirée.

#### Etape 2 : Écriture du système d'équations

Le problème consiste à résoudre l'équation complexe $ T_{\ast 0,n} = T_{0,n}(q) = T_{0,1}(q_1) \cdot T_{1,2}(q_2) \ldots T_{n-1,n}(q_n) $. Cette équation comporte des coefficients non linéaires, ce qui la rend difficile à résoudre, étant donné que toutes les inconnues $ q_i $ sont interdépendantes. 

Pour simplifier cette équation, on procède à une répartition des inconnues $ q_i $ dans une équation matricielle, permettant ainsi de diviser les inconnues en deux groupes. On utilise la notation $ T_{p,p-1}(q_p) \ldots T_{1,0}(q_1) \cdot T_{\ast 0,n} = T_{p,p+1}(q_{p+1}) \ldots T_{n-1,n}(q_n) $, où $ p $ est le nombre d'inconnues dans le premier groupe, et $ (n - p) $ est le nombre d'inconnues dans le deuxième groupe.

En répartissant les inconnues de cette manière, on obtient un **système d'équations à résoudre**:

**$$ T_{p,p-1}(q_p) \ldots T_{1,0}(q_1) \cdot T_{\ast 0,n} = T_{p,p+1}(q_{p+1}) \ldots T_{n-1,n}(q_n) $$**

Ce processus de répartition permet de simplifier le système d'équations, rendant ainsi le problème plus gérable pour la résolution.

#### Etape 3 : Résolution

Pour résoudre le système résultant de la répartition des inconnues, on se retrouve avec un ensemble de 9 équations à $ n $ inconnues. Il est souvent plus pratique si $ p = Int(\frac{n}{2}) $.

La résolution du système ne peut pas se faire en une seule étape. On suit généralement les étapes suivantes :
1. Identifier une variable $ q_i $ qui semble être la plus simple, elle deviendra une constante dans les autres équations.
2. Combiner les équations pour isoler $ q_i $ ou $ \cos(q_i) $ ou $ \sin(q_i) $.
3. Répéter ces étapes pour toutes les inconnues $ q_i $.

Il est crucial de s'assurer que toutes les équations sont utilisées et vérifiées dans le processus de résolution.

Pour une équation du type $ \alpha \cos(q) + \beta \sin(q) = \gamma $, elle a une solution si et seulement si $ \alpha^2 + \beta^2 \geq \gamma^2 $. La solution est donnée par :

$$ \sin(q) = \frac{\beta \gamma + \varepsilon \alpha \sqrt{\alpha^2 + \beta^2 - \gamma^2}}{\alpha^2 + \beta^2} $$

$$ \cos(q) = \frac{\alpha \gamma - \varepsilon \beta \sqrt{\alpha^2 + \beta^2 - \gamma^2}}{\alpha^2 + \beta^2} $$

où $ \varepsilon = \pm 1 $.

### Principaux types d'équations associées au MGI

#### 1. $X \cdot \cos(q_i) + Y \cdot \sin(q_i) = Z$
Quatre cas se présentent :
1. Si $X = 0$ et $Y \neq 0$, alors $\sin(q_i) = s_i = Z/Y$, et $q_i = \text{Atan2}(s_i, \pm \sqrt{1 - s_i^2})$.
2. Si $Y = 0$ et $X \neq 0$, alors $\cos(q_i) = c_i = Z/X$, et $q_i = \text{Atan2}(\pm \sqrt{1 - c_i^2}, c_i)$.
3. Si $X \neq 0$, $Y \neq 0$, et $Z = 0$, alors $q_i = \text{Atan2}(-X, Y)$ et $q'_i = q_i + \pi$.
4. Si $X \neq 0$, $Y \neq 0$, et $Z \neq 0$, l'équation a une solution si $X^2 + Y^2 \geq Z^2$. Alors, $\sin(q_i) = \frac{Y \cdot Z + \varepsilon \cdot X \cdot \sqrt{X^2 + Y^2 - Z^2}}{X^2 + Y^2}$ et $\cos(q_i) = \frac{X \cdot Z - \varepsilon \cdot Y \cdot \sqrt{X^2 + Y^2 - Z^2}}{X^2 + Y^2}$, avec $\varepsilon = \pm 1$, et $q_i = \text{Atan2}(s_i, c_i)$ (liaison rotoïde).

#### 2. $X_1 \cdot \sin(q_i) + Y_1 \cdot \cos(q_i) = Z_1$ et $X_2 \cdot \sin(q_i) + Y_2 \cdot \cos(q_i) = Z_2$
Si $X_1 \cdot Y_2 - X_2 \cdot Y_1 \neq 0$, alors $\sin(q_i) = \frac{Z_1 \cdot Y_2 - Z_2 \cdot Y_1}{X_1 \cdot Y_2 - X_2 \cdot Y_1}$ et $\cos(q_i) = \frac{Z_2 \cdot X_1 - Z_1 \cdot X_2}{X_1 \cdot Y_2 - X_2 \cdot Y_1}$, et $q_i = \text{Atan2}(s_i, c_i)$ (liaison rotoïde). Sinon, les deux équations sont dépendantes, et on choisit une équation de type (1).

#### 3. $X_1 \cdot q_j \cdot \sin(q_i) = Y_1$ et $X_2 \cdot q_j \cdot \sin(q_i) = Y_2$
$q_j = \pm \sqrt{\left(\frac{Y_1}{X_1}\right)^2 + \left(\frac{Y_2}{X_2}\right)^2}$ (liaison prismatique), et $q_i = \text{Atan2}\left(\frac{Y_1}{X_1 \cdot q_j}, \frac{Y_2}{X_2 \cdot q_j}\right)$ (liaison rotoïde).

#### 4. $X_1 \cdot \sin(q_i) = Y_1 + Z_1 \cdot q_j$ et $X_2 \cdot \cos(q_i) = Y_2 + Z_2 \cdot q_j$
On normalise les équations, élève au carré et additionne, ce qui donne une équation quadratique. On résout cette équation pour $q_j$, puis on résout pour $q_i$ en utilisant une équation de type (2) ou (1).

#### 5. $W_1 \cdot \cos(q_j) + W_2 \cdot \sin(q_j) = X \cdot \cos(q_i) + Y \cdot \sin(q_i) + Z_1$ et $W_1 \cdot \sin(q_j) - W_2 \cdot \cos(q_j) = X \cdot \sin(q_i) - Y \cdot \cos(q_i) + Z_2$
On élève au carré et additionne, puis on se ramène à une équation de type (1) pour résoudre $q_i$. Connaissant $q_i$, on résout pour $q_j$ en utilisant une équation de type (2).
