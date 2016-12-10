package com.yz.service;

import java.util.List;

import com.yz.model.Camera;

public interface ICameraService {

	// 添加对象
	public abstract void add(Camera camera) throws Exception;

	// 删除对象
	public abstract void delete(Camera camera);

	// 删除某个id的对象
	public abstract void deleteById(int id);

	// 修改对象
	public abstract void update(Camera camera);

	// 获取所有对象
	public abstract List<Camera> getCameras();

	// 加载一个id的对象
	public abstract Camera loadById(int id);

	// 后台管理-页数获取
	public abstract int getPageCount(int totalCount, int size);

	// 后台管理-获取总记录数
	public abstract int getTotalCount(int con, String convalue, Camera camera);

	// 后台管理-获取符合条件的记录
	public abstract List<Camera> queryList(int con, String convalue,
			Camera camera, int page, int size);

	public abstract List<Camera> getCamerasByIdDescAndLimit();

	public abstract Camera loadByPid(int pid);


}