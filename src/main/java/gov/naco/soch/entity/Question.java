package gov.naco.soch.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "question", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "question_id_seq"), @Parameter(name = "increment_size", value = "1"),
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
public class Question {
	
	public enum QstnType {
		
		Radio(0), 
		Checkbox(1),
		Textbox(2);
		
		int value;
		private QstnType(int value) {
			this.value = value;
		}
	};
	
	@Id
	@GeneratedValue(generator = "question")
	private Integer id;
	
	@Column(length = 16)
	private String name;
	
	private QstnType choiceType;
	private String title;
	private String visibleIf;
	private String choices;
    
	@ManyToOne
	private Questionnaire questionnaire;
	
	public Question() {
		super();
	}
	
	public Question( String name, QstnType choiceType, String title, String visibleIf, String choices) {
		super();
		this.name = name;
		this.choiceType = choiceType;
		this.title = title;
		this.visibleIf = visibleIf;
		this.choices = choices;
	}
	public Question(Integer Id, String name, QstnType choiceType, String title, String visibleIf, String choices) {
		super();
		this.id=Id;
		this.name = name;
		this.choiceType = choiceType;
		this.title = title;
		this.visibleIf = visibleIf;
		this.choices = choices;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public QstnType getChoiceType() {
		return choiceType;
	}

	public void setChoiceType(QstnType choiceType) {
		this.choiceType = choiceType;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVisibleIf() {
		return visibleIf;
	}
	public void setVisibleIf(String visibleIf) {
		this.visibleIf = visibleIf;
	}
	public String getChoices() {
		return choices;
	}
	public void setChoices(String choices) {
		this.choices = choices;
	}
	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}
	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

};
