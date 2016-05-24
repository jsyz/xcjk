package com.yz.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yz.model.Crane;
import com.yz.model.Dust;
import com.yz.model.Lift;
import com.yz.model.Noise;
import com.yz.service.ICraneService;
import com.yz.service.IDustService;
import com.yz.service.ILiftService;
import com.yz.service.INoiseService;
import com.yz.vo.Object_type;

public class SqlServiceUtil {

	final static ApplicationContext ac = new ClassPathXmlApplicationContext(
			"beans.xml");
	final static IDustService dustService = (IDustService) ac
			.getBean("dustService");
	final static ICraneService craneService = (ICraneService) ac
			.getBean("craneService");
	final static ILiftService liftService = (ILiftService) ac
			.getBean("liftService");
	final static INoiseService noiseService = (INoiseService) ac
			.getBean("noiseService");

	private static SqlServiceUtil servericeUtil = null;

	public static SqlServiceUtil getSqlServiceUtil() {
		if (servericeUtil == null) {
			synchronized (servericeUtil) {
				if (servericeUtil == null) {
					return new SqlServiceUtil();
				}
			}
		}
		return servericeUtil;
	}

	public boolean addObject(Object_type objType,Object object)
			throws Exception {

		boolean error = true;
		switch (objType) {
		case DUST:
			dustService.add((Dust)object);
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

}
