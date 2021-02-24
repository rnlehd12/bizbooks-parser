package kr.co.nzsol.service.dto.common;

import lombok.Data;

/**
 * 2021-02-24 강귀정
 * 세무사랑 전송관련 DTO
 * */
@Data
public class ParseDataDto {

	private String sendUserId;		//세무사랑 ID
	private String parseData;		//파싱할 json
	
}
