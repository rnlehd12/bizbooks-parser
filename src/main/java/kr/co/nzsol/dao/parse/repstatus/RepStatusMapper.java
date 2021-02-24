package kr.co.nzsol.dao.parse.repstatus;

import java.util.Map;
/**
 * 2021-02-24 강귀정
 * 신고(원천,부가,법인,종소) 관련 mapper
 * */
public interface RepStatusMapper {

	void insertAtmTax(Map<String, Object> map);

	void insertAtmAcv(Map<String, Object> map);

	void insertAtmCor(Map<String, Object> map);
	
	void insertAtmTotincm(Map<String, Object> map);

}
