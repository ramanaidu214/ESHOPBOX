package com.example.model;

import java.io.Serializable;

public class HeroVO implements Serializable {
	private static final long serialVersionUID = 1L;
	public String hero_id;
	public int last_played;
	public Integer games;
	public int win;
	public int with_games;
	public int with_win;
	public int against_games;
	public int against_win;

	public String getHero_id() {
		return hero_id;
	}
	public void setHero_id(String hero_id) {
		this.hero_id = hero_id;
	}
	public int getLast_played() {
		return last_played;
	}
	public void setLast_played(int last_played) {
		this.last_played = last_played;
	}
	public Integer getGames() {
		return games;
	}
	public void setGames(int games) {
		this.games = games;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getWith_games() {
		return with_games;
	}
	public void setWith_games(int with_games) {
		this.with_games = with_games;
	}
	public int getWith_win() {
		return with_win;
	}
	public void setWith_win(int with_win) {
		this.with_win = with_win;
	}
	public int getAgainst_games() {
		return against_games;
	}
	public void setAgainst_games(int against_games) {
		this.against_games = against_games;
	}
	public int getAgainst_win() {
		return against_win;
	}
	public void setAgainst_win(int against_win) {
		this.against_win = against_win;
	}
	@Override
	public String toString() {
		return "HeroVO [games=" + games + "]";
	}
	
	
}
