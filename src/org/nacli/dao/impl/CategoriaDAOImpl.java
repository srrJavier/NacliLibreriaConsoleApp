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

    // LISTAR TODAS LAS CATEGORÍAS
    @Override
    public List<Categoria> listarTodos() {

        List<Categoria> categorias = new ArrayList<>();

        String sql = "{call sp_listarcategorias()}";

        try (
                Connection conexion
                = Conexion.getInstancia().conectar(); CallableStatement cs
                = conexion.prepareCall(sql); ResultSet rs
                = cs.executeQuery()) {

            while (rs.next()) {

                Categoria categoria
                        = new Categoria();

                categoria.setNombreCategoria(
                        rs.getString("nombre_categoria")
                );

                categorias.add(categoria);
            }

        } catch (SQLException e) {

            System.err.println(
                    "ERROR AL LISTAR CATEGORÍAS:"
            );

            e.printStackTrace();
        }

        return categorias;
    }

    // CREAR CATEGORÍA
    @Override
    public boolean crear(Categoria categoria) {

        String sql
                = "{call sp_insertarcategoria(?)}";

        try (
                Connection conexion
                = Conexion.getInstancia().conectar(); CallableStatement cs
                = conexion.prepareCall(sql)) {

            cs.setString(
                    1,
                    categoria.getNombreCategoria()
            );

            cs.execute();

            System.out.println(
                    "Categoría insertada correctamente."
            );

            return true;

        } catch (SQLException e) {

            System.err.println(
                    "ERROR AL INSERTAR CATEGORÍA:"
            );

            e.printStackTrace();

            return false;
        }
    }

    // BUSCAR POR ID
    public Categoria buscarPorId(int idCategoria) {

        String sql
                = "{call sp_buscarcategoria(?)}";

        try (
                Connection conexion
                = Conexion.getInstancia().conectar(); CallableStatement cs
                = conexion.prepareCall(sql)) {

            cs.setInt(1, idCategoria);

            try (ResultSet rs
                    = cs.executeQuery()) {

                if (rs.next()) {

                    Categoria categoria
                            = new Categoria();

                    categoria.setNombreCategoria(
                            rs.getString(
                                    "nombre_categoria"
                            )
                    );

                    return categoria;
                }
            }

        } catch (SQLException e) {

            System.err.println(
                    "ERROR AL BUSCAR CATEGORÍA:"
            );

            e.printStackTrace();
        }

        return null;
    }

    // ACTUALIZAR POR ID
    public boolean actualizar(Categoria categoria) {

        return false;
    }

    // ELIMINAR POR ID
    public boolean eliminar(int idCategoria) {

        return false;
    }

    // BUSCAR POR NOMBRE
    @Override
    public Categoria buscarPorNombre(
            String nombreCategoria) {

        String sql
                = "{call sp_buscarnombrecategoria(?)}";

        try (
                Connection conexion
                = Conexion.getInstancia().conectar(); CallableStatement cs
                = conexion.prepareCall(sql)) {

            cs.setString(
                    1,
                    nombreCategoria
            );

            try (ResultSet rs
                    = cs.executeQuery()) {

                if (rs.next()) {

                    Categoria categoria
                            = new Categoria();

                    categoria.setNombreCategoria(
                            rs.getString(
                                    "nombre_categoria"
                            )
                    );

                    return categoria;
                }
            }

        } catch (SQLException e) {

            System.err.println(
                    "ERROR AL BUSCAR CATEGORÍA POR NOMBRE:"
            );

            e.printStackTrace();
        }

        return null;
    }

    // ACTUALIZAR POR NOMBRE
    @Override
    public boolean actualizarPorNombre(
            String nombreActual,
            String nuevoNombre) {

        String sql
                = "{call sp_actualizarcategoria(?, ?)}";

        try (
                Connection conexion
                = Conexion.getInstancia().conectar(); CallableStatement cs
                = conexion.prepareCall(sql)) {

            cs.setString(
                    1,
                    nombreActual
            );

            cs.setString(
                    2,
                    nuevoNombre
            );

            cs.execute();

            return true;

        } catch (SQLException e) {

            System.err.println(
                    "ERROR AL ACTUALIZAR CATEGORÍA:"
            );

            e.printStackTrace();

            return false;
        }
    }

    // ELIMINAR POR NOMBRE
    @Override
    public boolean eliminarPorNombre(
            String nombreCategoria) {

        String sql
                = "{call sp_eliminarcategoria(?)}";

        try (
                Connection conexion
                = Conexion.getInstancia().conectar(); CallableStatement cs
                = conexion.prepareCall(sql)) {

            cs.setString(
                    1,
                    nombreCategoria
            );

            cs.execute();

            return true;

        } catch (SQLException e) {

            System.err.println(
                    "ERROR AL ELIMINAR CATEGORÍA:"
            );

            e.printStackTrace();

            return false;
        }
    }
}
