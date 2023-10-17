package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.entity.TiOstBeneficiary;
import gov.naco.soch.projection.TiOstBeneficiaryPojection;

@Repository
public interface TiOstBeneficiaryRepository
		extends JpaRepository<TiOstBeneficiary, Long>, JpaSpecificationExecutor<TiOstBeneficiary>, CustomRepository {

	@Override
	@EntityGraph(value = "tiOstBeneficiaryGraph")
	Page<TiOstBeneficiary> findAll(Specification<TiOstBeneficiary> spec, Pageable pageable);

	List<TiOstBeneficiary> findAllByOstStatus(int i);

	List<TiOstBeneficiary> findAllByOstStatusIn(List<Long> ostStatusIds);

	Optional<TiOstBeneficiary> findByOstCodeAndAndIsDeletedAndIdNot(String ostCode, boolean isDeleted,
			Long beneficiaryId);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value = "CALL soch.beneficiary_dispensestatus()")
	void updateBeneficiaryDispensationStatus();

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value = "CALL soch.beneficiary_clientstatus()")
	void updateBeneficiaryClientStatus();

	boolean existsByOstCodeAndBeneficiary_BeneficiaryFacilityMappings_Facility_IdAndIsDeleted(String ostCode,
			Long facilityId, boolean b);

	Optional<TiOstBeneficiary> findByOstCodeAndBeneficiary_BeneficiaryFacilityMappings_Facility_IdAndIsDeletedAndIdNot(
			String ostCode, Long facilityId, boolean b, Long beneficiaryId);

	Optional<TiOstBeneficiary> findByOstNumberAndBeneficiary_BeneficiaryFacilityMappings_Facility_IdAndIsDeletedAndIdNot(
			String ostNumber, Long facilityId, boolean b, Long beneficiaryId);

	@Query("select case when tob.status.id in (1,7) then true else false end from "
			+ " TiOstBeneficiary tob where id=:id")
	boolean checkActiveOrRelapseStatus(@Param("id") Long id);

	@Query(nativeQuery = true, value = ostBeneficiarySearchQuery)
	Page<TiOstBeneficiaryPojection> findOstBeneficiariesByBasicSearchWithTsVector(@Param("facilityId") Long facilityId,
			@Param("isDelete") List<Boolean> isDelete, @Param("searchString") String searchString, Pageable page);

	String ostBeneficiarySearchQuery = "select ostben.facility_id as facilityId,\r\n"
			+ "ostben.consent_documented as consentDocumented,\r\n"
			+ "ostben.consent_taken_date as consentTakenDate,ostben.followUps as followUps,\r\n"
			+ "ostben.id as ostBeneficiaryId,ostben.is_active as isActive,ostben.is_delete as isDeleted,\r\n"
			+ "ostben.is_transit as isTransit,ostben.status_id as statusId,\r\n"
			+ "ostben.registration_date as registrationDate,\r\n" + "ostben.referred_from_id as referredFromId,\r\n"
			+ "ostben.ost_status_id as ostStatusId,ostben.ost_code as ostCode,\r\n"
			+ "ostben.ost_number as ostNumber,ostben.linked_facility_id as linkedFacilityId,mr.name as referredFrom,\r\n"
			+ "mcs.name as status,mos.name as ostStatus,ostben.is_transfer_out as isTransferOut,bfm.is_transferred as isTransferred,\r\n"
			+ "tm.typology_id as typologyId,tm.typology_name as typologyName,ben.id as beneficiaryId,ben.first_name as firstName,\r\n"
			+ "ben.last_name as lastName,ben.middle_name as middleName,ben.uid as uid,ben.age as age,ben.date_of_birth as dateOfBirth,\r\n"
			+ "ben.mobile_number as mobileNumber,ben.gender_id as genderId,g.name as gender,ostben.transit_end_date as transitenddate,ostben.transit_start_date as transitstartdate\r\n"
			+ "from soch.ti_ost_beneficiary ostben left outer join soch.master_client_status_ost mcs\r\n"
			+ "on(ostben.status_id=mcs.id) left outer join soch.master_referredfrom mr\r\n"
			+ "on(ostben.referred_from_id=mr.id) left outer join soch.master_ost_status_beneficiary mos\r\n"
			+ "on(ostben.ost_status_id=mos.id) left outer join soch.beneficiary ben on(ostben.beneficiary_id=ben.id)\r\n"
			+ "left outer join soch.beneficiary_facility_mapping bfm on (ben.id=bfm.beneficiary_id)\r\n"
			+ "left outer join soch.facility f on(bfm.facility_id = f.id)\r\n"
			+ "left outer join soch.typology_master tm on(ostben.master_hrg_primary_id=tm.typology_id)\r\n"
			+ "left outer join soch.master_gender g on(ben.gender_id=g.id)\r\n"
			+ "left outer join soch.beneficiary_transit_facility tf on(ostben.id=tf.ti_ost_beneficiary_id) and ( tf.is_delete=false)\r\n"
			+ "where f.id=:facilityId and ostben.is_delete in :isDelete and (lower(ben.ost_benf_search_str) like %:searchString%)";

	@Modifying
	@Transactional
	@Query(value = "update\r\n" + "    soch.beneficiary b set tsv_tivalues = to_tsvector(\r\n"
			+ "coalesce(first_name, '') || ' ' || coalesce(middle_name, '') || ' ' ||\r\n"
			+ "coalesce(last_name, '') || ' ' || coalesce(uid, '') || ' ' ||\r\n"
			+ "coalesce(mobile_number, '') || ' ' || coalesce(ost_code, '') || ' ' ||\r\n"
			+ "coalesce((select tob.ost_number from soch.beneficiary b2\r\n"
			+ "join soch.ti_ost_beneficiary tob on (b2.id = tob.beneficiary_id)\r\n"
			+ "where b2.id = :beneficiaryId), '' )) where b.id = :beneficiaryId\r\n"
			+ "and ( b.first_name is not null or b.middle_name is not null\r\n"
			+ "or b.last_name is not null or b.uid is not null\r\n"
			+ "or b.mobile_number is not null or b.ost_code is not null)", nativeQuery = true)
	int updateTsvTiValues(@Param("beneficiaryId") Long beneficiaryId);

	@Modifying
	@Transactional
	@Query(value = "UPDATE soch.beneficiary b\r\n"
			+ "SET ost_benf_search_str = b.uid || ' ' || TRIM(coalesce(b.mobile_number, '')) || ' ' || TRIM(coalesce(b.first_name, '')) || ' ' || TRIM(coalesce(b.middle_name, ''))|| ' ' || TRIM(coalesce(b.last_name, '')) || ' ' || TRIM(coalesce(tob.ost_number, ''))\r\n"
			+ "FROM soch.ti_ost_beneficiary tob\r\n"
			+ "WHERE tob.beneficiary_id = :beneficiaryId AND b.id = tob.beneficiary_id", nativeQuery = true)
	int updateOstBenSearchValues(@Param("beneficiaryId") Long beneficiaryId);
}
