package vergecurrency.vergewallet.database.datamodels;


public final class ContactModel {
	
	//data
	private int contactId;
	private String contactAddress;
	private String contactName;
	
	public ContactModel() {}
	
	public String getContactAddress() {
		return contactAddress;
	}
	
	public void setContactAddress(String contactAddress) { this.contactAddress = contactAddress; }
	
	public String getContactName() {
		return contactName;
	}
	
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	public int getContactId() {	return contactId;	}
	
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	

}
