package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.IndentRequestStatusMaster;

/**
 * @date 2019-Dec-31 9:52:31 AM
 */

@Repository
public interface IndentRequestStatusMasterRepository extends JpaRepository<IndentRequestStatusMaster, Long> {

	/**
	 * @param indentRequestStatusName
	 * @return
	 */
	@Query(nativeQuery=true,value="select count(id) from soch.indent_request_status_master where LOWER(indent_request_status_name) = LOWER(?1) and id!=?2")
	int existsByIndentRequestStatusNameInEdit(String indentRequestStatusName, Long id);

	@Query(nativeQuery=true,value="select count(id) from soch.indent_request_status_master where LOWER(indent_request_status_name) = LOWER(?1)")
	int existsByOtherIndentRequestStatusNameInAdd(String indentRequestStatusName);

	List<IndentRequestStatusMaster> findByIsDelete(Boolean isDelete);

	IndentRequestStatusMaster findByIndentRequestStatusNameAndIsDelete(String indentRequestStatusName, Boolean isDelete);

}
