package src;

import java.util.Scanner;

public class Menu {
    /**
     * Tarifas recibidas por la consulta a la API.
     */
    private Tarifas tarifas;

    /**
     * Flag para terminar el programa o continuarlo.
     */
    private boolean terminar;

    private int moneda_base, moneda_conversion; // 1 -> ARS, 2 -> BOB, ...
    private String nombre_base, nombre_conversion; // Nombre: ARS, USD, ...
    private double tarifa_base, tarifa_conversion; // Tarifa de la API.
    private double monto_base, monto_resultado; // Cantidad a convertir y resultado calculado.

    /**
     * Constructor del menú que se encargará del flujo del programa.
     * @param tarifas Tarifas
     */
    public Menu(Tarifas tarifas) {
        this.tarifas = tarifas;
        this.terminar = false;

        System.out.println("Menu - Conversor de monedas");
        System.out.println("----------------------------");

        while(!this.terminar) {
            this.imprimirMenu();
        }
    }

    private void imprimirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        // Pide la moneda que desea convertir.
        do {
            System.out.println("Ingrese la moneda (origen, base) que desea convertir");
            this.imprimirOpcionesMonedas();
            opcion = scanner.nextInt();
        } while (!opcionValida(opcion));

        if (opcion == 0) {
            this.terminar = true;
            return;
        }
        this.moneda_base = opcion;

        // Pide el monto a convertir.
        System.out.println("Ingrese el monto a convertir (decimal, double):");
        this.monto_base = scanner.nextDouble();

        // Pide la moneda a la que desea hacer la conversión.
        do {
            System.out.println("Ingrese la moneda (final, conversion) a la que desea hacer la conversion");
            this.imprimirOpcionesMonedas();
            opcion = scanner.nextInt();
        } while (!opcionValida(opcion));

        if (opcion == 0) {
            this.terminar = true;
            return;
        }
        this.moneda_conversion = opcion;

        // Se calcula la conversión de la moneda y se imprime el resultado.
        this.calcularConversion();
        this.imprimirResultado();
    }

    private void imprimirOpcionesMonedas() {
        System.out.println("Elija la moneda deseada:");
        System.out.println("0 - SALIR DEL PROGRAMA");
        System.out.println("1 - ARS (Peso argentino)");
        System.out.println("2 - BOB (Boliviano boliviano)");
        System.out.println("3 - BRL (Real brasileño)");
        System.out.println("4 - CLP (Peso chileno)");
        System.out.println("5 - COP (Peso colombiano)");
        System.out.println("6 - USD (Dolar estadounidense)");
    }

    private boolean opcionValida(int opcion) {
        if ((opcion < 0) || (opcion > 6)) {
            System.out.println("Se recibio una opcion invalida, intente nuevamente...\n\n");
            return false;
        } else {
            return true;
        }
    }

    private void imprimirResultado() {
        System.out.println("******************************************");
        System.out.println("Resultado de la conversión:");
        System.out.printf(this.monto_base + " " + this.nombre_base);
        System.out.printf(" equivale a ");
        System.out.printf(this.monto_resultado + " " + this.nombre_conversion);
        System.out.println("\n******************************************\n\n");
    }

    private void calcularConversion() {
        switch (this.moneda_base) {
            case 1:
                this.nombre_base = "ARS";
                this.tarifa_base = this.tarifas.tarifaARS();
                break;

            case 2:
                this.nombre_base = "BOB";
                this.tarifa_base = this.tarifas.tarifaBOB();
                break;

            case 3:
                this.nombre_base = "BRL";
                this.tarifa_base = this.tarifas.tarifaBRL();
                break;

            case 4:
                this.nombre_base = "CLP";
                this.tarifa_base = this.tarifas.tarifaCLP();
                break;

            case 5:
                this.nombre_base = "COP";
                this.tarifa_base = this.tarifas.tarifaCOP();
                break;

            case 6:
                this.nombre_base = "USD";
                this.tarifa_base = this.tarifas.tarifaUSD();
                break;

            default:
                this.nombre_base = "???";
                this.tarifa_base = 1.0;
                break;
        }

        switch (this.moneda_conversion) {
            case 1:
                this.nombre_conversion = "ARS";
                this.tarifa_conversion = this.tarifas.tarifaARS();
                break;

            case 2:
                this.nombre_conversion = "BOB";
                this.tarifa_conversion = this.tarifas.tarifaBOB();
                break;

            case 3:
                this.nombre_conversion = "BRL";
                this.tarifa_conversion = this.tarifas.tarifaBRL();
                break;

            case 4:
                this.nombre_conversion = "CLP";
                this.tarifa_conversion = this.tarifas.tarifaCLP();
                break;

            case 5:
                this.nombre_conversion = "COP";
                this.tarifa_conversion = this.tarifas.tarifaCOP();
                break;

            case 6:
                this.nombre_conversion = "USD";
                this.tarifa_conversion = this.tarifas.tarifaUSD();
                break;

            default:
                this.nombre_conversion = "???";
                this.tarifa_conversion = 1.0;
                break;
        }

        this.monto_resultado = this.monto_base * (this.tarifa_conversion / this.tarifa_base);
    }
}
