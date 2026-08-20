package org.nacli.dao.impl;
 
import org.nacli.util.Conexion;
import org.nacli.model.Autores;
import org.nacli.dao.AutoresDAO;
 
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
 
        
public class AutorDAOImpl implements AutoresDAO{
 
    @Override
    public boolean insertar(Autores autores) {
        // sp_insertarautor(_nombre_autor, _apellido_autor, _nacionalidad, _biografia)
        String consulta = "{call sp_insertarautor(?, ?, ?, ?)}";
        try (Connection conexion = Conexion.getInstancia().conectar();
             CallableStatement consultaCall = conexion.prepareCall(consulta)) {
            consultaCall.setString(1, autores.getNombre_autor());
            consultaCall.setString(2, autores.getApellido_autor());
            consultaCall.setString(3, autores.getNacionalidad());
            consultaCall.setString(4, autores.getBiografia());
            return consultaCall.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al crear Autor: " + e.getMessage());
            return false;
        }
    }
 
    @Override
    public List<Autores> listarTodos() {
        List<Autores> Autor = new ArrayList<>();
        String consulta = "{call sp_listarautores()}";
        try (Connection conexion = Conexion.getInstancia().conectar(); CallableStatement consultaCall = conexion.prepareCall(consulta); ResultSet tablaResultado = consultaCall.executeQuery()) {
 
            while (tablaResultado.next()) {
                System.out.println("Autor encontrado en BD: " + tablaResultado.getString("nombre_autor"));
                Autor.add(new Autores(
                        tablaResultado.getLong("id_autor"),
                        tablaResultado.getString("nombre_autor"),
                        tablaResultado.getString("apellido_autor"),
                        tablaResultado.getString("nacionalidad"),
                        tablaResultado.getString("biografia")
                ));
            }
        } catch (SQLException e) {
            System.err.println("ERROR al listar Autores:" + e.getMessage());
        }
        return Autor;
    }
 
    @Override
    public Autores buscarPorId(int id_autor) {
        //objeto
        Autores autor = new Autores();
 
        //consulta
        String consultaSQL = "{call sp_buscarautor(?)}";
        //mapeamos el ResultSet al Objeto(Cliente) segun sus atributos y la fila devulta
        try (Connection conexion = Conexion.getInstancia().conectar(); CallableStatement consultaCall = conexion.prepareCall(consultaSQL);) {
            consultaCall.setInt(1, id_autor);
            ResultSet tablaResultado = consultaCall.executeQuery();
            if (tablaResultado.next()) {
                autor.setId_autor(tablaResultado.getInt("id_autor"));
                autor.setNombre_autor(tablaResultado.getString("nombre_autor"));
                autor.setApellido_autor(tablaResultado.getString("apellido_autor"));
                autor.setNacionalidad(tablaResultado.getString("nacionalidad"));
                autor.setBiografia(tablaResultado.getString("biografia"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.print("Error al buscar Autor: " + e.getMessage());
        }
        //retornamos el objeto
        return autor;
    }
 
        
    @Override
    public boolean actualizar(Autores autores) {
        // sp_actualizarautor(_id_autor, _nombre_autor, _apellido_autor, _nacionalidad, _biografia)
        String consulta = "{call sp_actualizarautor(?, ?, ?, ?, ?)}";
        try (Connection conexion = Conexion.getInstancia().conectar();
             CallableStatement consultaCall = conexion.prepareCall(consulta)) {
            consultaCall.setLong(1, autores.getId_autor());
            consultaCall.setString(2, autores.getNombre_autor());
            consultaCall.setString(3, autores.getApellido_autor());
            consultaCall.setString(4, autores.getNacionalidad());
            consultaCall.setString(5, autores.getBiografia());
            return consultaCall.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar Autor: " + e.getMessage());
            return false;
        }
    }
 
    @Override
    public boolean eliminar(int id_autor) {
        // sp_eliminarautor(_id_autor)
        String consulta = "{call sp_eliminarautor(?)}";
        try (Connection conexion = Conexion.getInstancia().conectar();
             CallableStatement consultaCall = conexion.prepareCall(consulta)) {
            consultaCall.setInt(1, id_autor);
            return consultaCall.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar Autor: " + e.getMessage());
            return false;
        }
    }
}
   