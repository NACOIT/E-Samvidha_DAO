package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtPrivateDispensation;
import gov.naco.soch.projection.PrivateDispensationProjection;

@Repository
public interface ArtPrivateDispensationRepository
		extends JpaRepository<ArtPrivateDispensation, Long>, CustomRepository {

	@Query(nativeQuery = true, value = "select pd.id as privateDispensationId,pd.private_facility_name as privateFacilityName,\r\n"
			+ "pd.private_beneficiary_name as beneficiaryName,pd.dispense_date as dispenseDate,pd.modified_time as modifiedTime,\r\n"
			+ "pd.date_of_birth as dateOfBirth,g.name as gender from soch.art_private_dispensation pd\r\n"
			+ "join soch.master_gender g on(pd.gender_id=g.id)\r\n"
			+ "where pd.dispensed_facility_id=:facilityId and pd.dispense_date=:date")
	List<PrivateDispensationProjection> findByFacilityIdAndDispenseDate(@Param("facilityId") Long facilityId,
			@Param("date") LocalDate date);

	@Query(nativeQuery = true, value = "select pd.id as privateDispensationId,pd.private_facility_name as privateFacilityName,\r\n"
			+ "pd.private_beneficiary_name as beneficiaryName,pd.dispense_date as dispenseDate,\r\n"
			+ "pd.date_of_birth as dateOfBirth,g.name as gender from soch.art_private_dispensation pd\r\n"
			+ "join soch.master_gender g on(pd.gender_id=g.id)\r\n"
			+ "where pd.dispensed_facility_id=:facilityId and pd.dispense_date=:date and LOWER(pd.private_beneficiary_name) like CONCAT('%',:beneficiaryName,'%')")
	List<PrivateDispensationProjection> searchByFacilityIdAndDispenseDate(@Param("facilityId") Long facilityId,
			@Param("date") LocalDate date, @Param("beneficiaryName") String beneficiaryName);

}
