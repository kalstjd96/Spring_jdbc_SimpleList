package com.jang.biz.service;

import java.util.List;

import com.jang.biz.model.Card;

public interface CardService {
	
	List<Card> getCardList();	
	Card getCards(int bno);
	int addCards(Card card);
	int updateCards(Card card);
	int deleteCards(int bno);

}
