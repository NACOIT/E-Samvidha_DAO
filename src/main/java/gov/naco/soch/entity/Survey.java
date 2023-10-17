package gov.naco.soch.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import gov.naco.soch.entity.Question;

@Entity
public class Survey {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<SurveyAnswer> answers = new ArrayList<SurveyAnswer>();
	
	@ManyToOne
	private Questionnaire questionnaire;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}
	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	public SurveyAnswer addAnswer(SurveyAnswer answer) {
		answers.add(answer);
		answer.setSurvey(this);
		return answer;
	}
	public void setAnswers(List<SurveyAnswer> answers) {
		this.answers = answers;
	}
	public SurveyAnswer removeAnswer(SurveyAnswer answer) {
		answers.remove(answer);
		answer.setSurvey(null);
		return answer;
	}
	public void removeAllAnswers() {
		for (SurveyAnswer answer : answers) {
			answer.setSurvey(null);
		}
		answers.clear();
	}
	public List<SurveyAnswer> getAnswers() {
		return answers;
	}
}

