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
import com.yz.model.Noise;
import com.yz.service.INoiseService;
import com.yz.vo.NoiseJson;

@Component("noiseAction")
public class NoiseAction extends ActionSupport implements RequestAware,
		SessionAware, ServletResponseAware, ServletRequestAware {
	/**
	 * 扬尘
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

	private INoiseService noiseService;
	private Noise noise;
	private List<Noise> noises;

	public static Noise noiseRealTime = new Noise();

	/*
	 * 实时数据
	 */
	public String realtimeNoise() {
		
		System.out.println("noise data:"+noiseRealTime.getData());
		if(noiseRealTime != null&&noiseRealTime.getData()!=null)
		{
			NoiseJson noiseJson = new NoiseJson();
			noiseJson.setData(noiseJson.getData());
			JSONObject jsonObject = JSONObject.fromObject(noiseJson);
			
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
		}
		return null;
	}

	public String list() throws Exception {
		// 判断会话是否失效
		// 总记录数
		int projectId = 1;

		totalCount = noiseService.getTotalCount(con, convalue, projectId);
		// 总页数
		pageCount = noiseService.getPageCount(totalCount, size);
		if (page > pageCount && pageCount != 0) {
			page = pageCount;
		}
		// 所有当前页记录对象
		noises = noiseService.queryList(con, convalue, projectId, page, size);
		return "list";
	}

	public String listline() throws Exception {

		noises = noiseService.getNoises();
		return "line";
	}

	public INoiseService getNoiseService() {
		return noiseService;
	}

	@Resource
	public void setNoiseService(INoiseService noiseService) {
		this.noiseService = noiseService;
	}

	public Noise getNoise() {
		return noise;
	}

	public void setNoise(Noise noise) {
		this.noise = noise;
	}

	public List<Noise> getNoises() {
		return noises;
	}

	public void setNoises(List<Noise> noises) {
		this.noises = noises;
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
