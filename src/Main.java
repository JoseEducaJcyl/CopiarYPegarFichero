import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Declaramos una lista para los textos
        ArrayList<String> textos = new ArrayList<>();
        //Leemos un fichero, en este caso "datos.txt" y guardamos los textos 
        //en la lista 
        try (BufferedReader reader = new BufferedReader(new
                FileReader("datos.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                textos.add(linea);
                //Y creamos un fichero, en este caso "copia.txt" y a traves del
                //contenido de la lista de textos, se rellena el fichero 
                try (BufferedWriter writer = new BufferedWriter(new
                        FileWriter("copia.txt"))) {
                    for (String texto : textos) {
                        for (int i = 0; i < texto.length(); i++) {
                            char caracter = texto.charAt(i);
                            if (caracter == '.') {
                                writer.newLine();
                            }
                        }
                        writer.write(texto);
                    }
                    System.out.println("Líneas escritas en el archivo.");
                } catch (IOException e) {
                    System.out.println("Ocurrió un error al escribir en el archivo: " +
                            e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " +
                    e.getMessage());
        }



    }
}
