package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZhengshuxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhengshuxinxiView;


/**
 * 证书信息
 *
 * @author 
 * @email 
 * @date 2024-03-20 12:00:33
 */
public interface ZhengshuxinxiService extends IService<ZhengshuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhengshuxinxiView> selectListView(Wrapper<ZhengshuxinxiEntity> wrapper);
   	
   	ZhengshuxinxiView selectView(@Param("ew") Wrapper<ZhengshuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhengshuxinxiEntity> wrapper);
   	

}

