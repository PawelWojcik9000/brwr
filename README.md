## Browarmistrz - aplikacja dla piwowarów domowych

#### Opis
Browarmistrz jest to aplikacja przeznaczona dla miłośników warzenia piwa samodzielnie w domu. Może z niej skorzystać zarówno 
osoba z doświadczeniem, jak i początkujący amator. Program pozwala na założenie konta oraz dodawanie przepisów na piwo. 
Następnie na podstawie danego przepisu aplikacja przeprowadza użytkownika przez proces warzenia krok po kroku. Pobierając dane 
z przepisu program podpowiada między innymi odpowiednią ilość wody dla danej warki, temperaturę procesu, czas gotowania, 
chmielenia, dodawania dodatków, etc. Możliwe jest też dodawanie przepisu jako publiczny, dzięku czemu skorzystać może z niego 
każdy, nawet niezarejestrowany odwiedzający. Baza przepisów publicznych dostępna jest dla każdego. Aplikacja zawiera również 
kalkulator, który oblicza potencjalną zawartość alkoholu w gotowym piwie. Ponadto pod adresem 
http://localhost:8080/Browarmistrz/adminpage dostępny jest panel administracyjny, który pozwala na zarządzanie użytkownikami 
oraz przepisami. 

#### Instalacja
Aplikacja korzysta z bazy danych MySQL. Aby uruchomić program na serwerze, trzeba ustawić login oraz hasło do bazy danych 
w pliku konfiguracyjnym persistence.xml. Domyślnie ustawione dane logowania: 
- login: root
- hasło: coderslab

W zrzucie bazy danych, który ładowany jest przy uruchomieniu aplikacji, założone są dwa konta: administratora oraz zwykłego 
użytkownika. Dane logowania: 
###### Admin
- login: admin
- hasło: admin
###### User
- login: user
- hasło: userpass

Konto usera ma dodany przykładowy przepis na piwo pszeniczne. Można zobaczyć jak działa proces warzenia. 
Dla celów demonstracyjnych liczniki czasu działają w znacznym przyspieszeniu. Aby korzystać z aplikacji w praktyce, trzeba 
w pliku brewit.js zmienić wartość 10 na 1000 w linii 77.
