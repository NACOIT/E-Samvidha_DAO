package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import gov.naco.soch.entity.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Integer> {

	Optional<Survey> findById(Integer id);
}
