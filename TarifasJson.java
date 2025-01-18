package src;

import com.google.gson.annotations.SerializedName;

public class TarifasJson {
    @SerializedName("result")
    private String result; // Resultado de la consulta a la API.
    @SerializedName("conversion_rates")
    private Tarifas conversion_rates; // Resultado de las tarifas recibidas de la consulta.

    /**
     * Devuelve las tarifas recibidas en la consulta a la API.
     * @return Tarifas
     */
    public Tarifas tarifas() {
        return this.conversion_rates;
    }

    /**
     * Verifica que la consulta a la API se haya recibido correctamente en el objeto.
     * (Debe recibir un "success".
     * @return true en caso de éxito, false caso contrario.
     */
    public boolean consultaExitosa() {
        return this.result.equals("success");
    }

    @Override
    public String toString() {
        if (this.consultaExitosa()) {
            return conversion_rates.toString();
        } else {
            return "error: fallo la consulta";
        }
    }
}
