package com.yz.protocol;

import com.yz.mina.CommandBase;
import com.yz.mina.ICmdParser;
import com.yz.mina.CmdFactoryBase.MONITOR_CMD_TYPE;

public class CommandData212 extends CommandBase {

	public CommandData212(ICmdParser parser) {
		super(parser);
		// TODO Auto-generated constructor stub
		m_eCmdType = MONITOR_CMD_TYPE.DATA_212;
	}

	public CommandData212(ICmdParser parser, byte[] data) {
		super(parser, data);
		// TODO Auto-generated constructor stub
		m_eCmdType = MONITOR_CMD_TYPE.DATA_212;
	}

}
