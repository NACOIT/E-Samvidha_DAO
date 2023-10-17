package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterPurposeOfVisit;


@Repository
public interface MasterPurposeOfVisitRepository extends JpaRepository<MasterPurposeOfVisit, Long>{

	List<MasterPurposeOfVisit> findByisDeleteAndFacilityTypeId(Boolean isDelete, Integer facilityTypeId);
//	List<MasterPurposeOfVisitEntity> findByisDeleteAndFacilityTypeId(Boolean isDelete, Integer facilityTypeId);
	
	@Query(nativeQuery = true, value = "select * from soch.master_purpose_visit where id = :id")
	MasterPurposeOfVisit findByPurposeId(@Param("id")Long id);

}
