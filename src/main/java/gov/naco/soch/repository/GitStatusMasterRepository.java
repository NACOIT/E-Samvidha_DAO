/**
 * 
 */
package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.GitStatusMaster;

/**
 * @date 2020-Dec-30 12:35:36 PM
 */

// Repository mapped with entity class
@Repository
public interface GitStatusMasterRepository extends JpaRepository<GitStatusMaster, Long> {

	/**
	 * @param gitStatusName
	 * @return
	 */
	boolean existsByGitStatusNameIgnoreCase(String gitStatusName);

	@Query(nativeQuery=true,value="select count(id) from soch.git_status_master where LOWER(git_status_name) = LOWER(?1) and id!=?2")
	int existsByGitStatusNameInEdit(String gitStatusName, Long id);

	@Query(nativeQuery=true,value="select count(id) from soch.git_status_master where LOWER(git_status_name) = LOWER(?1)")
	int existsByOtherGitStatusNameInAdd(String gitStatusName);
}
