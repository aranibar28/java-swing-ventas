package Controlador;

import Controlador.Conexion;
import Modelo.Boleta;
import java.sql.*;

public class BoletaDAO {

    private Conexion cc = new Conexion();
    private Connection cn = cc.getConexion();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private static BoletaDAO instancia;

    public static BoletaDAO getInstancia() {
        if (instancia == null) {
            instancia = new BoletaDAO();
        }
        return instancia;
    }

    public void Registrar(Boleta boleta) throws SQLException {

        try {
            ps = cn.prepareStatement("INSERT INTO boleta "
                    + "(num_bol"
                    + ",cod_cli"
                    + ",pre_tot"
                    + ",fecha)"
                    + "VALUES (?,?,?,?)");
            ps.setString(1, boleta.getNumero());
            ps.setString(2, boleta.getCodigo());
            ps.setString(3, boleta.getTotal());
            ps.setString(4, boleta.getFecha());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR SQLFactura: " + ex.getMessage());
        }
    }

    public void Detalle(Boleta boleta) throws SQLException {

        try {
            ps = cn.prepareStatement("INSERT INTO detalleboleta "
                    + "(num_fac"
                    + ",cod_pro"
                    + ",des_pro"
                    + ",cant_pro"
                    + ",pre_unit"
                    + ",pre_venta"
                    + "VALUES (?,?,?,?,?,?)");
            ps.setString(1, boleta.getNumero());
            ps.setString(2, boleta.getCodigo());
            ps.setString(3, boleta.getTotal());
            ps.setString(4, boleta.getFecha());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR SQLFactura: " + ex.getMessage());
        }
    }
}
