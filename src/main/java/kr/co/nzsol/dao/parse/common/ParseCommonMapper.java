package kr.co.nzsol.dao.parse.common;

import kr.co.nzsol.service.dto.common.ParseDataDto;

public interface ParseCommonMapper {
	
	/**
	 * 2021.02.24 yyw
	 * 
	 * 세무사랑에서 보낸 정보 insert
	 * @param parseDataDto
	 */
	void insertParseInfo(ParseDataDto parseDataDto);
	
	/**
	 * 2021.02.24 yyw
	 * 
	 * 파싱NY  N -> Y 변경
	 * @param parseDataDto
	 */
	void updateParseInfo(ParseDataDto parseDataDto);
	
	
}
