package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterPrisonQuestion;

@Repository
public interface MasterPrisonQuestionRepository  extends JpaRepository<MasterPrisonQuestion, Long> {
	
	//List<MasterPrisonQuestion> findByIsDelete(Boolean isDelete);	
	List<MasterPrisonQuestion> findAllByOrderByIdAsc();

}
