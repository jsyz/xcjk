package com.yz.protocol;

import org.apache.mina.core.session.IoSession;

import com.yz.action.CraneAction;
import com.yz.mina.CmdFactoryBase;
import com.yz.mina.CommandBase;
import com.yz.mina.ICmdParser;
import com.yz.model.Crane;
import com.yz.utils.SqlServiceUtil;
import com.yz.utils.bytetofloat;
import com.yz.vo.Object_type;

public class CraneRealTimeStatusCmdFactory extends CmdFactoryBase implements
		ICmdParser {

//	private SqlServiceUtil serviceUtil = SqlServiceUtil.getSqlServiceUtil();

	public CraneRealTimeStatusCmdFactory(byte[] data) {
		super(data);
		// TODO Auto-generated constructor stub
		this.expected_cmd = MONITOR_CMD_TYPE.CRANE_REALTIME_STATUS;
	}

	@Override
	public boolean OnAfter_Ack(IoSession session, CommandBase cmd)
			throws Exception {
		// TODO Auto-generated method stub

		upload_CraneRealTimeStatus(this.m_oData, session);
		return super.OnAfter_Ack(session, cmd);
	}

	private void upload_CraneRealTimeStatus(byte[] data, IoSession session)
			throws Exception {
		// TODO Auto-generated method stub

		int begin = 15;
		int byteset = 4;
		float[] liftingData = new float[10];
		for (int i = 0; i < 10; i++)
			liftingData[i] = bytetofloat.bytes2float(data, begin + i * byteset,
					byteset); // 起重量,起升高度,变幅幅度.....
		for (float a : liftingData)
			System.out.println("the Crane data is " + a);

		boolean[] flag1 = new boolean[7]; // 故障标志
		for (int j = 0; j < 7; j++) {
			if (((data[60]) & (0x01 << j)) == 0) {
				flag1[j] = false;
			} else {
				flag1[j] = true;
			}
		}
		for (boolean a : flag1)
			System.out.println("the flag1 is " + a);

		boolean[] flag2 = new boolean[8]; // 报警标志
		for (int k = 0; k < 8; k++) {
			if (((data[62]) & (0x01 << k)) == 0) {
				flag2[k] = false;
			} else {
				flag2[k] = true;
			}
		}
		for (boolean a : flag2) {
			System.out.println("the flag2 is " + a);
		}

		//获取塔基实时数据
		Crane crane = CraneAction.craneRealTime;

		crane.setLiftingCapacity(String.valueOf(liftingData[0]));
		crane.setLiftingHeight(String.valueOf(liftingData[1]));
		crane.setLuffingWidth(String.valueOf(liftingData[2]));
		crane.setRotationAngle(String.valueOf(liftingData[3]));
		crane.setRatedTorque(String.valueOf(liftingData[4]));
		crane.setSlope(String.valueOf(liftingData[5]));
		crane.setWindVelocity(String.valueOf(liftingData[6]));
		crane.setTorquePercent(String.valueOf(liftingData[7]));
		crane.setRatedCapacity(String.valueOf(liftingData[8]));
		crane.setCapacityPercent(String.valueOf(liftingData[9]));
		
		/*crane.setWeightWarning(flag1[0]);
		crane.setHeightWarning(flag1[1]);
		crane.setWidthWarning(flag1[2]);
		crane.setAngleWarning(flag1[3]);
		crane.setWindWarning(flag1[4]);
		crane.setInclinationWarning(flag1[5]);
		crane.setRelaysWarning(flag1[6]);

		crane.setWeightAlarm(flag2[0]);
		crane.setTorqueAlarm(flag2[1]);
		crane.setHeightAlarm(flag2[2]);
		crane.setWidthAlarm(flag2[3]);
		crane.setAngleAlarm(flag2[4]);
		crane.setWindAlarm(flag2[5]);
		crane.setInclinationAlarm(flag2[6]);
		crane.setAntiCollisionAlarm(flag2[7]);*/
		
		//serviceUtil.addObject(Object_type.CRANE, crane);

	}

	@Override
	public void Process(IoSession session, CommandBase cmd) throws Exception {
		// TODO Auto-generated method stub

		if (cmd.getCmdType() == this.expected_cmd) {

			OnAfter_Ack(session, cmd);
		}
	}
}
