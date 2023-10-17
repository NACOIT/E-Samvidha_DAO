package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Indent;
import gov.naco.soch.projection.IndentDetailsProjection;
import gov.naco.soch.projection.IndentListProjection;

@Repository
public interface IndentRepository
		extends JpaRepository<Indent, Long>, PagingAndSortingRepository<Indent, Long>, CustomRepository {

	Indent findByIndentNumber(String indentNumber);

	Indent findByIndentNumberAndIndentProducts_Product_IdNotIn(String indentNumber, List<Long> contractProductIds);

	List<Indent> findAllByIsDeleteOrderByIndentIdDesc(boolean b);

	List<Indent> findAllByIsDelete(boolean b);

	@Query(nativeQuery = true, value = "select i.indent_id as indentId,i.indent_number as indentNumber,\r\n"
			+ "i.indent_date as indentDate,i.indent_status_id as indentStatusId,ism.status as indentStatus,\r\n"
			+ "i.procurement_agent_id as procurementAgentId,pr.name as procurementAgentName from soch.indent i\r\n"
			+ "join soch.indent_status_master ism on(ism.id=i.indent_status_id)\r\n"
			+ "LEFT OUTER JOIN soch.facility pr on(i.procurement_agent_id=pr.id)\r\n"
			+ "where i.created_by=:userId and i.is_delete=false")
	Page<IndentListProjection> findAllByCreatedByAndIsDelete(@Param("userId") Long userId, Pageable paging);

	@Query(nativeQuery = true, value = "select distinct on(i.indent_id) i.indent_id as indentId,i.indent_number as indentNumber,\r\n"
			+ "i.indent_date as indentDate,i.indent_status_id as indentStatusId,ism.status as indentStatus,\r\n"
			+ "i.procurement_agent_id as procurementAgentId,pr.name as procurementAgentName from soch.indent i\r\n"
			+ "join soch.indent_status_master ism on(ism.id=i.indent_status_id)\r\n"
			+ "LEFT OUTER JOIN soch.facility pr on(i.procurement_agent_id=pr.id)\r\n"
			+ "join soch.indent_product ip on(i.indent_id=ip.indent_id) join soch.product p on (ip.product_id=p.id)\r\n"
			+ "where i.created_by=:userId and i.is_delete=false and (LOWER(i.indent_number) like :searchValue% OR p.product_name like :searchValue%)",
			countQuery="select count(distinct(i.indent_id)) from soch.indent i\r\n"
					+ "join soch.indent_status_master ism on(ism.id=i.indent_status_id)\r\n"
					+ "LEFT OUTER JOIN soch.facility pr on(i.procurement_agent_id=pr.id)\r\n"
					+ "join soch.indent_product ip on(i.indent_id=ip.indent_id) join soch.product p on (ip.product_id=p.id)\r\n"
					+ "where i.created_by=:userId and i.is_delete=false and (LOWER(i.indent_number) like :searchValue% OR p.product_name like :searchValue%)")
	Page<IndentListProjection> findAllByCreatedByAndIsDeleteByNormalSearch(@Param("userId") Long userId,
			@Param("searchValue") String searchValue, Pageable paging);

	List<Indent> findAllByCreatedByOrIndentStatusMaster_IdInAndIsDeleteOrderByIndentIdDesc(Long userId,
			List<Long> indentStatusMasterIds, boolean b);

	@Query(nativeQuery = true, value = "select  i.indent_id as indentId,i.indent_number as indentNumber,i.indent_date as indentDate,\r\n"
			+ "i.indent_status_id as indentStatusId,ism.status as indentStatus,i.procurement_agent_id as procurementAgentId,"
			+ "pr.name as procurementAgentName from soch.indent i\r\n"
			+ "join soch.user_master u on(u.id=i.created_by) join soch.facility f on(f.id=u.facility_id)\r\n"
			+ "join soch.indent_status_master ism on(ism.id=i.indent_status_id)\r\n"
			+ "join soch.user_role_mapping urm on(u.id=urm.user_id)\r\n"
			+ "LEFT OUTER JOIN soch.facility pr on(i.procurement_agent_id=pr.id)\r\n"
			+ "where ((urm.role_id in (2,10)) or (f.id=:facilityId AND i.indent_status_id IN :indentStatusMasterIds)) AND i.is_delete=false")
	Page<IndentListProjection> findAllNacoIndents(@Param("facilityId") Long facilityId,
			@Param("indentStatusMasterIds") List<Long> indentStatusMasterIds, Pageable paging);
	
	@Query(nativeQuery = true, value = "select distinct on(i.indent_id)  i.indent_id as indentId,i.indent_number as indentNumber,i.indent_date as indentDate,\r\n"
			+ "i.indent_status_id as indentStatusId,ism.status as indentStatus,i.procurement_agent_id as procurementAgentId,"
			+ "pr.name as procurementAgentName from soch.indent i\r\n"
			+ "join soch.user_master u on(u.id=i.created_by) join soch.facility f on(f.id=u.facility_id)\r\n"
			+ "join soch.indent_status_master ism on(ism.id=i.indent_status_id)\r\n"
			+ "join soch.user_role_mapping urm on(u.id=urm.user_id)\r\n"
			+ "LEFT OUTER JOIN soch.facility pr on(i.procurement_agent_id=pr.id)\r\n"
			+ "join soch.indent_product ip on(i.indent_id=ip.indent_id) join soch.product p on (ip.product_id=p.id)\r\n"
			+ "where ((urm.role_id in (2,10)) or (f.id=:facilityId AND i.indent_status_id IN :indentStatusMasterIds)) AND i.is_delete=false\r\n"
			+ "and (LOWER(i.indent_number) like :searchValue% OR LOWER(p.product_name) like :searchValue%) ",
			countQuery="select count(distinct(i.indent_id)) from soch.indent i\r\n"
					+ "join soch.user_master u on(u.id=i.created_by) join soch.facility f on(f.id=u.facility_id)\r\n"
					+ "join soch.indent_status_master ism on(ism.id=i.indent_status_id)\r\n"
					+ "join soch.user_role_mapping urm on(u.id=urm.user_id)\r\n"
					+ "LEFT OUTER JOIN soch.facility pr on(i.procurement_agent_id=pr.id)\r\n"
					+ "join soch.indent_product ip on(i.indent_id=ip.indent_id) join soch.product p on (ip.product_id=p.id)\r\n"
					+ "where ((urm.role_id in (2,10)) or (f.id=:facilityId AND i.indent_status_id IN :indentStatusMasterIds)) AND i.is_delete=false\r\n"
					+ "and (LOWER(i.indent_number) like :searchValue% OR LOWER(p.product_name) like :searchValue%) ")
	Page<IndentListProjection> findAllNacoIndentsByNormalSearch(@Param("facilityId") Long facilityId,
			@Param("indentStatusMasterIds") List<Long> indentStatusMasterIds,@Param("searchValue") String searchValue,
			Pageable paging);


	@Query(nativeQuery = true, value = "select i.indent_id as indentId,i.indent_number as indentNumber,\r\n"
			+ "i.indent_date as indentDate,i.indent_status_id as indentStatusId,ism.status as indentStatus,\r\n"
			+ "pr.name as procurementAgentName from soch.indent i join soch.indent_status_master ism on(ism.id=i.indent_status_id)\r\n"
			+ "LEFT OUTER JOIN soch.facility pr on(i.procurement_agent_id=pr.id)\r\n"
			+ "where i.indent_status_id=:id and i.procurement_agent_id=:facilityId")
	Page<IndentListProjection> findAllByIndentStatusMaster_IdAndProcurementAgent_Id(@Param("id") long id,
			@Param("facilityId") Long facilityId, Pageable paging);
	
	@Query(nativeQuery = true, value = "select distinct on(i.indent_id) i.indent_id as indentId,i.indent_number as indentNumber,\r\n"
			+ "i.indent_date as indentDate,i.indent_status_id as indentStatusId,ism.status as indentStatus,\r\n"
			+ "pr.name as procurementAgentName from soch.indent i join soch.indent_status_master ism on(ism.id=i.indent_status_id)\r\n"
			+ "LEFT OUTER JOIN soch.facility pr on(i.procurement_agent_id=pr.id)\r\n"
			+ "join soch.indent_product ip on(i.indent_id=ip.indent_id) join soch.product p on (ip.product_id=p.id)\r\n"
			+ "where i.indent_status_id=:id and i.procurement_agent_id=:facilityId \r\n"
			+ "and (LOWER(i.indent_number) like :searchValue% OR p.product_name like :searchValue%)",
			countQuery="select count(distinct(i.indent_id)) from soch.indent i join soch.indent_status_master ism on(ism.id=i.indent_status_id)\r\n"
					+ "LEFT OUTER JOIN soch.facility pr on(i.procurement_agent_id=pr.id)\r\n"
					+ "join soch.indent_product ip on(i.indent_id=ip.indent_id) join soch.product p on (ip.product_id=p.id)\r\n"
					+ "where i.indent_status_id=:id and i.procurement_agent_id=:facilityId \r\n"
					+ "and (LOWER(i.indent_number) like :searchValue% OR p.product_name like :searchValue%)")
	Page<IndentListProjection> findAllByIndentStatusMaster_IdAndProcurementAgent_IdByNormalSearch(@Param("id") long id,
			@Param("facilityId") Long facilityId,@Param("searchValue") String searchValue, Pageable paging);


	@Query(nativeQuery = true, value = "select i.indent_id as indentId,i.indent_number as indentNumber,\r\n"
			+ "i.indent_date as indentDate,i.indent_status_id as indentStatusId,ism.status as indentStatus,i.reject_remarks as remarks,\r\n"
			+ "u.firstname as user,i.rejected_time as remarkTime "
			+ "from soch.indent i join soch.indent_status_master ism on(ism.id=i.indent_status_id)\r\n"
			+ "left join soch.user_master u on(i.rejected_by=u.id) "
			+ "where i.indent_id=:indentId")
	IndentDetailsProjection findIndentById(@Param("indentId") Long indentId);

	@Query(nativeQuery = true, value = "select i.indent_id as indentId,i.indent_number as indentNumber\r\n"
			+ "from soch.indent i where i.is_delete=false order by i.indent_number asc")
	List<IndentListProjection> findAllIndentNumber();

	@Query(value = "select i.indent_id as indentId,i.indent_number as indentNumber from soch.indent as i where i.indent_status_id in(2,5) and i.is_delete=false order by i.indent_number asc", nativeQuery = true)
	List<IndentListProjection> findAllApprovedAndPushedIndents();

	@Query(value = "select i.indent_id as indentId,i.indent_number as indentNumber from soch.indent as i where i.indent_status_id = 5 and i.procurement_agent_id=:facilityId and i.is_delete=false order by i.indent_number asc", nativeQuery = true)
	List<IndentListProjection> findAllPushedIndents(@Param("facilityId") Long facilityId);

	@Query(value = "select i.* from soch.indent as i where i.indent_status_id in(2,5) and i.is_delete=false", nativeQuery = true)
	List<Indent> findAllApprovedIndents();

	@Query(nativeQuery = true, value = "select i.procurement_agent_id as procurementAgentId,f.name as procurementAgentName \r\n"
			+ "from soch.indent i join soch.facility f\r\n"
			+ "on(i.procurement_agent_id=f.id) where f.id IN :procurementIds")
	List<IndentListProjection> findProcurementAgents(@Param("procurementIds") List<Long> procurementIds);

	@Query(nativeQuery = true, value = "select i.indent_id from soch.indent i where i.indent_number=:indentNumber")
	Long findIndentIdByIndentNumber(@Param("indentNumber") String indentNumber);

	@Query("select i from Indent i where i.indentId=:indentId")
	Optional<Indent> findById(@Param("indentId") Long indentId);


	
	
}
