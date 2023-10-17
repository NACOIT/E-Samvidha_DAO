package gov.naco.soch.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import gov.naco.soch.entity.PrisonQuestionnierResult;

@Repository
public interface PrisonResultRepository<PrisonQuestionResultDto> extends JpaRepository<PrisonQuestionnierResult, Long>, CustomRepository {
	List<PrisonQuestionnierResult> findByIsDelete(Boolean isDelete);
	
	//Query to find existing for add
		@Query(nativeQuery = true, value = "select count(d.id) from soch.prison_questionaire_results d where is_delete = false and (is_submitted_to_naco = true) and d.facility_id=:sacs and d.financial_year=:financialYear and d.month_name=:month")
		int existsQuestionier(@Param("sacs")Long sacs, @Param("financialYear")String financialYear, 
				@Param("month")Integer month);
	
	//Query to delete the existing entry
		@Modifying		
		@Query(nativeQuery = true, value = "delete from soch.prison_questionaire_results d where is_delete = false and d.facility_id=:sacs and d.financial_year=:financialYear and d.month_name=:month")
		int deleteExistingEntry(@Param("sacs")Long sacs, @Param("financialYear")String financialYear, 
				@Param("month")Integer month);	
		
//	@Query(nativeQuery = true, value ="select count(1) from (select distinct on(pqr.facility_id,pqr.financial_year ,pqr.month_name) pqr.facility_id,s.\"name\" as State,f.\"name\" as facilityName,pqr.financial_year ,pqr.month_name \r\n"
//			+ "	from soch.prison_questionaire_results pqr inner join soch.facility f on pqr.facility_id = f.id \r\n"
//			+ "	inner join soch.address a on a.id = f.address_id inner join state s on s.id = a.state_id \r\n"
//			+ "	where pqr.is_delete = false and pqr.is_active=true and pqr.is_submitted_to_naco=true) pqr")
//		Integer findPrisonCount(Pageable pageable);
		
		@Query(nativeQuery = true, value = "select count(1) from (select distinct on(pqr.facility_id,pqr.financial_year ,pqr.month_name) pqr.facility_id,pqr.financial_year ,pqr.month_name \r\n"
				+ "	from soch.prison_questionaire_results pqr inner join soch.facility f on pqr.facility_id = f.id \r\n"
				+ "	inner join soch.address a on a.id = f.address_id inner join soch.state s on s.id = a.state_id \r\n"
				+ "	where pqr.is_delete = false and pqr.is_active=true and pqr.is_submitted_to_naco=true) pqr")
		int findCountIsDeleteOrderByIdDesc();
		
	@Query(nativeQuery = true, value = "select * from (select distinct on(pqr.facility_id,pqr.financial_year ,pqr.month_name) pqr.facility_id,s.\"name\" as State,f.\"name\" as facilityName,pqr.financial_year ,pqr.month_name,pqr.is_submitted_to_naco,pqr.is_approved,pqr.id,date(pqr.modified_time) reportedDate \r\n"
			+ "from soch.prison_questionaire_results pqr inner join soch.facility f on pqr.facility_id = f.id \r\n"
			+ "inner join soch.address a on a.id = f.address_id inner join soch.state s on s.id = a.state_id \r\n"
			+ "where pqr.is_delete = false and pqr.is_active=true and pqr.is_submitted_to_naco=true) pqr",countQuery ="select count(1) from (select distinct on(pqr.facility_id,pqr.financial_year ,pqr.month_name) pqr.facility_id,s.\"name\" as State,f.\"name\" as facilityName,pqr.financial_year ,pqr.month_name \r\n"
					+ "	from soch.prison_questionaire_results pqr inner join soch.facility f on pqr.facility_id = f.id \r\n"
					+ "	inner join soch.address a on a.id = f.address_id inner join soch.state s on s.id = a.state_id \r\n"
					+ "	where pqr.is_delete = false and pqr.is_active=true and pqr.is_submitted_to_naco=true) pqr")
		//List<PrisonQuestionResultDto> findByIsDeleteOrderByIdDesc(Pageable pageable);
		List<Object[]> findByIsDeleteOrderByIdDesc(Pageable pageable);
	
	// Page<> findByIsDeleteOrderByIdDesc(Pageable pageable);
		
		@Query(nativeQuery = true, value = "select count(1) from (select distinct on(pqr.facility_id,pqr.financial_year ,pqr.month_name) pqr.facility_id,pqr.financial_year ,pqr.month_name \r\n"
				+ " from soch.prison_questionaire_results pqr inner join soch.facility f on pqr.facility_id = f.id \r\n"
				+ " inner join soch.address a on a.id = f.address_id inner join soch.state s on s.id = a.state_id \r\n"
				+ " where pqr.is_delete = false and pqr.is_active=true and pqr.facility_id=:facilityId) pqr")
		int findCountIsDeleteForSpecificSacs(@Param("facilityId")Long facilityId);
		
	@Query(nativeQuery = true, value = "select * from (select distinct on(pqr.facility_id,pqr.financial_year ,pqr.month_name) pqr.facility_id,s.\"name\" as State,f.\"name\" as facilityName,pqr.financial_year ,pqr.month_name,pqr.is_submitted_to_naco,pqr.is_approved,pqr.id,date(pqr.modified_time) reportedDate \r\n"
			+ "from soch.prison_questionaire_results pqr inner join soch.facility f on pqr.facility_id = f.id \r\n"
			+ "inner join soch.address a on a.id = f.address_id inner join soch.state s on s.id = a.state_id \r\n"
			+ "where pqr.is_delete = false and pqr.is_active=true and pqr.facility_id=:facilityId) pqr")
		List<Object[]> findByIsDeleteForSpecificSacs(@Param("facilityId")Long facilityId,Pageable pageable);
	
			/*  *****************  Basic and  Advance Search Block Start Here *************  */
	// Basic Search For Prison List
		@Query(nativeQuery = true, value = "select count(1) from (select distinct on(pqr.facility_id,pqr.financial_year ,pqr.month_name) pqr.facility_id,pqr.financial_year ,pqr.month_name \r\n"
				+ " from soch.prison_questionaire_results pqr inner join soch.facility f on pqr.facility_id = f.id \r\n"
				+ " inner join soch.address a on a.id = f.address_id inner join soch.state s on s.id = a.state_id \r\n"
				+ " where pqr.is_delete = false and pqr.is_active=true and pqr.is_submitted_to_naco=true \r\n"
				+ "	and (lower(s.name) like %:searchText% or lower(f.name) like %:searchText%)) pqr")
		int findCountByBasicSearch(@Param("searchText") String searchText);
		
	@Query(nativeQuery = true, value = "select * from (select distinct on(pqr.facility_id,pqr.financial_year ,pqr.month_name) pqr.facility_id,s.\"name\" as State,f.\"name\" as facilityName,pqr.financial_year ,pqr.month_name,pqr.is_submitted_to_naco,pqr.is_approved,pqr.id,date(pqr.modified_time) reportedDate \r\n"
			+ "from soch.prison_questionaire_results pqr inner join soch.facility f on pqr.facility_id = f.id \r\n"
			+ "inner join soch.address a on a.id = f.address_id inner join soch.state s on s.id = a.state_id \r\n"
			+ "where pqr.is_delete = false and pqr.is_active=true and pqr.is_submitted_to_naco=true \r\n"
			+ "and (lower(s.\"name\") like %:searchText% or lower(f.\"name\") like %:searchText%)) pqr")
		List<Object[]> getPrisonByBasicSearch(@Param("searchText") String searchText,Pageable pageable);
	
		@Query(nativeQuery = true, value = "select count(1) from (select distinct on(pqr.facility_id,pqr.financial_year ,pqr.month_name) pqr.facility_id,pqr.financial_year ,pqr.month_name \r\n"
				+ " from soch.prison_questionaire_results pqr inner join soch.facility f on pqr.facility_id = f.id \r\n"
				+ " inner join soch.address a on a.id = f.address_id inner join soch.state s on s.id = a.state_id \r\n"
				+ " where pqr.is_delete = false and pqr.is_active=true and pqr.facility_id=:facilityId"
				+ " and (lower(s.name) like %:searchText% or lower(f.name) like %:searchText%)) pqr")
		int findCountByBasicSearchSpecificSacs(@Param("facilityId")Long facilityId,@Param("searchText") String searchText);
		
	@Query(nativeQuery = true, value = "select * from (select distinct on(pqr.facility_id,pqr.financial_year ,pqr.month_name) pqr.facility_id,s.\"name\" as State,f.\"name\" as facilityName,pqr.financial_year ,pqr.month_name,pqr.is_submitted_to_naco,pqr.is_approved,pqr.id,date(pqr.modified_time) reportedDate \r\n"
			+ "from soch.prison_questionaire_results pqr inner join soch.facility f on pqr.facility_id = f.id \r\n"
			+ "inner join soch.address a on a.id = f.address_id inner join soch.state s on s.id = a.state_id \r\n"
			+ "where pqr.is_delete = false and pqr.is_active=true and pqr.facility_id=:facilityId \r\n"
			+ "and (lower(s.\"name\") like %:searchText% or lower(f.\"name\") like %:searchText%)) pqr")
		List<Object[]> getPrisonByBasicSearchSpecificSacs(@Param("facilityId")Long facilityId,@Param("searchText") String searchText,Pageable pageable);
					
					
			
	// Advance Search for Prison List are implemented in customRepository and customRepositoryImp
	
	
			/*  *****************  Basic and  Advance Search Block End Here *************  */
			
			
	// Change Submit to NACO Status
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = " update soch.prison_questionaire_results set is_submitted_to_naco =:submitToNaco,is_approved =:isApproved where is_delete = false and facility_id=:sacs and financial_year=:financialYear and month_name=:month")
	void updateSubmitToNacoStatus(@Param("submitToNaco") Boolean submitToNaco, @Param("sacs") Integer sacs, 
			@Param("financialYear") String financialYear, @Param("month") Integer month, @Param("isApproved") String isApproved);

	// Change Approval Status
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = " update soch.prison_questionaire_results set is_approved =:approvalStatus where is_delete = false and facility_id=:sacs and financial_year=:financialYear and month_name=:month")
	void changeApprovaltatus(@Param("approvalStatus") String approvalStatus, @Param("sacs") Integer sacs, 
			@Param("financialYear") String financialYear, @Param("month") Integer month);

	
	// To get Prison List for Specific SACS
	@Query(nativeQuery = true, value = "select id,question_id,male_value,female_value,tg_value,financial_year,month_name,facility_id,is_submitted_to_naco,is_approved,total_prison_in_state,total_prison_till_reporting_month \r\n"
			+ "from soch.prison_questionaire_results pqr \r\n"
			+ "where pqr.is_delete = false and pqr.is_active=true and pqr.facility_id =:facilityId \r\n"
			+ "and pqr.financial_year =:financial_year and pqr.month_name =:month_name")
	List<Object[]> getPrisonDetailsForSpecificSacs(@Param("facilityId")Long facilityId, @Param("financial_year")String financial_year, @Param("month_name")Integer month_name);

// To get Prison List for Export	
	@Query(nativeQuery = true, value = "select f.id,s.name as state  ,f.name as sacs,pqr.financial_year,\r\n"
			+ "case pqr.month_name when 1 then 'Jan' when 2 then 'Feb' when 3 then 'Mar' when 4 then 'Apr' when 5 then 'May' when 6 then 'Jun'\r\n"
			+ "when 7 then 'Jul' when 8 then 'Aug' when 9 then 'Sep' when 10 then 'Oct' when 11 then 'Nov' when 12 then 'Dec' end as month,\r\n"
			+ "to_char(pqr.created_time, 'DD-MM-YYYY') as reporting_date,pqr.total_prison_in_state as number_of_prison_in_state ,\r\n"
			+ "pqr.total_prison_till_reporting_month as prison_intervention_stated_till_reporting_month,\r\n"
			+ "mpq.question_number ,mpq.question ,pqr.male_value ,pqr.female_value ,pqr.tg_value,pqr.is_submitted_to_naco,pqr.is_approved \r\n"
			+ "from soch.prison_questionaire_results pqr inner join soch.master_prison_questions mpq on pqr.question_id = mpq.id \r\n"
			+ "inner join soch.facility f on pqr.facility_id =f.id inner join soch.address a on a.id = f.address_id\r\n"
			+ "inner join soch.state s on s.id = a.state_id where pqr.is_submitted_to_naco=true")		
		List<Object[]> findPrisonQuestionnierByNACO(Pageable pageable);	
	
		
	@Query(nativeQuery = true, value = "select f.id,s.name as state  ,f.name as sacs,pqr.financial_year,\r\n"
			+ "case pqr.month_name when 1 then 'Jan' when 2 then 'Feb' when 3 then 'Mar' when 4 then 'Apr' when 5 then 'May' when 6 then 'Jun'\r\n"
			+ "when 7 then 'Jul' when 8 then 'Aug' when 9 then 'Sep' when 10 then 'Oct' when 11 then 'Nov' when 12 then 'Dec' end as month,\r\n"
			+ "to_char(pqr.created_time, 'DD-MM-YYYY') as reporting_date,pqr.total_prison_in_state as number_of_prison_in_state ,\r\n"
			+ "pqr.total_prison_till_reporting_month as prison_intervention_stated_till_reporting_month,\r\n"
			+ "mpq.question_number ,mpq.question ,pqr.male_value ,pqr.female_value ,pqr.tg_value,pqr.is_submitted_to_naco, pqr.is_approved \r\n"
			+ "from soch.prison_questionaire_results pqr inner join soch.master_prison_questions mpq on pqr.question_id = mpq.id \r\n"
			+ "inner join soch.facility f on pqr.facility_id =f.id inner join soch.address a on a.id = f.address_id\r\n"
			+ "inner join soch.state s on s.id = a.state_id where pqr.facility_id=:facilityId")
		List<Object[]> findPrisonQuestionnierBySacs(@Param("facilityId")Long facilityId,Pageable pageable);
	
	// To get Prison List for Export on the basis of Basic Search
		@Query(nativeQuery = true, value = "select f.id,s.name as state  ,f.name as sacs,pqr.financial_year, \r\n"
				+ "case pqr.month_name when 1 then 'Jan' when 2 then 'Feb' when 3 then 'Mar' when 4 then 'Apr' when 5 then 'May' when 6 then 'Jun' \r\n"
				+ "when 7 then 'Jul' when 8 then 'Aug' when 9 then 'Sep' when 10 then 'Oct' when 11 then 'Nov' when 12 then 'Dec' end as month, \r\n"
				+ "to_char(pqr.created_time, 'DD-MM-YYYY') as reporting_date,pqr.total_prison_in_state as number_of_prison_in_state , \r\n"
				+ "pqr.total_prison_till_reporting_month as prison_intervention_stated_till_reporting_month, \r\n"
				+ "mpq.question_number ,mpq.question ,pqr.male_value ,pqr.female_value ,pqr.tg_value,pqr.is_submitted_to_naco,pqr.is_approved \r\n"
				+ "from soch.prison_questionaire_results pqr inner join soch.master_prison_questions mpq on pqr.question_id = mpq.id \r\n"
				+ "inner join soch.facility f on pqr.facility_id =f.id inner join soch.address a on a.id = f.address_id \r\n"
				+ "inner join soch.state s on s.id = a.state_id where pqr.is_submitted_to_naco=true \r\n"
				+ "and (lower(s.\"name\") like %:searchText% or lower(f.\"name\") like %:searchText%)")
			List<Object[]> findPrisonQuestionnierByBasicSearchForNACO(@Param("searchText") String searchText,Pageable pageable);
		
			@Query(nativeQuery = true, value = "select f.id,s.name as state  ,f.name as sacs,pqr.financial_year, \r\n"
					+ "case pqr.month_name when 1 then 'Jan' when 2 then 'Feb' when 3 then 'Mar' when 4 then 'Apr' when 5 then 'May' when 6 then 'Jun' \r\n"
					+ "when 7 then 'Jul' when 8 then 'Aug' when 9 then 'Sep' when 10 then 'Oct' when 11 then 'Nov' when 12 then 'Dec' end as month, \r\n"
					+ "to_char(pqr.created_time, 'DD-MM-YYYY') as reporting_date,pqr.total_prison_in_state as number_of_prison_in_state , \r\n"
					+ "pqr.total_prison_till_reporting_month as prison_intervention_stated_till_reporting_month, \r\n"
					+ "mpq.question_number ,mpq.question ,pqr.male_value ,pqr.female_value ,pqr.tg_value,pqr.is_submitted_to_naco,pqr.is_approved \r\n"
					+ "from soch.prison_questionaire_results pqr inner join soch.master_prison_questions mpq on pqr.question_id = mpq.id \r\n"
					+ "inner join soch.facility f on pqr.facility_id =f.id inner join soch.address a on a.id = f.address_id \r\n"
					+ "inner join soch.state s on s.id = a.state_id where pqr.facility_id=:facilityId \r\n"
					+ "and (lower(s.\"name\") like %:searchText% or lower(f.\"name\") like %:searchText%)")		
			List<Object[]> findPrisonQuestionnierByBasicSearchForSacs(@Param("facilityId")Long facilityId,@Param("searchText") String searchText,Pageable pageable);
						
}