package modle;

import java.sql.Timestamp;

public class AdministratorTransaction {
	
	private int id;
	private int administratorId;
	private int transactionId;
	private boolean solved;
	private Timestamp sovledTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAdministratorId() {
		return administratorId;
	}
	public void setAdministratorId(int administratorId) {
		this.administratorId = administratorId;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public boolean isSolved() {
		return solved;
	}
	public void setSolved(boolean solved) {
		this.solved = solved;
	}
	public Timestamp getSovledTime() {
		return sovledTime;
	}
	public void setSovledTime(Timestamp sovledTime) {
		this.sovledTime = sovledTime;
	}
}
