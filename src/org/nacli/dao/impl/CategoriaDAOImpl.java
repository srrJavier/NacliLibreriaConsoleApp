package org.nacli.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.nacli.dao.CategoriaDAO;
import org.nacli.model.Categoria;
import org.nacli.util.Conexion;

public class CategoriaDAOImpl implements CategoriaDAO {

    @Override
    public List<Categoria> listarTodos() {

        List<Categoria> categorias = new ArrayList<>();

        String sql = "{call sp_listarcategorias()}";

        try (
                Connection conexion = Conexion.getInstancia().conectar();
                CallableStatement cs = conexion.prepareCall(sql);
                ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {

                Categoria categoria = new Categoria();

                // SOLO usamos nombre_categoria
                categoria.setNombreCategoria(
                        rs.getString("nombre_categoria")
                );

                categorias.add(categoria);
            }

        } catch (SQLException e) {

            System.err.println("ERROR AL LISTAR CATEGORÍAS:");
            e.printStackTrace();
        }

        return categorias;
    }

    @Override
    public boolean crear(Categoria categoria) {

        String sql = "{call sp_insertarcategoria(?)}";

        try (
                Connection conexion = Conexion.getInstancia().conectar();
                CallableStatement cs = conexion.prepareCall(sql)) {

            cs.setString(
                    1,
                    categoria.getNombreCategoria()
            );

            cs.execute();

            System.out.println("Categoría insertada correctamente.");

            return true;

        } catch (SQLException e) {

            System.err.println("ERROR AL INSERTAR CATEGORÍA:");
            e.printStackTrace();

            return false;
        }
    }

    /*
     * Como Categoria ya NO tiene idCategoria,
     * estos métodos ya no pueden trabajar con un ID.
     *
     * Si tu interfaz CategoriaDAO todavía exige estos métodos,
     * debemos modificar también CategoriaDAO.
     */

    public Categoria buscarPorId(int idCategoria) {

        String sql = "{call sp_buscarcategoria(?)}";

        try (
                Connection conexion = Conexion.getInstancia().conectar();
                CallableStatement cs = conexion.prepareCall(sql)) {

            cs.setInt(1, idCategoria);

            try (ResultSet rs = cs.executeQuery()) {

                if (rs.next()) {

                    Categoria categoria = new Categoria();

                    categoria.setNombreCategoria(
                            rs.getString("nombre_categoria")
                    );

                    return categoria;
                }
            }

        } catch (SQLException e) {

            System.err.println("ERROR AL BUSCAR CATEGORÍA:");
            e.printStackTrace();
        }

        return null;
    }

    /*
     * SIN idCategoria no podemos actualizar una categoría
     * usando su ID.
     */
    public boolean actualizar(Categoria categoria) {

        return false;
    }

    /*
     * SIN idCategoria no podemos eliminar una categoría
     * usando su ID.
     */
    public boolean eliminar(int idCategoria) {

        return false;
    }

    @Override
    public Categoria buscarPorNombre(String nombreCategoria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizarPorNombre(String nombreActual, String nuevoNombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarPorNombre(String nombreCategoria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}