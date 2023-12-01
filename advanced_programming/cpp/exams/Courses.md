# Note de cour Cpp

## Introduction

### Comparaison C++/Java

#### Pointeurs
- **C++:** Utilise des pointeurs de manière explicite pour la gestion de la mémoire, permettant un contrôle fin mais pouvant entraîner des erreurs.
- **Java:** Gère la mémoire automatiquement avec le ramasse-miettes (garbage collector), n'utilise pas de pointeurs explicites.

#### Surcharge d'opérateurs
- **C++:** Permet la surcharge d'opérateurs, offrant une flexibilité et une expressivité accrues.
- **Java:** Ne prend pas en charge la surcharge d'opérateurs, les opérations sont définies par des méthodes spécifiques.

#### Héritage multiple
- **C++:** Permet l'héritage multiple, ce qui signifie qu'une classe peut hériter de plusieurs classes.
- **Java:** Ne prend pas en charge l'héritage multiple direct, mais utilise des interfaces pour atteindre des résultats similaires.

#### Libération de mémoire non transparente
- **C++:** Le programmeur doit gérer explicitement la libération de la mémoire, ce qui peut entraîner des fuites mémoire si mal géré.
- **Java:** La gestion de la mémoire est transparente grâce au ramasse-miettes, réduisant le risque de fuites mémoire.

#### Rapidité
- **C++:** Compilé directement en langage machine, offre des performances élevées et un accès direct à la mémoire.
- **Java:** Interprété ou compilé en bytecode, généralement moins rapide que le C++ mais offre une portabilité accrue.

#### Facilité d'apprentissage et d'utilisation
- **C++:** Peut être plus difficile à apprendre en raison de son utilisation complexe des pointeurs et de la gestion explicite de la mémoire.
- **Java:** Souvent considéré comme plus simple à apprendre et à utiliser en raison de la gestion automatique de la mémoire et de la simplicité syntaxique.

#### Ressources supplémentaires
- Le site web "Bjarne Stroustrup FAQ" (le créateur du C++) peut fournir des informations approfondies sur le langage C++.

### Comparaison Python/C++

#### Orientés objets
- **Python:** Langage orienté objet, favorisant la programmation orientée objet.
- **C++:** Également orienté objet, mais offre plus de flexibilité avec des fonctionnalités comme la surcharge d'opérateurs et l'accès direct à la mémoire.

#### Interprété/Compilé
- **Python:** Langage interprété, ce qui signifie que le code est exécuté ligne par ligne par l'interpréteur.
- **C++:** Langage compilé, le code source est converti en langage machine avant l'exécution.

#### Puissance de calcul vs. Coût de développement
- **C++:** Puissant en termes de calcul et d'accès direct à la mémoire. Coût de développement potentiellement plus élevé en raison de la gestion manuelle de la mémoire.
- **Python:** Plus simple à développer, mais peut être moins performant pour des tâches intensives en calcul en comparaison avec le C++.

#### Applications critiques
- **C++:** Souvent utilisé pour des applications critiques où les performances et le contrôle de la mémoire sont essentiels.
- **Python:** Préféré pour le développement rapide, la simplicité, et les applications où la performance n'est pas critique.

En résumé, le choix entre C++ et Java dépend des besoins spécifiques du projet, tandis que Python est souvent privilégié pour la simplicité et la rapidité de développement.

### Rappel du Modèle Objet

#### Monde : Collection d'Objets
- **Entités physiques :** Grains de sable, étoiles, êtres vivants, etc.
- **Concepts :** Univers, compte en banque, équation mathématique, etc.
- **Objets :** Naissent, vivent, et meurent au travers de leurs interactions.

#### Les Classes
- **Nom de Classe :** Regroupement d'objets partageant des caractéristiques communes.
- **Attributs :** Caractéristiques d'une classe.
- **Opérations :** Méthodes ou fonctions associées à la classe.

#### Classes et Objets : Instanciation
- Chaque objet est formé à partir d'une classe.
- Les objets contiennent la valeur des attributs de la classe.
- Ils partagent l'implémentation des méthodes.

```cpp
void main() {
  Livre leLion("Le lion", "Kessel");
}
```

#### L'Encapsulation Protège les Données
- Accès aux données privées de l'objet via des procédures publiques.
- L'objet est accessible via son comportement et non par ses données.
- Comportement visible, état interne caché.

### Une Classe en C++

#### Définition de la Classe "Livre"

```cpp
// Livre.h
#include <string>

class Livre {
  private:
    std::string titre;
    std::string auteur;
    std::string resume;

  public:
    void saisirInfos();
    void afficherInfos();
};
```

#### Interface d'une Classe : `NomDeClasse.h`

```cpp
class NomDeClasse {
  private:
    // Variables cachées, accessibles depuis les méthodes de la classe

  protected:
    // Variables accessibles depuis la classe et ses sous-classes

  public:
    // Fonctions qui manipulent les variables cachées (méthodes)
};
```

#### Attributs Publics et Privés

- `private` : Les éléments suivants sont cachés aux fonctions externes à la classe.
- `public` : Les fonctions suivantes sont accessibles depuis l'extérieur de la classe.

```cpp
void main() {
  Livre monLivre;
  cout << monLivre.titre; // Accès illégal mais syntaxe correcte
}
```

#### Codage des Méthodes dans "Livre.cpp"

```cpp
// Livre.cpp
#include "Livre.h"
#include <iostream>

void Livre::afficherInfos() {
  cout << titre;
  cout << auteur;
  cout << resume;
}

void Livre::saisirInfos() {
  cin >> titre;
  cin >> auteur;
  cin >> resume;
}
```

#### Entrées / Sorties

- Inclure le fichier `<iostream>`
- `cout` : Flux sur la sortie standard (écran)
- `cin` : Flux sur l'entrée standard (clavier)

```cpp
#include <iostream>
using namespace std;

void main() {
  float price;
  cout << "price: " << price << endl;
  
  int nb, nb1, nb2;
  char c;
  cout << "Enter an integer: ";
  cin >> nb;
  cout << "Integer nb: " << nb << endl;

  cout << "Enter a letter: ";
  cin >> c;
  cout << "Letter c: " << c << endl;

  cout << "Enter a price: ";
  cin >> price;
  cout << "Price: " << price << endl;

  cout << "Enter two integers: ";
  cin >> nb1 >> nb2;
  cout << "Integers nb1: " << nb1 << "\t nb2: " << nb2 << endl;
}
```

#### Opérateur d'Écriture `<<` et Opérateur de Lecture `>>`

- `<<` : Opérateur d'insertion (flux en sortie)
- `>>` : Opérateur d'extraction (flux en entrée)

### Un Programme Principal

#### Main.cpp

```cpp
#include "Livre.h"

int main() {
  Livre monLivre;
  monLivre.saisirInfos();
  monLivre.afficherInfos();
}
```

### Autre Programme pour Saisir MAX Livres

#### Main.cpp

```cpp
#include "Livre.h"
#define MAX 10

int main() {
  Livre biblio[MAX]; // Tableau de MAX objets Livre
  int i;
  for (i = 0; i < MAX; i++)
    biblio[i].saisirInfos();
}
```

### Le Mot-Clé `this`

- `this` est un pointeur sur l'objet courant qui a appelé la fonction.
- Utilisé pour distinguer entre les paramètres de fonction et les attributs de la classe.

#### Livre.cpp

```cpp
#include "Livre.h"

void Livre::saisirInfos() {
  cin >> titre;
  cin >> auteur;
  cin >> resume;
}

void Livre::saisirInfos() {
  cin >> this->titre;
  cin >> this->auteur;
  cin >> this->resume;
}
```

### Fonctions d'Accès aux Attributs (Accesseurs)

- Autorisent l'accès en lecture et/ou en écriture aux attributs privés d'une classe.
- Utilisées par d'autres classes ou dans le programme principal.

#### Livre.cpp

```cpp
#include "Livre.h"

// Fonctions d'accès en lecture
string Livre::getTitre() { return titre; }
string Livre::getAuteur() { return auteur; }
string Livre::getResume() { return resume; }

// Fonctions d'accès en écriture
void Livre::setTitre(string t) { titre = t; }
void Livre::setAuteur(string a) { auteur = a; }
void Livre::setResume(string r) { resume = r; }
```

#### Livre.h

```cpp
class Livre {
  string titre;
  string auteur;
  string resume;

public:
  void saisirInfos();
  void afficherInfos();
  string getTitre() { return titre; }
  string getAuteur() { return auteur; }
  string getResume() { return resume; }
  void setTitre(string t) { titre = t; }
  void setAuteur(string a) { auteur = a; }
  void setResume(string r) { resume = r; }
};
```

### Compilation et Exécution

1. **Compiler la Classe Livre:**

   ```bash
   g++ -c Livre.cpp
   ```

2. **Compiler le Programme Principal:**

   ```bash
   g++ -c Main.cpp
   ```

3. **Édition de Liens pour Produire l'Exécutable:**

   ```bash
   g++ Livre.o Main.o -o Livre
   ```

4. **Lancer le Fichier Exécutable:**

   ```bash
   ./Livre
   ```

### Spécification de la Classe Compte

```cpp
// Compte.h
class Compte {
private:
  float solde;

public:
  // Constructeur
  Compte();

  // Méthodes
  void depot(float montant);
  void retrait(float montant);
  void afficherSolde();
  float getSolde();
  void virement(Compte &destinataire, float montant);
};

// Compte.cpp
#include <iostream>
using namespace std;

// Constructeur
Compte::Compte() : solde(0) {}

// Méthodes
void Compte::depot(float montant) {
  solde += montant;
}

void Compte::retrait(float montant) {
  if (montant <= solde) {
    solde -= montant;
  } else {
    cout << "Solde insuffisant." << endl;
  }
}

void Compte::afficherSolde() {
  cout << "Solde actuel : " << solde << endl;
}

float Compte::getSolde() {
  return solde;
}

void Compte::virement(Compte &destinataire, float montant) {
  if (montant <= solde) {
    retrait(montant);
    destinataire.depot(montant);
  } else {
    cout << "Solde insuffisant pour effectuer le virement." << endl;
  }
}
```

### Utilisation de la Classe Compte

```cpp
// MainCompte.cpp
#include "Compte.h"

int main() {
  Compte monCompte;
  Compte compteDestinataire;

  monCompte.depot(1000);
  monCompte.afficherSolde();

  monCompte.retrait(500);
  monCompte.afficherSolde();

  monCompte.virement(compteDestinataire, 200);
  monCompte.afficherSolde();
  compteDestinataire.afficherSolde();

  return 0;
}
```

**Compilation et Exécution du Programme Compte:**

```bash
g++ -c Compte.cpp MainCompte.cpp -o Compte
./Compte
```

## Déclaration différé
La déclaration différée, également appelée forward declaration en anglais, est une pratique courante en programmation C++ qui consiste à déclarer un type (classe, struct, etc.) sans définir son implémentation complète. Elle permet d'utiliser ce type dans certaines situations sans avoir besoin de fournir tous les détails sur sa structure.

Exemple 

```cpp
// Déclaration différée
struct Impair;

// Pointeurs et références sur Impair autorisés
struct Pair {
    Impair *suiv;
};

struct Impair {
    Pair *suiv;
};
```

Ici, Impair est déclaré mais non défini. Cela signifie que l'on peut utiliser des pointeurs et des références sur Impair sans connaître tous les détails de sa structure. Dans le cas présent, Pair et Impair se référencent mutuellement, ce qui peut être nécessaire dans certaines situations.

L'avantage de cette approche réside dans le fait que l'on peut déclarer des pointeurs et des références vers Impair dans Pair sans avoir besoin de définir complètement Impair à cet endroit. La définition complète de Impair peut être fournie plus tard dans le fichier source (.cpp) ou dans un autre fichier d'en-tête (.h).

L'utilisation de déclarations différées est particulièrement utile pour éviter des dépendances cycliques entre les fichiers d'en-tête. Cela peut aider à réduire le temps de compilation en limitant la propagation des changements.

## Espace de nom
L'idée d'un espace de noms (namespace en anglais) en C++ est de fournir un moyen de regrouper des identificateurs (noms de classes, fonctions, variables, etc.) de manière logique et hiérarchique, afin d'éviter les conflits de noms entre différentes parties d'un programme.

Dans le cas particulier de l'espace de nom std (Standard Template Library), c'est l'espace de nom standard qui contient de nombreux éléments de la bibliothèque standard C++. Pour utiliser des éléments de la STL, on doit soit préfixer chaque utilisation avec std::, soit utiliser la directive using namespace std pour éviter la nécessité de préfixer chaque élément.

Voici un exemple :

```cpp
#include <iostream>

// Utilisation avec std::
std::string nom("toto");
std::cout << nom;

// Utilisation avec using namespace std
using namespace std;
string autreNom("titi");
cout << autreNom;
```
Dans le premier exemple, chaque utilisation de string et cout est préfixée par std::. Dans le deuxième exemple, la directive `using namespace std` permet d'utiliser directement string et cout sans préfixe. Cependant, l'utilisation de using namespace std peut entraîner des conflits de noms, en particulier dans de grands projets, et est donc souvent évitée pour éviter des ambiguïtés.

L'utilisation d'espaces de noms personnalisés est également courante pour organiser son propre code de manière logique et éviter les conflits de noms avec d'autres parties du code. Cela peut être particulièrement utile lorsque l'on travaille sur de grands projets ou lorsque plusieurs bibliothèques sont utilisées simultanément.


## Opérateurs

1. **Types d'opérateurs :**
    - **Opérateurs arithmétiques :** `+` (addition), `-` (soustraction), `*` (multiplication), `/` (division), `%` (modulo).
    - **Opérateurs logiques :** `&&` (ET logique), `||` (OU logique), `!` (NON logique).
    - **Opérateurs de comparaison :** `==` (égal), `!=` (différent), `>=` (supérieur ou égal), `<=` (inférieur ou égal), `<` (inférieur), `>` (supérieur).
    - **Opérateurs d'incrémentation :** `++` (incrémentation), `--` (décrémentation).

2. **Autres opérateurs :**
    - **Opérateurs simplifiés :** `+=`, `-=`, etc.
    - **Opérateurs binaires (manipulation de bits) :** `&` (ET binaire), `|` (OU binaire), `^` (OU exclusif), `~` (complément à un), `<<` (décalage de bits à gauche), `>>` (décalage de bits à droite).
    - **Opérateur ternaire :** `? :` (opérateur ternaire), par exemple : `z = (a > b) ? a : b;`.
    - **Opérateur sizeof :** `sizeof(i)` donne la taille en octets de la variable `i` ou du type spécifié.

3. **Surcharge des opérateurs :**
    - En C++, la surcharge des opérateurs permet de redéfinir le comportement des opérateurs pour des types de données personnalisés (par exemple, les classes).
    - Par exemple, on peut surcharger l'opérateur de comparaison `<` pour comparer des objets de classe personnalisée comme des motos dans l'exemple donné.

```cpp
class Moto {
public:
    int vitesse;

    // Surcharge de l'opérateur <
    bool operator<(const Moto& autreMoto) const {
        return vitesse < autreMoto.vitesse;
    }
};

int main() {
    Moto Kawa(80), BMW(100);
    if (Kawa < BMW) {
        cout << "La Kawa est plus lente que la BMW." << endl;
    }

    return 0;
}
```

### Opérateur +

1. **Utilisation de l'opérateur `+` :**
   - L'opérateur `+` peut être utilisé pour ajouter deux objets de la classe Complexe, représentant des nombres complexes.
   - Par exemple, `C3 = C1 + C2;` ajoute les nombres complexes `C1` et `C2` et stocke le résultat dans `C3`.

2. **Interprétation de l'opérateur `+` :**
   - Si l'opérateur `+` est implémenté en tant que fonction globale (fonction non membre de la classe), son utilisation sera interprétée comme `C3 = operator+(C1, C2);`.
   - Si l'opérateur `+` est implémenté en tant que méthode de classe (fonction membre de la classe), son utilisation sera interprétée comme `C3 = C1.operator+(C2);`.

3. **Surcharge par une méthode de classe :**
   - Dans l'exemple donné, la surcharge de l'opérateur `+` est réalisée en tant que méthode de classe pour la classe Complexe.
   - La surcharge est définie comme `Complexe Complexe::operator+(const Complexe & c2)`, prenant un objet `Complexe` en paramètre et renvoyant un nouvel objet `Complexe` qui représente la somme.

```cpp
class Complexe {
    float re, im;

public:
    Complexe(float r = 0.0, float i = 0.0);
    Complexe operator+(const Complexe &c2);
    float Re() const { return re; }
    float Im() const { return im; }
};

Complexe Complexe::operator+(const Complexe &c2) {
    Complexe res;
    res.re = re + c2.re;
    res.im = im + c2.im;
    return res;
    // Ou simplement : return Complexe(re + c2.re, im + c2.im);
}

int main() {
    Complexe C1(1.0, 2.0), C2(2.0, 3.0), C3;
    C3 = C1 + C2;

    return 0;
}
```

4. **Surcharge par une fonction globale (friend) :**
   - La surcharge peut également être réalisée en tant que fonction globale avec l'utilisation du mot-clé `friend`.

```cpp
class Complexe {
    float re, im;

public:
    friend Complexe operator+(Complexe &c1, Complexe &c2);
};

Complexe operator+(Complexe &c1, Complexe &c2) {
    return Complexe(c1.re + c2.re, c1.im + c2.im);
}

int main() {
    Complexe C1(1.0, 2.0), C2(2.0, 3.0), C3;
    C3 = C1 + C2;

    return 0;
}
```

Ces exemples illustrent comment l'opérateur `+` peut être surchargé soit en tant que méthode de classe, soit en tant que fonction globale (avec l'utilisation de `friend`). La surcharge permet d'ajouter des objets de la classe Complexe de manière intuitive.

### Quel type de surcharge choisir?

1. **Surcharge par une fonction globale :**
   - Si le premier opérande est un type de base (comme `int`, `ostream`, etc.), l'opérateur sera généralement surchargé en tant que fonction globale.
   - Exemple 1 : Surcharge de `operator+` pour un double et un objet `Complexe`.
   - Exemple 2 : Surcharge de `operator+` pour une chaîne (`string`) et un objet `Chaine`.

```cpp
// Exemple 1
Complexe operator+(double nb, Complexe &c2);

// Exemple 2
Chaine operator+(string mot1, Chaine &mot2);
```

2. **Surcharge par une fonction membre de classe :**
   - Si le premier opérande est une classe (comme `Complexe`, `Livre`, `Chaine`, etc.), l'opérateur sera généralement surchargé en tant que fonction membre de la classe.
   - Exemple 1 : Surcharge de `operator+` pour deux objets `Complexe`.
   - Exemple 2 : Surcharge de `operator+` pour un objet `Livre` et un entier (`int`).
   - Exemple 3 : Surcharge de `operator+` pour deux objets `Chaine`.
   - Exemple 4 : Surcharge de `operator<` pour deux objets `Moto`.

```cpp
// Exemple 1
Complexe Complexe::operator+(const Complexe &c2);

// Exemple 2
void Livre::operator+(int an);

// Exemple 3
Chaine Chaine::operator+(Chaine &mot2);

// Exemple 4
bool Moto::operator<(Moto &m2);
```

Ces exemples montrent comment choisir entre surcharger un opérateur en tant que fonction globale ou en tant que fonction membre en fonction du type du premier opérande. L'utilisation de la surcharge d'opérateurs contribue à rendre le code plus lisible et intuitif.

### Deux type de retour
1. **Modification de l'objet courant :**
   - L'opérateur modifie l'objet courant (`*this`) et renvoie une référence vers cet objet.
   - Cela implique que l'objet sur lequel l'opérateur est appelé est modifié.

```cpp
Complexe &Complexe::operator+(const Complexe &c2) {
    this->re += c2.re;
    this->im += c2.im;
    // Retour de l'objet courant modifié
    return *this;
}
```

2. **Résultat dans un nouvel objet :**
   - L'opérateur crée un nouvel objet (`Complexe res`) qui contient le résultat de l'opération.
   - Cela évite de modifier l'objet courant, mais il faut être attentif à la gestion de la mémoire car un nouvel objet est alloué dynamiquement. Il faut penser à libérer cet objet pour éviter les fuites de mémoire.

```cpp
Complexe &Complexe::operator+(const Complexe &c2) {
    // Objet courant non modifié
    Complexe &res = *new Complexe(*this);
    // Objet courant modifié
    // Complexe &res = *this;
    res.re += c2.re;
    res.im += c2.im;
    return res;
}
```

### Opérateur =

1. **Objectif de l'opérateur d'affectation :**
   - L'opérateur d'affectation est utilisé pour copier le contenu d'un objet existant (le droit operand, `t2` dans votre exemple) dans un autre objet existant (l'objet courant, `*this`).
   - Il est crucial de gérer correctement les ressources allouées dynamiquement (comme les tableaux) pour éviter les fuites de mémoire.

2. **Prévention de l'auto-affectation :**
   - Avant de commencer la copie, il est généralement recommandé de vérifier si l'objet n'est pas en train de s'auto-affecter (`this != &copie`).

3. **Libération des ressources existantes :**
   - Si l'objet courant (`*this`) possède des ressources allouées dynamiquement, ces ressources doivent être libérées avant d'effectuer la copie.

4. **Copie des données :**
   - Une fois les précautions prises, les données de l'objet source (`copie`) peuvent être copiées dans l'objet courant (`*this`).

5. **Retour de l'objet courant :**
   - Il est courant de retourner une référence vers l'objet courant après l'opération d'affectation (`return *this`). Cela permet des affectations chaînées comme `A = B = C`.

Voici un exemple général de l'opérateur d'affectation dans une classe :

```cpp
class Tableau {
    int* valeurs;
    int taille;
    int nb;

public:
    // ...

    Tableau& operator=(const Tableau& t2) {
        if (this != &t2) {
            // Libérer les ressources existantes
            delete[] valeurs;

            // Copier les données de l'objet source
            taille = t2.taille;
            nb = t2.nb;
            valeurs = new int[taille];
            for (int i = 0; i < taille; ++i)
                valeurs[i] = t2.valeurs[i];
        }

        // Retourner l'objet courant
        return *this;
    }
};
```

Cet opérateur d'affectation prend en compte les précautions nécessaires pour éviter l'auto-affectation et gérer les ressources dynamiques correctement.

### Opérateur []

1. **Objectif de l'opérateur d'indice :**
   - L'opérateur d'indice permet d'accéder à un élément spécifique d'un objet, similaire à l'indexation des tableaux.
   - Il peut être surchargé pour contrôler la validité de l'indice et définir des comportements spécifiques en lecture et en écriture.

2. **Syntaxe de la surcharge :**
   - La syntaxe générale de la surcharge de l'opérateur d'indice est `TYPE operator[] (INDICE);`.
   - Cela permet d'accéder à une composante de l'objet en utilisant la notation `OBJET[INDICE]`.

3. **Exemple de surcharge :**
   - L'exemple présenté montre la surcharge de l'opérateur d'indice dans la classe `Biblio` avec une version en lecture seule (`const`) et une version en lecture/écriture.
   - La version en lecture seule renvoie un objet `Livre`, tandis que la version en lecture/écriture renvoie une référence à un objet `Livre`. Cela permet d'utiliser l'opérateur d'indice pour lire et écrire dans la bibliothèque.

4. **Exemple avec une classe `Tableau` :**
   - La classe `Tableau` illustre un exemple d'opérateur d'indice pour un tableau dynamique d'entiers.
   - La surcharge de `operator[]` permet d'accéder à un élément du tableau (`valeurs`) et d'en modifier la valeur.

Voici un extrait de la classe `Tableau` :

```cpp
class Tableau {
    int taille, indice_libre;
    int *valeurs;

public:
    // ...

    // En lecture/écriture
    int& operator[](int i) {
        return valeurs[i];
    }

    // En lecture seule
    int operator[](int i) const {
        return valeurs[i];
    }

    // ...
};
```

Cet exemple montre comment l'opérateur d'indice peut être surchargé avec différentes versions pour prendre en compte les cas de lecture et d'écriture.

### Opérateur ++

1. **Objectif des opérateurs ++ :**
   - Les opérateurs d'incrémentation sont utilisés pour augmenter la valeur d'un objet numérique.

2. **Syntaxe de la surcharge :**
   - La syntaxe générale de la surcharge de l'opérateur préfixé (++OBJET) est `TYPE operator++();`, où `TYPE` est le type de l'objet.
   - La syntaxe générale de la surcharge de l'opérateur postfixé (OBJET++) est `TYPE operator++(int);`, où `int` est fictif et surcharge la fonction.

3. **Exemple de surcharge :**
   - L'exemple présenté montre la surcharge des deux versions de l'opérateur d'incrémentation (`++`) pour la classe `Complexe`.
   - La version de pré-incrémentation (`++OBJET`) augmente la partie réelle de l'objet et renvoie l'objet modifié.
   - La version de post-incrémentation (`OBJET++`) crée une copie de l'objet avant l'incrémentation, puis renvoie la copie.

Voici un extrait de la classe `Complexe` :

```cpp
class Complexe {
    float re, im;

public:
    // ...

    // Post-incrémentation (OBJET++)
    Complexe operator++(int) {
        Complexe old(*this);
        re++;
        return old;
    }

    // Pré-incrémentation (++OBJET)
    Complexe operator++() {
        re++;
        return *this;
    }

    // ...
};
```

Cet exemple montre comment les opérateurs d'incrémentation peuvent être surchargés pour modifier la valeur de l'objet de différentes manières. La version post-incrémentation crée une copie avant l'incrémentation, tandis que la version pré-incrémentation incrémente l'objet directement.

### Opérateur ()
1. **Objectif de l'opérateur de fonction :**
   - L'opérateur de fonction est utilisé pour créer des objets qui se comportent comme des fonctions. Cela peut simplifier l'accès à une fonction particulière de la classe.

2. **Syntaxe de la surcharge :**
   - La syntaxe générale de la surcharge de l'opérateur de fonction est `TYPE operator()(Paramètres formels);`, où `TYPE` est le type de retour de la fonction, et `Paramètres formels` sont les paramètres de la fonction.

3. **Exemple de surcharge :**
   - L'exemple présenté montre la surcharge de l'opérateur de fonction pour une classe `Iterateur`. Cela est souvent utilisé dans le contexte des itérateurs pour parcourir les éléments d'une structure de données.

Voici un extrait de la classe `Iterateur` :

```cpp
class Iterateur {
    Cell *p;

public:
    Iterateur(List &l) {
        p = l.tete;
    }

    // Opérateur de fonction ()
    Elem operator()() {
        return p->val;
    }

    // Opérateur d'incrémentation (++), permettant de passer à l'élément suivant
    void operator++() {
        p = p->suiv;
    }

    // Opérateur de conversion vers int, par exemple, pour obtenir la position dans la liste
    operator int() {
        return (int)p;
    }
};
```

Dans cet exemple, l'opérateur de fonction `()` est surchargé pour permettre l'accès à la valeur d'un élément via un itérateur. L'opérateur d'incrémentation (`++`) est également surchargé pour passer à l'élément suivant, et un opérateur de conversion vers `int` est fourni, permettant d'obtenir la position dans la liste, par exemple.

### Conversion de type
Les conversions de type, également appelées opérateurs de conversion de type ou cast, permettent de convertir une instance d'une classe vers un type primitif ou une autre classe. Voici quelques points à noter sur les conversions de type :

1. **Conversion explicite :**
   - Une conversion explicite est effectuée en utilisant le type de destination comme fonction de conversion. Par exemple, `z = double(n);` effectue une conversion explicite de `int` vers `double`.

2. **Conversions implicites :**
   - Les conversions implicites sont gérées automatiquement par le compilateur dans divers contextes tels que les affectations (`z = n;`), les appels de fonctions, et les expressions (`z + n`).

3. **Opérateur de cast dans une classe :**
   - Une classe peut définir un opérateur de cast pour permettre la conversion vers un type spécifié. La syntaxe générale est `operator T();`, où `T` est le type vers lequel la conversion est souhaitée.

4. **Exemple d'opérateur de cast dans une classe :**
   - Dans l'exemple de la classe `Complexe`, un opérateur de cast est défini pour convertir l'objet `Complexe` en `float`. Cela permet l'appel implicite de cet opérateur lorsqu'un objet `Complexe` est utilisé dans un contexte où un `float` est attendu.

Voici un extrait de l'exemple de la classe `Complexe` :

```cpp
class Complexe {
    // ...

public:
    // Opérateur de cast pour convertir Complexe en float
    operator float() {
        return re;
    }
};

Complexe c(2.0);
float f;
f = c; // Appel implicite de l'opérateur de cast float()
```

Dans cet exemple, l'opérateur de cast `operator float()` permet la conversion implicite d'un objet `Complexe` en `float` lorsqu'il est utilisé dans un contexte nécessitant un `float`.

## Polymorphisme

L'héritage en C++ est une caractéristique qui permet à une classe (appelée classe dérivée) de hériter des propriétés et des comportements d'une autre classe (appelée classe de base). Les membres publics et protégés de la classe de base sont accessibles dans la classe dérivée, selon le mode d'héritage utilisé.

### Modes d'héritage :
- **Héritage public (`class D : public B`)** : Les membres publics et protégés de la classe de base restent accessibles en tant que membres protégés de la classe dérivée. C'est le mode d'héritage le plus courant et il reflète une relation "est-un".

  ```cpp
  class D : public B {
      // ...
  };
  ```

- **Héritage privé (`class D : private B`)** : Les membres publics et protégés de la classe de base deviennent des membres privés de la classe dérivée. Cela signifie que la relation "est-un" est présente, mais n'est pas visible à l'extérieur de la classe dérivée.

  ```cpp
  class D : private B {
      // ...
  };
  ```

- **Héritage protégé (`class D : protected B`)** : Les membres publics et protégés de la classe de base deviennent des membres protégés de la classe dérivée. Cette forme est moins courante et est similaire à l'héritage privé.

  ```cpp
  class D : protected B {
      // ...
  };
  ```

### Exemple d'héritage public :

```cpp
// Classe de base
class Article {
protected:
    string nom;
    int quantite;
    float prix;

public:
    // Constructeur avec paramètres
    Article(char* n, int q, float p) : nom(n), quantite(q), prix(p) {}
};

// Classe dérivée
class Vetement : public Article {
protected:
    int taille;
    string coloris;

public:
    Vetement(string n, int q, float p, int t, string c)
        : Article(n, q, p), taille(t), coloris(c) {}

    void solder(float remise) {
        prix *= (1.0 - remise);
    }
};
```

Dans cet exemple, `Vetement` hérite publiquement de `Article`, ce qui signifie que les membres protégés de `Article` (`nom`, `quantite`, `prix`) deviennent des membres protégés de `Vetement`, accessibles dans la classe dérivée.

### Exemple d'héritage privé :

```cpp
class Pile : private Tableau {
    int niveau;

public:
    Pile(int t) : Tableau(t), niveau(0) {}

    bool vide() {
        return niveau == 0;
    }

    void empiler(int x) {
        (*this)[niveau++] = x;
    }

    int depiler() {
        return (*this)[--niveau];
    }
};
```

Dans cet exemple, `Pile` hérite privément de `Tableau`, ce qui signifie que les membres de `Tableau` sont présents dans `Pile`, mais sont inaccessibles en dehors de la classe `Pile`. Cela permet à `Pile` d'utiliser les fonctionnalités de `Tableau` pour implémenter une pile sans exposer publiquement ces fonctionnalités.


### Héritage et Constructeurs

Lorsqu'une classe dérivée est créée, plusieurs étapes sont suivies en ce qui concerne les constructeurs :

1. **Appel du Constructeur de la Classe de Base :** Lors de la création d'un objet de la classe dérivée, le constructeur de la classe de base est automatiquement appelé. Cela garantit que les membres de la classe de base sont correctement initialisés.

    ```cpp
    class Etudiant {
        string nom;
        // ...
    };

    class Doctorant : public Etudiant {
        string these;

    public:
        Doctorant() {
            // appel implicite du constructeur de Etudiant
            // ...
        }

        Doctorant(string n, string t) : Etudiant(n) {
            // appel explicite du constructeur de Etudiant
            these = t;
        }
    };
    ```

2. **Appel du Constructeur de la Classe Dérivée :** Ensuite, le constructeur de la classe dérivée est appelé. Cela garantit que les membres spécifiques à la classe dérivée sont initialisés correctement.

### Héritage et Destructeurs

Lors de la destruction d'un objet de la classe dérivée, les destructeurs sont appelés dans l'ordre inverse de l'héritage. Cela signifie que le destructeur de la classe dérivée est appelé en premier, suivi des destructeurs des classes de base.

### Héritage et Copie

Lorsqu'il s'agit de la copie d'objets dans l'héritage, deux cas sont généralement considérés :

1. **Pas de Constructeur Copie dans D :** Dans ce cas, l'appel au constructeur copie par défaut est effectué. Il appelle le constructeur copie de la classe de base (s'il existe) et copie membre à membre pour les membres de la classe dérivée.

2. **Avec un Constructeur Copie dans D :** Si la classe dérivée a son propre constructeur copie, il faut recopier la totalité de l'objet, y compris les membres de la classe de base.

    ```cpp
    class Etudiant {
        string nom;
        // ...
    };

    class Doctorant : public Etudiant {
        These* these;

    public:
        Doctorant(const Doctorant& copie) : Etudiant(copie) {
            // gestion correcte de la mémoire
            these = new These(*copie.these);
        }
    };
    ```

### Redéfinition d'une Méthode Héritée

Une classe dérivée peut redéfinir une méthode héritée de la classe de base. Pour accéder à la méthode masquée dans la classe dérivée, on peut utiliser la notation `ClasseDeBase::methode()`.

### Redéfinition / Surcharge

Une fonction d'une classe dérivée peut porter le même nom et les mêmes paramètres qu'une fonction de la classe de base. La fonction appelée dépend de l'objet appelant déterminé statiquement à la compilation.

### Attention !

Il est crucial de faire attention lors de la redéfinition de méthodes dans une classe dérivée, car cela peut masquer toutes les définitions héritées de la classe de base. Cela peut entraîner des résultats inattendus si on ne fait pas attention.


### Héritage Multiple

L'héritage multiple permet à une classe dérivée d'avoir plusieurs classes de base. Cela peut conduire à une complexité accrue et à des conflits potentiels, en particulier lorsqu'il y a des membres portant le même nom dans les classes de base.

#### Ordre d'appel des constructeurs

L'ordre d'appel des constructeurs dépend de l'ordre de déclaration de l'héritage. Dans l'exemple suivant :

```cpp
class CampingCar : public Caravane, public VehiculeMotorise {
public:
    CampingCar(int P, int S, int PUI) : VehiculeMotorise(PUI), Caravane(P, S) {}
};
```

Le constructeur de `VehiculeMotorise` sera appelé avant celui de `Caravane` en raison de l'ordre de déclaration.

#### Plusieurs chemins d'accès à Vehicule

Lorsqu'une classe dérivée a plusieurs chemins d'accès à une même classe de base (par exemple, `Caravane` et `VehiculeMotorise` héritent tous deux de `Vehicule`), il peut y avoir des ambiguïtés d'accès aux membres de la classe de base.

```cpp
CampingCar C;
C.vmax = 1;                      // Erreur
C.VehiculeMotorise::vmax = 2;    // OK
C.Caravane::vmax = 3;            // OK
```

#### Héritage Virtuel

Pour éviter la duplication d'informations, une classe de base peut être partagée si ses classes dérivées en héritent de manière virtuelle. Cela est réalisé en utilisant le mot-clé `virtual`.

```cpp
class Caravane : virtual public Vehicule { /* ... */ };
class VehiculeMotorise : virtual public Vehicule { /* ... */ };
```

#### Appel du Constructeur de la Classe Virtuelle

Dans l'exemple d'héritage virtuel, le constructeur de la classe virtuelle est appelé avant les autres constructeurs lors de la construction d'une classe dérivée.

#### Conflits de Membre

En cas de conflits de membres entre les classes de base, la solution est de préfixer le nom du membre par le nom de la classe qui le contient.

#### Polymorphisme d'Héritage

Le polymorphisme d'héritage permet à une fonction d'une classe dérivée de porter le même nom et les mêmes paramètres qu'une fonction de la classe de base, mais la fonction appelée dépendra du type réel de l'objet à l'exécution.

#### Définition du Polymorphisme

Le polymorphisme est réalisé grâce aux fonctions virtuelles, à l'héritage, et aux pointeurs. Il permet à une fonction appelée sur des objets de types différents de répondre différemment, car elle est codée différemment selon le type de l'objet.

#### Utilisation du Polymorphisme

Le polymorphisme peut être utilisé pour créer un tableau de pointeurs vers des objets de types différents, où une même instruction se comporte différemment selon le type réel de l'objet.


### Utilisation d'un Conteneur Hétérogène

Dans cet exemple, une liste de formes géométriques est créée à l'aide d'un conteneur hétérogène, c'est-à-dire un conteneur qui peut contenir des objets de types différents mais dérivant tous d'une classe de base commune (`Forme` dans ce cas). Chaque classe dérivée de `Forme` redéfinit la méthode virtuelle `dessiner()`.

```cpp
#include <list>

class Forme {
public:
    virtual void dessiner() = 0;
};

class Cercle : public Forme {
public:
    virtual void dessiner() override {
        // Implémentation du dessin pour un cercle
    }
};

class Rectangle : public Forme {
public:
    virtual void dessiner() override {
        // Implémentation du dessin pour un rectangle
    }
};

class Triangle : public Forme {
public:
    virtual void dessiner() override {
        // Implémentation du dessin pour un triangle
    }
};

class UneClasse {
private:
    std::list<Forme*> l;

public:
    void dessinerTout() {
        for (std::list<Forme*>::iterator it = l.begin(); it != l.end(); ++it) {
            (*it)->dessiner();
        }
    }
};
```

### Exemple avec Héritage et Fonctions Virtuelles

L'utilisation d'héritage et de fonctions virtuelles peut être particulièrement utile pour éviter les structures de contrôle complexes, comme les switchs. Par exemple, considérons la gestion de différents types de pièces d'échecs :

```cpp
enum TypePiece { REINE, FOU, PION };

class Piece {
public:
    virtual void deplacer() = 0;
};

class Reine : public Piece {
public:
    virtual void deplacer() override {
        // Implémentation du déplacement d'une reine
    }
};

class Fou : public Piece {
public:
    virtual void deplacer() override {
        // Implémentation du déplacement d'un fou
    }
};

class Pion : public Piece {
public:
    virtual void deplacer() override {
        // Implémentation du déplacement d'un pion
    }
};

void deplacer(Piece* typePiece) {
    typePiece->deplacer();
}
```

### Objets Polymorphes et Surcharge

Lorsque l'on travaille avec des objets polymorphes, la surcharge des fonctions dépend du type dynamique de l'objet. Dans l'exemple suivant :

```cpp
pta1->compare(pta2);    // Appel de Article::compare(Article* a)
pta2->compare(pta1);    // Appel de Vetement::compare(Article* a)
pta2->compare(pta2);    // Appel de Vetement::compare(Article* a)
pta2->compare(ptv1);    // Appel de Vetement::compare(Vetement* v)
```

La fonction `compare` est appelée en fonction du type réel des objets impliqués.

### Destructeurs Virtuels

Les destructeurs virtuels sont importants pour éviter les fuites mémoire lors de la destruction d'objets polymorphes. Dans l'exemple suivant, la classe de base `X` a un destructeur virtuel :

```cpp
class X {
private:
    int* p;

public:
    X() {
        p = new int[2];
    }

    virtual ~X() {
        delete[] p;
    }
};
```

Les destructeurs virtuels permettent de s'assurer que le destructeur approprié (de la classe dérivée) est appelé lors de la suppression d'un objet polymorphe.


### Interfaces en C++

En C++, une interface est souvent simulée en utilisant une classe abstraite ne contenant que des fonctions virtuelles pures. Voici un exemple d'interface en C++ :

```cpp
class IForme {
public:
    virtual void afficher() = 0;
    virtual float surface() = 0;
    virtual ~IForme() {}
};

class IDeuxDim : public IForme {
public:
    virtual float périmètre() = 0;
};

class ITroisDim : public IForme {
public:
    virtual float volume() = 0;
};

class Carre : public IDeuxDim {
public:
    void afficher() override {
        // Implémentation de l'affichage pour un carré
    }

    float surface() override {
        // Implémentation du calcul de la surface pour un carré
    }

    float périmètre() override {
        // Implémentation du calcul du périmètre pour un carré
    }
};
```

### RTTI (Run Time Type Information)

RTTI (Run Time Type Information) permet d'obtenir des informations sur le type d'un objet lors de l'exécution. Cela peut être utile pour prendre des décisions en fonction du type réel d'un objet. Voici un exemple utilisant `typeid` :

```cpp
#include <typeinfo>
#include <iostream>

void printClassName(Base *b) {
    std::cout << typeid(*b).name() << std::endl;
}
```

### Transtypage Dynamique (`dynamic_cast`)

`dynamic_cast` est un opérateur de transtypage dynamique qui permet de convertir un pointeur ou une référence d'un type de base vers un type dérivé de manière sûre. Voici un exemple :

```cpp
B* ptb = new D;

D* ptd = dynamic_cast<D*>(ptb);
if (ptd) {
    // La conversion a réussi, ptd est maintenant de type D*
    ptd->d();
} else {
    // La conversion a échoué, ptb ne pointe pas vers un objet de type D
    std::cout << "La conversion a échoué." << std::endl;
}
```

`dynamic_cast` est plus sûr que les casts traditionnels, car il effectue une vérification à l'exécution pour s'assurer que la conversion est valide. Si la conversion échoue, il renvoie `nullptr` pour un pointeur ou lance une exception `std::bad_cast` pour une référence.