#include <iostream>
#include "Library.h"

Library::Library(int max_size){
    this->nb_Elements=0;
    this->max_size=max_size;
    this->Book_tab=new Book[this->max_size];
}
Library::Library(Library& cp){
    this->nb_Elements=cp.nb_Elements;
    this->max_size=cp.max_size;
    this->Book_tab=new Book[this->max_size];
    for(int i=0;i<cp.nb_Elements;i++){
        this->Book_tab[i]=cp.Book_tab[i];
    }
}
Library::~Library(){
    this->nb_Elements=0;
    this->max_size=0;
    delete[] this->Book_tab;
    /*
    Warning : 
        delete(tab_name)" delete the first tab place because it only point on the first tab place
        delete[] name_tab" delete all tab place
    */
}

Library& Library::operator=(Library& cp){
    if(this!=&cp){
        delete[]this->Book_tab;
        this->max_size=cp.max_size;
        this->nb_Elements=cp.nb_Elements;
        this->Book_tab=new Book[cp.max_size];
        for(int i=0;i<nb_Elements;i++){
            this->Book_tab[i]=cp.Book_tab[i];
        }
    }
    /*
    Warning : Don't code this like that
        if(this!=&copie){
            ~Library();
            Library(cp);
        }
    */
   return *this;
}

ostream& operator<<(ostream& out, Library& lib){
    out<<"taille"<<lib.max_size;
    out<<"nb"<<lib.nb_Elements;
    for(int i=0;i<lib.nb_Elements;i++){
        out<<lib.Book_tab[i];
    }
    return out;
}