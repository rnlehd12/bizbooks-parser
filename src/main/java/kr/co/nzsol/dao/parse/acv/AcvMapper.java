package kr.co.nzsol.dao.parse.acv;

import java.util.Map;

public interface AcvMapper {

	void insertAcvMain(Map<String, Object> map);

	void insertAcvMainGani(Map<String, Object> map);

	void insertAcvfSum(Map<String, Object> map);

	void insertAcvSum(Map<String, Object> map);

}
