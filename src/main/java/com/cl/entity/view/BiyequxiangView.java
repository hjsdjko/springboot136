package com.cl.entity.view;

import com.cl.entity.BiyequxiangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 毕业去向
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-20 12:00:33
 */
@TableName("biyequxiang")
public class BiyequxiangView  extends BiyequxiangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public BiyequxiangView(){
	}
 
 	public BiyequxiangView(BiyequxiangEntity biyequxiangEntity){
 	try {
			BeanUtils.copyProperties(this, biyequxiangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
