package software;

abstract public class Person {
	protected int f, pid;
	protected String pass, name, type;
	protected boolean status;
	
	static MainClass mainClass=null;

	public Person(MainClass mainClass)
	{
		mainClass=Opticity.mainClass;
		pid = 0;
		pass = "";
		status = false;
		name = "";
		type = "";
		f = 0;
	}

	void setStatus(boolean b)
	{
		if (b == (false))
		{
			f = 0;
			status = false;
		}

		else
		{
			f = 1;
			status = true;
		}
	}

	public int getPid() 
	{
		return pid;
	}

	public void setPid(int pid)
	{
		this.pid = pid;
	}
	
	void setName(String name)
	{
		this.name = name;
	}

	void setPassword(String pass) 
	{
		this.pass = pass;
	}

	boolean getStatus()
	{
		return status;
	}
	
	abstract String getPassword();

	abstract String getType();

	abstract String getName();

}
