package com.cl.dao;

import com.cl.entity.BanjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BanjiView;


/**
 * 班级
 * 
 * @author 
 * @email 
 * @date 2024-03-20 12:00:33
 */
public interface BanjiDao extends BaseMapper<BanjiEntity> {
	
	List<BanjiView> selectListView(@Param("ew") Wrapper<BanjiEntity> wrapper);

	List<BanjiView> selectListView(Pagination page,@Param("ew") Wrapper<BanjiEntity> wrapper);
	
	BanjiView selectView(@Param("ew") Wrapper<BanjiEntity> wrapper);
	

}
