package shell;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Zajmuje się tworzeniem ścieżki do katalogu. Ścieżka ta będzie wyznacznikiem
 * tego gdzie obecnie się znajdujemy.
 *
 * @author Bartłomiej Kulesa
 */
public class TworzenieSciezki {

    private final ArrayList<String> sciezka = new ArrayList<>();

    public TworzenieSciezki() {
        this.tworzSciezkePoczatkowa();
    }

    /**
     * Tworzy ścieżkę początkową.
     * Jest to home/user.
     */
    public void tworzSciezkePoczatkowa() {
        
        this.sciezka.clear();
        
        // Pobranie zmiennej środowiskowej HOME.
        String sciezkaPoczatkowa = System.getenv("HOME");
        // Rozbicie scieżki.
        String katalogi[] = sciezkaPoczatkowa.split("/");
        // Wstawienie nazw katalogu do listy.
        this.sciezka.addAll(Arrays.asList(katalogi));
    }
    
    /**
     * Dodaje kolejną nazwę katalogu do istniejącej już ścieżki.
     * Na początku sprawdza czy katalog istnieje.
     * 
     * @param nazwaKatalogu nazwa katalogu jaki chcemy dodać do ścieżki. 
     */
    public void wejdzDoKatalogu(String nazwaKatalogu) {
        // Pobranie wszystkich nazw katalogów i sprawdzenie czy podany katalog istnieje na dysku.
        File dir = new File(this.toString());
        File[] filesList = dir.listFiles();
        
        boolean flaga = false;

        for (File file : filesList) {
            if ((file.isDirectory() && !file.isFile()) && (file.getName().equals(nazwaKatalogu))) {
                flaga = true;
            }
        }
        
        if (flaga) {
            // Dodaje nazwę katalogu do ścieżki.
            this.sciezka.add(nazwaKatalogu);
        } else {
            // Komunikat o błędzie.
            System.out.println("Nie ma takiego katalog!");
        }
    }
    
    /**
     * Usuwan z listy ścieżka ostatnią wartość, skraca ścieżkę.
     * Przechodzi do katalogu nadrzędnego.
     */
    public void przejdzDoNadrzednegoKatalogu() {
        
        if (this.sciezka.size() > 1) {
            this.sciezka.remove(this.sciezka.size() - 1); 
        }
        
    }

    /**
     * Łączenie scieżki listy w jeden string.
     *
     * @return string z całą połączoną ścieżką.
     */
    @Override
    public String toString() {

        String polaczonaSciezka = "";

        for (String s : this.sciezka) {
            polaczonaSciezka += s;
            polaczonaSciezka += '/';
        }

        return polaczonaSciezka;

    }

}
