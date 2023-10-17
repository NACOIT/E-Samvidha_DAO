package gov.naco.soch.repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import gov.naco.soch.projection.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.entity.BeneficiaryClinicalTreatment;

@Repository
public interface BeneficiaryClinicalTreatmentRepository 
	extends JpaRepository<BeneficiaryClinicalTreatment,Long>, JpaSpecificationExecutor<BeneficiaryClinicalTreatment>,CustomRepository{




	 @Query(value = " select b.uid as uid ,CONCAT( b.first_name,' ', b.last_name ) as name, tb.ti_code as tiCode , tm.typology_name as typology,\r\n" + 
	            "b.date_of_birth as dateOfBirth , b.death_date as DeathDate,mg.name as gender ,mcst.name as status,min(bct.treatment_date) as diagnosisDate , \r\n" + 
	            "tb.beneficiary_id as beneficiaryId ,tb.id as tbId ,tb.date_of_reg as registrationDate \r\n" + 
	            "from soch.ti_beneficiary tb   \r\n" + 
	            "join soch.beneficiary b on b.id = tb.beneficiary_id   \r\n" + 
	            "join soch.typology_master tm on tm.typology_id  = tb.master_hrg_primary_id   \r\n" + 
	            "join soch.master_gender mg on mg.id = b.gender_id   \r\n" + 
	            "join soch.master_client_status_ticore mcst on mcst.id = tb.status_id   \r\n" + 
	            "join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = tb.beneficiary_id   \r\n" + 
	            "left join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = tb.beneficiary_id  \r\n" + 
	            "where  (tb.beneficiary_id , bct.treatment_date,bct.clinical_treatment_type_id) not in    \r\n" + 
	            "(select sti.beneficiary_id , sbct.treatment_date,sbct.clinical_treatment_type_id  from soch.ti_beneficiary sti    \r\n" + 
	            "join soch.beneficiary_clinical_treatment sbct on sbct.beneficiary_id=sti.beneficiary_id    \r\n" + 
	            "and (sbct.treatment_date +(INTERVAL '1 day' * sbct.rmc_followup_frequency)) >current_date)   \r\n" + 
	            "and bfm.facility_id =:facilityId and tb.facility_id =:facilityId and tb.is_deleted = false and coalesce(bct.is_delete,'false') = false and tm.typology_id not in (5,6)\r\n" + 
	            "and( '' like :param or b.ti_benf_search_str ilike :param ) \r\n"+
	            "and( '' like '' or b.mobile_number like :paramMobile ) \r\n"+
	            "and (0=:typologyId or tm.typology_id=:typologyId)  \r\n" +
	            "group by b.uid , b.first_name , b.last_name ,tb.ti_code , tm.typology_name ,b.date_of_birth ,\r\n" + 
	            "mg.name ,mcst.name ,tb.beneficiary_id , tb.id ,tb.date_of_reg,b.death_date,b.age",
	            nativeQuery = true)
	    Page<RmcDueListProjection> getRMCDueList(@Param("facilityId") Long facilityId , Pageable pageable , @Param("param") String param, @Param("paramMobile") String paramMobile, @Param("typologyId") Long typologyId);
	    
	
	@Query(value = "select b.id as beneficiaryId,b.uid as uid ,CONCAT( b.first_name,' ', b.last_name ) as name,b.date_of_birth as dateOfBirth,b.death_date as DeathDate , tm.typology_name as typology , \r\n" +
			"tb.ti_code as tiCode ,mg.name as gender, mcst.name as masterClientStatus,mct.name as infection, bct.treatment_date as diagnosisDate ,mct.id as treatmentTypeId \r\n" +
			",bsrt.sti_rti_diagnosis_type_id as diagnosisTypeId ,msrdt.name as diagnosisTypeName, bsrt.treatment_record_count as treatmentRecordCount \r\n" +
			"from soch.beneficiary b\r\n" +
			"join soch.ti_beneficiary tb on tb.beneficiary_id = b.id\r\n" +
			"join soch.typology_master tm on tm.typology_id = tb.master_hrg_primary_id \r\n" +
			"join soch.master_gender mg on mg.id = b.gender_id\r\n" +
			"join soch.master_client_status_ticore mcst on mcst.id = tb.status_id   \r\n" + 
			"join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = b.id\r\n" +
			"join soch.master_clinical_treatment_type mct on mct.id = bct.clinical_treatment_type_id\r\n" +
			"left join soch.beneficiary_sti_rti_treatment_details bsrt on bct.id = bsrt.clinical_treatment_id\r\n" +
			"left join soch.beneficiary_abscess_treatment_details batd on bct.id = batd.clinical_treatment_id\r\n" +
			"left join soch.beneficiary_opioid_overdose_treatment_details botd on bct.id = botd.clinical_treatment_id \r\n" +
			"left join soch.master_diagnosis_type msrdt on msrdt.id = bsrt.sti_rti_diagnosis_type_id \r\n" +
			"where bct.facility_id = :facilityId and tb.is_deleted = false and bct.is_delete = false and b.is_delete = false and mct.id !=4  \r\n" +
			"and ( ( bsrt.is_treatment_completed=true and bsrt.is_delete = false and bsrt.next_followup_date is null ) " + 
			"or ( bsrt.is_treatment_completed=true and bsrt.is_delete = false and bsrt.sti_rti_diagnosis_type_id = 7 ) \r\n" +
			"or ( batd.is_treatment_completed=true and batd.is_delete = false ) \r\n" +
			"or ( botd.is_treatment_completed=true and botd.is_delete = false ) ) \r\n" +
			"and (0=:genderId or mg.id=:genderId) and (0=:treatmentType or mct.id=:treatmentType) and (0=:typologyId or tm.typology_id=:typologyId) \r\n" +
			"and ((bct.treatment_date >=cast(:startdateOfDiagnosis as date) OR CAST(CAST(:startdateOfDiagnosis AS TEXT) AS date) IS NULL) AND (bct.treatment_date <= cast(:enddateOfDiagnosis as date) OR CAST(CAST(:enddateOfDiagnosis AS TEXT) AS date) IS NULL)) and (b.uid ilike %:param% or '' like %:param% or tb.ti_code ilike %:param% or b.first_name ilike %:param%  or b.middle_name ilike %:param% or b.last_name ilike %:param% or b.mobile_number ilike %:param% or CONCAT( b.first_name,' ', b.last_name ) ilike %:param%)"
			,nativeQuery = true)
	Page<CompletedTreatmentListProjection> getCompletedTreatmentList(@Param("facilityId") Long facilityId, Pageable pageable,
																	 @Param("genderId") Long genderId, @Param("typologyId") Long typologyId, @Param("treatmentType") Long treatmentType ,@Param("startdateOfDiagnosis")LocalDate startdateOfDiagnosis,@Param("enddateOfDiagnosis")LocalDate enddateOfDiagnosis,@Param("param") String param);

	@Query(value = " select distinct b.id as beneficiaryId,b.uid as uid ,CONCAT( b.first_name,' ', b.last_name ) as name,b.date_of_birth as dateOfBirth,b.death_date as DeathDate, \r\n"
			+ " b.mobile_number as mobileNumber,b.first_name as firstName,b.middle_name as middleName,b.last_name as lastName,  " + 
			"b.dsrc_beneficiary_code as dsrcCode ,mg.name as gender, mcst.name as masterClientStatus,mct.name as infection, bct.treatment_date as diagnosisDate ,mct.id as treatmentTypeId \r\n"
			+ ",bsrt.sti_rti_diagnosis_type_id as diagnosisTypeId ,msrdt.name as diagnosisTypeName, bsrt.treatment_record_count as treatmentRecordCount " + 
			"from soch.beneficiary b \r\n" + 
			"join soch.dsrc_beneficiary tb on tb.beneficiary_id = b.id and tb.facility_id = :facilityId \r\n" + 
			"join soch.master_gender mg on mg.id = b.gender_id \r\n" + 
			"join soch.master_dsrc_beneficiary_status mcst on mcst.id = tb.benficiary_status_id    \r\n" + 
			"join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = b.id \r\n" + 
			"join soch.master_clinical_treatment_type mct on mct.id = bct.clinical_treatment_type_id \r\n" + 
			"left join soch.beneficiary_sti_rti_treatment_details bsrt on bct.id = bsrt.clinical_treatment_id \r\n" + 
			"left join soch.beneficiary_syphilis_treatment_details  batd on bct.id = batd.clinical_treatment_id \r\n" + 
			"left join soch.master_diagnosis_type msrdt on msrdt.id = bsrt.sti_rti_diagnosis_type_id \r\n" + 
			"where bct.facility_id = :facilityId and tb.is_delete = false and bct.is_delete = false and b.is_delete = false and mct.id !=4  \r\n" + 
			"and ( ( bsrt.is_treatment_completed=true and bsrt.is_delete = false and bsrt.next_followup_date is null ) \r\n " +
			"or ( bsrt.is_treatment_completed=true and bsrt.is_delete = false and bsrt.sti_rti_diagnosis_type_id = 7 ) " + 
			"or ( batd.is_treatment_completed=true and batd.is_delete = false) ) \r\n" + 
			"and (0=:genderId or mg.id=:genderId) \r\n" + 
			"and (0=:treatmentType or mct.id=:treatmentType) \r\n" + 
			"and ((bct.treatment_date >=cast(:startdateOfDiagnosis as date) OR CAST(CAST(:startdateOfDiagnosis AS TEXT) AS date) IS NULL) AND (bct.treatment_date <= cast(:enddateOfDiagnosis as date) OR CAST(CAST(:enddateOfDiagnosis AS TEXT) AS date) IS NULL))  "
					,nativeQuery = true)
	Page<CompletedTreatmentListProjection> getCompletedTreatmentListDsrc(@Param("facilityId") Long facilityId, Pageable pageable,
																	 @Param("genderId") Long genderId, @Param("treatmentType") Long treatmentType ,@Param("startdateOfDiagnosis")LocalDate startdateOfDiagnosis,@Param("enddateOfDiagnosis")LocalDate enddateOfDiagnosis);

	@Query(value = "select  b.id as beneficiaryId,b.uid as uid ,CONCAT( b.first_name,' ', b.last_name ) as name,b.date_of_birth as dateOfBirth ,b.death_date as DeathDate, tm.typology_name as typology ,  \r\n" + 
			"tb.ti_code as tiCode ,mg.name as gender, mcst.name as masterClientStatus,mct.name as infection, min(bct.treatment_date) as diagnosisDate, \r\n" + 
			"bct.clinical_treatment_type_id as treatmentTypeId ,string_agg(distinct msrdt.name,',') as diagnosisType \r\n" + 
			"from soch.beneficiary b    \r\n" + 
			"join soch.ti_beneficiary tb on tb.beneficiary_id = b.id    \r\n" + 
			"join soch.typology_master tm on tm.typology_id  = tb.master_hrg_primary_id    \r\n" + 
			"join soch.master_gender mg on mg.id = b.gender_id    \r\n" + 
			"join soch.master_client_status_ticore mcst on mcst.id = tb.status_id   \r\n" + 
			"join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = b.id    \r\n" + 
			"join soch.master_clinical_treatment_type mct on mct.id = bct.clinical_treatment_type_id    \r\n" + 
			"left join soch.beneficiary_sti_rti_treatment_details bsrtd on bct.id = bsrtd.clinical_treatment_id    \r\n" + 
			"join soch.master_diagnosis_type msrdt on msrdt.id = bsrtd.sti_rti_diagnosis_type_id   \r\n" + 
			"where bct.facility_id =:facilityId and tb.is_deleted = false and bct.is_delete = false and b.is_delete = false \r\n" + 
			"and bsrtd.is_treatment_completed=false and bsrtd.is_delete = false  and bsrtd.clinical_treatment_type_id = 1  \r\n" + 
			"and ((bct.treatment_date >=cast(:startdateOfDiagnosis as date) OR CAST(CAST(:startdateOfDiagnosis AS TEXT) AS date) IS NULL) AND (bct.treatment_date <= cast(:enddateOfDiagnosis as date) OR CAST(CAST(:enddateOfDiagnosis AS TEXT) AS date) IS NULL)) and (b.uid ilike %:param% or '' like %:param% or tb.ti_code ilike %:param% or b.first_name ilike %:param%  or b.middle_name ilike %:param% or b.last_name ilike %:param% or b.mobile_number ilike %:param% or CONCAT( b.first_name,' ', b.last_name ) ilike %:param%)    \r\n" + 
			"and (0=:genderId or mg.id=:genderId) and (0=:treatmentType or mct.id=:treatmentType) and (0=:typologyId or tm.typology_id=:typologyId)  \r\n" + 
			" group by b.id,b.uid ,b.first_name,b.last_name,b.age ,tm.typology_name ,  \r\n" + 
			"tb.ti_code ,mg.name, mct.name ,mcst.name,bct.clinical_treatment_type_id,b.date_of_birth,b.death_date"
			,nativeQuery = true)
	Page<OngoingTreatmentListProjection> getOngoingTreatmentList(@Param("facilityId") Long facilityId, Pageable pageable, @Param("param") String param, @Param("typologyId") Long typologyId, @Param("genderId") Long genderId, @Param("treatmentType") Long treatmentType ,@Param("startdateOfDiagnosis")LocalDate startdateOfDiagnosis,@Param("enddateOfDiagnosis")LocalDate enddateOfDiagnosis);

	@Query(value = "select followup_frequency from soch.clinical_treatment_mapping ctm where ctm.diagnosis_type_id = :diagnosisId \r\n"
			+ "and ctm.facility_type_id=:facilityTypeId limit 1 ",nativeQuery = true) 
	  String findLatestFollowUpRecord(@Param("diagnosisId")Long diagnosisId,@Param("facilityTypeId")Long facilityTypeId);
	
	 @Query(value = "select fs.facility_id as facilityId, msrdpm.diagnosis_type_id as stiRtiDiasnosysTypeId, msrdt.name as stiRtiDiasnosysType,\r\n" + 
	 		"msrdpm.prod_id as productId,p.product_name as productName,fs.batch_number as batchNumber,fs.current_quantity as avaialableQty\r\n" + 
	 		"from\r\n" + 
	 		"soch.master_diagnosis_type msrdt\r\n" + 
	 		"join soch.clinical_treatment_mapping msrdpm on msrdt.id=msrdpm.diagnosis_type_id\r\n" + 
	 		"join soch.product p on msrdpm.prod_id=p.id\r\n" + 
	 		"join soch.facility_stock fs on msrdpm.prod_id=fs.product_id where fs.facility_id =:facilityId\r\n" + 
	 		"order by fs.facility_id,msrdpm.diagnosis_type_id,msrdpm.prod_id,fs.batch_number",nativeQuery = true) 
	  List<ProductListStiRti> getProdList(@Param("facilityId")Long facilityId);

	@Query(value = "select b.first_name as firstName, b.last_name as lastName, b.date_of_birth as dateOfBirth, mg.name as gender,sbsrtd.clinical_treatment_id as clinicalTrId,\n" +
			"sbsrtd.followup_date as followupDate, sbsrtd.next_followup_date as nextFollowupDate, sbsrtd.followup_cycle_count as followupCycleCount,\n" +
			"fs2.batch_number as batchnum,fs2.current_quantity as availableqty,sbsrtd.dispense_qty as dispenseQty,p.id as pid,p.product_name as pname, sbsrtd.is_treatment_completed as treatmentCompleted, fs2.expired_date as expiryDate "
			+ " ,sbsrtd.followup_date || ''|| sbsrtd.next_followup_date as concatDate "
			+ " from soch.beneficiary b\n" +
			"inner join soch.ti_beneficiary tb on tb.beneficiary_id = b.id\n" +
			"inner join soch.master_gender mg on mg.id = b.gender_id\n" +
			"inner join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = b.id\n" +
			"inner join soch.beneficiary_sti_rti_treatment_details sbsrtd on sbsrtd.clinical_treatment_id=bct.id\n" +
			"left join soch.facility_stock fs2 on fs2.id = sbsrtd.facility_stock_id\n" +
			"left join soch.product p on p.id = sbsrtd.sti_rti_prod_id\n" +
			"where b.uid = :uid and sbsrtd.sti_rti_diagnosis_type_id = :diagnosisTypeId and tb.is_deleted = false and bct.facility_id = :facilityId\n" +
			"and sbsrtd.is_treatment_completed=false  order by sbsrtd.followup_date asc", nativeQuery = true)
	List<OngoingReviewProjection> getOngoingData(@Param("uid")String uid, @Param("diagnosisTypeId")Long diagnosisTypeId, @Param("facilityId") Long facilityId);
	
	
	@Query(value = "select b.first_name as firstName, b.last_name as lastName, b.date_of_birth as dateOfBirth, mg.name as gender,sbsrtd.clinical_treatment_id as clinicalTrId,\n" +
			"sbsrtd.followup_date as followupDate, sbsrtd.next_followup_date as nextFollowupDate, sbsrtd.followup_cycle_count as followupCycleCount,\n" +
			"fs2.batch_number as batchnum,fs2.current_quantity as availableqty,sbsrtd.dispense_qty as dispenseQty,p.id as pid,p.product_name as pname, sbsrtd.is_treatment_completed as treatmentCompleted, fs2.expired_date as expiryDate "
			+ " ,sbsrtd.followup_date || ''|| sbsrtd.next_followup_date as concatDate "
			+ "from soch.beneficiary b\n" +
			"inner join soch.ti_beneficiary tb on tb.beneficiary_id = b.id\n" +
			"inner join soch.master_gender mg on mg.id = b.gender_id\n" +
			"inner join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = b.id\n" +
			"inner join soch.beneficiary_sti_rti_treatment_details sbsrtd on sbsrtd.clinical_treatment_id=bct.id\n" +
			"left join soch.facility_stock fs2 on fs2.id = sbsrtd.facility_stock_id\n" +
			"left join soch.product p on p.id = sbsrtd.sti_rti_prod_id\n" +
			"where b.uid = :uid and sbsrtd.sti_rti_diagnosis_type_id = :diagnosisTypeId and tb.is_deleted = false and bct.facility_id = :facilityId and sbsrtd.treatment_record_count=:treatmentRecordCount\n" +
			"and is_treatment_completed=true  order by sbsrtd.followup_date asc", nativeQuery = true)
	List<OngoingReviewProjection> getOngoingDataForCompleted(@Param("uid")String uid, @Param("diagnosisTypeId")Long diagnosisTypeId, @Param("facilityId") Long facilityId, @Param("treatmentRecordCount") Long treatmentRecordCount);
	
	
	
	@Query(value = "select fs.facility_id as facilityId, msrdpm.diagnosis_type_id as stiRtiDiasnosysTypeId, msrdt.name as stiRtiDiasnosysType,\r\n" + 
	 		"msrdpm.prod_id as productId,p.product_name as productName,fs.batch_number as batchNumber,fs.current_quantity as avaialableQty\r\n" + 
	 		"from\r\n" + 
	 		"soch.master_diagnosis_type msrdt\r\n" + 
	 		"join soch.clinical_treatment_mapping msrdpm on msrdt.id=msrdpm.diagnosis_type_id\r\n" + 
	 		"join soch.product p on msrdpm.prod_id=p.id\r\n" + 
	 		"join soch.facility_stock fs on msrdpm.sti_rti_prod_id=fs.product_id where fs.facility_id =:facilityId and msrdt.id= :diagnosisId \r\n" + 
	 		"order by fs.facility_id,msrdpm.diagnosis_type_id,msrdpm.prod_id,fs.batch_number",nativeQuery = true) 
 List<ProductListStiRti> getProdListByDigId(@Param("diagnosisId")Long diagnosisId, @Param("facilityId")Long facilityId);
 
	@Query(value = "select msrdt.id, msrdt.\"name\", sbsrtd.is_treatment_completed as isTreatmentCompleted from soch.beneficiary b \n" +
			"inner join soch.ti_beneficiary tb on tb.beneficiary_id = b.id\n" +
			"inner join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = b.id\n" +
			"inner join soch.beneficiary_sti_rti_treatment_details sbsrtd on sbsrtd.clinical_treatment_id=bct.id \n" +
			"inner join soch.master_diagnosis_type msrdt on msrdt.id = sbsrtd.sti_rti_diagnosis_type_id \n" +
			"where b.uid = :uid and tb.is_deleted = false and sbsrtd.is_treatment_completed=:isTreatmentCompleted and bct.facility_id =:facilityId \n" +
			"group by msrdt.id,sbsrtd.is_treatment_completed order by msrdt.id asc", nativeQuery = true)
	List<DiagnosisTypeProjection> diagnosisTypeByBeneficiaryId(@Param("uid")String uid, @Param("facilityId") Long facilityId,@Param("isTreatmentCompleted") Boolean isTreatmentCompleted);
	
	
	@Query(value = "select msrdt.id, msrdt.name, sbsrtd.is_treatment_completed as isTreatmentCompleted from soch.beneficiary b\r\n" + 
			"inner join soch.dsrc_beneficiary dben on dben.beneficiary_id = b.id\r\n" + 
			"inner join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = b.id\r\n" + 
			"inner join soch.beneficiary_sti_rti_treatment_details sbsrtd on sbsrtd.clinical_treatment_id=bct.id\r\n" + 
			"inner join soch.master_diagnosis_type msrdt on msrdt.id = sbsrtd.sti_rti_diagnosis_type_id \r\n" + 
			"where b.uid = :uid and dben.is_delete = false and sbsrtd.is_treatment_completed=:isTreatmentCompleted \r\n" + 
			"and bct.facility_id =:facilityId group by msrdt.id,sbsrtd.is_treatment_completed order by msrdt.id asc", nativeQuery = true)
	List<DiagnosisTypeProjection> diagnosisTypeByBeneficiaryIdForDsrc(@Param("uid")String uid, @Param("facilityId") Long facilityId,@Param("isTreatmentCompleted") Boolean isTreatmentCompleted);
	

	 @Query(value = "select id as facilityStockId, batch_number as batchNumber,current_quantity as currentQuantity from soch.facility_stock where product_id=:productId and facility_id=:facilityId and expired_date>=current_date",nativeQuery = true) 
	  List<BatchDetailsProjection> getBatchDetailsByProductIdAndFacilityId(@Param("productId")Integer productId,@Param("facilityId")Integer facilityId);
     
	 
//	 @Query(value = "select  prod.id as productId,prod.product_name as productName from soch.product prod where prod.id in(\r\n" + 
//	 		"select msrdpm.sti_rti_prod_id from \r\n" + 
//	 		"soch.master_sti_rti_diagnosis_type msrdt\r\n" + 
//	 		"join soch.master_sti_rti_diagnosis_prod_mapping  msrdpm   on msrdt.id=msrdpm.sti_rti_diagnosis_type_id\r\n" + 
//	 		"join soch.product p on p.id=msrdpm.sti_rti_prod_id\r\n" + 
//	 		"join soch.facility_stock fs on fs.product_id=msrdpm.sti_rti_prod_id\r\n" + 
//	 		" where fs.facility_id =:facilityId and msrdpm.sti_rti_diagnosis_type_id=:diagnosisId and fs.expired_date>=current_date group by msrdpm.sti_rti_prod_id)",nativeQuery = true) 
//	  List<ProductListStiRti> getProductListByDiagnosisAndFacility(@Param("diagnosisId")Long diagnosisId, @Param("facilityId")Long facilityId);
	 
	 @Query(value = "select  prod.id as productId,prod.product_name as productName from soch.product prod where prod.id in(\r\n" + 
		 		"select ctm.prod_id from \r\n" + 
		 		"soch.master_diagnosis_type msrdt\r\n" + 
		 		"join soch.clinical_treatment_mapping ctm   on msrdt.id=ctm.diagnosis_type_id\r\n" + 
		 		"join soch.product p on p.id=ctm.prod_id\r\n" + 
		 		"join soch.facility_stock fs on fs.product_id=ctm.prod_id\r\n" + 
		 		" where fs.facility_id =:facilityId and ctm.diagnosis_type_id=:diagnosisId and fs.expired_date>=current_date group by ctm.prod_id)",nativeQuery = true) 
		  List<ProductListStiRti> getProductListByDiagnosisAndFacility(@Param("diagnosisId")Long diagnosisId, @Param("facilityId")Long facilityId);

	
    @Query(value = "select * from soch.beneficiary_clinical_treatment bct where bct.beneficiary_id = :beneficiaryId" , nativeQuery = true)
    List<BeneficiaryClinicalTreatment> findByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);
    
    
    @Query(value = "select max(sti.followup_cycle_count) from soch.beneficiary_clinical_treatment bct\r\n" + 
    		" join soch.beneficiary_sti_rti_treatment_details sti on sti.clinical_treatment_id=bct.id\r\n" + 
    		" where bct.beneficiary_id=:beneficiaryId and bct.facility_id=:facilityId" , nativeQuery = true)
	Long getFollowCycleCountForBeneficiary(@Param("facilityId") Long facilityId,
			@Param("beneficiaryId") Long beneficiaryId);
    
    @Query(value = "select max(sti.followup_cycle_count) from soch.beneficiary_clinical_treatment bct\r\n" +
            " join soch.beneficiary_sti_rti_treatment_details sti on sti.clinical_treatment_id=bct.id\r\n" +
            " where bct.beneficiary_id=:beneficiaryId and bct.facility_id=:facilityId \r\n" +
            "and sti.sti_rti_diagnosis_type_id=:diagnosisId and sti.is_treatment_completed=true" , nativeQuery = true)
    Long getFollowCycleCount(@Param("facilityId") Long facilityId,
            @Param("beneficiaryId") Long beneficiaryId,@Param("diagnosisId") Long diagnosisId);
    
    @Query(value = "select sti.is_treatment_completed from soch.beneficiary_clinical_treatment bct \r\n" + 
    		" join soch.beneficiary_sti_rti_treatment_details sti on sti.clinical_treatment_id=bct.id\r\n" + 
    		"  where bct.beneficiary_id=:beneficiaryId and bct.facility_id=:facilityId \r\n" + 
    		"  and sti_rti_diagnosis_type_id=:diagnosieId and is_treatment_completed= false limit 1 \r\n" , nativeQuery = true)
	Boolean getStiDetails(@Param("facilityId") Long facilityId,
			@Param("beneficiaryId") Long beneficiaryId,
			@Param("diagnosieId") Long diagnosieId);
    
    
    @Query(value = "select sti.is_treatment_completed from soch.beneficiary_clinical_treatment bct \r\n" + 
    		"    		join soch.beneficiary_syphilis_treatment_details sti on sti.clinical_treatment_id=bct.id\r\n" + 
    		"    		where bct.beneficiary_id=:beneficiaryId and bct.facility_id=:facilityId\r\n" + 
    		"    		and sti.clinical_treatment_type_id=:treatmentTypeId and is_treatment_completed= false limit 1" , nativeQuery = true)
	Boolean getSyphilisDetails(@Param("facilityId") Long facilityId,
			@Param("beneficiaryId") Long beneficiaryId,
			@Param("treatmentTypeId") Long treatmentTypeId);
    

    @Query(value = "select sti.id from soch.beneficiary_clinical_treatment bct \r\n" + 
    		" join soch.beneficiary_sti_rti_treatment_details sti on sti.clinical_treatment_id=bct.id\r\n" + 
    		"  where bct.beneficiary_id=:beneficiaryId and bct.facility_id=:facilityId and sti.followup_date=:followupDate\r\n" + 
    		"  and sti_rti_diagnosis_type_id=:diagnosieId limit 1 \r\n" , nativeQuery = true)
	Long getStiDetailsByDate(@Param("facilityId") Long facilityId,
			@Param("beneficiaryId") Long beneficiaryId,
			@Param("diagnosieId") Long diagnosieId,@Param("followupDate") LocalDate followupDate);

    @Query(value = " select b.first_name as firstName, b.last_name as lastName, b.date_of_birth as dateOfBirth\r\n" + 
    		",mg.name as gender,batd.followup_date as followupDate ,batd.is_treatment_completed as treatmentCompleted\r\n" + 
    		"from soch.beneficiary b\r\n" + 
    		"inner join soch.ti_beneficiary tb on tb.beneficiary_id = b.id\r\n" + 
    		"inner join soch.master_gender mg on mg.id = b.gender_id\r\n" + 
    		"inner join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = b.id\r\n" + 
    		"inner join soch.beneficiary_abscess_treatment_details batd on batd.clinical_treatment_id = bct.id\r\n" + 
    		"where b.uid = :uid and bct.facility_id = :facilityId and bct.treatment_date=:treatmentDate\r\n" + 
    		"and tb.is_deleted=false and batd.is_delete = false\r\n" + 
    		"order by bct.id asc ",nativeQuery = true)
	OngoingReviewProjection getAbscessReview(@Param("uid") String uid, @Param("facilityId") Long facilityId, @Param("treatmentDate") LocalDate treatmentDate);

    @Query(value = " select b.first_name as firstName, b.last_name as lastName, b.date_of_birth as dateOfBirth,\r\n" + 
    		"mg.name as gender,bootd.followup_date as followupDate ,bootd.is_treatment_completed as treatmentCompleted\r\n" + 
    		"from soch.beneficiary b\r\n" + 
    		"inner join soch.ti_beneficiary tb on tb.beneficiary_id = b.id\r\n" + 
    		"inner join soch.master_gender mg on mg.id = b.gender_id\r\n" + 
    		"inner join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = b.id\r\n" + 
    		"inner join soch.beneficiary_opioid_overdose_treatment_details bootd on bootd.clinical_treatment_id = bct.id\r\n" + 
    		"where b.uid = :uid and bct.facility_id = :facilityId and bct.treatment_date=:treatmentDate \r\n" + 
    		"and tb.is_deleted=false and bootd.is_delete = false\r\n" + 
    		"order by bct.id asc " , nativeQuery = true)
	OngoingReviewProjection getOpioidReview(@Param("uid") String uid, @Param("facilityId") Long facilityId,@Param("treatmentDate") LocalDate treatmentDate);
    
    /*@Query(value = "select b.first_name as firstName, b.last_name as lastName, b.date_of_birth as dateOfBirth,\r\n" + 
    		"mg.name as gender,bsttd.syphilis_followup_date as followupDate ,bsttd.is_treatment_completed as treatmentCompleted\r\n" + 
    		"from soch.beneficiary b\r\n" + 
    		"inner join soch.dsrc_beneficiary dben on dben.beneficiary_id = b.id\r\n" + 
    		"inner join soch.master_gender mg on mg.id = b.gender_id\r\n" + 
    		"inner join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = b.id\r\n" + 
    		"inner join soch.beneficiary_syphilis_treatment_details bsttd on bsttd.clinical_treatment_id = bct.id \r\n" + 
    		"where b.uid = :uid and bct.facility_id = :facilityId  and bct.treatment_date=:treatmentDate\r\n" + 
    		"and dben.is_delete=false and bsttd.is_delete = false\r\n" + 
    		"order by bct.id asc" , nativeQuery = true)
    OngoingReviewProjection getSyphilisReview(@Param("uid") String uid, @Param("facilityId") Long facilityId,@Param("treatmentDate") LocalDate treatmentDate); */
    
    
	@Query(value = "select max(bst.id) from soch.beneficiary_clinical_treatment bct\r\n" + 
			"join soch.beneficiary_sti_rti_treatment_details bst on bst.clinical_treatment_id=bct.id\r\n" + 
			"where bct.beneficiary_id=:beneficiaryId and bst.sti_rti_diagnosis_type_id=:diagnosieId" , nativeQuery = true)
	Long getStiId(@Param("beneficiaryId") Long beneficiaryId,@Param("diagnosieId") Long diagnosieId);
    

	@Query(value = "select count(*) from soch.beneficiary_clinical_treatment bct\r\n" + 
			"join soch.beneficiary_opioid_overdose_treatment_details  bot\r\n" + 
			"on bot.clinical_treatment_id=bct.id\r\n" + 
			"where bct.clinical_treatment_type_id=:treatmentType and bct.beneficiary_id=:beneficiaryId \r\n" + 
			"and bot.followup_date=:fDate and bct.facility_id=:facilityId" , nativeQuery = true)
	Integer getOpioidCountByDate(@Param("treatmentType") Long treatmentType,@Param("beneficiaryId") Long beneficiaryId
			,@Param("fDate") LocalDate fDate,@Param("facilityId") Long facilityId);
    
	@Query(value = "select  count(*) from soch.beneficiary_clinical_treatment bct\r\n" + 
			"join soch.beneficiary_abscess_treatment_details bat\r\n" + 
			"on bat.clinical_treatment_id=bct.id\r\n" + 
			"where bct.clinical_treatment_type_id=:treatmentType and bct.beneficiary_id=:beneficiaryId\r\n" + 
			"and bat.followup_date=:fDate and bct.facility_id=:facilityId\r\n" + 
			"" , nativeQuery = true)
	Integer getAbscessCountByDate(@Param("treatmentType") Long treatmentType,@Param("beneficiaryId") Long beneficiaryId
			,@Param("fDate") LocalDate fDate,@Param("facilityId") Long facilityId);


	@Modifying
	@Transactional
	@Query(value = "update soch.beneficiary_sti_rti_treatment_details \r\n" + 
			"set is_treatment_completed = true\r\n" + 
			"where sti_rti_diagnosis_type_id = :diagnosisId \r\n" + 
			"and clinical_treatment_id in (select id  from soch.beneficiary_clinical_treatment \r\n" + 
			"							 where beneficiary_id= :beneficiaryId)" , nativeQuery=true)
	void updateStiRtiDetailsByBeneficiaryAndDiagnosis(@Param("beneficiaryId") Long beneficiaryId, @Param("diagnosisId") Long diagnosisId);


	@Query(value = " select b.uid as uid ,CONCAT( b.first_name,' ', b.last_name ) as name, tb.ti_code as tiCode , tm.typology_name as typology\r\n" + 
			",b.date_of_birth as dateOfBirth ,b.death_date as DeathDate,mg.name as gender ,mcst.name as status,min(bct.treatment_date) as diagnosisDate \r\n" + 
			",tb.beneficiary_id as beneficiaryId ,tb.id as tbId ,tb.date_of_reg as registrationDate \r\n" + 
			"from soch.ti_beneficiary tb   \r\n" + 
			"join soch.beneficiary b on b.id = tb.beneficiary_id   \r\n" + 
			"join soch.typology_master tm on tm.typology_id  = tb.master_hrg_primary_id   \r\n" + 
			"join soch.master_gender mg on mg.id = b.gender_id   \r\n" + 
			"join soch.master_client_status_ticore mcst on mcst.id = tb.status_id   \r\n" + 
			"join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = tb.beneficiary_id   \r\n" + 
			"join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = tb.beneficiary_id  \r\n" + 
			"where (bct.treatment_date +(INTERVAL '1 day' * bct.rmc_followup_frequency)) < current_date \r\n" + 
			"and bfm.facility_id = :facilityId and tb.facility_id =:facilityId and tb.is_deleted = false and coalesce(bct.is_delete,'false') = false and tm.typology_id not in (5,6)\r\n" + 
			"and( '' like :param or b.ti_benf_search_str ilike :param ) \r\n"+
			"and( '' like '' or b.mobile_number like :paramMobile ) \r\n"+
			"and (0=:typologyId or tm.typology_id=:typologyId) \r\n" + 
			"group by b.uid , b.first_name , b.last_name , tb.ti_code , tm.typology_name , b.date_of_birth ,mg.name ,mcst.name,\r\n" + 
			"tb.beneficiary_id ,tb.id , tb.date_of_reg,b.death_date,b.age  " 
			, nativeQuery = true)
	Page<RmcDueListProjection> getMissedRMCDueList(@Param("facilityId") Long facilityId , Pageable pageable , 
			@Param("param") String param,@Param("paramMobile") String paramMobile, @Param("typologyId") Long typologyId);

	@Query(value = "  select b.uid as uid ,CONCAT( b.first_name,' ', b.last_name ) as name, tb.ti_code as tiCode , tm.typology_name as typology\r\n" + 
			",b.date_of_birth as dateOfBirth,b.death_date as DeathDate,mg.name as gender ,mcst.name as status,min(bct.treatment_date) as diagnosisDate\r\n" + 
			",tb.beneficiary_id as beneficiaryId ,tb.id as tbId ,tb.date_of_reg as registrationDate \r\n" + 
			"from soch.ti_beneficiary tb   \r\n" + 
			"join soch.beneficiary b on b.id = tb.beneficiary_id   \r\n" + 
			"join soch.typology_master tm on tm.typology_id  = tb.master_hrg_primary_id   \r\n" + 
			"join soch.master_gender mg on mg.id = b.gender_id   \r\n" + 
			"join soch.master_client_status_ticore mcst on mcst.id = tb.status_id   \r\n" + 
			"join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = tb.beneficiary_id   \r\n" + 
			"left join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = tb.beneficiary_id  \r\n" + 
			"where  (tb.beneficiary_id , bct.treatment_date ,bct.clinical_treatment_type_id) not in    \r\n" + 
			"(select sti.beneficiary_id , sbct.treatment_date ,sbct.clinical_treatment_type_id  from soch.ti_beneficiary sti    \r\n" + 
			"join soch.beneficiary_clinical_treatment sbct on sbct.beneficiary_id=sti.beneficiary_id    \r\n" + 
			"and (((sbct.treatment_date +(INTERVAL '1 day' * sbct.rmc_followup_frequency)) >current_date)  \r\n" + 
			"or ((sbct.treatment_date +(INTERVAL '1 day' * sbct.rmc_followup_frequency)) <current_date))) \r\n" + 
			"and bfm.facility_id = :facilityId and tb.facility_id =:facilityId and tb.is_deleted = false and coalesce(bct.is_delete,'false') = false and tm.typology_id not in (5,6)\r\n" + 
			"and( '' like :param or b.ti_benf_search_str ilike :param ) \r\n"+
			"and( '' like '' or b.mobile_number like :paramMobile ) \r\n"+
			"and (0=:typologyId or tm.typology_id=:typologyId) \r\n" + 
			"group by b.uid , b.first_name , b.last_name , tb.ti_code , tm.typology_name , b.date_of_birth ,mg.name ,mcst.name,\r\n" + 
			"tb.beneficiary_id ,tb.id , tb.date_of_reg,b.death_date,b.age " 
			, nativeQuery = true)
	Page<RmcDueListProjection> getUpcomingRMCDueList(@Param("facilityId") Long facilityId , Pageable pageable ,
			@Param("param") String param,@Param("paramMobile") String paramMobile, @Param("typologyId") Long typologyId);
	
	
	@Query(value = "select bct.id from soch.beneficiary_clinical_treatment bct where bct.beneficiary_id=:beneficiaryId and bct.treatment_date =:treatmentDate and bct.clinical_treatment_type_id=:treatmentTypeId" , nativeQuery = true)
	Long getBeneficiaryById(@Param("beneficiaryId") Long beneficiaryId, @Param("treatmentDate") LocalDate treatmentDate, @Param("treatmentTypeId") Long treatmentTypeId);

	@Query(value = "select bct.id from soch.beneficiary_clinical_treatment bct where bct.beneficiary_id=:beneficiaryId and bct.clinical_treatment_type_id=:treatmentTypeId" , nativeQuery = true)
	Long getBeneficiaryClinicalTreamentId(@Param("beneficiaryId") Long beneficiaryId, @Param("treatmentTypeId") Long treatmentTypeId);

	@Query(value = "select max(sti.treatment_record_count) from soch.beneficiary_clinical_treatment bct\r\n" +
            " join soch.beneficiary_sti_rti_treatment_details sti on sti.clinical_treatment_id=bct.id\r\n" +
            " where bct.beneficiary_id=:beneficiaryId and bct.facility_id=:facilityId \r\n" +
            "and sti.sti_rti_diagnosis_type_id=:diagnosisId and sti.is_treatment_completed=true" , nativeQuery = true)
	Long getTreatmentRecordCount(@Param("facilityId") Long facilityId,@Param("beneficiaryId") Long beneficiaryId,@Param("diagnosisId") Long diagnosisId);
	
	@Query(nativeQuery=true, value="select p.id as productId,p.product_name as productName from soch.product p join soch.clinical_treatment_mapping ctm on p.id=ctm.prod_id join soch.facility_stock fs on fs.product_id=ctm.prod_id and ctm.facility_type_id=:facilityTypeId and fs.facility_id=:facilityId and ctm.treatment_type_id=:treatmentTypeId group by p.id")
	List<ProductProjcetion> getProductsByFacilityTypeAndTreatmentType(@Param("facilityTypeId") Long facilityTypeId,@Param("treatmentTypeId") Long treatmentTypeId,@Param("facilityId") Long facilityId);

	@Query(value = "select DISTINCT b.id as beneficiaryId,b.uid as uid ,CONCAT( b.first_name,' ', b.last_name ) as name,b.date_of_birth as dateOfBirth ,b.death_date as DeathDate, \r\n" +
            "b.dsrc_beneficiary_code as dsrcCode ,mg.name as gender, mct.name as infection, min(bct.treatment_date) as diagnosisDate,\r\n" +
            "bct.clinical_treatment_type_id as treatmentTypeId , string_agg(distinct msrdt.name,',') as diagnosisType \r\n" +
            "from soch.beneficiary_clinical_treatment bct \r\n" +
            "join soch.beneficiary b on bct.beneficiary_id = b.id \r\n" +
            "join soch.dsrc_beneficiary dben on dben.beneficiary_id = b.id and dben.facility_id = :facilityId  and dben.is_delete = false \r\n " +
            "join soch.master_gender mg on mg.id = b.gender_id  \r\n" +
            "join soch.master_clinical_treatment_type mct on mct.id = bct.clinical_treatment_type_id   \r\n" +
            "left join soch.beneficiary_sti_rti_treatment_details bsrtd on bct.id = bsrtd.clinical_treatment_id  \r\n" +
            "left join soch.beneficiary_syphilis_treatment_details bstd on bct.id = bstd.clinical_treatment_id  \r\n" +
            "left join soch.master_diagnosis_type msrdt on msrdt.id = bsrtd.sti_rti_diagnosis_type_id \r\n" +
            "where bct.facility_id =:facilityId and b.is_delete = false and bct.is_delete = false  \r\n" +
            "and ( bsrtd.is_treatment_completed=false and bsrtd.is_delete = false  and bsrtd.clinical_treatment_type_id = 1 or "
            + " bstd.is_treatment_completed=false and bstd.is_delete = false ) \r\n" +
            "and ((bct.treatment_date >=cast(:startdateOfDiagnosis as date) OR CAST(CAST(:startdateOfDiagnosis AS TEXT) AS date) IS NULL) AND (bct.treatment_date <= cast(:enddateOfDiagnosis as date) OR CAST(CAST(:enddateOfDiagnosis AS TEXT) AS date) IS NULL))\r\n" +
            "group by b.id,b.uid ,b.first_name,b.last_name,b.age,mg.name,mct.name,bct.clinical_treatment_type_id,b.date_of_birth,b.death_date,bct.modified_time"
            ,nativeQuery = true)
	Page<OngoingTreatmentListProjection> getdsrcOngoingTreatmentList(@Param("facilityId") Long facilityId, Pageable pageable,@Param("startdateOfDiagnosis") LocalDate startdateOfDiagnosis,@Param("enddateOfDiagnosis") LocalDate enddateOfDiagnosis);

	
@Query(value = "select DISTINCT b.id as beneficiaryId,b.uid as uid ,CONCAT( b.first_name,' ', b.last_name ) as name,b.date_of_birth as dateOfBirth ,\r\n" + 
		"b.dsrc_beneficiary_code as dsrcCode ,mg.name as gender, mct.name as infection, min(bct.treatment_date) as diagnosisDate,\r\n" + 
		"bct.clinical_treatment_type_id as treatmentTypeId ,string_agg(distinct msrdt.name,',') as diagnosisType \r\n" + 
		"from soch.beneficiary b \r\n" + 
		"join soch.dsrc_beneficiary dben on dben.beneficiary_id = b.id and dben.facility_id = :facilityId and dben.is_delete = false \r\n " + 
		"join soch.master_gender mg on mg.id = b.gender_id  \r\n" + 
		"join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = b.id \r\n" + 
		"join soch.master_clinical_treatment_type mct on mct.id = bct.clinical_treatment_type_id   \r\n" + 
		"left join soch.beneficiary_sti_rti_treatment_details bsrtd on bct.id = bsrtd.clinical_treatment_id  \r\n" + 
		"left join soch.beneficiary_syphilis_treatment_details bstd on bct.id = bstd.clinical_treatment_id  \r\n" + 
		"left join soch.master_diagnosis_type msrdt on msrdt.id = bsrtd.sti_rti_diagnosis_type_id \r\n" + 
		"where bct.facility_id =:facilityId and b.is_delete = false and bct.is_delete = false  \r\n" + 
		"and ( bsrtd.is_treatment_completed=false and bsrtd.is_delete = false  and bsrtd.clinical_treatment_type_id = 1 or "
		+ " bstd.is_treatment_completed=false and bstd.is_delete = false ) \r\n" + 
		"and ((bct.treatment_date >=cast(:startdateOfDiagnosis as date) OR CAST(CAST(:startdateOfDiagnosis AS TEXT) AS date) IS NULL) AND (bct.treatment_date <= cast(:enddateOfDiagnosis as date) OR CAST(CAST(:enddateOfDiagnosis AS TEXT) AS date) IS NULL))\r\n" + 
		"and b.uid =:param group by b.id,b.uid ,b.first_name,b.last_name,b.age,mg.name,mct.name,bct.clinical_treatment_type_id"			
		,nativeQuery = true)
Page<OngoingTreatmentListProjection> getdsrcOngoingTreatmentListByUid(Pageable pageable, @Param("param") String param, @Param("facilityId") Long facilityId,@Param("startdateOfDiagnosis") LocalDate startdateOfDiagnosis,@Param("enddateOfDiagnosis") LocalDate enddateOfDiagnosis);


@Query(value = "select DISTINCT b.id as beneficiaryId,b.uid as uid ,CONCAT( b.first_name,' ', b.last_name ) as name,b.date_of_birth as dateOfBirth ,\r\n" + 
		"b.dsrc_beneficiary_code as dsrcCode ,mg.name as gender, mct.name as infection, min(bct.treatment_date) as diagnosisDate,\r\n" + 
		"bct.clinical_treatment_type_id as treatmentTypeId ,string_agg(distinct msrdt.name,',') as diagnosisType \r\n" + 
		"from soch.beneficiary b \r\n"+
		"join soch.dsrc_beneficiary dben on dben.beneficiary_id = b.id and dben.facility_id = :facilityId  and dben.is_delete = false \r\n " + 
		"join soch.master_gender mg on mg.id = b.gender_id  \r\n" + 
		"join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = b.id \r\n" + 
		"join soch.master_clinical_treatment_type mct on mct.id = bct.clinical_treatment_type_id   \r\n" + 
		"left join soch.beneficiary_sti_rti_treatment_details bsrtd on bct.id = bsrtd.clinical_treatment_id  \r\n" +
		"left join soch.beneficiary_syphilis_treatment_details bstd on bct.id = bstd.clinical_treatment_id  \r\n" + 
		"left join soch.master_diagnosis_type msrdt on msrdt.id = bsrtd.sti_rti_diagnosis_type_id \r\n" + 
		"where bct.facility_id =:facilityId and b.is_delete = false and bct.is_delete = false  \r\n" + 
		"and ( bsrtd.is_treatment_completed=false and bsrtd.is_delete = false  and bsrtd.clinical_treatment_type_id = 1 or "
		+ " bstd.is_treatment_completed=false and bstd.is_delete = false ) \r\n" + 
		"and ((bct.treatment_date >=cast(:startdateOfDiagnosis as date) OR CAST(CAST(:startdateOfDiagnosis AS TEXT) AS date) IS NULL) AND (bct.treatment_date <= cast(:enddateOfDiagnosis as date) OR CAST(CAST(:enddateOfDiagnosis AS TEXT) AS date) IS NULL))\r\n" + 
		"and ( CONCAT( b.first_name,' ', b.last_name ) ilike %:param%  or b.benf_search_str ilike %:param%)  group by b.id,b.uid ,b.first_name,b.last_name,b.age,mg.name,mct.name,bct.clinical_treatment_type_id"			
		,nativeQuery = true)
Page<OngoingTreatmentListProjection> getdsrcOngoingTreatmentListBasicSrch( Pageable pageable, @Param("param") String param,@Param("facilityId") Long facilityId,@Param("startdateOfDiagnosis") LocalDate startdateOfDiagnosis,@Param("enddateOfDiagnosis") LocalDate enddateOfDiagnosis);


	@Query(value = "select b.first_name as firstName, b.last_name as lastName, b.date_of_birth as dateOfBirth, mg.name as gender,sbsrtd.clinical_treatment_id as clinicalTrId,sbsrtd.followup_date as followupDate, sbsrtd.next_followup_date as nextFollowupDate, sbsrtd.followup_cycle_count as followupCycleCount,\r\n" + 
			"fs2.batch_number as batchnum,fs2.current_quantity as availableqty,sbsrtd.dispense_qty as dispenseQty,p.id as pid,p.product_name as pname, sbsrtd.is_treatment_completed as treatmentCompleted, sbsrtd.refer_to as referTo, sbsrtd.test_type_conducted as testTypeConducted, fs2.expired_date as expiryDate \r\n" +
			" ,sbsrtd.followup_date || ''|| sbsrtd.next_followup_date as concatDate " +
			"from soch.beneficiary b\r\n" + 
			"inner join soch.dsrc_beneficiary dben on dben.beneficiary_id = b.id\r\n" + 
			"inner join soch.master_gender mg on mg.id = b.gender_id\r\n" + 
			"inner join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = b.id\r\n" + 
			"inner join soch.beneficiary_sti_rti_treatment_details sbsrtd on sbsrtd.clinical_treatment_id=bct.id\r\n " +
			"left join soch.facility_stock fs2 on fs2.id = sbsrtd.facility_stock_id\r\n" + 
			"left join soch.product p on p.id = sbsrtd.sti_rti_prod_id\r\n" + 
			"where b.uid = :uid and sbsrtd.sti_rti_diagnosis_type_id = :diagnosisTypeId and dben.is_delete = false \r\n" + 
			"and bct.facility_id = :facilityId and sbsrtd.is_treatment_completed=false  order by sbsrtd.followup_date asc", nativeQuery = true)
	List<OngoingReviewProjection> getOngoingDataForDsrc(@Param("uid") String uid, @Param("diagnosisTypeId") Long diagnosisTypeId, @Param("facilityId") Long facilityId);

    @Query(nativeQuery = true , value = "select b.first_name as firstName, b.last_name as lastName, b.date_of_birth as dateOfBirth, mg.name as gender,sbsrtd.clinical_treatment_id as clinicalTrId, sbsrtd.followup_date as followupDate, sbsrtd.next_followup_date as nextFollowupDate, sbsrtd.followup_cycle_count as followupCycleCount,\r\n" + 
    		"fs2.batch_number as batchnum,fs2.current_quantity as availableqty,sbsrtd.dispense_qty as dispenseQty,p.id as pid,p.product_name as pname, sbsrtd.is_treatment_completed as treatmentCompleted,sbsrtd.refer_to as referTo, sbsrtd.test_type_conducted as testTypeConducted, fs2.expired_date as expiryDate \r\n" + 
    		",sbsrtd.followup_date || ''|| sbsrtd.next_followup_date as concatDate " +
    		"from soch.beneficiary b\r\n" + 
    		"inner join soch.dsrc_beneficiary dben on dben.beneficiary_id = b.id\r\n" + 
    		"inner join soch.master_gender mg on mg.id = b.gender_id\r\n" + 
    		"inner join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = b.id\r\n" + 
    		"inner join soch.beneficiary_sti_rti_treatment_details sbsrtd on sbsrtd.clinical_treatment_id=bct.id\r\n" + 
    		"left join soch.facility_stock fs2 on fs2.id = sbsrtd.facility_stock_id\r\n" + 
    		"left join soch.product p on p.id = sbsrtd.sti_rti_prod_id\r\n" + 
    		"where b.uid = :uid and sbsrtd.sti_rti_diagnosis_type_id = :diagnosisTypeId and dben.is_delete = false and bct.facility_id = :facilityId \r\n" + 
    		"and sbsrtd.treatment_record_count=:treatmentRecordCount and is_treatment_completed=true  order by sbsrtd.followup_date asc")
	List<OngoingReviewProjection> getOngoingDataForCompletedForDsrc(@Param("uid") String uid, @Param("diagnosisTypeId") Long diagnosisTypeId, @Param("facilityId") Long facilityId,
			@Param("treatmentRecordCount") Long treatmentRecordCount);


    @Query(value = " select b.first_name as firstName, b.last_name as lastName, b.date_of_birth as dateOfBirth, mg.name as gender,\r\n" + 
    		"bct.treatment_date as initialDiagnosis, bstd.syphilis_followup_date as followupDate, fs2.batch_number as batchnum,\r\n" + 
    		"fs2.current_quantity as availableqty,bstd.dispense_qty as dispenseQty,p.id as pid,p.product_name as pname,\r\n" + 
    		"bstd.is_treatment_completed as treatmentCompleted , mstr.name as syphilisTestResult , mstt.name as syphilisTestType "
    		+ " , bstd.syphilis_test_result_id as syphilisTestResultId , bstd.syphilis_test_type_id as syphilisTestTypeId , bstd.titre as titre ,bstd.clinical_treatment_id as clinicalTreatmentId \r\n" + 
    		"from soch.beneficiary b \r\n" + 
    		"inner join soch.dsrc_beneficiary dben on dben.beneficiary_id = b.id \r\n" + 
    		"left join soch.master_gender mg on mg.id = b.gender_id \r\n" + 
    		"inner join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = b.id \r\n" + 
    		"inner join soch.beneficiary_syphilis_treatment_details bstd on bstd.clinical_treatment_id = bct.id \r\n" + 
    		"left join soch.master_syphilis_test_result mstr on mstr.id = bstd.syphilis_test_result_id \r\n" +
    		"left join soch.master_syphilis_test_type mstt on mstt.id = bstd.syphilis_test_type_id \r\n" + 
    		"left join soch.facility_stock fs2 on fs2.id = bstd.facility_stock_id \r\n" + 
    		"left join soch.product p on p.id = bstd.syphilis_prod_id \r\n" + 
    		"where b.uid = :uid and dben.is_delete = false and bct.facility_id = :facilityId and bstd.is_treatment_completed= :isTreatmentCompleted \r\n" +
    		"and bct.treatment_date = :initialDiagnosis and bstd.syphilis_followup_date =:followupDate \r\n" +
    		//"order by bstd.syphilis_followup_date asc " +
    		" " , nativeQuery = true)
	List<SyphilisReviewProjection> getSyphilisProductDetails(@Param("uid") String uid, @Param("facilityId") Long facilityId, @Param("isTreatmentCompleted") Boolean isTreatmentCompleted,  @Param("followupDate") LocalDate followupDate,
			@Param("initialDiagnosis") LocalDate initialDiagnosis);


    @Query(nativeQuery = true , value = " select distinct b.first_name as firstName, b.last_name as lastName, \r\n" + 
    		"b.date_of_birth as dateOfBirth,mg.name as gender,bct.treatment_date as initialDiagnosis, \r\n" + 
    		"bstd.syphilis_followup_date as followupDate,bstd.is_treatment_completed as treatmentCompleted \r\n " +
    		" ,v.is_pregnant as ispregnant,dben.infant_code as infantCode " + 
    		"from soch.beneficiary b \r\n" + 
    		"inner join soch.dsrc_beneficiary dben on dben.beneficiary_id = b.id \r\n" + 
    		"left join soch.master_gender mg on mg.id = b.gender_id \r\n" + 
    		"inner join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = b.id \r\n" + 
    		"inner join soch.beneficiary_syphilis_treatment_details bstd on bstd.clinical_treatment_id = bct.id\r\n" + 
    		"left join soch.master_syphilis_test_result mstr on mstr.id = bstd.syphilis_test_result_id\r\n" + 
    		"left join soch.master_syphilis_test_type mstt on mstt.id = bstd.syphilis_test_type_id\r\n" + 
    		"left join ( select  bv.beneficiary_id,bv.is_pregnant,bv.facility_id from soch.beneficiary_visit_register bv join ( select beneficiary_id,max(id) as visit_id  from soch.beneficiary_visit_register where facility_id=:facilityId group by beneficiary_id ) vr on (vr.beneficiary_id = bv.beneficiary_id and vr.visit_id=bv.id and bv.is_delete = false)) v on b.id = v.beneficiary_id " +
    		"where b.uid = :uid and dben.is_delete = false and bct.facility_id = :facilityId \r\n" + 
    		"and bstd.is_treatment_completed= :isTreatmentCompleted \r\n" + 
    		"order by bstd.syphilis_followup_date asc " +
    		 "")
	List<SyphilisReviewProjection> getDistinctSyphilisReviewData(@Param("uid") String uid, @Param("facilityId") Long facilityId, @Param("isTreatmentCompleted") Boolean isTreatmentCompleted);

    @Query(value = "select max(bst.id) from soch.beneficiary_clinical_treatment bct\r\n" + 
			"join soch.beneficiary_syphilis_treatment_details bst on bst.clinical_treatment_id=bct.id\r\n" + 
			"where bct.beneficiary_id=:beneficiaryId " , nativeQuery = true)
	Long getSyphilisId(@Param("beneficiaryId") Long beneficiaryId);


    @Query(value = "select bst.id from soch.beneficiary_clinical_treatment bct\r\n" + 
			"join soch.beneficiary_sti_rti_treatment_details bst on bst.clinical_treatment_id=bct.id\r\n" + 
			"where bct.beneficiary_id=:beneficiaryId and bst.sti_rti_diagnosis_type_id=:diagnosieId and bst.followup_date = :followupDate " , nativeQuery = true)
	List<Long> getStiIdsBasedOnFollowupDate(@Param("beneficiaryId") Long beneficiaryId,@Param("diagnosieId") Long diagnosieId,@Param("followupDate") LocalDate followupDate);
    
    @Query(value = "select bst.id from soch.beneficiary_clinical_treatment bct\r\n" + 
			"join soch.beneficiary_syphilis_treatment_details bst on bst.clinical_treatment_id=bct.id\r\n" + 
			"where bct.beneficiary_id=:beneficiaryId and bst.syphilis_followup_date = :followupDate " , nativeQuery = true)
	List<Long> getSyphilisIdsBasedOnFollowupDate(@Param("beneficiaryId") Long beneficiaryId,@Param("followupDate") LocalDate followupDate);
    
    @Query(value = " select distinct b.id as beneficiaryId,b.uid as uid ,CONCAT( b.first_name,' ', b.last_name ) as name,b.date_of_birth as dateOfBirth , \r\n"
			+ " b.mobile_number as mobileNumber,b.first_name as firstName,b.middle_name as middleName,b.last_name as lastName,  " + 
			"b.dsrc_beneficiary_code as dsrcCode ,mg.name as gender, mcst.name as masterClientStatus,mct.name as infection, bct.treatment_date as diagnosisDate ,mct.id as treatmentTypeId \r\n"
			+ ",bsrt.sti_rti_diagnosis_type_id as diagnosisTypeId ,msrdt.name as diagnosisTypeName, bsrt.treatment_record_count as treatmentRecordCount " + 
			"from soch.beneficiary b \r\n" + 
			"join soch.dsrc_beneficiary tb on tb.beneficiary_id = b.id and tb.facility_id = :facilityId \r\n" + 
			"join soch.master_gender mg on mg.id = b.gender_id \r\n" + 
			"join soch.master_dsrc_beneficiary_status mcst on mcst.id = tb.benficiary_status_id    \r\n" + 
			"join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = b.id \r\n" + 
			"join soch.master_clinical_treatment_type mct on mct.id = bct.clinical_treatment_type_id \r\n" + 
			"left join soch.beneficiary_sti_rti_treatment_details bsrt on bct.id = bsrt.clinical_treatment_id \r\n" + 
			"left join soch.beneficiary_syphilis_treatment_details  batd on bct.id = batd.clinical_treatment_id \r\n" + 
			"left join soch.master_diagnosis_type msrdt on msrdt.id = bsrt.sti_rti_diagnosis_type_id \r\n" + 
			"where bct.facility_id = :facilityId and tb.is_delete = false and bct.is_delete = false and b.is_delete = false and mct.id !=4  \r\n" + 
			"and ( ( bsrt.is_treatment_completed=true and bsrt.is_delete = false and bsrt.next_followup_date is null ) \r\n" + 
			"or ( bsrt.is_treatment_completed=true and bsrt.is_delete = false and bsrt.sti_rti_diagnosis_type_id = 7 ) " + 
			"or ( batd.is_treatment_completed=true and batd.is_delete = false) ) \r\n" + 
			"and (0=:genderId or mg.id=:genderId) \r\n" + 
			"and (0=:treatmentType or mct.id=:treatmentType) \r\n" + 
			"and ((bct.treatment_date >=cast(:startdateOfDiagnosis as date) OR CAST(CAST(:startdateOfDiagnosis AS TEXT) AS date) IS NULL) AND (bct.treatment_date <= cast(:enddateOfDiagnosis as date) OR CAST(CAST(:enddateOfDiagnosis AS TEXT) AS date) IS NULL)) and b.uid ilike %:param% "
					,nativeQuery = true)
	Page<CompletedTreatmentListProjection> getCompletedTreatmentListDsrcByUid(@Param("facilityId") Long facilityId, Pageable pageable,
																	 @Param("genderId") Long genderId, @Param("treatmentType") Long treatmentType ,@Param("startdateOfDiagnosis")LocalDate startdateOfDiagnosis,@Param("enddateOfDiagnosis")LocalDate enddateOfDiagnosis,@Param("param") String param);
    
    @Query(value = " select distinct b.id as beneficiaryId,b.uid as uid ,CONCAT( b.first_name,' ', b.last_name ) as name,b.date_of_birth as dateOfBirth , \r\n"
			+ " b.mobile_number as mobileNumber,b.first_name as firstName,b.middle_name as middleName,b.last_name as lastName,  " + 
			"b.dsrc_beneficiary_code as dsrcCode ,mg.name as gender, mcst.name as masterClientStatus,mct.name as infection, bct.treatment_date as diagnosisDate ,mct.id as treatmentTypeId \r\n"
			+ ",bsrt.sti_rti_diagnosis_type_id as diagnosisTypeId ,msrdt.name as diagnosisTypeName, bsrt.treatment_record_count as treatmentRecordCount " + 
			"from soch.beneficiary b \r\n" + 
			"join soch.dsrc_beneficiary tb on tb.beneficiary_id = b.id and tb.facility_id = :facilityId \r\n" + 
			"join soch.master_gender mg on mg.id = b.gender_id \r\n" + 
			"join soch.master_dsrc_beneficiary_status mcst on mcst.id = tb.benficiary_status_id    \r\n" + 
			"join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = b.id \r\n" + 
			"join soch.master_clinical_treatment_type mct on mct.id = bct.clinical_treatment_type_id \r\n" + 
			"left join soch.beneficiary_sti_rti_treatment_details bsrt on bct.id = bsrt.clinical_treatment_id \r\n" + 
			"left join soch.beneficiary_syphilis_treatment_details  batd on bct.id = batd.clinical_treatment_id \r\n" + 
			"left join soch.master_diagnosis_type msrdt on msrdt.id = bsrt.sti_rti_diagnosis_type_id \r\n" + 
			"where bct.facility_id = :facilityId and tb.is_delete = false and bct.is_delete = false and b.is_delete = false and mct.id !=4  \r\n" + 
			"and ( ( bsrt.is_treatment_completed=true and bsrt.is_delete = false and bsrt.next_followup_date is null ) \r\n" +
			"or ( bsrt.is_treatment_completed=true and bsrt.is_delete = false and bsrt.sti_rti_diagnosis_type_id = 7 ) " + 
			"or ( batd.is_treatment_completed=true and batd.is_delete = false) ) \r\n" + 
			"and (0=:genderId or mg.id=:genderId) \r\n" + 
			"and (0=:treatmentType or mct.id=:treatmentType) \r\n" + 
			"and ((bct.treatment_date >=cast(:startdateOfDiagnosis as date) OR CAST(CAST(:startdateOfDiagnosis AS TEXT) AS date) IS NULL) AND (bct.treatment_date <= cast(:enddateOfDiagnosis as date) OR CAST(CAST(:enddateOfDiagnosis AS TEXT) AS date) IS NULL)) \r\n"+
			"and (CONCAT( b.first_name,' ', b.last_name ) ilike %:param%  or b.benf_search_str ilike %:param%)"
					,nativeQuery = true)
	Page<CompletedTreatmentListProjection> getCompletedTreatmentListDsrctBasicSrch(@Param("facilityId") Long facilityId, Pageable pageable,
																	 @Param("genderId") Long genderId, @Param("treatmentType") Long treatmentType ,@Param("startdateOfDiagnosis")LocalDate startdateOfDiagnosis,@Param("enddateOfDiagnosis")LocalDate enddateOfDiagnosis,@Param("param") String param);
    
    @Query(value = "select bst.id from soch.beneficiary_syphilis_treatment_details bst\r\n" + 
			"where bst.clinical_treatment_id=:clinicalTreatmentId " , nativeQuery = true)
	List<Long> getSyphilisIdsBasedOnClinicalId(@Param("clinicalTreatmentId") Long clinicalTreatmentId);
    
	@Modifying
	@Transactional
    @Query(value = "update soch.beneficiary_syphilis_treatment_details \r\n "
    		+ " set is_treatment_completed = true " + 
			"where id in :clinicalTreatmentId  " , nativeQuery = true)
	void updateSyphilisCompleted(@Param("clinicalTreatmentId") List<Long> clinicalTreatmentId);
	
	@Query(value = "select bstd.id from soch.beneficiary_syphilis_treatment_details bstd "
 		+ " where bstd.clinical_treatment_id = :clinicalTreatmentId "
 		+ " and syphilis_followup_date = (select syphilis_followup_date from soch.beneficiary_syphilis_treatment_details where id = (select max(id) from soch.beneficiary_syphilis_treatment_details where clinical_treatment_id = :clinicalTreatmentId ) )  " , nativeQuery = true)
	List<Long> getSyphilisLatestIdsBasedOnClinicalId(@Param("clinicalTreatmentId") Long clinicalTreatmentId);
    
	@Modifying
	@Transactional
    @Query(value = "update soch.beneficiary_syphilis_treatment_details set syphilis_followup_date = :followDate where id in :clinicalTreatmentId " , nativeQuery = true)
	void updateSyphilisDate(@Param("clinicalTreatmentId") List<Long> clinicalTreatmentId,@Param("followDate") LocalDate followDate);
		

	 @Query(value = " select b.first_name as firstName, b.last_name as lastName, b.date_of_birth as dateOfBirth, mg.name as gender,\r\n" + 
	    		"bct.treatment_date as initialDiagnosis, bstd.syphilis_followup_date as followupDate, fs2.batch_number as batchnum,\r\n" + 
	    		"fs2.current_quantity as availableqty,bstd.dispense_qty as dispenseQty,p.id as pid,p.product_name as pname,\r\n" + 
	    		"bstd.is_treatment_completed as treatmentCompleted , mstr.name as syphilisTestResult , mstt.name as syphilisTestType "
	    		+ " , bstd.syphilis_test_result_id as syphilisTestResultId , bstd.syphilis_test_type_id as syphilisTestTypeId , bstd.titre as titre ,bstd.clinical_treatment_id as clinicalTreatmentId \r\n" + 
	    		"from soch.beneficiary b \r\n" + 
	    		"inner join soch.dsrc_beneficiary dben on dben.beneficiary_id = b.id \r\n" + 
	    		"left join soch.master_gender mg on mg.id = b.gender_id \r\n" + 
	    		"inner join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = b.id \r\n" + 
	    		"inner join soch.beneficiary_syphilis_treatment_details bstd on bstd.clinical_treatment_id = bct.id \r\n" + 
	    		"inner join soch.master_syphilis_test_result mstr on mstr.id = bstd.syphilis_test_result_id \r\n" +
	    		"inner join soch.master_syphilis_test_type mstt on mstt.id = bstd.syphilis_test_type_id \r\n" + 
	    		"left join soch.facility_stock fs2 on fs2.id = bstd.facility_stock_id \r\n" + 
	    		"left join soch.product p on p.id = bstd.syphilis_prod_id \r\n" + 
	    		"where b.uid = :uid and dben.is_delete = false and bct.facility_id = :facilityId and bstd.is_treatment_completed= :isTreatmentCompleted \r\n" +
	    		"and bct.treatment_date = :initialDiagnosis and bstd.syphilis_followup_date is null \r\n" +
	    		//"order by bstd.syphilis_followup_date asc " +
	    		" " , nativeQuery = true)
		List<SyphilisReviewProjection> getSyphilisProductDetailsFollowDateIsNULL(@Param("uid") String uid, @Param("facilityId") Long facilityId, @Param("isTreatmentCompleted") Boolean isTreatmentCompleted,  
				@Param("initialDiagnosis") LocalDate initialDiagnosis);
	 
	 
	    @Modifying
		@Transactional
		@Query(value = "update soch.dsrc_beneficiary set benficiary_status_id=:status where  beneficiary_id= :beneficiaryId" , nativeQuery=true)
		void updateDsrcStatusDetailsByBeneficiary(@Param("beneficiaryId") Long beneficiaryId, @Param("status") Long status);

	    @Query(nativeQuery = true, value ="select case  \r\n" + 
	    		"				 when COALESCE(bstd.is_treatment_completed ) = false then 'Ongoing Treatment' \r\n" + 
	    		"				 when COALESCE(bstd.is_treatment_completed ) = true  then 'Completed Treatment' \r\n" + 
	    		"				 else 'Registered' END as treatmentCompleted  from soch.dsrc_beneficiary dbs \r\n" + 
	    		" join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = dbs.beneficiary_id and  bct.is_delete= false \r\n" + 
	    		" join soch.beneficiary_syphilis_treatment_details bstd on bstd.clinical_treatment_id = bct.id \r\n" + 
	    		"				 where dbs.beneficiary_id = :beneficiaryId and dbs.is_delete =false  and dbs.is_active = true order by bct.id desc  limit 1\r\n" + 
	    		"")
		String getBenficiaryLatestClinicalStatusSyphilis(@Param("beneficiaryId") Long beneficiaryId) ;
		
	    @Query(nativeQuery = true, value ="select case  \r\n" + 
	    		"				 when COALESCE(bstd.is_treatment_completed ) = false then 'Ongoing Treatment' \r\n" + 
	    		"				 when COALESCE(bstd.is_treatment_completed ) = true  then 'Completed Treatment' \r\n" + 
	    		"				 else 'Registered' END as treatmentCompleted  from soch.dsrc_beneficiary dbs \r\n" + 
	    		" join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = dbs.beneficiary_id and  bct.is_delete= false \r\n" + 
	    		" join soch.beneficiary_sti_rti_treatment_details bstd on bstd.clinical_treatment_id = bct.id \r\n" + 
	    		"				 where dbs.beneficiary_id = :beneficiaryId and dbs.is_delete =false  and dbs.is_active = true order by bct.id desc  limit 1\r\n" + 
	    		"")
		String getBenficiaryLatestClinicalStatusStiRti(@Param("beneficiaryId") Long beneficiaryId) ;
		

		 @Query(value = " select b.uid as uid ,CONCAT( b.first_name,' ', b.last_name ) as name, tb.ti_code as tiCode , tm.typology_name as typology,\r\n" + 
		            "b.date_of_birth as dateOfBirth , b.death_date as DeathDate,mg.name as gender ,mcst.name as status,min(bct.treatment_date) as diagnosisDate , \r\n" + 
		            "tb.beneficiary_id as beneficiaryId ,tb.id as tbId ,tb.date_of_reg as registrationDate \r\n" + 
		            "from soch.ti_beneficiary tb   \r\n" + 
		            "join soch.beneficiary b on b.id = tb.beneficiary_id   \r\n" + 
		            "join soch.typology_master tm on tm.typology_id  = tb.master_hrg_primary_id   \r\n" + 
		            "join soch.master_gender mg on mg.id = b.gender_id   \r\n" + 
		            "join soch.master_client_status_ticore mcst on mcst.id = tb.status_id   \r\n" + 
		            "join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = tb.beneficiary_id   \r\n" + 
		            "left join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = tb.beneficiary_id  \r\n" + 
		            "where  (tb.beneficiary_id , bct.treatment_date,bct.clinical_treatment_type_id) not in    \r\n" + 
		            "(select sti.beneficiary_id , sbct.treatment_date,sbct.clinical_treatment_type_id  from soch.ti_beneficiary sti    \r\n" + 
		            "join soch.beneficiary_clinical_treatment sbct on sbct.beneficiary_id=sti.beneficiary_id    \r\n" + 
		            "and (sbct.treatment_date +(INTERVAL '1 day' * sbct.rmc_followup_frequency)) >current_date)   \r\n" + 
		            "and bfm.facility_id =:facilityId and tb.facility_id =:facilityId and tb.is_deleted = false and coalesce(bct.is_delete,'false') = false and tm.typology_id not in (5,6)\r\n" + 
		            "group by b.uid , b.first_name , b.last_name ,tb.ti_code , tm.typology_name ,b.date_of_birth ,\r\n" + 
		            "mg.name ,mcst.name ,tb.beneficiary_id , tb.id ,tb.date_of_reg,b.death_date,b.age",
		            nativeQuery = true)
		 Page<RmcDueListProjection> getRMCDueListWithoutFilter(@Param("facilityId") Long facilityId , Pageable pageable );
		 
			@Query(value = " select b.uid as uid ,CONCAT( b.first_name,' ', b.last_name ) as name, tb.ti_code as tiCode , tm.typology_name as typology\r\n" + 
					",b.date_of_birth as dateOfBirth ,b.death_date as DeathDate,mg.name as gender ,mcst.name as status,min(bct.treatment_date) as diagnosisDate \r\n" + 
					",tb.beneficiary_id as beneficiaryId ,tb.id as tbId ,tb.date_of_reg as registrationDate \r\n" + 
					"from soch.ti_beneficiary tb   \r\n" + 
					"join soch.beneficiary b on b.id = tb.beneficiary_id   \r\n" + 
					"join soch.typology_master tm on tm.typology_id  = tb.master_hrg_primary_id   \r\n" + 
					"join soch.master_gender mg on mg.id = b.gender_id   \r\n" + 
					"join soch.master_client_status_ticore mcst on mcst.id = tb.status_id   \r\n" + 
					"join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = tb.beneficiary_id   \r\n" + 
					"join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = tb.beneficiary_id  \r\n" + 
					"where (bct.treatment_date +(INTERVAL '1 day' * bct.rmc_followup_frequency)) < current_date \r\n" + 
					"and bfm.facility_id = :facilityId and tb.facility_id =:facilityId and tb.is_deleted = false and coalesce(bct.is_delete,'false') = false and tm.typology_id not in (5,6)\r\n" + 
					"group by b.uid , b.first_name , b.last_name , tb.ti_code , tm.typology_name , b.date_of_birth ,mg.name ,mcst.name,\r\n" + 
					"tb.beneficiary_id ,tb.id , tb.date_of_reg,b.death_date,b.age  " 
					, nativeQuery = true)
			Page<RmcDueListProjection> getMissedRMCDueListWithoutFilter(@Param("facilityId") Long facilityId , Pageable pageable);

			@Query(value = "  select b.uid as uid ,CONCAT( b.first_name,' ', b.last_name ) as name, tb.ti_code as tiCode , tm.typology_name as typology\r\n" + 
					",b.date_of_birth as dateOfBirth,b.death_date as DeathDate,mg.name as gender ,mcst.name as status,min(bct.treatment_date) as diagnosisDate\r\n" + 
					",tb.beneficiary_id as beneficiaryId ,tb.id as tbId ,tb.date_of_reg as registrationDate \r\n" + 
					"from soch.ti_beneficiary tb   \r\n" + 
					"join soch.beneficiary b on b.id = tb.beneficiary_id   \r\n" + 
					"join soch.typology_master tm on tm.typology_id  = tb.master_hrg_primary_id   \r\n" + 
					"join soch.master_gender mg on mg.id = b.gender_id   \r\n" + 
					"join soch.master_client_status_ticore mcst on mcst.id = tb.status_id   \r\n" + 
					"join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = tb.beneficiary_id   \r\n" + 
					"left join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = tb.beneficiary_id  \r\n" + 
					"where  (tb.beneficiary_id , bct.treatment_date ,bct.clinical_treatment_type_id) not in    \r\n" + 
					"(select sti.beneficiary_id , sbct.treatment_date ,sbct.clinical_treatment_type_id  from soch.ti_beneficiary sti    \r\n" + 
					"join soch.beneficiary_clinical_treatment sbct on sbct.beneficiary_id=sti.beneficiary_id    \r\n" + 
					"and (((sbct.treatment_date +(INTERVAL '1 day' * sbct.rmc_followup_frequency)) >current_date)  \r\n" + 
					"or ((sbct.treatment_date +(INTERVAL '1 day' * sbct.rmc_followup_frequency)) <current_date))) \r\n" + 
					"and bfm.facility_id = :facilityId and tb.facility_id =:facilityId and tb.is_deleted = false and coalesce(bct.is_delete,'false') = false and tm.typology_id not in (5,6)\r\n" + 
					"group by b.uid , b.first_name , b.last_name , tb.ti_code , tm.typology_name , b.date_of_birth ,mg.name ,mcst.name,\r\n" + 
					"tb.beneficiary_id ,tb.id , tb.date_of_reg,b.death_date,b.age " 
					, nativeQuery = true)
			Page<RmcDueListProjection> getUpcomingRMCDueListWithoutFilter(@Param("facilityId") Long facilityId , Pageable pageable);

	    
	    
}
