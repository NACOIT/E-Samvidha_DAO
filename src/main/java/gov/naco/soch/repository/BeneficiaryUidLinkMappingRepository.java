package gov.naco.soch.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.BeneficiaryUidLinkMapping;
import gov.naco.soch.projection.UidMergeProjection;

@Repository
public interface BeneficiaryUidLinkMappingRepository extends JpaRepository<BeneficiaryUidLinkMapping, Long>,JpaSpecificationExecutor<BeneficiaryUidLinkMapping>{
	
	@Query(nativeQuery = true, value = "select b.id as beneficiaryId,b.uid as uid,b.first_name as firstName,b.middle_name as middleName,b.last_name as lastName,b.art_number as artNumber,bg.name as gender, " + 
			"b.date_of_birth as dateOfBirth,b.mobile_number as mobileNumber,f.name as facility,f.id as facilityId,ft.id as facilityTypeId, ft.facility_type_name as facilityType,bfm.id as linkedId, bfm.created_by as createdBy from soch.beneficiary b join soch.master_gender bg on " + 
			"bg.id = b.gender_id join soch.beneficiary_uid_link_mapping bfm on bfm.uid_link_beneficiary_id = b.id and b.is_delete = false join soch.facility f on f.id = bfm.uid_link_facility_id " + 
			"join soch.facility_type ft on ft.id = f.facility_type_id where bfm.base_beneficiary_id =:beneficiaryId and bfm.is_delete = false and bfm.is_active = true " + 
			"order by bfm.modified_time desc")
	List<UidMergeProjection> findAllLinkedBeneficiaries(@Param("beneficiaryId")Long baseBeneficiary);
	
	@Query(nativeQuery = true, value = "select b.id as beneficiaryId,b.uid as uid,b.first_name as firstName,b.middle_name as middleName,b.last_name as lastName,b.art_number as artNumber,bg.name as gender, " + 
			"b.date_of_birth as dateOfBirth,b.mobile_number as mobileNumber,f.name as facility,f.id as facilityId,ft.id as facilityTypeId, ft.facility_type_name as facilityType,bfm.id as linkedId, bfm.created_by as createdBy from soch.beneficiary b join soch.master_gender bg on " + 
			"bg.id = b.gender_id join soch.beneficiary_uid_link_mapping bfm on bfm.base_beneficiary_id = b.id and b.is_delete = false join soch.facility f on f.id = bfm.base_facility_id " + 
			"join soch.facility_type ft on ft.id = f.facility_type_id where bfm.uid_link_beneficiary_id =:beneficiaryId  and bfm.is_delete = false and bfm.is_active = true " + 
			"order by bfm.modified_time desc")
	List<UidMergeProjection> findAllLinkedBeneficiariesInReverse(@Param("beneficiaryId")Long baseBeneficiary);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "update soch.beneficiary_uid_link_mapping set is_delete = true, is_active = false where id =:linkedId ")
	int unlinkBeneficiaryUid(@Param("linkedId")Long linkedId);

}
