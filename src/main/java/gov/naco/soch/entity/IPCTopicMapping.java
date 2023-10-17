package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Where;

@GenericGenerator(name = "ipc_topic_mapping", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
	@Parameter(name = "sequence_name", value = "ipc_topic_mapping_id_seq"),
	@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })

@Entity
@Table(name = "ipc_topic_mapping")
@Where(clause="is_delete=false")
public class IPCTopicMapping extends Auditable<Long> implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "ipc_topic_mapping")
    private Long id;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @ManyToOne
    @JoinColumn(name = "ipc_session_id")
    private IPCSession ipcSession;

    @ManyToOne
    @JoinColumn(name = "ipc_topic_id")
    private MasterIPCTopic ipcTopic;
    
    public IPCTopicMapping() {
	
    }

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

    public IPCSession getIpcSession() {
	return ipcSession;
    }

    public void setIpcSession(IPCSession ipcSession) {
	this.ipcSession = ipcSession;
    }

    public MasterIPCTopic getIpcTopic() {
        return ipcTopic;
    }

    public void setIpcTopic(MasterIPCTopic ipcTopic) {
        this.ipcTopic = ipcTopic;
    }


}