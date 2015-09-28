package com.rabbit.site.service.impl;

import org.springframework.stereotype.Service;

import com.rabbit.site.model.BaseUser;

/**
 * 测试aop的Service
 * @author rabbit
 * @date 2015年9月5日 上午1:08:56
 */
@Service
public class NoInterfaceService {
	
	public void addPerson(String personName, String add2, BaseUser baseUser) {
		System.out.println("add person " + personName);
	}
	
	public String deletePerson(String personName) {
		System.out.println("delete person " + personName) ;
		return "return"+personName;
	}
	
	public void editPerson(String personName) {
		System.out.println("edit person " + personName);
		throw new RuntimeException("edit person throw exception");
	}

}
