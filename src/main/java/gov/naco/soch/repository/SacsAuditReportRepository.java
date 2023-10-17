package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.NgoDocumentsEntity;
import gov.naco.soch.entity.SacsAuditReportEntity;
import gov.naco.soch.projection.NgoMemberListProjection;

@Repository
public interface SacsAuditReportRepository  extends JpaRepository<SacsAuditReportEntity, Long>, CustomRepository {
	List<NgoDocumentsEntity> findByIsDelete(Boolean isDelete);
	
	@Query(nativeQuery = true, value = "select n.id,n.remarks ,n.facility_id as facilityId,f.name as facilityName, n.financial_year as financialYear ,n.file_type as fileType ,n.file_name as fileName , n.file_path as filePath,n.status ,n.is_active as isActive,n.is_delete as isDelete, n.created_time as createdTime \r\n"
			+ "from soch.sacs_audit_report n  join soch.facility f on n.facility_id =f.id where n.facility_id = :facilityId and n.is_delete= false  and(lower(n.financial_year) Like %:searchText% or lower(f.name) Like %:searchText%)")
	Page<NgoMemberListProjection> findAllRegistrationCertByFacilityId(@Param("facilityId") Long facilityId,@Param("searchText") String searchText, Pageable pageable);
	
	@Query(nativeQuery = true, value = "select count(n.id) from soch.sacs_audit_report n inner join soch.facility f on n.facility_id =f.id and n.is_delete= false  where n.facility_id=:facilityId and(lower(n.financial_year) Like %:searchText% or lower(f.name) Like %:searchText%)")
	int findRegistrationCertCountByFacilityId(@Param("facilityId") Long facilityId,@Param("searchText") String searchText);
	
//	@Query(nativeQuery = true, value = "select n.id,n.remarks ,n.facility_id as facilityId,f.name as facilityName,n.financial_year as financialYear ,n.file_type as fileType ,n.file_name as fileName , n.file_path as filePath,n.status ,n.is_active as isActive,n.is_delete as isDelete, n.created_time as createdTime \r\n"
//			+ "from soch.sacs_audit_report n  join soch.facility f on n.facility_id =f.id where n.sacs_id = :facilityId and n.is_delete= false  and(lower(n.financial_year) Like %:searchText% or lower(f.name) Like %:searchText%)")
//	Page<NgoMemberListProjection> findAllRegistrationCertBySacsId(@Param("facilityId") Long facilityId,@Param("searchText") String searchText, Pageable pageable);
//	
//	@Query(nativeQuery = true, value = "select count(n.id) from soch.sacs_audit_report n inner join soch.facility f on n.facility_id =f.id where n.sacs_id=:facilityId and n.is_delete= false  and(lower(n.financial_year) Like %:searchText% or lower(f.name) Like %:searchText%)")
//	int findRegistrationCertCountBySacsId(@Param("facilityId") Long facilityId,@Param("searchText") String searchText);
	
}
