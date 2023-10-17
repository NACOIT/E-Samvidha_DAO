package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Regimen;
import gov.naco.soch.projection.MobileRegimenForPillReminderProjection;

@Repository
public interface RegimenRepository extends JpaRepository<Regimen, Long>, CustomRepository {

	@Query(nativeQuery = true, value = "select count(id) from soch.regimen where is_delete = false and LOWER(regimen_name)=LOWER(:regimenName) and id!=:id ")
	int countRegimentInEdit(@Param("regimenName") String regimenName, @Param("id") Long id);

	@Query(nativeQuery = true, value = "select count(id) from soch.regimen where is_delete = false and LOWER(regimen_name)=LOWER(:regimenName) ")
	int countRegimentInAdd(@Param("regimenName") String regimenName);

	@Query(nativeQuery = true, value = "select distinct on(r.id) r.id as regimenid,r.regimen_name,r.is_active,ap.id as adultid,ap.name as adultname,li.id as lineid,li.name as linename,\r\n"
			+ "CAST(array_agg(distinct(concat(rc.id,',',p.id,',',p.product_name,',',rc.quantity,',',pum.id,',',pum.uom_name)))as character varying)  as constituent  \r\n"
			+ "from soch.regimen r \r\n"
			+ "left join soch.regimen_constituent rc on r.id = rc.regimen_id and rc.is_delete =false  \r\n"
			+ "left join soch.product p on rc.product_id =p.id  and p.is_delete =false and p.is_active = true \r\n"
			+ "left join soch.product_uom_master pum on p.uom_id =pum.id and pum.is_delete = false and pum.is_active = true \r\n"
			+ "left join soch.master_data ap on r.adult_ped =ap.id and ap.is_delete =false \r\n"
			+ "left join soch.master_data li on r.line =li.id and li.is_delete =false \r\n"
			+ "where r.is_delete = false \r\n" + "group by r.id,ap.id,li.id order by r.id desc")
	List<Object[]> findRegimenList();

	@Query(nativeQuery = true, value = "select r.* from soch.regimen r \r\n" + 
			"join soch.regimen_constituent rc on r.id = rc.regimen_id \r\n" + 
			"where r.id !=:regimenId and rc.product_id IN :requestProductIds and rc.is_delete=false and r.is_delete = false group by r.id ")
	List<Regimen> findRegimenForDuplicateCheckInEdit(@Param("requestProductIds") List<Long> requestProductIds,@Param("regimenId") Long regimenId);

	@Query(nativeQuery = true, value = "select r.* from soch.regimen r \r\n" + 
			"join soch.regimen_constituent rc on r.id = rc.regimen_id \r\n" + 
			"where rc.product_id IN :requestProductIds and rc.is_delete=false and r.is_delete = false group by r.id ")
	List<Regimen> findRegimenForDuplicateCheckInSave(@Param("requestProductIds") List<Long> requestProductIds);

	
	@Query(nativeQuery = true, value = "SELECT\r\n" + 
			"abcd.regimen_id regimenId,\r\n" + 
			"abcd.beneficiary_id as beneficiaryId,\r\n" + 
			"reg.regimen_name as regimenName,\r\n" + 
			"'ART' as regimenSource\r\n" + 
			"FROM soch.art_beneficiary_clinical_details abcd\r\n" + 
			"join soch.regimen reg ON reg.id = abcd.regimen_id\r\n" + 
			"join soch.beneficiary_visit_register visit on visit.id = abcd.visit_register_id\r\n" + 
			"where abcd.regimen_id is not null\r\n" + 
			"and visit.beneficiary_id = :beneficiaryId\r\n" + 
			"order by visit.visit_date desc limit 1")
	List<MobileRegimenForPillReminderProjection> getArtRegimenDetailsForBeneficiary(@Param("beneficiaryId")Long beneficiaryId);
	
	@Query(nativeQuery = true, value = "select ipt.tb_regimen_id as regimenId, visit.beneficiary_id as beneficiaryId,\r\n" + 
			"tbregimen.name as regimenName,\r\n" + 
			"'TB' as regimenSource \r\n" + 
			"from soch.beneficiary_visit_register visit\r\n" + 
			"join soch.art_beneficiary_ipt_att_details ipt on ipt.visit_register_id = visit.id\r\n" + 
			"join soch.master_tb_regimen tbregimen on tbregimen.id = ipt.tb_regimen_id\r\n" + 
			"where ipt.tb_regimen_id is not null\r\n" + 
			"and visit.beneficiary_id = :beneficiaryId\r\n" + 
			"order by visit.visit_date desc limit 1")
	List<MobileRegimenForPillReminderProjection> getTbRegimenDetailsForBeneficiary(@Param("beneficiaryId")Long beneficiaryId);

}
