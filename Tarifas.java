package src;

import com.google.gson.annotations.SerializedName;

public class Tarifas {
    @SerializedName("ARS")
    private double ARS; // Peso argentino
    @SerializedName("BOB")
    private double BOB; // Boliviano boliviano
    @SerializedName("BRL")
    private double BRL; // Real brasileño
    @SerializedName("CLP")
    private double CLP; // Peso chileno
    @SerializedName("COP")
    private double COP; // Peso colombiano
    @SerializedName("USD")
    private double USD; // Dólar estadounidense

    /**
     * Constructor por default.
     * @param ARS double, Peso argentino.
     * @param BOB double, Boliviano boliviano.
     * @param BRL double, Real brasileño.
     * @param CLP double, Peso chileno.
     * @param COP double, Peso colombiano.
     * @param USD double, Dolar estadounidense.
     */
    public Tarifas(double ARS, double BOB, double BRL, double CLP, double COP, double USD) {
        this.ARS = ARS;
        this.BOB = BOB;
        this.BRL = BRL;
        this.CLP = CLP;
        this.COP = COP;
        this.USD = USD;
    }

    /**
     * Devuelve la tarifa para el peso argentino.
     * @return double, ARS (con USD = 1).
     */
    public double tarifaARS() {
        return this.ARS;
    }

    /**
     * Devuelve la tarifa para el boliviano boliviano.
     * @return double, BOB (con USD = 1).
     */
    public double tarifaBOB() {
        return this.ARS;
    }

    /**
     * Devuelve la tarifa para el real brasileño.
     * @return double, BRL (con USD = 1).
     */
    public double tarifaBRL() {
        return this.ARS;
    }

    /**
     * Devuelve la tarifa para el peso chileno.
     * @return double, CLP (con USD = 1).
     */
    public double tarifaCLP() {
        return this.CLP;
    }

    /**
     * Devuelve la tarifa para el peso colombiano.
     * @return double, COP (con USD = 1).
     */
    public double tarifaCOP() {
        return this.COP;
    }

    /**
     * Devuelve la tarifa para el dólar estadounidense.
     * @return double, USD (con USD = 1, base).
     */
    public double tarifaUSD() {
        return this.USD;
    }

    @Override
    public String toString() {
        String texto = "(ARS: " + this.ARS + ", " +
                "BOB: " + this.BOB + ", " +
                "BRL: " + this.BRL + ", " +
                "CLP: " + this.CLP + ", " +
                "COP: " + this.COP + ", " +
                "USD: " + this.USD + ")";
        return texto;
    }
}
