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

import com.cl.entity.ShenzaoxinxiEntity;
import com.cl.entity.view.ShenzaoxinxiView;

import com.cl.service.ShenzaoxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 深造信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-20 12:00:33
 */
@RestController
@RequestMapping("/shenzaoxinxi")
public class ShenzaoxinxiController {
    @Autowired
    private ShenzaoxinxiService shenzaoxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShenzaoxinxiEntity shenzaoxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			shenzaoxinxi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShenzaoxinxiEntity> ew = new EntityWrapper<ShenzaoxinxiEntity>();

		PageUtils page = shenzaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenzaoxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShenzaoxinxiEntity shenzaoxinxi, 
		HttpServletRequest request){
        EntityWrapper<ShenzaoxinxiEntity> ew = new EntityWrapper<ShenzaoxinxiEntity>();

		PageUtils page = shenzaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenzaoxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShenzaoxinxiEntity shenzaoxinxi){
       	EntityWrapper<ShenzaoxinxiEntity> ew = new EntityWrapper<ShenzaoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shenzaoxinxi, "shenzaoxinxi")); 
        return R.ok().put("data", shenzaoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShenzaoxinxiEntity shenzaoxinxi){
        EntityWrapper< ShenzaoxinxiEntity> ew = new EntityWrapper< ShenzaoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shenzaoxinxi, "shenzaoxinxi")); 
		ShenzaoxinxiView shenzaoxinxiView =  shenzaoxinxiService.selectView(ew);
		return R.ok("查询深造信息成功").put("data", shenzaoxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShenzaoxinxiEntity shenzaoxinxi = shenzaoxinxiService.selectById(id);
		shenzaoxinxi = shenzaoxinxiService.selectView(new EntityWrapper<ShenzaoxinxiEntity>().eq("id", id));
        return R.ok().put("data", shenzaoxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShenzaoxinxiEntity shenzaoxinxi = shenzaoxinxiService.selectById(id);
		shenzaoxinxi = shenzaoxinxiService.selectView(new EntityWrapper<ShenzaoxinxiEntity>().eq("id", id));
        return R.ok().put("data", shenzaoxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShenzaoxinxiEntity shenzaoxinxi, HttpServletRequest request){
    	shenzaoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shenzaoxinxi);
        shenzaoxinxiService.insert(shenzaoxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShenzaoxinxiEntity shenzaoxinxi, HttpServletRequest request){
    	shenzaoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shenzaoxinxi);
        shenzaoxinxiService.insert(shenzaoxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShenzaoxinxiEntity shenzaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shenzaoxinxi);
        shenzaoxinxiService.updateById(shenzaoxinxi);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ShenzaoxinxiEntity> list = new ArrayList<ShenzaoxinxiEntity>();
        for(Long id : ids) {
            ShenzaoxinxiEntity shenzaoxinxi = shenzaoxinxiService.selectById(id);
            shenzaoxinxi.setSfsh(sfsh);
            shenzaoxinxi.setShhf(shhf);
            list.add(shenzaoxinxi);
        }
        shenzaoxinxiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shenzaoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
