package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShenzaoxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShenzaoxinxiView;


/**
 * 深造信息
 *
 * @author 
 * @email 
 * @date 2024-03-20 12:00:33
 */
public interface ShenzaoxinxiService extends IService<ShenzaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShenzaoxinxiView> selectListView(Wrapper<ShenzaoxinxiEntity> wrapper);
   	
   	ShenzaoxinxiView selectView(@Param("ew") Wrapper<ShenzaoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShenzaoxinxiEntity> wrapper);
   	

}

