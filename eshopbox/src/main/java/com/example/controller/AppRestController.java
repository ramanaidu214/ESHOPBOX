package com.example.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.HeroInfo;
import com.example.model.HeroVO;
import com.example.model.HerosVO;

@RestController
@RequestMapping("/api")
public class AppRestController {
	
	List<HerosVO> herosList=new ArrayList<HerosVO>();
	List<HeroVO> maxherosList =null;
	
	@RequestMapping("/maxwinheroesinfo")
	private List<HeroInfo> getHerosInfo() {
		List<HeroInfo> heroInfoList= new ArrayList<>();
		
		for(int i=0;i<maxherosList.size();i++) {
			String heroId= maxherosList.get(i).getHero_id();
			for(int j=0;j<herosList.size();j++) {
				HerosVO herosVOObj = herosList.get(j);
				int heroid = herosVOObj.getId();
				if(heroId.equals(String.valueOf(heroid))) {
					HeroInfo heroInfo = new HeroInfo();
					
					heroInfo.setHero_id(heroid);
					heroInfo.setLocalized_name(herosVOObj.getLocalized_name());
					heroInfo.setName(herosVOObj.getName());
					heroInfoList.add(heroInfo);
				}
			}
		}
		return heroInfoList;
	}
	@PostConstruct
	private void getHerosList() {
		final String uri = "https://api.opendota.com/api/heroes/";
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		ResponseEntity<HerosVO[]> response = null;
		response = restTemplate.exchange(uri, HttpMethod.GET, entity, HerosVO[].class);
		
		herosList = Arrays.stream(response.getBody()).collect(Collectors.toList());

		//return getMax3Heros(response.getBody());
	}

	@RequestMapping("/maxwinheroes/{accountId}")
	private List<HeroVO> getMaxWinHerosByAccountId(@PathVariable(name = "accountId" ) String accountId) {
		final String uri = "https://api.opendota.com/api/players/{account_id}/heroes";
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		// headers.set("Host", "<calculated when request is sent>");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		Map<String, String> params = new HashMap<String, String>();
		params.put("account_id", accountId);
		
		ResponseEntity<HeroVO[]> response = null;
		response = restTemplate.exchange(uri, HttpMethod.GET, entity, HeroVO[].class, params);
		
		System.out.println(response.getBody().length);
		//return Arrays.stream(response.getBody()).collect(Collectors.toList());
		return getMax3Heros(response.getBody());
	}
	
	
	private List<HeroVO> getMax3Heros(HeroVO[] arrList) {
		List<HeroVO>  list = Arrays.stream(arrList).collect(Collectors.toList());
		
		Collections.sort(list, new Comparator<HeroVO>() {
			@Override
			public int compare(HeroVO o1, HeroVO o2) {
				return o2.getGames().compareTo(o1.getGames());
			}
		});
		
		
		List<HeroVO>  maxList = new ArrayList<HeroVO>();
		for(int i=0;i<list.size();i++) {
			maxList.add(list.get(i));
			if(i>=2)
				break;
		}
		maxherosList=new ArrayList<HeroVO>(maxList);
		return maxList;
	}
	
}
