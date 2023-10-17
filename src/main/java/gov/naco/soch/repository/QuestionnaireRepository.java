package gov.naco.soch.repository;

import gov.naco.soch.entity.Questionnaire;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {
	// method to check duplication in surveyName in edit
	@Query(nativeQuery = true, value = "select count(f.id) from soch.questionnaire f where "
			+ "LOWER(f.survey_name)=LOWER(?1) and f.id!=?2")
	int existsBySurveyNameInEdit(String surveyName, Integer id);
	
	// method to check duplication in surveyName in add
	@Query(nativeQuery = true, value = "select count(id) from soch.questionnaire where LOWER(survey_name)=LOWER(?1)")
	int existsBySurveyNameIgnoreCase(String surveyName);
	
	// to get all questionnaires
	@Query(nativeQuery = true, value = "select * from soch.questionnaire order by id asc")
	List<Questionnaire> findAll();
	
	Questionnaire findById(Integer id);
	List<Questionnaire> findBySurveyName(String surveyName);
}
