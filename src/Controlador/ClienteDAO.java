package Controlador;
import Controlador.Conexion;
import Modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO {

    private Conexion cc = new Conexion();
    private Connection cn = cc.getConexion();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private static ClienteDAO instancia;

    public static ClienteDAO getInstancia() {
        if (instancia == null) {
            instancia = new ClienteDAO();
        }
        return instancia;
    }

    public ArrayList<Cliente> MostrarClientes(String valor) throws SQLException {
        ArrayList<Cliente> lista = new ArrayList();

        try {
            String mostrar = "SELECT * FROM cliente WHERE CONCAT(cod_cli,nom_cli,ape_cli,dni_cli,ruc_cli) LIKE '%" + valor + "%'";
            ps = cn.prepareStatement(mostrar);
            rs = ps.executeQuery(mostrar);
            while (rs.next()) {
                String cod = rs.getString("cod_cli");
                String nom = rs.getString("nom_cli");
                String ape = rs.getString("ape_cli");
                String sex = rs.getString("sexo_cli");
                String dni = rs.getString("dni_cli");
                String tel = rs.getString("tel_cli");
                String ruc = rs.getString("ruc_cli");
                String email = rs.getString("email_cli");
                String dir = rs.getString("dir_cli");
                Cliente cli;
                cli = new Cliente(cod, nom, ape, sex, dni, tel, ruc, email, dir);
                lista.add(cli);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return lista;
    }

    public void Registrar(Cliente cliente) throws SQLException {

        try {
            ps = cn.prepareStatement("INSERT INTO cliente "
                    + "(cod_cli"
                    + ",nom_cli"
                    + ",ape_cli"
                    + ",sexo_cli"
                    + ",dni_cli"
                    + ",tel_cli"
                    + ",ruc_cli"
                    + ",email_cli"
                    + ",dir_cli)"
                    + "VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, cliente.getCodigo());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setString(4, cliente.getSexo());
            ps.setString(5, cliente.getDni());
            ps.setString(6, cliente.getTelefono());
            ps.setString(7, cliente.getRuc());
            ps.setString(8, cliente.getEmail());
            ps.setString(9, cliente.getDireccion());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public void Actualizar(Cliente cliente) throws SQLException {

        try {
            ps = cn.prepareStatement("UPDATE cliente SET "
                    + "nom_cli = ?, "
                    + "ape_cli = ?, "
                    + "sexo_cli = ?,  "
                    + "dni_cli = ?, "
                    + "tel_cli = ?, "
                    + "ruc_cli = ?, "
                    + "email_cli = ?, "
                    + "dir_cli  = ? "
                    + "WHERE cod_cli = ? ");

            ps.setString(9, cliente.getCodigo());
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getSexo());
            ps.setString(4, cliente.getDni());
            ps.setString(5, cliente.getTelefono());
            ps.setString(6, cliente.getRuc());
            ps.setString(7, cliente.getEmail());
            ps.setString(8, cliente.getDireccion());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public void Eliminar(String idcliente) throws SQLException {

        try {
            ps = cn.prepareStatement("DELETE FROM cliente "
                    + "WHERE cod_cli=?");
            ps.setString(1, idcliente);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public void SolicitarCodigo(String id) throws SQLException {

        try {
            ps = cn.prepareStatement("SELECT MAX(cod_cli) FROM cliente");
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}

