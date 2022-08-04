package com.campus.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.campus.myapp.vo.DataVO;

@Mapper
@Repository
public interface DataDAO {
	public List<DataVO> dataAllSelect();
	public int dataInsert(DataVO vo);
}
