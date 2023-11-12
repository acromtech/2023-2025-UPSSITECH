#include <iostream>

using namespace std;

class Book{
    private:
        string title;
        int year;

    public: 
        Book(string title="", int year=0);
        Book(Book& cp);
        ~Book();

    friend ostream& operator<<(ostream& out,Book& cp){
        out<<"title"<<cp.title;
        out<<"year"<<cp.year;
        return out;
    }
};