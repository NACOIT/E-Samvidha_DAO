package gov.naco.soch.repository;

import gov.naco.soch.entity.Question;
import gov.naco.soch.entity.Questionnaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
	
}
