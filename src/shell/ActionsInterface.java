package shell;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Interfejs wzorca Command
 * @author Bartłomiej Kulesa
 */
public interface ActionsInterface {
    void action(TworzenieSciezki sciezka, String tKomenda[]);
}

// Tworzy ścieżkę początkową /home/user.
class ActionTworzSciezkePoczatkowa implements ActionsInterface {

    @Override
    public void action(TworzenieSciezki sciezka, String tKomenda[]) {
        sciezka.tworzSciezkePoczatkowa();
    }
    
}

// Przechodzi do katalogu nadrzędnego.
class ActionPrzejdzDoNadrzednegoKatalogu implements ActionsInterface {

    @Override
    public void action(TworzenieSciezki sciezka, String tKomenda[]) {
        sciezka.przejdzDoNadrzednegoKatalogu();
    }
    
}

// Wchodzi do podanego katalogu.
class ActionWejdzDoKatalogu implements ActionsInterface {

    @Override
    public void action(TworzenieSciezki sciezka, String tKomenda[]) {
        sciezka.wejdzDoKatalogu(tKomenda[1]);
    }
    
}

class ActionKopiowanie implements ActionsInterface {

    @Override
    public void action(TworzenieSciezki sciezka, String tKomenda[]) {
        String sciezki[] = tKomenda[1].split(" /", 2);
        if (sciezki.length == 1) {
            System.out.println("Błędnie wprowadzona ścieżka.");
        } else {
            sciezki[0] = sciezka + sciezki[0].trim();
            sciezki[1] = "/" + sciezki[1].trim();
            Kopiowanie kopiowanie = new Kopiowanie();
            kopiowanie.kopiuj(sciezki[0], sciezki[1]);
        }
    }
}

// Wyświetla w terminalu pliki (widoczne).
class ActionWyswietlPliki implements ActionsInterface {

    @Override
    public void action(TworzenieSciezki sciezka, String tKomenda[]) {
        WyswietlaniePlikow wyswietlPliki = new WyswietlaniePlikow();
        wyswietlPliki.wyswietlPliki(sciezka.toString());
    }
    
}

// Wyświetla w terminalu ukryte pliki.
class ActionWyswietlPlikiUkryte implements ActionsInterface {

    @Override
    public void action(TworzenieSciezki sciezka, String tKomenda[]) {
        WyswietlaniePlikow wyswietlPliki = new WyswietlaniePlikow();
        wyswietlPliki.wyswietlPlikiUkryte(sciezka.toString());
    }
    
}

// Wyświetla w terminalu katalogi.
class ActionWyswietlKatalogi implements ActionsInterface {

    @Override
    public void action(TworzenieSciezki sciezka, String tKomenda[]) {
        WyswietlaniePlikow wyswietlPliki = new WyswietlaniePlikow();
        wyswietlPliki.wyswietlKatalogi(sciezka.toString());
    }
    
}

// Tworzy nowy pusty plik.
class ActionUtworzPlik implements ActionsInterface {

    @Override
    public void action(TworzenieSciezki sciezka, String tKomenda[]) {
        ZapisOdczyt zapisOdczyt = new ZapisOdczyt();
        try {
            zapisOdczyt.utworzPlik(sciezka.toString(), tKomenda[1]);
        } catch (FileNotFoundException ex) {
            System.out.println("Nie można utworzyć pliku.");
        }
    }
    
}

// Odczytuje zawartość pliku i wyświetla w terminalu.
class ActionOdczytajPlik implements ActionsInterface {

    @Override
    public void action(TworzenieSciezki sciezka, String tKomenda[]) {
        ZapisOdczyt zapisOdczyt = new ZapisOdczyt();
        try {
            zapisOdczyt.odczytajPlik(sciezka.toString(), tKomenda[1]);
        } catch (IOException ex) {
            System.out.println("Nie można odczytać pliku.");
        }
    }
    
}

// Kasuje plik.
class ActionKasowaniePliku implements ActionsInterface {

    @Override
    public void action(TworzenieSciezki sciezka, String[] tKomenda) {
        KasowaniePliku kasowaniePliku = new KasowaniePliku();
        kasowaniePliku.kasujPlik(sciezka.toString(), tKomenda[1]);
    }
    
    
}

// Wyświetla pomoc.
class ActionPomoc implements ActionsInterface {

    @Override
    public void action(TworzenieSciezki sciezka, String[] tKomenda) {
        Pomoc pomoc = new Pomoc();
        pomoc.wyswietlPomoc();
    }
    
    
}






















