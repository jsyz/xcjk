package com.yz.utils;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.yz.model.Crane;
import com.yz.model.Dust;
import com.yz.model.Lift;
import com.yz.model.Noise;
import com.yz.service.ICraneService;
import com.yz.service.IDustService;
import com.yz.service.ILiftService;
import com.yz.service.INoiseService;
import com.yz.vo.Object_type;

@Component
public class SqlServiceUtil {

	private IDustService dustService;
	private ILiftService liftService;
	private ICraneService craneService;
	private INoiseService noiseService;

	public boolean addObject(Object_type objType, Object object)
			throws Exception {

		boolean error = true;
		switch (objType) {
		case DUST:
			dustService.add((Dust) object);
			error = false;
			break;
		case CRANE:
			craneService.add((Crane) object);
			error = false;
			break;
		case LIFT:
			liftService.add((Lift) object);
			error = false;
			break;
		case NOISE:
			noiseService.add((Noise) object);
			error = false;
			break;
		default:
			break;
		}

		return error;
	}

	public IDustService getDustService() {
		return dustService;
	}

	@Resource
	public void setDustService(IDustService dustService) {
		this.dustService = dustService;
	}

	public ILiftService getLiftService() {
		return liftService;
	}

	@Resource
	public void setLiftService(ILiftService liftService) {
		this.liftService = liftService;
	}

	public ICraneService getCraneService() {
		return craneService;
	}

	@Resource
	public void setCraneService(ICraneService craneService) {
		this.craneService = craneService;
	}

	public INoiseService getNoiseService() {
		return noiseService;
	}

	@Resource
	public void setNoiseService(INoiseService noiseService) {
		this.noiseService = noiseService;
	}

}
