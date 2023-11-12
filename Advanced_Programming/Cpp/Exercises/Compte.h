#include <iostream>

using namespace std;

class Compte{
    private:
        float sold=0;
    
    public: 
        Compte();
        void depot(float val);
        void retrait(float val);
        void printSold();
        float getSold();
        void virement(Compte& c, float val);
};
