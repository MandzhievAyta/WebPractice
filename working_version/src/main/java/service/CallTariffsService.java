package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.Impl.CallTariffsDAO;
import models.CallTariffs;

@Service
public class CallTariffsService {

    private CallTariffsDAO callTariffsDAO;

    public void setCallTariffsDAO(CallTariffsDAO callTariffsDAO) {
        this.callTariffsDAO = callTariffsDAO;
    }

    @Transactional
    public void addCallTariffs(CallTariffs p) {
        this.callTariffsDAO.addSample(p);
    }

    @Transactional
    public void updateCallTariffs(CallTariffs p) {
        this.callTariffsDAO.updateSample(p);
    }

    @Transactional
    public List<CallTariffs> listCallTariffs() {
        return this.callTariffsDAO.listAll();
    }

    @Transactional
    public CallTariffs getCallTariffsById(Integer id) {
        return this.callTariffsDAO.getById(id);
    }

    @Transactional
    public void removeCallTariffs(Integer id) {
        this.callTariffsDAO.removeById(id);
    }

}
