package kr.co.nzsol.service.parse.common.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kr.co.nzsol.dao.parse.common.ParseCommonMapper;
import kr.co.nzsol.service.dto.common.ParseDataDto;
import kr.co.nzsol.service.parse.common.IDataConvertService;
import kr.co.nzsol.service.parse.common.IParseService;

@Service
public class ParseService implements IParseService{
	
	@Autowired
	IDataConvertService dataConvertService;
	
	@Autowired
	ParseCommonMapper parseCommonMapper;

	/**
	 * 2021-02-23 강귀정
	 * json 데이터 파싱 service
	 * 
	 * @param : ParseDataDto
	 * 
	 * # 원천세 마감: 21, 제작: 22, 신고: 23, 마감취소: 24
	 * # 부가세 마감: 31, 제작: 32, 신고: 33, 마감취소: 34
	 * # 법인세 마감: 41, 제작: 42, 신고: 43, 마감취소: 44
	 * # 종소세 마감: 51, 제작: 52, 신고: 53, 마감취소: 54
	 * # 부가세 신고서: 61
	 * # 부가세 신고서 간이: 62
	 * # 계산서 합계표: 63
	 * # 세금계산서 합계표: 64
	 * # 금액은 마감일때만 입력
	 */
	@Override
	@SuppressWarnings("unchecked")
	public String dataParsing(ParseDataDto parseDataDto) {
		
		String sendUserId = parseDataDto.getSendUserId();
		String parseData = parseDataDto.getParseData();

		if(sendUserId == null || "".equals(sendUserId)) return "SENDUSERID NULL";
		
		if(parseData == null || "".equals(parseData)) return "JSON NULL";
			
		String msg = "SUCCESS!";
		Gson gson = new Gson();
		List<Map<String, Object>> dataList =  new ArrayList<Map<String, Object>>();
		
		try {
			
			//- 데이터 리스트 파싱
			dataList = (List<Map<String, Object>>)gson.fromJson(parseData, new TypeToken<List<Map<String, Object>>>(){}.getType());
			
			//- 마감관련 정보 DB저장
			parseCommonMapper.insertParseInfo(parseDataDto);
			
			for(Map<String, Object> map : dataList) {
				dataConvertService.convertData(map);
				
				if(!map.containsKey("Flag")) return "Flag NULL";

				int flag = (int)Math.floor(((double)map.get("Flag")));
			}
			
			// 파싱작업 Update완료 
			/* parseCommonMapper.updateParseInfo(parseDataDto); */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return msg;
	}
		
}
