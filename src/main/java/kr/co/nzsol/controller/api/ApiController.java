package kr.co.nzsol.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.nzsol.service.parse.common.IParseService;

/**
 * 2021-02-23 강귀정
 * 파싱 호출 api controller
 * 
 */
@RestController
@RequestMapping("/api/bizbooks/parser")
public class ApiController {

	@Autowired
	IParseService parseService;
	
	@GetMapping(value= {"","/"})
	public String kclepDataParser(@RequestParam(value="parseData",required=false) String parseData) {
	
		int result = 0;
		
		if(parseData == null || "".equals(parseData)) return "FAIL!";
		
		result = parseService.dataParsing(parseData);
		
		return "SUCESS!";
	}
}
