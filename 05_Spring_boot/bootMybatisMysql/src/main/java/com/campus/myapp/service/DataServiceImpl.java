package com.campus.myapp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.campus.myapp.dao.DataDAO;
import com.campus.myapp.vo.DataVO;

@Service
public class DataServiceImple implements DataService {
	
	@Inject
	DataDAO dao;
	
	@Override
	public List<DataVO> dataAllSelect(){
		return dao.dataAllSelect();
	}

	@Override
	public int dataInsert(DataVO vo) {
		return dao.dataInsert(vo);
	}
}
