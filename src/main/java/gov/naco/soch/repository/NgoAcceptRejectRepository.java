package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.NgoAcceptRejectEntity;

@Repository
public interface NgoAcceptRejectRepository  extends JpaRepository<NgoAcceptRejectEntity, Long>, CustomRepository {
	List<NgoAcceptRejectEntity> findByIsDelete(Boolean isDelete);
	
	@Query(nativeQuery = true, value = "select ard.id,ard.remarks , ard.approve_reject_date , ard.file_name , ard.file_path,ard.disclaimer,ard.facility_id,ard.status,ard.is_active,ard.is_delete, ard.created_by, date(ard.created_time) as approvedDate, ard.modified_by, ard.modified_time from soch.approve_reject_details ard where ard.facility_id= :facilityId and ard.is_active = true and ard.is_delete =false order by ard.id desc limit 1;")	
	List<Object[]> fetchAcceptRejectListByFacId(@Param("facilityId") Long facilityId);
	
	@Query(nativeQuery = true, value = "select date(ard.created_time) as approveRejectDate from soch.facility ard where ard.id= :facilityId and ard.is_active = true and ard.is_delete =false order by ard.id desc limit 1;")	
	List<Object[]> fetchDataByFacId(@Param("facilityId") Long facilityId);

}
