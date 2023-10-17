package gov.naco.soch.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.NgoDocumentsEntity;
import gov.naco.soch.projection.NgoMemberListProjection;

@Repository
public interface NgoDocumentRepository  extends JpaRepository<NgoDocumentsEntity, Long>, CustomRepository {
	List<NgoDocumentsEntity> findByIsDelete(Boolean isDelete);
	
	
	@Query(nativeQuery = true, value = "select n.id,n.remarks ,n.facility_id as facilityId,f.name as facilityName, n.sacs_id as sacsId ,n.financial_year as financialYear ,n.file_type as fileType ,n.file_name as fileName , n.file_path as filePath,n.valid_till as societyValiditydate,n.status ,n.is_active as isActive,n.is_delete as isDelete, n.created_time as createdTime \r\n"
			+ "from soch.registration_certificate n  join soch.facility f on n.facility_id =f.id where n.facility_id = :facilityId and n.is_delete= false and(lower(n.financial_year) Like %:searchText% or lower(f.name) Like %:searchText%)")
	Page<NgoMemberListProjection> findAllRegistrationCertByFacilityId(@Param("facilityId") Long facilityId,@Param("searchText") String searchText, Pageable pageable);
	
	@Query(nativeQuery = true, value = "select count(n.id) from soch.registration_certificate n inner join soch.facility f on n.facility_id =f.id where n.facility_id=:facilityId and n.is_delete= false  and(lower(n.financial_year) Like %:searchText% or lower(f.name) Like %:searchText%)")
	int findRegistrationCertCountByFacilityId(@Param("facilityId") Long facilityId,@Param("searchText") String searchText);
	
	@Query(nativeQuery = true, value = "select n.id,n.remarks ,n.facility_id as facilityId,f.name as facilityName, n.sacs_id as sacsId ,n.financial_year as financialYear ,n.file_type as fileType ,n.file_name as fileName , n.file_path as filePath,n.valid_till as societyValiditydate,n.status ,n.is_active as isActive,n.is_delete as isDelete, n.created_time as createdTime \r\n"
			+ "from soch.registration_certificate n  join soch.facility f on n.facility_id =f.id where n.sacs_id = :facilityId and n.is_delete= false  and(lower(n.financial_year) Like %:searchText% or lower(f.name) Like %:searchText%)")
	Page<NgoMemberListProjection> findAllRegistrationCertBySacsId(@Param("facilityId") Long facilityId,@Param("searchText") String searchText, Pageable pageable);
	
	@Query(nativeQuery = true, value = "select count(n.id) from soch.registration_certificate n inner join soch.facility f on n.facility_id =f.id and n.is_delete= false where n.sacs_id=:facilityId and(lower(n.financial_year) Like %:searchText% or lower(f.name) Like %:searchText%)")
	int findRegistrationCertCountBySacsId(@Param("facilityId") Long facilityId,@Param("searchText") String searchText);
	
	// Verify Registered Document Status
		@Modifying
		@Transactional
		@Query(nativeQuery = true, value = "update soch.registration_certificate set status =:recordStatus where id=:recordId")
		void changeRegCertStatus(@Param("recordId") Long recordId, @Param("recordStatus") Integer recordStatus);
		
		@Modifying
		@Transactional
		@Query(nativeQuery = true, value = "update soch.return_file set status =:recordStatus where id=:recordId")
		void changeReturnFileStatus(@Param("recordId") Long recordId, @Param("recordStatus") Integer recordStatus);
		
		@Modifying
		@Transactional
		@Query(nativeQuery = true, value = "update soch.activity_report set status =:recordStatus where id=:recordId")
		void changeActiveReportStatus(@Param("recordId") Long recordId, @Param("recordStatus") Integer recordStatus);
		
		@Modifying
		@Transactional
		@Query(nativeQuery = true, value = "update soch.audit_report set status =:recordStatus where id=:recordId")
		void changeAuditReportStatus(@Param("recordId") Long recordId, @Param("recordStatus") Integer recordStatus);
		
		@Modifying
		@Transactional
		@Query(nativeQuery = true, value = "update soch.fcra_registration set status =:recordStatus where id=:recordId")
		void changeFCRACertStatus(@Param("recordId") Long recordId, @Param("recordStatus") Integer recordStatus);
		
		@Modifying
		@Transactional
		@Query(nativeQuery = true, value = "update soch.tax_registration set status =:recordStatus where id=:recordId")
		void changeTaxCertStatus(@Param("recordId") Long recordId, @Param("recordStatus") Integer recordStatus);
		
		// Delete Registered Document Status
		@Modifying
		@Transactional
		@Query(nativeQuery = true, value = "update soch.registration_certificate set is_delete =:deleteStatus where id=:recordId")
		void deleteRegCertData(@Param("recordId") Long recordId, @Param("deleteStatus") Boolean deleteStatus);
		
		@Modifying
		@Transactional
		@Query(nativeQuery = true, value = "update soch.return_file set is_delete =:deleteStatus where id=:recordId")
		void deleteReturnFileData(@Param("recordId") Long recordId, @Param("deleteStatus") Boolean deleteStatus);
		
		@Modifying
		@Transactional
		@Query(nativeQuery = true, value = "update soch.activity_report set is_delete =:deleteStatus where id=:recordId")
		void deleteActiveReportData(@Param("recordId") Long recordId, @Param("deleteStatus") Boolean deleteStatus);
		
		@Modifying
		@Transactional
		@Query(nativeQuery = true, value = "update soch.audit_report set is_delete =:deleteStatus where id=:recordId")
		void deleteAuditReportData(@Param("recordId") Long recordId, @Param("deleteStatus") Boolean deleteStatus);
		
		@Modifying
		@Transactional
		@Query(nativeQuery = true, value = "update soch.annual_report set is_delete =:deleteStatus where id=:recordId")
		void deleteAnnualReportData(@Param("recordId") Long recordId, @Param("deleteStatus") Boolean deleteStatus);
		
		@Modifying
		@Transactional
		@Query(nativeQuery = true, value = "update soch.fcra_registration set is_delete =:deleteStatus where id=:recordId")
		void deleteFCRACertData(@Param("recordId") Long recordId, @Param("deleteStatus") Boolean deleteStatus);
		
		@Modifying
		@Transactional
		@Query(nativeQuery = true, value = "update soch.tax_registration set is_delete =:deleteStatus where id=:recordId")
		void deleteTaxCertData(@Param("recordId") Long recordId, @Param("deleteStatus") Boolean deleteStatus);

		@Modifying
		@Transactional
		@Query(nativeQuery = true, value = "update soch.sacs_audit_report set is_delete =:deleteStatus where id=:recordId")
		void deleteSacsAuditRecord(@Param("recordId") Long recordId, @Param("deleteStatus") Boolean deleteStatus);

		@Modifying
		@Transactional
		@Query(nativeQuery = true, value = "update soch.sacs_annual_report set is_delete =:deleteStatus where id=:recordId")
		void deleteSacsAnnualRecord(@Param("recordId") Long recordId, @Param("deleteStatus") Boolean deleteStatus);
		
		@Modifying
		@Transactional
		@Query(nativeQuery = true, value = "update soch.ngo_project_soe set is_delete =:deleteStatus where id=:recordId")
		void deleteSoeDocumentRecord(@Param("recordId") Long recordId, @Param("deleteStatus") Boolean deleteStatus);

		@Modifying
		@Transactional
		@Query(nativeQuery = true, value = "update soch.ngo_uc_details set is_delete =:deleteStatus where id=:recordId")
		void deleteUcDocumentRecord(@Param("recordId") Long recordId, @Param("deleteStatus") Boolean deleteStatus);
		
		@Modifying
		@Transactional
		@Query(nativeQuery = true, value = "update soch.other_documents_detail set is_delete =:deleteStatus where id=:recordId")
		void deleteOtherDocumentRecord(@Param("recordId") Long recordId, @Param("deleteStatus") Boolean deleteStatus);
		
		@Query(nativeQuery = true, value = "select rc.file_name as filename,rc.file_path as filepath,rc.valid_till as societyValiditydate from soch.registration_certificate as rc "
				+ "where rc.is_delete =false and rc.is_active=true and rc.facility_id=:facilityId order by rc.id desc ")
		List<Object[]> findSocietyCertByFacilityId(@Param("facilityId") Long facilityId);
		
		@Query(nativeQuery = true, value = "select rc.file_name as filename,rc.file_path as filepath,rc.valid_till as contractValiditydate from soch.ngo_contract_certificate as rc "
				+ "where rc.is_delete =false and rc.is_active=true and rc.facility_id=:facilityId order by rc.id desc ")
		List<Object[]> findContractLetterByFacilityId(@Param("facilityId") Long facilityId);
		
}
