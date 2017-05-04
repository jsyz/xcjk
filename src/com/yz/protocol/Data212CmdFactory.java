package com.yz.protocol;

import org.apache.mina.core.session.IoSession;

import com.yz.mina.CmdFactoryBase;
import com.yz.mina.CommandBase;
import com.yz.mina.ICmdParser;
import com.yz.model.Data212;
import com.yz.utils.DataConvertor;

public class Data212CmdFactory extends CmdFactoryBase implements ICmdParser{

	public Data212CmdFactory(byte[] data) {
		super(data);
		// TODO Auto-generated constructor stub
		this.expected_cmd = MONITOR_CMD_TYPE.DATA_212;
	}

	@Override
	public boolean OnAfter_Ack(IoSession session, CommandBase cmd)
			throws Exception {
		// TODO Auto-generated method stub
		upload_Data212(this.m_oData, session);
		return super.OnAfter_Ack(session, cmd);
	}

	private void upload_Data212(byte[] data, IoSession session) {
		// TODO Auto-generated method stub
		String data212 = DataConvertor.toAsciiString(data,0,data.length);
		String[] sourceData = data212.split(";");
		
		String dtunumber = sourceData[3].substring(sourceData[3].indexOf("="));
		String dustData = sourceData[5].substring(sourceData[5].indexOf("="));
		String noiseData = sourceData[6].substring(sourceData[6].indexOf("="));
		
		Data212 mData212 = new Data212();
		mData212.setDTUnumber(dtunumber);
		mData212.setDustData(dustData);
		mData212.setNoiseData(noiseData);
		
	}

	@Override
	public void Process(IoSession session, CommandBase cmd) throws Exception {
		// TODO Auto-generated method stub
		super.Process(session, cmd);
		if (cmd.getCmdType() == this.expected_cmd) {

			OnAfter_Ack(session, cmd);
		}
	}
	
}
