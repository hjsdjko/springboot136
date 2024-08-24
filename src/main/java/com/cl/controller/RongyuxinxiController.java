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

import com.cl.entity.RongyuxinxiEntity;
import com.cl.entity.view.RongyuxinxiView;

import com.cl.service.RongyuxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 荣誉信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-20 12:00:33
 */
@RestController
@RequestMapping("/rongyuxinxi")
public class RongyuxinxiController {
    @Autowired
    private RongyuxinxiService rongyuxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RongyuxinxiEntity rongyuxinxi,
                @RequestParam(required = false) Double rongyushuliangstart,
                @RequestParam(required = false) Double rongyushuliangend,
		HttpServletRequest request){
        EntityWrapper<RongyuxinxiEntity> ew = new EntityWrapper<RongyuxinxiEntity>();
                if(rongyushuliangstart!=null) ew.ge("rongyushuliang", rongyushuliangstart);
                if(rongyushuliangend!=null) ew.le("rongyushuliang", rongyushuliangend);

		PageUtils page = rongyuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, rongyuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RongyuxinxiEntity rongyuxinxi, 
                @RequestParam(required = false) Double rongyushuliangstart,
                @RequestParam(required = false) Double rongyushuliangend,
		HttpServletRequest request){
        EntityWrapper<RongyuxinxiEntity> ew = new EntityWrapper<RongyuxinxiEntity>();
                if(rongyushuliangstart!=null) ew.ge("rongyushuliang", rongyushuliangstart);
                if(rongyushuliangend!=null) ew.le("rongyushuliang", rongyushuliangend);

		PageUtils page = rongyuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, rongyuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RongyuxinxiEntity rongyuxinxi){
       	EntityWrapper<RongyuxinxiEntity> ew = new EntityWrapper<RongyuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( rongyuxinxi, "rongyuxinxi")); 
        return R.ok().put("data", rongyuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RongyuxinxiEntity rongyuxinxi){
        EntityWrapper< RongyuxinxiEntity> ew = new EntityWrapper< RongyuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( rongyuxinxi, "rongyuxinxi")); 
		RongyuxinxiView rongyuxinxiView =  rongyuxinxiService.selectView(ew);
		return R.ok("查询荣誉信息成功").put("data", rongyuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RongyuxinxiEntity rongyuxinxi = rongyuxinxiService.selectById(id);
		rongyuxinxi = rongyuxinxiService.selectView(new EntityWrapper<RongyuxinxiEntity>().eq("id", id));
        return R.ok().put("data", rongyuxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RongyuxinxiEntity rongyuxinxi = rongyuxinxiService.selectById(id);
		rongyuxinxi = rongyuxinxiService.selectView(new EntityWrapper<RongyuxinxiEntity>().eq("id", id));
        return R.ok().put("data", rongyuxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RongyuxinxiEntity rongyuxinxi, HttpServletRequest request){
    	rongyuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(rongyuxinxi);
        rongyuxinxiService.insert(rongyuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody RongyuxinxiEntity rongyuxinxi, HttpServletRequest request){
    	rongyuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(rongyuxinxi);
        rongyuxinxiService.insert(rongyuxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody RongyuxinxiEntity rongyuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(rongyuxinxi);
        rongyuxinxiService.updateById(rongyuxinxi);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<RongyuxinxiEntity> list = new ArrayList<RongyuxinxiEntity>();
        for(Long id : ids) {
            RongyuxinxiEntity rongyuxinxi = rongyuxinxiService.selectById(id);
            rongyuxinxi.setSfsh(sfsh);
            rongyuxinxi.setShhf(shhf);
            list.add(rongyuxinxi);
        }
        rongyuxinxiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        rongyuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
