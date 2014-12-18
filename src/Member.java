package ChocAn;


public class Member {
		String FirstName;
		String LastName;
		String MiddleName;
		String ID;
		String PhoneNumber;
		String Street;
		String City;
		String State;
		String ZipCode;
		String Email;
		boolean Active;
		Service [] s = new Service[0];
		Provider []p = new Provider[0];
		
		public Member()
		{
			FirstName = null;
			LastName = null;
			MiddleName = null;
			ID = null;
			PhoneNumber = null;
			Street = null;
			City = null;
			State = null;
			ZipCode = null;
			Email = null;
			Active = true;
		}
}
