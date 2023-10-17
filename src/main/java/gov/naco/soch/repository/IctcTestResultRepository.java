package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.naco.soch.entity.IctcTestResult;
import gov.naco.soch.projection.IctcTestResultAndSamplesProjection;
import gov.naco.soch.projection.IctcTestResultProjection;

public interface IctcTestResultRepository extends JpaRepository<IctcTestResult, Long> {

	@Query(value = "select t.* from soch.ictc_test_result t where t.sample_id = :sampleId", nativeQuery = true)
	Optional<IctcTestResult> findBySampleId(@Param("sampleId") Long sampleId);
	
	@Query(value = "select t.* from soch.ictc_test_result t where t.sample_id IN :sampleIds", nativeQuery = true)
	List<IctcTestResult> findBySampleIds(@Param("sampleIds") List<Long> sampleIds);
	
	@Query("select itr.testedDate from IctcTestResult itr join IctcBeneficiary ib on ib.currentTestResultId=itr.id where ib.beneficiary.id=:beneficiaryId")
	LocalDate getHivTestedDate(@Param("beneficiaryId")Long beneficiaryId);
	
	@Query(value = "select t.hiv_type as hivType, t.hiv_status as hivStatus from soch.ictc_test_result as t "
			+ "join soch.ictc_sample_collection as s "
			+ "on t.sample_id = s.id where t.ictc_beneficiary_id=:ictcBeneficiaryId "
			+ "and s.test_type IN (5,6,7,8,9,10)", nativeQuery = true)
	List<IctcTestResultProjection> findAllCDBSTestByIctcBenficiaryId(@Param("ictcBeneficiaryId") Long ictcBeneficiaryId);

	@Query(value = "select s.sample_collection_date as sampleCollectedDate, "
			+ "s.facility_id as sampleCollectedFacility, f.name as facilityName, d.name as districtName, "
			+ "t.tested_date as testedDate from soch.ictc_test_result as t "
			+ "join soch.ictc_sample_collection as s on t.sample_id = s.id "
			+ "join soch.facility as f on s.facility_id = f.id "
			+ "left join soch.address as a on a.id = f.address_id "
			+ "left join soch.district as d on d.id = a.district_id "
			+ "where t.ictc_beneficiary_id=:ictcBeneficiaryId ", nativeQuery = true)
	List<IctcTestResultAndSamplesProjection> findByIctcBeneficiaryId(
			@Param("ictcBeneficiaryId") Long ictcBeneficiaryId);

}
