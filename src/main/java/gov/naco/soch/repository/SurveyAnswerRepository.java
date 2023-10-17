package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.SurveyAnswer;

@Repository
public interface SurveyAnswerRepository extends JpaRepository<SurveyAnswer, Integer> {

	Optional<SurveyAnswer> findById(Integer id);
	List<SurveyAnswer> findByQuestionId(Integer id);
}