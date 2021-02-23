package kr.co.nzsol.service.parse.common.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kr.co.nzsol.service.parse.common.IParseService;

@Service
public class ParseService implements IParseService{

	@Override
	@SuppressWarnings("unchecked")
	public int dataParsing(String parseData) {
		
		Gson gson = new Gson();
		List<Map<String, Object>> dataList =  new ArrayList<Map<String, Object>>();
		
		try {
			
			dataList = (List<Map<String, Object>>)gson.fromJson(parseData, new TypeToken<List<Map<String, Object>>>(){}.getType());
			
			for(Map<String, Object> m : dataList) {
				int flag = (int)Math.floor(((double)m.get("Flag")));
				System.out.println(flag);
				//System.out.println(m);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
