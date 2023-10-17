package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.projection.Hiv2labsFacilityDetailsProjection;
import gov.naco.soch.projection.Hiv2labsSearchProjection;

@Repository
public interface Hiv2LabsSearchIctcRepository extends JpaRepository<Beneficiary, Long> {
	
    @Query(nativeQuery = true, value ="select b.id as beneficaryId,ib.id as ictcBeneficaryId,ib.facility_id as facilityId, b.pid as pid,b.first_name as firstName,b.middle_name as middleName,b.last_name as lastName,\r\n" + 
    		"bg.name as gender,b.date_of_birth as dateOfBirth,b.reg_date as dateOfRegistration,\r\n" + 
    		"b.mobile_number as mobileNumber,mht.name as hivStatus from soch.beneficiary b\r\n" + 
    		"join soch.master_gender bg on b.gender_id = bg.id\r\n" + 
    		"join soch.master_hiv_type mht on b.hiv_type_id = mht.id\r\n" + 
    		"join soch.ictc_beneficiary ib on b.id=ib.beneficiary_id \r\n" +
    		" where b.pid=:pidNumber")
	Hiv2labsSearchProjection searchIctcBeneficiary(@Param("pidNumber") String pidNumber);
    
    
    @Query(nativeQuery = true, value ="select id as facilityId, name as facilityName, facility_no as facilityNumber from soch.facility where id = :facilityId")
	Hiv2labsFacilityDetailsProjection getFacilityDetails(@Param("facilityId") Long facilityId);
    
    
}
