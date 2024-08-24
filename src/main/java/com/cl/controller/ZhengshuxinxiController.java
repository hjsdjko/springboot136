package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.ZhengshuxinxiEntity;
import com.cl.entity.view.ZhengshuxinxiView;

import com.cl.service.ZhengshuxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 证书信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-20 12:00:33
 */
@RestController
@RequestMapping("/zhengshuxinxi")
public class ZhengshuxinxiController {
    @Autowired
    private ZhengshuxinxiService zhengshuxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhengshuxinxiEntity zhengshuxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			zhengshuxinxi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhengshuxinxiEntity> ew = new EntityWrapper<ZhengshuxinxiEntity>();

		PageUtils page = zhengshuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhengshuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhengshuxinxiEntity zhengshuxinxi, 
		HttpServletRequest request){
        EntityWrapper<ZhengshuxinxiEntity> ew = new EntityWrapper<ZhengshuxinxiEntity>();

		PageUtils page = zhengshuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhengshuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhengshuxinxiEntity zhengshuxinxi){
       	EntityWrapper<ZhengshuxinxiEntity> ew = new EntityWrapper<ZhengshuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhengshuxinxi, "zhengshuxinxi")); 
        return R.ok().put("data", zhengshuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhengshuxinxiEntity zhengshuxinxi){
        EntityWrapper< ZhengshuxinxiEntity> ew = new EntityWrapper< ZhengshuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhengshuxinxi, "zhengshuxinxi")); 
		ZhengshuxinxiView zhengshuxinxiView =  zhengshuxinxiService.selectView(ew);
		return R.ok("查询证书信息成功").put("data", zhengshuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhengshuxinxiEntity zhengshuxinxi = zhengshuxinxiService.selectById(id);
		zhengshuxinxi = zhengshuxinxiService.selectView(new EntityWrapper<ZhengshuxinxiEntity>().eq("id", id));
        return R.ok().put("data", zhengshuxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhengshuxinxiEntity zhengshuxinxi = zhengshuxinxiService.selectById(id);
		zhengshuxinxi = zhengshuxinxiService.selectView(new EntityWrapper<ZhengshuxinxiEntity>().eq("id", id));
        return R.ok().put("data", zhengshuxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhengshuxinxiEntity zhengshuxinxi, HttpServletRequest request){
    	zhengshuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhengshuxinxi);
        zhengshuxinxiService.insert(zhengshuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhengshuxinxiEntity zhengshuxinxi, HttpServletRequest request){
    	zhengshuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhengshuxinxi);
        zhengshuxinxiService.insert(zhengshuxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhengshuxinxiEntity zhengshuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhengshuxinxi);
        zhengshuxinxiService.updateById(zhengshuxinxi);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ZhengshuxinxiEntity> list = new ArrayList<ZhengshuxinxiEntity>();
        for(Long id : ids) {
            ZhengshuxinxiEntity zhengshuxinxi = zhengshuxinxiService.selectById(id);
            zhengshuxinxi.setSfsh(sfsh);
            zhengshuxinxi.setShhf(shhf);
            list.add(zhengshuxinxi);
        }
        zhengshuxinxiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhengshuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
