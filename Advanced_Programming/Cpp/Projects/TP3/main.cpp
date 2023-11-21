#include <iostream>
#include "Document.h"
#include "Livre.h"
#include "Article.h"

using namespace std;

int main() {
    // Test de la classe Document
    Document doc1("C++ Programming", "Introduction to C++ programming language.", "John Doe");
    doc1.display();

    cout << "\nCloning the document...\n\n";
    Document doc2 = doc1.clone();
    doc2.display();

    // Test de la classe Livre
    Livre livre1("The C++ Programming Language", "A classic book on C++.", "Bjarne Stroustrup", "Addison-Wesley", 1985);
    livre1.display();

    cout << "\nCloning the book...\n\n";
    Livre livre2 = livre1.clone();
    livre2.display();

    // Test de la classe Article
    Article article1("Magazine Title", "Summary of the article.", "Jane Doe", "Tech Magazine", "Tech Publications", 123);
    article1.display();

    cout << "\nCloning the article...\n\n";
    Article article2 = article1.clone();
    article2.display();

    // Test de l'opérateur d'affectation pour Livre
    Livre livre3;
    livre3 = livre1;  // Utilisation de l'opérateur d'affectation
    cout << "\nAssignment operator test for Livre:\n";
    livre3.display();

    // Test de l'opérateur d'affectation pour Article
    Article article3;
    article3 = article1;  // Utilisation de l'opérateur d'affectation
    cout << "\nAssignment operator test for Article:\n";
    article3.display();

    return 0;
}
