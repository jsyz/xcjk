package com.yz.protocol;

import org.apache.mina.core.session.IoSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yz.action.NoiseAction;
import com.yz.mina.CmdFactoryBase;
import com.yz.mina.CommandBase;
import com.yz.mina.ICmdParser;
import com.yz.model.Lift;
import com.yz.model.Noise;
import com.yz.utils.DataConvertor;
import com.yz.utils.DateTimeKit;
import com.yz.utils.SqlServiceUtil;
import com.yz.vo.Object_type;

public class NoiseDataCmdFactory extends CmdFactoryBase implements ICmdParser {

	// private SqlServiceUtil serviceUtil = SqlServiceUtil.getSqlServiceUtil();

	final static ApplicationContext ac = new ClassPathXmlApplicationContext(
			"beans.xml");
	final static SqlServiceUtil sqlServiceUtil = (SqlServiceUtil) ac
			.getBean("sqlServiceUtil");

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

	private void upload_NoiseData(byte[] data, IoSession session)
			throws Exception {
		// TODO Auto-generated method stub

		String noiseData = DataConvertor.toAsciiString(data, 1, 5);
		// String noiseData =

		// 保存噪音数据
		Noise noise = NoiseAction.noiseRealTime;
		noise.setData(noiseData);

		Noise noise_upload = new Noise();
		noise_upload.setData(noiseData);
		noise_upload.setReportedTime(DateTimeKit.getLocal_Time());
		try {
			sqlServiceUtil.addObject(Object_type.NOISE, noise_upload);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("噪音记录添加失败");
		}
		// serviceUtil.addObject(Object_type.NOISE, noise);
	}

	@Override
	public void Process(IoSession session, CommandBase cmd) throws Exception {
		// TODO Auto-generated method stub

		if (cmd.getCmdType() == this.expected_cmd) {

			OnAfter_Ack(session, cmd);
		}
	}
}
