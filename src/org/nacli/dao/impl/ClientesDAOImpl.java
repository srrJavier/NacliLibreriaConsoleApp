
package org.nacli.dao.impl;
import org.nacli.util.Conexion;
import org.nacli.model.clientes;
import org.nacli.dao.ClientesDAO;

import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.ResultSet;



public class ClientesDAOImpl  implements ClientesDAO{

    @Override
    public boolean insetar(clientes cliente) {
        return false;
    }

    @Override
    public List<clientes> listar() {
        return null;
    }

    @Override
    public clientes buscar(long cui) {
        return null;
    }

    @Override
    public boolean actualizar(clientes cliente) {
        return false;
    }

    @Override
    public boolean eliminar(long cui) {
        return false;
    }
    
}
