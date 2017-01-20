package shell;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Zapisuje dane do pliku. Tworzy nowy pusty plik. Odczytuje zawartość pliku.
 *
 * @author Bartłomiej Kulesa
 */
public class ZapisOdczyt {

    public void utworzPlik(String sciezka, String nazwaPliku) throws FileNotFoundException {

        String sciezkaNazwaPliku = sciezka + '/' + nazwaPliku;

        File file = new File(sciezkaNazwaPliku);

        if (file.exists()) {
            System.out.println("Plik już istnieje! czy nadpisać plik? [t\\n]");
            Scanner odczyt = new Scanner(System.in);

            switch (odczyt.nextLine()) {
                case "t":
                    PrintWriter zapis = new PrintWriter(sciezkaNazwaPliku);
                    zapis.close();
                    break;
                    
                default:
                    System.out.println("Plik nie został utworzony.");
            }

        } else {
            PrintWriter zapis = new PrintWriter(sciezkaNazwaPliku);
            zapis.close();
        }
    }

    public void odczytajPlik(String sciezka, String nazwaPliku) throws FileNotFoundException, IOException {

        String sciezkaNazwaPliku = sciezka + '/' + nazwaPliku;

        File file = new File(sciezkaNazwaPliku);
        if (file.exists()) {
            FileReader fileReader = new FileReader(file);
            try (BufferedReader bfReader = new BufferedReader(fileReader)) {
                bfReader.lines().forEach(System.out::println);
            }
        } else {
            System.out.println("Nie można dokonać odczytu, ponieważ plik nie istnieje!");
        }
    }

}
