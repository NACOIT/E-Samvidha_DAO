package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.projection.BeneficiaryHeightWeightProjection;
import gov.naco.soch.projection.ProfileWidgetProjection;
import gov.naco.soch.projection.StatisticsProjection;

@Repository
public interface ArtMiniatureInvestigationRepository extends JpaRepository<Beneficiary, Long> {

	@Query(nativeQuery = true , value ="select ROW_NUMBER () OVER (ORDER BY abi.investigation_date desc) AS resultId, "
			+ " abi.investigation_value as resultValue , abi.investigation_date as resultDate from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id "
			+ " inner join soch.art_beneficiary_investigation abi on abi.beneficiary_id = ab.beneficiary_id and abi.facility_id = ab.facility_id "
			+ " inner join soch.master_investigation mi on abi.investigation_id = mi.id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where (0=:facilityId or bfm.facility_id=:facilityId) and ab.is_active = true and ab.is_delete=false "
			+ " and b.id = :beneficiaryId and mi.id = :investigationId "
			+ " fetch first 12 row only")
	List<ProfileWidgetProjection> getInvestigationDetails(@Param("beneficiaryId") Long beneficiaryId, @Param("facilityId") Long facilityId , @Param("investigationId") Long investigationId);

    @Query(nativeQuery = true, value = "select id from soch.master_investigation fetch first 1 row only")
	Long getFirstInvestigationId();

    @Query(nativeQuery = true, value = "select mi.id as value, mi.name as name from soch.master_investigation mi")
	List<StatisticsProjection> getMasterInvestigationDetails();

	@Query(nativeQuery = true, value = "select bvr.visit_date as visitedDate,bvr.weight,bvr.height from soch.beneficiary b\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.beneficiary_visit_register bvr on bvr.beneficiary_id  = b.id\n" +
			"inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"where bfm.facility_id  = :facilityId and bvr.beneficiary_id  = :beneficiaryId and bvr.is_active =true\n" +
			"and bvr.visit_date is not null and (bvr.height is not null or bvr.weight is not null)\n" +
			"order by bvr.visit_date desc limit 12")
	List<BeneficiaryHeightWeightProjection> getBeneficiaryHeightAndWeightDetails(@Param("beneficiaryId") Long beneficiaryId, @Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select bvr.visit_date as visitedDate,bvr.weight,bvr.height from soch.beneficiary b\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.beneficiary_visit_register bvr on bvr.beneficiary_id  = b.id\n" +
			"where bvr.beneficiary_id  = :beneficiaryId and bvr.is_active =true\n" +
			"and bvr.visit_date is not null and (bvr.height is not null or bvr.weight is not null)\n" +
			"order by bvr.visit_date desc limit 12")
	List<BeneficiaryHeightWeightProjection> getBeneficiaryVisitHeightAndWeightDetails(@Param("beneficiaryId") Long beneficiaryId);



}
