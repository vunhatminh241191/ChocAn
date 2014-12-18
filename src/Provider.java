package ChocAn;


public class Provider {
	String Name;
	String ID;
	int Consultation;
	String Street;
	String City;
	String State;
	String ZipCode;
	String TotalFee;
	Member [] m = new Member[0];
	
	public Provider()
	{
		Name = null;
		ID = null;
		Consultation = 0;
		Street = null;
		City = null;
		State = null;
		ZipCode = null;
		TotalFee = null;
	}
}
