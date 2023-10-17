package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.constants.QueryConstant;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.projection.DailyDosageProjection;
import gov.naco.soch.projection.DailyDosageRegistrationProjection;

@Repository
public interface DailyDosageReportRepository extends JpaRepository<Facility, Long> {

	@Query(nativeQuery = true, value = QueryConstant.DAILY_DOSAGE_REGISTRAION_DTL_QUERY)
	DailyDosageRegistrationProjection getRegistrationCounts(Long facilityId);

	@Query(nativeQuery = true, value = QueryConstant.DAILY_DOSAGE_REPORT_FETCH_QUREY)
	List<DailyDosageProjection> getDailyDosageReportList(Long facilityId, String month, int year);

	Optional<Facility> findFacilityById(Long facilityId);
}
