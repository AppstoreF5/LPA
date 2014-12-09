package app.management.prototype;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
public abstract class AccountParent {

	private String name;
	private String address;
	private String profession;
	private int appsUsedFree;
	private int appsPurchased;
	protected double amountToBePaid;
        private String perms;
        Path currentRelativePath = Paths.get("");
        public String accDir = currentRelativePath.toAbsolutePath().toString()+"\\Accounts\\";
       
public AccountParent (int aa) throws IOException
        {
          buildAccount(aa);            
        }
	
public void buildAccount(int fn)
    throws IOException
  {
    FileReader fr = new FileReader(accDir+fn+".txt");
    BufferedReader textReader = new BufferedReader(fr);
    
    int numberOfLines = 6;
    String[] textData = new String[numberOfLines];
    for (int i = 0; i < numberOfLines; i++) {
        
      textData[i] = textReader.readLine();
            
    }
    this.name = textData[0];
    this.address = textData[1];
    this.profession = textData[2];
    this.appsPurchased = Integer.parseInt(textData[4]);
    this.amountToBePaid = Double.parseDouble(textData[3]);
    this.perms = textData[5];
    textReader.close();
      
  }

public void buyAll(int aa) throws IOException
        
{ System.out.println("-----------------------"); System.out.println("You paid £"+this.amountToBePaid); System.out.println("-----------------------");
  this.amountToBePaid = 0;
  String newline = System.getProperty("line.separator");	
 
  FileWriter fw = new FileWriter(accDir+aa+".txt");
  BufferedWriter bw = new BufferedWriter(fw);
  String editLine = this.name + newline + this.address + newline + this.profession + newline + this.amountToBePaid + newline + this.appsPurchased + newline + this.perms;
               
               bw.write(editLine);
               bw.flush();
               bw.close();
}
//Setters	
	public void setName(String n){
		this.name = n;
	}
	public void setAddress(String a){
		this.address = a;
	}
	public void setProfession(String p){
		this.profession = p;
	}
	public void setAppsUsedFree(int af){
		this.appsUsedFree = af;
	}
	public void setAppsPurchased(int ap){
		this.appsPurchased = ap;
	}
	public void setAmountToBePaid(double amountp, int aa) throws IOException{
	String newline = System.getProperty("line.separator");	
  this.amountToBePaid = amountp;
  FileWriter fw = new FileWriter(accDir+aa+".txt");
  BufferedWriter bw = new BufferedWriter(fw);
  String editLine = this.name + newline + this.address + newline + this.profession + newline + this.amountToBePaid + newline + this.appsPurchased + newline + this.perms;
               
               bw.write(editLine);
               bw.flush();
               bw.close();
	}
	
	//Getters
	public String getName(){ 
		return this.name; 
	}
	public String getAddress(){ 
		return this.address; 
	}
	public String getProfession(){ 
		return this.profession; 
	}
	public int getAppsUsedFree(){ 
		return this.appsUsedFree; 
	}
	public int getAppsPurchased(){ 
		return this.appsPurchased; 
	}
	public double getAmountToBePaid(){ 
		return this.amountToBePaid; 
	}
        
        public String getPerms(){ 
		return this.perms; 
	}
}