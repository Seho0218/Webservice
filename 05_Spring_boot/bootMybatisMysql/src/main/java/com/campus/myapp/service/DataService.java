package com.campus.myapp.service;

import java.util.List;

import com.campus.myapp.vo.DataVO;

public interface DataService {
	public List<DataVO> dataAllSelect();
	public int dataInsert(DataVO vo);

}
