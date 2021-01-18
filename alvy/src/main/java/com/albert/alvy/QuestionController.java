package com.albert.alvy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.albert.alvy.dao.QuestionDao;
import com.albert.alvy.entity.Quest;
import com.albert.alvy.entity.Question;

@Controller
@EnableWebMvc
public class QuestionController {
	@Autowired
	QuestionDao qDao;

	@RequestMapping("saveQuestion.htm")
	public ModelAndView saveQuestion(@ModelAttribute Question q) // to save a question
	{

		ModelAndView mv = new ModelAndView("saveQuestion.jsp");
		qDao.saveQuestion(q);
		return mv;
	}

	@RequestMapping("getQuestions")
	@ResponseBody
	public List<Question> getQuestions() // returns all questions
	{
		List<Question> questions = qDao.getTestQuestions();

		System.out.println(questions);

		return questions;
	}

	@RequestMapping("/test.htm") // code test
	public ModelAndView test() {
		ModelAndView mv = new ModelAndView("test.jsp");

		return mv;
	}

	@RequestMapping("/verify.htm")
	public ModelAndView verify(@ModelAttribute Quest quest) // calculating and printing result
	{
		int result = qDao.verify(quest);
		ModelAndView mv = new ModelAndView("result.jsp");
		mv.addObject("result", result);
		mv.addObject("percent", result * 20);

		return mv;
	}
}
