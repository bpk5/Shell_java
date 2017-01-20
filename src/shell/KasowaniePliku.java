package shell;

import java.io.File;

/**
 * Kasuje plik z dysku.
 *
 * @author Bartłomiej Kulesa
 */
public class KasowaniePliku {

    /**
     * Kasuje plik z dysku.
     * @param sciezka ścieżka do katalogu, w którym znajduje się plik.
     * @param nazwaPliku nazwa pliku, który będzie kasowany.
     */
    public void kasujPlik(String sciezka, String nazwaPliku) {
        File file = new File(sciezka + nazwaPliku);

        if (file.exists()) {
            file.delete();
            System.out.println("Plik został skasowany.");
        } else {
            System.out.println("Nie ma takiego pliku.");
        }

    }
}
