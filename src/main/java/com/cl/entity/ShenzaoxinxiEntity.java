package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 深造信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-20 12:00:33
 */
@TableName("shenzaoxinxi")
public class ShenzaoxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShenzaoxinxiEntity() {
		
	}
	
	public ShenzaoxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 深造学校
	 */
					
	private String shenzaoxuexiao;
	
	/**
	 * 深造专业
	 */
					
	private String shenzaozhuanye;
	
	/**
	 * 深造时间
	 */
					
	private String shenzaoshijian;
	
	/**
	 * 深造状态
	 */
					
	private String shenzaozhuangtai;
	
	/**
	 * 填报时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date tianbaoshijian;
	
	/**
	 * 账号
	 */
					
	private String zhanghao;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	/**
	 * 班级
	 */
					
	private String banji;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 回复内容
	 */
					
	private String shhf;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：深造学校
	 */
	public void setShenzaoxuexiao(String shenzaoxuexiao) {
		this.shenzaoxuexiao = shenzaoxuexiao;
	}
	/**
	 * 获取：深造学校
	 */
	public String getShenzaoxuexiao() {
		return shenzaoxuexiao;
	}
	/**
	 * 设置：深造专业
	 */
	public void setShenzaozhuanye(String shenzaozhuanye) {
		this.shenzaozhuanye = shenzaozhuanye;
	}
	/**
	 * 获取：深造专业
	 */
	public String getShenzaozhuanye() {
		return shenzaozhuanye;
	}
	/**
	 * 设置：深造时间
	 */
	public void setShenzaoshijian(String shenzaoshijian) {
		this.shenzaoshijian = shenzaoshijian;
	}
	/**
	 * 获取：深造时间
	 */
	public String getShenzaoshijian() {
		return shenzaoshijian;
	}
	/**
	 * 设置：深造状态
	 */
	public void setShenzaozhuangtai(String shenzaozhuangtai) {
		this.shenzaozhuangtai = shenzaozhuangtai;
	}
	/**
	 * 获取：深造状态
	 */
	public String getShenzaozhuangtai() {
		return shenzaozhuangtai;
	}
	/**
	 * 设置：填报时间
	 */
	public void setTianbaoshijian(Date tianbaoshijian) {
		this.tianbaoshijian = tianbaoshijian;
	}
	/**
	 * 获取：填报时间
	 */
	public Date getTianbaoshijian() {
		return tianbaoshijian;
	}
	/**
	 * 设置：账号
	 */
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
	/**
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * 设置：班级
	 */
	public void setBanji(String banji) {
		this.banji = banji;
	}
	/**
	 * 获取：班级
	 */
	public String getBanji() {
		return banji;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：回复内容
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：回复内容
	 */
	public String getShhf() {
		return shhf;
	}

}
