package kr.co.nzsol.service.parse.repstatus;

import java.util.Map;

public interface IRepStatusParseService {

	void insertData(int flagType, Map<String, Object> map);

}
