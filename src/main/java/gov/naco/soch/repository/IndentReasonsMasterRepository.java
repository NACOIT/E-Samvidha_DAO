/**
 * 
 */
package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.IndentReasonsMaster;

/**
 * @date 2020-Jan-01 12:04:29 PM
 */

// Repository mapped with entity class
@Repository
public interface IndentReasonsMasterRepository extends JpaRepository<IndentReasonsMaster, Long> {

	/**
	 * @param indentReasonsName
	 * @return
	 */

	@Query(nativeQuery=true,value="select count(id) from soch.indent_reasons_master where LOWER(indent_reasons_name) = LOWER(?1) and id!=?2")
	int existsByIndentReasonsNameInEdit(String indentReasonsName, Long id);

	@Query(nativeQuery=true,value="select count(id) from soch.indent_reasons_master where LOWER(indent_reasons_name) = LOWER(?1)")
	int existsByOtherIndentReasonsNameInAdd(String indentReasonsName);

	List<IndentReasonsMaster> findByIsDeleteOrderByIndentReasonsNameAsc(Boolean false1);
}
