import DAO.ClientsDAO;
import DAO.Impl.ClientsDAOImpl;
import models.*;


/**
 * Created by ayta on 27.03.17.
 */
public class Main {
    public static void main(final String[] args) throws Exception {
        ClientsDAO client = new ClientsDAOImpl();
        Clients entity = new Clients();
        entity.setId(3);
        entity.setType(Clients.ClientType.organization);
        client.addClients(entity);
    }
}