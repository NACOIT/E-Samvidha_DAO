package gov.naco.soch.constructordto;

import java.math.BigInteger;

public class SummaryDto {

	private BigInteger monthly_active_target;
	private BigInteger registrations;
	private BigInteger plhivs;
	private BigInteger active_plhivs;
	private BigInteger active_hrgs;
	private BigInteger activeOstClients;
	private BigInteger totalOstClients;

	public BigInteger getActive_hrgs() {
		return active_hrgs;
	}

	public void setActive_hrgs(BigInteger active_hrgs) {
		this.active_hrgs = active_hrgs;
	}

	public BigInteger getRegistrations() {
		return registrations;
	}

	public void setRegistrations(BigInteger registrations) {
		this.registrations = registrations;
	}

	public BigInteger getPlhivs() {
		return plhivs;
	}

	public void setPlhivs(BigInteger plhivs) {
		this.plhivs = plhivs;
	}

	public BigInteger getActive_plhivs() {
		return active_plhivs;
	}

	public void setActivePlhivs(BigInteger activePlhivs) {
		this.active_plhivs = activePlhivs;
	}

	public BigInteger getMonthly_active_target() {
		return monthly_active_target;
	}

	public void setMonthly_active_target(BigInteger monthly_active_target) {
		this.monthly_active_target = monthly_active_target;
	}

	public BigInteger getActiveOstClients() {
		return activeOstClients;
	}

	public void setActiveOstClients(BigInteger activeOstClients) {
		this.activeOstClients = activeOstClients;
	}

	public BigInteger getTotalOstClients() {
		return totalOstClients;
	}

	public void setTotalOstClients(BigInteger totalOstClients) {
		this.totalOstClients = totalOstClients;
	}

}
