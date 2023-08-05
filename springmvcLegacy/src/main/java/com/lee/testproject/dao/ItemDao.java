package com.lee.testproject.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDao {
	@Autowired
	SqlSessionTemplate sqlsessionTemplate;
	
	public int insert(Map<String, Object> map) {				// map에는 그러면 sql db의 ("item_name", 큐브스테이크) = (key, value)
		return sqlsessionTemplate.insert("item.insert", map); // item_sql.xml의 item-insert를 map에
	}

	public List<Map<String, Object>> selectAll() {
		return sqlsessionTemplate.selectList("item.getItem") ;
	}

	public Map<String, Object> detail(Map<String, Object> map) {
		return   sqlsessionTemplate.selectOne("item.select_detail" , map);
	}

	public boolean update(Map<String, Object> map) {
		int result =  sqlsessionTemplate.update("item.modify", map); // 성공한 건수 
		return result == 1;
	}

	public void delete(Map<String, Object> map) {
		sqlsessionTemplate.delete("item.delete", map);
		
	}

	public List<Map<String, Object>> pselect(int offset, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>(); // 이 작업 service로 가는 게 좋음
		map.put("offset", offset);
		map.put("pageSize", pageSize);
		return sqlsessionTemplate.selectList("item.pselect", map );
	}

	public int getcount() {
		return sqlsessionTemplate.selectOne("item.getcount") ;
	}
}
