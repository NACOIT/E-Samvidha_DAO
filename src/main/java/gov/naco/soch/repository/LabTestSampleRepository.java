package gov.naco.soch.repository;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.LabTestSample;
import gov.naco.soch.projection.ArtSampleCollectionProjection;
import gov.naco.soch.projection.IctcTestResultProjection;

@Repository
public interface LabTestSampleRepository
		extends JpaRepository<LabTestSample, Long>, PagingAndSortingRepository<LabTestSample, Long>, CustomRepository {

	List<LabTestSample> findByIsDelete(Boolean isDelete);
	
	@Query(nativeQuery = true, value = "select lts.id as sampleId,lts.sample_dispatch_date as resultDispatchDate , f.id as facilityId,lts.sample_collected_date as sampleCollectedDate,lts.test_type_id as testTypeId, " + 
			"lts.test_id as testId,lts.artc_sample_status as artcSampleStatus,lts.lab_technician_id as labTechnicianId, " + 
			"b.id as beneficiaryId,b.uid as uid,b.age as age,b.first_name as firstName,b.last_name as lastName,b.middle_name as middleName, " + 
			"mg.name as genderId,b.art_number as artNumber,b.pre_art_number as preArtNumber, t.type_of_test as test, mt.test_type as testType, b.date_of_birth as dateOfBirth from " + 
			"soch.lab_test_sample lts join soch.beneficiary b on b.id = lts.beneficiary_id join soch.master_gender mg on mg.id = b.gender_id  " + 
			"join soch.facility f on f.id = lts.sample_collected_facility_id " + 
			"join soch.test as t on (t.id = lts.test_id) left outer join soch.master_test_type mt on (mt.id = lts.test_type_id) " + 
			"where lts.test_id=1 and lts.sample_collected_facility_id=:facilityId and lts.artc_sample_status in ('Dispatched','Result Recorded') ")
	Page<ArtSampleCollectionProjection> findAllCD4(@Param("facilityId") Long facilityId, Pageable pageable);
	
	@Query(value = "SELECT s.* FROM soch.lab_test_sample as s "
			+ "where s.test_batch_id = :batchId", nativeQuery = true)
	List<LabTestSample> findSamplesByBatchId(@Param("batchId") Long batchId);

//	@Query(value = "SELECT s.* FROM soch.lab_test_sample as s join soch.lab_test_sample_batch as b " + 
//			"on s.test_batch_id = b.id where b.lab_id = :labId and s.sample_status_id = 1 " + 
//			"and b.batch_status_id > 1 and s.result_status_id = 1 " + 
//			"and s.is_delete = false order by s.id desc", nativeQuery =true)
//	Page<LabTestSample> findSamplesToRecordResult(@Param("labId") Long labId, Pageable paging);
	
	@Query(value = "SELECT d FROM LabTestSample d JOIN FETCH d.labTestSampleBatch b "
			+ "JOIN FETCH b.facility f JOIN FETCH b.lab l "
			+ "JOIN FETCH f.address a JOIN FETCH d.beneficiary ben "
			+ "JOIN FETCH ben.genderId g "
			+ "JOIN FETCH d.masterResultStatus rs JOIN FETCH d.masterSampleStatus ss "
			+ "LEFT JOIN FETCH d.labTecnician lt "
			+ "LEFT JOIN FETCH d.labInCharge li "
			+ "LEFT JOIN FETCH b.artcLabTechUser alt "
			+ "LEFT JOIN FETCH b.vlLabTechUser vlt "
			+ "LEFT JOIN FETCH ben.artBeneficiary artben "
			+ "LEFT JOIN FETCH artben.masterArtBeneficiaryStatus artStatus "
			+ "LEFT JOIN FETCH d.testType tt "
			+ "WHERE b.lab.id = :labId AND d.masterSampleStatus.id = 1 AND b.masterBatchStatus.id > 1 "
			+ "AND d.masterResultStatus.id = 1 AND d.isDelete = false "
			+ "ORDER BY d.id DESC", countQuery="SELECT count(d) FROM LabTestSample d "
			+ "JOIN d.labTestSampleBatch b "
			+ "WHERE b.lab.id = :labId AND d.masterSampleStatus.id = 1 AND b.masterBatchStatus.id > 1 " 
			+ "AND d.masterResultStatus.id = 1 AND d.isDelete = false")
	Page<LabTestSample> findSamplesToRecordResult(@Param("labId") Long labId, Pageable paging);
	
//	@Query(value = "SELECT s.* FROM soch.lab_test_sample as s join soch.lab_test_sample_batch as b " + 
//			"on s.test_batch_id = b.id where b.lab_id = :labId and s.sample_status_id IN (1,4) " + 
//			"and b.batch_status_id > 1 and s.result_status_id > 1 " + 
//			"and s.is_delete = false order by s.id desc", nativeQuery =true)
//	Page<LabTestSample> findSamplesTestResults(@Param("labId") Long labId, Pageable paging);
	// Extra join in below query commented by Asjad
	
	@Query(value = "SELECT d FROM LabTestSample d JOIN FETCH d.labTestSampleBatch b "
			+ "JOIN FETCH b.facility f JOIN FETCH b.lab l "
		//	+ "JOIN FETCH f.address a "
			+ "JOIN FETCH d.beneficiary ben "
		//	+ "JOIN FETCH ben.genderId g "
			+ "JOIN FETCH d.masterResultStatus rs"
			+ " JOIN FETCH d.masterSampleStatus ss "
			// + "LEFT JOIN FETCH d.labTecnician lt "
		//	+ "LEFT JOIN FETCH d.labInCharge li "
		//	+ "LEFT JOIN FETCH b.artcLabTechUser alt "
		//	+ "LEFT JOIN FETCH b.vlLabTechUser vlt "
			+ "LEFT JOIN FETCH ben.artBeneficiary artben "
		//	+ "LEFT JOIN FETCH artben.masterArtBeneficiaryStatus artStatus "
			+ "LEFT JOIN FETCH d.testType tt "
		//	+ "LEFT JOIN FETCH d.masterResultStatus res "
			+ "LEFT JOIN FETCH d.resultType resType "
			+ "WHERE b.lab.id = :labId AND d.masterSampleStatus.id IN (1,4) AND b.masterBatchStatus.id > 1 "
			+ "AND d.masterResultStatus.id > 1 AND d.isDelete = false ", countQuery="SELECT count(d) FROM LabTestSample d "
			+ "JOIN d.labTestSampleBatch b "
			+ "WHERE b.lab.id = :labId AND d.masterSampleStatus.id IN (1,4) AND b.masterBatchStatus.id > 1 " 
			+ "AND d.masterResultStatus.id > 1 AND d.isDelete = false")
	Page<LabTestSample> findSamplesTestResults(@Param("labId") Long labId, Pageable paging);
	
//	@Query(value = "SELECT s.* FROM soch.lab_test_sample as s join soch.lab_test_sample_batch as b " + 
//			"on s.test_batch_id = b.id where b.lab_id = :labId and s.sample_status_id = 1 " + 
//			"and b.batch_status_id > 1 and s.result_status_id = 2 " + 
//			"and s.is_delete = false order by s.id desc", nativeQuery =true)
//	Page<LabTestSample> findSamplesForApproval(@Param("labId") Long labId, Pageable paging);
	
	@Query(value = "SELECT d FROM LabTestSample d JOIN FETCH d.labTestSampleBatch b "
			+ "JOIN FETCH b.facility f JOIN FETCH b.lab l "
			+ "JOIN FETCH f.address a JOIN FETCH d.beneficiary ben "
			+ "JOIN FETCH ben.genderId g "
			+ "JOIN FETCH d.masterResultStatus rs JOIN FETCH d.masterSampleStatus ss "
			+ "LEFT JOIN FETCH d.labTecnician lt "
			+ "LEFT JOIN FETCH d.labInCharge li "
			+ "LEFT JOIN FETCH b.artcLabTechUser alt "
			+ "LEFT JOIN FETCH b.vlLabTechUser vlt "
			+ "LEFT JOIN FETCH ben.artBeneficiary artben "
			+ "LEFT JOIN FETCH artben.masterArtBeneficiaryStatus artStatus "
			+ "LEFT JOIN FETCH d.testType tt "
			+ "LEFT JOIN FETCH d.masterResultStatus res "
			+ "LEFT JOIN FETCH d.resultType resType "
			+ "WHERE b.lab.id = :labId AND d.masterSampleStatus.id = 1 AND b.masterBatchStatus.id > 1 "
			+ "AND d.masterResultStatus.id = 2 AND d.isDelete = false "
			+ "ORDER BY d.id DESC", countQuery="SELECT count(d) FROM LabTestSample d "
			+ "JOIN d.labTestSampleBatch b "
			+ "WHERE b.lab.id = :labId AND d.masterSampleStatus.id = 1 AND b.masterBatchStatus.id > 1 " 
			+ "AND d.masterResultStatus.id = 2 AND d.isDelete = false")
	Page<LabTestSample> findSamplesForApproval(@Param("labId") Long labId, Pageable paging);
	
	@Query(value = "SELECT count(*) FROM soch.lab_test_sample as s where s.test_id = 2 " + 
			"and s.sample_status_id = 4 and s.result_status_id = 3 " + 
			"and s.is_delete = false and s.beneficiary_id = :beneficiaryId", nativeQuery = true)
	Long getVLTestCountOfBeneficiary(@Param("beneficiaryId") Long beneficiaryId);
	

	@Query(nativeQuery = true, value = "select * from soch.lab_test_sample as s"
			+ " join soch.lab_test_sample_batch b "
			+ "on s.test_batch_id = b.id "
			+ "where s.test_id = 4 and b.batch_status_id > 1 and s.sample_status_id IN (1,4) "
			+ "and s.beneficiary_id = :beneficiaryId and b.lab_id = :labId "
			+ "and s.is_delete = false")
	List<LabTestSample> findDBSSamplesByBeneficiaryIdAndLabId(@Param("beneficiaryId") Long beneficiaryId,
			@Param("labId") Long labId);

	Boolean existsByBarcodeNumber(String barcode);

	// @Query(value = "select a from LabTestSample a where a.sampleCollectedDate=?1
	// ")
	// List<LabTestSample> findTodaysSamples(LocalDateTime localDate);

	@Query(nativeQuery = true, value = "select * from soch.lab_test_sample a where DATE(a.sample_collected_date) =CURRENT_DATE")
	List<LabTestSample> findTodaysSamples();

	@Query(nativeQuery = true, value = "select lts.id as sampleId,lts.sample_collected_date as sampleCollectedDate,lts.test_type_id as testTypeId, " + 
			"lts.test_id as testId,lts.artc_sample_status as artcSampleStatus,lts.lab_technician_id as labTechnicianId, " + 
			"b.id as beneficiaryId,b.uid as uid,b.age as age,b.first_name as firstName,b.last_name as lastName,b.middle_name as middleName, " + 
			"mg.name as genderId,b.art_number as artNumber,b.pre_art_number as preArtNumber, t.type_of_test as test, mt.test_type as testType, lts.is_undone as isUndone, b.date_of_birth as dateOfBirth  from  " + 
			"soch.lab_test_sample lts join soch.beneficiary b on b.id = lts.beneficiary_id join soch.master_gender mg on mg.id = b.gender_id " + 
			"join soch.test as t on (t.id = lts.test_id) left outer join soch.master_test_type mt on (mt.id = lts.test_type_id) where lts.is_delete = false " + 
			"and lts.sample_collected_facility_id =:facilityId and lts.artc_sample_status ='Sample Collected' and lts.test_id = 1 order by lts.sample_collected_date desc ")
	Page<ArtSampleCollectionProjection> findAllCD4List(@Param("facilityId") Long facilityId,Pageable page);

	@Query(nativeQuery = true, value = "select lts.id as sampleId,lts.sample_collected_date as sampleCollectedDate,lts.test_type_id as testTypeId, " + 
			"lts.test_id as testId,lts.artc_sample_status as artcSampleStatus,lts.lab_technician_id as labTechnicianId, " + 
			"b.id as beneficiaryId,b.uid as uid,b.age as age,b.first_name as firstName,b.last_name as lastName,b.middle_name as middleName, " + 
			"mg.name as genderId,b.art_number as artNumber,b.pre_art_number as preArtNumber, t.type_of_test as test, mt.test_type as testType,  lts.is_undone as isUndone, b.date_of_birth as dateOfBirth from  " + 
			"soch.lab_test_sample lts join soch.beneficiary b on b.id = lts.beneficiary_id join soch.master_gender mg on mg.id = b.gender_id " + 
			"join soch.test as t on (t.id = lts.test_id) left outer join soch.master_test_type mt on (mt.id = lts.test_type_id) where lts.is_delete = false " + 
			"and lts.sample_collected_facility_id =:facilityId and lts.artc_sample_status ='Sample Collected' and lts.test_id = 2 order by lts.sample_collected_date desc ")
	Page<ArtSampleCollectionProjection> findAllViralList(@Param("facilityId") Long facilityId ,Pageable pageable );


	@Query(nativeQuery = true, value = "select lts.id as sampleId,lts.sample_collected_date as sampleCollectedDate,lts.sample_dispatch_date as sampleDispatchDate,lts.test_type_id as testTypeId, " 
			+ "lts.test_id as testId,lts.artc_sample_status as artcSampleStatus,lts.lab_technician_id as labTechnicianId, " 
			+ "b.id as beneficiaryId,b.uid as uid,b.age as age,b.first_name as firstName,b.last_name as lastName,b.middle_name as middleName, " 
			+ "mg.name as genderId,b.art_number as artNumber,b.pre_art_number as preArtNumber, t.type_of_test as test, mt.test_type as testType, b.date_of_birth as dateOfBirth from " 
			+ "soch.lab_test_sample lts join soch.beneficiary b on b.id = lts.beneficiary_id join soch.master_gender mg on mg.id = b.gender_id "
			+ "join soch.test as t on (t.id = lts.test_id) left outer join soch.master_test_type mt on (mt.id = lts.test_type_id) where lts.artc_sample_status= 'Dispatched' and lts.test_id= 1 and lts.is_delete = false " 
			+ "and (lts.sample_collected_facility_id =:facilityId or lts.dispatched_to_lab_id =:facilityId) " )
	Page<ArtSampleCollectionProjection> findAllCD4Dispatchedlist(@Param("facilityId") Long facilityId,Pageable pageable );

	@Query(nativeQuery = true, value = "select * from soch.lab_test_sample where artc_sample_status='Dispatched' and test_id=2 "
			+ "and is_delete=false and sample_collected_facility_id=:facilityId")
	List<LabTestSample> findAllViralDispatchedList(@Param("facilityId") Long facilityId);

	List<LabTestSample> findAllByArtcSampleStatus(String string);

	@Query(nativeQuery = true, value = "select max(id) from soch.lab_test_sample")
	Long findMaxOfId();

	/*
	 * @Query(nativeQuery = true, value =
	 * "select * from soch.lab_test_sample where result_status_id=4 and test_id=1 "
	 * + "and is_delete=false and sample_collected_facility_id=:facilityId")
	 */
	@Query(nativeQuery = true,value = "select lts.id as sampleId,lts.sample_collected_date as sampleCollectedDate,lts.type_of_specimen as typeOfSpecimen, " 
			+ "lts.result_value as resultValue,lts.result_dispatch_date as resultDispatchDate,b.id as beneficiaryId,b.uid as uid,b.age as age, "
			+ "b.first_name as firstName,b.last_name as lastName,b.middle_name as middleName, mab.name as beneficiaryStatus, f.name as facilityName, "
			+ "f.id as facilityId,b.art_number as artNumber,b.pre_art_number as preArtNumber, mg.name as genderId, lts.result_received_date as resultReceivedDate from " 
			+ "soch.lab_test_sample lts join soch.beneficiary b on b.id = lts.beneficiary_id join soch.master_gender mg on mg.id = b.gender_id join soch.art_beneficiary art on art.beneficiary_id = b.id " 
			+ "join soch.master_art_beneficiary_status mab on mab.id = art.art_beneficiary_status_id "
			+ "join soch.facility f on f.id = lts.sample_collected_facility_id where lts.is_delete = false and (lts.sample_collected_facility_id =:facilityId or lts.dispatched_to_lab_id =:facilityId) "
			+ "and lts.result_status_id= 4 and lts.test_id= 1 order by lts.sample_dispatch_date desc")
	Page<ArtSampleCollectionProjection> findAllCD4TestResults(@Param("facilityId") Long facilityId, Pageable pageable);
	
	@Query(nativeQuery = true, value = "select * from soch.lab_test_sample where result_status_id=4 and test_id=1 "
			+ "and is_delete=false and sample_collected_facility_id=:facilityId and beneficiary_id = :beneficiaryId "
			+ "and id < :id order by id desc limit 1")
	Optional<LabTestSample> findPreviousCD4TestResults(@Param("id") Long id, @Param("beneficiaryId") Long beneficiaryId,
			@Param("facilityId") Long facilityId);

	Page<LabTestSample> findAllByIsDeleteAndSampleCollectedFacilityId(Boolean false1, Long facilityId, Pageable pageable);

	@Query(nativeQuery = true, value = "select s.* from soch.lab_test_sample as s where s.result_status_id=4 and s.test_id=1 "
			+ "and s.is_delete=false and s.sample_collected_facility_id=:facilityId and s.beneficiary_id = :beneficiaryId "
			+ "and s.type_of_specimen = 'Good'")
	List<LabTestSample> findAllCD4TestResultsOfBeneficiary(@Param("facilityId") Long facilityId,
			@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select s.* from soch.lab_test_sample as s where s.result_status_id=3 and s.test_id=2 "
			+ "and s.is_delete=false and s.sample_collected_facility_id=:facilityId and s.beneficiary_id = :beneficiaryId")
	List<LabTestSample> findAllVLTestResultsOfBeneficiary(@Param("facilityId") Long facilityId,
			@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select s.* from soch.lab_test_sample as s where s.test_id=4 "
			+ "and s.is_delete=false and s.beneficiary_id = :beneficiaryId and s.dispatched_to_lab_id= :facilityId "
			+ "and s.id < :sampleId")
	List<LabTestSample> findPreviousDBSDetails(@Param("beneficiaryId") Long beneficiaryId,
			@Param("facilityId") Long facilityId, @Param("sampleId") Long sampleId);

	@Query(nativeQuery = true, value = "select s.barcode_number from soch.lab_test_sample as s "
			+ "where s.barcode_number is not null")
	List<String> findAllBarcodes();

	Optional<LabTestSample> findByBarcodeNumber(@Valid String barcode);

	@Query(nativeQuery = true, value = "SELECT count(lts.beneficiary_id) as PATIENT_LOAD\r\n"
			+ "FROM soch.lab_test_sample lts where lts.next_appointment_date=:date and \r\n"
			+ "lts.sample_collected_facility_id=:facilityId and lts.dispatched_to_lab_id "
			+ "in(select id from soch.facility where name like '%MHL' and code='MHL'\r\n" 
			+ "and facility_type_id=26 order by id ASC limit 1)\r\n"
			+ "GROUP BY lts.next_appointment_date")
	Integer findBeneficiaryLoadByDate(@Param("facilityId")Long facilityId,@Param("date")LocalDate date);
	
	@Query(nativeQuery = true, value = "select lts.id as sampleId,lts.sample_collected_date as sampleCollectedDate,lts.test_type_id as testTypeId, " 
	+ "lts.test_id as testId,lts.artc_sample_status as artcSampleStatus,lts.lab_technician_id as labTechnicianId, " 
	+ "b.id as beneficiaryId,b.uid as uid,b.age as age,b.first_name as firstName,b.last_name as lastName,b.middle_name as middleName, " 
	+ "mg.name as genderId,b.art_number as artNumber,b.pre_art_number as preArtNumber, t.type_of_test as test, mt.test_type as testType, b.date_of_birth as dateOfBirth  from " 
	+ "soch.lab_test_sample lts join soch.beneficiary b on b.id = lts.beneficiary_id join soch.master_gender mg on mg.id = b.gender_id "
	+ "join soch.test as t on (t.id = lts.test_id) left outer join soch.master_test_type mt on (mt.id = lts.test_type_id) where lts.is_delete = false " 
	+ "and lts.sample_collected_facility_id =:facilityId and (lower(b.age) like %:searchText%  or lower(b.uid) like %:searchText% or lower(b.art_number) like %:searchText% "
	+ "or lower(b.pre_art_number) like %:searchText% or lower(b.first_name) like %:searchText% or lower(b.last_name) like %:searchText% or "
	+ "lower(b.middle_name) like %:searchText% or concat(lower(b.first_name), ' ',lower(b.middle_name), ' ',lower(b.last_name)) like %:searchText% or "
	+ "concat(lower(b.first_name), ' ',lower(b.middle_name)) like %:searchText% or concat(lower(b.first_name), ' ',lower(b.last_name)) like %:searchText% )" )
	Page<ArtSampleCollectionProjection> searchInSampleList(@Param("facilityId")Long facilityId,@Param("searchText") String searchValue, Pageable pageable);
	
	@Query(nativeQuery = true,value = "select lts.id as sampleId,lts.sample_collected_date as sampleCollectedDate,lts.type_of_specimen as typeOfSpecimen, " 
	+ "lts.result_value as resultValue,lts.result_dispatch_date as resultDispatchDate,b.id as beneficiaryId,b.uid as uid,b.age as age, "
	+ "b.first_name as firstName,b.last_name as lastName,b.middle_name as middleName, mab.name as beneficiaryStatus, f.name as facilityName, "
	+ "f.id as facilityId,b.art_number as artNumber,b.pre_art_number as preArtNumber, mg.name as genderId, lts.result_received_date as resultReceivedDate from " 
	+ "soch.lab_test_sample lts join soch.beneficiary b on b.id = lts.beneficiary_id join soch.master_gender mg on mg.id = b.gender_id join soch.art_beneficiary art on art.beneficiary_id = b.id " 
	+ "join soch.master_art_beneficiary_status mab on mab.id = art.art_beneficiary_status_id join soch.facility f on f.id = lts.sample_collected_facility_id where lts.is_delete = false and (lts.sample_collected_facility_id =:facilityId or lts.dispatched_to_lab_id =:facilityId) "
	+ "and lts.result_status_id= 4 and lts.test_id= 1 and (lower(b.age) like :searchText%  or lower(b.uid) like :searchText% or lower(b.art_number) like :searchText% or lower(b.pre_art_number) "
	+ "like :searchText% or lower(b.first_name) like :searchText% or lower(b.last_name) like :searchText% or lower(b.middle_name) like :searchText% or "
	+ "concat(lower(b.first_name), ' ',lower(b.middle_name), ' ',lower(b.last_name)) like :searchText% or concat(lower(b.first_name), ' ',lower(b.middle_name)) "
	+ "like :searchText% or concat(lower(b.first_name), ' ',lower(b.last_name)) like :searchText% ) order by lts.sample_dispatch_date desc")
	Page<ArtSampleCollectionProjection> searchInCD4TestResults(@Param("facilityId")Long facilityId,@Param("searchText") String searchText, Pageable pageable);
	
	
	@Query(nativeQuery = true, value = "select lts.id as sampleId,lts.sample_collected_date as sampleCollectedDate,lts.sample_dispatch_date as sampleDispatchDate,lts.test_type_id as testTypeId, " 
	+ "lts.test_id as testId,lts.artc_sample_status as artcSampleStatus,lts.lab_technician_id as labTechnicianId, " 
	+ "b.id as beneficiaryId,b.uid as uid,b.age as age,b.first_name as firstName,b.last_name as lastName,b.middle_name as middleName, " 
	+ "mg.name as genderId,b.art_number as artNumber,b.pre_art_number as preArtNumber, t.type_of_test as test, mt.test_type as testType, b.date_of_birth as dateOfBirth from " 
	+ "soch.lab_test_sample lts join soch.beneficiary b on b.id = lts.beneficiary_id join soch.master_gender mg on mg.id = b.gender_id "
	+ "join soch.test as t on (t.id = lts.test_id) left outer join soch.master_test_type mt on (mt.id = lts.test_type_id) where lts.artc_sample_status= 'Dispatched' and lts.test_id= 1 and lts.is_delete = false " 
	+ "and (lts.sample_collected_facility_id =:facilityId or lts.dispatched_to_lab_id =:facilityId) and (lower(b.age) like %:searchText%  or lower(b.uid) like %:searchText% or lower(b.art_number) like %:searchText% "
	+ "or lower(b.pre_art_number) like %:searchText% or lower(b.first_name) like %:searchText% or lower(b.last_name) like %:searchText% or "
	+ "lower(b.middle_name) like %:searchText% or concat(lower(b.first_name), ' ',lower(b.middle_name), ' ',lower(b.last_name)) like %:searchText% or "
	+ "concat(lower(b.first_name), ' ',lower(b.middle_name)) like %:searchText% or concat(lower(b.first_name), ' ',lower(b.last_name)) like %:searchText% )" )
	Page<ArtSampleCollectionProjection> findAllCD4DispatchedlistByProjection(@Param("facilityId")Long facilityId,@Param("searchText") String searchText,Pageable pageable);

	@Query(nativeQuery= true , value = "select distinct(beneficiary_id)from soch.lab_test_sample where id in( " + 
			" select id from (select beneficiary_id,max(id) as id from soch.lab_test_sample " + 
			" where test_id=1 and Lower(type_of_specimen)='good'  group by beneficiary_id) as result) " + 
			" and cast(result_value as integer) < :criteriaValue ")
	Set<Long> findCd4BelowBeneficiaryList(@Param("criteriaValue") Integer criteriaValue);

	@Query(nativeQuery=true , value = "select distinct(beneficiary_id) from soch.lab_test_sample where id in( " + 
			" select id from (select beneficiary_id,max(id) as id from soch.lab_test_sample  group by beneficiary_id) as result) " + 
			" and test_id=2 and result_type_id=4 and result_status_id=3 and cast(result_value as integer) > :criteriaValue ")
	Set<Long> findVlAboveBeneficiaryList(@Param("criteriaValue") Integer criteriaValue);
	
	@Query(value = "SELECT s.* FROM soch.lab_test_sample as s join soch.lab_test_sample_batch as b " + 
			"on s.test_batch_id = b.id join soch.beneficiary as be on be.id =s.beneficiary_id " + 
			"join soch.facility as f on f.id = s.sample_collected_facility_id where b.lab_id =:labId and s.sample_status_id IN (1,4) " + 
			"and b.batch_status_id > 1 and s.result_status_id > 1 and s.is_delete = false and (lower(b.bdn_serial_number) like lower(:searchValue) or " + 
			"lower(be.first_name) like lower(:searchValue) or lower(be.middle_name) like lower(:searchValue) or " + 
			"lower(be.last_name) like lower(:searchValue) or lower(f.name) like lower(:searchValue)) order by s.id desc", nativeQuery =true)
	Page<LabTestSample> fetchTestResultsListByNormalSearch(@Param("labId")Long labId,@Param("searchValue") String searchValue, Pageable paging);

	@Query(nativeQuery= true , value = "select beneficiary_id from soch.lab_test_sample where id in( " + 
			" select id from (select beneficiary_id,max(id) as id from soch.lab_test_sample " + 
			" where test_id=1 and Lower(type_of_specimen)='good'  group by beneficiary_id) as result) " + 
			" and cast(result_value as integer) > :criteriaValue ")
	Set<Long> findCd4AboveBeneficiaryList(@Param("criteriaValue") Integer criteriaValue);
	
	@Query(nativeQuery=true , value = "select beneficiary_id from soch.lab_test_sample where id in( " + 
			" select id from (select beneficiary_id,max(id) as id from soch.lab_test_sample  group by beneficiary_id) as result) " + 
			" and test_id=2 and result_type_id=4 and result_status_id=3 and cast(result_value as integer) < :criteriaValue ")
	Set<Long> findVlBelowBeneficiaryList(@Param("criteriaValue")  Integer criteriaValue);

	@Query(value = "select t.hiv_type as hivType, t.hiv_status as hivStatus from soch.lab_test_sample as t "
			+ "where t.ictc_beneficiary_id=:ictcBeneficiaryId "
			+ "and t.test_id = 4 and t.test_type_id IN (5,6,7,8,9,10)", nativeQuery = true)
	List<IctcTestResultProjection> findAllCDBSTestByIctcBenficiaryId(@Param("ictcBeneficiaryId") Long ictcBeneficiaryId);
	

	@Query(nativeQuery= true , value = "select cast(result_value as integer) as result_value,beneficiary_id  from soch.lab_test_sample where id in( " + 
			"select id from (select beneficiary_id,id from soch.lab_test_sample " + 
			"where test_id=1 and Lower(type_of_specimen)='good'  ) as result  ) order by id desc limit  3")
	Set<Long> findCd4IncreasingBeneficiaryList();
	
	
	@Query(value = "SELECT d FROM LabTestSample d JOIN FETCH d.labTestSampleBatch b "
			+ "JOIN FETCH b.facility f JOIN FETCH b.lab l "
			+ "JOIN FETCH f.address a JOIN FETCH d.beneficiary ben "
			+ "JOIN FETCH ben.genderId g "
			+ "JOIN FETCH d.masterResultStatus rs JOIN FETCH d.masterSampleStatus ss "
			+ "LEFT JOIN FETCH d.labTecnician lt "
			+ "LEFT JOIN FETCH d.labInCharge li "
			+ "LEFT JOIN FETCH b.artcLabTechUser alt "
			+ "LEFT JOIN FETCH b.vlLabTechUser vlt "
			+ "LEFT JOIN FETCH ben.artBeneficiary artben "
			+ "LEFT JOIN FETCH artben.masterArtBeneficiaryStatus artStatus "
			+ "LEFT JOIN FETCH d.testType tt "
			+ "WHERE b.lab.id = :labId AND d.masterSampleStatus.id = 1 AND b.masterBatchStatus.id > 1 "
			+ "AND d.masterResultStatus.id = 1 AND d.isDelete = false "
			+ "ORDER BY d.id DESC")
	List<LabTestSample> findAllSamplesToRecordResult(@Param("labId") Long labId);

	/**
	 * @return
	 */
	@Query(nativeQuery= true , value = "select count(*) from soch.lab_test_sample lts where lts.hiv_status =:hivStatus and lts.hiv_type =:hivType and " + 
	"(lts.result_approved_date >= :startDate and lts.result_approved_date <= :endDate )")
	BigInteger numberOfHIV1PositiveCasesInThePreviousQuarter(@Param("hivStatus")Long hivStatus,@Param("hivType")Long hivType,
			@Param("startDate")LocalDate startDate,@Param("endDate")LocalDate endDate);
	
	/**
	 * @return
	 */
	@Query(nativeQuery= true , value = "select count(*) from soch.lab_test_sample lts where lts.hiv_status =:hivStatus and lts.hiv_type =:hivType and " + 
	"(lts.result_approved_date >= :startDate and lts.result_approved_date <= :endDate )")
	BigInteger numberOfHIV2PositiveCasesInThePreviousQuarter(@Param("hivStatus")Long hivStatus,@Param("hivType")Long hivType,
			@Param("startDate")LocalDate startDate,@Param("endDate")LocalDate endDate);

	/**
	 * @param hivType
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@Query(nativeQuery= true , value = "select count(*) from soch.lab_test_sample lts where lts.hiv_type =:hivType and " + 
			"(lts.result_approved_date >= :startDate and lts.result_approved_date <= :endDate )")
	BigInteger numberOfSamplesScreenedHIV12InThePreviousQuarter(@Param("hivType")Long hivType,
			@Param("startDate")LocalDate startDate,@Param("endDate")LocalDate endDate);

	/**
	 * @param masterHivStatus
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@Query(nativeQuery= true , value = "select count(*) from soch.lab_test_sample lts where lts.hiv_status =:hivStatus and " + 
			"(lts.result_approved_date >= :startDate and lts.result_approved_date <= :endDate )")
	BigInteger numberOfSamplesScreenedAsIndeterminateInPreviousQuarter(@Param("hivStatus")Long hivStatus, @Param("startDate")LocalDate startDate,
			@Param("endDate")LocalDate endDate);

	/**
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@Query(nativeQuery= true , value = "select count(*) from soch.lab_test_sample lts where lts.hiv_status IN (1,2,3) and " + 
			"(lts.result_approved_date >= :startDate and lts.result_approved_date <= :endDate )")
	BigInteger numberOfHivTestsDoneInPreviousQuarter(@Param("startDate")LocalDate startDate,@Param("endDate")LocalDate endDate);
	
//	@Query("select lts from LabTestSample lts where lts.isDelete = false and lts.ictcBeneficiary.id=:ictcBeneficiaryId")
//	List<LabTestSample> findActiveLabTestSamplesByIctcBeneficiaryId(@Param("ictcBeneficiaryId") Long ictcBeneficiaryId);
	
	//Below both functions(findTestResultsVLList, findTestResultsVLListWithSearchValue) are calling from ART module
	
	@Query(value = "SELECT d FROM LabTestSample d JOIN FETCH d.labTestSampleBatch b "
			+ "JOIN FETCH b.facility f JOIN FETCH b.lab l "
			+ "JOIN FETCH f.address a JOIN FETCH d.beneficiary ben "
			+ "JOIN FETCH ben.genderId g "
			+ "JOIN FETCH d.masterResultStatus rs JOIN FETCH d.masterSampleStatus ss "
			+ "LEFT JOIN FETCH d.labTecnician lt "
			+ "LEFT JOIN FETCH d.labInCharge li "
			+ "LEFT JOIN FETCH b.artcLabTechUser alt "
			+ "LEFT JOIN FETCH b.vlLabTechUser vlt "
			+ "LEFT JOIN FETCH ben.artBeneficiary artben "
			+ "LEFT JOIN FETCH artben.masterArtBeneficiaryStatus artStatus "
			+ "LEFT JOIN FETCH d.testType tt "
			+ "LEFT JOIN FETCH d.masterResultStatus res "
			+ "LEFT JOIN FETCH d.resultType resType "
			+ "LEFT JOIN FETCH d.test t "
			+ "WHERE f.id = :labId AND d.masterSampleStatus.id IN (1,4) AND b.masterBatchStatus.id > 1 "
			+ "AND d.masterResultStatus.id > 1 AND d.isDelete = false AND t.id = 2"
			+ "ORDER BY d.id DESC", countQuery="SELECT count(d) FROM LabTestSample d "
			+ "JOIN d.labTestSampleBatch b "
			+ "WHERE b.facility.id = :labId AND d.masterSampleStatus.id IN (1,4) AND b.masterBatchStatus.id > 1 " 
			+ "AND d.masterResultStatus.id > 1 AND d.isDelete = false AND d.test = 2")
	Page<LabTestSample> findTestResultsVLList(@Param("labId")Long labId, Pageable pageable);
	
	@Query(value = "SELECT d FROM LabTestSample d JOIN FETCH d.labTestSampleBatch b "
			+ "JOIN FETCH b.facility f JOIN FETCH b.lab l "
			+ "JOIN FETCH f.address a JOIN FETCH d.beneficiary ben "
			+ "JOIN FETCH ben.genderId g "
			+ "JOIN FETCH d.masterResultStatus rs JOIN FETCH d.masterSampleStatus ss "
			+ "LEFT JOIN FETCH d.labTecnician lt "
			+ "LEFT JOIN FETCH d.labInCharge li "
			+ "LEFT JOIN FETCH b.artcLabTechUser alt "
			+ "LEFT JOIN FETCH b.vlLabTechUser vlt "
			+ "LEFT JOIN FETCH ben.artBeneficiary artben "
			+ "LEFT JOIN FETCH artben.masterArtBeneficiaryStatus artStatus "
			+ "LEFT JOIN FETCH d.testType tt "
			+ "LEFT JOIN FETCH d.masterResultStatus res "
			+ "LEFT JOIN FETCH d.resultType resType "
			+ "LEFT JOIN FETCH d.test t "
			+ "WHERE f.id = :labId AND d.masterSampleStatus.id IN (1,4) AND b.masterBatchStatus.id > 1 "
			+ "AND d.masterResultStatus.id > 1 AND d.isDelete = false AND t.id = 2 AND ((lower(b.bdnSerialNumber) like %:searchValue%)or (lower(ben.artBenfSearchStr) like %:searchValue%))"
			+ "ORDER BY d.id DESC", countQuery= "SELECT count(d) FROM LabTestSample d "
			+ "JOIN d.labTestSampleBatch b JOIN d.beneficiary ben "
			+ "WHERE b.facility.id = :labId AND d.masterSampleStatus.id IN (1,4) AND b.masterBatchStatus.id > 1 " 
			+ "AND d.masterResultStatus.id > 1 AND d.isDelete = false AND d.test = 2 "
			+ "AND ((lower(b.bdnSerialNumber) like %:searchValue%)or (lower(ben.artBenfSearchStr) like %:searchValue%))")
	Page<LabTestSample> findTestResultsVLListWithSearchValue(@Param("labId")Long labId,@Param("searchValue")String searchValue ,Pageable pageable);
	
	
	//cd4 mobile query
	
		@Query(nativeQuery = true, value = "select s.* from soch.lab_test_sample as s where s.result_status_id=4 and s.test_id=1 and s.is_delete=false and s.beneficiary_id = :beneficiaryId and s.type_of_specimen = 'Good'order by id desc limit 4")
		List<LabTestSample> findPreviousCD4MobileTestResults(@Param("beneficiaryId")Long beneficiaryId);
		
		//vl mobile query
		@Query(nativeQuery = true, value = "select s.* from soch.lab_test_sample as s where s.result_status_id=3 and s.test_id=2 and s.is_delete=false and s.beneficiary_id = :beneficiaryId order by id desc limit 4")
		List<LabTestSample> findPreviousVLMobileTestResults(@Param("beneficiaryId")Long beneficiaryId);
	/**
	 *  @param batchId
	 * @param pageable
	 * @return
	 */
	@Query(nativeQuery= true , value = "select * from soch.lab_test_sample lts where lts.test_batch_id =:batchId ")
	Page<LabTestSample> getAllViralLoadPreviouDispatchedSamplesByBatchId(@Param("batchId")Long batchId, Pageable pageable);
	
	@Query(nativeQuery= true , value = "select * from soch.lab_test_sample lts where lts.id=:sampleId")
	Optional<LabTestSample> findById(@Param("sampleId")Long sampleId);
	
	@Query(nativeQuery = true, value = "select * from soch.lab_test_sample as s"
			+ " join soch.lab_test_sample_batch b "
			+ "on s.test_batch_id = b.id "
			+ "where batch_status_id > 1 and s.sample_status_id IN (1,4) "
			+ "and s.beneficiary_id = :beneficiaryId and b.lab_id = :labId "
			+ "and s.is_delete = false")
	List<LabTestSample> findSamplesByBeneficiaryIdAndLabId(@Param("beneficiaryId") Long beneficiaryId,
			@Param("labId") Long labId);

	@Query(nativeQuery = true, value = "select s.* from soch.lab_test_sample as s where s.result_status_id=4 and s.test_id=1 "
			+ "and s.is_delete=false  and s.beneficiary_id = :beneficiaryId "
			+ "and s.type_of_specimen = 'Good' order by s.id desc limit 6")
	List<LabTestSample> findAllCD4TestResultsOfBeneficiary(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select s.* from soch.lab_test_sample as s where s.result_status_id=3 and s.test_id=2 "
			+ "and s.is_delete=false and s.beneficiary_id = :beneficiaryId  order by s.id desc limit 6")
	List<LabTestSample> findAllVLTestResultsOfBeneficiary(@Param("beneficiaryId")  Long beneficiaryId);
	
	// Change VL Test Result Approval Status
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update soch.lab_test_sample set result_approved_date =:resultApprovedDate,result_dispatch_date =:resultApprovedDate where is_delete = false and test_batch_id=:batchId and id=:sampleId")
	void updateApprovalStatus(@Param("batchId") Integer batchId, @Param("sampleId") Integer sampleId, @Param("resultApprovedDate") LocalDateTime resultApprovedDate);
	
}
