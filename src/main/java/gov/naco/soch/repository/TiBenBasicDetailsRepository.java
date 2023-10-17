package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.TIBenBasicDetails;
import gov.naco.soch.projection.SurveyProjection;

@Repository
public interface TiBenBasicDetailsRepository
	extends JpaRepository<TIBenBasicDetails, Long>, JpaSpecificationExecutor<TIBenBasicDetails> {
    @Query(nativeQuery = true, value = " select question_id as questionId,answer from soch.survey_answer sa "
	    + " join soch.question ques on ques.id=sa.question_id"
	    + " join soch.ti_ben_rv_assessment rv on sa.survey_id=rv.survey_id"
	    + " join soch.ti_beneficiary tb on tb.id=rv.beneficiary_id join soch.typology_master tm on tm.typology_id= tb.master_hrg_primary_id "
	    + " where rv.id=(select max(id) from soch.ti_ben_rv_assessment where beneficiary_id=:id) "
	    + " and  tb.id=:id and ques.questionnaire_id= case when tm.typology_id in (1,2,3) then 4 "
	    + " when tm.typology_id=4 then 3 when tm.typology_id in (5,6) then 2 end "
	    + " and (ques.id=case when ques.questionnaire_id=4 then 21 when ques.questionnaire_id=3 then 18 end "
	    + " or ques.id = case when ques.questionnaire_id=3 then 19 end)")
    List<SurveyProjection> getSurveyDetails(@Param("id") Long id);

}
