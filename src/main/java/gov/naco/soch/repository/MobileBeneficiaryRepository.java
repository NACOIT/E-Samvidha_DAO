package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.projection.MobileRegisteredFacilityDetailsProjection;

@Repository
public interface MobileBeneficiaryRepository extends JpaRepository<Beneficiary , Long>, CustomRepository {
	@Query(nativeQuery = true, value ="SELECT  ben.id as beneficiaryId, ben.first_name as firstName, ben.uid as uid, ben.art_number as artNumber,ben.pre_art_number as preArtNumber, ben.pid as Pid, ben.ti_code as tiCode,ben.dsrc_beneficiary_code as dsrcBeneficiaryCode,  ib.facility_id as facilityId, fac.name as facilityName, \r\n" + 
			"addr.address_line_one as addressLine1, addr.address_line_two as addressLine2, addr.country as country,pc.pincode as pinCode, st.id as stateId, st.name as state,\r\n" + 
			"dt.id as districtId, dt.name as district, ft.id as facilityTypeId, ft.facility_type_name as facilityTypeName\r\n" + 
			"FROM soch.beneficiary ben \r\n" + 
			"inner join soch.ictc_beneficiary as ib ON ib.pid = ben.pid\r\n" + 
			"inner join soch.facility as fac ON fac.id = ib.facility_id\r\n" + 
			"inner join soch.facility_type as ft ON ft.id = fac.facility_type_id\r\n" + 
			"inner join soch.address as addr ON addr.id = fac.address_id\r\n" + 
			"left join soch.pincode as pc ON pc.id = addr.pincode_id\r\n" + 
			"left join soch.state as st ON st.id = addr.state_id\r\n" + 
			"left join soch.district as dt ON dt.id = addr.district_id\r\n" + 
			"where ben.id = :beneficiaryId and ben.pid is not NULL")
	List<MobileRegisteredFacilityDetailsProjection> findIctcCentre(@Param("beneficiaryId")Long beneficiaryId);
	
	@Query(nativeQuery = true, value ="SELECT  ben.id as beneficiaryId, ben.first_name as firstName, ben.uid as uid, ben.art_number as artNumber,ben.pre_art_number as preArtNumber, ben.pid as Pid, ben.ti_code as tiCode,ben.dsrc_beneficiary_code as dsrcBeneficiaryCode,  ib.facility_id as facilityId, fac.name as facilityName,  \r\n" + 
			"addr.address_line_one as addressLine1, addr.address_line_two as addressLine2, addr.country as country,pc.pincode as pinCode, st.id as stateId, st.name as state, \r\n" + 
			"dt.id as districtId, dt.name as district, ft.id as facilityTypeId, ft.facility_type_name as facilityTypeName \r\n" + 
			"FROM soch.beneficiary ben  \r\n" + 
			"inner join soch.art_beneficiary as ib ON ib.beneficiary_id = ben.id \r\n" + 
			"inner join soch.facility as fac ON fac.id = ib.facility_id \r\n" + 
			"inner join soch.facility_type as ft ON ft.id = fac.facility_type_id \r\n" + 
			"inner join soch.address as addr ON addr.id = fac.address_id \r\n" + 
			"left join soch.pincode as pc ON pc.id = addr.pincode_id\r\n" +
			"left join soch.state as st ON st.id = addr.state_id \r\n" + 
			"left join soch.district as dt ON dt.id = addr.district_id \r\n" + 
			"where ben.id = :beneficiaryId and (ben.art_number is not NULL OR ben.pre_art_number is not NULL)")
	List<MobileRegisteredFacilityDetailsProjection> findArtCentre(@Param("beneficiaryId")Long beneficiaryId);
	
	@Query(nativeQuery = true, value ="SELECT  ben.id as beneficiaryId, ben.first_name as firstName, ben.uid as uid, ben.art_number as artNumber,ben.pre_art_number as preArtNumber, ben.pid as Pid, ben.ti_code as tiCode,ben.dsrc_beneficiary_code as dsrcBeneficiaryCode,  ib.facility_id as facilityId, fac.name as facilityName,  \r\n" + 
			"addr.address_line_one as addressLine1, addr.address_line_two as addressLine2, addr.country as country,pc.pincode as pinCode, st.id as stateId, st.name as state, \r\n" + 
			"dt.id as districtId, dt.name as district, ft.id as facilityTypeId, ft.facility_type_name as facilityTypeName \r\n" + 
			"FROM soch.beneficiary ben  \r\n" + 
			"inner join soch.ti_beneficiary as ib ON ib.beneficiary_id = ben.id \r\n" + 
			"inner join soch.facility as fac ON fac.id = ib.facility_id \r\n" + 
			"inner join soch.facility_type as ft ON ft.id = fac.facility_type_id \r\n" + 
			"inner join soch.address as addr ON addr.id = fac.address_id \r\n" + 
			"left join soch.pincode as pc ON pc.id = addr.pincode_id\r\n" +
			"left join soch.state as st ON st.id = addr.state_id \r\n" + 
			"left join soch.district as dt ON dt.id = addr.district_id \r\n" + 
			"where ben.id = :beneficiaryId and ben.ti_code is not NULL")
	List<MobileRegisteredFacilityDetailsProjection> findTiCentre(@Param("beneficiaryId")Long beneficiaryId);
	
	@Query(nativeQuery = true, value ="SELECT  ben.id as beneficiaryId, ben.first_name as firstName, ben.uid as uid, ben.art_number as artNumber,ben.pre_art_number as preArtNumber, ben.pid as Pid, ben.ti_code as tiCode,ben.dsrc_beneficiary_code as dsrcBeneficiaryCode,  ib.facility_id as facilityId, fac.name as facilityName,  \r\n" + 
			"addr.address_line_one as addressLine1, addr.address_line_two as addressLine2, addr.country as country,pc.pincode as pinCode, st.id as stateId, st.name as state, \r\n" + 
			"dt.id as districtId, dt.name as district, ft.id as facilityTypeId, ft.facility_type_name as facilityTypeName \r\n" + 
			"FROM soch.beneficiary ben  \r\n" + 
			"inner join soch.dsrc_beneficiary as ib ON ib.beneficiary_id = ben.id \r\n" + 
			"inner join soch.facility as fac ON fac.id = ib.facility_id \r\n" + 
			"inner join soch.facility_type as ft ON ft.id = fac.facility_type_id \r\n" + 
			"inner join soch.address as addr ON addr.id = fac.address_id \r\n" +
			"left join soch.pincode as pc ON pc.id = addr.pincode_id\r\n" +
			"left join soch.state as st ON st.id = addr.state_id \r\n" + 
			"left join soch.district as dt ON dt.id = addr.district_id \r\n" + 
			"where ben.id = :beneficiaryId and ben.dsrc_beneficiary_code is not NULL")
	List<MobileRegisteredFacilityDetailsProjection> findDsrcCentre(@Param("beneficiaryId")Long beneficiaryId);
	
	@Query(nativeQuery = true, value ="SELECT ben.id as beneficiaryId, ben.first_name as firstName, ben.uid as uid, ben.art_number as artNumber,ben.pre_art_number as preArtNumber, ben.pid as Pid, ben.ti_code as tiCode,ben.dsrc_beneficiary_code as dsrcBeneficiaryCode, ben.ost_code as ostCode, ib.facility_id as facilityId, fac.name as facilityName,\r\n" + 
			"addr.address_line_one as addressLine1, addr.address_line_two as addressLine2, addr.country as country,pc.pincode as pinCode, st.id as stateId, st.name as state,\r\n" + 
			"dt.id as districtId, dt.name as district, ft.id as facilityTypeId, ft.facility_type_name as facilityTypeName\r\n" + 
			"FROM soch.beneficiary ben\r\n" + 
			"inner join soch.ti_ost_beneficiary as ib ON ib.beneficiary_id = ben.id\r\n" + 
			"inner join soch.facility as fac ON fac.id = ib.facility_id\r\n" + 
			"inner join soch.facility_type as ft ON ft.id = fac.facility_type_id\r\n" + 
			"inner join soch.address as addr ON addr.id = fac.address_id\r\n" + 
			"left join soch.pincode as pc ON pc.id = addr.pincode_id\r\n" + 
			"left join soch.state as st ON st.id = addr.state_id\r\n" + 
			"left join soch.district as dt ON dt.id = addr.district_id\r\n" + 
			"where ben.id =:beneficiaryId\r\n" + 
			"and ben.ost_code is not NULL")
	List<MobileRegisteredFacilityDetailsProjection> findOstCentre(@Param("beneficiaryId")Long beneficiaryId);

	@Query(nativeQuery = true, value ="select \r\n" + 
			"Case when aben.art_beneficiary_status_id in (8,9,10,14,15) \r\n" + 
			"then true \r\n" + 
			"else false \r\n" + 
			"end \r\n" + 
			"AS resultValue \r\n" + 
			"from soch.art_beneficiary aben \r\n" + 
			"inner join soch.beneficiary_visit_register visit on visit.beneficiary_id = aben.beneficiary_id \r\n" + 
			"inner join soch.art_beneficiary_clinical_details clidt on clidt.visit_register_id = visit.id \r\n" + 
			"where clidt.regimen_id is not null \r\n" + 
			"and aben.beneficiary_id =:beneficiaryId \r\n" + 
			"order by visit.id desc limit 1")
	Boolean fetchBeneficiaryArtStatus(@Param("beneficiaryId")Long beneficiaryId);

	
}
