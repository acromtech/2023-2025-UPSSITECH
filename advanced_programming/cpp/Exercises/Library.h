#include <iostream>
#include "Book.h"

using namespace std;

class Library{
    private:
        Book* Book_tab;
        int max_size;
        int nb_Elements;
    
    public: 
        Library(int max_size=10);
        Library(Library& cp);
        Library& operator=(Library&);
        ~Library();

    friend ostream& operator<<(ostream& out,Library& lib);
};