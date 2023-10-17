package gov.naco.soch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.TiOstAssessment;
import gov.naco.soch.projection.TiOstAssessmentProjection;

@Repository
public interface TIOSTAssessmentRepository
		extends JpaRepository<TiOstAssessment, Long>, JpaSpecificationExecutor<TiOstAssessment> {

	@Override
	@EntityGraph(value = "tiOstAssessGraph")
	Page<TiOstAssessment> findAll(Specification<TiOstAssessment> spec, Pageable pageable);

	@Query(nativeQuery = true, value = assessmentQuery)
	Page<TiOstAssessmentProjection> findOstAssessmentByBasicSearchWithTsVector(@Param("facilityId") Long facilityId,
			@Param("isDelete") Boolean isDelete, @Param("searchString") String searchString,
			Pageable pageable);

	String assessmentQuery = "SELECT ostassess.id as id,ostassess.date_of_assessment as dateOfAssessment, \r\n"
			+ "ostassess.injecting_route as injectingRoute, \r\n"
			+ "ostassess.is_active as isActive, ostassess.is_delete as isDelete, \r\n"
			+ "ostassess.next_date_of_assessment as nextDateOfAessment, \r\n"
			+ "ostassess.ti_ost_beneficiary_id as tiOstBeneficiaryId,\r\n"
			+ "ostben.beneficiary_id as beneficiaryId,\r\n"
			+ "ostben.ost_code as ostCode,ostben.ost_number as ostNumber,\r\n"
			+ "ostben.ost_status_id as ostStatusId,\r\n" + "ostben.status_id as statusId,\r\n"
			+ "mcs.name as status,mos.name as ostStatus,\r\n"
			+ "ben.first_name as firstName,ben.last_name as lastname,\r\n"
			+ "ben.middle_name as middleName,ben.age as age,ben.date_of_birth as dateOfBirth,\r\n"
			+ "ben.mobile_number as mobileNumber,ben.uid as uid\r\n" + "FROM   soch.ti_ost_assessment ostassess\r\n"
			+ "LEFT OUTER JOIN soch.ti_ost_beneficiary ostben \r\n"
			+ "ON ostassess.ti_ost_beneficiary_id = ostben.id \r\n" + "LEFT OUTER JOIN soch.beneficiary ben \r\n"
			+ "ON ostben.beneficiary_id = ben.id \r\n" + "LEFT OUTER JOIN soch.beneficiary_facility_mapping bfm \r\n"
			+ "ON ben.id = bfm.beneficiary_id AND ( bfm.is_active =true ) \r\n" + "LEFT OUTER JOIN soch.facility f \r\n"
			+ "ON bfm.facility_id = f.id \r\n" + "LEFT OUTER JOIN soch.master_ost_status_beneficiary mos\r\n"
			+ "on ostben.ost_status_id=mos.id\r\n" + "LEFT OUTER JOIN soch.master_client_status_ost mcs\r\n"
			+ "on ostben.status_id=mcs.id\r\n" + "WHERE  ostassess.is_delete =:isDelete \r\n" + "AND f.id =:facilityId\r\n"
			+ "and (lower(ben.ost_benf_search_str) like %:searchString%)";

}
