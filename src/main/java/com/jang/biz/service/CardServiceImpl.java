package com.jang.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jang.biz.mapper.CardMapper;
import com.jang.biz.model.Card;

@Service (value="cardservice")
public class CardServiceImpl implements CardService {
	
	@Autowired
	private CardMapper cardMapper;

	@Override
	public List<Card> getCardList() {
		return this.cardMapper.getCardList();
	}

	@Override
	public Card getCards(int bno) {
		return this.cardMapper.getCard(bno);
	}

	@Override
	public int addCards(Card card) {
		return this.cardMapper.addCard(card);
	}

	@Override
	public int updateCards(Card card) {
		return this.cardMapper.updateCard(card);
	}

	@Override
	public int deleteCards(int bno) {
		return this.cardMapper.deleteCard(bno);
	}

	
	
	

}
