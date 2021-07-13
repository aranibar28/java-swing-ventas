package Modelo;
public class Boleta {

    private String numero;
    private String codigo;
    private String total;
    private String fecha;

    public Boleta() {
    }

    public Boleta(String numero, String codigo, String total, String fecha) {
        this.numero = numero;
        this.codigo = codigo;
        this.total = total;
        this.fecha = fecha;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
