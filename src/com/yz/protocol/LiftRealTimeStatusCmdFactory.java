package com.yz.protocol;

import org.apache.mina.core.session.IoSession;

import com.yz.mina.CmdFactoryBase;
import com.yz.mina.CommandBase;
import com.yz.mina.ICmdParser;

public class LiftRealTimeStatusCmdFactory extends CmdFactoryBase implements ICmdParser{

	private String driverID;
	private String operatingStatus;
	
	public LiftRealTimeStatusCmdFactory(byte[] data) {
		super(data);
		// TODO Auto-generated constructor stub
		this.expected_cmd = MONITOR_CMD_TYPE.LIFT_REALTIME_STATUS;
	}

	@Override
	public boolean OnAfter_Ack(IoSession session, CommandBase cmd)
			throws Exception {
		// TODO Auto-generated method stub
		upload_RealTimeStatus(this.m_oData,session);
		return super.OnAfter_Ack(session, cmd);
	}

	private void upload_RealTimeStatus(byte[] data, IoSession session) {
		// TODO Auto-generated method stub
		
		boolean[] flag1 = new boolean[7]; // 故障标志
		for (int j = 0; j < 7; j++) {
			if (((data[38]) & (0x01 << j)) == 0) {
				flag1[j] = false;
			} else {
				flag1[j] = true;
			}
		}
		for(boolean a: flag1)
			System.out.println("the flag1 is "+a);
		
		
	}

	@Override
	public void Process(IoSession session, CommandBase cmd) throws Exception {
		// TODO Auto-generated method stub
		
		if(cmd.getCmdType() == this.expected_cmd)
		{
			
			OnAfter_Ack(session, cmd);
		}
	}
	
}
