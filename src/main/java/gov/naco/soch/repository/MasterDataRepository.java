package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterData;
import gov.naco.soch.entity.MasterPrisonQuestion;
import gov.naco.soch.projection.MinimasterProjection;

@Repository
public interface MasterDataRepository extends JpaRepository<MasterData, Long> {

	@Query(nativeQuery = true, value = "select m.* from master_data m where m.master_type='BATCH_NO_OPT'")
	List<MasterData> findAllBatchNoOptions();
	
	@Query(nativeQuery = true, value = "select m.* from master_data m where m.master_type='REGIMEN_ADULT_PED'")
	List<MasterData> findRegimenAdultPedOptions();
	
	@Query(nativeQuery = true, value = "select m.* from master_data m where m.master_type='REGIMEN_1_2_LINE'")
	List<MasterData> findRegimenLineOptions();
	
	@Query(nativeQuery = true, value = "select m.* from master_data m where m.master_type=:masterType")
	List<MasterData> findMasterDataOptions(@Param("masterType") String masterType);
	
	@Query(nativeQuery=true,value="select id,name from soch.minimaster(:tablename)")
	List<MinimasterProjection> getValues(@Param("tablename")String tablename); 

//	@Query(nativeQuery=true,value="select id,name from soch.minimaster(soch.list_to_array(:tablenames))")
//	List<MinimasterProjection> getMinimasters(@Param("tablenames")List<String> tables);
	
	@Query(nativeQuery=true,value="select id, status as itemName from soch.master_batch_status")
	List<MinimasterProjection> getBatchStatusValues(); 
	
	@Query(nativeQuery=true,value="select mtt.id, mtt.test_type as itemName from soch.master_test_type mtt where mtt.lab_type = 'EID'")
	List<MinimasterProjection> getTestTypeValues(); 
	
	@Query(nativeQuery=true,value="select id, status as itemName from soch.master_result_status")
	List<MinimasterProjection> getResultStatusValues(); 
	
	@Query(nativeQuery=true,value="select id, name as itemName from soch.master_delete_reason")
	List<MinimasterProjection> getDeleteReasonValues();

}
