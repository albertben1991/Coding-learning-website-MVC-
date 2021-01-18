package com.albert.alvy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.albert.alvy.dao.FeedbackDao;
import com.albert.alvy.entity.Feedback;

@Controller
public class IndexController

{

	@Autowired
	FeedbackDao fdao;

	Feedback feedback;

	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}

	@RequestMapping("/feedback.htm")
	public String feedback() {

		return "feedback.jsp";
	}

	@RequestMapping("/addFeedback")
	public String addFeedback(@ModelAttribute Feedback feedback) {

		fdao.addFeedback(feedback);
		return "welcome.jsp";

	}

}
