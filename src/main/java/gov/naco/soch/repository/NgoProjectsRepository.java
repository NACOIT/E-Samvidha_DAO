package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.NgoProjectsEntity;
import gov.naco.soch.projection.NgoMemberListProjection;
import gov.naco.soch.projection.NgoProjectListProjection;

@Repository
public interface NgoProjectsRepository  extends JpaRepository<NgoProjectsEntity, Long>, CustomRepository {
	List<NgoProjectsRepository> findByIsDelete(Boolean isDelete);
	
	@Query(nativeQuery = true, value = "select np.id,s.name as stateName,d.name as districtName,np.project_name as projectName ,upper(np.project_type) as projectType  ,np.facility_id as facilityId,np.is_active as isActive,\r\n"
			+ "np.start_date as startDate ,np.end_date as endDate ,np.sanction_amount as sanctionAmount ,np.file_name as fileName ,np.file_path as filePath, nptm.typology_id as typologyId, typology_name as typologyName,\r\n"
			+ "np.state_id as stateId,np.district_id as districtId,np.address,np.pincode\r\n"
			+ "from soch.ngo_project np \r\n"
			+ "left join  (select  np.project_id , array_to_string(array_agg(np.typology_id ),  ',' ) typology_id,\r\n"
			+ "array_to_string(array_agg(ty.typology_name  ),  ',' ) typology_name\r\n"
			+ "from soch.ngo_project_typology_mapping np\r\n"
			+ "inner join soch.typology_master ty on ty.typology_id = np.typology_id\r\n"
			+ "group by np.project_id ) nptm on np.id= nptm.project_id\r\n"
			+ "inner join soch.state s on s.id=np.state_id \r\n"
			+ "inner join soch.district d on d.id = np.district_id\r\n"
			+ "where np.facility_id =:facilityId and np.is_delete= false\r\n"
			+ "group by typology_id,typology_name,np.id,nptm.project_id,np.id,s.name,d.name ,np.project_name ,np.project_type ,np.facility_id ,\r\n"
			+ "np.start_date ,np.end_date ,np.sanction_amount ,np.file_name ,np.file_path,np.is_active,np.state_id ,np.district_id,np.address,np.pincode")
	Page<NgoProjectListProjection> findAllProjectsByFacilityId(@Param("facilityId") Long facilityId, Pageable pageable);
	
	@Query(nativeQuery = true, value = "select count(1) from (select count(np.id)\r\n"
			+ "from soch.ngo_project np \r\n"
			+ "left join  (select  np.project_id , array_to_string(array_agg(np.typology_id ),  ',' ) typology_id,\r\n"
			+ "array_to_string(array_agg(ty.typology_name  ),  ',' ) typology_name\r\n"
			+ "from soch.ngo_project_typology_mapping np\r\n"
			+ "inner join soch.typology_master ty on ty.typology_id = np.typology_id\r\n"
			+ "group by np.project_id ) nptm on np.id= nptm.project_id\r\n"
			+ "inner join soch.state s on s.id=np.state_id \r\n"
			+ "inner join soch.district d on d.id = np.district_id\r\n"
			+ "where np.facility_id =:facilityId and np.is_delete= false\r\n"
			+ "group by np.id,nptm.project_id) asd group by count")
	int findCountByFacilityId(@Param("facilityId") Long facilityId);
	
	@Query(nativeQuery = true, value = "select np.id,s.name as stateName,d.name as districtName,np.project_name as projectName ,upper(np.project_type) as projectType  ,np.facility_id as facilityId,np.is_active as isActive,\r\n"
			+ "	np.start_date as startDate ,np.end_date as endDate ,np.sanction_amount as sanctionAmount ,np.file_name as fileName ,np.file_path as filePath, nptm.typology_id as typologyId, typology_name as typologyName,\r\n"
			+ "	np.state_id as stateId,np.district_id as districtId,np.address,np.pincode \r\n"
			+ "	from soch.ngo_project np \r\n"
			+ "	left join  (select  np.project_id , array_to_string(array_agg(np.typology_id ),  ',' ) typology_id,\r\n"
			+ "	array_to_string(array_agg(ty.typology_name  ),  ',' ) typology_name\r\n"
			+ "	from soch.ngo_project_typology_mapping np\r\n"
			+ "	inner join soch.typology_master ty on ty.typology_id = np.typology_id\r\n"
			+ "	group by np.project_id ) nptm on np.id= nptm.project_id\r\n"
			+ "	inner join soch.state s on s.id=np.state_id \r\n"
			+ "	inner join soch.district d on d.id = np.district_id\r\n"
			+ "	where np.facility_id =:facilityId and np.is_delete= false and(lower(np.project_name) Like %:searchText% or lower(np.project_type) Like %:searchText%)  \r\n"
			+ "	group by typology_id,typology_name,np.id,nptm.project_id,np.id,s.name,d.name ,np.project_name ,np.project_type ,np.facility_id ,\r\n"
			+ "	np.start_date ,np.end_date ,np.sanction_amount ,np.file_name ,np.file_path,np.is_active,np.state_id ,np.district_id,np.address,np.pincode")
	Page<NgoProjectListProjection> findAllProjectsByFacilityIdSearch(@Param("facilityId") Long facilityId,@Param("searchText") String searchText, Pageable pageable);
	
	@Query(nativeQuery = true, value = "select count(1) from (select count(np.id)\r\n"
			+ "	from soch.ngo_project np \r\n"
			+ "	left join  (select  np.project_id , array_to_string(array_agg(np.typology_id ),  ',' ) typology_id,\r\n"
			+ "	array_to_string(array_agg(ty.typology_name  ),  ',' ) typology_name\r\n"
			+ "	from soch.ngo_project_typology_mapping np\r\n"
			+ "	inner join soch.typology_master ty on ty.typology_id = np.typology_id\r\n"
			+ "	group by np.project_id ) nptm on np.id= nptm.project_id\r\n"
			+ "	inner join soch.state s on s.id=np.state_id \r\n"
			+ "	inner join soch.district d on d.id = np.district_id\r\n"
			+ "	where np.facility_id =:facilityId and np.is_delete= false  and(lower(np.project_name) Like %:searchText% or lower(np.project_type) Like %:searchText%)  \r\n"
			+ "	group by np.id,nptm.project_id) asd group by count")
	int findCountByFacilityIdSearch(@Param("facilityId") Long facilityId,@Param("searchText") String searchText);
	
}
