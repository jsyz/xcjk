package com.yz.protocol;

import org.apache.mina.core.session.IoSession;

import com.yz.mina.CmdFactoryBase;
import com.yz.mina.CommandBase;
import com.yz.mina.ICmdParser;
import com.yz.model.Dust;
import com.yz.model.Noise;
import com.yz.utils.DataConvertor;
import com.yz.utils.SqlServiceUtil;
import com.yz.vo.Object_type;

public class NoiseDataCmdFactory extends CmdFactoryBase implements ICmdParser {
	
	private SqlServiceUtil serviceUtil = SqlServiceUtil.getSqlServiceUtil();

	public NoiseDataCmdFactory(byte[] data) {
		super(data);
		// TODO Auto-generated constructor stub
		this.expected_cmd = MONITOR_CMD_TYPE.NOISE_DATA;
	}

	@Override
	public boolean OnAfter_Ack(IoSession session, CommandBase cmd)
			throws Exception {
		// TODO Auto-generated method stub

		upload_NoiseData(this.m_oData, session);
		return super.OnAfter_Ack(session, cmd);
	}

	private void upload_NoiseData(byte[] data, IoSession session) throws Exception {
		// TODO Auto-generated method stub
		
		String noiseData = DataConvertor.toString(data);
		
		//保存噪音数据 
		Noise noise = new Noise();
		noise.setData(noiseData);
		serviceUtil.addObject(Object_type.NOISE, noise);
	}

	@Override
	public void Process(IoSession session, CommandBase cmd) throws Exception {
		// TODO Auto-generated method stub

		if (cmd.getCmdType() == this.expected_cmd) {

			OnAfter_Ack(session, cmd);
		}
	}
}
