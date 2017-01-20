package shell;

import java.io.File;
import java.util.Arrays;

/**
 * Wyświetla pliki i katalogi.
 * 
 * @author Bartłomiej Kulesa
 */
public class WyswietlaniePlikow {
    
    private File[] filesList;
    
    /**
     * Wyswietla pliki widoczne z podanego katalogu.
     * @param sciezka 
     */
    public void wyswietlPliki(String sciezka) {
        this.pobierzWszystko(sciezka);
        
        System.out.println("\n------- PLIKI --------");
        
        for (File file : filesList) {
            if (file.isFile() && !file.isHidden())  {
                System.out.print(file.getName());
            }
        }
        
        System.out.println();
    }
    
    /**
     * Wyświetla ukryte pliki z danego katalogu.
     * @param sciezka 
     */
    public void wyswietlPlikiUkryte(String sciezka) {
        this.pobierzWszystko(sciezka);
        
        System.out.println("\n------- PLIKI UKRYTE --------");
        
        for (File file : this.filesList) {
            if (file.isHidden())  {
                System.out.print(file.getName());
            }
        }
        
        System.out.println();
    }
    
    /**
     * Wyświetla katalogi z aktualnego katalogu.
     * @param sciezka 
     */
    public void wyswietlKatalogi(String sciezka) {
        this.pobierzWszystko(sciezka);
        
        System.out.println("------ KATALOGI ------");
        
        for (File file : this.filesList) {
            if (file.isDirectory() && !file.isFile() && !file.isHidden())  {
                System.out.println(file.getName());
            }
        }
        
        System.out.println();
    }
    
    /**
     * Tworzy obiekt pobierający wszystkie dane o plikach w podanym katalogu.
     * @param sciezka sciezka do katalogu z którego pobiera wszystkie dane o plikach
     */
    private void pobierzWszystko(String sciezka) {
        File dir = new File(sciezka);
        this.filesList = dir.listFiles();
        // Sortowanie nazw plików.
        Arrays.sort(this.filesList);
    }
    
}
