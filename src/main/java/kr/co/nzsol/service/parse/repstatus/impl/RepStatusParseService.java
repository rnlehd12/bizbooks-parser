package kr.co.nzsol.service.parse.repstatus.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.nzsol.dao.parse.repstatus.RepStatusMapper;
import kr.co.nzsol.service.parse.repstatus.IRepStatusParseService;

/**
 * 2021-02-24 강귀정
 * 신고(원천,부가,법인,종소)관련 service
 * */
@Service
public class RepStatusParseService implements IRepStatusParseService {

	@Autowired
	RepStatusMapper repStatusMapper;
	
	/**
	 * @param int flagType, Map<String, Object> map
	 * */
	@Override
	public void insertData(int flagType, Map<String, Object> map) {

		//- 필요한 필드 추가
		map.put("TaxAgentCompCd", (String)map.get("OrderCompCd"));
		map.put("RglRtnSec", (int)Math.floor((double)map.get("RglRtnSec")));
		map.put("Status", (int)Math.floor((double)map.get("Status")));
		map.put("RglRtnSecDtlCd", (int)Math.floor((double)map.get("RglRtnSecDtlCd")));
		map.put("TaxAdjtmYn", (int)Math.floor((double)map.get("TaxAdjtmYn")));
		map.put("DispIncYn", (int)Math.floor((double)map.get("DispIncYn")));
		map.put("RefundYn", (int)Math.floor((double)map.get("RefundYn")));
		
		if(flagType == 2) repStatusMapper.insertAtmTax(map);
		else if(flagType == 3) repStatusMapper.insertAtmAcv(map);
		else if(flagType == 4) repStatusMapper.insertAtmCor(map);
		else if(flagType == 5) repStatusMapper.insertAtmTotincm(map);	
	}

}
