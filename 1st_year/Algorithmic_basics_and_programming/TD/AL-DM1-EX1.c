void main()
{
    int note;
    printf("Saisissez la note de l'étudiant :");
    note=scanf();
    printf("La mention de l'élève est : ");
    if(note>=0 && note<10)
    {
        printf("Insufisante");
    }   
    else if (note>=10 && note<12)
    {
        printf("Passable");
    }   
    else if (note>=12 && note<14)
    {
        printf("AB");
    }
    else if (note>=14 && note<16)
    {
        printf("B");
    }
    else if (note>=16)
    {
        printf("TB");
    }  
    else
    {
        printf("note invalide");
    }
        
}