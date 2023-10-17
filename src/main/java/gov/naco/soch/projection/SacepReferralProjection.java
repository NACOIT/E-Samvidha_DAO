package gov.naco.soch.projection;

public interface SacepReferralProjection {

	public String getFirstName();

	public String getMiddleName();

	public String getLastName();

	public String getUidNumber();

	public String getGender();

	public String getStateName();

	public String getDistrictName();

	public String getBeneficiaryStatus();

	public String getMobileNumber();

	public String getPreArtNumber();

	public String getArtNumber();

	public String getDateOfBirth();

	public String getBeneficiaryReferralStatus();

	public Long getBeneficiaryId();

	public Long getBeneficiaryReferralId();
	
	public String getReferedFrom();
	
	public String getReferedTo();
	
	public Long getReferralStatusId();
	
	public Long getSacepReferralInformationId();
	
	public Boolean getAcceptedForSacep();
}
