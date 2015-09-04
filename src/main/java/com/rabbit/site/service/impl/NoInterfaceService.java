package com.rabbit.site.service.impl;

import org.springframework.stereotype.Service;

/**
 *
 * @author rabbit
 * @date 2015年9月5日 上午1:08:56
 */
@Service
public class NoInterfaceService {
	
	public void add(String user){
		System.out.println("NoInterfaceService:"+user);
	}

}
