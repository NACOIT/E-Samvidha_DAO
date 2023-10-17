package gov.naco.soch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.projection.Hiv2labsTestResultBasedOnPidProjection;
import gov.naco.soch.projection.Hiv2labsTestResultsProjection;

@Repository
public interface Hiv2LabsTestResultsRepository extends JpaRepository<Beneficiary, Long> , CustomRepository{
	
    @Query(nativeQuery = true, value ="select b.pid,st.name as state, dt.name as district,ft.name as ictcName,bg.name as gender	, \r\n" + 
    		"b.date_of_birth as dateOfBirth, mht.name as hivType,hltd.result_Date as resultDate,mhlrs.name as resultStatus,\r\n" + 
    		"b.id as beneficiaryId,ib.id as ictcBeneficiaryId\r\n"+
    		",case when (current_date-date(hltd.created_time)) > 7 or mhlrs.id = 2 then 'disabled' else  'enabled' end as deleteStatus " +
    	    "from soch.beneficiary b\r\n" + 
    		"join soch.ictc_beneficiary ib on b.id=ib.beneficiary_id and ib.is_deleted = false \r\n" + 
    		"join soch.master_gender bg on b.gender_id = bg.id\r\n" + 
    		"join soch.hiv2_lab_test_details hltd on b.id=hltd.beneficiary_id and hltd.is_delete = false  \r\n" + 
    		"join soch.master_hiv_type mht on hltd.hiv_type_id = mht.id\r\n" + 
    		"join soch.master_hiv2_lab_result_status mhlrs on hltd.hiv2_lab_result_status_id = mhlrs.id\r\n" + 
    		"join soch.facility ft on ft.id=ib.facility_id\r\n" + 
    		"join soch.address ad on b.address_id=ad.id\r\n" + 
    		"join soch.state st on ad.state_id=st.id\r\n" + 
    		"join soch.district dt on ad.district_id=dt.id "+
    		" where b.is_delete = false and hltd.hiv2_lab_facility_id =:facilityId ")
    Page<Hiv2labsTestResultsProjection> getTestResults(Pageable pageable,@Param("facilityId") Long facilityId);
    
    @Query(nativeQuery = true, value ="select b.pid,st.name as state, dt.name as district,ft.name as ictcName,bg.name as gender	, \r\n" + 
    		"b.date_of_birth as dateOfBirth, mht.name as hivType,hltd.result_Date as resultDate,mhlrs.name as resultStatus\r\n" + 
    		",b.id as beneficiaryId,ib.id as ictcBeneficiaryId, case when (current_date-date(hltd.created_time)) > 7 or mhlrs.id = 2 then 'disabled' else  'enabled' end as deleteStatus "+
    		"from soch.beneficiary b\r\n" + 
    		"join soch.ictc_beneficiary ib on b.id=ib.beneficiary_id and ib.is_deleted = false \r\n" + 
    		"join soch.master_gender bg on b.gender_id = bg.id\r\n" + 
    		"join soch.hiv2_lab_test_details hltd on b.id=hltd.beneficiary_id and hltd.is_delete = false  \r\n" + 
    		"join soch.master_hiv_type mht on hltd.hiv_type_id = mht.id\r\n" + 
    		"join soch.master_hiv2_lab_result_status mhlrs on hltd.hiv2_lab_result_status_id = mhlrs.id\r\n" + 
    		"join soch.facility ft on ft.id=ib.facility_id\r\n" + 
    		"join soch.address ad on b.address_id=ad.id\r\n" + 
    		"join soch.state st on ad.state_id=st.id\r\n" + 
    		"join soch.district dt on ad.district_id=dt.id "+
    		" where b.is_delete = false and hltd.hiv2_lab_result_status_id =1 and hltd.hiv2_lab_facility_id =:facilityId ")
    Page<Hiv2labsTestResultsProjection> getAwaitingTestResults(Pageable pageable,@Param("facilityId")  Long facilityId);

    @Query(nativeQuery = true, value ="select b.pid,ft.name as ictcName, \r\n" + 
    		" mht.name as hivType,hltd.result_Date as resultDate,mhlrs.name as resultStatus ,\r\n" +
    		"ln.name as hiv2Name " + 
    		"from soch.beneficiary b\r\n" + 
    		"join soch.ictc_beneficiary ib on b.id=ib.beneficiary_id and ib.is_deleted = false \r\n" + 
    		"join soch.hiv2_lab_test_details hltd on b.id=hltd.beneficiary_id and hltd.is_delete = false  \r\n" + 
    		"join soch.master_hiv_type mht on hltd.hiv_type_id = mht.id\r\n" + 
    		"join soch.master_hiv2_lab_result_status mhlrs on hltd.hiv2_lab_result_status_id = mhlrs.id\r\n" + 
    		"join soch.facility ft on ft.id=ib.facility_id\r\n" +
    		"join soch.facility ln on ln.id=hltd.hiv2_lab_facility_id\r\n " +
    		" where b.is_delete = false  and b.pid=:pidNumber and hltd.hiv2_lab_facility_id =:facilityId ")
    Page<Hiv2labsTestResultBasedOnPidProjection> getHiv2ResultBasedOnPid(Pageable pageable,@Param("pidNumber") String pidNumber,@Param("facilityId") Long facilityId);
	
	@Query(nativeQuery = true, value ="select b.pid,ft.name as ictcName, \r\n" + 
    		" mht.name as hivType,hltd.result_Date as resultDate,mhlrs.name as resultStatus ,\r\n" +
    		"ln.name as hiv2Name " + 
    		"from soch.beneficiary b\r\n" + 
    		"join soch.ictc_beneficiary ib on b.id=ib.beneficiary_id and ib.is_deleted = false \r\n" + 
    		"join soch.hiv2_lab_test_details hltd on b.id=hltd.beneficiary_id and hltd.is_delete = false  \r\n" + 
    		"join soch.master_hiv_type mht on hltd.hiv_type_id = mht.id\r\n" + 
    		"join soch.master_hiv2_lab_result_status mhlrs on hltd.hiv2_lab_result_status_id = mhlrs.id\r\n" + 
    		"join soch.facility ft on ft.id=ib.facility_id\r\n" +
    		"join soch.facility ln on ln.id=hltd.hiv2_lab_facility_id\r\n " +
    		" where b.is_delete = false  and b.pid=:pidNumber ")
    Page<Hiv2labsTestResultBasedOnPidProjection> getHiv2ResultBasedOnPidViewCard(Pageable pageable,@Param("pidNumber") String pidNumber);
	
	
	@Query(nativeQuery = true, value ="select  b.pid,st.name as state, dt.name as district,ft.name as ictcName,bg.name as gender    ,\r\n" + 
    		"b.date_of_birth as dateOfBirth, mht.name as hivType,hltd.result_Date as resultDate,mhlrs.name as resultStatus,\r\n" + 
    		"b.id as beneficiaryId,ib.id as ictcBeneficiaryId, case when (current_date-date(hltd.created_time)) > 7 or mhlrs.id = 2 then 'disabled' else  'enabled' end as deleteStatus "+
    		"from soch.beneficiary b\r\n" + 
    		"join soch.ictc_beneficiary ib on b.id=ib.beneficiary_id and ib.is_deleted = false \r\n" + 
    		"join soch.master_gender bg on b.gender_id = bg.id\r\n" + 
    		"join soch.hiv2_lab_test_details hltd on b.id=hltd.beneficiary_id and hltd.is_delete = false  \r\n" + 
    		"join soch.master_hiv_type mht on hltd.hiv_type_id = mht.id\r\n" + 
    		"join soch.master_hiv2_lab_result_status mhlrs on hltd.hiv2_lab_result_status_id = mhlrs.id\r\n" + 
    		"join soch.facility ft on ft.id=ib.facility_id\r\n" + 
    		"join soch.address ad on b.address_id=ad.id\r\n" + 
    		"join soch.state st on ad.state_id=st.id\r\n" + 
    		"join soch.district dt on ad.district_id=dt.id\r\n" + 
    		"and (st.name ilike %:searchText% or dt.name ilike %:searchText% or ft.name ilike %:searchText%)\r\n" + 
    		" where b.is_delete = false and hltd.hiv2_lab_facility_id =:facilityId ")
    Page<Hiv2labsTestResultsProjection> getBasicSrchTestResults(Pageable pageable,@Param("searchText") String searchText,@Param("facilityId") Long facilityId);


	@Query(nativeQuery = true, value ="select  b.pid,st.name as state, dt.name as district,ft.name as ictcName,bg.name as gender    ,\r\n" + 
    		"b.date_of_birth as dateOfBirth, mht.name as hivType,hltd.result_Date as resultDate,mhlrs.name as resultStatus,\r\n" + 
    		"b.id as beneficiaryId,ib.id as ictcBeneficiaryId, case when (current_date-date(hltd.created_time)) > 7 or mhlrs.id = 2 then 'disabled' else  'enabled' end as deleteStatus "+
    		"from soch.beneficiary b\r\n" + 
    		"join soch.ictc_beneficiary ib on b.id=ib.beneficiary_id and ib.is_deleted = false \r\n" + 
    		"join soch.master_gender bg on b.gender_id = bg.id\r\n" + 
    		"join soch.hiv2_lab_test_details hltd on b.id=hltd.beneficiary_id and hltd.is_delete = false  \r\n" + 
    		"join soch.master_hiv_type mht on hltd.hiv_type_id = mht.id\r\n" + 
    		"join soch.master_hiv2_lab_result_status mhlrs on hltd.hiv2_lab_result_status_id = mhlrs.id\r\n" + 
    		"join soch.facility ft on ft.id=ib.facility_id\r\n" + 
    		"join soch.address ad on b.address_id=ad.id\r\n" + 
    		"join soch.state st on ad.state_id=st.id\r\n" + 
    		"join soch.district dt on ad.district_id=dt.id\r\n" + 
    		"and (st.name ilike %:searchText% or dt.name ilike %:searchText% or ft.name ilike %:searchText%)\r\n" + 
    		" where b.is_delete = false and hltd.hiv2_lab_result_status_id =1 and hltd.hiv2_lab_facility_id =:facilityId ")
    Page<Hiv2labsTestResultsProjection> getAwaitingBasicSrchTestResults(Pageable pageable,@Param("searchText") String searchText,@Param("facilityId") Long facilityId);


}
