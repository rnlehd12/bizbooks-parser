package kr.co.nzsol.service.parse.repstatus;

import java.util.Map;

public interface IRepStatusConvertService {

	void convertData(int flagType, Map<String, Object> map);

}
