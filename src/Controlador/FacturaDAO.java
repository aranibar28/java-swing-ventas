package Controlador;

import Controlador.Conexion;
import Modelo.Factura;
import java.sql.*;

public class FacturaDAO {

    private Conexion cc = new Conexion();
    private Connection cn = cc.getConexion();
    private PreparedStatement ps = null;
    private static FacturaDAO instancia;

    public static FacturaDAO getInstancia() {
        if (instancia == null) {
            instancia = new FacturaDAO();
        }
        return instancia;
    }

    public void Registrar(Factura factura) throws SQLException {

        try {
            ps = cn.prepareStatement("INSERT INTO factura "
                    + "(num_fac"
                    + ",cod_cli"
                    + ",ruc_cli"
                    + ",subtotal"
                    + ",igv"
                    + ",total"
                    + ",fec_fac)"
                    + "VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, factura.getNumero());
            ps.setString(2, factura.getCodigo());
            ps.setString(3, factura.getRuc());
            ps.setDouble(4, factura.getSubtotal());
            ps.setDouble(5, factura.getIgv());
            ps.setDouble(6, factura.getTotal());
            ps.setString(7, factura.getFecha());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR SQLFactura: " + ex.getMessage());
        }
    }

    public void Detalle(Factura factura) throws SQLException {

        try {
            ps = cn.prepareStatement("INSERT INTO detallefactura "
                    + "(num_fac"
                    + ",cod_pro"
                    + ",des_pro"
                    + ",cant_pro"
                    + ",pre_unit"
                    + ",pre_tot"
                    + "VALUES (?,?,?,?,?,?)");
            ps.setString(1, factura.getNumero());
            ps.setString(2, factura.getCodigo());
            ps.setString(3, factura.getRuc());
            ps.setDouble(4, factura.getSubtotal());
            ps.setDouble(5, factura.getIgv());
            ps.setDouble(6, factura.getTotal());
            ps.setString(7, factura.getFecha());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR SQLFactura: " + ex.getMessage());
        }
    }
}
