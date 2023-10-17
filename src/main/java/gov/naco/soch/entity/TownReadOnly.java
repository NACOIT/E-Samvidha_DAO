package gov.naco.soch.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Immutable;

import java.sql.Timestamp;
import java.util.Set;

/**
 * The persistent class for the town database table.
 * 
 */
@Entity(name="TownReadOnly")
@Table(name = "town")
@Immutable
public class TownReadOnly implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "town_id")
    private Long townId;

    @Column(name = "town_name")
    private String townName;

    @Column(name="town_code")
    private String townCode;
    
    public TownReadOnly() {
    }

    public Long getTownId() {
	return townId;
    }

    public void setTownId(Long townId) {
	this.townId = townId;
    }

    public String getTownName() {
	return this.townName;
    }

    public void setTownName(String townName) {
	this.townName = townName;
    }

	public String getTownCode() {
		return townCode;
	}

	public void setTownCode(String townCode) {
		this.townCode = townCode;
	}

}