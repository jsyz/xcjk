package com.yz.protocol;

import org.apache.mina.core.session.IoSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yz.action.DustAction;
import com.yz.mina.CmdFactoryBase;
import com.yz.mina.CommandBase;
import com.yz.mina.ICmdParser;
import com.yz.model.Dust;
import com.yz.model.Noise;
import com.yz.utils.DateTimeKit;
import com.yz.utils.SqlServiceUtil;
import com.yz.vo.Object_type;

public class DustDataCmdFactory extends CmdFactoryBase implements ICmdParser {

	// private SqlServiceUtil serviceUtil = SqlServiceUtil.getSqlServiceUtil();

	final static ApplicationContext ac = new ClassPathXmlApplicationContext(
			"beans.xml");
	final static SqlServiceUtil sqlServiceUtil = (SqlServiceUtil) ac
			.getBean("sqlServiceUtil");

	public DustDataCmdFactory(byte[] data) {
		super(data);
		// TODO Auto-generated constructor stub
		this.expected_cmd = MONITOR_CMD_TYPE.DUST_DATA;
	}

	@Override
	public boolean OnAfter_Ack(IoSession session, CommandBase cmd)
			throws Exception {
		// TODO Auto-generated method stub

		upload_dustdata(this.m_oData, session);
		return super.OnAfter_Ack(session, cmd);
	}

	private void upload_dustdata(byte[] data, IoSession session)
			throws Exception {
		// TODO Auto-generated method stub

		String data1;// 粉尘浓度值
		// String data2; //空气洁净度等级

		int DTUnumber = (int) data[0] & 0xff;

		int dustData = ((data[3] & 0xff) << 8) + (data[4] & 0xff);

		System.out.println(dustData);
		// 获取实时状态扬尘
		Dust dust = DustAction.dustRealTime;
		dust.setDTUnumber(DTUnumber);
		dust.setData(dustData + "");

		Dust dust_upload = new Dust();
		dust_upload.setData(String.valueOf(dustData));
		dust_upload.setReportedTime(DateTimeKit.getLocal_Time());
		try {
			sqlServiceUtil.addObject(Object_type.NOISE, dust_upload);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("噪音记录添加失败");
		}
		// serviceUtil.addObject(Object_type.DUST, dust);

		// float airLevel = (float) ((data[5]&0xff)/(10.0));

		// System.out.println("the dust is"+dust +"and the airlevle is
		// "+airLevel);
	}

	@Override
	public void Process(IoSession session, CommandBase cmd) throws Exception {
		// TODO Auto-generated method stub

		if (cmd.getCmdType() == this.expected_cmd) {

			OnAfter_Ack(session, cmd);
		}
	}
}
