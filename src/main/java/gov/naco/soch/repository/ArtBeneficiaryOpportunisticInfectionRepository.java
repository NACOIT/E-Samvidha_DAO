package gov.naco.soch.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtBeneficiaryOpportunisticInfection;
import gov.naco.soch.projection.ArtBeneficiaryOIDetailsProjection;
import gov.naco.soch.projection.ArtTbOiDetailProjection;

@Repository
public interface ArtBeneficiaryOpportunisticInfectionRepository
		extends JpaRepository<ArtBeneficiaryOpportunisticInfection, Long> {

	@Query(nativeQuery = true, value = "select oi.* from soch.art_beneficiary_opportunistic_infections as oi "
			+ "where oi.visit_register_id = :visitRegisterId")
	List<ArtBeneficiaryOpportunisticInfection> findByVisitRegisterId(@Param("visitRegisterId") Long visitRegisterId);
	
	@Query(nativeQuery = true, value = "select * from soch.art_beneficiary_opportunistic_infections as oi join soch.beneficiary_visit_register vr"
			+ " on vr.id = oi.visit_register_id where oi.visit_register_id = :visitRegisterId and vr.beneficiary_id = :beneficiaryId ")
	List<ArtBeneficiaryOpportunisticInfection> findByBeneficiaryIdAndVisitRegisterId(@Param("beneficiaryId") Long beneficiaryId, @Param("visitRegisterId") Long visitRegisterId);
	
	@Query(nativeQuery = true, value = "select bv.visit_date as dateOfVisit, bf.opportunistic_infections_remarks as remarks, bv.id as visitorRegisterId from soch.beneficiary_visit_register bv " + 
			" join soch.art_beneficiary_followup bf on bf.visit_register_id = bv.id where bv.beneficiary_id = :beneficiaryId " + 
			"  order by bv.visit_date desc limit 4")
	List<ArtTbOiDetailProjection> findTbOiByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select bv.visit_date as visitDate, bf.opportunistic_infection_id as masterOpportunisticInfectionId, bv.id as visiterRegisterId from soch.beneficiary_visit_register bv " + 
			" join soch.art_beneficiary_opportunistic_infections bf on bf.visit_register_id = bv.id where bv.beneficiary_id = :beneficiaryId " + 
			"  order by bv.visit_date desc limit 3")
	List<ArtBeneficiaryOIDetailsProjection> findOpportunisticInfections(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery= true , value = " select " + 
			" distinct(beneficiary_id) " + 
			" from " + 
			" ( " + 
			" select " + 
			" beneficiary_id, max(id) as visit_register_id " + 
			" from " + 
			" soch.beneficiary_visit_register " + 
			" group by " + 
			" beneficiary_id) as result " + 
			" join soch.art_beneficiary_opportunistic_infections as aboi on " + 
			" result.visit_register_id = aboi.visit_register_id " + 
			" where " + 
			" aboi.opportunistic_infection_id in (:opportunisticInfectionIds) ")
	Set<Long> findOpportunisticInfectionPostiveBeneficiaryList(@Param("opportunisticInfectionIds") Set<Long> opportunisticInfectionIds);
}
