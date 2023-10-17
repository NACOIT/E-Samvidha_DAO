package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtBeneficiaryCounsellingAdherence;
import gov.naco.soch.projection.CounsellingNoteBasicBeneficiaryDetailsProjection;

@Repository
public interface ArtBeneficiaryCounsellingAdherenceRepository
		extends JpaRepository<ArtBeneficiaryCounsellingAdherence, Long>,
		JpaSpecificationExecutor<ArtBeneficiaryCounsellingAdherence> {

	@Query(nativeQuery = true, value = "select b.* from soch.art_beneficiary_counselling_adherence as b "
			+ " where b.beneficiary_id = :beneficiaryId and b.visit_register_id = :visiterId")
	List<ArtBeneficiaryCounsellingAdherence> findByBeneficiaryIdAndVisitRegisterId(
			@Param("beneficiaryId") Long beneficiaryId, @Param("visiterId") Long visiterId);

	@Query(value = "select min(cda.counselling_adherence_to_art) as counsellingAdherence from soch.art_beneficiary_counselling_adherence as cda where cda.beneficiary_id = :beneficiaryid and cda.visit_register_id =:visitRegisterId", nativeQuery = true)
	CounsellingNoteBasicBeneficiaryDetailsProjection findAdherenceByBeneficiaryId(
			@Param("beneficiaryid") Long beneficiaryid, @Param("visitRegisterId") Long visitRegisterId);

	@Query(value = "select avg(abca.counselling_adherence_to_art )  \r\n"
			+ "from soch.art_beneficiary_counselling_adherence abca \r\n"
			+ "join soch.beneficiary_visit_register bvr on abca.visit_register_id = bvr.id \r\n"
			+ "where abca.beneficiary_id=:beneficiaryId and abca.is_active=true and abca.is_delete=false \r\n"
			+ "and bvr.is_active=true and bvr.is_delete=false \r\n"
			+ "group by abca.visit_register_id order by abca.visit_register_id desc limit 1", nativeQuery = true)
	Float findAvgAdherenceByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select b.* from soch.art_beneficiary_counselling_adherence as b "
			+ " where b.beneficiary_id = :beneficiaryId and b.visit_register_id = :visitRegsiterId and b.product_id=:productId and b.facility_id=:facilityId order by b.id desc limit 1 ")
	ArtBeneficiaryCounsellingAdherence findByBeneficiaryIdAndVisitIdAndProductIdAndFacilityId( @Param("beneficiaryId") Long beneficiaryId,
			@Param ("visitRegsiterId") Long visitRegsiterId,@Param("productId") Long productId,@Param("facilityId") Long facilityId);

}