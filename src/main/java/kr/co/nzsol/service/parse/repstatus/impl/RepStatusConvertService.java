package kr.co.nzsol.service.parse.repstatus.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.nzsol.service.parse.repstatus.IRepStatusConvertService;
import kr.co.nzsol.service.parse.repstatus.acv.AcvConvert;
import kr.co.nzsol.service.parse.repstatus.cor.CorConvert;
import kr.co.nzsol.service.parse.repstatus.tax.TaxConvert;
import kr.co.nzsol.service.parse.repstatus.totincm.TotincmConvert;

@Service
public class RepStatusConvertService implements IRepStatusConvertService {

	@Autowired
	TaxConvert tax;
	
	@Autowired
	AcvConvert acv;
	
	@Autowired
	CorConvert cor;
	
	@Autowired
	TotincmConvert totincm;
	
	@Override
	public void convertData(int flagType, Map<String, Object> map) {
		switch(flagType) {
			case 2 : tax.convertData(map); break;
			case 3 : acv.convertData(map); break;
			case 4 : cor.convertData(map); break;
			case 5 : totincm.convertData(map); break;
		}
	}

}
