package Controlador;
import Controlador.Conexion;
import Modelo.Producto;
import java.sql.*;
import java.util.ArrayList;

public class ProductoDAO {

    private Conexion cc = new Conexion();
    private Connection cn = cc.getConexion();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private static ProductoDAO instancia;

    public static ProductoDAO getInstancia() {
        if (instancia == null) {
            instancia = new ProductoDAO();
        }
        return instancia;
    }

    public ArrayList<Producto> MostrarProducto(String valor) throws SQLException {
        ArrayList<Producto> Lista = new ArrayList();

        try {
            String mostrar = "SELECT * FROM producto WHERE CONCAT(cod_pro,descripcion,tipo) LIKE '%" + valor + "%'";
            ps = cn.prepareStatement(mostrar);
            rs = ps.executeQuery();
            while (rs.next()) {
                String cod = rs.getString("cod_pro");
                String des = rs.getString("descripcion");
                Double pre = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                String tip = rs.getString("tipo");
                Producto pro;
                pro = new Producto(cod, des, pre, stock, tip);
                Lista.add(pro);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return Lista;
    }

    public void Registrar(Producto producto) throws SQLException {

        try {
            ps = cn.prepareStatement("INSERT INTO producto "
                    + "(cod_pro"
                    + ",descripcion"
                    + ",precio"
                    + ",stock"
                    + ",tipo)"
                    + "VALUES (?,?,?,?,?)");
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setString(5, producto.getTipo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public void Actualizar(Producto producto) throws SQLException {

        try {
            ps = cn.prepareStatement("UPDATE producto SET "
                    + "descripcion = ?, "
                    + "precio = ?, "
                    + "stock = ?,  "
                    + "tipo = ? "
                    + "WHERE cod_pro = ? ");

            ps.setString(5, producto.getCodigo());
            ps.setString(1, producto.getDescripcion());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());
            ps.setString(4, producto.getTipo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public void Eliminar(String idproducto) throws SQLException {

        try {
            ps = cn.prepareStatement("DELETE FROM producto "
                    + "WHERE cod_pro=?");
            ps.setString(1, idproducto);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }

    }

    public void SolicitarCodigo(String id) throws SQLException {

        try {
            ps = cn.prepareStatement("SELECT MAX(cod_pro) FROM producto");
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}
