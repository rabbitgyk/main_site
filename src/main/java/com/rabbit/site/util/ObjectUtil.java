package com.rabbit.site.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author GuoYankui
 * @version Mar 17, 2015 11:32:40 AM
 * 
 */
public class ObjectUtil {

	/**
	 * 将一个对象实例obj的所列fieldName属性的值组成Object数组
	 * 
	 * @param obj
	 * @param fieldNames
	 * @return
	 * @throws Exception
	 */
	public static Object[] objToFieldValueArray(Object obj, String... fieldNames) {
		Object[] objs = new Object[fieldNames.length];
		Class<? extends Object> clazz = obj.getClass();
		try {
			for (int i = 0; i < fieldNames.length; i++) {
				Field field = clazz.getDeclaredField(fieldNames[i]);
				if (Modifier.toString(field.getModifiers()).endsWith("private")) {
					Method getMethod = new PropertyDescriptor(field.getName(), clazz).getReadMethod();// 获得get方法
					objs[i] = getMethod.invoke(obj);
				} else {
					objs[i] = field.get(obj);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}
	
	
	
	
//	public static void main(String[] args) {
//		Bank bank = new Bank();
//		bank.setId(1);
//		bank.setName("花旗");
//		bank.setExtra("cahca");
//		
////		Person person = new Person(1, "xiaoming");
//		
//		try {
//			Object[] objs = objToFieldValueArray(bank, "id", "name","extra");
////			Object[] objs = objToFieldValueArray(person, "id", "name");
//			for(Object obj : objs){
//				System.out.println(obj.toString());
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
