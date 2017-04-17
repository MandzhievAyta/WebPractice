package Test;

import DAO.Impl.AccountsDAO;
import DAO.Impl.ContractsHistoryDAO;
import DAO.Impl.WriteoffsHistoryDAO;
import models.Accounts;
import models.ContractsHistory;
import models.WriteoffsHistory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Time;
import java.sql.Date;
import java.util.List;

/**
 * Created by ayta on 16.04.17.
 */
public class TestClass {
    @DataProvider
    public Object[][] writeoffsHistoryData() {
        return new Object[][]{
                new Object[]{new Date(2017, 1, 1), new Time(200), 20}
        };
    }

    @Test(dataProvider = "writeoffsHistoryData")
    public void testWriteoffsHistory(Date date, Time time, Integer value) {
        WriteoffsHistoryDAO whDAO = new WriteoffsHistoryDAO();
        WriteoffsHistory wh = new WriteoffsHistory();

        int size = whDAO.getAll().size();
        Assert.assertNotNull(size);


        wh.setDate(date);
        wh.setTime(time);
        wh.setValue(value);
        wh.setAccount(new AccountsDAO().getById(1));
        wh.setContractsHistory(new ContractsHistoryDAO().getById(1));
        whDAO.add(wh);

        Assert.assertEquals(whDAO.getAll().size(), size + 1);
        WriteoffsHistory chk = whDAO.getById(wh.getId());
        Assert.assertNotNull(chk);

        Assert.assertTrue(chk.equals(wh));

        wh.setValue(500);

        whDAO.update(wh);
        chk = whDAO.getById(wh.getId());
        Assert.assertTrue(chk.equals(wh));

        whDAO.deleteById(wh.getId());
        Assert.assertEquals(size, whDAO.getAll().size());

        Assert.assertEquals(whDAO.getWriteoffsByAccountId(2).size(), 1);

    }
}
