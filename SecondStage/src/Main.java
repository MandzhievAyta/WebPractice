
import DAO.AbstractDAO;
import DAO.Impl.ContractsHistoryDAO;
import DAO.Impl.WriteoffsHistoryDAO;
import models.Contacts;
import models.ContractsHistory;
import models.WriteoffsHistory;
import util.HibernateUtil;

import java.util.List;


/**
 * Created by ayta on 27.03.17.
 */
public class Main {
    public static void main(final String[] args) throws Exception {
        WriteoffsHistoryDAO writeoffsHistoryDAO = new WriteoffsHistoryDAO();
        List<WriteoffsHistory> contractHistoryList = writeoffsHistoryDAO.getAll();
        for (WriteoffsHistory kek : contractHistoryList) {
            System.out.println(kek);
        }
        System.out.println("---------------");
        for (WriteoffsHistory col : writeoffsHistoryDAO.getWriteoffsByAccountId(1)) {
            System.out.println(col);
        }
        HibernateUtil.closeEMF();

    }
}