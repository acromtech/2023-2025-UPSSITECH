#include "Book.h"

Book::Book(string title, int year){
    this->title=title;
    this->year=year;
}
Book::Book(Book& cp){
    this->title=cp.title;
    this->year=cp.year;
}
Book::~Book(){
}