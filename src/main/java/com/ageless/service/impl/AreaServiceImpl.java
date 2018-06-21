package com.ageless.service.impl;

import java.util.List;

import com.ageless.mapper.AreaMapper;
import com.ageless.pojo.Area;
import com.ageless.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaMapper areamapper;

	@Override
	@Transactional
	public List<Area> seleAll() {
		System.out.println("进来了");
		List<Area> areaList=areamapper.seleAll();
		System.out.println(areaList.size());
		return areaList;
	}

}
