# ProgramareWebJava

## Aplicatia Extreme World

Doresc sa implementez un backend pentru gestionarea locurilor unde se pot practica sporturi extreme si pentru a ajuta oamenii sa aleaga perioada cea mai buna in care pot merge acolo.
In cadrul unui loc se pot practica mai multe tipuri de sporturi extreme si fiecare are o perioada din an in care poate fi practicat (ex. schi dec-feb; parapanta mai-aug; ATV tot anul; etc) si un cost mediu per zi de practicat. 
Locurile apartin de o structura ierarhica ce cuprinde tari, regiuni, localitati. Acest lucru ii va permite unui client sa caute o vacanta la schi in Romania sau in regiunea Brasovului sau doar in Predeal, in perioada feb-mar. 

Vom avea doua tipuri de utilizatori ai aplicatiei: admin si client. Voi implementa partea de autentificare si inregistrare pentru a putea diferentia intre actiunile permise unui utilizator.

Contul de admin poate:
- adugarea locatiilor pentru sporturi extreme
- stergerea si modificarea locatiilor
- setarea costului mediu pe zi a unui sport
- setarea perioadei din an in care se poate efectua un sport extrem intr-o anumita locatie
- setarea numarului de locuri la un sport extrem intr-o anumita perioada.

Contul de client poate:
- sa faca o rezervare pentru un sport extrem
- sa anuleze o rezervare
- sa verifice care sunt cele mai bune oferte pentru un sport extrem intr-o anumita perioada
- sa verifice daca mai sunt locuri intr-o anumita perioada pentru un anumit sport extrem
- sa gaseasca ofertele care se incadreaza in bugetul sau dupa un min si max price.

Pentru inceput, ma voi ocupa de implementarea modulului de autentificare pentru a asigura optima functionare a aplicatiei. Dupa autentificare, utilizatorul, in functie de rolul sau, va avea acces la endpointurile specifice pentru acel cont.
Vor trebui adaugate cateva locatii cu sporturile, perioada si costurile aferente. De asemenea va trebui setat numarul de locuri disponibile pentru fiecare sport.
Un client se va putea inregistra utilizand adresa de mail, numele, prenumele si o parola. Ulterior acesta se va putea autentifica si va putea sa caute si sa vada toate locatiile si ce sporturi se practica in locatia respectiva. Clientul o sa selecteze o anumita locatie, in functie de sport, perioada, pret si disponibilitate si o sa isi faca o rezervare. In urma rezervarii efectuate, numarul de locuri disponibile se va modifica. In cazul in care clientul nu mai are cum sa ajunga in perioada in care si-a facut rezervarea, acesta poate sa o anuleze (numarul de locuri din nou va fi updatat).
Utilizatorii neautentificati vor putea doar sa caute si sa vada locatiile in aplicatie, fara sa poata sa faca o rezervare.
