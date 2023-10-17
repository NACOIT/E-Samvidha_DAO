package gov.naco.soch.repository;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.constructordto.SummaryDto;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.projection.ArtBeneficiaryMiniProfileProjection;
import gov.naco.soch.projection.ArtBeneficiaryRegistrationProjection;
import gov.naco.soch.projection.ArtFollowupListProjection;
import gov.naco.soch.projection.ArtRegistrationProjection;
import gov.naco.soch.projection.ArtTransitBeneficiaryProjection;
import gov.naco.soch.projection.PersonalMedicalRecordGeneralProjection;
import gov.naco.soch.projection.BeneficiaryBasicProjection;
import gov.naco.soch.projection.BeneficiaryDetailsProjection;
import gov.naco.soch.projection.BeneficiaryProjectionForMobile;
import gov.naco.soch.projection.CounsellingNoteBasicBeneficiaryDetailsProjection;
import gov.naco.soch.projection.ExcelDetailsProjection;
import gov.naco.soch.projection.FacilityTargetProjection;
import gov.naco.soch.projection.InventoryProjection;
import gov.naco.soch.projection.MasterLineProjection;
import gov.naco.soch.projection.PediatricBeneficiaryProjection;
import gov.naco.soch.projection.SacepReferralProjection;
import gov.naco.soch.projection.StatisticsProjection;
import gov.naco.soch.projection.StockDetailsProjection;
import gov.naco.soch.projection.UidMergeProjection;
import gov.naco.soch.projection.WhiteCardDetailsProjection;

//Repository mapped with entity class3
@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long>, JpaSpecificationExecutor<Beneficiary> {

	// Query to search beneficiary with UID or mobile number
	@Query(nativeQuery = true, value = "select b.id,b.uid,b.first_name,b.middle_name,b.last_name,b.mobile_number,b.beneficiary_activity_status,"
			+ "br.hrg_primary_category,br.hrg_secondary_category,b.age,b.gender,br.client_status,br.beneficiary_id,b.ti_code from soch.beneficiary b"
			+ " join soch.beneficiary_registration br on b.id=br.beneficiary_id where b.is_delete=false and (b.mobile_number=?1 or UPPER(b.uid)=UPPER(?1) or UPPER(b.first_name)=UPPER(?1))")
	List<Object[]> findBySearchValue(String searchValue);

	// QueryTo Get specific records for Beneficiary - Facility ID:
	@Query(nativeQuery = true, value = "select f.name as MllCenName,a.address AS MllAddr,a.city as MllCity,s.name AS MllState ,d.name AS MllDist,a.pincode as MllPin,b.uid as MllUid,tib.ost_code as MllRegNum,(b.first_name || ' ' || b.last_name) AS MllPatientName,tib.date_of_reg as MllRegDate, b.gender as MllPatGender,b.age as MllPatAge,b.mobile_number as MllPatMobile, "
			+ "	tib.beneficiary_activity_status as MllCurrStatus,od.current_dose as MllCurrDosage "
			+ "	from  soch.beneficiary b join soch.ti_beneficiary tib on b.id = tib.beneficiary_id "
			+ "	join soch.facility f on f.id = tib.facility_id  join soch.address a on f.address_id = a.id "
			+ "	 join soch.district d on a.district_id = d.id  join soch.state s on a.state_id = s.id  "
			+ "	 left join soch.ti_ost_details od on od.beneficiary_id = b.id AND od.dispensed_last_date = (Select Max(dispensed_last_date)  "
			+ "								                             FROM soch.ti_ost_details "
			+ "															WHERE beneficiary_id = b.id) where f.id = ?1")
	List<MasterLineProjection> findBeneficiariesByFacility(long facilityId);

	@Query(nativeQuery = true, value = "select b.id,uid,first_name as firstName ,middle_name as middleName,last_name as lastName ,age,mg.name as gender ,reg_date as regDate from beneficiary b inner join master_gender mg on  mg.id = b.gender_id where b.id = :beneficiaryId")
	BeneficiaryBasicProjection getBasicBeneficiaryDetails(@Param("beneficiaryId") Long beneficiaryId);

	// Query to search beneficiary details by UID, mobile number,
	// firstName, LastName, HIVStatus, referralStatus, referralFacility
	@Query(nativeQuery = true, value = "select b.id,b.uid,b.first_name,b.middle_name,b.last_name,b.mobile_number,b.beneficiary_activity_status,br.referral_facility,br.referral_status,br.hiv_status from soch.beneficiary b join soch.ti_beneficiary_referral br "
			+ "on b.id=br.beneficiary_id where b.mobile_number=?1 or UPPER(b.uid)=UPPER(?1) or UPPER(b.first_name)=UPPER(?1) or UPPER(br.referral_facility)=UPPER(?1) or UPPER(br.referral_status)=UPPER(?1) or UPPER(br.hiv_status)=UPPER(?1)")
	List<Object[]> findBySearchValueReferral(String searchValue);

	// query to list all beneficiaries if isDelete = false
	@Query(nativeQuery = true, value = "select * from soch.beneficiary b join soch.beneficiary_facility_mapping bfm on b.id=bfm.beneficiary_id  where b.is_delete=false and bfm.facility_id=?1 order by b.id desc")
	List<Beneficiary> findAll(Long facilityId);

	List<Beneficiary> findAllByIsDelete(boolean isDelete);

	@Query(nativeQuery = true, value = "select registrations,plhivs,active_plhivs,active_hrgs,mtarget from soch.SUMMARYDATA(:facilityId)")
	Object getSummaryData(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select registrations,plhivs,active_plhivs,active_ost,total_ost from soch.SUMMARYDATAOST(:facilityId)")
	Object getSummaryOstData(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_reg),'MONTH') AS name, "
			+ " COUNT(tib.id) AS value FROM soch.ti_beneficiary tib"
			+ " JOIN soch.beneficiary bn ON bn.id = tib.beneficiary_id"
			+ " WHERE tib.facility_id=:facilityId and tib.is_active = true and tib.is_deleted  = false and to_char(date_of_reg,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseRegistrationCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_screening),'MONTH') AS name, "
			+ " COUNT(tcb.beneficiary_id) AS value FROM soch.ti_ben_scr_details tsd join soch.ti_core_beneficiary tcb on tcb.beneficiary_id="
			+ " tsd.beneficiary_id "
			+ " WHERE tcb.facility_id=:facilityId  and lower(screening_status_hiv)='positive' and to_char(date_of_screening,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseHivReactiveCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',br.refer_date),'MONTH') AS name, "
			+ " COUNT(br.beneficiary_id) AS value FROM soch.beneficiary_referral br join soch.art_beneficiary_details ab on ab.beneficiary_id=br.beneficiary_id "
			+ " WHERE refered_to in (select id from soch.facility where facility_type_id in (15,16,17,18)) "
			+ " and   refered_from =:facilityId "
			+ " and   to_char(br.refer_date,'YYYY')=to_char(now(),'YYYY') GROUP BY 1")
	List<StatisticsProjection> getMonthwiseBeneficiaryReferralsCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',isc.tested_date),'MONTH') AS name, "
			+ " COUNT(isc.beneficiary_id) AS value " + " FROM soch.ictc_sample_collection isc "
			+ " WHERE lower(isc.hiv_status)='tested' and  to_char(isc.tested_date,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseHivTestsCount();

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',br.refer_date),'MONTH') AS name , "
			+ " COUNT(br.beneficiary_id) AS value FROM soch.beneficiary_referral br "
			+ " WHERE NOT EXISTS(SELECT FROM soch.art_beneficiary_details where beneficiary_id=br.beneficiary_id) "
			+ " and refered_to in (select id from soch.facility where facility_type_id in (15,16,17,18)) "
			+ " and refered_from=:facilityId" + " and   to_char(br.refer_date,'YYYY')=to_char(now(),'YYYY') GROUP BY 1")
	List<StatisticsProjection> getArtReferredButNotLinkedCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT  TO_CHAR(DATE_TRUNC('month',br.refer_date),'MONTH') AS name, "
			+ "  COUNT(br.beneficiary_id) AS value FROM soch.beneficiary_referral br "
			+ "  join soch.art_beneficiary_details  abd on br.beneficiary_id=abd.beneficiary_id "
			+ "  WHERE  refered_to in (select id from soch.facility where facility_type_id in (15,16,17,18)) "
			+ "  and    refered_from=:facilityId and lower(patient_art_status)=:status "
			+ "  and  to_char(br.refer_date,'YYYY')=to_char(now(),'YYYY')" + "  GROUP BY 1")
	List<StatisticsProjection> getArtRefferedLinkedBasedOnStatusCount(@Param("facilityId") Long facilityId,
			@Param("status") String status);

	default SummaryDto getSummaryDashboardDetails(Long facilityId) {

		Object object = getSummaryData(facilityId);
		SummaryDto summaryDto = new SummaryDto();
		if (object instanceof Object[]) {
			Object[] values = (Object[]) object;
			summaryDto.setRegistrations((BigInteger) values[0]);
			summaryDto.setPlhivs((BigInteger) values[1]);
			summaryDto.setActivePlhivs((BigInteger) values[2]);
			summaryDto.setActive_hrgs((BigInteger) values[3]);
			summaryDto.setMonthly_active_target((BigInteger) values[4]);
		}
		return summaryDto;

	}

	default SummaryDto getSummaryOstDashboardDetails(Long facilityId) {
		Object object = getSummaryOstData(facilityId);
		SummaryDto summaryDto = new SummaryDto();
		if (object instanceof Object[]) {
			Object[] values = (Object[]) object;
			summaryDto.setRegistrations((BigInteger) values[0]);
			summaryDto.setPlhivs((BigInteger) values[1]);
			summaryDto.setActivePlhivs((BigInteger) values[2]);
			summaryDto.setActiveOstClients((BigInteger) values[3]);
			summaryDto.setTotalOstClients((BigInteger) values[4]);
		}
		return summaryDto;

	}

	// monthly target from ti_beneficiary as it is present only in this table
	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',tib.date_of_reg),'MONTH') AS name, "
			+ " fac.monthly_active_target AS value FROM soch.ti_beneficiary tib"
			+ " join soch.facility fac on fac.id = tib.facility_id"
			+ " where tib.facility_id=:facilityId and to_char(tib.date_of_reg,'YYYY')=to_char(now(),'YYYY')")
	List<StatisticsProjection> getMonthwiseMonthlyTarget(@Param("facilityId") Long facilityId);

	// icr.hiv_status =2 , means hiv positive
	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.date_of_screening),'MONTH') AS name, "
			+ " COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti "
			+ " join soch.ti_beneficiary tcb on tcb.id = sti.beneficiary_id and tcb.facility_id = sti.facility_id"
			+ " join soch.master_infection_type mit on mit.id = sti.infection_id "
			+ " WHERE tcb.facility_id=:facilityId and mit.id =1 " + " and sti.screening_status_hiv_id IS NOT NULL "
			+ " and to_char(sti.date_of_screening,'YYYY')=to_char(now(),'YYYY') " + " GROUP BY 1")
	List<StatisticsProjection> getMonthwiseHivTested(@Param("facilityId") Long facilityId);

	// screening_status_hiv =reactive
	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.date_of_screening),'MONTH') AS name,  "
			+ "			 COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti  "
			+ "			 join soch.ti_beneficiary tcb on tcb.id = sti.beneficiary_id  "
			+ "			 join soch.beneficiary bn on bn.id = tcb.beneficiary_id  "
			+ "			 join soch.master_infection_type mit on mit.id = sti.infection_id  "
			+ "			 join soch.master_hiv_screening_status mhss on mhss.id = sti.screening_status_hiv_id  "
			+ "		 	WHERE tcb.facility_id= :facilityId and mit.id =1  and mhss.id=1 "
			+ "			 and to_char(sti.date_of_screening,'YYYY')=to_char(now(),'YYYY') GROUP BY 1 ")
	List<StatisticsProjection> getMonthwiseHivReactive(@Param("facilityId") Long facilityId);

	// Beneficairy linked - HIV
	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.date_of_screening),'MONTH') AS name,  "
			+ "			 COUNT(distinct sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti  "
			+ "			 join soch.ti_beneficiary tcb on tcb.id = sti.beneficiary_id  "
			+ "			 join soch.beneficiary bn on bn.id = tcb.beneficiary_id  "
			+ "			 join soch.master_infection_type mit on mit.id = sti.infection_id  "
			+ "			 join soch.master_hiv_screening_status mhss on mhss.id = sti.screening_status_hiv_id inner join beneficiary_referral br  "
			+ "			 on br.beneficiary_id  = bn.id  "
			+ "			 inner join master_referral_status mrs on mrs.id = br.referral_status_id  "
			+ "			 inner join facility f on br.refered_to  = f.id  "
			+ "		 	WHERE tcb.facility_id=:facilityId and mit.id =1  and mhss.id=1 and mrs.id = 3 and f.facility_type_id  = 11 "
			+ "		 	and to_char(sti.date_of_screening,'YYYY')=to_char(now(),'YYYY') GROUP BY 1")
	List<StatisticsProjection> getMonthwiseHivLinked(@Param("facilityId") Long facilityId);
		
	
	@Query(nativeQuery = true , value = " select ahbcr.month as name ,\r\n" +
            "sum(ahbcr.active_hrg_count) as value  \r\n" +
            "from soch.active_hrg_beneficiary_count_record ahbcr\r\n" +
            "join soch.ti_beneficiary tiben on tiben.beneficiary_id=ahbcr.beneficiary_id\r\n"+
            "where ahbcr.facility_id = :facilityId and ahbcr.year =to_char(now(),'YYYY') and tiben.status_id=1 and tiben.is_deleted=false\r\n" +
            "group by ahbcr.month ")
	List<StatisticsProjection> getMonthwiseActiveCount(@Param("facilityId") Long facilityId);


	// Used = Distributed - Returned , but condoms returned is not present
	// is tbcd.created_time is correct ?
	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',tbcd.created_time),'MONTH') AS name, "
			+ " coalesce (sum(tbcd.condoms_distributed),0) as value from soch.ti_beneficiary_comm_dis tbcd "
			+ " where tbcd.facility_id =:facilityId and to_char(tbcd.created_time,'YYYY')=to_char(now(),'YYYY') group by 1")
	List<StatisticsProjection> getMonthWiseCondomsUsed(@Param("facilityId") Long facilityId);

	// is tbcd.created_time is correct ?
	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',tbcd.created_time),'MONTH') AS name, "
			+ " coalesce (sum(tbcd.needles_distributed),0)- coalesce (sum(tbcd.syringes_needles_returned),0) as value "
			+ " from soch.ti_beneficiary_comm_dis tbcd where tbcd.facility_id =:facilityId "
			+ " and to_char(tbcd.created_time,'YYYY')=to_char(now(),'YYYY') group by 1 ")
	List<StatisticsProjection> getMonthWiseNeedlesUsed(@Param("facilityId") Long facilityId);

	// is tbcd.created_time is correct ?
	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',tbcd.distribution_date),'MONTH') AS name, coalesce (sum(tbcd.condoms_distributed ),0) as value\n"
			+ "from soch.ti_beneficiary_comm_dis tbcd \n"
			+ "inner join soch.ti_beneficiary tb on tb.id = tbcd.beneficiary_id\n"
			+ "where tbcd.facility_id =:facilityId and tb.is_active =true and tb.is_deleted =false\n"
			+ "and to_char(tbcd.distribution_date,'YYYY')=to_char(now(),'YYYY') group by 1")
	List<StatisticsProjection> getMonthWiseCondomsDistributedForCommodity(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',tbc.counselling_date),'MONTH') AS name, coalesce (sum(tbc.no_of_condoms_distributed ),0) as value\n"
			+ "from soch.ti_ben_counselling tbc \n"
			+ "inner join soch.ti_beneficiary tb on tb.id = tbc.beneficiary_id\n"
			+ "where tbc.facility_id =:facilityId and tb.is_active =true and tb.is_deleted =false\n"
			+ "and to_char(tbc.counselling_date,'YYYY')=to_char(now(),'YYYY') group by 1")
	List<StatisticsProjection> getMonthWiseCondomsDistributedForCounselling(@Param("facilityId") Long facilityId);

	// is tbcd.created_time is correct ?
	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',tbcd.distribution_date),'MONTH') AS name,\n"
			+ "coalesce (sum(tbcd.needles_distributed + tbcd.syringes_distributed),0) as value\n"
			+ "from soch.ti_beneficiary_comm_dis tbcd inner join soch.ti_beneficiary tb on tb.id = tbcd.beneficiary_id  where tbcd.facility_id =:facilityId\n"
			+ "and tb.is_active =true and tb.is_deleted =false\n"
			+ "and to_char(tbcd.distribution_date,'YYYY')=to_char(now(),'YYYY') group by 1")
	List<StatisticsProjection> getMonthWiseNeedlesDistributed(@Param("facilityId") Long facilityId);

	/*@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_reg),'MONTH') AS name, "
			+ "		 COUNT(tib.id) AS value FROM soch.ti_beneficiary tib JOIN soch.beneficiary bn ON bn.id = tib.beneficiary_id  "
			+ "	   inner join master_client_status msc on msc.id = tib.status_id  "
			+ "		 WHERE tib.facility_id=:facilityId and  msc.id =5 and  tib.is_active = true and tib.is_deleted  = false  and to_char(date_of_reg,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")*/
	
	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',tib.modified_time),\r\n"
			+ "'MONTH') AS name,COUNT(tib.id) AS value FROM soch.ti_beneficiary tib\r\n"
			+ "JOIN soch.beneficiary bn ON bn.id = tib.beneficiary_id\r\n"
			+ "INNER JOIN master_client_status msc ON msc.id = tib.status_id\r\n"
			+ "WHERE tib.facility_id =:facilityId AND msc.id = 5 AND tib.is_active = TRUE\r\n"
			+ "AND tib.is_deleted = FALSE AND to_char(tib.modified_time ,\r\n"
			+ "'YYYY')= to_char(now(),'YYYY') GROUP BY 1")
	List<StatisticsProjection> getMonthwiseDropoutCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_screening),'MONTH') AS name,  "
			+ "		COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti  "
			+ "		 JOIN soch.ti_beneficiary tib ON sti.beneficiary_id = tib.id "
			+ "		 JOIN soch.beneficiary bn ON tib.beneficiary_id = bn.id "
			+ "		JOIN soch.master_infection_type mit on mit.id = sti.infection_id  "
			+ "		WHERE tib.facility_id=:facilityId and sti.screening_status_syphilis_id IS NOT NULL  "
			+ "		 AND mit.id = 2 and to_char(date_of_screening,'YYYY')=to_char(now(),'YYYY') and tib.is_active = true and tib.is_deleted  = false GROUP BY 1")
	List<StatisticsProjection> getMonthwiseTestingCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',bsrtd.followup_date ),'MONTH') AS name, COUNT(distinct bct.beneficiary_id) AS value\n"
			+ "FROM soch.beneficiary_clinical_treatment bct \n"
			+ "join soch.beneficiary_sti_rti_treatment_details bsrtd on bct.id = bsrtd.clinical_treatment_id\n"
			+ "join soch.beneficiary bn ON bct.beneficiary_id = bn.id\n"
			+ "where bsrtd.facility_id=:facilityId and (to_char(bsrtd.followup_date,'YYYY')=to_char(now(),'YYYY'))\n"
			+ "and bn.is_active = true and bn.is_delete = false GROUP BY 1;")
	List<StatisticsProjection> getMonthwiseDetectedCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_screening),'MONTH') AS name, "
			+ " COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti "
			+ " JOIN soch.ti_beneficiary tib ON sti.beneficiary_id = tib.id"
			+ " JOIN soch.beneficiary bn ON tib.beneficiary_id = bn.id"
			+ " join soch.master_syphilis_status mss on mss.id = sti.screening_status_syphilis_id "
			+ " join soch.master_infection_type mit on mit.id = sti.infection_id "
			+ " WHERE tib.facility_id=:facilityId and lower(mss.name) = 'reactive' "
			+ " and lower(mit.name)='syphilis' "
			+ " and to_char(date_of_screening,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseSyphilisReactiveCount(@Param("facilityId") Long facilityId);

	// this month
	@Query(nativeQuery = true, value = "select count(distinct tb.beneficiary_id) as value from soch.ti_ben_counselling tbc inner join ti_beneficiary tb   "
			+ "		on tbc.beneficiary_id  = tb.id  "
			+ "		where to_char(counselling_date,'YYYY-MM')=to_char(now(),'YYYY-MM')  "
			+ "		and tb.facility_id= :facilityId and  tbc.counselling_date is not null and tb.is_active  = true and tb.is_deleted  = false")
	List<StatisticsProjection> getHRGSCounselled(@Param("facilityId") Long facilityId);

	// till date
	@Query(nativeQuery = true, value = " select count(distinct tb.beneficiary_id) as value from soch.ti_ben_counselling tbc inner join soch.ti_beneficiary tb \n" +
			"on tbc.beneficiary_id  = tb.id  where tbc.counselling_date is not null and counselling_date<=current_date \n" +
			"and tb.facility_id= :facilityId and tb.is_active  = true and tb.is_deleted  = false")
	List<StatisticsProjection> getHRGSCounselledTillDate(@Param("facilityId") Long facilityId);

	// current month
	@Query(nativeQuery = true, value = "select count( distinct tb.beneficiary_id) as value from soch.ti_beneficiary_comm_dis bcd inner join ti_beneficiary tb on tb.id = bcd.beneficiary_id "
			+ "	inner join master_contact_type mct on bcd.master_contact_type_id  = mct.id and tb.facility_id =:facilityId "
			+ "	and to_char(bcd.created_time,'YYYY-MM')=to_char(now(),'YYYY-MM') and tb.is_active  = true and tb.is_deleted  = false")
	List<StatisticsProjection> getTotalContact(@Param("facilityId") Long facilityId);


	// Total Contact Till Date
	@Query(nativeQuery = true, value = "select  count(distinct tb.beneficiary_id) as value  from soch.ti_beneficiary_comm_dis bcd \n" +
			"inner join soch.ti_beneficiary tb on tb.id = bcd.beneficiary_id \n" +
			"inner join soch.master_contact_type mct on bcd.master_contact_type_id  = mct.id and tb.facility_id =:facilityId \n" +
			"and bcd.distribution_date <=current_date and tb.is_active  = true and tb.is_deleted  = false")
	List<StatisticsProjection> getTotalContactTillDate(@Param("facilityId") Long facilityId);

	// current month
	@Query(nativeQuery = true, value = "select count(distinct tb.beneficiary_id) as value from soch.ti_beneficiary_comm_dis bcd inner join ti_beneficiary tb on tb.id = bcd.beneficiary_id "
			+ "	inner join master_contact_type mct	on bcd.master_contact_type_id  = mct.id where mct.id = 1 and tb.facility_id =:facilityId and to_char(bcd.created_time,'YYYY-MM')=to_char(now(),'YYYY-MM') "
			+ "	and tb.is_active =true and tb.is_deleted = false")
	List<StatisticsProjection> getOneToOneContact(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select count(distinct tb.beneficiary_id) as value from soch.ti_beneficiary_comm_dis bcd inner join  soch.ti_beneficiary tb on tb.id = bcd.beneficiary_id\n" +
			" inner join soch.master_contact_type mct on bcd.master_contact_type_id  = mct.id where mct.id = 1 and tb.facility_id =:facilityId and bcd.distribution_date <=current_date\n" +
			" and tb.is_active =true and tb.is_deleted = false")
	List<StatisticsProjection> getOneToOneContactTillDate(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select coalesce (sum(tbra.condom_requirement_per_week),0) as value , "
			+ "			 to_char(tbra.assessment_date,'month') as name from soch.ti_ben_rv_assessment tbra inner join ti_beneficiary tb on tb.id = tbra.beneficiary_id  "
			+ "			 where tb.facility_id =:facilityId and tb.is_active and tb.is_deleted  = false and to_char(tbra.assessment_date,'YYYY')=to_char(now(),'YYYY') group by 2 ")
	List<StatisticsProjection> getMonthwiseCondomDemand(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select coalesce (sum(tbra.needles_syringes_requirement_per_week),0) as value , "
			+ "			to_char(tbra.assessment_date,'month') as name from soch.ti_ben_rv_assessment tbra inner join ti_beneficiary tb on tb.id = tbra.beneficiary_id "
			+ "			 where tb.facility_id =:facilityId and tb.is_active and tb.is_deleted  = false and to_char(tbra.assessment_date,'YYYY')=to_char(now(),'YYYY') group by 2 ")
	List<StatisticsProjection> getMonthwiseNeedlesDemand(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select coalesce (date_part ('year' ,  created_time),0) as year,coalesce (date_part ('month' ,  created_time),0) as month,coalesce (date_part ('year' ,  valid_till),0) as endYear, "
			+ "                    coalesce (date_part ('month' ,  valid_till ),0) as endMonth,coalesce (monthly_active_target,0) as targets from soch.facility where id=:facilityId")
	FacilityTargetProjection getMonthlyActiveTargetByFacilityId(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select coalesce (date_part ('year' ,  f.created_time),0) as year,coalesce (date_part ('month' ,  f.created_time),0) as month,coalesce (date_part ('year' ,  valid_till),0) as endYear,coalesce (date_part ('month' ,  valid_till ),0) as endMonth, "
			+ "                   coalesce (SUM(tfm.typology_target),0) as targets from typology_facility_mapping tfm inner join facility f on f.id = tfm.facility_id  "
			+ "where f.id = :facilityId and tfm.typology_id  IN :typology group by f.created_time,f.valid_till")
	FacilityTargetProjection getMonthlyActiveTargetByFacilityIdAndTypology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select monthly_syphilis_target from soch.facility where id =:facilityId")
	Integer getMonthlySyphilisTargetByFacilityId(@Param("facilityId") Long facilityId);
	
	
	@Query(nativeQuery = true, value = " select ahbcr.month as name ,\r\n" +
            "sum(ahbcr.active_hrg_count) as value  \r\n" +
            "from soch.active_hrg_beneficiary_count_record ahbcr\r\n" +
            "join soch.ti_beneficiary tiben on tiben.beneficiary_id=ahbcr.beneficiary_id\r\n"+
            "where ahbcr.facility_id = :facilityId and ahbcr.year =to_char(now(),'YYYY') and tiben.status_id=1 and tiben.is_deleted=false\r\n" +
            "and ahbcr.gender_id IN :gender and ahbcr.typology_id IN :typology\r\n" +
            "group by ahbcr.month ")
	List<StatisticsProjection> getMonthwiseActiveCountByGenderAndTypology(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

		
		@Query(nativeQuery = true, value = " select ahbcr.month as name ,\r\n" +
            "sum(ahbcr.active_hrg_count) as value  \r\n" +
            "from soch.active_hrg_beneficiary_count_record ahbcr\r\n" +
            "where ahbcr.facility_id = :facilityId and ahbcr.year =to_char(now(),'YYYY')\r\n" +
            "and ahbcr.gender_id IN :gender \r\n" +
            "group by ahbcr.month ")
	List<StatisticsProjection> getMonthwiseActiveCountByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

		
		@Query(nativeQuery = true, value = "select ahbcr.month as name ,\r\n" +
                "sum(ahbcr.active_hrg_count) as value  \r\n" +
                "from soch.active_hrg_beneficiary_count_record ahbcr\r\n" +
                "join soch.ti_beneficiary tiben on tiben.beneficiary_id=ahbcr.beneficiary_id\r\n"+
                "where ahbcr.facility_id = :facilityId and ahbcr.year =to_char(now(),'YYYY') and tiben.status_id=1 and tiben.is_deleted=false\r\n" +
                "and ahbcr.typology_id IN :typology\r\n" +
                "group by ahbcr.month")
	List<StatisticsProjection> getMonthwiseActiveCountByTypology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);


	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_reg),'MONTH') AS name, "
			+ " COUNT(tib.id) AS value FROM soch.ti_beneficiary tib"
			+ " JOIN soch.beneficiary bn ON bn.id = tib.beneficiary_id"
			+ " WHERE tib.facility_id=:facilityId and bn.gender_id IN :gender and tib.master_hrg_primary_id IN :typology and tib.is_active = true and tib.is_deleted  = false and to_char(date_of_reg,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseRegistrationCountByGenderAndTopology(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_reg),'MONTH') AS name, "
			+ " COUNT(tib.id) AS value FROM soch.ti_beneficiary tib"
			+ " JOIN soch.beneficiary bn ON bn.id = tib.beneficiary_id"
			+ " WHERE tib.facility_id=:facilityId and bn.gender_id IN :gender  and tib.is_active = true and tib.is_deleted  = false and to_char(date_of_reg,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseRegistrationCountByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_reg),'MONTH') AS name, "
			+ " COUNT(tib.id) AS value FROM soch.ti_beneficiary tib"
			+ " JOIN soch.beneficiary bn ON bn.id = tib.beneficiary_id"
			+ " WHERE tib.facility_id=:facilityId and tib.master_hrg_primary_id IN :typology and tib.is_active = true and tib.is_deleted  = false and to_char(date_of_reg,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseRegistrationCountByTopology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_reg),'MONTH') AS name, "
			+ "     COUNT(tib.id) AS value FROM soch.ti_beneficiary tib JOIN soch.beneficiary bn ON bn.id = tib.beneficiary_id  "
			+ "     inner join master_client_status msc on msc.id = bn.client_status_id  "
			+ "     WHERE tib.facility_id=:facilityId and bn.gender_id IN :gender and tib.master_hrg_primary_id IN :typology and  msc.id =5 and  tib.is_active = true and tib.is_deleted  = false  and to_char(date_of_reg,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseDropoutCountByGenderAndTypology(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_reg),'MONTH') AS name, "
			+ "     COUNT(tib.id) AS value FROM soch.ti_beneficiary tib JOIN soch.beneficiary bn ON bn.id = tib.beneficiary_id  "
			+ "     inner join master_client_status msc on msc.id = bn.client_status_id  "
			+ "     WHERE tib.facility_id=:facilityId and tib.master_hrg_primary_id IN :typology and  msc.id =5 and  tib.is_active = true and tib.is_deleted  = false  and to_char(date_of_reg,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseDropoutCountByTypology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_reg),'MONTH') AS name, "
			+ "     COUNT(tib.id) AS value FROM soch.ti_beneficiary tib JOIN soch.beneficiary bn ON bn.id = tib.beneficiary_id  "
			+ "     inner join master_client_status msc on msc.id = bn.client_status_id  "
			+ "     WHERE tib.facility_id=:facilityId and bn.gender_id IN :gender and  msc.id =5 and  tib.is_active = true and tib.is_deleted  = false  and to_char(date_of_reg,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseDropoutCountByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

	// @Query(nativeQuery = true, value = " select b.id as beneficiaryId, b.uid
	// as beneficiaryUId, "
	// + " b.first_name as firstname, b.middle_name as middlename, b.last_name
	// as lastname, "
	// + " b.gender_id as gender, b.pre_art_number as preArtNumber, "
	// + " b.art_number as artNumber from soch.beneficiary as b "
	// + " join soch.art_beneficiary as ab on ab.beneficiary_id= b.id "
	// + " left join soch.beneficiary_transit_facility as btf on
	// btf.beneficiary_id=b.id "
	// + " where ab.is_active=true and ab.is_delete=false and
	// ab.facility_id=:facilityId "
	// + " and ab.is_transit = true and current_date BETWEEN SYMMETRIC
	// ab.transit_start_date AND ab.transit_end_date and
	// btf.facility_id=:currentFacilityId "
	// + " and (lower(b.first_name) like %:searchText% or lower(b.middle_name)
	// like %:searchText% "
	// + " or lower(b.last_name) like %:searchText% or
	// lower(concat(b.first_name,' ',b.middle_name,' ',b.last_name)) like
	// %:searchText% "
	// + " or lower(b.art_number) like %:searchText% or lower(b.pre_art_number)
	// like %:searchText% ); ")
	// List<ArtTransitBeneficiaryProjection>
	// findByFacilityIdAndSearchText(@Param("facilityId") Long facilityId,
	// @Param("currentFacilityId") Long currentFacilityId, @Param("searchText")
	// String searchText);

	@Query(nativeQuery = true, value = " select b.id as beneficiaryId, b.uid as beneficiaryUId, "
			+ "	b.first_name as firstname, b.middle_name as middlename, b.last_name as lastname, "
			+ "	b.gender_id as gender, b.pre_art_number as preArtNumber, "
			+ "	b.art_number as artNumber  from soch.beneficiary as b "
			+ " join soch.art_beneficiary as ab on ab.beneficiary_id= b.id "
			+ " where ab.is_active=true and ab.is_delete=false and ab.facility_id=:facilityId "
			+ " and (lower(b.first_name) like %:searchText% or lower(b.middle_name) like %:searchText% "
			+ " or lower(b.last_name) like %:searchText% or lower(concat(b.first_name,' ',b.middle_name,' ',b.last_name)) like %:searchText% "
			+ " or lower(b.art_number) like %:searchText% or lower(b.pre_art_number) like %:searchText% ); ")
	List<ArtTransitBeneficiaryProjection> findByFacilityIdAndSearchText(@Param("searchText") String searchText,
			@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_screening),'MONTH') AS name,  "
			+ "        COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti  "
			+ "        JOIN soch.ti_beneficiary tib ON sti.beneficiary_id = tib.id "
			+ "        JOIN soch.beneficiary bn ON tib.beneficiary_id = bn.id "
			+ "        JOIN soch.master_infection_type mit on mit.id = sti.infection_id  "
			+ "        WHERE tib.facility_id=:facilityId and bn.gender_id IN :gender and tib.master_hrg_primary_id IN :typology and sti.screening_status_syphilis_id IS NOT NULL  "
			+ "        AND mit.id = 2 and to_char(date_of_screening,'YYYY')=to_char(now(),'YYYY') and tib.is_active = true and tib.is_deleted  = false GROUP BY 1")
	List<StatisticsProjection> getMonthwiseTreatedCountByGenderAndTypology(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_screening),'MONTH') AS name,  "
			+ "        COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti  "
			+ "        JOIN soch.ti_beneficiary tib ON sti.beneficiary_id = tib.id "
			+ "        JOIN soch.beneficiary bn ON tib.beneficiary_id = bn.id "
			+ "        JOIN soch.master_infection_type mit on mit.id = sti.infection_id  "
			+ "        WHERE tib.facility_id=:facilityId and bn.gender_id IN :gender and sti.screening_status_syphilis_id IS NOT NULL  "
			+ "        AND mit.id = 2 and to_char(date_of_screening,'YYYY')=to_char(now(),'YYYY') and tib.is_active = true and tib.is_deleted  = false GROUP BY 1")
	List<StatisticsProjection> getMonthwiseTreatedCountByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_screening),'MONTH') AS name,  "
			+ "        COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti  "
			+ "        JOIN soch.ti_beneficiary tib ON sti.beneficiary_id = tib.id "
			+ "        JOIN soch.beneficiary bn ON tib.beneficiary_id = bn.id "
			+ "        JOIN soch.master_infection_type mit on mit.id = sti.infection_id  "
			+ "        WHERE tib.facility_id=:facilityId  and tib.master_hrg_primary_id IN :typology and sti.screening_status_syphilis_id IS NOT NULL  "
			+ "        AND mit.id = 2 and to_char(date_of_screening,'YYYY')=to_char(now(),'YYYY') and tib.is_active = true and tib.is_deleted  = false GROUP BY 1")
	List<StatisticsProjection> getMonthwiseTreatedCountByTopology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',bsrtd.followup_date ),'MONTH') AS name, COUNT(distinct bct.beneficiary_id) AS value \n"
			+ "FROM soch.beneficiary_clinical_treatment bct \n"
			+ "join soch.beneficiary_sti_rti_treatment_details bsrtd on bct.id = bsrtd.clinical_treatment_id\n"
			+ "JOIN soch.beneficiary bn ON bct.beneficiary_id = bn.id\n"
			+ "join soch.ti_beneficiary tb on tb.beneficiary_id = bn.id\n"
			+ "WHERE bsrtd.facility_id=:facilityId and bn.gender_id IN :gender and tb.master_hrg_primary_id IN :typology\n"
			+ "and (to_char(bsrtd.followup_date,'YYYY')=to_char(now(),'YYYY')) and tb.is_active = true and tb.is_deleted  = false GROUP BY 1")
	List<StatisticsProjection> getMonthwiseDetectedCountByGenderAndTypology(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',bsrtd.followup_date ),'MONTH') AS name, COUNT(distinct bct.beneficiary_id) AS value \n"
			+ "FROM soch.beneficiary_clinical_treatment bct \n"
			+ "join soch.beneficiary_sti_rti_treatment_details bsrtd on bct.id = bsrtd.clinical_treatment_id\n"
			+ "JOIN soch.beneficiary bn ON bct.beneficiary_id = bn.id\n"
			+ "WHERE bsrtd.facility_id=:facilityId and bn.gender_id IN :gender\n"
			+ "and (to_char(bsrtd.followup_date,'YYYY')=to_char(now(),'YYYY') ) and bn.is_active  = true and bn.is_delete  = false GROUP BY 1")
	List<StatisticsProjection> getMonthwiseDetectedCountByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',bsrtd.followup_date),'MONTH') AS name,COUNT(distinct bct.beneficiary_id) AS value \n"
			+ "FROM soch.beneficiary_clinical_treatment bct \n"
			+ "join soch.beneficiary_sti_rti_treatment_details bsrtd on bct.id = bsrtd.clinical_treatment_id\n"
			+ "JOIN soch.beneficiary bn ON bct.beneficiary_id = bn.id\n"
			+ "join soch.ti_beneficiary tb on tb.beneficiary_id = bn.id\n"
			+ "WHERE bsrtd.facility_id=:facilityId and tb.master_hrg_primary_id IN :typology\n"
			+ "and (to_char(bsrtd.followup_date,'YYYY')=to_char(now(),'YYYY') ) and tb.is_active  = true and tb.is_deleted  = false GROUP BY 1")
	List<StatisticsProjection> getMonthwiseDetectedCountByTypology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_screening),'MONTH') AS name, "
			+ " COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti "
			+ " JOIN soch.ti_beneficiary tib ON sti.beneficiary_id = tib.id"
			+ " JOIN soch.beneficiary bn ON tib.beneficiary_id = bn.id"
			+ " join soch.master_syphilis_status mss on mss.id = sti.screening_status_syphilis_id "
			+ " join soch.master_infection_type mit on mit.id = sti.infection_id "
			+ " WHERE tib.facility_id=:facilityId and bn.gender_id IN :gender and tib.master_hrg_primary_id IN :typology and lower(mss.name) = 'reactive' "
			+ " and lower(mit.name)='syphilis' "
			+ " and to_char(date_of_screening,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseSyphilisReactiveCountByGenderAndTypology(
			@Param("facilityId") Long facilityId, @Param("gender") List<Integer> gender,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_screening),'MONTH') AS name, "
			+ " COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti "
			+ " JOIN soch.ti_beneficiary tib ON sti.beneficiary_id = tib.id"
			+ " JOIN soch.beneficiary bn ON tib.beneficiary_id = bn.id"
			+ " join soch.master_syphilis_status mss on mss.id = sti.screening_status_syphilis_id "
			+ " join soch.master_infection_type mit on mit.id = sti.infection_id "
			+ " WHERE tib.facility_id=:facilityId and bn.gender_id IN :gender and lower(mss.name) = 'reactive' "
			+ " and lower(mit.name)='syphilis' "
			+ " and to_char(date_of_screening,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseSyphilisReactiveCountByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_screening),'MONTH') AS name, "
			+ " COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti "
			+ " JOIN soch.ti_beneficiary tib ON sti.beneficiary_id = tib.id"
			+ " JOIN soch.beneficiary bn ON tib.beneficiary_id = bn.id"
			+ " join soch.master_syphilis_status mss on mss.id = sti.screening_status_syphilis_id "
			+ " join soch.master_infection_type mit on mit.id = sti.infection_id "
			+ " WHERE tib.facility_id=:facilityId  and tib.master_hrg_primary_id IN :typology and lower(mss.name) = 'reactive' "
			+ " and lower(mit.name)='syphilis' "
			+ " and to_char(date_of_screening,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseSyphilisReactiveCountByTypology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select count(distinct tb.beneficiary_id) as value from soch.ti_ben_counselling tbc  "
			+ " inner join soch.ti_beneficiary tb on tbc.beneficiary_id  = tb.id "
			+ " inner join soch.beneficiary b on b.id = tb.beneficiary_id "
			+ " where to_char(counselling_date,'YYYY-MM')=to_char(now(),'YYYY-MM') "
			+ " and tb.facility_id= :facilityId and  tbc.counselling_date is not null "
			+ " and tb.is_active  = true and tb.is_deleted  = false "
			+ " and tb.master_hrg_primary_id IN :typology and b.gender_id IN :gender ")
	List<StatisticsProjection> getHRGSCounselledByGenderAndTypology(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select count(distinct tb.beneficiary_id) as value from soch.ti_ben_counselling tbc \n" +
			"inner join soch.ti_beneficiary tb on tbc.beneficiary_id  = tb.id \n" +
			"inner join soch.beneficiary b on b.id = tb.beneficiary_id \n" +
			"where tb.facility_id= :facilityId and  tbc.counselling_date is not null  and counselling_date <= current_date \n" +
			"and tb.is_active  = true and tb.is_deleted  = false and b.gender_id IN :gender and tb.master_hrg_primary_id IN :typology  ")
	List<StatisticsProjection> getHRGSCounselledTillDateByGenderAndTypology(@Param("facilityId") Long facilityId,
																	@Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select count(distinct tb.beneficiary_id) as value from soch.ti_ben_counselling tbc "
			+ " inner join soch.ti_beneficiary tb on tbc.beneficiary_id  = tb.id "
			+ " inner join soch.beneficiary b on b.id = tb.beneficiary_id "
			+ " where to_char(counselling_date,'YYYY-MM')=to_char(now(),'YYYY-MM') and tb.facility_id=:facilityId "
			+ " and  tbc.counselling_date is not null" + " and tb.is_active  = true and tb.is_deleted  = false "
			+ " and b.gender_id IN :gender ")
	List<StatisticsProjection> getHRGSCounselledByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

	@Query(nativeQuery = true, value = "select count(distinct tb.beneficiary_id) as value from soch.ti_ben_counselling tbc "
			+ " inner join soch.ti_beneficiary tb on tbc.beneficiary_id  = tb.id "
			+ " inner join soch.beneficiary b on b.id = tb.beneficiary_id "
			+ " where tb.facility_id=:facilityId and  tbc.counselling_date is not null and counselling_date <= current_date "
			+ " and tb.is_active  = true and tb.is_deleted  = false "
			+ " and b.gender_id IN :gender ")
	List<StatisticsProjection> getHRGSCounselledTillDateByGender(@Param("facilityId") Long facilityId,
														 @Param("gender") List<Integer> gender);

	@Query(nativeQuery = true, value = "select count(distinct tb.beneficiary_id) as value from soch.ti_ben_counselling tbc "
			+ " inner join soch.ti_beneficiary tb on tbc.beneficiary_id  = tb.id "
			+ " where to_char(counselling_date,'YYYY-MM')=to_char(now(),'YYYY-MM') "
			+ " and tb.facility_id= :facilityId and  tbc.counselling_date is not null "
			+ " and tb.is_active  = true and tb.is_deleted  = false " + " and tb.master_hrg_primary_id IN :typology ")
	List<StatisticsProjection> getHRGSCounselledByTypology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select count(distinct tb.beneficiary_id) as value from soch.ti_ben_counselling tbc "
			+ " inner join soch.ti_beneficiary tb on tbc.beneficiary_id  = tb.id "
			+ " where tb.facility_id= :facilityId "
			+ " and tbc.counselling_date is not null and counselling_date <= current_date"
			+ " and tb.is_active  = true and tb.is_deleted  = false  and tb.master_hrg_primary_id IN :typology ")
	List<StatisticsProjection> getHRGSCounselledTillDateByTypology(@Param("facilityId") Long facilityId,
														   @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select count( distinct tb.beneficiary_id) as value from soch.ti_beneficiary_comm_dis bcd "
			+ " inner join soch.ti_beneficiary tb on tb.id = bcd.beneficiary_id "
			+ " inner join soch.master_contact_type mct on bcd.master_contact_type_id  = mct.id "
			+ " inner join soch.beneficiary b on b.id = tb.beneficiary_id "
			+ " and tb.facility_id =:facilityId and to_char(bcd.created_time,'YYYY-MM')=to_char(now(),'YYYY-MM')"
			+ " and tb.is_active  = true and tb.is_deleted  = false"
			+ " and tb.master_hrg_primary_id IN :typology and b.gender_id IN :gender ")
	List<StatisticsProjection> getTotalContactByGenderAndTypology(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select  count(distinct tb.beneficiary_id) as value  from soch.ti_beneficiary_comm_dis bcd \n" +
			" inner join soch.ti_beneficiary tb on tb.id = bcd.beneficiary_id \n" +
			" inner join soch.master_contact_type mct on bcd.master_contact_type_id  = mct.id  inner join soch.beneficiary b on b.id = tb.beneficiary_id and tb.facility_id =:facilityId \n" +
			" and bcd.distribution_date <=current_date and tb.is_active  = true and tb.is_deleted  = false \n" +
			" and b.gender_id IN :gender and tb.master_hrg_primary_id IN :typology ")
	List<StatisticsProjection> getTotalContactTillDateByGenderAndTypology(@Param("facilityId") Long facilityId,
																  @Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select count( distinct tb.beneficiary_id) as value from soch.ti_beneficiary_comm_dis bcd "
			+ " inner join soch.ti_beneficiary tb on tb.id = bcd.beneficiary_id "
			+ " inner join soch.master_contact_type mct on bcd.master_contact_type_id  = mct.id "
			+ " inner join soch.beneficiary b on b.id = tb.beneficiary_id "
			+ " and tb.facility_id =:facilityId and to_char(bcd.created_time,'YYYY-MM')=to_char(now(),'YYYY-MM') "
			+ " and tb.is_active  = true and tb.is_deleted  = false and b.gender_id IN :gender ")
	List<StatisticsProjection> getTotalContactByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

	@Query(nativeQuery = true, value = "select  count(distinct tb.beneficiary_id) as value  from soch.ti_beneficiary_comm_dis bcd \n" +
			"inner join soch.ti_beneficiary tb on tb.id = bcd.beneficiary_id \n" +
			"inner join soch.master_contact_type mct on bcd.master_contact_type_id  = mct.id inner join soch.beneficiary b on b.id = tb.beneficiary_id and tb.facility_id =:facilityId \n" +
			"and bcd.distribution_date <=current_date and tb.is_active  = true and tb.is_deleted  = false \n" +
			"and b.gender_id IN :gender ")
	List<StatisticsProjection> getTotalContactTillDateByGender(@Param("facilityId") Long facilityId,
													   @Param("gender") List<Integer> gender);

	@Query(nativeQuery = true, value = "select  count(distinct tb.beneficiary_id) as value  from soch.ti_beneficiary_comm_dis bcd \n" +
			"inner join soch.ti_beneficiary tb on tb.id = bcd.beneficiary_id \n" +
			"inner join soch.master_contact_type mct on bcd.master_contact_type_id  = mct.id and tb.facility_id =:facilityId \n" +
			"and bcd.distribution_date <=current_date and tb.is_active  = true and tb.is_deleted  = false \n" +
			"and tb.master_hrg_primary_id IN :typology ")
	List<StatisticsProjection> getTotalContactTillDateByTypology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select count( distinct tb.beneficiary_id) as value from soch.ti_beneficiary_comm_dis bcd  "
			+ " inner join soch.ti_beneficiary tb on tb.id = bcd.beneficiary_id "
			+ " inner join soch.master_contact_type mct on bcd.master_contact_type_id  = mct.id  "
			+ " and tb.facility_id = :facilityId and to_char(bcd.created_time,'YYYY-MM')=to_char(now(),'YYYY-MM') "
			+ " and tb.is_active  = true and tb.is_deleted  = false and tb.master_hrg_primary_id IN :typology ")
	List<StatisticsProjection> getTotalContactByTypology(@Param("facilityId") Long facilityId,
														 @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select count(distinct tb.beneficiary_id) as value from soch.ti_beneficiary_comm_dis bcd  "
			+ " inner join soch.ti_beneficiary tb on tb.id = bcd.beneficiary_id "
			+ " inner join soch.master_contact_type mct	on bcd.master_contact_type_id  = mct.id"
			+ " inner join soch.beneficiary b on b.id = tb.beneficiary_id"
			+ " where mct.id = 1 and tb.facility_id =:facilityId "
			+ " and to_char(bcd.created_time,'YYYY-MM')=to_char(now(),'YYYY-MM') and tb.is_active =true and tb.is_deleted = false"
			+ " and tb.master_hrg_primary_id IN :typology " + " and b.gender_id IN :gender ")
	List<StatisticsProjection> getOneToOneContactByGenderAndTypology(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select count(distinct tb.beneficiary_id) as value from soch.ti_beneficiary_comm_dis bcd inner join  soch.ti_beneficiary tb on tb.id = bcd.beneficiary_id \n" +
			"inner join soch.master_contact_type mct on bcd.master_contact_type_id  = mct.id inner join soch.beneficiary b on b.id = tb.beneficiary_id where mct.id = 1 and tb.facility_id =:facilityId and bcd.distribution_date <=current_date \n" +
			"and tb.is_active =true and tb.is_deleted = false and b.gender_id IN :gender and tb.master_hrg_primary_id IN :typology ")
	List<StatisticsProjection> getOneToOneContactTillDateByGenderAndTypology(@Param("facilityId") Long facilityId,
																	 @Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select count(distinct tb.beneficiary_id) as value from soch.ti_beneficiary_comm_dis bcd "
			+ " inner join soch.ti_beneficiary tb on tb.id = bcd.beneficiary_id "
			+ " inner join soch.master_contact_type mct	on bcd.master_contact_type_id  = mct.id "
			+ " inner join soch.beneficiary b on b.id = tb.beneficiary_id "
			+ " where mct.id = 1 and tb.facility_id = :facilityId "
			+ " and to_char(bcd.created_time,'YYYY-MM')=to_char(now(),'YYYY-MM') "
			+ " and tb.is_active =true and tb.is_deleted = false and b.gender_id IN :gender ")
	List<StatisticsProjection> getOneToOneContactByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

	@Query(nativeQuery = true, value = " select count(distinct tb.beneficiary_id) as value from soch.ti_beneficiary_comm_dis bcd inner join  soch.ti_beneficiary tb on tb.id = bcd.beneficiary_id \n" +
			" inner join soch.master_contact_type mct on bcd.master_contact_type_id  = mct.id inner join soch.beneficiary b on b.id = tb.beneficiary_id where mct.id = 1 and tb.facility_id =:facilityId and bcd.distribution_date <=current_date \n" +
			" and tb.is_active =true and tb.is_deleted = false  and b.gender_id IN :gender ")
	List<StatisticsProjection> getOneToOneContactTillDatetByGender(@Param("facilityId") Long facilityId,
														  @Param("gender") List<Integer> gender);

	@Query(nativeQuery = true, value = "select count(distinct tb.beneficiary_id) as value from soch.ti_beneficiary_comm_dis bcd "
			+ " inner join soch.ti_beneficiary tb on tb.id = bcd.beneficiary_id "
			+ " inner join soch.master_contact_type mct	on bcd.master_contact_type_id  = mct.id "
			+ " where mct.id = 1 and tb.facility_id =:facilityId "
			+ " and to_char(bcd.created_time,'YYYY-MM')=to_char(now(),'YYYY-MM') "
			+ " and tb.is_active =true and tb.is_deleted = false and tb.master_hrg_primary_id IN :typology ")
	List<StatisticsProjection> getOneToOneContactByTypology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select count(distinct tb.beneficiary_id) as value from soch.ti_beneficiary_comm_dis bcd inner join  soch.ti_beneficiary tb on tb.id = bcd.beneficiary_id \n" +
			"inner join soch.master_contact_type mct on bcd.master_contact_type_id  = mct.id where mct.id = 1 and tb.facility_id =:facilityId and bcd.distribution_date <=current_date \n" +
			"and tb.is_active =true and tb.is_deleted = false and tb.master_hrg_primary_id IN :typology ")
	List<StatisticsProjection> getOneToOneContactTillDateByTypology(@Param("facilityId") Long facilityId,
															@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.date_of_screening),'MONTH') AS name, "
			+ " COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti "
			+ " join soch.ti_beneficiary tcb on tcb.id = sti.beneficiary_id "
			+ " join soch.beneficiary bn on bn.id = tcb.beneficiary_id "
			+ " join soch.master_infection_type mit on mit.id = sti.infection_id  "
			+ " WHERE tcb.facility_id= :facilityId and mit.id =1 " + " and sti.screening_status_hiv_id IS NOT NULL "
			+ " and to_char(sti.date_of_screening,'YYYY')=to_char(now(),'YYYY')  "
			+ " and bn.gender_id IN :gender and tcb.master_hrg_primary_id IN :typology GROUP BY 1 ")
	List<StatisticsProjection> getMonthwiseHivTestedByGenderAndTypology(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.date_of_screening),'MONTH') AS name, "
			+ " COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti "
			+ " join soch.ti_beneficiary tcb on tcb.id = sti.beneficiary_id "
			+ " join soch.beneficiary bn on bn.id = tcb.beneficiary_id "
			+ " join soch.master_infection_type mit on mit.id = sti.infection_id  "
			+ " WHERE tcb.facility_id= :facilityId and mit.id =1 " + " and sti.screening_status_hiv_id IS NOT NULL "
			+ " and to_char(sti.date_of_screening,'YYYY')=to_char(now(),'YYYY')  "
			+ " and bn.gender_id IN :gender GROUP BY 1 ")
	List<StatisticsProjection> getMonthwiseHivTestedByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.date_of_screening),'MONTH') AS name, "
			+ " COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti "
			+ " join soch.ti_beneficiary tcb on tcb.id = sti.beneficiary_id "
			+ " join soch.beneficiary bn on bn.id = tcb.beneficiary_id "
			+ " join soch.master_infection_type mit on mit.id = sti.infection_id  "
			+ " WHERE tcb.facility_id= :facilityId and mit.id =1 " + " and sti.screening_status_hiv_id IS NOT NULL "
			+ " and to_char(sti.date_of_screening,'YYYY')=to_char(now(),'YYYY')  "
			+ " and tcb.master_hrg_primary_id IN :typology GROUP BY 1 ")
	List<StatisticsProjection> getMonthwiseHivTestedByTypology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.date_of_screening),'MONTH') AS name, "
			+ " COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti "
			+ " join soch.ti_beneficiary tcb on tcb.id = sti.beneficiary_id  "
			+ " join soch.beneficiary bn on bn.id = tcb.beneficiary_id  "
			+ " join soch.master_infection_type mit on mit.id = sti.infection_id "
			+ " join soch.master_hiv_screening_status mhss on mhss.id = sti.screening_status_hiv_id "
			+ " WHERE tcb.facility_id= :facilityId and mit.id =1  and mhss.id=1 "
			+ " and to_char(sti.date_of_screening,'YYYY')=to_char(now(),'YYYY')  "
			+ " and tcb.master_hrg_primary_id IN :typology and bn.gender_id IN :gender GROUP BY 1 ")
	List<StatisticsProjection> getMonthwiseHivReactiveByGenderAndTypology(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.date_of_screening),'MONTH') AS name, "
			+ " COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti "
			+ " join soch.ti_beneficiary tcb on tcb.id = sti.beneficiary_id  "
			+ " join soch.beneficiary bn on bn.id = tcb.beneficiary_id  "
			+ " join soch.master_infection_type mit on mit.id = sti.infection_id "
			+ " join soch.master_hiv_screening_status mhss on mhss.id = sti.screening_status_hiv_id "
			+ " WHERE tcb.facility_id= :facilityId and mit.id =1  and mhss.id=1 "
			+ " and to_char(sti.date_of_screening,'YYYY')=to_char(now(),'YYYY')  "
			+ " and bn.gender_id IN :gender GROUP BY 1 ")
	List<StatisticsProjection> getMonthwiseHivReactiveByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.date_of_screening),'MONTH') AS name, "
			+ " COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti "
			+ " join soch.ti_beneficiary tcb on tcb.id = sti.beneficiary_id  "
			+ " join soch.beneficiary bn on bn.id = tcb.beneficiary_id  "
			+ " join soch.master_infection_type mit on mit.id = sti.infection_id "
			+ " join soch.master_hiv_screening_status mhss on mhss.id = sti.screening_status_hiv_id "
			+ " WHERE tcb.facility_id= :facilityId and mit.id =1  and mhss.id=1 "
			+ " and to_char(sti.date_of_screening,'YYYY')=to_char(now(),'YYYY')  "
			+ " and tcb.master_hrg_primary_id IN :typology GROUP BY 1 ")
	List<StatisticsProjection> getMonthwiseHivReactiveByTypology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select DISTINCT b.pre_art_number as preArtNumber, b.id as beneficiaryId from soch.beneficiary as b "
			+ "	join soch.art_beneficiary as ab on ab.beneficiary_id = b.id "
			+ "	where  ab.facility_id = :facilityId  and b.pre_art_number = :preArtNumber and b.is_delete = false and b.is_active = true")
	Optional<ArtBeneficiaryRegistrationProjection> findByPreArtNumber(@Param("preArtNumber") String preArtNumber,
			@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select DISTINCT b.art_number as artNumber ,b.id as beneficiaryId from soch.beneficiary as b "
			+ "	join soch.art_beneficiary as ab on ab.beneficiary_id = b.id "
			+ "	where  ab.facility_id = :facilityId  and b.art_number  = :artNumber and b.is_delete = false and b.is_active = true")
	Optional<ArtBeneficiaryRegistrationProjection> findByArtNumber(@Param("artNumber") String artNumber,
			@Param("facilityId") Long facilityId);

	/*
	 * @Query(nativeQuery = true ,value =
	 * "select count(beneficiary_id) as value,TO_CHAR(date_of_reg,'MONTH') as name "
	 * +
	 * " from soch.ti_core_beneficiary tcb join soch.beneficiary b on b.id = tcb.beneficiary_id "
	 * +
	 * " where tcb.hiv_art_linked = true and tcb.facility_id =:facilityId and b.gender IN :gender "
	 * +
	 * " and tcb.typology IN :typology and to_char(tcb.date_of_reg,'YYYY')=to_char(now(),'YYYY') group by 2"
	 * ) List<StatisticsProjection>
	 * getHIVLinkedByGenderAndTopology(@Param("facilityId") Long
	 * facilityId, @Param("gender") List<String> gender,
	 * 
	 * @Param("typology") List<String> typology);
	 */

	/*
	 * @Query(nativeQuery = true ,value =
	 * "select count(beneficiary_id) as value,TO_CHAR(date_of_reg,'MONTH') as name "
	 * +
	 * " from soch.ti_core_beneficiary tcb join soch.beneficiary b on b.id = tcb.beneficiary_id "
	 * +
	 * " where tcb.hiv_art_linked = true and tcb.facility_id =:facilityId and b.gender IN :gender "
	 * +
	 * " and to_char(tcb.date_of_reg,'YYYY')=to_char(now(),'YYYY') group by 2 ")
	 * List<StatisticsProjection> getHIVLinkedByGender(@Param("facilityId") Long
	 * facilityId, @Param("gender") List<String> gender);
	 */

	/*
	 * @Query(nativeQuery = true ,value =
	 * "select count(beneficiary_id) as value,TO_CHAR(date_of_reg,'MONTH') as name "
	 * +
	 * " from soch.ti_core_beneficiary tcb join soch.beneficiary b on b.id = tcb.beneficiary_id "
	 * +
	 * " where tcb.hiv_art_linked = true and tcb.facility_id =:facilityId and  tcb.typology IN :typology "
	 * +
	 * " and to_char(tcb.date_of_reg,'YYYY')=to_char(now(),'YYYY') group by 2 ")
	 * List<StatisticsProjection> getHIVLinkedByTypology(@Param("facilityId")
	 * Long facilityId, @Param("typology") List<String> typology);
	 */

	/*
	 * @Query(nativeQuery = true , value =
	 * "select count(bast.beneficiary_id) as value , 'Preparedness' as name " +
	 * " from soch.beneficiary_art_status_tracking bast " +
	 * " join soch.master_beneficiary_activity_status mbas on mbas.id = bast.art_beneficiary_status_id "
	 * + " join soch.beneficiary b on b.id = bast.beneficiary_id " +
	 * " join soch.ti_beneficiary tb on tb.beneficiary_id = b.id " +
	 * " where mbas.name = 'ART Preparedness Counselling' and to_char(bast.created_time,'YYYY')=to_char(now(),'YYYY')"
	 * + " and bast.facility_id =:facilityId and b.gender IN :gender " +
	 * " and tb.typology IN :typology group by 2") List<StatisticsProjection>
	 * getArtPreparednessByGenderAndTypology(@Param("facilityId") Long
	 * facilityId, @Param("gender") List<String> gender,
	 * 
	 * @Param("typology") List<String> typology);
	 */

	/*
	 * @Query(nativeQuery = true , value =
	 * "select count(bast.beneficiary_id) as value , 'Preparedness' as name " +
	 * " from soch.beneficiary_art_status_tracking bast " +
	 * " join soch.master_beneficiary_activity_status mbas on mbas.id = bast.art_beneficiary_status_id "
	 * + " join soch.beneficiary b on b.id = bast.beneficiary_id " +
	 * " join soch.ti_beneficiary tb on tb.beneficiary_id = b.id " +
	 * " where mbas.name = 'ART Preparedness Counselling' and to_char(bast.created_time,'YYYY')=to_char(now(),'YYYY')"
	 * + " and bast.facility_id =:facilityId and b.gender IN :gender " +
	 * " group by 2") List<StatisticsProjection>
	 * getArtPreparednessByGender(@Param("facilityId") Long
	 * facilityId, @Param("gender") List<String> gender);
	 */

	/*
	 * @Query(nativeQuery = true , value =
	 * "select count(bast.beneficiary_id) as value , 'Preparedness' as name " +
	 * " from soch.beneficiary_art_status_tracking bast " +
	 * " join soch.master_beneficiary_activity_status mbas on mbas.id = bast.art_beneficiary_status_id "
	 * + " join soch.beneficiary b on b.id = bast.beneficiary_id " +
	 * " join soch.ti_beneficiary tb on tb.beneficiary_id = b.id " +
	 * " where mbas.name = 'ART Preparedness Counselling' and to_char(bast.created_time,'YYYY')=to_char(now(),'YYYY')"
	 * + " and bast.facility_id =:facilityId and tb.typology IN :typology " +
	 * " group by 2") List<StatisticsProjection>
	 * getArtPreparednessByTypology(@Param("facilityId") Long
	 * facilityId, @Param("typology") List<String> typology);
	 */

	/*
	 * @Query(nativeQuery=true , value
	 * =" select count(bast.beneficiary_id) as value , 'On-Art' as name " +
	 * " from soch.beneficiary_art_status_tracking bast " +
	 * " join soch.master_beneficiary_activity_status mbas on mbas.id = bast.art_beneficiary_status_id "
	 * + " join soch.beneficiary b on b.id = bast.beneficiary_id " +
	 * " join soch.ti_beneficiary tb on tb.beneficiary_id = b.id " +
	 * " where mbas.name = 'On-ART' and to_char(bast.created_time,'YYYY')=to_char(now(),'YYYY') "
	 * +
	 * " and bast.facility_id =:facilityId and tb.typology IN :typology and b.gender IN :gender group by 2 "
	 * ) List<StatisticsProjection>
	 * getOnArtByGenderAndTypology(@Param("facilityId") Long
	 * facilityId, @Param("gender") List<String> gender,
	 * 
	 * @Param("typology") List<String> typology);
	 */

	/*
	 * @Query(nativeQuery=true , value
	 * =" select count(bast.beneficiary_id) as value , 'On-Art' as name " +
	 * " from soch.beneficiary_art_status_tracking bast " +
	 * " join soch.master_beneficiary_activity_status mbas on mbas.id = bast.art_beneficiary_status_id "
	 * + " join soch.beneficiary b on b.id = bast.beneficiary_id " +
	 * " join soch.ti_beneficiary tb on tb.beneficiary_id = b.id " +
	 * " where mbas.name = 'On-ART' and to_char(bast.created_time,'YYYY')=to_char(now(),'YYYY') "
	 * +
	 * " and bast.facility_id =:facilityId  and b.gender IN :gender group by 2 "
	 * ) List<StatisticsProjection> getOnArtByGender(@Param("facilityId") Long
	 * facilityId, @Param("gender") List<String> gender);
	 */

	/*
	 * @Query(nativeQuery=true , value
	 * =" select count(bast.beneficiary_id) as value , 'On-Art' as name " +
	 * " from soch.beneficiary_art_status_tracking bast " +
	 * " join soch.master_beneficiary_activity_status mbas on mbas.id = bast.art_beneficiary_status_id "
	 * + " join soch.beneficiary b on b.id = bast.beneficiary_id " +
	 * " join soch.ti_beneficiary tb on tb.beneficiary_id = b.id " +
	 * " where mbas.name = 'On-ART' and to_char(bast.created_time,'YYYY')=to_char(now(),'YYYY') "
	 * +
	 * " and bast.facility_id =:facilityId  and tb.typology IN :typology  group by 2 "
	 * ) List<StatisticsProjection> getOnArtByTypology(@Param("facilityId") Long
	 * facilityId, @Param("typology") List<String> typology);
	 */

	/*
	 * @Query(nativeQuery=true , value =
	 * "select count(tbed.beneficiary_id) as value, 'Not-linked' as name " +
	 * " from soch.ti_ben_ext_Details tbed join soch.ti_beneficiary tb on tb.id = tbed.beneficiary_id "
	 * +
	 * " join soch.beneficiary b on b.id = tb.beneficiary_id where tbed.facility_id =:facilityId "
	 * + " and b.gender IN :gender and tb.typology IN :typology " +
	 * " and tbed.hiv_art_linked=false and to_char(tbed.created_time,'YYYY')=to_char(now(),'YYYY') "
	 * ) List<StatisticsProjection>
	 * getNotLinkedByGenderAndTypology(@Param("facilityId") Long
	 * facilityId, @Param("gender") List<String> gender,
	 * 
	 * @Param("typology") List<String> typology);
	 */

	/*
	 * @Query(nativeQuery=true , value =
	 * "select count(tbed.beneficiary_id) as value, 'Not-linked' as name " +
	 * " from soch.ti_ben_ext_Details tbed join soch.ti_beneficiary tb on tb.id = tbed.beneficiary_id "
	 * +
	 * " join soch.beneficiary b on b.id = tb.beneficiary_id where tbed.facility_id =:facilityId "
	 * + " and b.gender IN :gender " +
	 * " and tbed.hiv_art_linked=false and to_char(tbed.created_time,'YYYY')=to_char(now(),'YYYY') "
	 * ) List<StatisticsProjection> getNotLinkedByGender(@Param("facilityId")
	 * Long facilityId, @Param("gender") List<String> gender);
	 */

	/*
	 * @Query(nativeQuery=true , value =
	 * "select count(tbed.beneficiary_id) as value, 'Not-linked' as name " +
	 * " from soch.ti_ben_ext_Details tbed join soch.ti_beneficiary tb on tb.id = tbed.beneficiary_id "
	 * +
	 * " join soch.beneficiary b on b.id = tb.beneficiary_id where tbed.facility_id =:facilityId "
	 * + "  and tb.typology IN :typology " +
	 * " and tbed.hiv_art_linked=false and to_char(tbed.created_time,'YYYY')=to_char(now(),'YYYY') "
	 * ) List<StatisticsProjection> getNotLinkedByTypology(@Param("facilityId")
	 * Long facilityId, @Param("typology") List<String> typology);
	 */

	@Query(nativeQuery = true, value = " select  b.uid as uid, concat(b.first_name,' ', b.middle_name,' ', b.last_name) as benficiaryName, "
			+ " b.pre_art_number as preArtNumber, b.mobile_number as mobileNumber,"
			+ " b.art_number as artNumber, b.age as age, ab.beneficiary_id as beneficiaryId , ab.facility_id as facilityId ,"
			+ " mabs.id as artBeneficiaryStatusId , mabs.name as artBeneficiaryStatusName,"
			+ " mg.id as genderId , mg.name as genderName" + " from soch.beneficiary as b"
			+ " join soch.art_beneficiary as ab on ab.beneficiary_id=b.id"
			+ " left join soch.master_art_beneficiary_status as mabs on mabs.id= ab.art_beneficiary_status_id"
			+ " left join soch.master_gender as mg on mg.id = b.gender_id"
			+ " where ab.facility_id = :facilityId and ab.is_active = true and ab.is_delete =false and b.is_active = true"
			+ " and b.is_delete = false and (lower(b.uid) like %:searchText%  or lower(b.first_name) like %:searchText% or lower(b.middle_name) like %:searchText% "
			+ " or lower(concat(b.first_name,' ',b.middle_name,' ',b.last_name)) like %:searchText% "
			+ "	or lower(b.last_name) like %:searchText% or lower(b.mobile_number) like %:searchText% or lower(b.pre_art_number) like %:searchText% or lower(b.art_number) like %:searchText%) ")
	List<ArtFollowupListProjection> findAllFollowUpList(@Param("facilityId") Long facilityId,
			@Param("searchText") String searchText);

	@Query(nativeQuery = true, value = " select  b.uid as uid, concat(b.first_name,' ', b.middle_name,' ', b.last_name) as benficiaryName, "
			+ " b.pre_art_number as preArtNumber, b.mobile_number as mobileNumber,"
			+ " b.art_number as artNumber, b.age as age, ab.beneficiary_id as beneficiaryId , ab.facility_id as facilityId ,"
			+ " mabs.id as artBeneficiaryStatusId , mabs.name as artBeneficiaryStatusName,"
			+ " mg.id as genderId , mg.name as genderName" + " from soch.beneficiary as b"
			+ " join soch.art_beneficiary as ab on ab.beneficiary_id=b.id"
			+ " left join soch.master_art_beneficiary_status as mabs on mabs.id= ab.art_beneficiary_status_id"
			+ " left join soch.master_gender as mg on mg.id = b.gender_id"
			+ " where  ab.facility_id = :facilityId and ab.is_active = true and ab.is_delete =false and b.is_active = true"
			+ " and b.is_delete = false and  b.id=:beneficiaryId")
	ArtFollowupListProjection findFollowUpLisByBeneficairyId(@Param("facilityId") Long facilityId,
			@Param("beneficiaryId") Long beneficiaryId);

	/*
	 * List<Beneficiary> findAllFollowUpList(@Param("artBeneficiaryStatusIds")
	 * List<Long> artBeneficiaryStatusIds,
	 * 
	 * @Param("adherenceValue") Integer adherenceValue, @Param("cD4belowValue")
	 * Integer cD4belowValue,
	 * 
	 * @Param("vLaboveValue") Integer vLaboveValue);
	 */

	// Beneficairy linked - HIV
	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.date_of_screening),'MONTH') AS name,  "
			+ "			 COUNT(distinct sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti  "
			+ "			 join soch.ti_beneficiary tcb on tcb.id = sti.beneficiary_id  "
			+ "			 join soch.beneficiary bn on bn.id = tcb.beneficiary_id  "
			+ "			 join soch.master_infection_type mit on mit.id = sti.infection_id  "
			+ "			 join soch.master_hiv_screening_status mhss on mhss.id = sti.screening_status_hiv_id "
			+ "          inner join soch.beneficiary_referral br  " + "			 on br.beneficiary_id  = bn.id  "
			+ "			 inner join soch.master_referral_status mrs on mrs.id = br.referral_status_id  "
			+ "			 inner join soch.facility f on br.refered_to  = f.id  "
			+ "		 	WHERE tcb.facility_id=:facilityId and mit.id =1  and mhss.id=1 and mrs.id = 3 and f.facility_type_id  = 11 "
			+ "		 	and to_char(sti.date_of_screening,'YYYY')=to_char(now(),'YYYY') "
			+ "  and tcb.master_hrg_primary_id IN :typology and bn.gender_id IN :gender GROUP BY 1")
	List<StatisticsProjection> getMonthwiseHivLinkedByGenderAndTypology(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	// Beneficairy linked - HIV
	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.date_of_screening),'MONTH') AS name,  "
			+ "			 COUNT(distinct sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti  "
			+ "			 join soch.ti_beneficiary tcb on tcb.id = sti.beneficiary_id  "
			+ "			 join soch.beneficiary bn on bn.id = tcb.beneficiary_id  "
			+ "			 join soch.master_infection_type mit on mit.id = sti.infection_id  "
			+ "			 join soch.master_hiv_screening_status mhss on mhss.id = sti.screening_status_hiv_id "
			+ "          inner join soch.beneficiary_referral br  " + "			 on br.beneficiary_id  = bn.id  "
			+ "			 inner join soch.master_referral_status mrs on mrs.id = br.referral_status_id  "
			+ "			 inner join soch.facility f on br.refered_to  = f.id  "
			+ "		 	WHERE tcb.facility_id=:facilityId and mit.id =1  and mhss.id=1 and mrs.id = 3 and f.facility_type_id  = 11 "
			+ "		 	and to_char(sti.date_of_screening,'YYYY')=to_char(now(),'YYYY') "
			+ "  and bn.gender_id IN :gender GROUP BY 1")
	List<StatisticsProjection> getMonthwiseHivLinkedByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

	// Beneficairy linked - HIV
	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.date_of_screening),'MONTH') AS name,  "
			+ "			 COUNT(distinct sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti  "
			+ "			 join soch.ti_beneficiary tcb on tcb.id = sti.beneficiary_id  "
			+ "			 join soch.beneficiary bn on bn.id = tcb.beneficiary_id  "
			+ "			 join soch.master_infection_type mit on mit.id = sti.infection_id  "
			+ "			 join soch.master_hiv_screening_status mhss on mhss.id = sti.screening_status_hiv_id "
			+ "          inner join soch.beneficiary_referral br  " + "			 on br.beneficiary_id  = bn.id  "
			+ "			 inner join soch.master_referral_status mrs on mrs.id = br.referral_status_id  "
			+ "			 inner join soch.facility f on br.refered_to  = f.id  "
			+ "		 	WHERE tcb.facility_id=:facilityId and mit.id =1  and mhss.id=1 and mrs.id = 3 and f.facility_type_id  = 11 "
			+ "		 	and to_char(sti.date_of_screening,'YYYY')=to_char(now(),'YYYY') "
			+ "  and tcb.master_hrg_primary_id IN :typology GROUP BY 1")
	List<StatisticsProjection> getMonthwiseHivLinkedByTypology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select mabs.name as name , count(distinct tb.beneficiary_id) as value from ti_beneficiary tb inner join beneficiary b on b.id = tb.beneficiary_id " +
			"		inner join art_beneficiary ab on ab.beneficiary_id = tb.beneficiary_id inner join master_art_beneficiary_status mabs on mabs.id = ab.art_beneficiary_status_id " +
			"		and b.hiv_status_id = 2 and tb.facility_id = :facilityId group by mabs.name union select 'Not Linked' as name , count( tb.beneficiary_id) " +
			"		from ti_beneficiary tb inner join beneficiary b on b.id = tb.beneficiary_id where " +
			"		not exists( select 1 from art_beneficiary ab where ab.beneficiary_id=b.id and is_active = true and is_delete = false) " +
			"		and b.hiv_status_id = 2 and tb.facility_id = :facilityId")
	List<StatisticsProjection> getArtBeneficiaryStatusFromTI(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select mabs.name as name ,count(distinct tb.beneficiary_id) as value from ti_beneficiary tb inner join beneficiary b "
			+ "		 on b.id =tb.beneficiary_id inner join art_beneficiary ab on ab.beneficiary_id = tb.beneficiary_id "
			+ "		 inner join master_art_beneficiary_status mabs on mabs.id = ab.art_beneficiary_status_id and b.hiv_status_id = 2 "
			+ "		 and tb.facility_id = :facilityId and tb.master_hrg_primary_id IN :typology group by mabs.name "
			+ "		 union "
			+ "		 select 'Not Linked' as name , count(distinct tb.beneficiary_id) from ti_beneficiary tb inner join beneficiary b "
			+ "		 on b.id =tb.beneficiary_id "
			+ "		 where b.id not in(select distinct beneficiary_id from art_beneficiary where is_active=true and is_delete=false) "
			+ "		 and b.hiv_status_id = 2  and tb.master_hrg_primary_id IN :typology and tb.facility_id = :facilityId")
	List<StatisticsProjection> getArtBeneficiaryStatusFromTIByTypology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select mabs.name as name ,count(distinct tb.beneficiary_id) as value from ti_beneficiary tb inner join beneficiary b "
			+ "		 on b.id =tb.beneficiary_id inner join art_beneficiary ab on ab.beneficiary_id = tb.beneficiary_id "
			+ "		 inner join master_art_beneficiary_status mabs on mabs.id = ab.art_beneficiary_status_id and b.hiv_status_id = 2 "
			+ "		 and tb.facility_id = :facilityId and b.gender_id IN :gender group by mabs.name " + "		 union "
			+ "		 select 'Not Linked' as name , count(distinct tb.beneficiary_id) from ti_beneficiary tb inner join beneficiary b "
			+ "		 on b.id =tb.beneficiary_id "
			+ "		 where b.id not in(select distinct beneficiary_id from art_beneficiary where is_active=true and is_delete=false) "
			+ "		 and b.hiv_status_id = 2 and b.gender_id IN :gender and tb.facility_id = :facilityId")
	List<StatisticsProjection> getArtBeneficiaryStatusFromTIByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

	@Query(nativeQuery = true, value = "select mabs.name as name ,count(distinct tb.beneficiary_id) as value from ti_beneficiary tb inner join beneficiary b "
			+ "		 on b.id =tb.beneficiary_id inner join art_beneficiary ab on ab.beneficiary_id = tb.beneficiary_id "
			+ "		 inner join master_art_beneficiary_status mabs on mabs.id = ab.art_beneficiary_status_id and b.hiv_status_id = 2 "
			+ "		 and tb.facility_id = :facilityId and tb.master_hrg_primary_id IN :typology and b.gender_id IN :gender group by mabs.name "
			+ "		 union "
			+ "		 select 'Not Linked' as name , count(distinct tb.beneficiary_id) from ti_beneficiary tb inner join beneficiary b "
			+ "		 on b.id =tb.beneficiary_id "
			+ "		 where b.id not in(select distinct beneficiary_id from art_beneficiary where is_active=true and is_delete=false) "
			+ "		 and b.hiv_status_id = 2 and tb.master_hrg_primary_id IN :typology and b.gender_id IN :gender and tb.facility_id = :facilityId")
	List<StatisticsProjection> getArtBeneficiaryStatusFromTIByGenderAndTypology(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select ((select abs(coalesce(sum(quantity)/3,0)) from soch.facility_stock_tracking fst \n"
			+ "inner join soch.product p on fst.product_id = p.id \n"
			+ "where fst.facility_id =:facilityId and p.product_short_code in('NLC', 'LC')\n"
			+ "and fst.type_id =18 and fst.transaction_date >= date_trunc('month', now())- interval '3 month'\n"
			+ "and fst.transaction_date < now())\n" + "+\n"
			+ "(select coalesce (sum(sd.adjust_stock_quantity)/3,0) from soch.facility_stock_adjustment sd\n"
			+ "inner join soch.facility f on f.id = sd.facility_id\n"
			+ "inner join soch.product p on p.id = sd.product_id\n"
			+ "where sd.date_of_addition_or_consupmtion >= date_trunc('month', now())- interval '3 month'\n"
			+ "and sd.date_of_addition_or_consupmtion < now()\n"
			+ "and f.id  =:facilityId and p.product_short_code in('NLC', 'LC')))/2 as AverageCount,\n"
			+ "(select sum(fas.available_quantity) as TotalQuantity from (select product_id, facility_id, git,damaged_quantity,case\n"
			+ "when date(batch_expiry_date) <date(now()) then 0 else available_quantity\n"
			+ "end as available_quantity,case\n"
			+ "when date(batch_expiry_date) < date(now()) then available_quantity else 0\n"
			+ "end as expired_quantity from soch.facility_aggregate_stock\n"
			+ "where facility_id = :facilityId ) as fas\n" + "join soch.product as p on\n" + "p.id = fas.product_id\n"
			+ "where p.product_short_code in('NLC', 'LC')) as TotalQuantity")
	InventoryProjection getCondomInventoryDetails(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select ((select abs(coalesce(sum(quantity)/3,0)) from soch.facility_stock_tracking fst\r\n"
			+ "inner join soch.product p on fst.product_id = p.id\r\n"
			+ "where fst.facility_id =:facilityId and p.product_short_code = 'WBFinger'\r\n"
			+ "and fst.type_id =18 and fst.transaction_date >=  now()- interval '3 month' and fst.transaction_date <  now()) \r\n"
			+ "+ (select coalesce (sum(sd.adjust_stock_quantity)/3,0) from soch.facility_stock_adjustment sd \r\n"
			+ "inner join soch.facility f on f.id = sd.facility_id \r\n"
			+ "inner join soch.product p on p.id = sd.product_id\r\n"
			+ "where sd.date_of_addition_or_consupmtion >=  now() - interval '3 month'\r\n"
			+ "and sd.date_of_addition_or_consupmtion <  now()\r\n"
			+ "and f.id  =:facilityId and p.product_short_code ='WBFinger'))/2 as AverageCount,\r\n"
			+ "(select sum(fas.available_quantity) as TotalQuantity from\r\n"
			+ "(select product_id, facility_id, git,damaged_quantity,case\r\n"
			+ "when date(batch_expiry_date) <date(now()) then 0 else available_quantity\r\n"
			+ "end as available_quantity,case\r\n"
			+ "when date(batch_expiry_date) < date(now()) then available_quantity else 0\r\n"
			+ "end as expired_quantity from soch.facility_aggregate_stock\r\n"
			+ "where facility_id = :facilityId ) as fas\r\n" + "join soch.product as p on \r\n"
			+ "p.id = fas.product_id  \r\n" + "where p.product_short_code = 'WBFinger') as TotalQuantity")
	InventoryProjection getHivInventoryDetails(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select ((select abs(coalesce(sum(quantity)/3,0)) from soch.facility_stock_tracking fst \r\n"
			+ "inner join soch.product p on fst.product_id = p.id \r\n"
			+ "where fst.facility_id =:facilityId and p.product_short_code ='Needles'\r\n"
			+ "and fst.type_id =18 and fst.transaction_date >= date_trunc('month', now())- interval '3 month'\r\n"
			+ "and fst.transaction_date < now())\r\n" + "+\r\n"
			+ "(select coalesce (sum(sd.adjust_stock_quantity)/3,0) from soch.facility_stock_adjustment sd\r\n"
			+ "inner join soch.facility f on f.id = sd.facility_id\r\n"
			+ "inner join soch.product p on p.id = sd.product_id\r\n"
			+ "where sd.date_of_addition_or_consupmtion >= date_trunc('month', now())- interval '3 month'\r\n"
			+ "and sd.date_of_addition_or_consupmtion <  now()\r\n"
			+ "and f.id  =:facilityId and p.product_short_code = 'Needles'))/2 as AverageCount,\r\n"
			+ "(select sum(fas.available_quantity) as TotalQuantity from (select product_id, facility_id, git,damaged_quantity,case\r\n"
			+ "when date(batch_expiry_date) <date(now()) then 0 else available_quantity\r\n"
			+ "end as available_quantity,case\r\n"
			+ "when date(batch_expiry_date) < date(now()) then available_quantity else 0\r\n"
			+ "end as expired_quantity from soch.facility_aggregate_stock\r\n"
			+ "where facility_id = :facilityId ) as fas\r\n" + "join soch.product as p on\r\n"
			+ "p.id = fas.product_id\r\n" + "where p.product_short_code ='Needles') as TotalQuantity")
	InventoryProjection getNeedleInventoryDetails(@Param("facilityId") Long facilityId);

	@Modifying
	@Transactional
	@Query("update Beneficiary b set b.isDelete = true , b.isActive = false where b.id = :beneficiaryId")
	void deleteBeneficiary(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = " select ab.beneficiary_id as beneficiaryId , ab.facility_id as facilityId ,"
			+ " ab.art_beneficiary_status_id as artBeneficiaryStatusId " + " from soch.beneficiary as bf "
			+ " join soch.art_beneficiary as ab on ab.beneficiary_id=bf.id "
			+ " where ab.is_active = true and ab.is_delete =false and bf.is_active = true "
			+ " and bf.is_delete = false and bf.id IN (:followupBeneficiaryIds)")
	List<ArtFollowupListProjection> findBeneficiaryByIds(
			@Param("followupBeneficiaryIds") Set<Long> followupBeneficiaryIds);

	@Query(nativeQuery = true, value = "select b.pre_art_number as preArtNumber,b.art_number as artNumber from soch.beneficiary as b "
			+ "	join soch.art_beneficiary as ab on ab.beneficiary_id = b.id "
			+ "	where ab.facility_id = :facilityId and b.is_delete = false and b.is_active = true")
	List<ArtBeneficiaryRegistrationProjection> findPreArtAndArtNumbers(@Param("facilityId") Long facilityId);

	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = " update soch.beneficiary "
			+ " set guardian_caregiver_highest_education_id=:guardianHighestEducationId, date_of_birth=:age, "
			+ " gender_id=:sexId,staying_with_id=:stayingWithId,staying_with_others=:stayingWithOthers,guardian_caregiver_id=:guardianCaregiverId, "
			+ " guardian_caregiver_others=:guardianCaregiverOthers,birth_history_id=:birthHistoryId,birth_weight=:birthWeight,neo_natal_complications=:neonatalComplications, "
			+ " paediatric_other_vaccines=:otherVaccines where id=:beneficiaryId ")
	void updatePediatricBeneficiaryDetailsById(@Param("beneficiaryId") Long beneficiaryId,
			@Param("guardianHighestEducationId") Long guardianHighestEducationId, @Param("age") LocalDate age,
			@Param("sexId") Long sexId, @Param("stayingWithId") Long stayingWithId,
			@Param("stayingWithOthers") String stayingWithOthers,
			@Param("guardianCaregiverId") Long guardianCaregiverId,
			@Param("guardianCaregiverOthers") String guardianCaregiverOthers,
			@Param("birthHistoryId") Long birthHistoryId, @Param("birthWeight") Long birthWeight,
			@Param("neonatalComplications") String neonatalComplications, @Param("otherVaccines") String otherVaccines);

	/*
	 * @Query(nativeQuery=true,
	 * value=" select gender_id as genderId,date_of_birth as dateOfBirth," +
	 * " guardian_caregiver_highest_education_id as guardianCaregiverHighestEducationId,"
	 * +
	 * " guardian_caregiver_id as guardianCaregiverId, staying_with_id as stayingWithId,"
	 * +
	 * " guardian_caregiver_others as guardianCaregiverOthers, staying_with_others as stayingWithOthers,"
	 * +
	 * " birth_history_id as birthHistoryId,birth_weight as birthWeight, neo_natal_complications as neoNatalComplications,"
	 * + " paediatric_other_vaccines as paediatricOtherVaccines" +
	 * " from soch.beneficiary where id=:beneficiaryId")
	 * PediatricBeneficiaryProjection
	 * findPediatricBeneficiaryDetailsById(@Param("beneficiaryId") Long
	 * beneficiaryId);
	 */
	@Query(nativeQuery = true, value = "select concat(b.first_name,' ',b.middle_name,' ',b.last_name) as pediatricBeneficiaryName,mbc.name as categoryName, "
			+ " b.mobile_number as mobileNumber, b.alternate_phonenumber as alternatePhoneNumber, ma.address_line_one as addressLineOne,  "
			+ " ma.address_line_two as addressLineTwo,st.id as stateId, st.name as stateName, "
			+ " dt.id as districtId,dt.name as districtName, sb.subdistrict_id as subdistrictId, sb.subdistrict_name as subdistrictName, "
			+ " tn.town_id as townId,tn.town_name as townName, pc.id as pincodeId, pc.pincode as pincodeName, "
			+ " g.id as genderId,g.name as genderName,b.date_of_birth as dateOfBirth, "
			+ " b.guardian_caregiver_highest_education_id as guardianCaregiverHighestEducationId, "
			+ " b.guardian_caregiver_id as guardianCaregiverId, b.staying_with_id as stayingWithId, "
			+ " b.guardian_caregiver_others as guardianCaregiverOthers, b.staying_with_others as stayingWithOthers, "
			+ " b.birth_history_id as birthHistoryId,b.birth_weight as birthWeight, b.neo_natal_complications as neoNatalComplications, b.guardian_date_of_birth as guardianDateOfBirth, "
			+ " b.paediatric_other_vaccines as paediatricOtherVaccines " + " from soch.beneficiary b  "
			+ " left join soch.master_gender as g on g.id = b.gender_id "
			+ " left join soch.master_beneficiary_category as mbc on mbc.id = b.category_id "
			+ " left join soch.address as ma on ma.id= b.address_id "
			+ " left join soch.state as st on st.id = ma.state_id "
			+ " left join soch.district as dt on dt.id = ma.district_id "
			+ " left join soch.subdistrict as sb on sb.subdistrict_id=ma.subdistrict_id "
			+ " left join soch.town as tn on tn.town_id=ma.town_id "
			+ " left join soch.pincode as pc on pc.id = ma.pincode_id " + " where b.id=:beneficiaryId")
	PediatricBeneficiaryProjection findPediatricBeneficiaryDetailsById(@Param("beneficiaryId") Long beneficiaryId);

	@Query(value = "select concat(b.first_name,' ',b.middle_name,' ',b.last_name) as beneficiaryName , g.id as genderId , b.art_number as artNumber , b.pre_art_number as preArtNumber, b.age as age , b.date_of_birth as dateOfBirth, bvr.visit_date as visitedDate,bvr.id as visitRegisterId, g.name as gender from soch.beneficiary as b "
			+ "left join soch.beneficiary_visit_register as bvr on bvr.beneficiary_id = b.id "
			+ "left join soch.master_gender as g on g.id = b.gender_id "
			+ "where b.id=:beneficiaryid order by  bvr.id desc limit 1", nativeQuery = true)
	CounsellingNoteBasicBeneficiaryDetailsProjection findCounsellingBeneficiaryDetailsById(
			@Param("beneficiaryid") Long beneficiaryid);

	@Query(nativeQuery = true, value = "select concat(b.first_name, ' ', b.middle_name,'',b.last_name) as beneficiaryName, b.date_of_birth as dateOfBirth, g.id as genderId,g.name as genderName, \r\n"
			+ "			b.pre_art_number as preArtNumber,b.art_number as artNumber, b.uid as uid ,cd.regimen_id as regimenId,cd.other_clinical_notes as otherClinicalNotes, \r\n"
			+ "			ab.art_beneficiary_status_id as artBeneficiaryStatusId,bvr.visit_date as lastVisitDate,\r\n"
			+ "			bvr.height as previousHeight,bvr.is_pregnant as isPregnant, bvr.weight as previousWeight,bf.clinical_stage_id as previousWHOClinicalStageId,\r\n"
			+ "			bf.functional_status_id as previousFunctionalStatusId,bf.tb_treatment as tBTreatment \r\n"
			+ "			from soch.beneficiary b left join soch.master_gender as g on g.id = b.gender_id \r\n"
			+ "			left join soch.art_beneficiary_clinical_details as cd on cd.beneficiary_id =b.id \r\n"
			+ "			join soch.art_beneficiary as ab on ab.beneficiary_id =b.id \r\n"
			+ "			left join soch.beneficiary_visit_register as bvr on bvr.beneficiary_id=b.id \r\n"
			+ "			left join soch.art_beneficiary_followup as bf on bf.beneficiary_id=b.id\r\n"
			+ "           where b.id =:beneficiaryId order by bvr.id desc,cd.id desc,bf.id desc limit 1")
	ArtBeneficiaryMiniProfileProjection findArtBeneficiaryMiniProfileDetailsById(
			@Param("beneficiaryId") Long beneficiaryId);

	@Modifying
	@Transactional
	@Query(value = "update soch.beneficiary as b "
			+ "set tsv_artvalues = to_tsvector(coalesce(first_name, '') || ' ' || coalesce(middle_name, '') || ' ' || coalesce(last_name, '') || ' ' || coalesce(uid, '') || ' ' || coalesce(mobile_number, '') || ' ' || coalesce(pre_art_number, '') || ' ' || coalesce(art_number, '')) "
			+ "where b.id =:beneficiaryId and ( first_name is not null  or middle_name is not null "
			+ " or last_name is not null   or uid is not null "
			+ " or mobile_number is not null   or pre_art_number is not null "
			+ "or art_number is not null )", nativeQuery = true)
	int updateTsArtValues(@Param("beneficiaryId") Long beneficiaryId);

	/*@Modifying
	@Transactional
	@Query(value = "UPDATE soch.beneficiary b\r\n" + "SET art_benf_search_str =\r\n"
			+ "b.uid || ' ' || TRIM(coalesce(b.first_name, '')) || ' ' || TRIM(coalesce(b.middle_name, '')) || ' ' || TRIM(coalesce(b.last_name, '')) || ' ' || TRIM(coalesce(b.pre_art_number, '')) || ' ' || TRIM(coalesce(b.art_number, ''))\r\n"
			+ "WHERE\r\n" + "b.id =:beneficiaryId", nativeQuery = true)*/
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "UPDATE soch.beneficiary as b SET art_benf_search_str = trim(regexp_replace(b.uid || ' ' || TRIM(coalesce(b.first_name, '')) || ' ' || TRIM(coalesce(b.middle_name, '')) || ' ' || " 
			+ " TRIM(coalesce(b.last_name, '')) || ' ' || TRIM(coalesce(b.pre_art_number, '')) || ' ' || TRIM(coalesce(b.art_number, '')),'\\s+', ' ', 'g'))"  
			+ " WHERE b.id =:beneficiaryId")
	int updateArtBeneficiarySearchString(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select b.uid, b.id, b.first_name as firstName,b.middle_name as middleName,b.last_name as lastName,"
			+ "b.mobile_number as mobileNumber, b.alternate_phonenumber as alternatePhonenumber,b.date_of_birth as dateOfBirth,"
			+ "b.death_date as deathDate,b.death_reason as deathReason,b.pre_art_number as preArtNumber, b.art_number as artNumber,"
			+ "b.caregiver_name as CaregiverName, b.caregiver_phone_number as caregiverPhoneNumber,b.bank_account_name as bankAccountName, "
			+ "b.bank_account_number as bankAccountNumber, b.bank_ifsc as bankIfsc,b.close_person_name as closePersonName,"
			+ "b.is_living_in_rel as isLivingInRelationship,b.close_person_relation_type as masterRelationType,b.hiv_type_id as hivTypeId,mht.name as hivTypeName,"
			+ "b.hiv_status_id as hivStatusId,b.gender_id as genderId, g.name as genderName,b.education_level_id as educationLevelId,"
			+ "b.marital_status_id as maritalStatusId,b.occupation_id as occupationId,b.monthly_income as monthlyIncomeId,b.category_id as categoryId,"
			+ "mbc.name as categoryName,ma.address_line_one as addressLineOne,ma.address_line_two as addressLineTwo,st.id as stateId,"
			+ "dt.id as districtId,dt.name as districtName, sb.subdistrict_id as subdistrictId, sb.subdistrict_name as subdistrictName,"
			+ "tn.town_id as townId,tn.town_name as townName, pc.id as pincodeId, pc.pincode as pincodeName, b.staying_with_id as stayingWithId,"
			+ "b.caregiver_address_id as caregiverAddressId,b.age as age,b.aadhar_number as aadharNumber,"
			+ "b.regular_partners as regularPartners,b.ti_code as tiCode, b.ost_code as ostCode, b.reg_date as regDate,"
			+ "ab.is_active as isActive,ab.is_transit as isTransit,ab.transit_end_date as transitEndDate,ab.transit_start_date as transitStartDate,"
			+ "ab.lac_linked as lacLinked,ab.consent_taken as isConsentTaken,ab.art_registration_date as artRegistrationDate,ab.art_start_date as artStartDate,"
			+ "ab.registration_treatment_status as masterArtTreatmentStatus,ab.art_beneficiary_status_id as masterArtBeneficiaryStatus,"
			+ "ab.art_transferred_from as masterBeneficiaryArtTransferredFrom,ab.entry_point_id as entryPointId, "
			+ "ab.hiv_risk_factor_id as masterRiskFactor,ib.id as ictcId, ib.pid as pid,f.name as ictcFacilityName,itr.tested_date as testedDate, "
			+ "tr.destination_facility_id as facilityTo,tr.transfer_status as transferStatus,lfb.linked_facility_id as linkedFacilityId, "
			+ "bfm.art_previous_clinic as artPreviousClinic ,bfm.mapping_date as mappingDate, "
			+ "bfm.previous_not_transferred_art_id as previousNotTransferredArtId,pf.name as previousArtCenterName,ab.art_eligibility_date as artEligibilityDate,"
			+ "mp.name as entryPointName,mrf.name as riskFactorName,ab.linkage_institute_name as linkageInstituteName,"
			+ "ab.linkage_organisation_type_id as masterOrganisationType,brs.id as refferalStatusId,"
			+ "mrs.name as refferalStatusName,brs.refered_from as ictcReferedFrom,af.state_id as transferStateId, af.district_id as transferDistrictId ,"
			+ "bcd.treatment_line_id as masterTreatmentLine , mtl.name as treatmentLine ,ab.multi_month_dispensation_id as masterMultimonthDispensation ,"
			+ "mmd.name as multimonthDispensation,b.infant_eid_code as infantEidCode,ca.address_line_one as caregiverAddressLineOne,ca.address_line_two as caregiverAddressLineTwo, " 
			+ "ca.state_id as caregiverStateId,ca.district_id as caregiverDistrictId,ca.subdistrict_id as caregiverSubdistrictId,ca.town_id as caregiverTownId,ca.pincode as caregiverPincode, " 
			+ "aa.address_line_one as alternateAddressLineOne,aa.address_line_two as alternateAddressLineTwo,aa.state_id as alternateStateId,aa.district_id as alternateDistrictId,aa.subdistrict_id as alternateSubdistrictId, " 
			+ "aa.town_id as alternateTownId,aa.pincode as alternatePincode,ab.infant_registered_through_eid as infantRegisteredThroughEid ,bpt.transfer_to_private_facility_name as privateFacility ,lfb.is_linked as isLinked from soch.beneficiary b "
			+ "left join soch.master_gender as g on g.id = b.gender_id "
			+ "left join soch.master_beneficiary_category as mbc on mbc.id = b.category_id "
			+ "left join soch.address as ma on ma.id= b.address_id  "
			+ "left join soch.state as st on st.id = ma.state_id  "
			+ "left join soch.district as dt on dt.id = ma.district_id "
			+ "left join soch.subdistrict as sb on sb.subdistrict_id=ma.subdistrict_id "
			+ "left join soch.town as tn on tn.town_id=ma.town_id "
			+ "left join soch.pincode as pc on pc.id = ma.pincode_id "
			+ "left join soch.art_beneficiary as ab on ab.beneficiary_id =b.id "
			+ "left join soch.master_entry_point as mp on mp.id = ab.entry_point_id "
			+ "left join soch.master_risk_factor as mrf on mrf.id= ab.hiv_risk_factor_id "
			+ "left join soch.master_hiv_type as mht on mht.id =b.hiv_type_id "
			+ "left join soch.ictc_beneficiary as ib on ib.beneficiary_id =b.id "
			+ "left join soch.facility as f on f.id =ib.facility_id "
			+ "left join soch.ictc_test_result as itr on ib.id = itr.ictc_beneficiary_id "
			+ "left join soch.transfers as tr on tr.beneficiary_id =b.id and tr.is_deleted=false and tr.is_active=true and tr.source_facility_id=:facilityId "
			+ "left join soch.beneficiary_private_transfers as bpt on bpt.beneficiary_id =b.id "
			+ "left join soch.facility as tf on  tf.id = tr.destination_facility_id "
			+ "left join soch.address as af on af.id = tf.address_id "
			+ "left join soch.facility_linked_facility_beneficiary as lfb on lfb.beneficiary_id =b.id "
			+ "left join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id =b.id and bfm.previous_not_transferred_art_id is not null "
			+ "left join soch.facility pf on bfm.previous_not_transferred_art_id=pf.id "
			+ "left join soch.beneficiary_referral brs on brs.beneficiary_id =b.id "
			+ "left join soch.master_referral_status mrs on mrs.id =brs.referral_status_id "
			+ "left join soch.art_beneficiary_clinical_details as bcd on bcd.beneficiary_id =b.id "
			+ "left join soch.master_treatment_line as mtl on mtl.id = bcd.treatment_line_id "
			+ "left join soch.master_multi_month_dispensation as mmd on mmd.id = ab.multi_month_dispensation_id "
			+ "left join soch.address as ca on ca.id = b.caregiver_address_id left join soch.address as aa on aa.id = b.alternate_address_id "
			+ "where b.id =:beneficiaryId order by bcd.visit_register_id desc limit 1 ")
	ArtRegistrationProjection findArtBeneficaryRegistrationDetailsById(@Param("beneficiaryId") Long beneficiaryId, @Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select concat(b.first_name,' ',b.middle_name,' ',b.last_name) as beneficiaryName ,g.name as gender,b.date_of_birth as dateOfBirth,b.age as age, "
			+ "mbc.name as category,b.mobile_number as mobileNumber,concat(ma.address_line_one,' ',ma.address_line_two ,' ',st.name ,' ',pc.pincode) as address, "
			+ "st.name as stateName,dt.name as district,sb.subdistrict_name as subDistrict,tn.town_name as city,b.caregiver_name as caregiverName, "
			+ "b.caregiver_phone_number as caregiverContactNumber,b.caregiver_address_id as caregiverAddressId , mht.name as hivType,ab.art_registration_date as registrationDate,mas.name as registrationTreatmentStatus, "
			+ "ib.pid as beneficiaryPID ,b.occupation_id as occupationId,itr.tested_date as testedDate,flb.link_date as linkDate,flb.is_linked as linkedOut ,b.death_date as deathDate ,b.death_reason as deathReason ,"
			+ "f.name as facilityName ,f.code as facilityCode ,sa.name as facilityState ,tw.town_name as facilityCity,bfm.art_previous_clinic as previousClinic ,mat.name as transferredFrom , "
			+ "mel.name as beneficiaryEducation , ab.facility_id as facilityId , b.guardian_caregiver_highest_education_id as caregiverEducationId ,fl.name as lacName ,b.art_number as artNumber,b.uid as beneficiaryUID, "
			+ "mmi.name as monthlyIncome ,ab.art_beneficiary_status_id as beneficiaryStatus, mms.name as maritalStatus, mrf.name as riskFactor ,msw.name as caregiverRelation ,fy.name as testPlace "
			+ "from soch.beneficiary b " + "left join soch.master_gender as g on g.id = b.gender_id "
			+ "left join soch.master_beneficiary_category as mbc on mbc.id = b.category_id "
			+ "left join soch.address as ma on ma.id = b.address_id "
			+ "left join soch.state as st on st.id = ma.state_id "
			+ "left join soch.district as dt on dt.id = ma.district_id "
			+ "left join soch.subdistrict as sb on sb.subdistrict_id = ma.subdistrict_id "
			+ "left join soch.town as tn on tn.town_id = ma.town_id "
			+ "left join soch.pincode as pc on pc.id = ma.pincode_id "
			+ "left join soch.art_beneficiary as ab on ab.beneficiary_id = b.id "
			+ "left join soch.facility as f on f.id = ab.facility_id "
			+ "left join soch.master_hiv_type as mht on mht.id = b.hiv_type_id "
			+ "left join soch.beneficiary_facility_mapping as bfm on bfm.beneficiary_id  = b.id "
			+ "left join soch.address as ad on ad.id = f.address_id "
			+ "left join soch.state as sa on sa.id = ad.state_id "
			+ "left join soch.town as tw on tw.town_id = ad.town_id "
			+ "left join soch.facility_linked_facility_beneficiary as flb on flb.beneficiary_id = b.id "
			+ "left join soch.facility as fl on fl.id = flb.linked_facility_id "
			+ "left join soch.master_education_level as mel on mel.id = b.education_level_id "
			+ "left join soch.ictc_beneficiary as ib on ib.beneficiary_id = b.id  "
			+ "left join soch.lab_test_sample as itr on ib.id = itr.ictc_beneficiary_id "
			+ "left join soch.facility as fy on fy.id = ib.facility_id "
			+ "left join soch.ictc_details as icd on icd.beneficiary_id = b.id "
			+ "left join soch.master_beneficiary_art_transferred_from as mat on mat.id = ab.art_transferred_from "
			+ "left join soch.master_art_treatment_status as mas on mas.id = ab.registration_treatment_status "
			+ "left join soch.master_monthly_income as mmi on mmi.id = b.monthly_income "
			+ "left join soch.master_marital_status as mms on mms.id = b.marital_status_id "
			+ "left join soch.master_risk_factor as mrf on mrf.id = ab.hiv_risk_factor_id "
			+ "left join soch.master_staying_with as msw on msw.id = b.staying_with_id "
			+ "where b.id = :beneficiaryId order by ib.id desc limit 1")
	WhiteCardDetailsProjection findBeneficiaryDetailsByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId,b.uid as uid,b.first_name as firstName,b.middle_name as middleName,b.last_name as lastName,b.art_number as artNumber,bg.name as gender, "
			+ "b.date_of_birth as dateOfBirth,b.mobile_number as mobileNumber,f.name as facility,f.id as facilityId,ft.id as facilityTypeId, ft.facility_type_name as facilityType from soch.beneficiary b join soch.master_gender bg on "
			+ "bg.id = b.gender_id join (select MAX(id) as bfmid, beneficiary_id from soch.beneficiary_facility_mapping where facility_id =:facilityId group by beneficiary_id) as resultTable on "
			+ "resultTable.beneficiary_id = b.id join soch.beneficiary_facility_mapping as bfm on resultTable.beneficiary_id = bfm.beneficiary_id and resultTable.bfmid = bfm.id join soch.facility f on f.id = bfm.facility_id "
			+ "join soch.facility_type ft on ft.id = f.facility_type_id where b.is_delete = false and bfm.is_delete = false and b.mobile_number = :searchText order by b.modified_time desc")
	List<UidMergeProjection> getSearchInBeneficiariesByMobileNo(@Param("searchText") String searchText,
			@Param("facilityId") Integer facilityId);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId,b.uid as uid,b.first_name as firstName,b.middle_name as middleName,b.last_name as lastName,b.art_number as artNumber,bg.name as gender, "
			+ "b.date_of_birth as dateOfBirth,b.mobile_number as mobileNumber,f.name as facility,f.id as facilityId,ft.id as facilityTypeId,ft.facility_type_name as facilityType from soch.beneficiary b join soch.master_gender bg on "
			+ "bg.id = b.gender_id join (select MAX(id) as bfmid, beneficiary_id from soch.beneficiary_facility_mapping where facility_id =:facilityId group by beneficiary_id) as resultTable on "
			+ "resultTable.beneficiary_id = b.id join soch.beneficiary_facility_mapping as bfm on resultTable.beneficiary_id = bfm.beneficiary_id and resultTable.bfmid = bfm.id join soch.facility f on f.id = bfm.facility_id "
			+ "join soch.facility_type ft on ft.id = f.facility_type_id where b.is_delete = false and bfm.is_delete = false and b.uid ilike concat(:searchText, '%') order by b.modified_time desc ")
	List<UidMergeProjection> getSearchInBeneficiariesByUid(@Param("searchText") String searchText,
			@Param("facilityId") Integer facilityId);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId,b.uid as uid,b.first_name as firstName,b.middle_name as middleName,b.last_name as lastName,b.art_number as artNumber,bg.name as gender, "
			+ "b.date_of_birth as dateOfBirth,b.mobile_number as mobileNumber,f.name as facility,f.id as facilityId,ft.id as facilityTypeId,ft.facility_type_name as facilityType from soch.beneficiary b join soch.master_gender bg on "
			+ "bg.id = b.gender_id join (select MAX(id) as bfmid, beneficiary_id from soch.beneficiary_facility_mapping where facility_id =:facilityId group by beneficiary_id) as resultTable on "
			+ "resultTable.beneficiary_id = b.id join soch.beneficiary_facility_mapping as bfm on resultTable.beneficiary_id = bfm.beneficiary_id and resultTable.bfmid = bfm.id join soch.facility f on f.id = bfm.facility_id "
			+ "join soch.facility_type ft on ft.id = f.facility_type_id where b.is_delete = false and bfm.is_delete = false and (tsv_artvalues @@ to_tsquery(:searchText) or b.ti_benf_search_str ilike :searchText ) order by b.modified_time desc ")
	List<UidMergeProjection> getSearchInBeneficiariesWithTsVector(@Param("searchText") String searchText,
			@Param("facilityId") Integer facilityId);

	@Query(nativeQuery = true, value = "select coalesce (sum(cast(sa.answer as int) ),0) as value ,to_char(tbra.assessment_date,'month') as name \n"
			+ "from soch.ti_ben_rv_assessment tbra \n"
			+ "inner join soch.ti_beneficiary tb on tb.id = tbra.beneficiary_id\n"
			+ "inner join soch.survey s on s.id = tbra.survey_id \n"
			+ "inner join soch.survey_answer sa on sa.survey_id = s.id \n"
			+ "where tb.facility_id =:facilityId and tb.is_active and tb.is_deleted  = false \n"
			+ "and to_char(tbra.assessment_date,'YYYY')=to_char(now(),'YYYY') and sa.question_id in(18,21) group by 2")
	List<StatisticsProjection> getMonthWiseCondomsDemandByFacilityId(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select coalesce (sum(cast(sa.answer as int) ),0) as value ,to_char(tbra.assessment_date,'month') as name \n"
			+ "from soch.ti_ben_rv_assessment tbra \n"
			+ "inner join soch.ti_beneficiary tb on tb.id = tbra.beneficiary_id\n"
			+ "inner join soch.beneficiary b on b.id = tb.beneficiary_id \n"
			+ "inner join soch.survey s on s.id = tbra.survey_id \n"
			+ "inner join soch.survey_answer sa on sa.survey_id = s.id \n"
			+ "where tb.facility_id =:facilityId and tb.is_active and tb.is_deleted  = false \n"
			+ "and to_char(tbra.assessment_date,'YYYY')=to_char(now(),'YYYY') and sa.question_id in(18,21) and b.gender_id in :genderIds group by 2")
	List<StatisticsProjection> getMonthWiseCondomsDemandByFacilityIdByGenderId(@Param("facilityId") Long facilityId,
			@Param("genderIds") List<Integer> genderIds);

	@Query(nativeQuery = true, value = "select coalesce (sum(cast(sa.answer as int) ),0) as value ,to_char(tbra.assessment_date,'month') as name \n"
			+ "from soch.ti_ben_rv_assessment tbra \n"
			+ "inner join soch.ti_beneficiary tb on tb.id = tbra.beneficiary_id\n"
			+ "inner join soch.survey s on s.id = tbra.survey_id \n"
			+ "inner join soch.survey_answer sa on sa.survey_id = s.id \n"
			+ "inner join soch.question q on q.id = sa.question_id \n"
			+ "where tb.facility_id =:facilityId and tb.is_active and tb.is_deleted  = false \n"
			+ "and to_char(tbra.assessment_date,'YYYY')=to_char(now(),'YYYY') and sa.question_id in(18,21) and q.questionnaire_id in :typologyIds group by 2")
	List<StatisticsProjection> getMonthWiseCondomsDemandByFacilityIdByTopologyId(@Param("facilityId") Long facilityId,
			@Param("typologyIds") List<Integer> typologyIds);

	@Query(nativeQuery = true, value = "select coalesce (sum(cast(sa.answer as int) ),0) as value ,to_char(tbra.assessment_date,'month') as name \n"
			+ "from soch.ti_ben_rv_assessment tbra \n"
			+ "inner join soch.ti_beneficiary tb on tb.id = tbra.beneficiary_id\n"
			+ "inner join soch.beneficiary b on b.id = tb.beneficiary_id \n"
			+ "inner join soch.survey s on s.id = tbra.survey_id \n"
			+ "inner join soch.survey_answer sa on sa.survey_id = s.id \n"
			+ "inner join soch.question q on q.id = sa.question_id \n"
			+ "where tb.facility_id =:facilityId and tb.is_active and tb.is_deleted  = false \n"
			+ "and to_char(tbra.assessment_date,'YYYY')=to_char(now(),'YYYY') and sa.question_id in(18,21)\n"
			+ "and q.questionnaire_id in :typologyIds and b.gender_id in :genderIds group by 2")
	List<StatisticsProjection> getMonthWiseCondomsDemandByFacilityIdGenderIdAndTopologyId(
			@Param("facilityId") Long facilityId, @Param("genderIds") List<Integer> genderIds,
			@Param("typologyIds") List<Integer> typologyIds);

	@Query(nativeQuery = true, value = "select coalesce (sum(cast(sa.answer as int) ),0) as value ,to_char(tbra.assessment_date,'month') as name \n"
			+ "from soch.ti_ben_rv_assessment tbra \n"
			+ "inner join soch.ti_beneficiary tb on tb.id = tbra.beneficiary_id\n"
			+ "inner join soch.survey s on s.id = tbra.survey_id \n"
			+ "inner join soch.survey_answer sa on sa.survey_id = s.id \n"
			+ "where tb.facility_id =:facilityId and tb.is_active and tb.is_deleted  = false \n"
			+ "and to_char(tbra.assessment_date,'YYYY')=to_char(now(),'YYYY') and sa.question_id = 19 group by 2")
	List<StatisticsProjection> getMonthWiseNeedlesDemandByFacilityId(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select coalesce (sum(cast(sa.answer as int) ),0) as value ,to_char(tbra.assessment_date,'month') as name \n"
			+ "from soch.ti_ben_rv_assessment tbra \n"
			+ "inner join soch.ti_beneficiary tb on tb.id = tbra.beneficiary_id\n"
			+ "inner join soch.beneficiary b on b.id = tb.beneficiary_id \n"
			+ "inner join soch.survey s on s.id = tbra.survey_id \n"
			+ "inner join soch.survey_answer sa on sa.survey_id = s.id \n"
			+ "where tb.facility_id =:facilityId and tb.is_active and tb.is_deleted  = false \n"
			+ "and to_char(tbra.assessment_date,'YYYY')=to_char(now(),'YYYY') and sa.question_id = 19 and b.gender_id in :genderIds group by 2")
	List<StatisticsProjection> getMonthWiseNeedlesDemandByFacilityIdByGenderId(@Param("facilityId") Long facilityId,
			@Param("genderIds") List<Integer> genderIds);

	@Query(nativeQuery = true, value = "select coalesce (sum(cast(sa.answer as int) ),0) as value ,to_char(tbra.assessment_date,'month') as name \n"
			+ "from soch.ti_ben_rv_assessment tbra \n"
			+ "inner join soch.ti_beneficiary tb on tb.id = tbra.beneficiary_id\n"
			+ "inner join soch.survey s on s.id = tbra.survey_id \n"
			+ "inner join soch.survey_answer sa on sa.survey_id = s.id \n"
			+ "inner join soch.question q on q.id = sa.question_id \n"
			+ "where tb.facility_id =:facilityId and tb.is_active and tb.is_deleted  = false \n"
			+ "and to_char(tbra.assessment_date,'YYYY')=to_char(now(),'YYYY') and sa.question_id = 19 and q.questionnaire_id in :typologyIds group by 2")
	List<StatisticsProjection> getMonthWiseNeedlesDemandByFacilityIdByTopologyId(@Param("facilityId") Long facilityId,
			@Param("typologyIds") List<Integer> typologyIds);

	@Query(nativeQuery = true, value = "select coalesce (sum(cast(sa.answer as int) ),0) as value ,to_char(tbra.assessment_date,'month') as name \n"
			+ "from soch.ti_ben_rv_assessment tbra \n"
			+ "inner join soch.ti_beneficiary tb on tb.id = tbra.beneficiary_id\n"
			+ "inner join soch.beneficiary b on b.id = tb.beneficiary_id \n"
			+ "inner join soch.survey s on s.id = tbra.survey_id \n"
			+ "inner join soch.survey_answer sa on sa.survey_id = s.id \n"
			+ "inner join soch.question q on q.id = sa.question_id \n"
			+ "where tb.facility_id =:facilityId and tb.is_active and tb.is_deleted  = false \n"
			+ "and to_char(tbra.assessment_date,'YYYY')=to_char(now(),'YYYY') and sa.question_id = 19\n"
			+ "and q.questionnaire_id in :typologyIds and b.gender_id in :genderIds group by 2")
	List<StatisticsProjection> getMonthWiseNeedlesDemandByFacilityIdGenderIdAndTopologyId(
			@Param("facilityId") Long facilityId, @Param("genderIds") List<Integer> genderIds,
			@Param("typologyIds") List<Integer> typologyIds);

	@Modifying
	@Transactional
	@Query(value = "update soch.beneficiary b set ti_benf_search_str = trim(regexp_replace(TRIM(coalesce(first_name, '')) || ' ' || TRIM(coalesce(middle_name, '')) || ' ' || TRIM(coalesce(last_name, '')) || ' ' || coalesce(uid, '') || ' ' || TRIM(coalesce(mobile_number, ''))|| ' ' || TRIM(coalesce(ti_code, '')), '\\\\s+', ' ', 'g')) \n" +
			" where id = :beneficiaryId", nativeQuery = true)
	int updateTsvTiValues(@Param("beneficiaryId") Long beneficiaryId);

	@Modifying
	@Transactional
	@Query(value = "UPDATE soch.beneficiary b\r\n"
			+ "SET ost_benf_search_str = b.uid || ' ' || TRIM(coalesce(b.mobile_number, '')) || ' ' || TRIM(coalesce(b.first_name, '')) || ' ' || TRIM(coalesce(b.middle_name, ''))|| ' ' || TRIM(coalesce(b.last_name, '')) || ' ' || TRIM(coalesce(tob.ost_number, ''))\r\n"
			+ "FROM soch.ti_ost_beneficiary tob\r\n"
			+ "WHERE tob.beneficiary_id = :beneficiaryId AND b.id = tob.beneficiary_id", nativeQuery = true)
	int updateOstBenSearchValues(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select count(tob.status_id) as value,mcso.name \n"
			+ "from soch.ti_ost_beneficiary tob\n"
			+ "inner join soch.master_client_status_ost mcso on tob.status_id = mcso.id\n"
			+ "where tob.is_active = true and tob.is_delete = false\n"
			+ "and tob.facility_id = :facilityId group by mcso.id")
	List<StatisticsProjection> getClientStatusDistribution(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select b.birth_weight as birthWeight ,b.neo_natal_complications as complications,  \r\n"
			+ "mbh.name as birthHistory ,mif.name as infantFeeding ,mdpr.name as  pcrResults "
			+ "from soch.beneficiary as b  "
			+ "left join soch.master_birth_history as mbh on mbh.id = b.birth_history_id  "
			+ "left join soch.art_beneficiary_followup as abf on abf.beneficiary_id = b.id "
			+ "left join soch.master_infant_feeding as mif on mif.id = abf.infant_feeding_id "
			+ "left join soch.art_beneficiary_dna_pcr_result as abd on abd.beneficiary_id = b.id "
			+ "left join soch.master_dna_pcr_result as mdpr on mdpr.id = abd.dna_pcr_result_id "
			+ "where b.id = :beneficiaryId order by abf.visit_register_id desc limit 1")
	WhiteCardDetailsProjection findPediatricDetailsByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Modifying
	@Transactional
	@Query(value = "update soch.beneficiary b set tsv_tivalues = to_tsvector(\r\n"
			+ "coalesce(first_name, '') || ' ' || coalesce(middle_name, '') || ' ' ||\r\n"
			+ "coalesce(last_name, '') || ' ' || coalesce(uid, '') || ' ' ||\r\n"
			+ "coalesce(mobile_number, '') || ' ' || coalesce(ost_code, '') || ' ' ||\r\n"
			+ "coalesce(ti_code, '') || ' ' ||\r\n" + "coalesce((select tob.ost_number from soch.beneficiary b2\r\n"
			+ "join soch.ti_ost_beneficiary tob on (b2.id = tob.beneficiary_id)\r\n"
			+ "where b2.id = :beneficiaryId), '' )), ost_number=:ostNumber where b.id = :beneficiaryId", nativeQuery = true)
	int updateTsvTiValuesAndOstNumber(@Param("beneficiaryId") Long beneficiaryId, @Param("ostNumber") String ostNumber);


	@Query(nativeQuery = true, value = "select count(tbds.dispensation_status_id) as value, ods.name\n"
			+ "from soch.ti_beneficiary_dispensation_status tbds\n"
			+ "inner join soch.master_ost_dispensation_status ods on  ods.id=tbds.dispensation_status_id\n"
			+ "where tbds.facility_id =:facilityId\n" + "group by ods.id")
	List<StatisticsProjection> getDispensationStatusDistribution(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',tob.modified_time),'MONTH') AS name, \r\n"
			+ "count(tob.status_id) as value from soch.ti_ost_beneficiary tob  \r\n"
			+ "where tob.facility_id =:facilityId and tob.is_active = true and tob.is_delete = false \r\n"
			+ "and tob.status_id=1 or tob.status_id=7  \r\n"
			+ "and tob.modified_time >= date_trunc('month', now())- interval '11 month' GROUP BY name")
	List<StatisticsProjection> getExpectedClientCount(Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',tob.modified_time),'MONTH') AS name, \r\n"
			+ "count(tob.status_id) as value from soch.ti_ost_beneficiary tob   \r\n"
			+ "where tob.facility_id =:facilityId and tob.is_active = true and tob.is_delete = false  \r\n"
			+ "and tob.status_id=2  \r\n"
			+ "and tob.modified_time >= date_trunc('month', now())- interval '11 month' GROUP BY name")
	List<StatisticsProjection> getTreatmentCompleteCount(Long facilityId);

	@Query(nativeQuery = true, value = "select p.product_code as productName, sum(fas.available_quantity) as availableQuantity,\r\n"
			+ "sum(fas.expired_quantity) as expiredQuantity from (select product_id, facility_id, git,damaged_quantity,case\r\n"
			+ "when date(batch_expiry_date) < date(now()) then 0 else available_quantity\r\n"
			+ "end as available_quantity,case\r\n"
			+ "when date(batch_expiry_date) < date(now()) then available_quantity else 0\r\n"
			+ "end as expired_quantity from soch.facility_aggregate_stock\r\n"
			+ "where facility_id = :facilityId ) as fas\r\n" + "join soch.product as p on\r\n"
			+ "p.id = fas.product_id\r\n" + "where p.product_code in('PR103', 'PR44', 'PR164')\r\n"
			+ "group by p.product_code order by p.product_code")
	List<StockDetailsProjection> getStockAvialableStatus(Long facilityId);

	@Query(nativeQuery = true, value = "select sum(tod.total_dispensed_qty ) as dispensedQuantity,p.product_code as productName from soch.ti_ost_dispensation tod\r\n"
			+ "inner join soch.product p on p.id = tod.substitution_drug\r\n"
			+ "where tod.facility_id = :facilityId and\r\n" + "tod.ost_dispensation_date = current_date\r\n"
			+ "and  p.product_code in('PR103', 'PR44', 'PR164')\r\n"
			+ "and tod.is_active = true and tod.is_deleted =false\r\n"
			+ "group by p.product_code order by p.product_code")
	List<StockDetailsProjection> getStockDispensedTodayList(Long facilityId);

	@Query(nativeQuery = true, value = " select b.id as beneficiaryId, b.uid as beneficiaryUId,concat(b.first_name,' ',b.middle_name,' ',b.last_name) as beneficiaryName, "
			+ " b.gender_id as  genderId, mg.name as gender, b.date_of_birth as dateOfBirth, b.art_number as artNumber, "
			+ " b.pre_art_number as preArtNumber, ab.art_beneficiary_status_id as artBeneficiaryStatusId, mabs.name as artBeneficiaryStatusName, "
			+ " ab.transit_start_date as transitStartDate, ab.transit_end_date as transitEndDate "
			+ " from soch.beneficiary as b " + " join soch.art_beneficiary as ab on ab.beneficiary_id =b.id "
			+ " join soch.master_gender as mg on mg.id = b.gender_id "
			+ " join soch.master_art_beneficiary_status as mabs on mabs.id = ab.art_beneficiary_status_id "
			+ " where ab.is_active = true and ab.is_delete =false and ab.is_transit =true and ab.facility_id =:facilityId order by ab.modified_time ")
	Page<ArtTransitBeneficiaryProjection> findTransitByFacilityId(@Param("facilityId") Long facilityId,
			Pageable pageable);

	@Query(nativeQuery = true, value = "select count(b.id) from soch.beneficiary as b "
			+ " join soch.art_beneficiary as ab on ab.beneficiary_id =b.id "
			+ " where ab.is_active = true and ab.is_delete =false and ab.is_transit =true and ab.facility_id =:facilityId ")
	Long getActualCountofTransitList(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = " select b.id as beneficiaryId, b.uid as beneficiaryUId,concat(b.first_name,' ',b.middle_name,' ',b.last_name) as beneficiaryName, "
			+ " b.gender_id as  genderId, mg.name as gender, b.date_of_birth as dateOfBirth, b.art_number as artNumber, "
			+ " b.pre_art_number as preArtNumber, ab.art_beneficiary_status_id as artBeneficiaryStatusId, mabs.name as artBeneficiaryStatusName, "
			+ " ab.transit_start_date as transitStartDate, ab.transit_end_date as transitEndDate "
			+ " from soch.beneficiary as b " + " join soch.art_beneficiary as ab on ab.beneficiary_id =b.id "
			+ " join soch.master_gender as mg on mg.id = b.gender_id "
			+ " join soch.master_art_beneficiary_status as mabs on mabs.id = ab.art_beneficiary_status_id "
			+ " where ab.is_active = true and ab.is_delete =false and ab.is_transit =true and ab.facility_id =:facilityId "
			+ " and (lower(b.first_name) like %:searchText% or lower(b.middle_name) like %:searchText% "
			+ " or lower(b.last_name) like %:searchText% or lower(concat(b.first_name,' ',b.middle_name,' ',b.last_name)) like %:searchText% "
			+ " or lower(b.art_number) like %:searchText% or lower(b.pre_art_number) like %:searchText% or lower(b.uid) like %:searchText% )"
			+ " order by ab.modified_time")
	Page<ArtTransitBeneficiaryProjection> findTransitByFacilityIdAndSearchText(@Param("facilityId") Long facilityId,
			@Param("searchText") String searchText, Pageable pageable);

	@Query(nativeQuery = true, value = "select count(b.id) from soch.beneficiary as b "
			+ " join soch.art_beneficiary as ab on ab.beneficiary_id =b.id "
			+ " where ab.is_active = true and ab.is_delete =false and ab.is_transit =true and ab.facility_id =:facilityId "
			+ " and (lower(b.first_name) like %:searchText% or lower(b.middle_name) like %:searchText% "
			+ " or lower(b.last_name) like %:searchText% or lower(concat(b.first_name,' ',b.middle_name,' ',b.last_name)) like %:searchText% "
			+ " or lower(b.art_number) like %:searchText% or lower(b.pre_art_number) like %:searchText% or lower(b.uid) like %:searchText% ) ")
	Long getActualCountofTransitListBySearchText(@Param("facilityId") Long facilityId,
			@Param("searchText") String searchText);

	@Query(nativeQuery = true, value = "select date_of_birth from soch.beneficiary where id =:beneficiaryId")
	LocalDate findDateOfBirth(@Param("beneficiaryId") Long beneficiaryId);

	@Modifying
	@Query(nativeQuery = true, value = "update soch.beneficiary set age =:age , client_status_id =:statusId where id =:beneficiaryId ")
	void updateAgeAndStatus(@Param("beneficiaryId") Long beneficiaryId, @Param("age") String age,
			@Param("statusId") Long statusId);

	@Query(nativeQuery = true, value = "select age from soch.beneficiary where uid =:uid")
	String findAgeByUid(@Param("uid") String uid);

	@Query(nativeQuery = true, value = "select age from soch.beneficiary where id =:beneficiaryId")
	String findAge(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select concat(b.first_name,' ',b.middle_name,' ',b.last_name ) as name,\r\n"
			+ "b.uid as uid,\r\n" + "b.ti_code as ticode ,\r\n" + "tm.typology_name as typology,\r\n"
			+ "TO_CHAR(tbsd.next_date_of_screening , 'DDth Month, YYYY') as dateDueOn\r\n"
			+ "from soch.ti_ben_scr_details tbsd inner join soch.ti_beneficiary tb on tbsd.beneficiary_id = tb.id\r\n"
			+ "inner join soch.beneficiary b  on tb.beneficiary_id = b.id \r\n"
			+ "inner join soch.beneficiary_facility_mapping bfm on b.id=bfm.beneficiary_id \r\n"
			+ "and (bfm.is_active=true) inner join soch.facility fac on bfm.facility_id=fac.id\r\n"
			+ "inner join soch.typology_master tm on tb.master_hrg_primary_id = tm.typology_id \r\n"
			+ "inner join soch.master_infection_type mit on tbsd.infection_id = mit.id\r\n"
			+ "where fac.id = :facilityId  and tbsd.infection_id=1\r\n" + "order by tbsd.next_date_of_screening asc")
	List<ExcelDetailsProjection> getHivDueDateDetails(Long facilityId);

	@Query(nativeQuery = true, value = "select concat(b.first_name,' ',  b.middle_name,' ', b.last_name ) as name,\r\n"
			+ "b.uid as uid, b.ti_code as ticode , tm.typology_name as typology,\r\n"
			+ "TO_CHAR(tbc.last_counselling_date, 'DDth Month, YYYY') as notCounselledSince\r\n"
			+ "from soch.ti_ben_counselling tbc inner join soch.ti_beneficiary tb on tbc.beneficiary_id=tb.id\r\n"
			+ "inner join soch.beneficiary b on tb.beneficiary_id=b.id \r\n"
			+ "inner join soch.beneficiary_facility_mapping bfm on b.id=bfm.beneficiary_id \r\n"
			+ "and (bfm.is_active=true) inner join soch.facility fac on bfm.facility_id=fac.id\r\n"
			+ "inner join soch.typology_master tm on tm.typology_id = tb.master_hrg_primary_id\r\n"
			+ "where fac.id = :facilityId order by tbc.last_counselling_date asc")
	List<ExcelDetailsProjection> getCounsellingDueDetails(Long facilityId);

	@Query(nativeQuery = true, value = "select concat(b.first_name,'',  b.middle_name,' ', b.last_name ) as name,\r\n"
			+ "b.uid as uid, b.ti_code as ticode , tm.typology_name as typology,\r\n"
			+ "TO_CHAR(tbra.assessment_date , 'Q') as quarterOfLastRV \r\n"
			+ "from soch.ti_ben_rv_assessment tbra inner join soch.ti_beneficiary tb on tbra.beneficiary_id = tb.id \r\n"
			+ "inner join soch.beneficiary b on tb.beneficiary_id = b.id \r\n"
			+ "inner join soch.beneficiary_facility_mapping bfm on b.id=bfm.beneficiary_id \r\n"
			+ "and (bfm.is_active=true) inner join soch.facility fac on bfm.facility_id=fac.id\r\n"
			+ "inner join soch.typology_master tm on tb.master_hrg_primary_id = tm.typology_id \r\n"
			+ "where fac.id = :facilityId")
	List<ExcelDetailsProjection> getRandVListDetails(Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',bcd.created_time),'MONTH') AS name,   \r\n"
			+ "count(distinct tb.beneficiary_id) as value from\r\n"
			+ "soch.ti_beneficiary_comm_dis bcd inner join soch.ti_beneficiary tb on tb.id = bcd.beneficiary_id \r\n"
			+ "inner join soch.master_contact_type mct on bcd.master_contact_type_id  = mct.id and tb.facility_id =:facilityId \r\n"
			+ "and to_char(bcd.created_time,'YYYY')=to_char(now(),'YYYY') and tb.is_active  = true and tb.is_deleted  = false\r\n"
			+ "group by 1")
	List<StatisticsProjection> getMonthWiseTotalContact(Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',counselling_date),'MONTH') AS name,\r\n"
			+ "count(distinct tb.beneficiary_id) as value from soch.ti_ben_counselling tbc inner join soch.ti_beneficiary tb \r\n"
			+ "on tbc.beneficiary_id  = tb.id  \r\n"
			+ "where to_char(counselling_date,'YYYY')=to_char(now(),'YYYY')  \r\n"
			+ "and tb.facility_id= :facilityId and  tbc.counselling_date is not null\r\n"
			+ "and tb.is_active  = true and tb.is_deleted  = false	group by 1")
	List<StatisticsProjection> getMonthWiseHrgsCounselled(Long facilityId);

	// List<StatisticsProjection> getMonthwiseSyphilisSentForTreatment(Long
	// facilityId);

	@Query(nativeQuery = true, value = "select count(distinct b.id) as value, TO_CHAR(DATE_TRUNC('month',bct.treatment_date),'MONTH') AS name from soch.beneficiary b\r\n"
			+ "	join soch.ti_beneficiary tb on tb.beneficiary_id = b.id\r\n"
			+ "	join soch.master_client_status_ticore mcst on mcst.id = tb.status_id   \r\n"
			+ "	join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = b.id\r\n"
			+ "	join soch.master_clinical_treatment_type mct on mct.id = bct.clinical_treatment_type_id\r\n"
			+ "	left join soch.beneficiary_sti_rti_treatment_details bsrt on bct.id = bsrt.clinical_treatment_id\r\n"
			+ "	left join soch.master_sti_rti_diagnosis_type msrdt on msrdt.id = bsrt.sti_rti_diagnosis_type_id \r\n"
			+ "	where tb.is_deleted = false and bct.is_delete = false and mct.id =1 and bsrt.next_followup_date is null \r\n"
			+ "	and bsrt.is_treatment_completed=true and bsrt.is_delete = false and to_char(bct.treatment_date ,'YYYY')=to_char(now(),'YYYY') group by 2")
	List<StatisticsProjection> getMonthwiseStitreatedCount(Long facilityId);

	@Query(nativeQuery = true, value = "select count(distinct b.id) as value, TO_CHAR(DATE_TRUNC('month',bct.treatment_date),'MONTH') AS name\r\n"
			+ "from soch.beneficiary b\r\n" + "join soch.ti_beneficiary tb on tb.beneficiary_id = b.id\r\n"
			+ "join soch.typology_master tm on tm.typology_id = tb.master_hrg_primary_id \r\n"
			+ "join soch.master_gender mg on mg.id = b.gender_id\r\n"
			+ "join soch.master_client_status_ticore mcst on mcst.id = tb.status_id   \r\n"
			+ "join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = b.id\r\n"
			+ "join soch.master_clinical_treatment_type mct on mct.id = bct.clinical_treatment_type_id\r\n"
			+ "left join soch.beneficiary_sti_rti_treatment_details bsrt on bct.id = bsrt.clinical_treatment_id\r\n"
			+ "left join soch.beneficiary_abscess_treatment_details batd on bct.id = batd.clinical_treatment_id\r\n"
			+ "left join soch.beneficiary_opioid_overdose_treatment_details botd on bct.id = botd.clinical_treatment_id \r\n"
			+ "left join soch.master_sti_rti_diagnosis_type msrdt on msrdt.id = bsrt.sti_rti_diagnosis_type_id \r\n"
			+ "where bct.facility_id = :facilityId and tb.is_deleted = false and bct.is_delete = false and mct.id !=4 and bsrt.next_followup_date is null \r\n"
			+ "and (bsrt.is_treatment_completed=true and bsrt.is_delete = false\r\n"
			+ "or batd.is_treatment_completed=true and batd.is_delete = false\r\n"
			+ "or botd.is_treatment_completed=true and botd.is_delete = false) \r\n"
			+ "and to_char(bct.treatment_date ,'YYYY')=to_char(now(),'YYYY') group by 2")
	List<StatisticsProjection> getMonthwiseRmcDoneCount(Long facilityId);

	@Query(nativeQuery = true, value = "select b.first_name as firstName ,b.middle_name as middleName ,b.last_name as lastName ,b.uid as uidNumber ,"
			+ "mg.name as gender,st.name as stateName ,dt.name as districtName ,mab.name as beneficiaryStatus ,b.mobile_number as mobileNumber ,"
			+ "b.pre_art_number as preArtNumber ,b.art_number as artNumber ,b.date_of_birth as dateOfBirth ,mrs.name as beneficiaryReferralStatus ,"
			+ "b.id as beneficiaryId ,f.name as referedTo,bf.id as beneficiaryReferralId,bf.referral_status_id  as referralStatusId "
			+ "from soch.beneficiary as b " + "join soch.beneficiary_referral as bf on bf.beneficiary_id = b.id "
			+ "left join soch.art_beneficiary as ab on ab.beneficiary_id = b.id "
			+ "left join soch.master_gender as mg on mg.id = b.gender_id "
			+ "left join soch.address as ad on ad.id = b.address_id "
			+ "left join soch.state as st on st.id = ad.state_id "
			+ "left join soch.district as dt on dt.id = ad.district_id "
			+ "left join soch.master_art_beneficiary_status as mab on mab.id = ab.art_beneficiary_status_id "
			+ "left join soch.master_referral_status as mrs on mrs.id = bf.referral_status_id "
			+ "left join soch.facility as f on f.id = bf.refered_to "
			+ "where bf.referred_to_facility_type_id IN(16,17,31) and bf.refered_from = :facilityId and b.is_delete = false and bf.is_delete = false and bf.referral_status_id in(1,2,3,4,6,7,8) order by bf.modified_time desc")
	Page<SacepReferralProjection> findReferralList(@Param("facilityId") Long facilityId, Pageable pageable);

	@Query(nativeQuery = true, value = "select b.first_name as firstName ,b.middle_name as middleName ,b.last_name as lastName ,b.uid as uidNumber ,\r\n"
			+ "mg.name as gender,st.name as stateName ,dt.name as districtName ,mab.name as beneficiaryStatus ,b.mobile_number as mobileNumber ,\r\n"
			+ "b.pre_art_number as preArtNumber ,b.art_number as artNumber ,b.date_of_birth as dateOfBirth ,mrs.name as beneficiaryReferralStatus,\r\n"
			+ "b.id as beneficiaryId,bf.id as beneficiaryReferralId,f.name as referedTo,bf.referral_status_id  as referralStatusId,sri.is_beneficiary_accepted_for_sacep as acceptedForSacep \r\n"
			+ "from soch.beneficiary as b \r\n"
			+ "join soch.beneficiary_referral as bf on bf.beneficiary_id = b.id \r\n"
			+ "left join soch.sacep_referral_information as sri on bf.id=sri.beneficiary_referral_id and sri.is_delete=false and sri.is_active=true \r\n"
			+ "left join soch.art_beneficiary as ab on ab.beneficiary_id = b.id \r\n"
			+ "left join soch.master_gender as mg on mg.id = b.gender_id \r\n"
			+ "left join soch.address as ad on ad.id = b.address_id \r\n"
			+ "left join soch.state as st on st.id = ad.state_id \r\n"
			+ "left join soch.district as dt on dt.id = ad.district_id \r\n"
			+ "left join soch.master_art_beneficiary_status as mab on mab.id = ab.art_beneficiary_status_id \r\n"
			+ "left join soch.master_referral_status as mrs on mrs.id = bf.referral_status_id \r\n"
			+ "left join soch.facility as f on f.id = bf.refered_to "
			+ "where bf.referred_to_facility_type_id IN(16,17,31) and bf.refered_from = :facilityId and b.is_delete = false and bf.referral_status_id=8 order by bf.modified_time desc")
	Page<SacepReferralProjection> findSacepReferralOutcomeList(@Param("facilityId") Long facilityId, Pageable pageable);

	@Query(nativeQuery = true, value = "select b.first_name as firstName ,b.middle_name as middleName ,b.last_name as lastName ,b.uid as uidNumber ,\r\n"
			+ "mg.name as gender,st.name as stateName ,dt.name as districtName ,mab.name as beneficiaryStatus ,b.mobile_number as mobileNumber ,\r\n"
			+ "b.pre_art_number as preArtNumber ,b.art_number as artNumber ,b.date_of_birth as dateOfBirth ,mrs.name as beneficiaryReferralStatus,\r\n"
			+ "b.id as beneficiaryId,bf.id as beneficiaryReferralId,f.name as referedTo,bf.referral_status_id  as referralStatusId,sri.is_beneficiary_accepted_for_sacep as acceptedForSacep  \r\n"
			+ "from soch.beneficiary as b \r\n"
			+ "join soch.beneficiary_referral as bf on bf.beneficiary_id = b.id \r\n"
			+ "left join soch.sacep_referral_information as sri on bf.id=sri.beneficiary_referral_id and sri.is_delete=false and sri.is_active=true \r\n"
			+ "left join soch.art_beneficiary as ab on ab.beneficiary_id = b.id \r\n"
			+ "left join soch.master_gender as mg on mg.id = b.gender_id \r\n"
			+ "left join soch.address as ad on ad.id = b.address_id \r\n"
			+ "left join soch.state as st on st.id = ad.state_id \r\n"
			+ "left join soch.district as dt on dt.id = ad.district_id \r\n"
			+ "left join soch.master_art_beneficiary_status as mab on mab.id = ab.art_beneficiary_status_id \r\n"
			+ "left join soch.master_referral_status as mrs on mrs.id = bf.referral_status_id \r\n"
			+ "left join soch.facility as f on f.id = bf.refered_to "
			+ "where bf.referred_to_facility_type_id IN(16,17,31) and bf.refered_from = :facilityId and b.is_delete = false and bf.referral_status_id=8 and \r\n"
			+ "( lower(b.uid) like lower(:searchValue) or lower(b.pre_art_number) like lower(:searchValue) or lower(b.art_number) like lower(:searchValue) "
			+ "\r\n or lower(concat(b.first_name,' ',b.middle_name,' ',b.last_name)) like lower(:searchValue) or lower(concat(b.first_name,' ',b.middle_name)) like lower(:searchValue) "
			+ "or lower(concat(b.first_name,' ',b.last_name)) like lower(:searchValue) or lower(b.first_name) like lower(:searchValue) or lower(b.middle_name) like lower(:searchValue) "
			+ "or lower(b.last_name) like lower(:searchValue) ) order by bf.modified_time desc")
	Page<SacepReferralProjection> normalSearchSacepReferralOutcomeList(@Param("facilityId") Long facilityId,
			@Param("searchValue") String searchValue, Pageable pageable);

	@Query(nativeQuery = true, value = "select b.first_name as firstName ,b.middle_name as middleName ,b.last_name as lastName ,b.uid as uidNumber ,"
			+ "mg.name as gender,st.name as stateName ,dt.name as districtName ,mab.name as beneficiaryStatus ,b.mobile_number as mobileNumber ,"
			+ "b.pre_art_number as preArtNumber ,b.art_number as artNumber ,b.date_of_birth as dateOfBirth ,mrs.name as beneficiaryReferralStatus ,"
			+ "b.id as beneficiaryId ,f.name as referedTo,bf.id as beneficiaryReferralId,bf.referral_status_id as referralStatusId "
			+ "from soch.beneficiary as b " + "join soch.beneficiary_referral as bf on bf.beneficiary_id = b.id "
			+ "left join soch.art_beneficiary as ab on ab.beneficiary_id = b.id "
			+ "left join soch.master_gender as mg on mg.id = b.gender_id "
			+ "left join soch.address as ad on ad.id = b.address_id "
			+ "left join soch.state as st on st.id = ad.state_id "
			+ "left join soch.district as dt on dt.id = ad.district_id "
			+ "left join soch.master_art_beneficiary_status as mab on mab.id = ab.art_beneficiary_status_id "
			+ "left join soch.master_referral_status as mrs on mrs.id = bf.referral_status_id "
			+ "left join soch.facility as f on f.id = bf.refered_to "
			+ "where bf.referred_to_facility_type_id IN(16,17,31) and bf.refered_from = :facilityId and b.is_delete = false and b.is_delete = false and bf.referral_status_id in(1,2,3,4,6,7,8) and (lower(b.age) like %:searchText%  or lower(b.uid) like %:searchText% or lower(b.art_number) like %:searchText% or "
			+ "lower(b.pre_art_number) like %:searchText% or lower(b.mobile_number) like %:searchText% or lower(mg.name) like %:searchText% or lower(st.name) like %:searchText% or lower(dt.name) like %:searchText% or lower(mab.name) like %:searchText% or lower(mrs.name) like %:searchText% or lower(b.first_name) like %:searchText% or lower(b.last_name) like %:searchText% or lower(b.middle_name) like %:searchText% or "
			+ "concat(lower(b.first_name), ' ',lower(b.middle_name), ' ',lower(b.last_name)) like %:searchText% or concat(lower(b.first_name), ' ',lower(b.middle_name)) "
			+ "like %:searchText% or concat(lower(b.first_name), ' ',lower(b.last_name)) like %:searchText% )")
	Page<SacepReferralProjection> searchReferralList(@Param("searchText") String searchText,
			@Param("facilityId") Long facilityId, Pageable pageable);
	
	// Query to search beneficiary with mobile number
	@Query(nativeQuery = true, value = "select b.id,b.uid,b.first_name,b.middle_name,b.last_name,b.mobile_number, "
			+ " b.age,b.gender_id,b.ti_code from soch.beneficiary b"
			+ " where b.is_delete=false and (b.mobile_number=?1)")
	List<Object[]> findByMobileNumber(String mobileNumber);
	
	@Query(nativeQuery = true, value = "select b.id as beneficiaryId,b.uid as uid,b.first_name as firstName,\r\n" + 
			"b.middle_name as middleName,b.last_name as lastName, bg.name as gender,\r\n" + 
			"b.date_of_birth as dateOfBirth,b.mobile_number as mobileNumber \r\n" + 
			"from soch.beneficiary b \r\n" + 
			"join soch.master_gender bg on bg.id = b.gender_id  \r\n" + 
			"where  b.is_delete = false \r\n" + 
			"and b.mobile_number = :searchText \r\n" + 
			"order by b.modified_time desc")
	List<BeneficiaryProjectionForMobile> findBenefiaryDetailsByMobileNo(@Param("searchText") String searchText);

	@Query(nativeQuery = true, value = "select b.first_name as firstName ,b.middle_name as middleName ,b.last_name as lastName ,b.uid as uidNumber ,"
			+ "mg.name as gender,st.name as stateName ,dt.name as districtName ,mab.name as beneficiaryStatus ,b.mobile_number as mobileNumber ,"
			+ "b.pre_art_number as preArtNumber ,b.art_number as artNumber ,b.date_of_birth as dateOfBirth ,mrs.name as beneficiaryReferralStatus , "
			+ "b.id as beneficiaryId ,f1.name as referedTo,f2.name referedFrom, "
			+ "bf.id as beneficiaryReferralId,bf.referral_status_id as referralStatusId,si.id as sacepReferralInformationId "
			+ "from soch.beneficiary as b " + "join soch.beneficiary_referral as bf on bf.beneficiary_id = b.id "
			+ "left join soch.art_beneficiary as ab on ab.beneficiary_id = b.id "
			+ "left join soch.master_gender as mg on mg.id = b.gender_id "
			+ "left join soch.address as ad on ad.id = b.address_id "
			+ "left join soch.state as st on st.id = ad.state_id "
			+ "left join soch.district as dt on dt.id = ad.district_id "
			+ "left join soch.master_art_beneficiary_status as mab on mab.id = ab.art_beneficiary_status_id "
			+ "left join soch.master_referral_status as mrs on mrs.id = bf.referral_status_id "
			+ "left join soch.facility as f1 on f1.id = bf.refered_to "
			+ "left join soch.facility as f2 on f2.id = bf.refered_from "
			+ "left join soch.sacep_referral_information as si on si.beneficiary_referral_id = bf.id "
			+ "where bf.referred_to_facility_type_id IN(16,17,31) and bf.refered_from = :facilityId and b.is_delete = false and bf.referral_status_id in(3,7,8) ")
	Page<SacepReferralProjection> findArtSacepPlanList(@Param("facilityId") Long facilityId, Pageable pageable);

	@Query(nativeQuery = true, value = "select b.first_name as firstName ,b.middle_name as middleName ,b.last_name as lastName ,b.uid as uidNumber ,"
			+ "mg.name as gender,st.name as stateName ,dt.name as districtName ,mab.name as beneficiaryStatus ,b.mobile_number as mobileNumber ,"
			+ "b.pre_art_number as preArtNumber ,b.art_number as artNumber ,b.date_of_birth as dateOfBirth ,mrs.name as beneficiaryReferralStatus ,b.id as beneficiaryId ,f.name as referedTo, "
			+ "bf.id as beneficiaryReferralId,bf.referral_status_id as referralStatusId,si.id as sacepReferralInformationId "
			+ "from soch.beneficiary as b " + "join soch.beneficiary_referral as bf on bf.beneficiary_id = b.id "
			+ "left join soch.art_beneficiary as ab on ab.beneficiary_id = b.id "
			+ "left join soch.master_gender as mg on mg.id = b.gender_id "
			+ "left join soch.address as ad on ad.id = b.address_id "
			+ "left join soch.state as st on st.id = ad.state_id "
			+ "left join soch.district as dt on dt.id = ad.district_id "
			+ "left join soch.master_art_beneficiary_status as mab on mab.id = ab.art_beneficiary_status_id "
			+ "left join soch.master_referral_status as mrs on mrs.id = bf.referral_status_id "
			+ "left join soch.facility as f on f.id = bf.refered_to "
			+ "left join soch.sacep_referral_information as si on si.beneficiary_referral_id = bf.id "
			+ "where bf.referred_to_facility_type_id IN(16,17) and bf.refered_from = :facilityId and b.is_delete = false and bf.referral_status_id in(3,7,8) and (lower(b.age) like %:searchText%  or lower(b.uid) like %:searchText% or lower(b.art_number) like %:searchText% or "
			+ "lower(b.pre_art_number) like %:searchText% or lower(b.mobile_number) like %:searchText% or lower(mg.name) like %:searchText% or lower(st.name) like %:searchText% or lower(dt.name) like %:searchText% or lower(mab.name) like %:searchText% or lower(mrs.name) like %:searchText% or lower(b.first_name) like %:searchText% or lower(b.last_name) like %:searchText% or lower(b.middle_name) like %:searchText% or "
			+ "concat(lower(b.first_name), ' ',lower(b.middle_name), ' ',lower(b.last_name)) like %:searchText% or concat(lower(b.first_name), ' ',lower(b.middle_name)) "
			+ "like %:searchText% or concat(lower(b.first_name), ' ',lower(b.last_name)) like %:searchText% )")
	Page<SacepReferralProjection> searchArtSacepPlanList(@Param("searchText") String searchText,
			@Param("facilityId") Long facilityId, Pageable pageable);

	@Modifying
	@Transactional
	@Query(value = "update soch.beneficiary b set benf_search_str ='D' || trim(coalesce(b.uid, '')) || ' ' || trim(coalesce(b.mobile_number, '')) || ' ' || \n"
			+ "trim(coalesce(b.first_name, '')) || ' ' || trim(coalesce(b.middle_name, '')) || ' ' || trim(coalesce(b.last_name, '')) || ' ' || \n"
			+ "trim(coalesce(b.dsrc_beneficiary_code, ''))  where b.id =:beneficiaryId and b.dsrc_beneficiary_code is not null ", nativeQuery = true)
	int updateBeneficiarySearchString(@Param("beneficiaryId") Long beneficiaryId);
	
	@Modifying
	@Transactional
	@Query(value = "update soch.beneficiary b set benf_search_str ='D' || trim(coalesce(b.uid, '')) || ' ' || trim(coalesce(b.mobile_number, '')) || ' ' || \n"
			+ "trim(coalesce(b.first_name, '')) || ' ' || trim(coalesce(b.last_name, '')) || ' ' || \n"
			+ "trim(coalesce(b.dsrc_beneficiary_code, ''))  where b.id =:beneficiaryId and b.dsrc_beneficiary_code is not null ", nativeQuery = true)
	int updateBeneficiaryWithoutMiddleNameSearchString(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select b.first_name as firstName ,b.middle_name as middleName ,b.last_name as lastName ,b.uid as uidNumber ,"
			+ "mg.name as gender,st.name as stateName ,dt.name as districtName ,mab.name as beneficiaryStatus ,b.mobile_number as mobileNumber ,"
			+ "b.pre_art_number as preArtNumber ,b.art_number as artNumber ,b.date_of_birth as dateOfBirth ,mrs.name as beneficiaryReferralStatus , "
			+ "b.id as beneficiaryId ,f1.name as referedTo,f2.name referedFrom, "
			+ "bf.id as beneficiaryReferralId,bf.referral_status_id as referralStatusId,si.id as sacepReferralInformationId "
			+ "from soch.beneficiary as b " + "join soch.beneficiary_referral as bf on bf.beneficiary_id = b.id "
			+ "left join soch.art_beneficiary as ab on ab.beneficiary_id = b.id "
			+ "left join soch.master_gender as mg on mg.id = b.gender_id "
			+ "left join soch.address as ad on ad.id = b.address_id "
			+ "left join soch.state as st on st.id = ad.state_id "
			+ "left join soch.district as dt on dt.id = ad.district_id "
			+ "left join soch.master_art_beneficiary_status as mab on mab.id = ab.art_beneficiary_status_id "
			+ "left join soch.master_referral_status as mrs on mrs.id = bf.referral_status_id "
			+ "left join soch.facility as f1 on f1.id = bf.refered_to "
			+ "left join soch.facility as f2 on f2.id = bf.refered_from "
			+ "left join soch.sacep_referral_information as si on si.beneficiary_referral_id = bf.id "
			+ "where bf.refered_to = :facilityId and b.is_delete = false and bf.referral_status_id in(3,7,8) ")
	Page<SacepReferralProjection> findArtPlusSacepPlanList(@Param("facilityId") Long facilityId, Pageable pageable);

	@Query(nativeQuery = true, value = "select b.first_name as firstName ,b.middle_name as middleName ,b.last_name as lastName ,b.uid as uidNumber ,"
			+ "mg.name as gender,st.name as stateName ,dt.name as districtName ,mab.name as beneficiaryStatus ,b.mobile_number as mobileNumber ,"
			+ "b.pre_art_number as preArtNumber ,b.art_number as artNumber ,b.date_of_birth as dateOfBirth ,mrs.name as beneficiaryReferralStatus ,b.id as beneficiaryId ,f.name as referedTo, "
			+ "f2.name as referedFrom, bf.id as beneficiaryReferralId,bf.referral_status_id as referralStatusId,si.id as sacepReferralInformationId "
			+ "from soch.beneficiary as b " + "join soch.beneficiary_referral as bf on bf.beneficiary_id = b.id "
			+ "left join soch.art_beneficiary as ab on ab.beneficiary_id = b.id "
			+ "left join soch.master_gender as mg on mg.id = b.gender_id "
			+ "left join soch.address as ad on ad.id = b.address_id "
			+ "left join soch.state as st on st.id = ad.state_id "
			+ "left join soch.district as dt on dt.id = ad.district_id "
			+ "left join soch.master_art_beneficiary_status as mab on mab.id = ab.art_beneficiary_status_id "
			+ "left join soch.master_referral_status as mrs on mrs.id = bf.referral_status_id "
			+ "left join soch.facility as f on f.id = bf.refered_to "
			+ "left join soch.facility as f2 on f2.id = bf.refered_from "
			+ "left join soch.sacep_referral_information as si on si.beneficiary_referral_id = bf.id "
			+ "where bf.refered_to = :facilityId and b.is_delete = false and bf.referral_status_id in(3,7,8) and (lower(b.age) like %:searchText%  or lower(b.uid) like %:searchText% or lower(b.art_number) like %:searchText% or "
			+ "lower(b.pre_art_number) like %:searchText% or lower(b.mobile_number) like %:searchText% or lower(mg.name) like %:searchText% or lower(st.name) like %:searchText% or lower(dt.name) like %:searchText% or lower(mab.name) like %:searchText% or lower(mrs.name) like %:searchText% or lower(b.first_name) like %:searchText% or lower(b.last_name) like %:searchText% or lower(b.middle_name) like %:searchText% or "
			+ "concat(lower(b.first_name), ' ',lower(b.middle_name), ' ',lower(b.last_name)) like %:searchText% or concat(lower(b.first_name), ' ',lower(b.middle_name)) "
			+ "like %:searchText% or concat(lower(b.first_name), ' ',lower(b.last_name)) like %:searchText% )")
	Page<SacepReferralProjection> searchArtPlusSacepPlanList(@Param("searchText") String searchText,
			@Param("facilityId") Long facilityId, Pageable pageable);

	@Query(nativeQuery = true, value = "select b.first_name as firstName ,b.middle_name as middleName ,b.last_name as lastName ,b.uid as uidNumber ,"
			+ "mg.name as gender,st.name as stateName ,dt.name as districtName ,mab.name as beneficiaryStatus ,b.mobile_number as mobileNumber ,"
			+ "b.pre_art_number as preArtNumber ,b.art_number as artNumber ,b.date_of_birth as dateOfBirth ,mrs.name as beneficiaryReferralStatus ,"
			+ "b.id as beneficiaryId ,f2.name as referedFrom, f.name as referedTo,bf.id as beneficiaryReferralId, bf.referral_status_id  as referralStatusId "
			+ "from soch.beneficiary as b " + "join soch.beneficiary_referral as bf on bf.beneficiary_id = b.id "
			+ "left join soch.art_beneficiary as ab on ab.beneficiary_id = b.id "
			+ "left join soch.master_gender as mg on mg.id = b.gender_id "
			+ "left join soch.address as ad on ad.id = b.address_id "
			+ "left join soch.state as st on st.id = ad.state_id "
			+ "left join soch.district as dt on dt.id = ad.district_id "
			+ "left join soch.master_art_beneficiary_status as mab on mab.id = ab.art_beneficiary_status_id "
			+ "left join soch.master_referral_status as mrs on mrs.id = bf.referral_status_id "
			+ "left join soch.facility as f on f.id = bf.refered_to "
			+ "left join soch.facility as f2 on f2.id = bf.refered_from "
			+ "where bf.referred_to_facility_type_id IN(16,17,31) and bf.refered_to =:facilityId and b.is_delete = false and bf.referral_status_id IN(2,3,6,7,8) order by bf.modified_time desc")
	Page<SacepReferralProjection> findAllArtPlusSacepReferralList(@Param("facilityId") Long facilityId,
			Pageable pageable);

	@Query(nativeQuery = true, value = "select b.first_name as firstName ,b.middle_name as middleName ,b.last_name as lastName ,b.uid as uidNumber ,"
			+ "mg.name as gender,st.name as stateName ,dt.name as districtName ,mab.name as beneficiaryStatus ,b.mobile_number as mobileNumber ,"
			+ "b.pre_art_number as preArtNumber ,b.art_number as artNumber ,b.date_of_birth as dateOfBirth ,mrs.name as beneficiaryReferralStatus ,"
			+ "b.id as beneficiaryId ,f2.name as referedFrom,f.name as referedTo,bf.id as beneficiaryReferralId, bf.referral_status_id  as referralStatusId "
			+ "from soch.beneficiary as b " + "join soch.beneficiary_referral as bf on bf.beneficiary_id = b.id "
			+ "left join soch.art_beneficiary as ab on ab.beneficiary_id = b.id "
			+ "left join soch.master_gender as mg on mg.id = b.gender_id "
			+ "left join soch.address as ad on ad.id = b.address_id "
			+ "left join soch.state as st on st.id = ad.state_id "
			+ "left join soch.district as dt on dt.id = ad.district_id "
			+ "left join soch.master_art_beneficiary_status as mab on mab.id = ab.art_beneficiary_status_id "
			+ "left join soch.master_referral_status as mrs on mrs.id = bf.referral_status_id "
			+ "left join soch.facility as f on f.id = bf.refered_to "
			+ "left join soch.facility as f2 on f2.id = bf.refered_from "
			+ "where bf.referred_to_facility_type_id IN(16,17,31) and bf.refered_to = :facilityId and b.is_delete = false and bf.referral_status_id IN(2,3,6,7,8) and (lower(b.age) like %:searchText%  or lower(b.uid) like %:searchText% or lower(b.art_number) like %:searchText% or lower(f2.name) like %:searchText% or "
			+ "lower(b.pre_art_number) like %:searchText% or lower(b.mobile_number) like %:searchText% or lower(mg.name) like %:searchText% or lower(st.name) like %:searchText% or lower(dt.name) like %:searchText% or lower(mab.name) like %:searchText% or lower(mrs.name) like %:searchText% or lower(b.first_name) like %:searchText% or lower(b.last_name) like %:searchText% or lower(b.middle_name) like %:searchText% or "
			+ "concat(lower(b.first_name), ' ',lower(b.middle_name), ' ',lower(b.last_name)) like %:searchText% or concat(lower(b.first_name), ' ',lower(b.middle_name)) "
			+ "like %:searchText% or concat(lower(b.first_name), ' ',lower(b.last_name)) like %:searchText% )")
	Page<SacepReferralProjection> searchArtPlusSacepReferralList(@Param("searchText") String searchText,
			@Param("facilityId") Long facilityId, Pageable pageable);
	
	@Query(nativeQuery = true, value = "select b.first_name as firstName ,b.middle_name as middleName ,b.last_name as lastName ,b.uid as uidNumber ,\r\n"
			+ "mg.name as gender,st.name as stateName ,dt.name as districtName ,mab.name as beneficiaryStatus ,b.mobile_number as mobileNumber ,\r\n"
			+ "b.pre_art_number as preArtNumber ,b.art_number as artNumber ,b.date_of_birth as dateOfBirth ,mrs.name as beneficiaryReferralStatus,\r\n"
			+ "b.id as beneficiaryId,bf.id as beneficiaryReferralId,f.name as referedTo,f1.name as referedFrom,bf.referral_status_id  as referralStatusId \r\n"
			+ "from soch.beneficiary as b \r\n"
			+ "join soch.beneficiary_referral as bf on bf.beneficiary_id = b.id \r\n"
			+ "left join soch.art_beneficiary as ab on ab.beneficiary_id = b.id \r\n"
			+ "left join soch.master_gender as mg on mg.id = b.gender_id \r\n"
			+ "left join soch.address as ad on ad.id = b.address_id \r\n"
			+ "left join soch.state as st on st.id = ad.state_id \r\n"
			+ "left join soch.district as dt on dt.id = ad.district_id \r\n"
			+ "left join soch.master_art_beneficiary_status as mab on mab.id = ab.art_beneficiary_status_id \r\n"
			+ "left join soch.master_referral_status as mrs on mrs.id = bf.referral_status_id \r\n"
			+ "left join soch.facility as f on f.id = bf.refered_to "
			+ "left join soch.facility as f1 on f1.id = bf.refered_from "
			+ "where bf.refered_to = :facilityId and b.is_delete = false and bf.referral_status_id IN (7,8) and \r\n"
			+ "( lower(b.uid) like lower(:searchValue) or lower(b.pre_art_number) like lower(:searchValue) or lower(b.art_number) like lower(:searchValue) "
			+ "\r\n or lower(concat(b.first_name,' ',b.middle_name,' ',b.last_name)) like lower(:searchValue) or lower(concat(b.first_name,' ',b.middle_name)) like lower(:searchValue) "
			+ "or lower(concat(b.first_name,' ',b.last_name)) like lower(:searchValue) or lower(b.first_name) like lower(:searchValue) or lower(b.middle_name) like lower(:searchValue) "
			+ "or lower(b.last_name) like lower(:searchValue) ) order by bf.modified_time desc")
	Page<SacepReferralProjection> normalSearchSacepReferralOutcomeListForSacep(@Param("facilityId") Long facilityId,
			@Param("searchValue") String searchValue, Pageable pageable);
	
	@Query(nativeQuery = true, value = "select b.first_name as firstName ,b.middle_name as middleName ,b.last_name as lastName ,b.uid as uidNumber ,\r\n"
			+ "mg.name as gender,st.name as stateName ,dt.name as districtName ,mab.name as beneficiaryStatus ,b.mobile_number as mobileNumber ,\r\n"
			+ "b.pre_art_number as preArtNumber ,b.art_number as artNumber ,b.date_of_birth as dateOfBirth ,mrs.name as beneficiaryReferralStatus,\r\n"
			+ "b.id as beneficiaryId,bf.id as beneficiaryReferralId,f.name as referedTo,f1.name as referedFrom,bf.referral_status_id  as referralStatusId \r\n"
			+ "from soch.beneficiary as b \r\n"
			+ "join soch.beneficiary_referral as bf on bf.beneficiary_id = b.id \r\n"
			+ "left join soch.art_beneficiary as ab on ab.beneficiary_id = b.id \r\n"
			+ "left join soch.master_gender as mg on mg.id = b.gender_id \r\n"
			+ "left join soch.address as ad on ad.id = b.address_id \r\n"
			+ "left join soch.state as st on st.id = ad.state_id \r\n"
			+ "left join soch.district as dt on dt.id = ad.district_id \r\n"
			+ "left join soch.master_art_beneficiary_status as mab on mab.id = ab.art_beneficiary_status_id \r\n"
			+ "left join soch.master_referral_status as mrs on mrs.id = bf.referral_status_id \r\n"
			+ "left join soch.facility as f on f.id = bf.refered_to "
			+ "left join soch.facility as f1 on f1.id = bf.refered_from "
			+ "where bf.refered_to = :facilityId and b.is_delete = false and bf.referral_status_id IN (7,8) order by bf.modified_time desc")
	Page<SacepReferralProjection> findSacepReferralOutcomeListForSacep(@Param("facilityId") Long facilityId, Pageable pageable);

	@Query(nativeQuery = true, value = "select b.first_name as firstName ,b.middle_name as middleName ,b.last_name as lastName ,b.uid as uidNumber ,\r\n"
			+ "mg.name as gender,st.name as stateName ,dt.name as districtName ,mab.name as beneficiaryStatus ,b.mobile_number as mobileNumber ,\r\n"
			+ "b.pre_art_number as preArtNumber ,b.art_number as artNumber ,b.date_of_birth as dateOfBirth ,mrs.name as beneficiaryReferralStatus,\r\n"
			+ "b.id as beneficiaryId,bf.id as beneficiaryReferralId,f.name as referedTo,f1.name as referedFrom,bf.referral_status_id  as referralStatusId \r\n"
			+ "from soch.beneficiary as b \r\n"
			+ "join soch.beneficiary_referral as bf on bf.beneficiary_id = b.id \r\n"
			+ "left join soch.art_beneficiary as ab on ab.beneficiary_id = b.id \r\n"
			+ "left join soch.master_gender as mg on mg.id = b.gender_id \r\n"
			+ "left join soch.address as ad on ad.id = b.address_id \r\n"
			+ "left join soch.state as st on st.id = ad.state_id \r\n"
			+ "left join soch.district as dt on dt.id = ad.district_id \r\n"
			+ "left join soch.master_art_beneficiary_status as mab on mab.id = ab.art_beneficiary_status_id \r\n"
			+ "left join soch.master_referral_status as mrs on mrs.id = bf.referral_status_id \r\n"
			+ "left join soch.facility as f on f.id = bf.refered_to "
			+ "left join soch.facility as f1 on f1.id = bf.refered_from "
			+ "where bf.refered_to = :facilityId and b.is_delete = false and bf.referral_status_id=8 and \r\n"
			+ "( lower(b.uid) like lower(:searchValue) or lower(b.pre_art_number) like lower(:searchValue) or lower(b.art_number) like lower(:searchValue) "
			+ "\r\n or lower(concat(b.first_name,' ',b.middle_name,' ',b.last_name)) like lower(:searchValue) ) order by bf.modified_time desc")
	Page<SacepReferralProjection> normalSearchSacepReviewList(@Param("facilityId") Long facilityId,
			@Param("searchValue") String searchValue, Pageable pageable);
	
	@Query(nativeQuery = true, value = "select b.first_name as firstName ,b.middle_name as middleName ,b.last_name as lastName ,b.uid as uidNumber ,\r\n"
			+ "mg.name as gender,st.name as stateName ,dt.name as districtName ,mab.name as beneficiaryStatus ,b.mobile_number as mobileNumber ,\r\n"
			+ "b.pre_art_number as preArtNumber ,b.art_number as artNumber ,b.date_of_birth as dateOfBirth ,mrs.name as beneficiaryReferralStatus,\r\n"
			+ "b.id as beneficiaryId,bf.id as beneficiaryReferralId,f.name as referedTo,f1.name as referedFrom,bf.referral_status_id  as referralStatusId \r\n"
			+ "from soch.beneficiary as b \r\n"
			+ "join soch.beneficiary_referral as bf on bf.beneficiary_id = b.id \r\n"
			+ "left join soch.art_beneficiary as ab on ab.beneficiary_id = b.id \r\n"
			+ "left join soch.master_gender as mg on mg.id = b.gender_id \r\n"
			+ "left join soch.address as ad on ad.id = b.address_id \r\n"
			+ "left join soch.state as st on st.id = ad.state_id \r\n"
			+ "left join soch.district as dt on dt.id = ad.district_id \r\n"
			+ "left join soch.master_art_beneficiary_status as mab on mab.id = ab.art_beneficiary_status_id \r\n"
			+ "left join soch.master_referral_status as mrs on mrs.id = bf.referral_status_id \r\n"
			+ "left join soch.facility as f on f.id = bf.refered_to "
			+ "left join soch.facility as f1 on f1.id = bf.refered_from "
			+ "where bf.refered_to = :facilityId and bf.referral_status_id=8 order by bf.modified_time desc")
	Page<SacepReferralProjection> findSacepReviewList(@Param("facilityId") Long facilityId, Pageable pageable);

	@Query(nativeQuery = true , value = " select b.id as id ,b.uid as uid ,b.first_name as firstName, b.middle_name as MiddleName , b.last_name as lastName, \r\n" + 
			"b.date_of_birth as dateOfBirth ,b.age as age,b.mobile_number as mobileNumber ,b.regular_partners as regularPartner ,\r\n" + 
			"b.reg_date as regDate,b.is_living_in_rel as livingInRelation,mg.id as genderId ,mms.id as maritalStatusId, \r\n" + 
			"mdl.id as educationLevelId , mo.id as occupationId,a.address_line_one as addressLineOne , a.address_line_two as addressLineTwo,\r\n" + 
			"a.town_id as townId ,a.district_id as districtId, a.state_id as stateId,a.country as country,\r\n" + 
			"a.pincode as pincode, a.taluk as taluk ,a.subdistrict_id as subdistrictId , b.other_employment_status as otherEmploymentStatus \r\n" + 
			"from soch.beneficiary b \r\n" + 
			"left join soch.master_gender mg on mg.id = b.gender_id\r\n" + 
			"left join soch.master_marital_status mms on mms.id = b.marital_status_id\r\n" + 
			"left join soch.master_education_level mdl on mdl.id = b.education_level_id\r\n" + 
			"left join soch.master_occupation mo on mo.id = b.occupation_id\r\n" + 
			"left join soch.address a on a.id = b.address_id\r\n" + 
			"where b.id = :id ")
	BeneficiaryDetailsProjection getMasterBeneficiaryDetails(@Param("id") Long id);

	@Query(nativeQuery = true, value = " select b.id as id ,b.uid as uid ,b.first_name as firstName, b.middle_name as MiddleName , b.last_name as lastName,  \r\n"
			+ "b.date_of_birth as dateOfBirth ,b.age as age,b.mobile_number as mobileNumber ,tob.regular_partners as regularPartner , \r\n"
			+ "b.reg_date as regDate,b.is_living_in_rel as livingInRelation,mg.id as genderId ,mms.id as maritalStatusId,  \r\n"
			+ "mdl.id as educationLevelId , mo.id as occupationId,a.address_line_one as addressLineOne , a.address_line_two as addressLineTwo, \r\n"
			+ "a.town_id as townId ,a.district_id as districtId, a.state_id as stateId,a.country as country, \r\n"
			+ "a.pincode as pincode, a.taluk as taluk ,a.subdistrict_id as subdistrictId , b.other_employment_status as otherEmploymentStatus, \r\n"
			+ "tm.typology_id as typologyId , tob.number_of_partners as numberOfPartners\r\n"
			+ "from soch.beneficiary b \r\n" + "left join soch.master_gender mg on mg.id = b.gender_id \r\n"
			+ "left join soch.master_marital_status mms on mms.id = b.marital_status_id \r\n"
			+ "left join soch.master_education_level mdl on mdl.id = b.education_level_id \r\n"
			+ "left join soch.master_occupation mo on mo.id = b.occupation_id \r\n"
			+ "left join soch.address a on a.id = b.address_id \r\n"
			+ "join soch.ti_ost_beneficiary tob on tob.beneficiary_id = b.id\r\n"
			+ "join soch.typology_master tm on tm.typology_id = tob.master_hrg_primary_id\r\n" + "where b.id = :id")
	BeneficiaryDetailsProjection getMasterBeneficiaryDetailsForOst(@Param("id") Long id);

// General MedicalRecord Mobile  Query
	
	@Query(nativeQuery = true, value = "SELECT * FROM (\r\n" + 
			"SELECT b.id AS id, b.uid AS uid, b.first_name AS firstName, b.last_name AS lastName,date_part('year',AGE(b.date_of_birth)) as age, mg.name AS gender, reg_date AS regDate\r\n" + 
			"FROM soch.beneficiary b\r\n" + 
			"LEFT JOIN soch.master_gender mg ON mg.id = b.gender_id\r\n" + 
			"WHERE b.id = :beneficiaryId\r\n" + 
			") a1\r\n" + 
			"FULL JOIN (\r\n" + 
			"SELECT bvr.weight AS weight \r\n" + 
			"FROM soch.beneficiary_visit_register bvr\r\n" + 
			"WHERE bvr.id = (\r\n" + 
			"SELECT max(bvr1.id) FROM soch.beneficiary_visit_register bvr1\r\n" + 
			"WHERE bvr1.weight IS NOT NULL\r\n" + 
			"AND bvr1.beneficiary_id = bvr.beneficiary_id\r\n" + 
			") AND bvr.beneficiary_id = :beneficiaryId  ) a2 ON true\r\n" + 
			"FULL JOIN (\r\n" + 
			"SELECT bvr2.height AS height\r\n" + 
			"FROM soch.beneficiary_visit_register bvr2\r\n" + 
			"WHERE bvr2.id = (\r\n" + 
			"SELECT max(bvr3.id) FROM soch.beneficiary_visit_register bvr3\r\n" + 
			"WHERE bvr3.height IS NOT NULL\r\n" + 
			"AND bvr3.beneficiary_id = bvr2.beneficiary_id\r\n" + 
			") AND bvr2.beneficiary_id = :beneficiaryId  ) a3 ON true")
	PersonalMedicalRecordGeneralProjection getBasicBeneficiaryMobileDetails(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "SELECT * from \n"
			+ "((Select coalesce(count(b.id),0) as noOfPartnersLinked FROM soch.beneficiary_family_details b\n"
			+ "where (b.is_alive = true OR b.is_alive is NULL)\n"
			+ "and b.beneficiary_id = :beneficiaryId)\n"
			+ " ) a\n"
			+ "cross join (\n"
			+ "SELECT coalesce(count(b1.id),0) as noOfPartnersHivTested FROM soch.beneficiary_family_details b1\n"
			+ "where (b1.is_alive = true OR b1.is_alive is NULL)\n"
			+ "and b1.hiv_status_id in (1,2,3)\n"
			+ "and b1.beneficiary_id = :beneficiaryId\n"
			+ ") a1\n"
			+ "cross join (\n"
			+ "SELECT coalesce(count(b2.id),0) as noOfPartnersHivReactive FROM soch.beneficiary_family_details b2\n"
			+ "where (b2.is_alive = true OR b2.is_alive is NULL)\n"
			+ "and b2.hiv_status_id =2 \n"
			+ "and b2.beneficiary_id = :beneficiaryId\n"
			+ ") a2")
	PersonalMedicalRecordGeneralProjection getNoOfPartnerDetails(@Param("beneficiaryId") Long beneficiaryId);
	
	
	@Modifying
	@Transactional
	@Query(value="Update soch.beneficiary_mobile_login_otp set beneficiary_id=:beneficiaryId, device_token=:deviceToken,device_os_type=:deviceType where mobile_number=:mobile",nativeQuery = true)
	int updateBeneficiaryIdAndFcmDeviceTokenAndType(@Param("beneficiaryId")Long beneficiaryId, @Param("deviceToken")String deviceToken,@Param("deviceType")String deviceType,@Param("mobile")String mobile);
	
	@Query(nativeQuery = true , value = " select b.id as beneficiaryId,b.uid as uid,b.first_name as firstName,b.middle_name as middleName,\r\n" + 
			"b.last_name as lastName,b.art_number as artNumber,bg.name as gender, \r\n" + 
			"b.date_of_birth as dateOfBirth,b.mobile_number as mobileNumber,f.name as facility,\r\n" + 
			"f.id as facilityId,ft.id as facilityTypeId, ft.facility_type_name as facilityType \r\n" + 
			"from soch.beneficiary b \r\n" + 
			"join soch.master_gender bg on bg.id = b.gender_id \r\n" + 
			"join (select MAX(id) as bfmid, beneficiary_id from soch.beneficiary_facility_mapping \r\n" + 
			"where facility_id =:facilityId group by beneficiary_id) as resultTable on resultTable.beneficiary_id = b.id \r\n" + 
			"join soch.beneficiary_facility_mapping as bfm on resultTable.beneficiary_id = bfm.beneficiary_id and resultTable.bfmid = bfm.id \r\n" + 
			"join soch.facility f on f.id = bfm.facility_id \r\n" + 
			"join soch.facility_type ft on ft.id = f.facility_type_id\r\n" + 
			"left join soch.ictc_beneficiary ib on ib.beneficiary_id = b.id\r\n" + 
			"left join soch.art_beneficiary ab on ab.beneficiary_id = b.id\r\n" + 
			"left join soch.ti_ost_beneficiary tob on tob.beneficiary_id = b.id\r\n" +
			"where  b.is_delete = false and bfm.is_delete = false \r\n" + 
			"and b.mobile_number = :searchText\r\n" + 
			"and b.id not in (select beneficiary_id from soch.ictc_beneficiary where beneficiary_id=b.id and is_deleted=true)\r\n" + 
			"and b.id not in (select beneficiary_id from soch.art_beneficiary where beneficiary_id=b.id and is_delete=true)\r\n" +
			"and b.id not in (select beneficiary_id from soch.ti_ost_beneficiary where beneficiary_id=b.id and is_delete=true)\r\n" +
			"and (exists ( select 1 from soch.ictc_beneficiary where beneficiary_id=b.id)or\r\n" + 
			"	exists ( select 1 from soch.art_beneficiary where beneficiary_id=b.id)or\r\n" +
			"	exists ( select 1 from soch.ti_ost_beneficiary where beneficiary_id=b.id)or\r\n" +
			"   exists ( select 1 from soch.dsrc_beneficiary where beneficiary_id=b.id))\r\n" +
			"order by b.modified_time desc ")
	List<UidMergeProjection> getSearchInBeneficiariesByMobileNoForTi(@Param("searchText") String searchText, @Param("facilityId") Integer facilityId);

	@Query(nativeQuery = true , value = " select b.id as beneficiaryId,b.uid as uid,b.first_name as firstName,b.middle_name as middleName,\r\n" + 
			"b.last_name as lastName,b.art_number as artNumber,bg.name as gender,\r\n" + 
			"b.date_of_birth as dateOfBirth,b.mobile_number as mobileNumber,f.name as facility,\r\n" + 
			"f.id as facilityId,ft.id as facilityTypeId,ft.facility_type_name as facilityType \r\n" + 
			"from soch.beneficiary b \r\n" + 
			"join soch.master_gender bg on bg.id = b.gender_id \r\n" + 
			"join (select MAX(id) as bfmid, beneficiary_id from soch.beneficiary_facility_mapping \r\n" + 
			"where facility_id =:facilityId group by beneficiary_id) as resultTable on resultTable.beneficiary_id = b.id \r\n" + 
			"join soch.beneficiary_facility_mapping as bfm on resultTable.beneficiary_id = bfm.beneficiary_id and resultTable.bfmid = bfm.id \r\n" + 
			"join soch.facility f on f.id = bfm.facility_id\r\n" + 
			"join soch.facility_type ft on ft.id = f.facility_type_id \r\n" + 
			"left join soch.ictc_beneficiary ib on ib.beneficiary_id = b.id\r\n" + 
			"left join soch.art_beneficiary ab on ab.beneficiary_id = b.id\r\n" +
			"left join soch.ti_ost_beneficiary tob on tob.beneficiary_id = b.id\r\n" +
			"where  b.is_delete = false and bfm.is_delete = false \r\n" + 
			"and b.uid ilike concat(:searchText, '%') \r\n" + 
			"and b.id not in (select beneficiary_id from soch.ictc_beneficiary where beneficiary_id=b.id and is_deleted=true)\r\n" + 
			"and b.id not in (select beneficiary_id from soch.art_beneficiary where beneficiary_id=b.id and is_delete=true)\r\n" +
			"and b.id not in (select beneficiary_id from soch.ti_ost_beneficiary where beneficiary_id=b.id and is_delete=true)\r\n" +
			"and (exists ( select 1 from soch.ictc_beneficiary where beneficiary_id=b.id)or\r\n" + 
			"	exists ( select 1 from soch.art_beneficiary where beneficiary_id=b.id)or\r\n" +
			"	exists ( select 1 from soch.ti_ost_beneficiary where beneficiary_id=b.id)or\r\n" +
			"   exists ( select 1 from soch.dsrc_beneficiary where beneficiary_id=b.id))\r\n" +
			"order by b.modified_time desc ")
	List<UidMergeProjection> getSearchInBeneficiariesByUidForTi(@Param("searchText") String searchText, @Param("facilityId") Integer facilityId);

	@Query(value = " select b.id as beneficiaryId,b.uid as uid,b.first_name as firstName,b.middle_name as middleName,\r\n" + 
			"b.last_name as lastName,b.art_number as artNumber,bg.name as gender,\r\n" + 
			"b.date_of_birth as dateOfBirth,b.mobile_number as mobileNumber,f.name as facility,\r\n" + 
			"f.id as facilityId,ft.id as facilityTypeId,ft.facility_type_name as facilityType \r\n" + 
			"from soch.beneficiary b \r\n" + 
			"join soch.master_gender bg on bg.id = b.gender_id\r\n" + 
			"join (select MAX(id) as bfmid, beneficiary_id from soch.beneficiary_facility_mapping \r\n" + 
			"where facility_id =:facilityId group by beneficiary_id) as resultTable on resultTable.beneficiary_id = b.id \r\n" + 
			"join soch.beneficiary_facility_mapping as bfm on resultTable.beneficiary_id = bfm.beneficiary_id and resultTable.bfmid = bfm.id \r\n" + 
			"join soch.facility f on f.id = bfm.facility_id\r\n" + 
			"join soch.facility_type ft on ft.id = f.facility_type_id\r\n" + 
			"left join soch.ictc_beneficiary ib on ib.beneficiary_id = b.id\r\n" + 
			"left join soch.art_beneficiary ab on ab.beneficiary_id = b.id \r\n" +
			"left join soch.ti_ost_beneficiary tob on tob.beneficiary_id = b.id \r\n" +
			"where  b.is_delete = false and bfm.is_delete = false \r\n" + 
			"and (tsv_artvalues @@ to_tsquery(:searchText) or b.ti_benf_search_str ilike :searchText ) \r\n" + 
			"and b.id not in (select beneficiary_id from soch.ictc_beneficiary where beneficiary_id=b.id and is_deleted=true)\r\n" + 
			"and b.id not in (select beneficiary_id from soch.art_beneficiary where beneficiary_id=b.id and is_delete=true)\r\n" +
			"and b.id not in (select beneficiary_id from soch.ti_ost_beneficiary where beneficiary_id=b.id and is_delete=true)\r\n" +
			"and (exists ( select 1 from soch.ictc_beneficiary where beneficiary_id=b.id)or\r\n" + 
			"	exists ( select 1 from soch.art_beneficiary where beneficiary_id=b.id)or\r\n" + 
			"	exists ( select 1 from soch.ti_ost_beneficiary where beneficiary_id=b.id))\r\n" +			
			"order by b.modified_time desc " ,nativeQuery = true)
	List<UidMergeProjection> getSearchInBeneficiariesWithTsVectorForTi(@Param("searchText") String searchText, @Param("facilityId") Integer facilityId);
	
	@Query(value = " select b.id as beneficiaryId,b.uid as uid,b.first_name as firstName,b.middle_name as middleName, \r\n" + 
			"b.last_name as lastName,b.art_number as artNumber,bg.name as gender,  \r\n" + 
			"b.date_of_birth as dateOfBirth,b.mobile_number as mobileNumber,f.name as facility, \r\n" + 
			"f.id as facilityId,ft.id as facilityTypeId, ft.facility_type_name as facilityType  \r\n" + 
			"from soch.beneficiary b  \r\n" + 
			"join soch.master_gender bg on bg.id = b.gender_id  \r\n" + 
			"join (select MAX(id) as bfmid, beneficiary_id from soch.beneficiary_facility_mapping  \r\n" + 
			"where facility_id =:facilityId group by beneficiary_id) as resultTable on resultTable.beneficiary_id = b.id  \r\n" + 
			"join soch.beneficiary_facility_mapping as bfm on resultTable.beneficiary_id = bfm.beneficiary_id and resultTable.bfmid = bfm.id  \r\n" + 
			"join soch.facility f on f.id = bfm.facility_id  \r\n" + 
			"join soch.facility_type ft on ft.id = f.facility_type_id \r\n" + 
			"left join soch.ictc_beneficiary ib on ib.beneficiary_id = b.id \r\n" + 
			"left join soch.art_beneficiary ab on ab.beneficiary_id = b.id \r\n" + 
			"left join soch.ti_ost_beneficiary tob on tob.beneficiary_id = b.id\r\n" + 
			"where  b.is_delete = false and bfm.is_delete = false  \r\n" + 
			"and (b.mobile_number ilike %:searchText%  or b.first_name ilike %:searchText%  or b.middle_name ilike %:searchText% \r\n" + 
			"or b.last_name ilike %:searchText% or  CONCAT( b.first_name,' ', b.last_name ) ilike %:searchText% or b.uid ilike %:searchText%)\r\n" + 
			"and b.id not in (select beneficiary_id from soch.ictc_beneficiary where beneficiary_id=b.id and is_deleted=true) \r\n" + 
			"and b.id not in (select beneficiary_id from soch.art_beneficiary where beneficiary_id=b.id and is_delete=true)\r\n" + 
			"and b.id not in (select beneficiary_id from soch.ti_ost_beneficiary where beneficiary_id=b.id and is_delete=true)\r\n" + 
			"and (exists ( select 1 from soch.ictc_beneficiary where beneficiary_id=b.id)or \r\n" + 
			"	exists ( select 1 from soch.art_beneficiary where beneficiary_id=b.id)or\r\n" + 
			"	exists ( select 1 from soch.ti_ost_beneficiary where beneficiary_id=b.id))\r\n" + 
			"order by b.modified_time desc  ", nativeQuery = true)
	List<UidMergeProjection> getSearchIctcBeneficiariesForTi(@Param("searchText") String searchText, @Param("facilityId") Integer facilityId);

	@Query(value = " select b.id as beneficiaryId,b.uid as uid,b.first_name as firstName,b.middle_name as middleName,\r\n" + 
			"b.last_name as lastName,b.art_number as artNumber,bg.name as gender,\r\n" + 
			"b.date_of_birth as dateOfBirth,b.mobile_number as mobileNumber,f.name as facility,\r\n" + 
			"f.id as facilityId,ft.id as facilityTypeId, ft.facility_type_name as facilityType \r\n" + 
			"from soch.beneficiary b \r\n" + 
			"join soch.master_gender bg on bg.id = b.gender_id \r\n" + 
			"join (select MAX(id) as bfmid, beneficiary_id from soch.beneficiary_facility_mapping \r\n" + 
			"where facility_id =:facilityId group by beneficiary_id) as resultTable on resultTable.beneficiary_id = b.id\r\n" + 
			"join soch.beneficiary_facility_mapping as bfm on resultTable.beneficiary_id = bfm.beneficiary_id and resultTable.bfmid = bfm.id \r\n" + 
			"join soch.facility f on f.id = bfm.facility_id\r\n" + 
			"join soch.facility_type ft on ft.id = f.facility_type_id \r\n" + 
			"where b.is_delete = false and bfm.is_delete = false \r\n" + 
			"and (b.mobile_number ilike %:searchText%  or b.first_name ilike %:searchText%  or b.middle_name ilike %:searchText% \r\n" + 
			"or b.last_name ilike %:searchText% or  CONCAT( b.first_name,' ', b.last_name ) ilike %:searchText% or b.uid ilike %:searchText%) \r\n" + 
			"order by b.modified_time desc ", nativeQuery = true )
	List<UidMergeProjection> getSearchIctcBeneficiaries(@Param("searchText") String searchText, @Param("facilityId") Integer facilityId);

    @Query(value = " select b.id as beneficiaryId,b.uid as uid,b.first_name as firstName,b.middle_name as middleName,\r\n" + 
			"b.last_name as lastName,b.art_number as artNumber,bg.name as gender,\r\n" + 
			"b.date_of_birth as dateOfBirth,b.mobile_number as mobileNumber,f.name as facility,\r\n" + 
			"f.id as facilityId,ft.id as facilityTypeId,ft.facility_type_name as facilityType \r\n" + 
			"from soch.beneficiary b \r\n" + 
			"join soch.master_gender bg on bg.id = b.gender_id\r\n" + 
			"join (select MAX(id) as bfmid, beneficiary_id from soch.beneficiary_facility_mapping \r\n" + 
			"where facility_id =:facilityId group by beneficiary_id) as resultTable on resultTable.beneficiary_id = b.id \r\n" + 
			"join soch.beneficiary_facility_mapping as bfm on resultTable.beneficiary_id = bfm.beneficiary_id and resultTable.bfmid = bfm.id \r\n" + 
			"join soch.facility f on f.id = bfm.facility_id\r\n" + 
			"join soch.facility_type ft on ft.id = f.facility_type_id\r\n" + 
			"left join soch.ictc_beneficiary ib on ib.beneficiary_id = b.id\r\n" + 
			"left join soch.art_beneficiary ab on ab.beneficiary_id = b.id \r\n" +
			"left join soch.ti_ost_beneficiary tob on tob.beneficiary_id = b.id \r\n" +
			"where  b.is_delete = false and bfm.is_delete = false \r\n" + 
			"and (b.benf_search_str ilike %:searchText%) \r\n" + 
			"and b.id not in (select beneficiary_id from soch.ictc_beneficiary where beneficiary_id=b.id and is_deleted=true)\r\n" + 
			"and b.id not in (select beneficiary_id from soch.art_beneficiary where beneficiary_id=b.id and is_delete=true)\r\n" +
			"and b.id not in (select beneficiary_id from soch.ti_ost_beneficiary where beneficiary_id=b.id and is_delete=true)\r\n" +
			"and (exists ( select 1 from soch.ictc_beneficiary where beneficiary_id=b.id)or\r\n" + 
			"	exists ( select 1 from soch.art_beneficiary where beneficiary_id=b.id)or\r\n" + 
			"	exists ( select 1 from soch.ti_ost_beneficiary where beneficiary_id=b.id)or\r\n"+
			"   exists ( select 1 from soch.dsrc_beneficiary where beneficiary_id=b.id))\r\n" + 
			"order by b.modified_time desc " ,nativeQuery = true)
	List<UidMergeProjection> getSearchInBeneficiariesWithForDsrc(@Param("searchText") String searchText, @Param("facilityId") Integer facilityId);

}
