package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "ipc_session", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
	@Parameter(name = "sequence_name", value = "ipc_session_id_seq"),
	@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })

@Entity
@Table(name = "ipc_session")
@NamedQuery(name = "IPCSession.findAll", query = "SELECT t FROM IPCSession t")
public class IPCSession extends Auditable<Long> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "ipc_session")
    private Long id;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "is_delete")
    private Boolean isDelete;
    @Column(name = "facility_id")
    private Long facilityId;
    @Column(name = "ipc_code")
    private String ipcCode;
    @Column(name = "session_date")
    private LocalDate sessionDate;
    @Column(name = "orw_code")
    private String orwCode;
    @Column(name = "pe_code")
    private String peCode;
    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToMany(mappedBy="ipcSession",cascade = CascadeType.ALL)
    private Set<IPCTopicMapping> ipcTopics;
    private Integer hrgCovered;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Boolean getIsActive() {
	return isActive;
    }

    public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
    }

    public Boolean getIsDelete() {
	return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
	this.isDelete = isDelete;
    } 
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getFacilityId() {
	return facilityId;
    }

    public void setFacilityId(Long facilityId) {
	this.facilityId = facilityId;
    }

    public String getIpcCode() {
	return ipcCode;
    }

    public void setIpcCode(String ipcCode) {
	this.ipcCode = ipcCode;
    }

    public LocalDate getSessionDate() {
	return sessionDate;
    }

    public void setSessionDate(LocalDate sessionDate) {
	this.sessionDate = sessionDate;
    }

    public String getOrwCode() {
	return orwCode;
    }

    public void setOrwCode(String orwCode) {
	this.orwCode = orwCode;
    }

    public String getPeCode() {
	return peCode;
    }

    public void setPeCode(String peCode) {
	this.peCode = peCode;
    }

    public Set<IPCTopicMapping> getIpcTopics() {
	return ipcTopics;
    }

    public void setIpcTopics(Set<IPCTopicMapping> ipcTopics) {
	this.ipcTopics = ipcTopics;
	if (ipcTopics != null) {
	    for (IPCTopicMapping ipcTopic : ipcTopics) {
		this.ipcTopics.add(addIPCTopicMapping(ipcTopic));
	    }
	}
    }

    public IPCTopicMapping addIPCTopicMapping(IPCTopicMapping IPCTopicMapping) {
	getIpcTopics().add(IPCTopicMapping);
	IPCTopicMapping.setIpcSession(this);
	return IPCTopicMapping;
    }

    public IPCTopicMapping removeIPCTopicMapping(IPCTopicMapping ipcTopicMapping) {
	getIpcTopics().remove(ipcTopicMapping);
	ipcTopicMapping.setIpcSession(null);
	return ipcTopicMapping;
    }

    public Integer getHrgCovered() {
	return hrgCovered;
    }

    public void setHrgCovered(Integer hrgCovered) {
	this.hrgCovered = hrgCovered;
    }

}