package org.nacli.dao.impl;

import java.util.ArrayList;
import org.nacli.model.Categoria;
import org.nacli.dao.CategoriaDAO;

import org.nacli.util.Conexion;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaDAOImpl implements CategoriaDAO {

    @Override
    public List<Categoria> listarTodos() {
        //crear lista
        List<Categoria> categorias = new ArrayList<>();//null
        //crear nustras consulta
        String consulta = "{call sp_listarclientes()}";
        //maperar el resultado de la consulta a objeto y lo agregamos a la lista
        //try with resources / intentar con recursos --> cierra el recurso al completar el intento
        //recurso: Conexion, al final se cierra
        try (Connection conexion = Conexion.getInstancia().conectar(); CallableStatement consultaCall = conexion.prepareCall(consulta); ResultSet tablaResultado = consultaCall.executeQuery();) {
            //ciclo para rellenar mi lista
            //verificar cada filta del result set
            //va a guarda cada celda dentro de cada atributo de mi objeto
            while (tablaResultado.next()) {
                categorias.add(new Categoria(
                        tablaResultado.getLong("cui"),
                        tablaResultado.getString("nombre_cliente"),
                        tablaResultado.getString("apellido_cliente"),
                        tablaResultado.getString("correo_electronico")
                ));
            }
        } catch (SQLException e) {
            System.err.print("Error al listar Clientes: " + e.getMessage());
        }

        //retornamos un alista
        return categorias;
    }

    @Override
    public boolean crear(Categoria cliente) {
        return false;
    }

    @Override
    public Categoria buscarPorId(long cui) {
        //objeto
        Categoria categoria = new Categoria();

        //consulta
        String consultaSQL = "{call sp_buscarcliente(?)}";
        //mapeamos el ResultSet al Objeto(Cliente) segun sus atributos y la fila devulta
        try (Connection conexion = Conexion.getInstancia().conectar(); CallableStatement consultaCall = conexion.prepareCall(consultaSQL);) {
            consultaCall.setLong(1, cui);
            ResultSet tablaResultado = consultaCall.executeQuery();
            if (tablaResultado.next()) {
                categoria.setCui(tablaResultado.getLong("cui"));
                categoria.setNombre(tablaResultado.getString("nombre_cliente"));
                categoria.setApellido(tablaResultado.getString("apellido_cliente"));
                categoria.setCorreoElectronico(tablaResultado.getString("correo_electronico"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.print("Error al buscar Cliente: " + e.getMessage());
        }
        //retornamos el objeto
        return categoria;
    }

    @Override
    public boolean actualizar(Categoria cliente) {
        return false;
    }

    @Override
    public boolean eliminar(long cui) {
        return false;
    }

}