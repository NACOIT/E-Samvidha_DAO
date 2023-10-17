package gov.naco.soch.constructordto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class OngoingTreatmentDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String uid;
	
	private String name;
	
	private String tiCode; 
	
	private String dsrcCode;
	
	private String Typology;
	
	private String age;
	
	private String gender;
	
	private String infection;
	
	private LocalDate diagnosisDate;
	
	private int beneficiaryId;
	
	private int treatmentTypeId;
	
	private List<String> diagnosisType;
	
	public String getDsrcCode() {
		return dsrcCode;
	}

	public void setDsrcCode(String dsrcCode) {
		this.dsrcCode = dsrcCode;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTiCode() {
		return tiCode;
	}

	public void setTiCode(String tiCode) {
		this.tiCode = tiCode;
	}

	public String getTypology() {
		return Typology;
	}

	public void setTypology(String typology) {
		Typology = typology;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getInfection() {
		return infection;
	}

	public void setInfection(String infection) {
		this.infection = infection;
	}

	public LocalDate getDiagnosisDate() {
		return diagnosisDate;
	}

	public void setDiagnosisDate(LocalDate diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}

	public int getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(int beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public List<String> getDiagnosisType() {
		return diagnosisType;
	}

	public void setDiagnosisType(List<String> diagnosisType) {
		this.diagnosisType = diagnosisType;
	}

	public int getTreatmentTypeId() {
		return treatmentTypeId;
	}

	public void setTreatmentTypeId(int treatmentTypeId) {
		this.treatmentTypeId = treatmentTypeId;
	}

}
