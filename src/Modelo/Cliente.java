package Modelo;

public class Cliente {

    private String codigo;
    private String nombre;
    private String apellido;
    private String sexo;
    private String dni;
    private String telefono;
    private String ruc;
    private String email;
    private String direccion;

    public Cliente(String codigo, String nombre, String apellido, String sexo, String dni, String telefono, String ruc, String email, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.dni = dni;
        this.telefono = telefono;
        this.ruc = ruc;
        this.email = email;
        this.direccion = direccion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
