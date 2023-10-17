package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtBeneficiaryCounsellingNotes;


@Repository
public interface ArtBeneficiaryCounsellingNoteRepository 
							extends JpaRepository<ArtBeneficiaryCounsellingNotes, Long>, JpaSpecificationExecutor<ArtBeneficiaryCounsellingNotes>{

	@Query(value = "select * from soch.art_beneficiary_counselling_notes cn where cn.beneficiary_id=:beneficiaryId ", nativeQuery = true)
	List<ArtBeneficiaryCounsellingNotes> findByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(value = "select * from soch.art_beneficiary_counselling_notes cn where cn.beneficiary_id=:beneficiaryId and cn.visit_register_id = :visitRegisterId", nativeQuery = true)
	List<ArtBeneficiaryCounsellingNotes> findByBeneficiaryIdAndVisitRegisterId(@Param("beneficiaryId") Long beneficiaryId, @Param("visitRegisterId") Long visitRegisterId);

	@Query(value = "select distinct bcn.visit_register_id from soch.art_beneficiary_counselling_notes as bcn where bcn.beneficiary_id = :beneficiaryid", nativeQuery = true)
	List<Long> findAllVisitRegisterIdByBeneficiary(@Param("beneficiaryid") Long beneficiaryid);

	@Query(nativeQuery = true , value ="select count(distinct bcn.visit_register_id) from soch.art_beneficiary_counselling_notes as bcn where bcn.beneficiary_id =:beneficiaryId")
	Long findTotalCountOfVisitedDate(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true , value ="select distinct bcn.visit_register_id from soch.art_beneficiary_counselling_notes as bcn where bcn.beneficiary_id = :beneficiaryId order by bcn.visit_register_id desc limit 1")
	Long findLastVisitRedisterId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true , value ="select distinct bcn.visit_register_id from soch.art_beneficiary_counselling_notes as bcn where bcn.beneficiary_id = :beneficiaryId order by bcn.visit_register_id asc limit 1")
	Long findfirstvisitId(@Param("beneficiaryId") Long beneficiaryId);
}
