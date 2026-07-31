package org.nacli.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.nacli.dao.CategoriaDAO;
import org.nacli.model.Categoria;
import org.nacli.util.Conexion;

public class CategoriaDAOImpl implements CategoriaDAO {

    @Override
    public List<Categoria> listarTodos() {
        List<Categoria> categorias = new ArrayList<>();

        String consulta = "{call sp_listarcategorias()}";

        try (Connection conexion = Conexion.getInstancia().conectar();
             CallableStatement consultaCall = conexion.prepareCall(consulta);
             ResultSet tablaResultado = consultaCall.executeQuery()) {

            while (tablaResultado.next()) {
                categorias.add(new Categoria(
                        tablaResultado.getString("nombreCategoria")
                ));
            }

        } catch (SQLException e) {
            System.err.println("Error al listar categorías: " + e.getMessage());
        }

        return categorias;
    }


    @Override
public boolean crear(Categoria categoria) {

    String sql = "INSERT INTO categoria(nombreCategoria) VALUES (?)";

    try (Connection conexion = Conexion.getInstancia().conectar();
         java.sql.PreparedStatement ps = conexion.prepareStatement(sql)) {

        ps.setString(1, categoria.getnombreCategoria());

        int resultado = ps.executeUpdate();

        System.out.println("Filas insertadas: " + resultado);

        return resultado > 0;

    } catch (SQLException e) {
        System.err.println("ERROR AL INSERTAR:");
        e.printStackTrace();
        return false;
    }
}


    @Override
    public Categoria buscarPorId(int idCategoria) {

        Categoria categoria = new Categoria();

        String consultaSQL = "{call sp_buscategoria(?)}";

        try (Connection conexion = Conexion.getInstancia().conectar();
             CallableStatement consultaCall = conexion.prepareCall(consultaSQL)) {

            consultaCall.setInt(1, idCategoria);

            ResultSet tablaResultado = consultaCall.executeQuery();

            if (tablaResultado.next()) {
                categoria.setnombreCategoria(
                        tablaResultado.getString("nombreCategoria")
                );
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar categoría: " + e.getMessage());
        }

        return categoria;
    }


    @Override
    public boolean actualizar(Categoria categoria) {
        return false;
    }


    @Override
    public boolean eliminar(int idCategoria) {
        return false;
    }
}
