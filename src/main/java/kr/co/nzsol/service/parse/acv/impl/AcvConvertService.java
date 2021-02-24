package kr.co.nzsol.service.parse.acv.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import kr.co.nzsol.service.parse.acv.IAcvConvertService;

@Service
public class AcvConvertService implements IAcvConvertService{

	@Override
	public void convertData(int flagType, Map<String, Object> map) {
		//- flagStatus 1:부가세신고서(AcvMain) / 2:부가세신고서간이(AcvMain_GANI) / 3:계산서합계표(ACVFSUM) / 4: 세금계산서합계표(ACVSUM)
		int flagStatus = flagType % 10;
		switch(flagStatus) {
		case 1 :
			
			break;
		case 2 :
			
			break;
		case 3 :
			
			break;
		case 4 :
			
			break;
		}
	}

}
