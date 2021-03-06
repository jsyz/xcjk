package com.yz.protocol;

import org.apache.mina.core.session.IoSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yz.action.CraneAction;
import com.yz.mina.CmdFactoryBase;
import com.yz.mina.CommandBase;
import com.yz.mina.ICmdParser;
import com.yz.model.Crane;
import com.yz.utils.DateTimeKit;
import com.yz.utils.SqlServiceUtil;
import com.yz.utils.bytetofloat;
import com.yz.vo.Object_type;

public class CraneRealTimeStatusCmdFactory extends CmdFactoryBase implements
		ICmdParser {

//	private SqlServiceUtil serviceUtil = SqlServiceUtil.getSqlServiceUtil();
	final static ApplicationContext ac = new ClassPathXmlApplicationContext(
	"beans.xml");
	final static SqlServiceUtil sqlServiceUtil = (SqlServiceUtil) ac.getBean("sqlServiceUtil");

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
					byteset,1); // 起重量,起升高度,变幅幅度.....
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
		

		crane.setLiftingCapacity(handleStringDecimal(String.valueOf(liftingData[0])));
		crane.setLiftingHeight(handleStringDecimal(String.valueOf(liftingData[1])));
		crane.setLuffingWidth(handleStringDecimal(String.valueOf(liftingData[2])));
		crane.setRotationAngle(handleStringDecimal(String.valueOf(liftingData[3])));
		crane.setRatedTorque(handleStringDecimal(String.valueOf(liftingData[4])));
		crane.setSlope(handleStringDecimal(String.valueOf(liftingData[5])));
		crane.setWindVelocity(handleStringDecimal(String.valueOf(liftingData[6])));
		crane.setTorquePercent(handleStringDecimal(String.valueOf(liftingData[7])));
		crane.setRatedCapacity(handleStringDecimal(String.valueOf(liftingData[8])));
		crane.setCapacityPercent(handleStringDecimal(String.valueOf(liftingData[9])));
		crane.setReportedTime(DateTimeKit.getLocal_Time());
		
		try {
			sqlServiceUtil.addObject(Object_type.CRANE, crane);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("塔基数据添加失败");
		}
		
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

	private String handleStringDecimal(String msg) {
		
		if(msg.contains("."))
		{
			int index = msg.indexOf(".");
			
			System.out.println("index is"+index);
			
			String msgHandle = msg.substring(index+1);
			
			if(msgHandle.length()>3)
			{
				msg = msg.substring(0, index+3);
			}
			
		}
		return msg;
	}

	@Override
	public void Process(IoSession session, CommandBase cmd) throws Exception {
		// TODO Auto-generated method stub

		if (cmd.getCmdType() == this.expected_cmd) {

			OnAfter_Ack(session, cmd);
		}
	}
}
