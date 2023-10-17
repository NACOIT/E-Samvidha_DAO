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

/**
 * The persistent class for the facility_dispatch_transport_details database
 * table.
 * 
 */
@GenericGenerator(name = "facility_dispatch_transport_details", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "facility_dispatch_transport_details_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "facility_dispatch_transport_details")
@NamedQuery(name = "FacilityDispatchTransportDetails.findAll", query = "SELECT m FROM FacilityDispatchTransportDetails m")
public class FacilityDispatchTransportDetails extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "facility_dispatch_transport_details")
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "awb_number")
	private String awbNumber;

	@Column(name = "booking_city")
	private String bookingCity;

	@Column(name = "delivery_city")
	private String deliveryCity;

	@Column(name = "booking_date")
	private LocalDate bookingDate;

	@Column(name = "estimated_delivery_date")
	private LocalDate estimatedDeliveryDate;

	@Column(name = "actual_delivery_date")
	private LocalDate actualDeliveryDate;

	@Column(name = "transportation_status_message")
	private String transportationStatusMessage;

	// bi-directional many-to-one association to FacilityDispatch
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_dispatch_id")
	private FacilityDispatch facilityDispatch;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transporter_id")
	private Facility transporter;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transportation_status_id")
	private MasterTransportationStatus masterTransportationStatus;

	public Long getId() {
		return id;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public String getAwbNumber() {
		return awbNumber;
	}

	public String getBookingCity() {
		return bookingCity;
	}

	public String getDeliveryCity() {
		return deliveryCity;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public LocalDate getEstimatedDeliveryDate() {
		return estimatedDeliveryDate;
	}

	public LocalDate getActualDeliveryDate() {
		return actualDeliveryDate;
	}

	public String getTransportationStatusMessage() {
		return transportationStatusMessage;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}

	public void setBookingCity(String bookingCity) {
		this.bookingCity = bookingCity;
	}

	public void setDeliveryCity(String deliveryCity) {
		this.deliveryCity = deliveryCity;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public void setEstimatedDeliveryDate(LocalDate estimatedDeliveryDate) {
		this.estimatedDeliveryDate = estimatedDeliveryDate;
	}

	public void setActualDeliveryDate(LocalDate actualDeliveryDate) {
		this.actualDeliveryDate = actualDeliveryDate;
	}

	public void setTransportationStatusMessage(String transportationStatusMessage) {
		this.transportationStatusMessage = transportationStatusMessage;
	}

	public FacilityDispatch getFacilityDispatch() {
		return facilityDispatch;
	}

	public Facility getTransporter() {
		return transporter;
	}

	public MasterTransportationStatus getMasterTransportationStatus() {
		return masterTransportationStatus;
	}

	public void setFacilityDispatch(FacilityDispatch facilityDispatch) {
		this.facilityDispatch = facilityDispatch;
	}

	public void setTransporter(Facility transporter) {
		this.transporter = transporter;
	}

	public void setMasterTransportationStatus(MasterTransportationStatus masterTransportationStatus) {
		this.masterTransportationStatus = masterTransportationStatus;
	}

}
