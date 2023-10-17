package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterClientStatus;

@Repository
public interface MasterClientStatusRepository extends JpaRepository<MasterClientStatus, Long> {

	
	 List<MasterClientStatus> findByIsDelete(Boolean isDelete);

	List<MasterClientStatus> findByFacilityTypeIdAndIsDelete(Long facilityTypeId, Boolean isDelete);
	
	@Query(nativeQuery = true, value = "select count(d.id) from soch.master_client_status_ticore d where is_delete = false and  LOWER(d.name)=LOWER(:name)")
	int existsByOtherName(@Param("name") String name); 
	

}