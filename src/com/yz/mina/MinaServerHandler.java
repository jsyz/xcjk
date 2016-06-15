package com.yz.mina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import com.yz.utils.DataConvertor;

public class MinaServerHandler implements IoHandler {
	final static String cmd_diaoyue1 = "FF FF FF FF 01 F0 90 00 00 08 01 89";

	public void exceptionCaught(IoSession arg0, Throwable arg1)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void inputClosed(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		arg0.closeOnFlush();
	}

	public void messageReceived(IoSession session, Object message)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("enter messageReceived from "+session.getRemoteAddress().toString()+":"
				+ DataConvertor.bytesToHexString(DataConvertor
						.toByteArray(message)));
		CmdFactoryBase cmdFactory = CmdFactoryBase.SelectCmdFactory(session,
				message);
		if (cmdFactory != null) {
			CommandBase cmd = cmdFactory.CreateCommand(session, message);
			if (null != cmd) {
				cmdFactory.Process(session, cmd);
			}
		}

	}

	public void messageSent(IoSession arg0, Object arg1) throws Exception {
		 System.out.println("发送信息:"+arg1.toString()+"到"+arg0.getRemoteAddress().toString()); 
	}

	public void sessionClosed(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	public void sessionCreated(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	public void sessionIdle(IoSession arg0, IdleStatus arg1) throws Exception {
		// TODO Auto-generated method stub

	}

	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("opened " + session.getRemoteAddress().toString());
//		String[] cmds = cmd_diaoyue1.split(" ");
//        byte[] aaa = new byte[cmds.length];
//        int i = 0;
//        for (String b : cmds) {
//            if (b.equals("FF")) {
//                aaa[i++] = -1;
//            } else {
//                aaa[i++] = Integer.valueOf(b, 16).byteValue();;
//            }
//        }
//        session.write(IoBuffer.wrap(aaa));
		// session.write(arg0);
	}

}
