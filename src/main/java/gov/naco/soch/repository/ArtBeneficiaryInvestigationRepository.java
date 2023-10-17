package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtBeneficiaryInvestigation;
import gov.naco.soch.projection.ArtBeneficiaryInvestigationProjection;
import gov.naco.soch.projection.WhiteCardDetailsProjection;

@Repository
public interface ArtBeneficiaryInvestigationRepository extends JpaRepository<ArtBeneficiaryInvestigation, Long> {


	@Query(value = "select distinct investigation_date as investigationDate, visit_register_id as visitRegisterId from "
			+ "soch.art_beneficiary_investigation bi where bi.beneficiary_id=:beneficiaryId "
			+ "and bi.facility_id=:facilityId and visit_register_id IN :visitRegisterIds order by visit_register_id ASC", nativeQuery = true)
	List<ArtBeneficiaryInvestigationProjection> findInvestigationDates(@Param("beneficiaryId") Long beneficiaryId,
			@Param("facilityId") Long facilityId, @Param("visitRegisterIds") List<Long> visitRegisterIds);

	@Query(value = "select beneficiary_id as beneficiaryId, facility_id as facilityId, "
			+ "investigation_id as investigationId, investigation_value as investigationValue, "
			+ "investigation_date as investigationDate, visit_register_id as visitRegisterId from "
			+ "soch.art_beneficiary_investigation bi where bi.beneficiary_id=:beneficiaryId "
			+ "and bi.facility_id=:facilityId and visit_register_id IN :visitRegisterIds "
			+ "order by visit_register_id ASC", nativeQuery = true)
	List<ArtBeneficiaryInvestigationProjection> findInvestigationByBeneficiaryIdAndVisitRegisterIds(
			@Param("beneficiaryId") Long beneficiaryId, @Param("facilityId") Long facilityId,
			@Param("visitRegisterIds") List<Long> visitRegisterIds);

	@Query(value = "select * from soch.art_beneficiary_investigation bi "
			+ "where visit_register_id = :visitRegisterId", nativeQuery = true)
	List<ArtBeneficiaryInvestigation> findExistingInvestigationByVisitRegisterId(
			@Param("visitRegisterId") Long visitRegisterIds);

	@Query(nativeQuery = true , value="select abi.investigation_date as investigationDate ,mi.name as investigation ,abi.investigation_value as investigationValue " + 
			"from soch.art_beneficiary_investigation as abi " + 
			"join soch.beneficiary_visit_register as bvr on bvr.id = abi.visit_register_id " + 
			"left join soch.master_investigation as mi on mi.id = abi.investigation_id " + 
			"where abi.beneficiary_id = :beneficiaryId order by abi.investigation_date asc ")
	List<WhiteCardDetailsProjection> findInvestigationDetailsByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true , value="select distinct investigation_date as investigationDate, visit_register_id as visitRegisterId from "
			+ "soch.art_beneficiary_investigation bi where bi.beneficiary_id=:beneficiaryId order by visit_register_id ASC")
	List<ArtBeneficiaryInvestigationProjection> findInvestigationDatesByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	
	@Query(value = "select distinct investigation_date as investigationDate, visit_register_id as visitRegisterId from "
			+ "soch.art_beneficiary_investigation bi where bi.beneficiary_id=:beneficiaryId "
			+ "and visit_register_id IN :visitRegisterIds order by visit_register_id ASC", nativeQuery = true)
	List<ArtBeneficiaryInvestigationProjection> findInvestigationDates(@Param("beneficiaryId") Long beneficiaryId,@Param("visitRegisterIds") List<Long> visitRegisterIds);
	
	
	@Query(value = "select beneficiary_id as beneficiaryId, "
			+ "investigation_id as investigationId, investigation_value as investigationValue, "
			+ "investigation_date as investigationDate, visit_register_id as visitRegisterId from "
			+ "soch.art_beneficiary_investigation bi where bi.beneficiary_id=:beneficiaryId "
			+ "and visit_register_id IN :visitRegisterIds "
			+ "order by visit_register_id ASC", nativeQuery = true)
	List<ArtBeneficiaryInvestigationProjection> findInvestigationByBeneficiaryIdAndVisitRegisterIds(
			@Param("beneficiaryId") Long beneficiaryId, 
			@Param("visitRegisterIds") List<Long> visitRegisterIds);


}
