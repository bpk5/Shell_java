package shell;

/**
 * Zawiera informacje na temat wszystkich poleceń.
 *
 * @author Bartłomiej Kulesa
 */
public class Pomoc {

    /**
     * Wyświetla na ekranie informacje na temat dostępnych komend.
     */
    public void wyswietlPomoc() {

        System.out.println();
        System.out.println("---------------------------- POMOC -----------------------------------");
        System.out.println();
        System.out.println("sp                - przejście do katalogu /home/user");
        System.out.println("sp ..             - przejście do katalogu nadrzędnego");
        System.out.println("sp nazwaPliku     - przejście do katalogu o podanej nazwie");
        System.out.println("kp nazwaPliku /ścieżka/nazwaPliku.txt");
        System.out.println("                  - kopiowanie pliku z katalogu, w którym się znajdujemy");
        System.out.println("                    do dowolnego miejsca na dysku (Uwaga dla miejsca)");
        System.out.println("                    docelowego musimy podać pełną ścieżkę");
        System.out.println("                    oraz nową nową nazwę pliku.");
        System.out.println("                    przykład:");
        System.out.println("                       kp plik.txt /home/user/nowyPlik.txt");
        System.out.println("wp                - wyświetla pliki");
        System.out.println("wp -u             - wyświetla pliki i katalogi ukryte");
        System.out.println("wp -k             - wyświetla tylko katalogi");
        System.out.println("up nazwaPliku     - tworzy nowy plik o podanej nazwie");
        System.out.println("op nazwaPliku     - wyświetla zawartość pliku tekstowego");
        System.out.println("dl nazwaPliku     - kasuje plik");
        System.out.println("pomoc             - pomoc");
        System.out.println("wyjdz             - wyjście z programu");
        System.out.println("---------------------------- POMOC -----------------------------------");
        System.out.println();
    }

}
