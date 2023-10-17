package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import gov.naco.soch.entity.Auditable;
import gov.naco.soch.entity.MasterEducationLevel;
import gov.naco.soch.entity.MasterGender;
import gov.naco.soch.entity.MasterGuardianCaregiver;
import gov.naco.soch.entity.MasterStayingWith;

@GenericGenerator(name = "beneficiary", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "beneficiary_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "beneficiary")
@NamedQuery(name = "PediatricBeneficiaryEntity.findAll", query = "SELECT b FROM PediatricBeneficiaryEntity b")
public class PediatricBeneficiaryEntity extends Auditable<Long> implements Serializable{

	 private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(generator = "beneficiary")
	    private Long id;
	    
	    @Column(name = "date_of_birth")
	    private LocalDate dateOfBirth;
	    
	    @Column(name = "guardian_caregiver_id")
	    private Long guardianCaregiverId;
	    
	    @Column(name = "gender_id")
	    private Long genderId;
	    
	    @Column(name = "staying_with_id")
	    private Long stayingWithId;
	    
	    @Column(name = "staying_with_others")
	    private String stayingWithOthers;
	    
	    @Column(name = "guardian_caregiver_highest_education_id")
	    private Long guardianCaregiverHighestEducation_id;
	    
	    @Column(name = "guardian_caregiver_others")
	    private String guardianCaregiverOthers;
	    
	    @Column(name = "birth_history_id")
	    private Long birthHistoryId;

	    @Column(name = "birth_weight")
	    private Double birthWeight;

	    @Column(name = "neo_natal_complications")
	    private String neoNatalComplications;
	    
	    @Column(name = "paediatric_other_vaccines")
	    private String paediatricOtherVaccines;
	    
	    @Column(name = "guardian_date_of_birth")
	    private LocalDate guardianDateOfBirth;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public Long getGuardianCaregiverId() {
			return guardianCaregiverId;
		}

		public void setGuardianCaregiverId(Long guardianCaregiverId) {
			this.guardianCaregiverId = guardianCaregiverId;
		}

		public Long getGenderId() {
			return genderId;
		}

		public void setGenderId(Long genderId) {
			this.genderId = genderId;
		}

		public Long getStayingWithId() {
			return stayingWithId;
		}

		public void setStayingWithId(Long stayingWithId) {
			this.stayingWithId = stayingWithId;
		}

		public String getStayingWithOthers() {
			return stayingWithOthers;
		}

		public void setStayingWithOthers(String stayingWithOthers) {
			this.stayingWithOthers = stayingWithOthers;
		}

		public Long getGuardianCaregiverHighestEducation_id() {
			return guardianCaregiverHighestEducation_id;
		}

		public void setGuardianCaregiverHighestEducation_id(Long guardianCaregiverHighestEducation_id) {
			this.guardianCaregiverHighestEducation_id = guardianCaregiverHighestEducation_id;
		}

		public String getGuardianCaregiverOthers() {
			return guardianCaregiverOthers;
		}

		public void setGuardianCaregiverOthers(String guardianCaregiverOthers) {
			this.guardianCaregiverOthers = guardianCaregiverOthers;
		}

		public Long getBirthHistoryId() {
			return birthHistoryId;
		}

		public void setBirthHistoryId(Long birthHistoryId) {
			this.birthHistoryId = birthHistoryId;
		}

		public Double getBirthWeight() {
			return birthWeight;
		}

		public void setBirthWeight(Double birthWeight) {
			this.birthWeight = birthWeight;
		}

		public String getNeoNatalComplications() {
			return neoNatalComplications;
		}

		public void setNeoNatalComplications(String neoNatalComplications) {
			this.neoNatalComplications = neoNatalComplications;
		}

		public String getPaediatricOtherVaccines() {
			return paediatricOtherVaccines;
		}

		public void setPaediatricOtherVaccines(String paediatricOtherVaccines) {
			this.paediatricOtherVaccines = paediatricOtherVaccines;
		}

		public LocalDate getGuardianDateOfBirth() {
			return guardianDateOfBirth;
		}

		public void setGuardianDateOfBirth(LocalDate guardianDateOfBirth) {
			this.guardianDateOfBirth = guardianDateOfBirth;
		}

		
	    
	    

	    
	    

}
