package DAO;

import com.mysql.jdbc.Driver;
import models.Clients;
import org.hibernate.mapping.Collection;

import java.sql.SQLException;

/**
 * Created by ayta on 28.03.17.
 */
public interface ClientsDAO {
    public void addClients(Clients Clients) throws SQLException;
    public void updateClients(Long Clients_id, Clients Clients) throws SQLException;
    public Clients getClientsById(Long Clients_id) throws SQLException;
}
