package kr.co.nzsol.service.parse.acv.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.nzsol.dao.parse.acv.AcvMapper;
import kr.co.nzsol.service.parse.acv.IAcvParseService;

@Service
public class AcvParseService implements IAcvParseService{

	@Autowired
	AcvMapper acvMapper;
	
	@Override
	public void insertData(int flag, Map<String, Object> map) {

		//- TODO flag타입맞춰서 쿼리 구현... + userid, orderCompCd 등 키값 변경 필요 
		int flagStatus = flag % 10;
			
		if(flagStatus == 1) acvMapper.insertAcvMain(map);
		else if(flagStatus == 2) acvMapper.insertAcvMainGani(map);
		else if(flagStatus == 3) acvMapper.insertAcvfSum(map);
		else if(flagStatus == 4) acvMapper.insertAcvSum(map);
	}

}
