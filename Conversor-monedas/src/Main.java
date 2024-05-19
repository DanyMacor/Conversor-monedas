import com.google.gson.Gson;

import javax.net.ssl.SSLSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.Executor;

public class Main {
    public static void main(String[] args) {

        int opcion = 0;
        double cantidad = 0;
        double convertir = 0;
        String monedaEntrada;
        String monedaSalida;

        Scanner teclado = new Scanner(System.in);

        Convertidor conversion = new Convertidor();
        API consultaAPI = new API();
        Json jsonToClass = consultaAPI.consultarApi();

        System.out.println("Conversor de monedas :) ");

        do {
            try {
                System.out.println("1 - Dolares  Soles Peruanos\n" +
                        "2 - Pesos Mexicanos a dolares\n" +
                        "3 - Pesos Colombianos a dolares\n" +
                        "4 - Pesos argentinos a dolares\n" +
                        "5 - Salir\n" +
                        "Elija una opción valida");

                opcion = teclado.nextInt();

                switch (opcion) {
                    case '1':
                        conversion.imprimirSolicitarCantidad("Dolares", "Soles Peruanos");
                        cantidad = teclado.nextDouble();
                        convertir = conversion.convertirMonedas("Dolares", "Soles Peruanos", cantidad);
                        conversion.imprimirResultado(cantidad, "Dolares", convertir, "Soles Peruanos");
                        break;
                    case '2':
                        conversion.imprimirSolicitarCantidad("Dolares", "Pesos Mexicanos");
                        cantidad = teclado.nextDouble();
                        convertir = conversion.convertirMonedas("Dolares", "Pesos Mexicanos", cantidad);
                        conversion.imprimirResultado(cantidad, "Dolares", convertir, "Pesos Mexicanos");
                        break;
                    case '3':
                        conversion.imprimirSolicitarCantidad("Dolares", "Pesos Colombianos");
                        cantidad = teclado.nextDouble();
                        convertir = conversion.convertirMonedas("Dolares", "Pesos Colombianos", cantidad);
                        conversion.imprimirResultado(cantidad, "Dolares", convertir, "Pesos Colombianos");
                        break;
                    case '4':
                        conversion.imprimirSolicitarCantidad("Dolares", "Pesos Argentinos");
                        cantidad = teclado.nextDouble();
                        convertir = conversion.convertirMonedas("Dolares", "Pesos Argentinos", cantidad);
                        conversion.imprimirResultado(cantidad, "Dolares", convertir, "Pesos Argentinos");
                        break;
                    case '5':
                        System.out.println("Cerrando programa");
                        break;
                    default:
                        System.out.println("Opción incorrecta");
                        break;
                }
            } catch (NullPointerException e) {
                System.out.println("Error: Una o más divisas no fueron encontradas, verifique.");
                teclado.nextLine();
            } catch (Exception e) {
                System.out.println("Error: Debes ingresar un número entero válido.");
                teclado.nextLine();
            }
        } while (opcion != 5);
    }

}