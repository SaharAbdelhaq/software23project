package software;

public class Admin extends Person {
	Service s;

	public Admin()
	{
		super(mainClass);
		s = new Service();
		name = "admin";
		pass = "admin123";
		type = "admin";
		f = 0;
		status = false;
	}

	@Override
	String getType() 
	{
		return type;
	}

	@Override
	String getName() 
	{
		return name;
	}
	
	@Override
	String getPassword()
	{
		return pass;
	}


}
