package shell;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Kopiowanie pliku. Klasa kopiuje plik, należy podać ścieżkę do pliku, który ma
 * być kopiowany i ścieżkę oraz nazwę pliku nowo utworzonego.
 *
 * @author Bartłomiej Kulesa
 */
public class Kopiowanie {

    /**
     * Kopiuje plik.
     *
     * @param sciezka1 scieżka do pliku, który będziemy kopiować
     * @param sciezka2 scieżka gdzie ma być plik skopiowany, należy podać nazwę
     * pliku.
     */
    public void kopiuj(String sciezka1, String sciezka2) {
        DataInputStream strumienWejsciowy = null;
        DataOutputStream strumienWyjsciowy = null;

        boolean flaga = true;

        File file = new File(sciezka2);

        if (file.exists()) {
            System.out.print("Plik o podanej nazwie już istnieje! Czy nadpisać plik? [t\\n]");
            Scanner odczyt = new Scanner(System.in);

            if (odczyt.nextLine().trim().equals("t")) {
                flaga = true;
            } else {
                flaga = false;
            }

        }
        
        System.out.println("flaga = " + flaga);

        if (flaga) {
            int iloscSczytanychBajtow = 0;
            int calkowitaIloscBajtow = 0;

            byte[] bufor = new byte[1024];

            try {

                strumienWejsciowy = new DataInputStream(new FileInputStream(sciezka1));
                strumienWyjsciowy = new DataOutputStream(new FileOutputStream(sciezka2));

                try {
                    while ((iloscSczytanychBajtow = strumienWejsciowy.read(bufor)) != -1) {
                        strumienWyjsciowy.write(bufor, 0, iloscSczytanychBajtow);
                        calkowitaIloscBajtow += iloscSczytanychBajtow;
                    }
                } catch (IOException e) {
                    System.out.println("Bład wejścia-wyjścia");
                }

            } catch (FileNotFoundException e) {
                System.out.println("Nie można wykonać kopiowania. Błędnie wprowadzone polecenie.");
            }

            try {
                if (strumienWejsciowy != null) {
                    strumienWejsciowy.close();
                }
                if (strumienWyjsciowy != null) {
                    strumienWyjsciowy.close();
                }
            } catch (IOException e) {
                System.out.println("Błąd zamykania strumieni");
            }
            
            System.out.println("Ilość przekopiowanych danych: " + calkowitaIloscBajtow + " B");
        }
    }
}
