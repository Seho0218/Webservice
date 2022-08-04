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
	//다운로드 횟수 증가
	public int downCount(int no);
	//새로운 다운로드 횟수 선택하기
	public int newDownCount(int no);
	public int hitCount(int no);
	public DataVO dataSelect(int no);
}
