package com.yz.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.model.Lift;
import com.yz.model.Noise;
import com.yz.service.ILiftService;

@Component("liftAction")
public class LiftAction extends ActionSupport implements RequestAware,
		SessionAware, ServletResponseAware, ServletRequestAware {
	/**
	 * 升降机
	 */
	private static final long serialVersionUID = 1L;
	Map<String, Object> request;
	Map<String, Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;

	private String[] arg = new String[2];
	private int page;
	private final int size = 10;
	private int pageCount;
	private int totalCount;
	// 条件
	private int id;
	private int con;
	private String convalue;

	private ILiftService liftService;
	private Lift lift;
	private List<Lift> lifts;
	
	public static Lift liftRealTime = new Lift();
	
	
	/*
	 * 实时数据
	 */
	public String realtimeLift() {
		
		JSONObject jsonObject = JSONObject.fromObject(liftRealTime);
		// System.out.println(jsonObject.toString());
		PrintWriter out;
		try {
			response.setCharacterEncoding("UTF-8");
			out = response.getWriter();
			out.print(jsonObject);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE;
	}

	public String list() throws Exception {
		// 判断会话是否失效
		// 总记录数

		/*
		 * int projectId = 1;
		 * 
		 * totalCount = liftService.getTotalCount(con, convalue, projectId); //
		 * 总页数 pageCount =liftService.getPageCount(totalCount, size); if (page >
		 * pageCount && pageCount != 0) { page = pageCount; } // 所有当前页记录对象 lifts =
		 * liftService.queryList(con, convalue, projectId, page, size);
		 */
		return "list";
	}

	public String listline() throws Exception {

		lifts = liftService.getLifts();
		return "line";
	}

	public ILiftService getLiftService() {
		return liftService;
	}

	@Resource
	public void setLiftService(ILiftService liftService) {
		this.liftService = liftService;
	}

	public Lift getLift() {
		return lift;
	}

	public void setLift(Lift lift) {
		this.lift = lift;
	}

	public List<Lift> getLifts() {
		return lifts;
	}

	public void setLifts(List<Lift> lifts) {
		this.lifts = lifts;
	}

	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request = request;

	}

	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;

	}

	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;

	}

	public void setServletRequest(HttpServletRequest req) {
		// TODO Auto-generated method stub
		this.req = req;

	}

	public String[] getArg() {
		return arg;
	}

	public void setArg(String[] arg) {
		this.arg = arg;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCon() {
		return con;
	}

	public void setCon(int con) {
		this.con = con;
	}

	public String getConvalue() {
		return convalue;
	}

	public void setConvalue(String convalue) {
		this.convalue = convalue;
	}

	public int getSize() {
		return size;
	}

}
