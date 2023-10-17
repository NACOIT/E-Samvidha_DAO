/**
 * 
 */
package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterSocialWelfare;
import gov.naco.soch.projection.SocialWelfareProjection;

/**
 * @author Pranav MS (144958)
 * @email pranav.sasi@ust-global.com
 * @date 2020-Jun-21 12:11:55 pm 
 * 
 */
@Repository
public interface MasterSocialWelfareRepository  extends JpaRepository<MasterSocialWelfare, Long>{
	List<MasterSocialWelfare> findByIsDelete(Boolean isDelete);
	
	@Query(nativeQuery = true,value = "select * from soch.master_social_welfare where state_id=:stateId and is_delete=false and is_active=true")
	List<MasterSocialWelfare> findByIsDeleteAndStateId(@Param("stateId")Long stateId);

	@Query(nativeQuery = true,value = "select msw.id as id,msw.code as code,msw.name as name,msw.description as description,msw.state_id as stateId,s.name as stateName " + 
			" from soch.master_social_welfare as msw join soch.state as s on s.id=msw.state_id where msw.is_active =true and msw.is_delete =false ")
	List<SocialWelfareProjection> findAllSocialWelfareList();
	
	@Query(nativeQuery = true, value = "select count(msw.id) from soch.master_social_welfare as msw where msw.is_delete = false and  LOWER(msw.name)=LOWER(:name) and msw.state_id =:stateId")
	int existsByOtherName(@Param("name") String name,@Param("stateId") Integer stateId);

	/**
	 * @param name
	 * @param stateId
	 * @param id
	 * @return
	 */
	@Query(nativeQuery = true, value = "select count(msw.id) from soch.master_social_welfare as msw where msw.is_delete = false and  LOWER(msw.name)=LOWER(:name) and msw.state_id =:stateId and msw.id !=:id")
	int existsByOtherNameAndState(@Param("name") String name,@Param("stateId") Integer stateId,@Param("id")Long id);

}
