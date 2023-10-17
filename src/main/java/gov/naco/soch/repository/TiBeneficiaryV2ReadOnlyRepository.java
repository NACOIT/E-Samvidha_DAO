package gov.naco.soch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.naco.soch.entity.TiBeneficiaryV2ReadOnly;
import gov.naco.soch.projection.TiBeneficiaryProjection;

public interface TiBeneficiaryV2ReadOnlyRepository
		extends JpaRepository<TiBeneficiaryV2ReadOnly, Long>, JpaSpecificationExecutor<TiBeneficiaryV2ReadOnly> {
	@Override
	@EntityGraph(value = "tiBeneficiaryV2ReadOnlyGraph")
	Page<TiBeneficiaryV2ReadOnly> findAll(Specification<TiBeneficiaryV2ReadOnly> spec, Pageable pageable);

	String query = " select tiben.id as id,ben.id as beneficiaryId,ben.date_of_birth as dateOfBirth,ben.uid as uid,ben.first_name as firstname, ben.mobile_number as mobile, ben.last_name as lastname,tiben.ti_code as tiCode,\r\n"
			+ "    tm.typology_id as typologyId,tm.typology_name as typologyName, bg.name as gender,cs.name as masterClientStatus , \r\n"
			+ "	 tiben.date_of_reg as dateOfReg,tiben.facility_id as facilityId,bfm.id as bfmId,bfm.beneficiary_id as bfmBenId,bfm.facility_id as bfmFacilityId,fac.facility_type_id as bfmFacilityTypeId, \r\n"
			+ "    msc.id as statusId,msc.name as status from soch.ti_beneficiary tiben left outer join soch.beneficiary ben on tiben.beneficiary_id=ben.id \r\n"
			+ "    left outer join soch.beneficiary_facility_mapping bfm on ben.id=bfm.beneficiary_id \r\n"
			+ "   and (bfm.is_active=true) left outer join soch.facility fac on bfm.facility_id=fac.id\r\n"
			+ "   left outer join soch.master_client_status_ticore msc on tiben.status_id=msc.id \r\n"
			+ "   left outer join soch.typology_master tm on tm.typology_id = tiben.master_hrg_primary_id\r\n"
			+ "   left outer join soch.master_gender bg on ben.gender_id = bg.id \r\n"
			+ "   left outer join soch.master_client_status cs on ben.client_status_id = cs.id \r\n"
			+ "   where fac.id=:facilityId and tiben.is_deleted=:isDeleted and ben.ti_benf_search_str ilike :searchString order by tiben.id desc";

	String count = " select count(*) from soch.ti_beneficiary tiben left outer join soch.beneficiary ben on tiben.beneficiary_id=ben.id \r\n"
			+ "   left outer join soch.beneficiary_facility_mapping bfm on ben.id=bfm.beneficiary_id \r\n"
			+ "   and (bfm.is_active=true) left outer join soch.facility fac on bfm.facility_id=fac.id\r\n"
			+ "   left outer join soch.master_client_status_ticore msc on tiben.status_id=msc.id \r\n"
			+ "   left outer join soch.typology_master tm on tm.typology_id = tiben.master_hrg_primary_id\r\n"
			+ "   left outer join soch.master_gender bg on ben.gender_id = bg.id \r\n"
			+ "   where fac.id=:facilityId and tiben.is_deleted=:isDeleted and ben.ti_benf_search_str ilike :searchString";

	@Query(nativeQuery = true, value = query, countQuery = count)
	Page<TiBeneficiaryProjection> findTiBeneficiaryByBasicSearchWithTsVector(@Param("facilityId") Long facilityId,
			@Param("isDeleted") Boolean isDeleted, @Param("searchString") String searchString, Pageable pageable);
	
	
	
	String reportsQuery="select tiben.id as Id,  tiben.ti_code as TiCode, ben.uid as Uid, ben.id as BeneficiaryId,ben.first_name as FirstName,\r\n" + 
			"ben.death_date as DeathDate, ben.last_name as LastName,ben.date_of_birth as dateOfBirth,ben.mobile_number as mobile,\r\n" +
			"ben.pre_art_number as artNumber,fac.name as FacilityName,gen.name as Gender,typo.typology_name  as TypologyName,\r\n" + 
			"mcst.name as Status,ostBen.ost_number as OstNumber,mabs.name as ArtStatus,string_agg(mhss.name,',') as HivScreeningStatus,\r\n" + 
			"mhs.name as HivConfirmatoryStatus, mosb.name as OstStatus ,\r\n" + 
			"case when hrg_p.id=1 then fsw.name\r\n" + 
			"when hrg_p.id=2 then msm.name\r\n" + 
			"when hrg_p.id=3 then tg.name\r\n" + 
			"when hrg_p.id=4 then idu.name\r\n" + 
			"when hrg_p.id=5 then trucker.name\r\n" + 
			"when hrg_p.id=6 then migrant.name\r\n" + 
			"else 'Not Selected'\r\n" + 
			"end as HRGSubcategory,\r\n" + 
			"tiben.date_of_reg as DateOfRegistration , orw_code as ORW,pe_code as PE,marital.name as MaritalStatus,edu.name as EducationalLevel,\r\n" + 
			"occ.name as EmploymentStatus,CONCAT(addr.address_line_one, ' ',addr.address_line_two) as Address,hot.hotspot_name as HotspotName,\r\n" + 
			"tiben.number_of_partners as RegularPartner,tiben.avg_no_sexual_acts_upon_reg as AverageNoSexualActsUponReg,\r\n" + 
			"tiben.no_years_in_sex_work as NumberOfyearsInSexWork,tiben.consume_alcohol as ConsumesAlcohol,\r\n" +
			"artFacility.name as artFacilityName , ostFacility.name as ostFacilityName\r\n" +
			"from soch.ti_beneficiary tiben\r\n" + 
			"left outer join soch.beneficiary ben  on tiben.beneficiary_id = ben.id\r\n" + 
			"left outer join soch.beneficiary_facility_mapping beneficiar2_  on ben.id = beneficiar2_.beneficiary_id  \r\n" + 
			"left outer join soch.facility fac  on beneficiar2_.facility_id = fac.id\r\n" + 
			"left outer join soch.master_gender gen on gen.id=ben.gender_id\r\n" + 
			"left outer join soch.typology_master typo on typo.typology_id=tiben.master_hrg_primary_id\r\n" + 
			"left outer join soch.master_client_status_ticore mcst on mcst.id=tiben.status_id\r\n" + 
			"left outer join soch.ti_ost_beneficiary ostBen  on ostBen.beneficiary_id = ben.id\r\n" + 
			"left outer join soch.art_beneficiary artBen  on artBen.beneficiary_id = ben.id\r\n" + 
			"left outer join soch.master_art_beneficiary_status mabs on mabs.id=artBen.art_beneficiary_status_id\r\n" + 
			"left outer join soch.ti_ben_scr_details tibenscr on tibenscr.beneficiary_id=tiben.id\r\n" + 
			"left outer join soch.master_hiv_screening_status mhss on mhss.id=tibenscr.screening_status_hiv_id\r\n" + 
			"left outer join soch.master_hiv_status mhs ON mhs.id = ben.hiv_status_id\r\n" + 
			"left outer join soch.master_ost_status_beneficiary mosb on mosb.id=ostBen.ost_status_id\r\n" + 
			"left join soch.master_fswsubcategory fsw on fsw.id=tiben.master_fsw_subcategory_id\r\n" + 
			"left join soch.master_msmsubcategory msm on msm.id=tiben.master_msm_subcategory_id\r\n" + 
			"left join soch.master_tgsubcategory tg on tg.id=tiben.master_tg_subcategory_id\r\n" + 
			"left join soch.master_idusubcategory idu on idu.id=tiben.master_idu_subcategory_id\r\n" + 
			"left join soch.master_occupation_trucker trucker on trucker.id=tiben.trucker_occupation_id\r\n" + 
			"left join soch.master_migrant_occupation migrant on migrant.id=tiben.migrant_occupation_id\r\n" + 
			"left join soch.master_marital_status marital on marital.id=ben.marital_status_id\r\n" + 
			"left join soch.master_occupation occ on occ.id=ben.occupation_id\r\n" + 
			"left join soch.master_education_level edu on edu.id=ben.education_level_id\r\n" + 
			"left join soch.address addr on addr.id=ben.address_id\r\n" + 
			"left join soch.ti_hotspot hot on hot.id=tiben.hotspot\r\n" + 
			"join soch.master_hrg_primary hrg_p on tiben.master_hrg_primary_id=hrg_p.id\r\n" +
			"left join soch.facility artFacility  on artFacility.id = artBen.facility_id\r\n"+
			"left join soch.facility ostFacility  on ostFacility.id = ostBen.facility_id\r\n"+
			"where fac.id =:facilityId  and ((tibenscr.modified_time in  (select max(tbsd2.modified_time) from soch.ti_ben_scr_details tbsd2\r\n" + 
			"inner join soch.ti_beneficiary tb2 on tbsd2.beneficiary_id = tb2.id\r\n" + 
			"and tiben.id = tbsd2.beneficiary_id)) or tibenscr.modified_time is null)\r\n" + 
			" and  tiben.is_deleted=:isDeleted \r\n"+
			" group by tiben.id ,  tiben.ti_code,ben.uid , ben.id ,ben.first_name ,ben.death_date , ben.last_name ,ben.date_of_birth ,ben.mobile_number ,ben.pre_art_number ,fac.name,gen.name,typo.typology_name,mcst.name,ostBen.ost_number,mabs.name,mhs.name , mosb.name ,case when hrg_p.id=1 then fsw.name when hrg_p.id=2 then msm.name when hrg_p.id=3 then tg.name when hrg_p.id=4 then idu.name when hrg_p.id=5 then trucker.name when hrg_p.id=6 then migrant.name else 'Not Selected' end ,tiben.date_of_reg,orw_code ,pe_code ,marital.name ,edu.name,occ.name,CONCAT(addr.address_line_one, ' ',addr.address_line_two) ,hot.hotspot_name,tiben.number_of_partners ,tiben.avg_no_sexual_acts_upon_reg,tiben.no_years_in_sex_work ,tiben.consume_alcohol ,artFacility.name , ostFacility.name";
	
	
	String reportsCountQuery="select  count(tiben.id) from soch.ti_beneficiary tiben\r\n" + 
			"left outer join soch.beneficiary ben  on tiben.beneficiary_id = ben.id\r\n" + 
			"left outer join soch.beneficiary_facility_mapping beneficiar2_  on ben.id = beneficiar2_.beneficiary_id \r\n" + 
			"left outer join soch.facility fac  on beneficiar2_.facility_id = fac.id\r\n" + 
			"left outer join soch.master_gender gen on gen.id=ben.gender_id\r\n" + 
			"left outer join soch.typology_master typo on typo.typology_id=tiben.master_hrg_primary_id\r\n" + 
			"left outer join soch.master_client_status_ticore mcst on mcst.id=tiben.status_id\r\n" + 
			"left outer join soch.ti_ost_beneficiary ostBen  on ostBen.beneficiary_id = ben.id\r\n" + 
			"left outer join soch.art_beneficiary artBen  on artBen.beneficiary_id = ben.id\r\n" + 
			"left outer join soch.master_art_beneficiary_status mabs on mabs.id=artBen.art_beneficiary_status_id\r\n" + 
			"left outer join soch.ti_ben_scr_details tibenscr on tibenscr.beneficiary_id=tiben.id\r\n" + 
			"left outer join soch.master_hiv_screening_status mhss on mhss.id=tibenscr.screening_status_hiv_id\r\n" + 
			"left outer join soch.master_hiv_status mhs ON mhs.id = ben.hiv_status_id\r\n" + 
			"left outer join soch.master_ost_status_beneficiary mosb on mosb.id=ostBen.ost_status_id\r\n" + 
			"left join soch.master_fswsubcategory fsw on fsw.id=tiben.master_fsw_subcategory_id\r\n" + 
			"left join soch.master_msmsubcategory msm on msm.id=tiben.master_msm_subcategory_id\r\n" + 
			"left join soch.master_tgsubcategory tg on tg.id=tiben.master_tg_subcategory_id\r\n" + 
			"left join soch.master_idusubcategory idu on idu.id=tiben.master_idu_subcategory_id\r\n" + 
			"left join soch.master_occupation_trucker trucker on trucker.id=tiben.trucker_occupation_id\r\n" + 
			"left join soch.master_migrant_occupation migrant on migrant.id=tiben.migrant_occupation_id\r\n" + 
			"left join soch.master_marital_status marital on marital.id=ben.marital_status_id\r\n" + 
			"left join soch.master_occupation occ on occ.id=ben.occupation_id\r\n" + 
			"left join soch.master_education_level edu on edu.id=ben.education_level_id\r\n" + 
			"left join soch.address addr on addr.id=ben.address_id\r\n" + 
			"left join soch.ti_hotspot hot on hot.id=tiben.hotspot\r\n" + 
			"join soch.master_hrg_primary hrg_p on tiben.master_hrg_primary_id=hrg_p.id\r\n" + 
			"left join soch.facility artFacility  on artFacility.id = artBen.facility_id\r\n"+
			"left join soch.facility ostFacility  on ostFacility.id = ostBen.facility_id\r\n"+
			"where fac.id =:facilityId and ((tibenscr.modified_time in  (select max(tbsd2.modified_time) from soch.ti_ben_scr_details tbsd2\r\n" + 
			"inner join soch.ti_beneficiary tb2 on tbsd2.beneficiary_id = tb2.id\r\n" + 
			"and tiben.id = tbsd2.beneficiary_id)) or tibenscr.modified_time is null)\r\n" + 
			" and  tiben.is_deleted=:isDeleted \r\n"+
			" group by tiben.id ,  tiben.ti_code,ben.uid , ben.id ,ben.first_name ,ben.death_date , ben.last_name ,ben.date_of_birth ,ben.mobile_number ,ben.pre_art_number ,fac.name,gen.name,typo.typology_name,mcst.name,ostBen.ost_number,mabs.name,mhs.name , mosb.name ,case when hrg_p.id=1 then fsw.name when hrg_p.id=2 then msm.name when hrg_p.id=3 then tg.name when hrg_p.id=4 then idu.name when hrg_p.id=5 then trucker.name when hrg_p.id=6 then migrant.name else 'Not Selected' end ,tiben.date_of_reg,orw_code ,pe_code ,marital.name ,edu.name,occ.name,CONCAT(addr.address_line_one, ' ',addr.address_line_two) ,hot.hotspot_name,tiben.number_of_partners ,tiben.avg_no_sexual_acts_upon_reg,tiben.no_years_in_sex_work ,tiben.consume_alcohol ,artFacility.name , ostFacility.name";
	
	
	@Query(nativeQuery = true, value = reportsQuery, countQuery = reportsCountQuery)
	Page<TiBeneficiaryProjection> getTiReportsData(@Param("facilityId") Long facilityId,
			@Param("isDeleted") Boolean isDeleted, Pageable pageable);
	
	
	String reportsSearchQuery="select tiben.id as Id,  tiben.ti_code as TiCode, ben.uid as Uid, ben.id as BeneficiaryId,ben.first_name as FirstName,\r\n" + 
			"ben.death_date as DeathDate, ben.last_name as LastName,ben.date_of_birth as DateOfBirth,ben.mobile_number as MobileNumber,\r\n" + 
			"ben.pre_art_number as artNumber,fac.name as FacilityName,gen.name as Gender,typo.typology_name  as TypologyName,\r\n" + 
			"mcst.name as Status,ostBen.ost_number as OstNumber,mabs.name as ArtStatus,string_agg(mhss.name,',') as HivScreeningStatus,\r\n" + 
			"mhs.name as HivConfirmatoryStatus, mosb.name as OstStatus ,\r\n" + 
			"case when hrg_p.id=1 then fsw.name\r\n" + 
			"when hrg_p.id=2 then msm.name\r\n" + 
			"when hrg_p.id=3 then tg.name\r\n" + 
			"when hrg_p.id=4 then idu.name\r\n" + 
			"when hrg_p.id=5 then trucker.name\r\n" + 
			"when hrg_p.id=6 then migrant.name\r\n" + 
			"else 'Not Selected'\r\n" + 
			"end as HRGSubcategory,\r\n" + 
			"tiben.date_of_reg as DateOfRegistration , orw_code as ORW,pe_code as PE,marital.name as MaritalStatus,edu.name as EducationalLevel,\r\n" + 
			"occ.name as EmploymentStatus,CONCAT(addr.address_line_one, ' ',addr.address_line_two) as Address,hot.hotspot_name as HotspotName,\r\n" + 
			"tiben.number_of_partners as RegularPartner,tiben.avg_no_sexual_acts_upon_reg as AverageNoSexualActsUponReg,\r\n" + 
			"tiben.no_years_in_sex_work as NumberOfyearsInSexWork,tiben.consume_alcohol as ConsumesAlcohol,\r\n" + 
			"artFacility.name as artFacilityName , ostFacility.name as ostFacilityName\r\n" +
			"from soch.ti_beneficiary tiben\r\n" + 
			"left outer join soch.beneficiary ben  on tiben.beneficiary_id = ben.id\r\n" + 
			"left outer join soch.beneficiary_facility_mapping beneficiar2_  on ben.id = beneficiar2_.beneficiary_id  \r\n" + 
			"left outer join soch.facility fac  on beneficiar2_.facility_id = fac.id\r\n" + 
			"left outer join soch.master_gender gen on gen.id=ben.gender_id\r\n" + 
			"left outer join soch.typology_master typo on typo.typology_id=tiben.master_hrg_primary_id\r\n" + 
			"left outer join soch.master_client_status_ticore mcst on mcst.id=tiben.status_id\r\n" + 
			"left outer join soch.ti_ost_beneficiary ostBen  on ostBen.beneficiary_id = ben.id\r\n" + 
			"left outer join soch.art_beneficiary artBen  on artBen.beneficiary_id = ben.id\r\n" + 
			"left outer join soch.master_art_beneficiary_status mabs on mabs.id=artBen.art_beneficiary_status_id\r\n" + 
			"left outer join soch.ti_ben_scr_details tibenscr on tibenscr.beneficiary_id=tiben.id\r\n" + 
			"left outer join soch.master_hiv_screening_status mhss on mhss.id=tibenscr.screening_status_hiv_id\r\n" + 
			"left outer join soch.master_hiv_status mhs ON mhs.id = ben.hiv_status_id\r\n" + 
			"left outer join soch.master_ost_status_beneficiary mosb on mosb.id=ostBen.ost_status_id\r\n" + 
			"left join soch.master_fswsubcategory fsw on fsw.id=tiben.master_fsw_subcategory_id\r\n" + 
			"left join soch.master_msmsubcategory msm on msm.id=tiben.master_msm_subcategory_id\r\n" + 
			"left join soch.master_tgsubcategory tg on tg.id=tiben.master_tg_subcategory_id\r\n" + 
			"left join soch.master_idusubcategory idu on idu.id=tiben.master_idu_subcategory_id\r\n" + 
			"left join soch.master_occupation_trucker trucker on trucker.id=tiben.trucker_occupation_id\r\n" + 
			"left join soch.master_migrant_occupation migrant on migrant.id=tiben.migrant_occupation_id\r\n" + 
			"left join soch.master_marital_status marital on marital.id=ben.marital_status_id\r\n" + 
			"left join soch.master_occupation occ on occ.id=ben.occupation_id\r\n" + 
			"left join soch.master_education_level edu on edu.id=ben.education_level_id\r\n" + 
			"left join soch.address addr on addr.id=ben.address_id\r\n" + 
			"left join soch.ti_hotspot hot on hot.id=tiben.hotspot\r\n" + 
			"join soch.master_hrg_primary hrg_p on tiben.master_hrg_primary_id=hrg_p.id\r\n" +
			"left join soch.facility artFacility  on artFacility.id = artBen.facility_id\r\n"+
			"left join soch.facility ostFacility  on ostFacility.id = ostBen.facility_id\r\n"+
			"where fac.id =:facilityId and ((tibenscr.modified_time in  (select max(tbsd2.modified_time) from soch.ti_ben_scr_details tbsd2\r\n" + 
			"inner join soch.ti_beneficiary tb2 on tbsd2.beneficiary_id = tb2.id\r\n" + 
			"and tiben.id = tbsd2.beneficiary_id)) or tibenscr.modified_time is null)\r\n" + 
			" and  tiben.is_deleted=:isDeleted and ben.ti_benf_search_str ilike :param \r\n" +
			" group by tiben.id ,  tiben.ti_code,ben.uid , ben.id ,ben.first_name ,ben.death_date , ben.last_name ,ben.date_of_birth ,ben.mobile_number ,ben.pre_art_number ,fac.name,gen.name,typo.typology_name,mcst.name,ostBen.ost_number,mabs.name,mhs.name , mosb.name ,case when hrg_p.id=1 then fsw.name when hrg_p.id=2 then msm.name when hrg_p.id=3 then tg.name when hrg_p.id=4 then idu.name when hrg_p.id=5 then trucker.name when hrg_p.id=6 then migrant.name else 'Not Selected' end ,tiben.date_of_reg,orw_code ,pe_code ,marital.name ,edu.name,occ.name,CONCAT(addr.address_line_one, ' ',addr.address_line_two) ,hot.hotspot_name,tiben.number_of_partners ,tiben.avg_no_sexual_acts_upon_reg,tiben.no_years_in_sex_work ,tiben.consume_alcohol ,artFacility.name , ostFacility.name";
	
	
	String reportsSearchCountQuery="select  count(tiben.id) from soch.ti_beneficiary tiben\r\n" + 
			"left outer join soch.beneficiary ben  on tiben.beneficiary_id = ben.id\r\n" + 
			"left outer join soch.beneficiary_facility_mapping beneficiar2_  on ben.id = beneficiar2_.beneficiary_id \r\n" + 
			"left outer join soch.facility fac  on beneficiar2_.facility_id = fac.id\r\n" + 
			"left outer join soch.master_gender gen on gen.id=ben.gender_id\r\n" + 
			"left outer join soch.typology_master typo on typo.typology_id=tiben.master_hrg_primary_id\r\n" + 
			"left outer join soch.master_client_status_ticore mcst on mcst.id=tiben.status_id\r\n" + 
			"left outer join soch.ti_ost_beneficiary ostBen  on ostBen.beneficiary_id = ben.id\r\n" + 
			"left outer join soch.art_beneficiary artBen  on artBen.beneficiary_id = ben.id\r\n" + 
			"left outer join soch.master_art_beneficiary_status mabs on mabs.id=artBen.art_beneficiary_status_id\r\n" + 
			"left outer join soch.ti_ben_scr_details tibenscr on tibenscr.beneficiary_id=tiben.id\r\n" + 
			"left outer join soch.master_hiv_screening_status mhss on mhss.id=tibenscr.screening_status_hiv_id\r\n" + 
			"left outer join soch.master_hiv_status mhs ON mhs.id = ben.hiv_status_id\r\n" + 
			"left outer join soch.master_ost_status_beneficiary mosb on mosb.id=ostBen.ost_status_id\r\n" + 
			"left join soch.master_fswsubcategory fsw on fsw.id=tiben.master_fsw_subcategory_id\r\n" + 
			"left join soch.master_msmsubcategory msm on msm.id=tiben.master_msm_subcategory_id\r\n" + 
			"left join soch.master_tgsubcategory tg on tg.id=tiben.master_tg_subcategory_id\r\n" + 
			"left join soch.master_idusubcategory idu on idu.id=tiben.master_idu_subcategory_id\r\n" + 
			"left join soch.master_occupation_trucker trucker on trucker.id=tiben.trucker_occupation_id\r\n" + 
			"left join soch.master_migrant_occupation migrant on migrant.id=tiben.migrant_occupation_id\r\n" + 
			"left join soch.master_marital_status marital on marital.id=ben.marital_status_id\r\n" + 
			"left join soch.master_occupation occ on occ.id=ben.occupation_id\r\n" + 
			"left join soch.master_education_level edu on edu.id=ben.education_level_id\r\n" + 
			"left join soch.address addr on addr.id=ben.address_id\r\n" + 
			"left join soch.ti_hotspot hot on hot.id=tiben.hotspot\r\n" + 
			"join soch.master_hrg_primary hrg_p on tiben.master_hrg_primary_id=hrg_p.id\r\n" +
			"left join soch.facility artFacility  on artFacility.id = artBen.facility_id\r\n"+
			"left join soch.facility ostFacility  on ostFacility.id = ostBen.facility_id\r\n"+
			"where fac.id =:facilityId and ((tibenscr.modified_time in  (select max(tbsd2.modified_time) from soch.ti_ben_scr_details tbsd2\r\n" + 
			"inner join soch.ti_beneficiary tb2 on tbsd2.beneficiary_id = tb2.id\r\n" + 
			"and tiben.id = tbsd2.beneficiary_id)) or tibenscr.modified_time is null)\r\n" + 
			" and  tiben.is_deleted=:isDeleted and ben.ti_benf_search_str ilike :param \r\n"+
			" group by tiben.id ,  tiben.ti_code,ben.uid , ben.id ,ben.first_name ,ben.death_date , ben.last_name ,ben.date_of_birth ,ben.mobile_number ,ben.pre_art_number ,fac.name,gen.name,typo.typology_name,mcst.name,ostBen.ost_number,mabs.name,mhs.name , mosb.name ,case when hrg_p.id=1 then fsw.name when hrg_p.id=2 then msm.name when hrg_p.id=3 then tg.name when hrg_p.id=4 then idu.name when hrg_p.id=5 then trucker.name when hrg_p.id=6 then migrant.name else 'Not Selected' end ,tiben.date_of_reg,orw_code ,pe_code ,marital.name ,edu.name,occ.name,CONCAT(addr.address_line_one, ' ',addr.address_line_two) ,hot.hotspot_name,tiben.number_of_partners ,tiben.avg_no_sexual_acts_upon_reg,tiben.no_years_in_sex_work ,tiben.consume_alcohol ,artFacility.name , ostFacility.name";
	
	
	@Query(nativeQuery = true, value = reportsSearchQuery, countQuery = reportsSearchCountQuery)
	Page<TiBeneficiaryProjection> getTiReportsSearchData(@Param("facilityId") Long facilityId,
			@Param("isDeleted") Boolean isDeleted,@Param("param") String param ,Pageable pageable);
	
	
	String reportsAdvSearchStatusQuery="select tiben.id as Id,  tiben.ti_code as TiCode, ben.uid as Uid, ben.id as BeneficiaryId,ben.first_name as FirstName,\r\n" +
			"ben.death_date as DeathDate, ben.last_name as LastName,ben.date_of_birth as DateOfBirth,ben.mobile_number as MobileNumber,\r\n" +
			"ben.pre_art_number as artNumber,fac.name as FacilityName,gen.name as Gender,typo.typology_name  as TypologyName,\r\n" +
			"mcst.name as Status,ostBen.ost_number as OstNumber,mabs.name as ArtStatus,string_agg(mhss.name,',') as HivScreeningStatus,\r\n" +
			"mhs.name as HivConfirmatoryStatus, mosb.name as OstStatus ,\r\n" +
			"case when hrg_p.id=1 then fsw.name\r\n" +
			"when hrg_p.id=2 then msm.name\r\n" +
			"when hrg_p.id=3 then tg.name\r\n" +
			"when hrg_p.id=4 then idu.name\r\n" +
			"when hrg_p.id=5 then trucker.name\r\n" +
			"when hrg_p.id=6 then migrant.name\r\n" +
			"else 'Not Selected'\r\n" +
			"end as HRGSubcategory,\r\n" +
			"tiben.date_of_reg as DateOfRegistration , orw_code as ORW,pe_code as PE,marital.name as MaritalStatus,edu.name as EducationalLevel,\r\n" +
			"occ.name as EmploymentStatus,CONCAT(addr.address_line_one, ' ',addr.address_line_two) as Address,hot.hotspot_name as HotspotName,\r\n" +
			"tiben.number_of_partners as RegularPartner,tiben.avg_no_sexual_acts_upon_reg as AverageNoSexualActsUponReg,\r\n" +
			"tiben.no_years_in_sex_work as NumberOfyearsInSexWork,tiben.consume_alcohol as ConsumesAlcohol,\r\n" +
			"artFacility.name as artFacilityName , ostFacility.name as ostFacilityName\r\n" +
			"from soch.ti_beneficiary tiben\r\n" +
			"left outer join soch.beneficiary ben  on tiben.beneficiary_id = ben.id\r\n" +
			"left outer join soch.facility fac  on tiben.facility_id = fac.id\r\n" +
			"left outer join soch.master_gender gen on gen.id=ben.gender_id\r\n" +
			"left outer join soch.typology_master typo on typo.typology_id=tiben.master_hrg_primary_id\r\n" +
			"left outer join soch.master_client_status_ticore mcst on mcst.id=tiben.status_id\r\n" +
			"left outer join soch.ti_ost_beneficiary ostBen  on ostBen.beneficiary_id = ben.id\r\n" +
			"left outer join soch.art_beneficiary artBen  on artBen.beneficiary_id = ben.id\r\n" +
			"left outer join soch.master_art_beneficiary_status mabs on mabs.id=artBen.art_beneficiary_status_id\r\n" +
			"left outer join soch.ti_ben_scr_details tibenscr on tibenscr.beneficiary_id=tiben.id\r\n" +
			"left outer join soch.master_hiv_screening_status mhss on mhss.id=tibenscr.screening_status_hiv_id\r\n" +
			"left outer join soch.master_hiv_status mhs ON mhs.id = ben.hiv_status_id\r\n" +
			"left outer join soch.master_ost_status_beneficiary mosb on mosb.id=ostBen.ost_status_id\r\n" +
			"left join soch.master_fswsubcategory fsw on fsw.id=tiben.master_fsw_subcategory_id\r\n" +
			"left join soch.master_msmsubcategory msm on msm.id=tiben.master_msm_subcategory_id\r\n" +
			"left join soch.master_tgsubcategory tg on tg.id=tiben.master_tg_subcategory_id\r\n" +
			"left join soch.master_idusubcategory idu on idu.id=tiben.master_idu_subcategory_id\r\n" +
			"left join soch.master_occupation_trucker trucker on trucker.id=tiben.trucker_occupation_id\r\n" +
			"left join soch.master_migrant_occupation migrant on migrant.id=tiben.migrant_occupation_id\r\n" +
			"left join soch.master_marital_status marital on marital.id=ben.marital_status_id\r\n" +
			"left join soch.master_occupation occ on occ.id=ben.occupation_id\r\n" +
			"left join soch.master_education_level edu on edu.id=ben.education_level_id\r\n" +
			"left join soch.address addr on addr.id=ben.address_id\r\n" +
			"left join soch.ti_hotspot hot on hot.id=tiben.hotspot\r\n" +
			"join soch.master_hrg_primary hrg_p on tiben.master_hrg_primary_id=hrg_p.id\r\n" +
			"left join soch.facility artFacility  on artFacility.id = artBen.facility_id\r\n"+
			"left join soch.facility ostFacility  on ostFacility.id = ostBen.facility_id\r\n"+
			"where fac.id =:facilityId and ((tibenscr.modified_time in  (select max(tbsd2.modified_time) from soch.ti_ben_scr_details tbsd2\r\n" +
			"inner join soch.ti_beneficiary tb2 on tbsd2.beneficiary_id = tb2.id\r\n" +
			"and tiben.id = tbsd2.beneficiary_id)) or tibenscr.modified_time is null)\r\n" +
			" and  tiben.is_deleted=:isDeleted and (0=:hivStatus or mhs.id=:hivStatus)  and  ('' like :gender or gen.name ilike :gender) and (0=:statusId or mcst.id=:statusId) and ('' like %:tiCode% or tiben.ti_code ilike %:tiCode%)"+
			"   and ('' like :typology or typo.typology_name ilike :typology) and ('' like %:mobileNumber% or ben.mobile_number ilike %:mobileNumber%) and ('' like %:uid% or ben.uid ilike %:uid%) and ('' like %:name% or ben.first_name ilike %:name%) \r\n"+
			" group by tiben.id ,  tiben.ti_code,ben.uid , ben.id ,ben.first_name ,ben.death_date , ben.last_name ,ben.date_of_birth ,ben.mobile_number ,ben.pre_art_number ,fac.name,gen.name,typo.typology_name,mcst.name,ostBen.ost_number,mabs.name,mhs.name , mosb.name ,case when hrg_p.id=1 then fsw.name when hrg_p.id=2 then msm.name when hrg_p.id=3 then tg.name when hrg_p.id=4 then idu.name when hrg_p.id=5 then trucker.name when hrg_p.id=6 then migrant.name else 'Not Selected' end ,tiben.date_of_reg,orw_code ,pe_code ,marital.name ,edu.name,occ.name,CONCAT(addr.address_line_one, ' ',addr.address_line_two) ,hot.hotspot_name,tiben.number_of_partners ,tiben.avg_no_sexual_acts_upon_reg,tiben.no_years_in_sex_work ,tiben.consume_alcohol ,artFacility.name , ostFacility.name";

	String reportsAdvSearchStatusCountQuery="select  count(tiben.id) from soch.ti_beneficiary tiben\r\n" +
			"left outer join soch.beneficiary ben  on tiben.beneficiary_id = ben.id\r\n" +
			"left outer join soch.facility fac  on tiben.facility_id = fac.id\r\n" +
			"left outer join soch.master_gender gen on gen.id=ben.gender_id\r\n" +
			"left outer join soch.typology_master typo on typo.typology_id=tiben.master_hrg_primary_id\r\n" +
			"left outer join soch.master_client_status_ticore mcst on mcst.id=tiben.status_id\r\n" +
			"left outer join soch.ti_ost_beneficiary ostBen  on ostBen.beneficiary_id = ben.id\r\n" +
			"left outer join soch.art_beneficiary artBen  on artBen.beneficiary_id = ben.id\r\n" +
			"left outer join soch.master_art_beneficiary_status mabs on mabs.id=artBen.art_beneficiary_status_id\r\n" +
			"left outer join soch.ti_ben_scr_details tibenscr on tibenscr.beneficiary_id=tiben.id\r\n" +
			"left outer join soch.master_hiv_screening_status mhss on mhss.id=tibenscr.screening_status_hiv_id\r\n" +
			"left outer join soch.master_hiv_status mhs ON mhs.id = ben.hiv_status_id\r\n" +
			"left outer join soch.master_ost_status_beneficiary mosb on mosb.id=ostBen.ost_status_id\r\n" +
			"left join soch.master_fswsubcategory fsw on fsw.id=tiben.master_fsw_subcategory_id\r\n" +
			"left join soch.master_msmsubcategory msm on msm.id=tiben.master_msm_subcategory_id\r\n" +
			"left join soch.master_tgsubcategory tg on tg.id=tiben.master_tg_subcategory_id\r\n" +
			"left join soch.master_idusubcategory idu on idu.id=tiben.master_idu_subcategory_id\r\n" +
			"left join soch.master_occupation_trucker trucker on trucker.id=tiben.trucker_occupation_id\r\n" +
			"left join soch.master_migrant_occupation migrant on migrant.id=tiben.migrant_occupation_id\r\n" +
			"left join soch.master_marital_status marital on marital.id=ben.marital_status_id\r\n" +
			"left join soch.master_occupation occ on occ.id=ben.occupation_id\r\n" +
			"left join soch.master_education_level edu on edu.id=ben.education_level_id\r\n" +
			"left join soch.address addr on addr.id=ben.address_id\r\n" +
			"left join soch.ti_hotspot hot on hot.id=tiben.hotspot\r\n" +
			"join soch.master_hrg_primary hrg_p on tiben.master_hrg_primary_id=hrg_p.id\r\n" +
			"left join soch.facility artFacility  on artFacility.id = artBen.facility_id\r\n"+
			"left join soch.facility ostFacility  on ostFacility.id = ostBen.facility_id\r\n"+
			"where fac.id =:facilityId and ((tibenscr.modified_time in  (select max(tbsd2.modified_time) from soch.ti_ben_scr_details tbsd2\r\n" +
			"inner join soch.ti_beneficiary tb2 on tbsd2.beneficiary_id = tb2.id\r\n" +
			"and tiben.id = tbsd2.beneficiary_id)) or tibenscr.modified_time is null)\r\n" +
			" and  tiben.is_deleted=:isDeleted and (0=:hivStatus or mhs.id=:hivStatus)  and  ('' like :gender or gen.name ilike :gender) and (0=:statusId or mcst.id=:statusId) and ('' like %:tiCode% or tiben.ti_code ilike %:tiCode%)"+
			"   and ('' like :typology or typo.typology_name ilike :typology) and ('' like %:mobileNumber% or ben.mobile_number ilike %:mobileNumber%) and ('' like %:uid% or ben.uid ilike %:uid%) and ('' like %:name% or ben.first_name ilike %:name%) \r\n" +
			" group by tiben.id ,  tiben.ti_code,ben.uid , ben.id ,ben.first_name ,ben.death_date , ben.last_name ,ben.date_of_birth ,ben.mobile_number ,ben.pre_art_number ,fac.name,gen.name,typo.typology_name,mcst.name,ostBen.ost_number,mabs.name,mhs.name , mosb.name ,case when hrg_p.id=1 then fsw.name when hrg_p.id=2 then msm.name when hrg_p.id=3 then tg.name when hrg_p.id=4 then idu.name when hrg_p.id=5 then trucker.name when hrg_p.id=6 then migrant.name else 'Not Selected' end ,tiben.date_of_reg,orw_code ,pe_code ,marital.name ,edu.name,occ.name,CONCAT(addr.address_line_one, ' ',addr.address_line_two) ,hot.hotspot_name,tiben.number_of_partners ,tiben.avg_no_sexual_acts_upon_reg,tiben.no_years_in_sex_work ,tiben.consume_alcohol ,artFacility.name , ostFacility.name";

	@Query(nativeQuery = true, value = reportsAdvSearchStatusQuery, countQuery = reportsAdvSearchStatusCountQuery)
	Page<TiBeneficiaryProjection> getTiReportsAdvSearchStatus(@Param("facilityId") Long facilityId,
														@Param("isDeleted") Boolean isDeleted,@Param("tiCode")  String tiCode, @Param("typology") String typology,@Param("name") String name,
														@Param("gender") String gender,@Param("mobileNumber")  String mobileNumber,
														@Param("statusId") Long statusId,	@Param("hivStatus")  Long hivStatus ,@Param("uid") String uid,Pageable pageable);

	String reportsAdvSearchInActiveStatusQuery="select tiben.id as Id,  tiben.ti_code as TiCode, ben.uid as Uid, ben.id as BeneficiaryId,ben.first_name as FirstName,\r\n" +
			"ben.death_date as DeathDate, ben.last_name as LastName,ben.date_of_birth as DateOfBirth,ben.mobile_number as MobileNumber,\r\n" +
			"ben.pre_art_number as artNumber,fac.name as FacilityName,gen.name as Gender,typo.typology_name  as TypologyName,\r\n" +
			"mcst.name as Status,ostBen.ost_number as OstNumber,mabs.name as ArtStatus,string_agg(mhss.name,',') as HivScreeningStatus,\r\n" +
			"mhs.name as HivConfirmatoryStatus, mosb.name as OstStatus ,\r\n" +
			"case when hrg_p.id=1 then fsw.name\r\n" +
			"when hrg_p.id=2 then msm.name\r\n" +
			"when hrg_p.id=3 then tg.name\r\n" +
			"when hrg_p.id=4 then idu.name\r\n" +
			"when hrg_p.id=5 then trucker.name\r\n" +
			"when hrg_p.id=6 then migrant.name\r\n" +
			"else 'Not Selected'\r\n" +
			"end as HRGSubcategory,\r\n" +
			"tiben.date_of_reg as DateOfRegistration , orw_code as ORW,pe_code as PE,marital.name as MaritalStatus,edu.name as EducationalLevel,\r\n" +
			"occ.name as EmploymentStatus,CONCAT(addr.address_line_one, ' ',addr.address_line_two) as Address,hot.hotspot_name as HotspotName,\r\n" +
			"tiben.number_of_partners as RegularPartner,tiben.avg_no_sexual_acts_upon_reg as AverageNoSexualActsUponReg,\r\n" +
			"tiben.no_years_in_sex_work as NumberOfyearsInSexWork,tiben.consume_alcohol as ConsumesAlcohol,\r\n" +
			"artFacility.name as artFacilityName , ostFacility.name as ostFacilityName\r\n" +
			"from soch.ti_beneficiary tiben\r\n" +
			"left outer join soch.beneficiary ben  on tiben.beneficiary_id = ben.id\r\n" +
			"left outer join soch.beneficiary_facility_mapping beneficiar2_  on ben.id = beneficiar2_.beneficiary_id \r\n" +
			"left outer join soch.facility fac  on beneficiar2_.facility_id = fac.id\r\n" +
			"left outer join soch.master_gender gen on gen.id=ben.gender_id\r\n" +
			"left outer join soch.typology_master typo on typo.typology_id=tiben.master_hrg_primary_id\r\n" +
			"left outer join soch.master_client_status_ticore mcst on mcst.id=tiben.status_id\r\n" +
			"left outer join soch.ti_ost_beneficiary ostBen  on ostBen.beneficiary_id = ben.id\r\n" +
			"left outer join soch.art_beneficiary artBen  on artBen.beneficiary_id = ben.id\r\n" +
			"left outer join soch.master_art_beneficiary_status mabs on mabs.id=artBen.art_beneficiary_status_id\r\n" +
			"left outer join soch.ti_ben_scr_details tibenscr on tibenscr.beneficiary_id=tiben.id\r\n" +
			"left outer join soch.master_hiv_screening_status mhss on mhss.id=tibenscr.screening_status_hiv_id\r\n" +
			"left outer join soch.master_hiv_status mhs ON mhs.id = ben.hiv_status_id\r\n" +
			"left outer join soch.master_ost_status_beneficiary mosb on mosb.id=ostBen.ost_status_id\r\n" +
			"left join soch.master_fswsubcategory fsw on fsw.id=tiben.master_fsw_subcategory_id\r\n" +
			"left join soch.master_msmsubcategory msm on msm.id=tiben.master_msm_subcategory_id\r\n" +
			"left join soch.master_tgsubcategory tg on tg.id=tiben.master_tg_subcategory_id\r\n" +
			"left join soch.master_idusubcategory idu on idu.id=tiben.master_idu_subcategory_id\r\n" +
			"left join soch.master_occupation_trucker trucker on trucker.id=tiben.trucker_occupation_id\r\n" +
			"left join soch.master_migrant_occupation migrant on migrant.id=tiben.migrant_occupation_id\r\n" +
			"left join soch.master_marital_status marital on marital.id=ben.marital_status_id\r\n" +
			"left join soch.master_occupation occ on occ.id=ben.occupation_id\r\n" +
			"left join soch.master_education_level edu on edu.id=ben.education_level_id\r\n" +
			"left join soch.address addr on addr.id=ben.address_id\r\n" +
			"left join soch.ti_hotspot hot on hot.id=tiben.hotspot\r\n" +
			"join soch.master_hrg_primary hrg_p on tiben.master_hrg_primary_id=hrg_p.id\r\n" +
			"left join soch.facility artFacility  on artFacility.id = artBen.facility_id\r\n"+
			"left join soch.facility ostFacility  on ostFacility.id = ostBen.facility_id\r\n"+
			"where fac.id =:facilityId and ((tibenscr.modified_time in  (select max(tbsd2.modified_time) from soch.ti_ben_scr_details tbsd2\r\n" +
			"inner join soch.ti_beneficiary tb2 on tbsd2.beneficiary_id = tb2.id\r\n" +
			"and tiben.id = tbsd2.beneficiary_id)) or tibenscr.modified_time is null)\r\n" +
			" and  tiben.is_deleted=:isDeleted and (0=:hivStatus or mhs.id=:hivStatus)  and  ('' like :gender or gen.name ilike :gender) and " +
			" (0=:statusId or mcst.id=:statusId or (select t.transfer_status from soch.transfers t where t.beneficiary_id =ben.id and t.source_facility_id = :facilityId  " +
			" and  exists  (select bfm.beneficiary_id from soch.beneficiary_facility_mapping bfm   where bfm.beneficiary_id=ben.id  and bfm.facility_id=t.source_facility_id and bfm.is_transferred = true and bfm.is_active = false)  and t.transfer_status = 'Accepted' order by t.id desc limit 1)= 'Accepted') and ('' like %:tiCode% or tiben.ti_code ilike %:tiCode%)"+
			" and ('' like :typology or typo.typology_name ilike :typology) and ('' like %:mobileNumber% or ben.mobile_number ilike %:mobileNumber%) and ('' like %:uid% or ben.uid ilike %:uid%) and ('' like %:name% or ben.first_name ilike %:name%) \r\n"+
			" group by tiben.id ,  tiben.ti_code,ben.uid , ben.id ,ben.first_name ,ben.death_date , ben.last_name ,ben.date_of_birth ,ben.mobile_number ,ben.pre_art_number ,fac.name,gen.name,typo.typology_name,mcst.name,ostBen.ost_number,mabs.name,mhs.name , mosb.name ,case when hrg_p.id=1 then fsw.name when hrg_p.id=2 then msm.name when hrg_p.id=3 then tg.name when hrg_p.id=4 then idu.name when hrg_p.id=5 then trucker.name when hrg_p.id=6 then migrant.name else 'Not Selected' end ,tiben.date_of_reg,orw_code ,pe_code ,marital.name ,edu.name,occ.name,CONCAT(addr.address_line_one, ' ',addr.address_line_two) ,hot.hotspot_name,tiben.number_of_partners ,tiben.avg_no_sexual_acts_upon_reg,tiben.no_years_in_sex_work ,tiben.consume_alcohol ,artFacility.name , ostFacility.name";
	
	String reportsAdvSearchInActiveStatusCountQuery="select  count(tiben.id) from soch.ti_beneficiary tiben\r\n" +
			"left outer join soch.beneficiary ben  on tiben.beneficiary_id = ben.id\r\n" +
			"left outer join soch.beneficiary_facility_mapping beneficiar2_  on ben.id = beneficiar2_.beneficiary_id \r\n" +
			"left outer join soch.facility fac  on beneficiar2_.facility_id = fac.id\r\n" +
			"left outer join soch.master_gender gen on gen.id=ben.gender_id\r\n" +
			"left outer join soch.typology_master typo on typo.typology_id=tiben.master_hrg_primary_id\r\n" +
			"left outer join soch.master_client_status_ticore mcst on mcst.id=tiben.status_id\r\n" +
			"left outer join soch.ti_ost_beneficiary ostBen  on ostBen.beneficiary_id = ben.id\r\n" +
			"left outer join soch.art_beneficiary artBen  on artBen.beneficiary_id = ben.id\r\n" +
			"left outer join soch.master_art_beneficiary_status mabs on mabs.id=artBen.art_beneficiary_status_id\r\n" +
			"left outer join soch.ti_ben_scr_details tibenscr on tibenscr.beneficiary_id=tiben.id\r\n" +
			"left outer join soch.master_hiv_screening_status mhss on mhss.id=tibenscr.screening_status_hiv_id\r\n" +
			"left outer join soch.master_hiv_status mhs ON mhs.id = ben.hiv_status_id\r\n" +
			"left outer join soch.master_ost_status_beneficiary mosb on mosb.id=ostBen.ost_status_id\r\n" +
			"left join soch.master_fswsubcategory fsw on fsw.id=tiben.master_fsw_subcategory_id\r\n" +
			"left join soch.master_msmsubcategory msm on msm.id=tiben.master_msm_subcategory_id\r\n" +
			"left join soch.master_tgsubcategory tg on tg.id=tiben.master_tg_subcategory_id\r\n" +
			"left join soch.master_idusubcategory idu on idu.id=tiben.master_idu_subcategory_id\r\n" +
			"left join soch.master_occupation_trucker trucker on trucker.id=tiben.trucker_occupation_id\r\n" +
			"left join soch.master_migrant_occupation migrant on migrant.id=tiben.migrant_occupation_id\r\n" +
			"left join soch.master_marital_status marital on marital.id=ben.marital_status_id\r\n" +
			"left join soch.master_occupation occ on occ.id=ben.occupation_id\r\n" +
			"left join soch.master_education_level edu on edu.id=ben.education_level_id\r\n" +
			"left join soch.address addr on addr.id=ben.address_id\r\n" +
			"left join soch.ti_hotspot hot on hot.id=tiben.hotspot\r\n" +
			"join soch.master_hrg_primary hrg_p on tiben.master_hrg_primary_id=hrg_p.id\r\n" +
			"left join soch.facility artFacility  on artFacility.id = artBen.facility_id\r\n"+
			"left join soch.facility ostFacility  on ostFacility.id = ostBen.facility_id\r\n"+
			"where fac.id =:facilityId and ((tibenscr.modified_time in  (select max(tbsd2.modified_time) from soch.ti_ben_scr_details tbsd2\r\n" +
			"inner join soch.ti_beneficiary tb2 on tbsd2.beneficiary_id = tb2.id\r\n" +
			"and tiben.id = tbsd2.beneficiary_id)) or tibenscr.modified_time is null)\r\n" +
			" and  tiben.is_deleted=:isDeleted and (0=:hivStatus or mhs.id=:hivStatus)  and  ('' like :gender or gen.name ilike :gender) " +
			" and (0=:statusId or mcst.id=:statusId or (select t.transfer_status from soch.transfers t where t.beneficiary_id =ben.id and t.source_facility_id = :facilityId  and  exists \n" +
			" (select bfm.beneficiary_id from soch.beneficiary_facility_mapping bfm   where bfm.beneficiary_id=ben.id  and bfm.facility_id=t.source_facility_id\n" +
			" and bfm.is_transferred = true and bfm.is_active = false)  and t.transfer_status = 'Accepted' order by t.id desc limit 1)= 'Accepted') and ('' like %:tiCode% or tiben.ti_code ilike %:tiCode%)"+
			" and ('' like :typology or typo.typology_name ilike :typology) and ('' like %:mobileNumber% or ben.mobile_number ilike %:mobileNumber%) and ('' like %:uid% or ben.uid ilike %:uid%) and ('' like %:name% or ben.first_name ilike %:name%) \r\n" +
			" group by tiben.id ,  tiben.ti_code,ben.uid , ben.id ,ben.first_name ,ben.death_date , ben.last_name ,ben.date_of_birth ,ben.mobile_number ,ben.pre_art_number ,fac.name,gen.name,typo.typology_name,mcst.name,ostBen.ost_number,mabs.name,mhs.name , mosb.name ,case when hrg_p.id=1 then fsw.name when hrg_p.id=2 then msm.name when hrg_p.id=3 then tg.name when hrg_p.id=4 then idu.name when hrg_p.id=5 then trucker.name when hrg_p.id=6 then migrant.name else 'Not Selected' end ,tiben.date_of_reg,orw_code ,pe_code ,marital.name ,edu.name,occ.name,CONCAT(addr.address_line_one, ' ',addr.address_line_two) ,hot.hotspot_name,tiben.number_of_partners ,tiben.avg_no_sexual_acts_upon_reg,tiben.no_years_in_sex_work ,tiben.consume_alcohol ,artFacility.name , ostFacility.name";
	@Query(nativeQuery = true, value = reportsAdvSearchInActiveStatusQuery, countQuery = reportsAdvSearchInActiveStatusCountQuery)
	Page<TiBeneficiaryProjection> getTiReportsAdvSearchForInActiveStatus(@Param("facilityId") Long facilityId,
			@Param("isDeleted") Boolean isDeleted,@Param("tiCode")  String tiCode, @Param("typology") String typology,@Param("name") String name,
			@Param("gender") String gender,@Param("mobileNumber")  String mobileNumber,
			@Param("statusId") Long statusId,	@Param("hivStatus")  Long hivStatus ,@Param("uid") String uid,Pageable pageable);


	String reportsAdvSearchsQuery="select tiben.id as Id,  tiben.ti_code as TiCode, ben.uid as Uid, ben.id as BeneficiaryId,ben.first_name as FirstName,\r\n" +
			"ben.death_date as DeathDate, ben.last_name as LastName,ben.date_of_birth as DateOfBirth,ben.mobile_number as MobileNumber,\r\n" +
			"ben.pre_art_number as artNumber,fac.name as FacilityName,gen.name as Gender,typo.typology_name  as TypologyName,\r\n" +
			"mcst.name as Status,ostBen.ost_number as OstNumber,mabs.name as ArtStatus,string_agg(mhss.name,',') as HivScreeningStatus,\r\n" +
			"mhs.name as HivConfirmatoryStatus, mosb.name as OstStatus ,\r\n" +
			"case when hrg_p.id=1 then fsw.name\r\n" +
			"when hrg_p.id=2 then msm.name\r\n" +
			"when hrg_p.id=3 then tg.name\r\n" +
			"when hrg_p.id=4 then idu.name\r\n" +
			"when hrg_p.id=5 then trucker.name\r\n" +
			"when hrg_p.id=6 then migrant.name\r\n" +
			"else 'Not Selected'\r\n" +
			"end as HRGSubcategory,\r\n" +
			"tiben.date_of_reg as DateOfRegistration , orw_code as ORW,pe_code as PE,marital.name as MaritalStatus,edu.name as EducationalLevel,\r\n" +
			"occ.name as EmploymentStatus,CONCAT(addr.address_line_one, ' ',addr.address_line_two) as Address,hot.hotspot_name as HotspotName,\r\n" +
			"tiben.number_of_partners as RegularPartner,tiben.avg_no_sexual_acts_upon_reg as AverageNoSexualActsUponReg,\r\n" +
			"tiben.no_years_in_sex_work as NumberOfyearsInSexWork,tiben.consume_alcohol as ConsumesAlcohol,\r\n" +
			"artFacility.name as artFacilityName , ostFacility.name as ostFacilityName\r\n" +
			"from soch.ti_beneficiary tiben\r\n" +
			"left outer join soch.beneficiary ben  on tiben.beneficiary_id = ben.id\r\n" +
			"left outer join soch.beneficiary_facility_mapping beneficiar2_  on ben.id = beneficiar2_.beneficiary_id \r\n" +
			"left outer join soch.facility fac  on beneficiar2_.facility_id = fac.id\r\n" +
			"left outer join soch.master_gender gen on gen.id=ben.gender_id\r\n" +
			"left outer join soch.typology_master typo on typo.typology_id=tiben.master_hrg_primary_id\r\n" +
			"left outer join soch.master_client_status_ticore mcst on mcst.id=tiben.status_id\r\n" +
			"left outer join soch.ti_ost_beneficiary ostBen  on ostBen.beneficiary_id = ben.id\r\n" +
			"left outer join soch.art_beneficiary artBen  on artBen.beneficiary_id = ben.id\r\n" +
			"left outer join soch.master_art_beneficiary_status mabs on mabs.id=artBen.art_beneficiary_status_id\r\n" +
			"left outer join soch.ti_ben_scr_details tibenscr on tibenscr.beneficiary_id=tiben.id\r\n" +
			"left outer join soch.master_hiv_screening_status mhss on mhss.id=tibenscr.screening_status_hiv_id\r\n" +
			"left outer join soch.master_hiv_status mhs ON mhs.id = ben.hiv_status_id\r\n" +
			"left outer join soch.master_ost_status_beneficiary mosb on mosb.id=ostBen.ost_status_id\r\n" +
			"left join soch.master_fswsubcategory fsw on fsw.id=tiben.master_fsw_subcategory_id\r\n" +
			"left join soch.master_msmsubcategory msm on msm.id=tiben.master_msm_subcategory_id\r\n" +
			"left join soch.master_tgsubcategory tg on tg.id=tiben.master_tg_subcategory_id\r\n" +
			"left join soch.master_idusubcategory idu on idu.id=tiben.master_idu_subcategory_id\r\n" +
			"left join soch.master_occupation_trucker trucker on trucker.id=tiben.trucker_occupation_id\r\n" +
			"left join soch.master_migrant_occupation migrant on migrant.id=tiben.migrant_occupation_id\r\n" +
			"left join soch.master_marital_status marital on marital.id=ben.marital_status_id\r\n" +
			"left join soch.master_occupation occ on occ.id=ben.occupation_id\r\n" +
			"left join soch.master_education_level edu on edu.id=ben.education_level_id\r\n" +
			"left join soch.address addr on addr.id=ben.address_id\r\n" +
			"left join soch.ti_hotspot hot on hot.id=tiben.hotspot\r\n" +
			"join soch.master_hrg_primary hrg_p on tiben.master_hrg_primary_id=hrg_p.id\r\n" +
			"left join soch.facility artFacility  on artFacility.id = artBen.facility_id\r\n"+
			"left join soch.facility ostFacility  on ostFacility.id = ostBen.facility_id\r\n"+
			"where fac.id =:facilityId and ((tibenscr.modified_time in  (select max(tbsd2.modified_time) from soch.ti_ben_scr_details tbsd2\r\n" +
			"inner join soch.ti_beneficiary tb2 on tbsd2.beneficiary_id = tb2.id\r\n" +
			"and tiben.id = tbsd2.beneficiary_id)) or tibenscr.modified_time is null)\r\n" +
			" and  tiben.is_deleted=:isDeleted and (0=:hivStatus or mhs.id=:hivStatus)  and  ('' like :gender or gen.name ilike :gender) and (0=:statusId or mcst.id=:statusId) and ('' like %:tiCode% or tiben.ti_code ilike %:tiCode%)"+
			"   and ('' like :typology or typo.typology_name ilike :typology) and ('' like %:mobileNumber% or ben.mobile_number ilike %:mobileNumber%) and ('' like %:uid% or ben.uid ilike %:uid%) and ('' like %:name% or ben.first_name ilike %:name%) \r\n"+
			" group by tiben.id ,  tiben.ti_code,ben.uid , ben.id ,ben.first_name ,ben.death_date , ben.last_name ,ben.date_of_birth ,ben.mobile_number ,ben.pre_art_number ,fac.name,gen.name,typo.typology_name,mcst.name,ostBen.ost_number,mabs.name,mhs.name , mosb.name ,case when hrg_p.id=1 then fsw.name when hrg_p.id=2 then msm.name when hrg_p.id=3 then tg.name when hrg_p.id=4 then idu.name when hrg_p.id=5 then trucker.name when hrg_p.id=6 then migrant.name else 'Not Selected' end ,tiben.date_of_reg,orw_code ,pe_code ,marital.name ,edu.name,occ.name,CONCAT(addr.address_line_one, ' ',addr.address_line_two) ,hot.hotspot_name,tiben.number_of_partners ,tiben.avg_no_sexual_acts_upon_reg,tiben.no_years_in_sex_work ,tiben.consume_alcohol ,artFacility.name , ostFacility.name";

	String reportsAdvSearchCountQuery="select  count(tiben.id) from soch.ti_beneficiary tiben\r\n" +
			"left outer join soch.beneficiary ben  on tiben.beneficiary_id = ben.id\r\n" +
			"left outer join soch.beneficiary_facility_mapping beneficiar2_  on ben.id = beneficiar2_.beneficiary_id \r\n" +
			"left outer join soch.facility fac  on beneficiar2_.facility_id = fac.id\r\n" +
			"left outer join soch.master_gender gen on gen.id=ben.gender_id\r\n" +
			"left outer join soch.typology_master typo on typo.typology_id=tiben.master_hrg_primary_id\r\n" +
			"left outer join soch.master_client_status_ticore mcst on mcst.id=tiben.status_id\r\n" +
			"left outer join soch.ti_ost_beneficiary ostBen  on ostBen.beneficiary_id = ben.id\r\n" +
			"left outer join soch.art_beneficiary artBen  on artBen.beneficiary_id = ben.id\r\n" +
			"left outer join soch.master_art_beneficiary_status mabs on mabs.id=artBen.art_beneficiary_status_id\r\n" +
			"left outer join soch.ti_ben_scr_details tibenscr on tibenscr.beneficiary_id=tiben.id\r\n" +
			"left outer join soch.master_hiv_screening_status mhss on mhss.id=tibenscr.screening_status_hiv_id\r\n" +
			"left outer join soch.master_hiv_status mhs ON mhs.id = ben.hiv_status_id\r\n" +
			"left outer join soch.master_ost_status_beneficiary mosb on mosb.id=ostBen.ost_status_id\r\n" +
			"left join soch.master_fswsubcategory fsw on fsw.id=tiben.master_fsw_subcategory_id\r\n" +
			"left join soch.master_msmsubcategory msm on msm.id=tiben.master_msm_subcategory_id\r\n" +
			"left join soch.master_tgsubcategory tg on tg.id=tiben.master_tg_subcategory_id\r\n" +
			"left join soch.master_idusubcategory idu on idu.id=tiben.master_idu_subcategory_id\r\n" +
			"left join soch.master_occupation_trucker trucker on trucker.id=tiben.trucker_occupation_id\r\n" +
			"left join soch.master_migrant_occupation migrant on migrant.id=tiben.migrant_occupation_id\r\n" +
			"left join soch.master_marital_status marital on marital.id=ben.marital_status_id\r\n" +
			"left join soch.master_occupation occ on occ.id=ben.occupation_id\r\n" +
			"left join soch.master_education_level edu on edu.id=ben.education_level_id\r\n" +
			"left join soch.address addr on addr.id=ben.address_id\r\n" +
			"left join soch.ti_hotspot hot on hot.id=tiben.hotspot\r\n" +
			"join soch.master_hrg_primary hrg_p on tiben.master_hrg_primary_id=hrg_p.id\r\n" +
			"left join soch.facility artFacility  on artFacility.id = artBen.facility_id\r\n"+
			"left join soch.facility ostFacility  on ostFacility.id = ostBen.facility_id\r\n"+
			"where fac.id =:facilityId and ((tibenscr.modified_time in  (select max(tbsd2.modified_time) from soch.ti_ben_scr_details tbsd2\r\n" +
			"inner join soch.ti_beneficiary tb2 on tbsd2.beneficiary_id = tb2.id\r\n" +
			"and tiben.id = tbsd2.beneficiary_id)) or tibenscr.modified_time is null)\r\n" +
			" and  tiben.is_deleted=:isDeleted and (0=:hivStatus or mhs.id=:hivStatus)  and  ('' like :gender or gen.name ilike :gender) and (0=:statusId or mcst.id=:statusId) and ('' like %:tiCode% or tiben.ti_code ilike %:tiCode%)"+
			"   and ('' like :typology or typo.typology_name ilike :typology) and ('' like %:mobileNumber% or ben.mobile_number ilike %:mobileNumber%) and ('' like %:uid% or ben.uid ilike %:uid%) and ('' like %:name% or ben.first_name ilike %:name%) \r\n" +
			" group by tiben.id ,  tiben.ti_code,ben.uid , ben.id ,ben.first_name ,ben.death_date , ben.last_name ,ben.date_of_birth ,ben.mobile_number ,ben.pre_art_number ,fac.name,gen.name,typo.typology_name,mcst.name,ostBen.ost_number,mabs.name,mhs.name , mosb.name ,case when hrg_p.id=1 then fsw.name when hrg_p.id=2 then msm.name when hrg_p.id=3 then tg.name when hrg_p.id=4 then idu.name when hrg_p.id=5 then trucker.name when hrg_p.id=6 then migrant.name else 'Not Selected' end ,tiben.date_of_reg,orw_code ,pe_code ,marital.name ,edu.name,occ.name,CONCAT(addr.address_line_one, ' ',addr.address_line_two) ,hot.hotspot_name,tiben.number_of_partners ,tiben.avg_no_sexual_acts_upon_reg,tiben.no_years_in_sex_work ,tiben.consume_alcohol ,artFacility.name , ostFacility.name";
			@Query(nativeQuery = true, value = reportsAdvSearchsQuery, countQuery = reportsAdvSearchCountQuery)
			Page<TiBeneficiaryProjection> getTiReportsAdvSearch(@Param("facilityId") Long facilityId,@Param("isDeleted") Boolean isDeleted,@Param("tiCode")  String tiCode, @Param("typology") String typology,@Param("name") String name, @Param("gender") String gender,@Param("mobileNumber")  String mobileNumber, @Param("statusId") Long statusId,@Param("hivStatus")  Long hivStatus ,@Param("uid") String uid,Pageable pageable);


}
