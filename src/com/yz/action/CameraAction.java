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
import com.yz.model.Camera;
import com.yz.service.ICameraService;

@Component("cameraAction")
public class CameraAction extends ActionSupport implements RequestAware,
		SessionAware, ServletResponseAware, ServletRequestAware {
	/**
	 * 摄像头
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
	private int pid;
	private int con;
	private String convalue;

	private ICameraService cameraService;
	private Camera camera;
	private List<Camera> cameras;

	/*
	 * 获取工程下的摄像头相关信息
	 */
	public String getCamerasByProjectID() {

		camera = cameraService.loadByPid(pid);
		if (camera == null) {
			return null;
		}

		JSONObject jsonObject = JSONObject.fromObject(camera);

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
		 * totalCount = cameraService.getTotalCount(con, convalue, projectId); //
		 * 总页数 pageCount =cameraService.getPageCount(totalCount, size); if (page >
		 * pageCount && pageCount != 0) { page = pageCount; } // 所有当前页记录对象
		 * cameras = cameraService.queryList(con, convalue, projectId, page,
		 * size);
		 */
		return "list";
	}

	public String listline() throws Exception {

		cameras = cameraService.getCamerasByIdDescAndLimit();
		System.out.println(cameras.size());
		return "line";
	}

	public ICameraService getCameraService() {
		return cameraService;
	}

	@Resource
	public void setCameraService(ICameraService cameraService) {
		this.cameraService = cameraService;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public List<Camera> getCameras() {
		return cameras;
	}

	public void setCameras(List<Camera> cameras) {
		this.cameras = cameras;
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

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

}
