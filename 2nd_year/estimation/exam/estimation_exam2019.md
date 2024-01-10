# Estimation exam2019

## Questions de cours 
Répondre en trois phrases maximum convenablement construites, sans nécessairement invoquer des formules mathématiques, à chacune des questions suivantes.

### Question 1
Soient $\theta$ et $Z$ deux variables aléatoires. Quelle signification peut-on accorder à la loi a priori $p\theta(\theta)$ de $\theta$ et à sa loi a posteriori $p\theta|Z(\theta|z)$ ?

**Réponse :** La loi a priori $p\theta(\theta)$ représente la distribution de probabilité initiale de la variable aléatoire $\theta$ avant d'observer les données. Elle exprime nos connaissances ou croyances préalables sur $\theta$. En revanche, la loi a posteriori $p\theta|Z(\theta|z)$ reflète la distribution de probabilité mise à jour de $\theta$ après avoir observé les données $Z$. C'est une combinaison de notre information préalable et de l'information nouvellement acquise à travers les observations, permettant ainsi d'ajuster nos estimations sur la valeur de $\theta$.

### Question 2 
Expliquer en langage simple ce que sont le biais et la covariance d’un estimateur.

**Réponse :** Le biais d'un estimateur mesure s'il a tendance à systématiquement surestimer ou sous-estimer la vraie valeur du paramètre. Un estimateur non biaisé donne en moyenne une estimation correcte. La covariance entre deux estimateurs indique comment ils varient ensemble : une covariance positive signifie qu'ils varient dans le même sens, tandis qu'une covariance négative indique une variation opposée.


### Question 3 
À quoi sert l'inégalité de Cramér-Rao ?

**Réponse :** L'inégalité de Cramér-Rao est une borne inférieure fondamentale sur la variance des estimateurs non biaisés d'un paramètre dans une distribution de probabilité. Elle indique que, sous certaines conditions, aucun estimateur non biaisé ne peut avoir une variance plus faible que celle prédite par cette inégalité. En d'autres termes, elle fournit une limite théorique à la précision atteignable par tout estimateur dans l'estimation d'un paramètre. Cette inégalité est particulièrement utile pour évaluer l'efficacité relative des estimateurs et pour déterminer si un estimateur donné est efficace ou peut être amélioré.



### Question 4
Soient $X$ une variable aléatoire vectorielle et $X_1, . . . , X_N$ ses composantes. On suppose que $X \sim \mathcal{N}(\bar{x}, P)$, c.-à-d. que $X$ suit la loi Gaussienne réelle multidimensionnelle de moyenne $\bar{x} = ( \bar{x}_1, \ldots, \bar{x}_N )^T$ et de covariance $P = \begin{pmatrix} p_{11} & \dots & p_{1N} \\ \vdots & \ddots & \vdots \\ p_{1N} & \dots & p_{NN} \end{pmatrix}$. Comment la densité de probabilité $pX(x)$ de $X$ se simplifie-t-elle si $X_1, . . . , X_N$ sont de plus indépendantes et identiquement distribuées ?

**Réponse :** Si les composantes $X_1, . . . , X_N$ de la variable aléatoire vectorielle $X$ sont indépendantes et identiquement distribuées, alors la densité de probabilité $pX(x)$ de $X$ suit une distribution gaussienne multidimensionnelle factorisée. Dans ce cas, la densité de probabilité peut être exprimée comme le produit des densités de probabilité marginales des composantes individuelles, simplifiant ainsi le calcul. En d'autres termes, la distribution de probabilité globale de $X$ devient le produit des distributions de probabilité de chacune de ses composantes.

## Estimation de distance par maximum de vraisemblance
Un télémètre et sa suite logicielle délivrent des mesures de distance selon un axe horizontal. Les données constructeur permettent d’établir que lorsqu’on effectue en séquence $N$ mesures $z_1, . . . , z_N$ d’une même distance inconnue $\theta \in \mathbb{R}^+$, on obtient en fait $N$ échantillons indépendants et identiquement distribués selon la loi Gaussienne d’espérance $\theta$ et d’écart-type $\rho\theta$, où le paramètre $\rho$ est connu. On note alors $z_1, \ldots, z_N \sim \text{i.i.d.} \, \mathcal{N}(\theta, (\rho\theta)^2)$. (1)

Dans tout le sujet, on ne dispose d’aucune connaissance a priori sur $\theta$.
Le symbole := signifie "égal par définition à".

### Question 5(a)
Caractériser qualitativement, en langage naturel et en trois phrases maximum, la distribution de probabilité des observations correspondant à $\theta$ cachée pour $\rho = 1/300$.

**Réponse :** Lorsque $\rho = 1/300$, la distribution des observations pour la distance $\theta$ est centrée autour de la vraie valeur $\theta$ avec un écart-type relativement étroit, indiquant une faible dispersion des mesures. Cela signifie que les mesures sont plus susceptibles d'être proches de la véritable distance, avec une probabilité décroissante à mesure que l'on s'éloigne de cette valeur centrale.

### Question 5(b) 
Préciser en quoi le capteur considéré diffère, qualitativement et en trois phrases maximum, d'un capteur délivrant une mesure de $\theta$ avec une erreur relative distribuée uniformément dans l'intervalle [−1%; +1%].

**Réponse :** Contrairement à un capteur avec une erreur relative uniforme, le capteur considéré présente des mesures qui suivent une distribution gaussienne autour de la vraie valeur $\theta$. Cette différence qualitative implique que les erreurs de mesure sont plus concentrées autour de la valeur réelle, plutôt que réparties uniformément. De plus, le capteur actuel introduit une variabilité plus étroite dans les mesures, ce qui peut influencer la précision des estimations de distance.


### Question 6(a) 
Montrer que $p_{Z|\theta}(z|\theta) = \prod_{n=1}^{N} p_{Z_n|\theta}(z_n|\theta)$. (2)

**Réponse :** La consigne indique que le vecteur $z = (z_1, \ldots, z_N)^T$ des observations peut être considéré comme la réalisation d'un vecteur aléatoire $Z = (Z_1, \ldots, Z_N)^T$ lié à $\theta$ par un modèle d'observation $p_{Z|\theta}(z|\theta)$.

L'idée ici est d'exprimer la probabilité $p_{Z|\theta}(z|\theta)$ en termes de probabilités conditionnelles individuelles. En utilisant la définition fondamentale de la probabilité conditionnelle, on peut écrire que la probabilité que le vecteur aléatoire $Z$ prenne la valeur $z$ est le produit des probabilités conditionnelles que chaque composante individuelle $Z_n$ prenne la valeur correspondante $z_n$, étant donné $\theta$.

Mathématiquement, cela s'exprime comme suit :

$$p_{Z|\theta}(z|\theta) = p_{Z1|\theta}(z_1|\theta) \cdot p_{Z2|\theta}(z_2|\theta) \cdot \ldots \cdot p_{ZN|\theta}(z_N|\theta)$$

Cette relation reflète la manière dont le modèle d'observation global pour le vecteur aléatoire $ Z $ peut être décomposé en produits des modèles d'observation conditionnels pour chaque composante individuelle.


### Question 6(b)
Développer l'expression de $p_{Z|\theta}(z|\theta)$ en tenant compte de (1)-(2).

**Réponse :** En utilisant la relation (2) énoncée dans la question précédente, qui stipule que $p_{Z|\theta}(z|\theta) = \prod_{n=1}^{N} p_{Zn|\theta}(z_n|\theta)$, et en se référant à l'énoncé (1) qui spécifie que $z_1, \ldots, z_N$ sont des échantillons i.i.d. de la loi gaussienne $N(\theta, (\rho\theta)^2)$, nous pouvons développer l'expression de $p_{Z|\theta}(z|\theta)$ :

**Étape 1 : Utiliser la relation (2)**
$$p_{Z|\theta}(z|\theta) = \prod_{n=1}^{N} p_{Zn|\theta}(z_n|\theta)$$

Cette relation découle de la définition du modèle d'observation pour le vecteur aléatoire $Z$.

**Étape 2 : Appliquer l'énoncé (1) à chaque composante $Z_n$**
$$p_{Zn|\theta}(z_n|\theta) = \frac{1}{\sqrt{2\pi (\rho\theta)^2}} \exp\left(-\frac{(z_n - \theta)^2}{2(\rho\theta)^2}\right)$$

C'est la densité de probabilité gaussienne pour chaque composante $Z_n$ avec une moyenne $\theta$ et un écart-type $\rho\theta$.

**Étape 3 : Développer la productoire des densités gaussiennes**
$$\prod_{n=1}^{N} p_{Zn|\theta}(z_n|\theta) = \frac{1}{(2\pi (\rho\theta)^2)^{N/2}} \exp\left(-\frac{\sum_{n=1}^{N} (z_n - \theta)^2}{2(\rho\theta)^2}\right)$$

Cela résulte de la multiplication des densités gaussiennes pour chaque composante $Z_n$. La somme quadratique apparaît dans l'exposant.

**Étape 4 : Simplification de l'exposant**
$$= \frac{1}{(2\pi (\rho\theta)^2)^{N/2}} \exp\left(-\frac{\sum_{n=1}^{N} z_n^2 - 2\theta\sum_{n=1}^{N} z_n + N\theta^2}{2(\rho\theta)^2}\right)$$

La simplification est réalisée en développant $(z_n - \theta)^2$ et en regroupant les termes.

**Étape 5 : Réarrangement des termes**
$$= \frac{1}{(2\pi (\rho\theta)^2)^{N/2}} \exp\left(-\frac{\sum_{n=1}^{N} z_n^2}{2(\rho\theta)^2} + \frac{\theta \sum_{n=1}^{N} z_n}{(\rho\theta)^2} - \frac{N\theta^2}{2(\rho\theta)^2}\right)$$

Cette étape implique la réorganisation des termes de l'exposant pour mieux mettre en évidence les composantes de l'expression.

En conclusion, cette expression représente la densité de probabilité conditionnelle de $Z$ sachant $\theta$, développée à partir des propriétés de la distribution gaussienne pour chaque composante et de l'indépendance des échantillons $z_1, \ldots, z_N$.

### Question 7(a)
Montrer que $\hat{\theta}_{MLE}$ est la solution de $\hat{\theta}_{MLE} = \text{arg min}_{\theta} J(\theta)$, avec $J(\theta) := N \ln(\theta) + \frac{1}{2\rho^2} \sum_{n=1}^{N} \frac{(z_n - \theta)^2}{\theta^2}$.

**Réponse :** L'estimateur du maximum de vraisemblance $\hat{\theta}_{MLE}$ est trouvé en maximisant la fonction de vraisemblance. Dans ce cas, cela revient à minimiser le négatif du logarithme de la vraisemblance. La fonction objectif $J(\theta)$ est définie comme suit :

$$J(\theta) = -\ln(\mathcal{L}(\theta)) = -\ln(p_{Z|\theta}(z|\theta))$$

En utilisant la relation (2) qui donne la probabilité conditionnelle, et l'énoncé (1) qui spécifie la distribution des échantillons, nous pouvons réécrire $J(\theta)$ comme suit :

$$J(\theta) = -\ln\left(\prod_{n=1}^{N} p_{Zn|\theta}(z_n|\theta)\right)$$

$$= -\sum_{n=1}^{N} \ln(p_{Zn|\theta}(z_n|\theta))$$

$$= -\sum_{n=1}^{N} \left(\frac{(z_n - \theta)^2}{2(\rho\theta)^2} + \frac{1}{2}\ln(2\pi (\rho\theta)^2)\right)$$

$$= \frac{1}{2\rho^2} \sum_{n=1}^{N} \frac{(z_n - \theta)^2}{\theta^2} + \frac{N}{2}\ln(2\pi (\rho\theta)^2)$$

La dernière étape consiste à prendre le négatif de la somme, car le problème d'optimisation cherche à minimiser $J(\theta)$. Ainsi, l'estimation du maximum de vraisemblance $\hat{\theta}_{MLE}$ est la solution de $\hat{\theta}_{MLE} = \text{arg min}_{\theta} J(\theta)$, avec $J(\theta) := \frac{1}{2\rho^2} \sum_{n=1}^{N} \frac{(z_n - \theta)^2}{\theta^2} + \frac{N}{2}\ln(2\pi (\rho\theta)^2)$.


### Question 7(b)
Préciser le lien qui unit $J(\theta)$ et $\text{NLL}(\theta; z) = -\ln p_{Z|\theta}(z|\theta)$, lequel pourra être exploité plus loin dans la question 9.

**Réponse :** Le lien entre $J(\theta)$ et $\text{NLL}(\theta; z)$ réside dans la définition de la log-vraisemblance négative ($\text{NLL}$). La log-vraisemblance négative est définie comme le négatif du logarithme de la vraisemblance, soit $\text{NLL}(\theta; z) = -\ln p_{Z|\theta}(z|\theta)$.

Comparons $J(\theta)$ avec $\text{NLL}(\theta; z)$ :

$$J(\theta) = \frac{1}{2\rho^2} \sum_{n=1}^{N} \frac{(z_n - \theta)^2}{\theta^2} + \frac{N}{2}\ln(2\pi (\rho\theta)^2)$$

$$\text{NLL}(\theta; z) = -\ln p_{Z|\theta}(z|\theta)$$

Dans le cas de la distribution gaussienne définie dans la question, la partie qui dépend de $z$ dans $J(\theta)$ est la même que celle de $\text{NLL}(\theta; z)$. C'est-à-dire, $\frac{1}{2\rho^2} \sum_{n=1}^{N} \frac{(z_n - \theta)^2}{\theta^2}$ représente la contribution de la vraisemblance aux deux fonctions.

Ainsi, $J(\theta)$ et $\text{NLL}(\theta; z)$ partagent la même forme fonctionnelle liée à la vraisemblance, et cela peut être exploité plus loin dans la question 9 pour simplifier les calculs.

**Question 7(c) :** Écrire soigneusement les conditions d'optimalité du premier ordre. Développer les expressions mathématiques obtenues. Conclure soigneusement sur les conclusions qu’elles permettent d’obtenir. On rappelle, à toutes fins utiles, que $\frac{\partial}{\partial\theta} \left( \frac{(x - \theta)^2}{\theta^2} \right) = \frac{2x(\theta - x)}{\theta^3}$ (4).

**Réponse :** 

Les conditions d'optimalité du premier ordre correspondent à l'endroit où la dérivée première de la fonction objectif $J(\theta)$ par rapport à $\theta$ s'annule. Mathématiquement, cela peut être exprimé comme suit :

$$\frac{\partial J(\theta)}{\partial \theta} = 0$$

Commençons par développer cette expression à partir de la définition de $J(\theta)$ :

$$\frac{\partial J(\theta)}{\partial \theta} = \frac{\partial}{\partial \theta} \left( \frac{1}{2\rho^2} \sum_{n=1}^{N} \frac{(z_n - \theta)^2}{\theta^2} + \frac{N}{2}\ln(2\pi (\rho\theta)^2) \right)$$

$$= \frac{1}{\rho^2} \sum_{n=1}^{N} \left( \frac{\partial}{\partial \theta} \frac{(z_n - \theta)^2}{\theta^2} \right) - \frac{N}{\theta}$$

Utilisons la propriété rappelée dans l'énoncé (4) pour calculer la dérivée partielle :

$$\frac{\partial}{\partial\theta} \left( \frac{(z_n - \theta)^2}{\theta^2} \right) = \frac{2z_n(\theta - z_n)}{\theta^3}$$

En remplaçant dans l'expression précédente :

$$\frac{\partial J(\theta)}{\partial \theta} = \frac{1}{\rho^2} \sum_{n=1}^{N} \frac{2z_n(\theta - z_n)}{\theta^3} - \frac{N}{\theta}$$

Pour trouver $\hat{\theta}_{MLE}$, on résout l'équation $\frac{\partial J(\theta)}{\partial \theta} = 0$.

$$\frac{1}{\rho^2} \sum_{n=1}^{N} \frac{2z_n(\theta - z_n)}{\theta^3} - \frac{N}{\theta} = 0$$

$$\sum_{n=1}^{N} \frac{2z_n(\theta - z_n)}{\theta^3} = \frac{N\rho^2}{\theta^2}$$

$$\sum_{n=1}^{N} \frac{2z_n}{\theta^2} - \sum_{n=1}^{N} \frac{2z_n^2}{\theta^3} = \frac{N\rho^2}{\theta^2}$$

$$\frac{2}{\theta^2} \left( \sum_{n=1}^{N} z_n - \sum_{n=1}^{N} \frac{z_n^2}{\theta} \right) = \frac{N\rho^2}{\theta^2}$$

$$2 \left( \sum_{n=1}^{N} z_n - \sum_{n=1}^{N} \frac{z_n^2}{\theta} \right) = N\rho^2$$

$$\sum_{n=1}^{N} z_n - \sum_{n=1}^{N} \frac{z_n^2}{\theta} = \frac{N\rho^2}{2}$$

$$\theta \left( \sum_{n=1}^{N} z_n \right) - \sum_{n=1}^{N} z_n^2 = \frac{N\rho^2}{2}$$

$$\theta \left( \sum_{n=1}^{N} z_n \right) = \sum_{n=1}^{N} z_n^2 + \frac{N\rho^2}{2}$$

$$\theta = \frac{\sum_{n=1}^{N} z_n^2 + \frac{N\rho^2}{2}}{\sum_{n=1}^{N} z_n}$$

Ainsi, les conditions d'optimalité du premier ordre nous conduisent à l'estimation du maximum de vraisemblance $\hat{\theta}_{MLE}$ donnée par l'expression ci-dessus.


### Question 7(d)
On conserve pour l'estimée $\hat{\theta}_{MLE}$ celui qui semble "intuitivement le plus judicieux" parmi le(s) candidat(s) obtenu(s) à la question précédente. Donner son expression.

**Réponse :** 

L'expression obtenue pour $\hat{\theta}_{MLE}$ dans la question précédente est :

$$\hat{\theta}_{MLE} = \frac{\sum_{n=1}^{N} z_n^2 + \frac{N\rho^2}{2}}{\sum_{n=1}^{N} z_n}$$

Cette expression représente l'estimation du maximum de vraisemblance pour le paramètre caché $\theta$ dans le modèle d'observation gaussien. Il s'agit de la solution obtenue en résolvant les conditions d'optimalité du premier ordre. Pour le conserver, il faut évaluer les candidats potentiels obtenus et choisir celui qui semble le plus judicieux en fonction du contexte du problème.


### Question 7(e)
Exprimer l'estimateur $\hat{\Theta}_{MLE}$ du maximum de vraisemblance obtenu en fonction de $\rho$ et des deux variables aléatoires $U_N = \frac{1}{N}\sum_{n=1}^{N} Z_n$ et $V_N = \frac{1}{N}\sum_{n=1}^{N} Z_n^2$ (5).

**Réponse :**

L'expression de $\hat{\Theta}_{MLE}$ en fonction de $\rho$, $U_N$, et $V_N$ peut être obtenue en remplaçant $\sum_{n=1}^{N} Z_n$ par $N U_N$ et $\sum_{n=1}^{N} Z_n^2$ par $N V_N$ dans l'expression obtenue à la question 7(d).

$$\hat{\Theta}_{MLE} = \frac{\sum_{n=1}^{N} Z_n^2 + \frac{N\rho^2}{2}}{\sum_{n=1}^{N} Z_n}$$

$$= \frac{N V_N + \frac{N\rho^2}{2}}{N U_N}$$

Simplifiant par $N$ dans le numérateur et le dénominateur :

$$\hat{\Theta}_{MLE} = \frac{V_N + \frac{\rho^2}{2}}{U_N}$$

Ainsi, l'estimateur $\hat{\Theta}_{MLE}$ du maximum de vraisemblance peut être exprimé en fonction de $\rho$, $U_N$, et $V_N$ selon l'expression donnée ci-dessus.


**Énoncé 8 :** Les variables aléatoires $U_N$ et $V_N$ définies en (5) se réalisent respectivement en la moyenne empirique des $z_1, \ldots, z_N$ et en la moyenne empirique des carrés des $z_1, \ldots, z_N$. En vertu de la loi des grands nombres, lorsque la dimension $N$ du vecteur $Z$ tend vers $+\infty$, leurs "limites" sont $\lim_{N \to +\infty} U_N = U_{\infty} := E[Z_n]$ et $\lim_{N \to +\infty} V_N = V_{\infty} := E[Z_n^2]$ (6).

### Question 8(a)
Établir les expressions de $U_{\infty}$ et $V_{\infty}$ en fonction de $\rho$ et $\theta$.

**Réponse :**

Les expressions de $U_{\infty}$ et $V_{\infty}$ peuvent être établies en utilisant les propriétés de la loi des grands nombres.

$$U_{\infty} = \lim_{N \to +\infty} U_N = \lim_{N \to +\infty} \frac{1}{N} \sum_{n=1}^{N} Z_n = E[Z_n]$$

$$V_{\infty} = \lim_{N \to +\infty} V_N = \lim_{N \to +\infty} \frac{1}{N} \sum_{n=1}^{N} Z_n^2 = E[Z_n^2]$$

Cependant, dans la question 8(a), il est demandé d'exprimer ces limites en fonction de $\rho$ et $\theta$. Pour ce faire, nous devons utiliser les propriétés de la distribution des $Z_n$.

$$Z_n \sim N(\theta, \rho^2)$$

$$E[Z_n] = \theta$$

$$E[Z_n^2] = \text{Var}(Z_n) + (E[Z_n])^2 = \rho^2 + \theta^2$$

Par conséquent, les expressions finales sont :

$$U_{\infty} = E[Z_n] = \theta$$

$$V_{\infty} = E[Z_n^2] = \rho^2 + \theta^2$$

### Question 8(b)
Exploiter ce résultat afin de montrer que $\hat{\Theta}_{MLE}$ est asymptotiquement non biaisée (c'est-à-dire non biaisée lorsque $N \to +\infty$).

**Réponse :**

La propriété d'asymptotique non biaisée signifie que lorsque la taille de l'échantillon ($N$) tend vers l'infini, l'estimateur converge en probabilité vers la vraie valeur du paramètre ($\theta$ dans ce cas) sans biais. 

L'estimateur $\hat{\Theta}_{MLE}$ est donné par l'expression :

$$\hat{\Theta}_{MLE} = \frac{V_N + \frac{\rho^2}{2}}{U_N}$$

En utilisant les résultats obtenus à la question précédente ($U_{\infty} = \theta$ et $V_{\infty} = \rho^2 + \theta^2$), nous pouvons exprimer $\hat{\Theta}_{MLE}$ en fonction de $\rho$ et $\theta$ dans le cas asymptotique ($N \to +\infty$) :

$$\lim_{N \to +\infty} \hat{\Theta}_{MLE} = \lim_{N \to +\infty} \frac{V_N + \frac{\rho^2}{2}}{U_N}$$

$$= \frac{V_{\infty} + \frac{\rho^2}{2}}{U_{\infty}}$$

$$= \frac{\rho^2 + \theta^2 + \frac{\rho^2}{2}}{\theta}$$

$$= \frac{\frac{3}{2}\rho^2 + \theta^2}{\theta}$$

Ainsi, $\lim_{N \to +\infty} \hat{\Theta}_{MLE}$ converge vers $\frac{\frac{3}{2}\rho^2 + \theta^2}{\theta}$. En comparant cela avec la vraie valeur du paramètre $\theta$, on peut conclure que $\hat{\Theta}_{MLE}$ est asymptotiquement non biaisée. Cela signifie que lorsque la taille de l'échantillon tend vers l'infini, l'estimateur converge vers la vraie valeur du paramètre sans biais.


### Question 9
Quelle est la borne inférieure de Cramér-Rao du problème ?

**Réponse :**

La borne inférieure de Cramér-Rao est une borne inférieure théorique sur la variance des estimateurs non biaisés d'un paramètre. Pour un problème d'estimation de paramètres, la borne inférieure de Cramér-Rao est donnée par l'inverse de l'information de Fisher.

Dans le cas de l'estimation du maximum de vraisemblance, l'information de Fisher ($I(\theta)$) est définie comme suit :

$$I(\theta) = -E\left[\frac{\partial^2 \ln p_{Z|\theta}(z|\theta)}{\partial \theta^2}\right]$$

En utilisant les propriétés de la distribution des $Z_n$ données dans l'énoncé, on peut calculer cette information de Fisher.

$$I(\theta) = -E\left[\frac{\partial^2 \ln p_{Z|\theta}(z|\theta)}{\partial \theta^2}\right] = -E\left[\frac{\partial^2 \ln \left(\frac{1}{\sqrt{2\pi (\rho \theta)^2}} \exp\left(-\frac{(z - \theta)^2}{2(\rho \theta)^2}\right)\right)}{\partial \theta^2}\right]$$

$$I(\theta) = -E\left[\frac{\partial^2 \ln \left(\frac{1}{\sqrt{2\pi (\rho \theta)^2}} - \frac{(z - \theta)^2}{2(\rho \theta)^2}\right)}{\partial \theta^2}\right]$$

$$I(\theta) = E\left[\frac{1}{\rho^2} - \frac{(z - \theta)^2}{(\rho \theta)^2} - \frac{1}{\theta^2}\right]$$

$$I(\theta) = \frac{1}{\rho^2} - E\left[\frac{(z - \theta)^2}{(\rho \theta)^2}\right] - E\left[\frac{1}{\theta^2}\right]$$

$$I(\theta) = \frac{1}{\rho^2} - \frac{1}{\theta^2} - E\left[\frac{1}{\theta^2}\right]$$

La borne inférieure de Cramér-Rao est alors l'inverse de l'information de Fisher :

$$\text{Cramér-Rao} = \frac{1}{I(\theta)} = \frac{1}{\frac{1}{\rho^2} - \frac{1}{\theta^2} - E\left[\frac{1}{\theta^2}\right]}$$

Cela représente la plus petite variance théoriquement possible pour un estimateur non biaisé de $\theta$ dans ce problème d'estimation.