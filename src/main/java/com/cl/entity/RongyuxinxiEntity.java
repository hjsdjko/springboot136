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
 * 荣誉信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-20 12:00:33
 */
@TableName("rongyuxinxi")
public class RongyuxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public RongyuxinxiEntity() {
		
	}
	
	public RongyuxinxiEntity(T t) {
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
	 * 荣誉名称
	 */
					
	private String rongyumingcheng;
	
	/**
	 * 证书图片
	 */
					
	private String zhengshutupian;
	
	/**
	 * 获得年份
	 */
					
	private String huodenianfen;
	
	/**
	 * 荣誉等级
	 */
					
	private String rongyudengji;
	
	/**
	 * 荣誉数量
	 */
					
	private Integer rongyushuliang;
	
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
	 * 设置：荣誉名称
	 */
	public void setRongyumingcheng(String rongyumingcheng) {
		this.rongyumingcheng = rongyumingcheng;
	}
	/**
	 * 获取：荣誉名称
	 */
	public String getRongyumingcheng() {
		return rongyumingcheng;
	}
	/**
	 * 设置：证书图片
	 */
	public void setZhengshutupian(String zhengshutupian) {
		this.zhengshutupian = zhengshutupian;
	}
	/**
	 * 获取：证书图片
	 */
	public String getZhengshutupian() {
		return zhengshutupian;
	}
	/**
	 * 设置：获得年份
	 */
	public void setHuodenianfen(String huodenianfen) {
		this.huodenianfen = huodenianfen;
	}
	/**
	 * 获取：获得年份
	 */
	public String getHuodenianfen() {
		return huodenianfen;
	}
	/**
	 * 设置：荣誉等级
	 */
	public void setRongyudengji(String rongyudengji) {
		this.rongyudengji = rongyudengji;
	}
	/**
	 * 获取：荣誉等级
	 */
	public String getRongyudengji() {
		return rongyudengji;
	}
	/**
	 * 设置：荣誉数量
	 */
	public void setRongyushuliang(Integer rongyushuliang) {
		this.rongyushuliang = rongyushuliang;
	}
	/**
	 * 获取：荣誉数量
	 */
	public Integer getRongyushuliang() {
		return rongyushuliang;
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
