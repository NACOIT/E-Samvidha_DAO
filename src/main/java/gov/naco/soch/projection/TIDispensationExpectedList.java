package gov.naco.soch.projection;

import java.math.BigDecimal;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(name = "AuthorValueMapping", classes = @ConstructorResult(targetClass = TIDispensationExpectedList.class, columns = {
		@ColumnResult(name = "ostnumber"), @ColumnResult(name = "tiostbeneficiaryid", type = Integer.class),
		@ColumnResult(name = "firstname"), @ColumnResult(name = "secondname"), @ColumnResult(name = "age"),
		@ColumnResult(name = "sex"), @ColumnResult(name = "tiostprescriptionid", type = Integer.class),
		@ColumnResult(name = "drug"), @ColumnResult(name = "dosage", type = BigDecimal.class),
		@ColumnResult(name = "linkedfacilityid", type = Integer.class) }))

public class TIDispensationExpectedList {

	private String uid;
	private String ostnumber;
	private Integer tiostbeneficiaryid;
	private String firstname;
	private String secondname;
	private String age;
	private String sex;
	private Integer tiostprescriptionid;
	private String drug;
	private Integer linkedfacilityid;
	private BigDecimal dosage;

	public String getOstNumber() {
		return ostnumber;
	}

	public Integer getLinkedfacilityid() {
		return linkedfacilityid;
	}

	public void setLinkedfacilityid(Integer linkedfacilityid) {
		this.linkedfacilityid = linkedfacilityid;
	}

	public void setOstNumber(String ostNumber) {
		this.ostnumber = ostNumber;
	}

	public Integer getTiOstBeneficiaryId() {
		return tiostbeneficiaryid;
	}

	public void setTiOstBeneficiaryId(Integer tiOstBeneficiaryId) {
		this.tiostbeneficiaryid = tiOstBeneficiaryId;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getTiOstPrescriptionId() {
		return tiostprescriptionid;
	}

	public void setTiOstPrescriptionId(Integer tiOstPrescriptionId) {
		this.tiostprescriptionid = tiOstPrescriptionId;
	}

	public String getDrug() {
		return drug;
	}

	public void setDrug(String drug) {
		this.drug = drug;
	}

	public BigDecimal getDosage() {
		return dosage;
	}

	public void setDosage(BigDecimal dosage) {
		this.dosage = dosage;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}

	public String getSecondName() {
		return secondname;
	}

	public void setSecondName(String secondName) {
		this.secondname = secondName;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}
