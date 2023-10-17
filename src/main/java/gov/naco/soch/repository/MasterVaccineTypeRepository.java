package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterVaccineType;

@Repository
public interface MasterVaccineTypeRepository extends JpaRepository<MasterVaccineType, Long> {

	List<MasterVaccineType> findByIsDelete(Boolean isDelete);
	
	
	@Query(nativeQuery=true , value =" select * from soch.master_vaccine_type where is_delete=false and vaccine_stage_id=:stageId ")
	List<MasterVaccineType> findByIsDeleteAndVaccineStageId(@Param("stageId") Long stageId);

}