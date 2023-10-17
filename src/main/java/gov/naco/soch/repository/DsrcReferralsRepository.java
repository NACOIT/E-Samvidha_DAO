package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.BeneficiaryReferral;
import gov.naco.soch.projection.DsrcBeneficiaryProjection;
import gov.naco.soch.projection.DsrcBeneficiaryReferralProjection;
import gov.naco.soch.projection.DsrcInwardReferralProjection;
import gov.naco.soch.projection.DsrcReferralProjection;

@Repository
public interface DsrcReferralsRepository extends JpaRepository<BeneficiaryReferral, Long>, CustomRepository {

    @Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName,b.mobile_number as mobileNumber,b.date_of_birth as dateOfBirth,bg.name as gender,br.refer_date as dateOfReferral, br.id as referralId, mrs.name as referralStatus, f.name as referredFacility, ft.facility_type_name as facilityType from soch.beneficiary b join soch.beneficiary_referral br on br.beneficiary_id = b.id  and br.refered_to=:facilityId and br.is_delete=false join soch.master_gender bg on b.gender_id = bg.id  join soch.master_referral_status mrs on mrs.id=br.referral_status_id join soch.facility f on f.id=br.refered_from left join soch.facility_type ft on ft.id=f.facility_type_id where b.is_delete = false")
	Page<DsrcInwardReferralProjection> findDsrcInwardReferrals(@Param("facilityId") Long facilityId, Pageable pageable);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName,b.mobile_number as mobileNumber,b.date_of_birth as dateOfBirth,bg.name as gender,br.refer_date as dateOfReferral, br.id as referralId, mrs.name as referralStatus, f.name as referredFacility, ft.facility_type_name as facilityType from soch.beneficiary b join soch.beneficiary_referral br on br.beneficiary_id = b.id  and br.refered_to=:facilityId and br.is_delete=false join soch.master_gender bg on b.gender_id = bg.id  join soch.master_referral_status mrs on mrs.id=br.referral_status_id join soch.facility f on f.id=br.refered_from left join soch.facility_type ft on ft.id=f.facility_type_id where b.is_delete = false and b.mobile_number =:searchParam ")
	Page<DsrcInwardReferralProjection> searchDsrcInwardRefByMobile(@Param("facilityId") Long facilityId,
			Pageable pageable, @Param("searchParam") String searchParam);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName,b.mobile_number as mobileNumber,b.date_of_birth as dateOfBirth,bg.name as gender,br.refer_date as dateOfReferral, br.id as referralId, mrs.name as referralStatus, f.name as referredFacility, ft.facility_type_name as facilityType from soch.beneficiary b join soch.beneficiary_referral br on br.beneficiary_id = b.id  and br.refered_to=:facilityId and br.is_delete=false join soch.master_gender bg on b.gender_id = bg.id  join soch.master_referral_status mrs on mrs.id=br.referral_status_id join soch.facility f on f.id=br.refered_from left join soch.facility_type ft on ft.id=f.facility_type_id where b.is_delete = false and b.uid =:searchParam ")
	Page<DsrcInwardReferralProjection> searchDsrcInwardRefByUid(@Param("facilityId") Long facilityId, Pageable pageable,
			@Param("searchParam") String searchParam);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName,b.mobile_number as mobileNumber,b.date_of_birth as dateOfBirth,bg.name as gender,br.refer_date as dateOfReferral, br.id as referralId, mrs.name as referralStatus, f.name as referredFacility, ft.facility_type_name as facilityType from soch.beneficiary b join soch.beneficiary_referral br on br.beneficiary_id = b.id  and br.refered_to=:facilityId and br.is_delete=false join soch.master_gender bg on b.gender_id = bg.id  join soch.master_referral_status mrs on mrs.id=br.referral_status_id join soch.facility f on f.id=br.refered_from left join soch.facility_type ft on ft.id=f.facility_type_id where b.is_delete = false and b.benf_search_str ilike :searchParam ")
	Page<DsrcInwardReferralProjection> searchBasicDsrcInwardReferrals(@Param("facilityId") Long facilityId,
			Pageable pageable, @Param("searchParam") String searchParam);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, f.name as referredToFacility, concat(b.first_name, ' ', b.last_name) as name, bg.name as sex, \r\n"
			+ "b.date_of_birth as dateOfBirth, b.mobile_number as mobileNumber, br.refer_date as dateOfReferral, mhs.name as hivStatus, mrs.name as referralStatus \r\n"
			+ "from soch.beneficiary b \r\n" + "join soch.beneficiary_referral br on br.beneficiary_id = b.id \r\n"
			+ "join soch.facility f on f.id = br.refered_to \r\n"
			+ "join soch.dsrc_beneficiary ab on ab.beneficiary_id = b.id \r\n"
			+ "join soch.master_gender bg on bg.id = b.gender_id \r\n"
			+ "left join soch.master_hiv_status mhs on mhs.id = b.hiv_status_id \r\n"
			+ "join soch.master_referral_status mrs on mrs.id = br.referral_status_id \r\n"
			+ "where ab.facility_id =:facilityId and f.facility_type_id in(:referedTo) and br.referral_status_id =:referralStatusId and ab.is_delete = false \r\n"
			+ "and br.refer_date >=:currentDateMinusSeven and (b.benf_search_str ilike %:searchParam% or concat(b.first_name, ' ', b.last_name) ilike %:searchParam%) ")
	Page<DsrcBeneficiaryReferralProjection> findDsrcReferralsReferred(@Param("facilityId") Long facilityId,
			@Param("referedTo") List<Integer> referedTo, @Param("referralStatusId") Integer referralStatusId,
			@Param("searchParam") String searchParam, Pageable pageable,
			@Param("currentDateMinusSeven") LocalDate currentDateMinusSeven);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, f.name as referredToFacility, concat(b.first_name, ' ', b.last_name) as name, bg.name as sex, \r\n"
			+ "b.date_of_birth as dateOfBirth, b.mobile_number as mobileNumber, br.refer_date as dateOfReferral, mhs.name as hivStatus, mrs.name as referralStatus \r\n"
			+ "from soch.beneficiary b \r\n" + "join soch.beneficiary_referral br on br.beneficiary_id = b.id \r\n"
			+ "join soch.facility f on f.id = br.refered_to \r\n"
			+ "join soch.dsrc_beneficiary ab on ab.beneficiary_id = b.id \r\n"
			+ "join soch.master_gender bg on bg.id = b.gender_id \r\n"
			+ "left join soch.master_hiv_status mhs on mhs.id = b.hiv_status_id \r\n"
			+ "join soch.master_referral_status mrs on mrs.id = br.referral_status_id \r\n"
			+ "where ab.facility_id =:facilityId and f.facility_type_id in(:referedTo) and br.referral_status_id =:referralStatusId and ab.is_delete = false \r\n"
			+ "and br.refer_date <:currentDateMinusSeven and (b.benf_search_str ilike %:searchParam% or concat(b.first_name, ' ', b.last_name) ilike %:searchParam%) ")
	Page<DsrcBeneficiaryReferralProjection> findDsrcReferralsPending(@Param("facilityId") Long facilityId,
			@Param("referedTo") List<Integer> referedTo, @Param("referralStatusId") Integer referralStatusId,
			@Param("searchParam") String searchParam, Pageable pageable,
			@Param("currentDateMinusSeven") LocalDate currentDateMinusSeven);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, f.name as referredToFacility, concat(b.first_name, ' ', b.last_name) as name, bg.name as sex, \r\n"
			+ "b.date_of_birth as dateOfBirth, b.mobile_number as mobileNumber, br.refer_date as dateOfReferral, mhs.name as hivStatus, mrs.name as referralStatus \r\n"
			+ "from soch.beneficiary b \r\n" + "join soch.beneficiary_referral br on br.beneficiary_id = b.id \r\n"
			+ "join soch.facility f on f.id = br.refered_to \r\n"
			+ "join soch.dsrc_beneficiary ab on ab.beneficiary_id = b.id \r\n"
			+ "join soch.master_gender bg on bg.id = b.gender_id \r\n"
			+ "left join soch.master_hiv_status mhs on mhs.id = b.hiv_status_id \r\n"
			+ "join soch.master_referral_status mrs on mrs.id = br.referral_status_id \r\n"
			+ "where ab.facility_id =:facilityId and f.facility_type_id in(:referedTo) and br.referral_status_id =:referralStatusId and ab.is_delete = false \r\n"
			+ "and (b.benf_search_str ilike %:searchParam% or concat(b.first_name, ' ', b.last_name) ilike %:searchParam%) ")
	Page<DsrcBeneficiaryReferralProjection> findDsrcReferralsLinked(@Param("facilityId") Long facilityId,
			@Param("referedTo") List<Integer> referedTo, @Param("referralStatusId") Integer referralStatusId,
			@Param("searchParam") String searchParam, Pageable pageable);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, f.name as referredToFacility, concat(b.first_name, ' ', b.last_name) as name, bg.name as sex, \r\n"
			+ "b.date_of_birth as dateOfBirth, b.mobile_number as mobileNumber, br.refer_date as dateOfReferral, mhs.name as hivStatus, mrs.name as referralStatus \r\n"
			+ "from soch.beneficiary b \r\n" + "join soch.beneficiary_referral br on br.beneficiary_id = b.id \r\n"
			+ "join soch.facility f on f.id = br.refered_to \r\n"
			+ "join soch.dsrc_beneficiary ab on ab.beneficiary_id = b.id \r\n"
			+ "join soch.master_gender bg on bg.id = b.gender_id \r\n"
			+ "left join soch.master_hiv_status mhs on mhs.id = b.hiv_status_id \r\n"
			+ "join soch.master_referral_status mrs on mrs.id = br.referral_status_id \r\n"
			+ "where ab.facility_id =:facilityId and f.facility_type_id in(:referedTo) and br.referral_status_id =:referralStatusId and ab.is_delete = false \r\n"
			+ "and br.refer_date >=:currentDateMinusSeven \r\n"
			+ "and (:fullName = '' or (b.first_name ilike %:fullName% \r\n" + " or b.last_name ilike %:fullName% \r\n"
			+ " or CONCAT( b.first_name,' ', b.last_name ) ilike %:fullName%))"
			+ " and (:dsrcCode = '' or b.dsrc_beneficiary_code ilike %:dsrcCode%) \r\n"
			+ " and (:mobilenumber = '' or b.mobile_number ilike %:mobilenumber%) \r\n"
			+ " and (:uid = '' or b.uid ilike %:uid%) \r\n" + " and (:gender = 0 or b.gender_id = :gender)")
	Page<DsrcBeneficiaryReferralProjection> findDsrcReferralsAdvancedReferred(@Param("facilityId") Long facilityId,
			@Param("referedTo") List<Integer> referedTo, @Param("referralStatusId") Integer referralStatusId,
			@Param("fullName") String fullName, @Param("mobilenumber") String mobilenumber,
			@Param("gender") Integer gender, @Param("dsrcCode") String dsrcCode, @Param("uid") String uid,
			Pageable pageable, @Param("currentDateMinusSeven") LocalDate currentDateMinusSeven);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, f.name as referredToFacility, concat(b.first_name, ' ', b.last_name) as name, bg.name as sex, \r\n"
			+ "b.date_of_birth as dateOfBirth, b.mobile_number as mobileNumber, br.refer_date as dateOfReferral, mhs.name as hivStatus, mrs.name as referralStatus \r\n"
			+ "from soch.beneficiary b \r\n" + "join soch.beneficiary_referral br on br.beneficiary_id = b.id \r\n"
			+ "join soch.facility f on f.id = br.refered_to \r\n"
			+ "join soch.dsrc_beneficiary ab on ab.beneficiary_id = b.id \r\n"
			+ "join soch.master_gender bg on bg.id = b.gender_id \r\n"
			+ "left join soch.master_hiv_status mhs on mhs.id = b.hiv_status_id \r\n"
			+ "join soch.master_referral_status mrs on mrs.id = br.referral_status_id \r\n"
			+ "where ab.facility_id =:facilityId and f.facility_type_id in(:referedTo) and br.referral_status_id =:referralStatusId and ab.is_delete = false \r\n"
			+ "and br.refer_date <:currentDateMinusSeven \r\n"
			+ "and (:fullName = '' or (b.first_name ilike %:fullName% \r\n" + " or b.last_name ilike %:fullName% \r\n"
			+ " or CONCAT( b.first_name,' ', b.last_name ) ilike %:fullName%))"
			+ " and (:dsrcCode = '' or b.dsrc_beneficiary_code ilike %:dsrcCode%) \r\n"
			+ " and (:mobilenumber = '' or b.mobile_number ilike %:mobilenumber%) \r\n"
			+ " and (:uid = '' or b.uid ilike %:uid%) \r\n" + " and (:gender = 0 or b.gender_id = :gender)")
	Page<DsrcBeneficiaryReferralProjection> findDsrcReferralsAdvancedPending(@Param("facilityId") Long facilityId,
			@Param("referedTo") List<Integer> referedTo, @Param("referralStatusId") Integer referralStatusId,
			@Param("fullName") String fullName, @Param("mobilenumber") String mobilenumber,
			@Param("gender") Integer gender, @Param("dsrcCode") String dsrcCode, @Param("uid") String uid,
			Pageable pageable, @Param("currentDateMinusSeven") LocalDate currentDateMinusSeven);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, f.name as referredToFacility, concat(b.first_name, ' ', b.last_name) as name, bg.name as sex, \r\n"
			+ "b.date_of_birth as dateOfBirth, b.mobile_number as mobileNumber, br.refer_date as dateOfReferral, mhs.name as hivStatus, mrs.name as referralStatus \r\n"
			+ "from soch.beneficiary b \r\n" + "join soch.beneficiary_referral br on br.beneficiary_id = b.id \r\n"
			+ "join soch.facility f on f.id = br.refered_to \r\n"
			+ "join soch.dsrc_beneficiary ab on ab.beneficiary_id = b.id \r\n"
			+ "join soch.master_gender bg on bg.id = b.gender_id \r\n"
			+ "left join soch.master_hiv_status mhs on mhs.id = b.hiv_status_id \r\n"
			+ "join soch.master_referral_status mrs on mrs.id = br.referral_status_id \r\n"
			+ "where ab.facility_id =:facilityId and f.facility_type_id in(:referedTo) and br.referral_status_id =:referralStatusId and ab.is_delete = false \r\n"
			+ "and (:fullName = '' or (b.first_name ilike %:fullName% \r\n" + " or b.last_name ilike %:fullName% \r\n"
			+ " or CONCAT( b.first_name,' ', b.last_name ) ilike %:fullName%))"
			+ " and (:dsrcCode = '' or b.dsrc_beneficiary_code ilike %:dsrcCode%) \r\n"
			+ " and (:mobilenumber = '' or b.mobile_number ilike %:mobilenumber%) \r\n"
			+ " and (:uid = '' or b.uid ilike %:uid%) \r\n" + " and (:gender = 0 or b.gender_id = :gender)")
	Page<DsrcBeneficiaryReferralProjection> findDsrcReferralsAdvancedLinked(@Param("facilityId") Long facilityId,
			@Param("referedTo") List<Integer> referedTo, @Param("referralStatusId") Integer referralStatusId,
			@Param("fullName") String fullName, @Param("mobilenumber") String mobilenumber,
			@Param("gender") Integer gender, @Param("dsrcCode") String dsrcCode, @Param("uid") String uid,
			Pageable pageable);

	@Query(value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName,b.middle_name as middleName, \r\n"
			+ "b.last_name as lastName,b.mobile_number as contactNumber,b.date_of_birth as dateOfBirth,b.category_id as categoryId,\r\n"
			+ "b.dsrc_beneficiary_code as dsrcBeneficiaryCode,b.age as age, b.occupation_id as occupationId, \r\n"
			+ "b.education_level_id as educationLevelId, b.marital_status_id as maritalStatusId,\r\n"
			+ "db.infant_code as infantCode, db.infant_mother_facility_id as infantMotherFacilityId,\r\n"
			+ "db.infant_mother_beneficiary_id as infantMotherBeneficiaryId, db.is_counselling_done as counsellingDone,\r\n"
			+ "bg.id as genderId,bs.id as dsrcBeneficiaryStatusId,db.dsrc_reg_date as regDate,\r\n"
			+ "ad.address_line_one as addressLineOne, ad.address_line_two as addressLineTwo, ad.state_id as stateId,ad.district_id as districtId,\r\n"
			+ "ad.subdistrict_id as subDistrictId, ad.town_id as townId, ad.country as country,ad.pincode as pinCode,\r\n"
			+ "br.refered_to as referedTo from soch.beneficiary b \r\n"
			+ "join soch.beneficiary_referral br on br.beneficiary_id = b.id \r\n"
			+ "left join soch.dsrc_beneficiary db on db.beneficiary_id = b.id \r\n"
			+ "join soch.master_gender bg on b.gender_id = bg.id\r\n"
			+ "left join soch.master_dsrc_beneficiary_status bs on db.benficiary_status_id = bs.id\r\n"
			+ "join soch.address ad on ad.id=b.address_id\r\n"
			+ "where br.id=:referralId and b.is_delete=false and b.is_active=true", nativeQuery = true)
	DsrcBeneficiaryProjection findByReferralId(@Param("referralId") Long referralId);

	@Query(value = "select br.id as id, br.beneficiary_id as beneficiaryId, br.ti_beneficiary_id as tiBeneficiaryId, br.ti_ben_scr_id as tiBenScrId, br.date_of_visit as dateOfVisit, "
			+ "br.refer_date as referDate, br.refered_from as referedFrom, br.refered_to as referedTo, br.referral_reason as referralReason, br.referred_by as referredBy, br.referral_type_id as referralTypeId, "
			+ "br.accepted_date as acceptedDate, br.declined_date as declinedDate, br.referral_type as referralType, br.referral_status_id as referralStatusId, br.is_active as isActive, br.is_delete as isDelete, "
			+ "br.referred_to_facility_type_id as referredToFacilityTypeId, br.accepted_facility_id as acceptedFacility "
			+ "from soch.beneficiary_referral br "
			+ "where br.beneficiary_id =:beneficiaryId and br.refered_to =:referredTo and br.referral_status_id in (1, 2)", nativeQuery = true)
	List<DsrcReferralProjection> findByBeneficiaryIdAndReferedToAndReferralStatusId(
			@Param("beneficiaryId") Long beneficiaryId, @Param("referredTo") Long referredTo);

	@Query(value = "select br.id as id, br.beneficiary_id as beneficiaryId, br.ti_beneficiary_id as tiBeneficiaryId, br.ti_ben_scr_id as tiBenScrId, br.date_of_visit as dateOfVisit, "
			+ "br.refer_date as referDate, br.refered_from as referedFrom, br.refered_to as referedTo, br.referral_reason as referralReason, br.referred_by as referredBy, br.referral_type_id as referralTypeId, "
			+ "br.accepted_date as acceptedDate, br.declined_date as declinedDate, br.referral_type as referralType, br.referral_status_id as referralStatusId, br.is_active as isActive, br.is_delete as isDelete, "
			+ "br.referred_to_facility_type_id as referredToFacilityTypeId, br.accepted_facility_id as acceptedFacility "
			+ "from soch.beneficiary_referral br where br.id =:referralId", nativeQuery = true)
	DsrcReferralProjection findByRefId(@Param("referralId") Long referralId);
}
