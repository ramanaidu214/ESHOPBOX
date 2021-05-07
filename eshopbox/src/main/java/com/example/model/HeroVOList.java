package com.example.model;

import java.io.Serializable;
import java.util.List;

public class HeroVOList implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<HeroVO> heroVO;

	public List<HeroVO> getHeroVO() {
		return heroVO;
	}

	public void setHeroVO(List<HeroVO> heroVO) {
		this.heroVO = heroVO;
	}
	
}
