package com.jang.biz.mapper;

import java.util.List;

import com.jang.biz.model.Card;

public interface CardMapper {
	
	List<Card> getCardList();
	
	Card getCard(int bno);
	
	int addCard(Card card);
	
	int updateCard(Card card);
	
	int deleteCard(int bno);
	
	

}
