package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.GbDetailsEntity;
import gov.naco.soch.entity.NgoMember;
import gov.naco.soch.entity.NgoReleasedAmtEntity;
import gov.naco.soch.projection.NgoMemberListProjection;
import gov.naco.soch.projection.NgoSoeReleaseFundProjection;

@Repository
public interface NgoReleasedAmtRepository  extends JpaRepository<NgoReleasedAmtEntity, Long>, CustomRepository {
	List<GbDetailsEntity> findByIsDelete(Boolean isDelete);
	
	@Query(nativeQuery = true, value = "select count(1)\r\n"
			+ "from soch.ngo_soe_released_fund n join soch.facility f on n.facility_id =f.id where n.project_id =:projectId and n.is_delete= false")
	int findCountByProjectId(@Param("projectId") Long projectId);
	
	@Query(nativeQuery = true, value = "select n.id,n.project_id as projectId ,n.facility_id as facilityId,f.name as facilityName ,n.financial_year as financialYear ,n.soe_released_amount as releasedAmount,n.soe_released_date as releaseDate, n.remarks ,n.is_active as isActive,n.is_delete as isDelete, n.created_time as createdTime\r\n"
			+ "from soch.ngo_soe_released_fund n join soch.facility f on n.facility_id =f.id where n.project_id =:projectId and n.is_delete= false")
	Page<NgoSoeReleaseFundProjection> findAllReleaseFundByProjectId(@Param("projectId") Long projectId, Pageable pageable);
	
	@Query(nativeQuery = true, value = "select count(1) "
			+ "from soch.ngo_soe_released_fund n join soch.facility f on n.facility_id =f.id where n.project_id =:projectId and n.is_delete= false "
			+ " and (lower(n.financial_year) like %:searchText%"
			+ "	or lower(n.remarks) Like %:searchText%)")
	int findCountByProjectIdSearch(@Param("projectId") Long projectId,@Param("searchText") String searchText);
	
	@Query(nativeQuery = true, value = "select n.id,n.project_id as projectId ,n.facility_id as facilityId,f.name as facilityName ,n.financial_year as financialYear ,n.soe_released_amount as releasedAmount,n.soe_released_date as releaseDate, n.remarks ,n.is_active as isActive,n.is_delete as isDelete, n.created_time as createdTime\r\n"
			+ "from soch.ngo_soe_released_fund n join soch.facility f on n.facility_id =f.id where n.project_id =:projectId and n.is_delete= false "
			+ " and (lower(n.financial_year) like %:searchText%"
			+ "	or lower(n.remarks) Like %:searchText%)")
	Page<NgoSoeReleaseFundProjection> findAllReleaseFundByProjectIdSearch(@Param("projectId") Long projectId,@Param("searchText") String searchText, Pageable pageable);


	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update soch.gb_details set is_delete =:deleteStatus where id=:gbId")
	void deleteGbDetail(@Param("gbId") Long gbId, @Param("deleteStatus") Boolean deleteStatus);
	
	// Change Member Status
		@Modifying
		@Transactional
		@Query(nativeQuery = true, value = "update soch.gb_details set is_active =:gbStatus where id=:gbId")
		void changeGbStatus(@Param("gbId") Long gbId, @Param("gbStatus") Boolean gbStatus);
}
