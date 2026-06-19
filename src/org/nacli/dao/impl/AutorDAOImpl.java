
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
    public boolean insertar(Autor autor) {
        return false;
    }

    @Override
    public List<Autor> listar() {
        return null;
    }

    @Override
    public Autor buscar(int idAutor) {
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
