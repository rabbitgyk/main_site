package com.rabbit.site.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GuoYankui
 * @version Mar 17, 2015 11:50:15 AM
 * 
 */
public class CollectionUtil {
	
	/**
	 * （JdbcTemplate.batchUpdate中传参数使用）
	 * 将一个对象的list 转换成 一个有对象中属性的值组成的数组的list
	 * 
	 * @param objList
	 * @param fieldNames
	 * @return
	 * @throws Exception
	 */
	public static <T> List<Object[]> objListToObjArrayList(List<T> objList, String... fieldNames) {
		List<Object[]> objArrayList = new ArrayList<Object[]>();
        for (T obj : objList) {
        	objArrayList.add(ObjectUtil.objToFieldValueArray(obj, fieldNames));
        }
		return objArrayList;
	}
}
