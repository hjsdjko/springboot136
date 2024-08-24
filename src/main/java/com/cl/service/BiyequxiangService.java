package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.BiyequxiangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BiyequxiangView;


/**
 * 毕业去向
 *
 * @author 
 * @email 
 * @date 2024-03-20 12:00:33
 */
public interface BiyequxiangService extends IService<BiyequxiangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BiyequxiangView> selectListView(Wrapper<BiyequxiangEntity> wrapper);
   	
   	BiyequxiangView selectView(@Param("ew") Wrapper<BiyequxiangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BiyequxiangEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<BiyequxiangEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<BiyequxiangEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<BiyequxiangEntity> wrapper);



}

