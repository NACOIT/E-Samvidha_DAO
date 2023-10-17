package gov.naco.soch.projection;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;

public interface BeneficiaryReferralProjection {
	
	@Value("#{target.beneficiary.uid}")
	String getUid();
	@Value("#{target.beneficiary.id}")
	Long getId(); 
	@Value("#{target.beneficiary.firstName} #{target.beneficiary.lastName}")
	String getName();
	LocalDate getDateOfVisit();
	@Value("#{target.beneficiary.mobileNumber}")
	String getMobileNumber();
	@Value("#{target.beneficiary.dateOfBirth}")
	LocalDate getDateOfBirth();
	@Value("#{target.beneficiary.category}")
	String getCategory();
	@Value("#{target.beneficiary.gender}")
	String getGender();
	String getHivStatus();
	LocalDate getReferDate();
	@Value("#{target.facility1.name}")
    String getReferredFrom();
    @Value("#{target.beneficiary.status}")
    String getBeneficiaryStatus();
    LocalDate getDateOfHivTest();
    String getTypeOfHiv();
}
