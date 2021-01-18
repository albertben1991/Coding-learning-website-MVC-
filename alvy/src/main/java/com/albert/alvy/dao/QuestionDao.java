package com.albert.alvy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.albert.alvy.entity.Quest;
import com.albert.alvy.entity.Question;

@Repository
public class QuestionDao {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public void saveQuestion(Question q) {
		Session session = sessionFactory.getCurrentSession();
		session.save(q);
	}

	@Transactional
	public List<Question> getQuestions() {

		Session session = sessionFactory.getCurrentSession();

		Query<Question> q = session.createQuery("from Question", Question.class);
		List<Question> questions = q.list();

		return questions;
	}

	@Transactional
	public List<Question> getTestQuestions() {

		Session session = sessionFactory.getCurrentSession();
		NativeQuery<Question> query = session.createNativeQuery("select * from question order by random() limit 5",
				Question.class);
		List<Question> questions = query.list();
		return questions;

	}

	@Transactional
	public int verify(Quest quest) {

		int qid[] = { quest.getQid1(), quest.getQid2(), quest.getQid3(), quest.getQid4(), quest.getQid5() };
		int ans[] = { quest.getAns1(), quest.getAns2(), quest.getAns3(), quest.getAns4(), quest.getAns5() };
		int score = 0;
		for (int i = 0; i < 5; i++) {

			String sql = "select * from question where qid=" + qid[i] + " and answer=' " + ans[i] + "";
			Session session = sessionFactory.getCurrentSession();
			NativeQuery<Question> query = session.createNativeQuery(sql, Question.class);
			Question q = query.uniqueResult();
			if (q != null)

				score++;

		}
		return score;

	}

}
