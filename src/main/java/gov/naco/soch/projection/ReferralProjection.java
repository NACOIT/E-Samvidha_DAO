package gov.naco.soch.projection;

import java.time.LocalDate;

//projection class for ti beneficiary referrals
public interface ReferralProjection {

	Long getId();

	void setId(Long id);

	String getAge();

	void setAge(String age);

	String getUid();

	void setUid(String uid);

	String getFirstName();

	void setFirstName(String firstName);

	String getGender();

	void setGender(String gender);

	String getLastName();

	void setLastName(String lastName);

	String getMiddleName();

	void setMiddleName(String middleName);

	String getMobileNumber();

	void setMobileNumber(String mobileNumber);

	String getUidNumber();

	void setUidNumber(String uidNumber);

	Long getBeneficiaryId();

	void setBeneficiaryId(Long beneficiaryId);

	Integer getReferralFacility();

	void setReferralFacility(Integer referralFacility);

	String getReferralStatus();

	void setReferralStatus(String referralStatus);

	LocalDate getDateOfReferral();

	void setDateOfReferral(LocalDate dateOfReferral);

	Integer getReferredFacility();

	void setReferredFacility(Integer referredFacility);

	String getHivStatus();

	void setHivStatus(String hivStatus);

	String getTransferTo();

	void setTransferTo(String transferTo);

	String getTransferFrom();

	void setTransferFrom(String transferFrom);

	LocalDate getTransferDate();

	void setTransferDate(LocalDate transferDate);

	String getTransferStatus();

	void setTransferStatus(String transferStatus);

}
