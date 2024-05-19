import java.text.DecimalFormat;

public class Convertidor {
    double moneda1 = 0;
    double moneda2 = 0;

    API conexionAPI = new API();
    Json jsonToClass = conexionAPI.consultarApi();


    public void imprimirSolicitarCantidad(String monedaEntrada, String monedaSalida) {
        System.out.println("""
                ==============================================
                """ + monedaEntrada + """ 
                \s ==> \s""" + monedaSalida + """
                \nIngresa el valor que deseas convertir: 
                """);
    }

    public double convertirMonedas(String monedaOrigen, String monedaDestino, double cantidad) {
        moneda1 = jsonToClass.tasa_conversion().get(monedaDestino); //
        moneda2 = jsonToClass.tasa_conversion().get(monedaOrigen); //
        return (moneda1 / moneda2) * cantidad;
    }

    public void imprimirResultado(double cantidad, String monedaOrigen, double convertir, String monedaDestino) {
        DecimalFormat df = new DecimalFormat(); //Instancia de DecimalFormat para formatear el double "convertir" a 2 decimales
        System.out.println(cantidad + " " + monedaOrigen + " = " + df.format(convertir) + " " + monedaDestino);
        System.out.println("==============================================\n");
    }
}