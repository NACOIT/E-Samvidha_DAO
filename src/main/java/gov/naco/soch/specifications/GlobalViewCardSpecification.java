package gov.naco.soch.specifications;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.springframework.data.jpa.domain.Specification;

import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryReferral;
import gov.naco.soch.entity.BeneficiaryReferralViewCardReadOnly;
import gov.naco.soch.entity.BeneficiaryReferralViewCardReadOnly_;
import gov.naco.soch.entity.BeneficiaryReferral_;
import gov.naco.soch.entity.Beneficiary_;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityType;
import gov.naco.soch.entity.FacilityType_;
import gov.naco.soch.entity.Facility_;
import gov.naco.soch.entity.BeneficiaryViewCardReadOnly;
import gov.naco.soch.entity.BeneficiaryViewCardReadOnly_;
import gov.naco.soch.entity.FacilityReadOnly;
import gov.naco.soch.entity.FacilityReadOnly_;

public class GlobalViewCardSpecification {

	public static Specification<BeneficiaryReferral> getLatestIctcReferralDetails(Long beneficiaryId) {
		return (root, query, cb) ->{ 
		   Subquery<Long> maxSubQuery = query.subquery(Long.class);
		   Root<BeneficiaryReferral> benReferral = maxSubQuery.from(BeneficiaryReferral.class);
		   Join<BeneficiaryReferral,Beneficiary> b= benReferral.join(BeneficiaryReferral_.beneficiary,JoinType.LEFT);
		   Subquery<Long> facilitySubQuery = query.subquery(Long.class);
		   Root<Facility> facility = facilitySubQuery.from(Facility.class);
		   facilitySubQuery.select(facility.get(Facility_.id));
		   Join<Facility,FacilityType> m= facility.join(Facility_.facilityType,JoinType.LEFT);
		   Predicate y= m.get(FacilityType_.id).in(11,13);
		   facilitySubQuery.where(y);
		   Predicate j=benReferral.get(BeneficiaryReferral_.facility2).in(facilitySubQuery);
		   maxSubQuery.select(cb.greatest(benReferral.get(BeneficiaryReferral_.id)));
		  Predicate a =cb.equal(b.get(Beneficiary_.id),beneficiaryId);
		   maxSubQuery.where(a,j);
		   Predicate k = cb.equal(root.get(BeneficiaryReferral_.id), maxSubQuery);
		   return cb.and(k);
		};
   }
	
	public static Specification<BeneficiaryReferralViewCardReadOnly> getLatestIctcRefDetails(Long beneficiaryId) {
		return (root, query, cb) ->{ 
		   Subquery<Long> maxSubQuery = query.subquery(Long.class);
		   Root<BeneficiaryReferralViewCardReadOnly> benReferral = maxSubQuery.from(BeneficiaryReferralViewCardReadOnly.class);
		   Join<BeneficiaryReferralViewCardReadOnly,BeneficiaryViewCardReadOnly> b= benReferral.join(BeneficiaryReferralViewCardReadOnly_.beneficiary,JoinType.LEFT);
		   Subquery<Long> facilitySubQuery = query.subquery(Long.class);
		   Root<FacilityReadOnly> facility = facilitySubQuery.from(FacilityReadOnly.class);
		   facilitySubQuery.select(facility.get(FacilityReadOnly_.id));
//		   Join<Facility,FacilityType> m= facility.join(Facility_.facilityType,JoinType.LEFT);
		   Predicate y= facility.get(FacilityReadOnly_.facilityTypeId).in(11,13);
		   facilitySubQuery.where(y);
		   Predicate j=benReferral.get(BeneficiaryReferralViewCardReadOnly_.referredTo).in(facilitySubQuery);
		   maxSubQuery.select(cb.greatest(benReferral.get(BeneficiaryReferralViewCardReadOnly_.id)));
		  Predicate a =cb.equal(b.get(BeneficiaryViewCardReadOnly_.id),beneficiaryId);
		   maxSubQuery.where(a,j);
		   Predicate k = cb.equal(root.get(BeneficiaryReferralViewCardReadOnly_.id), maxSubQuery);
		   return cb.and(k);
		};
   }
}
