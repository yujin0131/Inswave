package com.project.inswave.domain.tech.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inswave.elfw.annotation.ElDescription;
import com.inswave.elfw.annotation.ElValidator;
import com.inswave.elfw.log.AppLog;
import com.project.inswave.util.ApiUrlUtils;
import com.inswave.elfw.annotation.ElService;

@Controller
public class NewsController {

	@ElService(key = ApiUrlUtils.NEWS_ROOT)
	@RequestMapping(value = ApiUrlUtils.NEWS_ROOT)
	@ElDescription(sub = "뉴스 api", desc = "뉴스 api 를 가져온다")
	@ElValidator(errUrl = "")
	public ModelAndView NewsApi( Model model, RedirectAttributes redirectAttributes) {
		AppLog.info("#############################news controller########################");
		
		String clientId = "nF1kq0m3biVU20Pj4Yix";
		String clientSecret = "F5NVKW0vRf";
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName(ApiUrlUtils.TECH_NEWS); // 뷰의 이름
		try {
			
			String query = URLEncoder.encode("인스웨이브", "UTF-8"); //검색 쿼리 utf-8 타입설정
			int display = 5; // 한 번에 검색할 게시글 수
			int start = 1; // 몇번째 페이지 부터 조회할건지
			String apiURL = "https://openapi.naver.com/v1/search/news.json?query=" + query + "&display=" + display + "&start=" + start + "&sort=date";

			URL url = new URL(apiURL);
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
			
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
            	AppLog.info("############### responseCode err : " + con.getErrorStream() );
            	br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(response.toString());
            JSONArray jsonArr = (JSONArray) jsonObject.get("items");
            
            for(int i = 0; i < jsonArr.size(); i++) {
            	JSONObject itemObj = (JSONObject) jsonArr.get(i);

            	//게시 한 날짜
            	Date pubDate = new Date(itemObj.get("pubDate").toString());
            	
            	//format 안한 이유는 년도 + 1900 / 월 + 1 해야하기 때문
            	int year = pubDate.getYear()+1900;
            	int month = pubDate.getMonth()+1;
            	int day = pubDate.getDate();
            	String monthStr = month < 10 ? "0" + month : month+""; // 01월 형식 설정
            	String dayStr = day < 10 ? "0"+day : day+""; // 01일 형식 설정
            	
            	String postDate = year +"."+ monthStr + "." + dayStr;
            	itemObj.put("postDate", postDate); // 게시날짜 put

            	//오늘로부터 지난 날 계산 하기 위한 오늘날짜
            	LocalDate now = LocalDate.now();
            	
            	Period diff = Period.between(pubDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), now);
        		String pastDate = "";
        		if(diff.getYears() != 0) {
        			pastDate = diff.getYears() + "년 전";
        		}else if (diff.getMonths() !=0 || diff.getDays() > 20) {// 20일 이후는 +1 개월 로 친다.
        			pastDate = diff.getDays() > 20 ?  (diff.getMonths()+1) + "개월 전" : diff.getMonths() + "개월 전"; 
        		}else {
        			pastDate = diff.getDays() + "일 전";
        		}
        		itemObj.put("pastDate", pastDate); // 지난날짜 put
        		


            }

            mv.addObject("items", jsonArr);
            mv.addObject("length", jsonArr.size());
           
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mv;
	}
}
