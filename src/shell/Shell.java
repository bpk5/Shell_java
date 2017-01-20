package shell;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Bartłomiej Kulesa
 */
public class Shell {

    private final ArrayList<ActionsInterface> actionsList;

    public Shell() {
        this.actionsList = new ArrayList<>();
    }

    public static void main(String[] args) {
        System.out.println("Aby uzyskać informacje o dostępnych komendach wpisz: pomoc");
        Shell shell = new Shell();
        shell.mapaAkcji();
        shell.wykonujGlownaPetle();
    }

    /**
     * Utworzenie tablicy z wszystkimi obiektami akcjami.
     */
    private void mapaAkcji() {
        actionsList.add(new ActionTworzSciezkePoczatkowa()); // 0 sp
        actionsList.add(new ActionPrzejdzDoNadrzednegoKatalogu()); // 1 sp ..
        actionsList.add(new ActionWejdzDoKatalogu()); // 2 sp nazwaKatalogu
        actionsList.add(new ActionKopiowanie()); // 3 kp nazwaPliku /pelna/scieżka/nazwaPliku
        actionsList.add(new ActionWyswietlPliki()); // 4 wp
        actionsList.add(new ActionWyswietlPlikiUkryte()); // 5 wp -u
        actionsList.add(new ActionWyswietlKatalogi()); // 6 wp -k
        actionsList.add(new ActionUtworzPlik()); // 7 up nazwaPliku
        actionsList.add(new ActionOdczytajPlik()); // 8 op nazwaPliku
        actionsList.add(new ActionKasowaniePliku()); // 9 dl nazwaPliku
        actionsList.add(new ActionPomoc()); // 10 pomoc
    }

    /**
     * Metoda z główną pętlą.
     * Na podstawie wprowadzonej komendy z klawiatury wybiera
     * odpowiednią klasę akcję.
     */
    private void wykonujGlownaPetle() {
        TworzenieSciezki sciezka = new TworzenieSciezki();
        Scanner odczyt = new Scanner(System.in);

        String komenda;
        String tKomenda[];
        int rozmiarTab;
        boolean dzialaj = true;

        while (dzialaj) {
            // Wyświetlanie ścieżki
            System.out.print(sciezka + ": ");

            komenda = odczyt.nextLine();    // Pobieranie danych z terminala.
            komenda = komenda.trim();   // Usunięcie białych znaków

            // Rozdzielenie komendy.
            tKomenda = komenda.split(" ", 2);
            rozmiarTab = tKomenda.length;

            switch (tKomenda[0]) {
                case "sp":
                    if (rozmiarTab == 1) {
                        this.actionsList.get(0).action(sciezka, null);
                    } else if (tKomenda[1].equals("..")) {
                        this.actionsList.get(1).action(sciezka, null);
                    } else {
                        this.actionsList.get(2).action(sciezka, tKomenda);
                    }
                    break;

                case "wp":
                    if (rozmiarTab == 1) {
                        this.actionsList.get(4).action(sciezka, null);
                    } else if (tKomenda[1].equals("-k")) {
                        this.actionsList.get(6).action(sciezka, null);
                    } else if (tKomenda[1].equals("-u")) {
                        this.actionsList.get(5).action(sciezka, null);
                    }
                    break;

                case "op":
                    if (rozmiarTab == 1) {
                        System.out.println("Podaj nazwę pliku.");
                    } else {
                        this.actionsList.get(8).action(sciezka, tKomenda);
                    }
                    break;

                case "up":
                    if (rozmiarTab == 1) {
                        System.out.println("Podaj nazwę pliku.");
                    } else {
                        this.actionsList.get(7).action(sciezka, tKomenda);
                    }
                    break;

                case "kp":
                    if (rozmiarTab == 1) {
                        System.out.println("Podaj nazwę pliku, a następnie pełną ścieżkę i nazwę pliku.");
                    } else {
                        this.actionsList.get(3).action(sciezka, tKomenda);
                    }
                    break;

                case "dl":
                    if (rozmiarTab == 1) {
                        System.out.println("Podaj nazwę pliku.");
                    } else {
                        this.actionsList.get(9).action(sciezka, tKomenda);
                    }
                    break;

                case "pomoc":
                    this.actionsList.get(10).action(null, null);
                    break;

                case "wyjdz":
                    dzialaj = false;
                    break;

                default:
                    System.out.println("Nie znaleziono polecenia.");
            }

        }
    }
}
