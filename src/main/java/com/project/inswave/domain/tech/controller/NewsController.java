package com.project.inswave.domain.tech.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
			
			String query = URLEncoder.encode("인스웨이브", "UTF-8");
			int display = 5;
			int start = 1;
			String apiURL = "https://openapi.naver.com/v1/search/news.json?query=" + query + "&display=" + display + "&start=" + start + "&sort=date";

			URL url = new URL(apiURL);
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
			
            if(responseCode==200) { // 정상 호출
            	AppLog.info("############### responseCode 200 ###############");
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
            AppLog.info("###############response : " + response);
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(response.toString());
            //JSONObject jsonItems = (JSONObject) jsonObject.get("items");
            JSONArray jsonArr = (JSONArray) jsonObject.get("items");
            
            AppLog.info("##########jsonArr size : " + jsonArr.size() );
            for(int i = 0; i < jsonArr.size(); i++) {
            	JSONObject itemObj = (JSONObject) jsonArr.get(i);
            	AppLog.info("pubDate : " + itemObj.get("pubDate"));
            	Date pubDate = new Date(itemObj.get("pubDate").toString());
            	AppLog.info("Date : " + pubDate );
            	
            	String postDate = (pubDate.getYear()+1900) +"-"+pubDate.getMonth()+ "-" + pubDate.getDay();
            	itemObj.put("pastDate", postDate);
            	SimpleDateFormat dtFormat = new SimpleDateFormat("yyyyMMdd");
            	LocalDate now = LocalDate.now();
            	Calendar cal = Calendar.getInstance();
                
        		Date dt = dtFormat.parse(now.toString());
                
        		cal.setTime(dt);
                
        		cal.add(Calendar.YEAR,  -(pubDate.getYear()+1900));
        		cal.add(Calendar.MONTH, -pubDate.getMonth());
        		cal.add(Calendar.DATE,  -pubDate.getDay());
            	
        		Date date = new Date(cal.getTimeInMillis());
        		
            	AppLog.info("now : " + now + " / date : " +  date.toString());
            }

            mv.addObject("items", jsonArr);
            mv.addObject("length", jsonArr.size());
           
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
}
