package Objetos;

import java.util.Arrays;
import java.util.Objects;

public class Cotizador {
    private String[] empresas = {"Benedictino", "Nestlé", "Líder"};
    private String[] productos = {"Botella", "Bidón"};
    private int[] cobroPorBotella = {750, 675, 600};
    private int[] cobroPorBidon = {2650, 1500, 1250};
    private String[] cantidades = {"6", "12", "24"};
    private int envio = 3000;

    public Cotizador() {
    }

    public Cotizador(String[] empresas, String[] productos, int[] cobroPorBotella, int[] cobroPorBidon, String[] cantidades, int envio) {
        this.empresas = empresas;
        this.productos = productos;
        this.cobroPorBotella = cobroPorBotella;
        this.cobroPorBidon = cobroPorBidon;
        this.cantidades = cantidades;
        this.envio = envio;
    }

    public String[] getEmpresas() {
        return empresas;
    }

    public void setEmpresas(String[] empresas) {
        this.empresas = empresas;
    }

    public String[] getProductos() {
        return productos;
    }

    public void setProductos(String[] productos) {
        this.productos = productos;
    }

    public int[] getCobroPorBotella() {
        return cobroPorBotella;
    }

    public void setCobroPorBotella(int[] cobroPorBotella) {
        this.cobroPorBotella = cobroPorBotella;
    }

    public int[] getCobroPorBidon() {
        return cobroPorBidon;
    }

    public void setCobroPorBidon(int[] cobroPorBidon) {
        this.cobroPorBidon = cobroPorBidon;
    }

    public String[] getCantidades() {
        return cantidades;
    }

    public void setCantidades(String[] cantidades) {
        this.cantidades = cantidades;
    }

    public int getEnvio() {
        return envio;
    }

    public void setEnvio(int envio) {
        this.envio = envio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cotizador cotizador = (Cotizador) o;
        return envio == cotizador.envio && Arrays.equals(empresas, cotizador.empresas) && Arrays.equals(productos, cotizador.productos) && Arrays.equals(cobroPorBotella, cotizador.cobroPorBotella) && Arrays.equals(cobroPorBidon, cotizador.cobroPorBidon) && Arrays.equals(cantidades, cotizador.cantidades);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(envio);
        result = 31 * result + Arrays.hashCode(empresas);
        result = 31 * result + Arrays.hashCode(productos);
        result = 31 * result + Arrays.hashCode(cobroPorBotella);
        result = 31 * result + Arrays.hashCode(cobroPorBidon);
        result = 31 * result + Arrays.hashCode(cantidades);
        return result;
    }

    public int Cotizar(String empresa, String tipoBot, int cant, boolean hayEnvio){
        int total = 0;
        for(int i=0; i<empresas.length; i++){
            if(empresas[i].equals(empresa)){
                if(tipoBot.equals("Botella")){
                    total = total + cobroPorBotella[i];
                }else{
                    total = total + cobroPorBidon[i];
                }
            }
        }
        total = total * cant;
        if(hayEnvio){
            total = total + envio;
        }
        return total;
    }
}
