package software;

public class Service {
	boolean buy,selected;
	float price;
	String sname;
	int ID;

	public Service()
	{
		ID=0;
		price = 0;
		sname = "";
		selected = false;
		buy = false; 
		
	}
	
	public int getServID() 
	{
		return ID;
	}

	public void setservID(int ID) 
	{
		ID=ID;
		
	}
	public boolean getIfChosen()
	{
		return selected;
	}

	public boolean getAdded() 
	{

		return !(buy); 
	}

	public void setAdded(boolean h) 
	{
		buy = h;

	}

	public void setPrice(float price) 
	{
		price = price;

	}

	public void setName(String s2)
	{
		sname= s2;

	}

	public float getPrice() {
		return price;
	}


	public void selectedbyCli(boolean l)
	{
		selected =l;

	}
	
	public String getName() 
	{
		return sname;
	}

	

	
@Override
	public String toString()
	{
		return sname + "\t \t \t" + String.valueOf(price)+"\n";
	
	}
	
	

}
