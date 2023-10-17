package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.LabTestSampleBatch;
import gov.naco.soch.projection.ArtLabVLPreviousDispatchProjection;
import gov.naco.soch.projection.LabTestReceiveBatchProjection;

@Repository
public interface LabTestSampleBatchRepository extends JpaRepository<LabTestSampleBatch, Long>,
		PagingAndSortingRepository<LabTestSampleBatch, Long>, CustomRepository {

	List<LabTestSampleBatch> findAllByLabId(Long labId);

	List<LabTestSampleBatch> findByLabIdAndIsDelete(Long labId, Boolean isDelete);
	
	@Query(value = "select b.id as batchId, b.bdn_serial_number as bdnNumber, \r\n" + 
			"b.artc_id as facilityId, b.dispatch_date as batchDispatchDate, \r\n" + 
			"b.received_date as batchRecevievedDate, b.num_of_samples as totalSamples, \r\n" + 
			"b.accepted_samples as acceptedSamples, b.rejected_samples as rejectedSamples,\r\n" + 
			"b.batch_status_id as batchStatusId\r\n" + 
			"from soch.lab_test_sample_batch b\r\n" + 
			"where b.lab_id = :labId and b.is_delete = false " +
			"order by b.id desc", nativeQuery = true)
	Page<LabTestReceiveBatchProjection> findTestBatchesByLabId(@Param("labId") Long labId, Pageable paging);
	
	@Query(value = "select s.test_batch_id as batchId, s.sample_collected_date as sampleCollectedDate, \r\n" + 
			"s.sample_dispatch_date as sampleDispatchDate, s.sample_received_date as sampleReceivedDate, \r\n" + 
			"s.result_received_date as resultReceivedDate, s.result_approved_date as resultApprovedDate, \r\n" + 
			"s.result_dispatch_date as resultDispatchDate  \r\n" + 
			"from soch.lab_test_sample s where s.test_batch_id IN :batchIds", nativeQuery = true)
	List<LabTestReceiveBatchProjection> findTestSamplesInBatches(@Param("batchIds") List<Long> batchIds);
	

	// @Query(nativeQuery = true, value = "select * from soch.lab_test_sample_batch
	// ads join soch.lab_test_sample ars on"
	// + " ars.test_batch_id=ads.id where ars.test_id=2 order by
	// sample_dispatch_date")
	// List<LabTestSampleBatch> findAllViralLoad();
	@Query(nativeQuery = true, value = "select ltsb.* from soch.lab_test_sample_batch ltsb "
			+ "join soch.lab_test_sample lts on lts.test_batch_id=ltsb.id "
			+ "where lts.test_id=2 and lts.sample_collected_facility_id=:facilityId and ltsb.bdn_serial_number IS NOT null "
			+ "group by ltsb.id")
	Page<LabTestSampleBatch> findAllViralLoad(@Param("facilityId") Long facilityId,Pageable pageable);

	@Query(nativeQuery = true, value = "select max(id) from soch.lab_test_sample_batch")
	Long findMaxOfId();

	/**
	 * @param facilityId
	 * @param pageable
	 * @return
	 */
	@Query(nativeQuery = true, value = "select distinct on (ltsb.id) ltsb.id as batchId,ltsb.dispatch_date as dispatchDate,ltsb.bdn_serial_number as bdnSerialNumber,ltsb.num_of_samples as numOfSamples,ltsb.received_date as receivedDate,ltsb.accepted_samples as acceptedSamples,ltsb.rejected_samples as rejectedSamples,mbs.status as masterBatchStatus, " 
	 + "f.id as facilityId,f.name as facilityName,f.code as facilityCode,f.art_code as facilityArtCode,f2.id as labId,f2.name as labName,f2.code as labCode,ft.id as labFacilityTypeId,um.id as artcLabTechUserId,um.firstname as artcLabTechUserFirstName,um.lastname as artcLabTechUserLastName,um.mobile_number as artcLabTechUserMobile,a.address_line_one as labAddressLineOne, " 
	 + "a.address_line_two as labAddressLineTwo,um2.id as vlTechUserId,um2.firstname as vlTechUserFirstName,um2.lastname as vlTechUserLastName,um2.mobile_number as vlTechUserMobile,lts.result_received_date as resultReceivedDate from soch.lab_test_sample_batch ltsb join soch.lab_test_sample lts on lts.test_batch_id = ltsb.id left join soch.master_batch_status mbs on " 
	 + "(mbs.id = ltsb.batch_status_id) left join soch.facility f on (f.id = ltsb.artc_id) left join soch.facility f2 on (f2.id = ltsb.lab_id) left join soch.facility_type ft on (ft.id = f2.facility_type_id ) left join soch.user_master um on (um.id = ltsb.artc_lab_tech_id) left join soch.address a on (a.id = f2.address_id) left join soch.user_master um2 on " 
	 + "(um2.id = ltsb.lab_tech_id) where lts.test_id = 2 and lts.sample_collected_facility_id =:facilityId and ltsb.is_delete = false and ltsb.bdn_serial_number is not null ")
	Page<ArtLabVLPreviousDispatchProjection> getAllViralLoadPreviouDispatchedSamples(@Param("facilityId")Long facilityId,
			Pageable pageable);

	/**
	 * @param facilityId
	 * @param searchValue
	 * @param pageable
	 * @return
	 */
	@Query(nativeQuery = true, value = "select distinct on (ltsb.id) ltsb.id as batchId,ltsb.dispatch_date as dispatchDate,ltsb.bdn_serial_number as bdnSerialNumber,ltsb.num_of_samples as numOfSamples,ltsb.received_date as receivedDate,ltsb.accepted_samples as acceptedSamples,ltsb.rejected_samples as rejectedSamples,mbs.status as masterBatchStatus, " 
			 + "f.id as facilityId,f.name as facilityName,f.code as facilityCode,f.art_code as facilityArtCode,f2.id as labId,f2.name as labName,f2.code as labCode,ft.id as labFacilityTypeId,um.id as artcLabTechUserId,um.firstname as artcLabTechUserFirstName,um.lastname as artcLabTechUserLastName,um.mobile_number as artcLabTechUserMobile,a.address_line_one as labAddressLineOne,"
			 + "a.address_line_two as labAddressLineTwo,um2.id as vlTechUserId,um2.firstname as vlTechUserFirstName,um2.lastname as vlTechUserLastName,um2.mobile_number as vlTechUserMobile,lts.result_received_date as resultReceivedDate from soch.lab_test_sample_batch ltsb join soch.lab_test_sample lts on lts.test_batch_id = ltsb.id left join soch.master_batch_status mbs on (mbs.id = ltsb.batch_status_id) left join soch.facility f on (f.id = ltsb.artc_id) "
			 + "left join soch.facility f2 on (f2.id = ltsb.lab_id) left join soch.facility_type ft on (ft.id = f2.facility_type_id ) left join soch.user_master um on (um.id = ltsb.artc_lab_tech_id) left join soch.address a on (a.id = f2.address_id) left join soch.user_master um2 on (um2.id = ltsb.lab_tech_id) where lts.test_id = 2 " 
			 + "and lts.sample_collected_facility_id =:facilityId and ltsb.is_delete = false and ltsb.bdn_serial_number is not null and (lower(ltsb.bdn_serial_number) ilike %:searchValue%  or lower(f2.name) ilike %:searchValue% or lower(mbs.status) ilike %:searchValue% ) ")
	Page<ArtLabVLPreviousDispatchProjection> getAllViralLoadPreviouDispatchedSamplesBySearch(@Param("facilityId")Long facilityId,
			@Param("searchValue")String searchValue, Pageable pageable);

}
