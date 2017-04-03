package com.wanglei.graempinf.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.basic.util.DateUtils;
import com.wanglei.graempinf_core.graempinf_core.Enum.BaseCodeEnum;
import com.wanglei.graempinf_core.graempinf_core.dao.ICapDao;
import com.wanglei.graempinf_core.graempinf_core.dao.ICareerFairDao;
import com.wanglei.graempinf_core.graempinf_core.model.CapCafPro;
import com.wanglei.graempinf_core.graempinf_core.model.CareerFair;
import com.wanglei.graempinf_core.graempinf_core.model.CareerFairAppointment;
@Service("capService")
public class CapService implements ICapService {
	private ICareerFairDao careerFairDao;
	private ICapDao capDao;
	
	public ICareerFairDao getCareerFairDao() {
		return careerFairDao;
	}
	@Inject
	public void setCareerFairDao(ICareerFairDao careerFairDao) {
		this.careerFairDao = careerFairDao;
	}
	
	public ICapDao getCapDao() {
		return capDao;
	}
	@Inject
	public void setCapDao(ICapDao capDao) {
		this.capDao = capDao;
	}
	@Override
	public void add(CareerFairAppointment cap) {
		cap.setFinshStatus(BaseCodeEnum.CAP_STATE_APPY_APOINTMENT.getIndex());
		capDao.add(cap);
	}

	@Override
	public void updateEnter(CareerFairAppointment cap) {
		//判断是否招聘会已经举行如果已经举行则修改状态为已举行
		CareerFair cf = careerFairDao.loadCareerFairByUUid(cap.getCareeFairUuid());
		java.sql.Timestamp d = DateUtils.getCurrentTimestamp();
		if(cf.getCareerFairDate().before(d)){
			cap.setFinshStatus(BaseCodeEnum.CAP_STATE_APPY_MORE.getIndex());
		}else{
			cap.setFinshStatus(BaseCodeEnum.CAP_STATE_APPY_ENTER.getIndex());
		}
		capDao.updateCap(cap);
	}

	@Override
	public Pager<CareerFairAppointment> findByPager(CareerFairAppointment cap) {
		return capDao.findBypager(cap);
	}

	@Override
	public List<CareerFairAppointment> listCareerFairAppointment(
			CareerFairAppointment cap) {
		return capDao.listCareerFair(cap);
	}

	@Override
	public CareerFairAppointment loadByid(String id) {
		return capDao.loadByuuid(id);
	}
	@Override
	public void updateCancel(CareerFairAppointment cap) {
		cap.setFinshStatus(BaseCodeEnum.CAP_STATE_APPY_CANCEL.getIndex());
		capDao.updateCap(cap);
	}
	@Override
	public List<CareerFairAppointment> loadByCfidAndCapid(String cfid,
			String Capid) {
		return capDao.loadByCfidAndCapid(cfid, Capid);
	}
	@Override
	public Pager<CapCafPro> findCapCapro(CapCafPro cacap) {
		return capDao.findCapCapro(cacap);
	}
	@Override
	public List<CapCafPro> listCapCapro(CapCafPro cacap) {
		return capDao.listCapCapro(cacap);
	}

}
