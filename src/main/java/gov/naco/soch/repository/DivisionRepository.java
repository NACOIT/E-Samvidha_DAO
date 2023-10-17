package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Division;
import gov.naco.soch.projection.DivisionProjection;

/**
 * Repository class that deals with Division Entity
 *
 */
@Repository
public interface DivisionRepository extends JpaRepository<Division, Long>, CustomRepository {
	boolean existsByNameIgnoreCase(String name);

	List<Division> findByIsDeleteOrderByIdAsc(Boolean isDelete);

	@Query(nativeQuery = true, value = "select count(id) from soch.division where LOWER(name) = LOWER(?1) and id!=?2 and is_delete=false")
	int existsByNameInEdit(String name, Long id);

	@Query(nativeQuery = true, value = "select count(id) from soch.division where is_delete = false and LOWER(name) = LOWER(?1)")
	int existsByOtherNameInEdit(String name);

	@Query(nativeQuery = true, value = "select count(division_id) from soch.user_master where division_id =?1 and is_delete=false")
	int findDeleteUser(Long divisionId);

	@Query(nativeQuery = true, value = "select id,name from soch.division where is_delete=false and is_active=true order by name asc")
	List<Object[]> findBasicDivisionList();

	@Query(nativeQuery = true, value = "select distinct on(id,code,name) \r\n"
			+ "d.id as id,d.code as code,d.name as divisionName, CAST(array_agg(distinct(concat(f.facility_type_name))) as character varying) as facilityTypes, \r\n"
			+ "CAST(concat(um.firstname,' ',um.lastname) as character varying) as contactPerson,um.mobile_number as contactNumber,um.email as contactEmail,"
			+ "d.npo_name as npoName,d.npo_email_id as npoEmail,d.is_active as isActive from soch.division d \r\n"
			+ "left join soch.facility_type_division_mapping ftdm on d.id=ftdm.division_id and ftdm.is_delete=false  \r\n"
			+ "left join soch.facility_type f on ftdm.facility_type_id=f.id and f.is_delete=false \r\n"
			+ "left join soch.division_admin_division_mapping dadm on d.id=dadm.division_id and dadm.is_delete=false and dadm.is_active=true \r\n"
			+ "left join soch.user_master um on dadm.user_id=um.id and um.is_delete=false and um.is_active=true \r\n"
			+ "where d.is_delete=false group by d.id,um.id,d.code,d.name,um.firstname,um.lastname,um.mobile_number,um.email,d.npo_name,d.npo_email_id,d.is_active order by d.id desc")
	List<DivisionProjection> findDivisionList();

	Division findByIdAndIsDelete(Long divisionId, Boolean false1);
	
	@Query(nativeQuery = true, value = "select division_id from soch.facility_type_division_mapping where facility_type_id =?1 and is_active=true and is_delete=false")
	int getDivisionByFacTypeId(Long facilityTypeId);

}
