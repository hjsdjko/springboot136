package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.RongyuxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RongyuxinxiView;


/**
 * 荣誉信息
 *
 * @author 
 * @email 
 * @date 2024-03-20 12:00:33
 */
public interface RongyuxinxiService extends IService<RongyuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RongyuxinxiView> selectListView(Wrapper<RongyuxinxiEntity> wrapper);
   	
   	RongyuxinxiView selectView(@Param("ew") Wrapper<RongyuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RongyuxinxiEntity> wrapper);
   	

}

