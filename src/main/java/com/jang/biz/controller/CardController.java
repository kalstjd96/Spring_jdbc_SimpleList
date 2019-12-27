package com.jang.biz.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jang.biz.model.Card;
import com.jang.biz.service.CardService;

@Controller(value = "cardController")
public class CardController {

	@Autowired
	private CardService cardService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception {

		List<Card> list = this.cardService.getCardList();
		model.addAttribute("list", list);

		return "CardList";
	}

	@RequestMapping(value = "/toForm")
	public String form(@RequestParam(value = "bno", required = false, defaultValue = "0") int bno, Model model)
			throws Exception {
		if (bno > 0) {

			Card card = this.cardService.getCards(bno);
			model.addAttribute("commandUrl", "editSave");
			model.addAttribute("card", card);
		} else {
			model.addAttribute("commandUrl", "addSave");
			model.addAttribute("card", new Card());
		}

		return "CardView";
	}

	@RequestMapping(value = "/addSave", method = RequestMethod.POST)
	public String add(@Valid Card card, BindingResult result, RedirectAttributes rea) throws Exception {

		if (result.hasErrors()) {
			rea.addFlashAttribute(result.getModel());
			return "redirect:list";
		}

		if (this.cardService.addCards(card) !=0) {
			rea.addFlashAttribute("message", "�ű� ��ϵǾ����ϴ�.");
			return "redirect:list";
		} else {
			rea.addFlashAttribute("message", "�ű� ��Ͽ� �����Ͽ����ϴ�. Ȯ�� �� �ٽ� �õ� �Ͽ��ֽʽÿ�");
			return "redirect:list";
		}
	}

	@RequestMapping(value = "/editSave", method = RequestMethod.POST)
	public String edit(@Valid Card card, BindingResult result, RedirectAttributes rea) throws Exception {

		if (result.hasErrors()) {
			rea.addAllAttributes(result.getModel());
			return "redirect:list";
		}

		if (this.cardService.updateCards(card) != 0) {
			rea.addFlashAttribute("message", "������ �����߽��ϴ�");
			return "redirect:list";
		} else
			rea.addFlashAttribute("message", "���� ������ ���������ϴ�.");
		return "redirect:list";
	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String delete(@RequestParam(value = "bno") int bno, RedirectAttributes rea) throws Exception {

		if (this.cardService.deleteCards(bno) == 1) {
			rea.addFlashAttribute("message", "������ �����Ͽ����ϴ�.");
			return "redirect:list";
		} else
			rea.addFlashAttribute("message", "���� ������ ���������ϴ�.");
		return "redirect:list";
	}
}
