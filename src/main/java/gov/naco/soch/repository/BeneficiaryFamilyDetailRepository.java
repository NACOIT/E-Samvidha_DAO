package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.BeneficiaryFamilyDetail;

import javax.transaction.Transactional;

@Repository
public interface BeneficiaryFamilyDetailRepository
		extends JpaRepository<BeneficiaryFamilyDetail, Long>, JpaSpecificationExecutor<BeneficiaryFamilyDetail> {

	boolean existsByBeneficiary_IdAndPartnerBeneficiary_IdAndIsDelete(Long beneficiaryId, Long partnerId,
			boolean isDelete);

	List<BeneficiaryFamilyDetail> findAllByBeneficiary_IdAndIsDelete(Long beneficiaryId, Boolean false1);

	@Query(nativeQuery = true, value = "select * from soch.beneficiary_family_details bfd where bfd.beneficiary_id=:id order by bfd.created_time DESC LIMIT 1")
	BeneficiaryFamilyDetail findLatestByBeneficiary_Id(@Param("id") Long id);

	List<BeneficiaryFamilyDetail> findByPartnerBeneficiary_Id(Long beneficiaryId);
	
	@Query(value = "select * from beneficiary_family_details as bfd where bfd.beneficiary_id = :beneficiaryId "
			+ "and bfd.relationship_id = :relationshipId order by bfd.id desc limit 1", nativeQuery = true)
	Optional<BeneficiaryFamilyDetail> findByBeneficiaryIdAndRelationshipId(@Param("beneficiaryId") Long beneficiaryId,
			@Param("relationshipId") Long relationshipId);

	@Query(value = "select b from BeneficiaryFamilyDetail b LEFT JOIN FETCH b.masterGender mg "
			+ "LEFT JOIN FETCH b.masterHivStatus mhs LEFT JOIN FETCH b.masterRelationship mr "
			+ "where b.beneficiary.id=:id")
	List<BeneficiaryFamilyDetail> findFamilyMembersByBenficiaryId(@Param("id") Long id);

	@Query(value = "select fd.family_uid from soch.beneficiary_family_details as fd where fd.beneficiary_id = :beneficiaryId "
			+ "order by fd.id desc limit 1", nativeQuery = true)
	String findFamilyUidIfExistsForBeneficiary(@Param("beneficiaryId") Long beneficiaryId);

	@Modifying
	@Transactional
	@Query(value = "update soch.beneficiary_family_details set is_twin=true where beneficiary_id=:beneficiaryId", nativeQuery = true)
	int updateTwinStatusForBeneficiary(@Param("beneficiaryId") Long beneficiaryId);

}