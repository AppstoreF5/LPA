package app.management.prototype;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AccountAcademics extends AccountParent {
	
       @Override
       public double getAmountToBePaid()
       {
           return super.amountToBePaid*0.85;
       }

        @Override
     public void buyAll(int aa) throws IOException
     {
         System.out.println("-----------------------"); System.out.println("You paid £"+this.getAmountToBePaid()+" with a discount of 15%"); System.out.println("-----------------------");
  this.amountToBePaid = 0;
  String newline = System.getProperty("line.separator");	
 
  FileWriter fw = new FileWriter(accDir+aa+".txt");
  BufferedWriter bw = new BufferedWriter(fw);
  String editLine = this.getName() + newline + this.getAddress() + newline + this.getProfession() + newline + this.getAmountToBePaid() + newline + this.getAppsPurchased() + newline + this.getPerms();
               
               bw.write(editLine);
               bw.flush();
               bw.close();
     }
     
     @Override
public void setAmountToBePaid(double amountp, int aa) throws IOException{
	String newline = System.getProperty("line.separator");	
  this.amountToBePaid = amountp*0.85;
  System.out.println("-----------------------");
  System.out.println(" Applied 15% discount");
  System.out.println("-----------------------");
  FileWriter fw = new FileWriter(accDir+aa+".txt");
  BufferedWriter bw = new BufferedWriter(fw);
  String editLine = this.getName() + newline + this.getAddress() + newline + this.getProfession() + newline + this.getAmountToBePaid() + newline + this.getAppsPurchased() + newline + this.getPerms();
               
               bw.write(editLine);
               bw.flush();
               bw.close();
}

    public AccountAcademics(int aa) throws IOException {
        super(aa);
    }
	
	


}