package com.cl.entity.view;

import com.cl.entity.ZhengshuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 证书信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-20 12:00:33
 */
@TableName("zhengshuxinxi")
public class ZhengshuxinxiView  extends ZhengshuxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhengshuxinxiView(){
	}
 
 	public ZhengshuxinxiView(ZhengshuxinxiEntity zhengshuxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, zhengshuxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
