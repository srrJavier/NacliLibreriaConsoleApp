
package org.nacli.dao.impl;

import org.nacli.model.Autor;
import org.nacli.dao.AutorDAO;
import org.nacli.util.Conexion;

import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class AutorDAOImpl implements AutorDAO{

    @Override
    public List<Autor> ListarTodos() {
        //crear nuestra consulta
        List<Autor> autor = new ArrayList<>();//null
        //mapea el resultado de la consulta a objeto y lo agrega a la lista
        String consulta = "{call sp_Listarautores()}";
        //retornamos una lista
       try (Connection conexion = Conexion.getInstancia().conectar();
                CallableStatement consultaCall = conexion.prepareCall(consulta);
                ResultSet tablaResultado = consultaCall.executeQuery();) {
        //ciclo para rellenar mi lista
        //verificar cada filta del result set
        //va a guarda cada celda dentro de cada atributo de mi objeto
        while (tablaResultado.next()) {
                autor.add(new Autor(
                        (int) tablaResultado.getLong("id"),
                        tablaResultado.getString("nombre_autor"),
                        tablaResultado.getString("apellido_autor"),
                        tablaResultado.getString("nacionalidad"),
                        tablaResultado.getString("biografia")
                ));
            }
         } catch (SQLException e) {
             System.err.print("Error al listar Clientes: " + e.getMessage());
         }
        
        //retornamos un alista
        return autor;
    }
    
    @Override
    public boolean insertar(Autor autor) {
        return false;
    }

    @Override
    public Autor BuscarPorID(int idAutor) {
        return null;
    }

    @Override
    public boolean actualizar(Autor autor) {
        return false;
    }

    @Override
    public boolean eliminar(int idAutor) {
        return false;
    }
    
}
