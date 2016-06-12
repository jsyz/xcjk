package com.yz.protocol;

import org.apache.mina.core.session.IoSession;

import com.yz.mina.CmdFactoryBase;
import com.yz.mina.CommandBase;
import com.yz.mina.ICmdParser;
import com.yz.model.Lift;
import com.yz.utils.SqlServiceUtil;
import com.yz.vo.Object_type;

public class LiftRealTimeStatusCmdFactory extends CmdFactoryBase implements
		ICmdParser {

	private String driverID;
	private String operatingStatus;

	private SqlServiceUtil serviceUtil = SqlServiceUtil.getSqlServiceUtil();

	public LiftRealTimeStatusCmdFactory(byte[] data) {
		super(data);
		// TODO Auto-generated constructor stub
		this.expected_cmd = MONITOR_CMD_TYPE.LIFT_REALTIME_STATUS;
	}

	@Override
	public boolean OnAfter_Ack(IoSession session, CommandBase cmd)
			throws Exception {
		// TODO Auto-generated method stub
		upload_RealTimeStatus(this.m_oData, session);
		return super.OnAfter_Ack(session, cmd);
	}

	private void upload_RealTimeStatus(byte[] data, IoSession session)
			throws Exception {
		// TODO Auto-generated method stub
		boolean[] flag1 = new boolean[7]; // 故障标志
		for (int j = 0; j < 7; j++) {
			if (((data[38]) & (0x01 << j)) == 0) {
				flag1[j] = false;
			} else {
				flag1[j] = true;
			}
		}
		for (boolean a : flag1) {
			System.out.println("the flag1 is " + a);
		}

		Lift lift = new Lift();

		lift.setHoistingAlarm(flag1[0]);
		lift.setSquattingAlarm(flag1[1]);
		lift.setFaceDetectionError(flag1[2]);
		lift.setControlSignalError(flag1[3]);
		lift.setSingleDoorError(flag1[4]);
		lift.setDoubleDoorError(flag1[5]);
		lift.setTopDoorError(flag1[6]);
		
		
		serviceUtil.addObject(Object_type.LIFT, lift);

	}

	@Override
	public void Process(IoSession session, CommandBase cmd) throws Exception {
		// TODO Auto-generated method stub

		if (cmd.getCmdType() == this.expected_cmd) {

			OnAfter_Ack(session, cmd);
		}
	}

}
