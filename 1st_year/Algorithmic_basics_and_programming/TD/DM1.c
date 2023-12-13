void test_note_switch()
{
    int note;
    printf("Saisissez la note de l'étudiant :");
    note=scanf();
    if (note>=0 && note<=20)
    {
        printf("La mention de l'élève est : ");

        switch(note)
        case <10:
            printf("Insufisante");
            break;
        case >=10 && <12:
            printf("Passable");
            break;
        case >=12 && <14:
            printf("AB");
            break;
        case >=14 && <16:
            printf("B");
            break;
        case >=16:
            printf("TB");
            break;
    }
    else printf("note invalide")
}

void main ()
{
    test_note_switch()
}