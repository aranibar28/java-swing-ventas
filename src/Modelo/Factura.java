package Modelo;
public class Factura {

    private String numero;
    private String codigo;
    private String ruc;
    private double subtotal;
    private double igv;
    private double total;
    private String fecha;

    public Factura(String numero, String codigo, String ruc, double subtotal, double igv, double total, String fecha) {
        this.numero = numero;
        this.codigo = codigo;
        this.ruc = ruc;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
        this.fecha = fecha;
    }

    public double Igv() {
        return subtotal * 0.18;
    }

    public double Total() {
        return subtotal + Igv();
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

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
