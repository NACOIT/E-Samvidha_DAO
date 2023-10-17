package gov.naco.soch.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import gov.naco.soch.entity.DsrcBeneficiary;



@Repository
public interface RecordTreatmentSearchRepository extends JpaRepository<DsrcBeneficiary, Long> {

	@Query(nativeQuery = true, value = "Select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName,b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth,b.dsrc_beneficiary_code as dsrcCode,bg.name as gender,bs.name as status,dbs.dsrc_reg_date as dateOfRegistration,c.ClinicalTreatmentType as clinicalTreatmentType from soch.beneficiary b join soch.dsrc_beneficiary dbs on dbs.beneficiary_id = b.id and dbs.facility_id = :facilityId and dbs.is_delete = false and b.is_delete =false join soch.master_gender bg on b.gender_id = bg.id join soch.master_dsrc_beneficiary_status bs on dbs.benficiary_status_id = bs.id left join(select bc.beneficiary_id,case when count(bc.clinical_treatment_type_id) = 2 then 0 else max(bc.clinical_treatment_type_id) END as ClinicalTreatmentType from  (select distinct clinical_treatment_type_id,bct.beneficiary_id from soch.beneficiary_clinical_treatment bct where  bct.facility_id = :facilityId  and bct.is_delete = false ) bc group by  bc.beneficiary_id ) c on b.id = c.beneficiary_id "
			+ " where ( b.benf_search_str ilike %:searchParam% or concat(b.first_name, ' ', b.middle_name, ' ', b.last_name) ilike %:searchParam% ) "
			+ "")
	List<Object[]> searchBasicDsrcBeneficiariesForAdults(@Param("searchParam") String searchParam,@Param("facilityId") Long facilityId);
	
}