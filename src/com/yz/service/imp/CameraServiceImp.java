package com.yz.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.yz.dao.ICameraDao;
import com.yz.model.Camera;
import com.yz.service.ICameraService;
@Component("cameraService")
public class CameraServiceImp implements ICameraService {
	private ICameraDao cameraDao;
	public ICameraDao getCameraDao() {
		return cameraDao;
	}
	@Resource
	public void setCameraDao(ICameraDao cameraDao) {
		this.cameraDao = cameraDao;
	}
	//添加对象
	/* (non-Javadoc)
	 * @see com.yz.service.imp.ICameraServiceImp#add(com.yz.model.Camera)
	 */
	public void add(Camera camera) throws Exception {
		cameraDao.save(camera);
	}
	//删除对象
	/* (non-Javadoc)
	 * @see com.yz.service.imp.ICameraServiceImp#delete(com.yz.model.Camera)
	 */
	public void delete(Camera camera) {
		cameraDao.delete(camera);
	}
	//删除某个id的对象
	/* (non-Javadoc)
	 * @see com.yz.service.imp.ICameraServiceImp#deleteById(int)
	 */
	public void deleteById(int id) {
		cameraDao.deleteById(id);
	}
	//修改对象
	/* (non-Javadoc)
	 * @see com.yz.service.imp.ICameraServiceImp#update(com.yz.model.Camera)
	 */
	public void update(Camera camera) {
		cameraDao.update(camera);
	}
	//获取所有对象
	/* (non-Javadoc)
	 * @see com.yz.service.imp.ICameraServiceImp#getCameras()
	 */
	public List<Camera> getCameras() {
		return cameraDao.getCameras();
	}
	//加载一个id的对象
	/* (non-Javadoc)
	 * @see com.yz.service.imp.ICameraServiceImp#loadById(int)
	 */
	public Camera loadById(int id) {
		return cameraDao.loadById(id);
	}
	//后台管理-页数获取
	/* (non-Javadoc)
	 * @see com.yz.service.imp.ICameraServiceImp#getPageCount(int, java.lang.String, int)
	 */
	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}
	//后台管理-获取总记录数
	/* (non-Javadoc)
	 * @see com.yz.service.imp.ICameraServiceImp#getTotalCount(int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue, Camera camera) {
		String queryString = "select count(*) from Camera mo where 1=1 and mo.id!="+camera.getId();
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			if(con==1){
				queryString += "and mo.unit.name like ? "; 
			}
			if(con==2){
				queryString += "and mo.realname like ? "; 
				
			}
			if(con==3){
				queryString += "and mo.number like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
		return cameraDao.getUniqueResult(queryString,p);
	}
	//后台管理-获取符合条件的记录
	/* (non-Javadoc)
	 * @see com.yz.service.imp.ICameraServiceImp#queryList(int, java.lang.String, int, int)
	 */
	public List<Camera> queryList(int con, String convalue, Camera camera, int page, int size) {
		String queryString = "from Camera mo where 1=1 and mo.id!="+camera.getId();
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			if(con==1){
				queryString += "and mo.unit.name like ? "; 
			}
			if(con==2){
				queryString += "and mo.realname like ? "; 
				
			}
			if(con==3){
				queryString += "and mo.number like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
		return cameraDao.pageList(queryString,p,page,size);
	}
	public List<Camera> getCamerasByIdDescAndLimit() {
		String queryString = "from Camera mo  order by id desc";
		return cameraDao.queryList(queryString,10);
	}
	public Camera loadByPid(int pid) {
		// TODO Auto-generated method stub
		String queryString="from Camera mo where mo.pid=:pid";
		String[] paramNames=new String[]{"pid"};
		Object[] values=new Object[]{pid};
		return cameraDao.queryByNamedParam(queryString,paramNames,values);
	}
	
}
