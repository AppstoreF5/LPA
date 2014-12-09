package app.management.prototype;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.nio.file.Path;
import java.nio.file.Paths;


public class SysFunc {
    Path currentRelativePath = Paths.get("");
    public String accDir = currentRelativePath.toAbsolutePath().toString()+"\\Accounts\\";
    public String appDir = currentRelativePath.toAbsolutePath().toString()+"\\Apps\\";
    public int activeAccount;
    public int numOfAccounts = new File(accDir).list().length;
    public int numOfApps = new File(appDir).list().length;
    Scanner i = new Scanner(System.in);
    
// MENUS    
public void adminMenu() throws IOException
{   
    Account aA = new Account(activeAccount);
    Scanner in = new Scanner(System.in);    
    System.out.println("Logged in as "+aA.getName());
    System.out.println("-----------------------");
    System.out.println("What do you want to manage?");
        System.out.println("1.Accounts");
        System.out.println("2.Apps");
        System.out.println("Type a number to select an option");
        System.out.println("-----------------------");
        String choice = in.nextLine();
        switch (choice) {
            case "1":
                accMng();
                break;
            case "2":
                appMng();
                break;
            default:
            System.out.println("Not a valid option.");
                    System.out.println("-----------------------");
                    adminMenu();
                break;
        }
}
    
public void custMenu() throws IOException
{
    Account aA = new Account(activeAccount);
    Scanner in = new Scanner(System.in);   
    System.out.println("Logged in as "+aA.getName()+" with £"+aA.getAmountToBePaid()+" to be paid (Student and Academic discounts are applied at checkout)");
    System.out.println("-----------------------");
    System.out.println("Main Menu?");
        System.out.println("1.Edit Account");
        System.out.println("2.View all apps");
        System.out.println("3.View specific app");
        System.out.println("4.Buy all Apps in Basket");
        System.out.println("Type a number to select an option");
        System.out.println("-----------------------");
        String choice = in.nextLine();
        switch (choice) {
            case "1":
                custEditAcc(activeAccount);
                break;
            case "2":
                listApps();
                break;
            case "3":
               searchApp();
                break;
            case "4":
                if(aA.getProfession().equalsIgnoreCase("Student"))
                { AccountStudents aS = new AccountStudents(activeAccount);
                  
                aS.buyAll(activeAccount);
                      chkPrm();
                } else if (aA.getProfession().equalsIgnoreCase("Academic"))
                { AccountAcademics aAc = new AccountAcademics(activeAccount);
                   
                aAc.buyAll(activeAccount);
                    chkPrm();
                }
                    aA.buyAll(activeAccount);
                    chkPrm();
                break;
            default:
            System.out.println("Not a valid option.");
                    System.out.println("-----------------------");
                    adminMenu();
                break;
}
}

public void devMenu() throws IOException
{
    Account aA = new Account(activeAccount);
    Scanner in = new Scanner(System.in);    
    System.out.println("Logged in as "+aA.getName()+" with £"+aA.getAmountToBePaid()+" to be paid");
    System.out.println("-----------------------");
    System.out.println("Main Menu?");
        System.out.println("1.Edit Account");
        System.out.println("2.View all apps");
        System.out.println("3.View specific app");
        System.out.println("4.Create new App");
        System.out.println("Type a number to select an option");
        System.out.println("-----------------------");
        String choice = in.nextLine();
        switch (choice) {
            case "1":
                custEditAcc(activeAccount);
                break;
            case "2":
                listApps();
                break;
            case "3":
               searchApp();
                break;
            case "4":
               createApp();
                break;
            default:
            System.out.println("Not a valid option.");
                    System.out.println("-----------------------");
                    adminMenu();
                break;
}
}

public void accMng() throws IOException
{
    Scanner in = new Scanner(System.in);  
    System.out.println("-----------------------");
    System.out.println("Account Management Menu");
           System.out.println("1.Create New Account");
           System.out.println("2.Delete account");
           System.out.println("3.Edit Account");
           System.out.println("4.Search for account");
           System.out.println("5.Display total Accounts");
           System.out.println("6.List Accounts");
           System.out.println("7.Return to Main Menu");
           System.out.println("Type a number to select an option");
           System.out.println("-----------------------");
           String choice = in.nextLine();
        switch (choice) {
            case "1":
                createAcc(false);
                break;
            case "2":
                deleteAcc();
                break;
            case "3":
                editAcc();
                break;
            case "4":
                searchAcc();
                break;
            case "5":
                System.out.println("-----------------------");
                System.out.println("There are currently "+numOfAccounts+" accounts.");
                
                accMng();
                break;
            case "7":
                adminMenu();
                break;
            case "6":
                listAccounts();
                break;
            default:
                System.out.println("-----------------------");
                System.out.println("Not a valid option.");
                System.out.println("-----------------------");
                accMng();
                break;
                
        }
           
    }
    
public void appMng() throws IOException
{
    Scanner in = new Scanner(System.in);   
    System.out.println("-----------------------");
    System.out.println("App Management Menu");
           System.out.println("1.Create New App");
           System.out.println("2.Delete App");
           System.out.println("3.Edit App");
           System.out.println("4.Search for App");
           System.out.println("5.Display total Apps");
           System.out.println("6.List all Apps");
           System.out.println("7.Return to Main Menu");
           System.out.println("Type a number to select an option");
           String choice = in.nextLine();
        switch (choice) {
            case "1":
                createApp();
                break;
            case "2":
                deleteApp();
                break;
            case "3":
                editApp();
                break;
            case "4":
                searchApp();
                break;
            case "5":
                System.out.println("There are currently "+numOfApps+" App(s).");
                appMng();
                break;
            case "6":
                listApps();
                break;
            case "7":
                adminMenu();
                break;
            default:
                System.out.println("Not a valid option.");
                System.out.println("-----------------------");
                appMng();
                break;
        }
   }

public void logIn() throws IOException
{
    System.out.println("Please type 'new' to create a new account, or press enter to Log In.");
       try{
        String ch = i.nextLine();
        if (ch.equalsIgnoreCase("new")){ activeAccount = 9999; createAcc(true);} 
        else { System.out.println("What is your account number?");
            activeAccount = i.nextInt(); Account aA = new Account(activeAccount);
            if (aA.getPerms().equalsIgnoreCase("c"))
          {custMenu();}
        else if(aA.getPerms().equalsIgnoreCase("d"))
          {devMenu();}
        else if(aA.getPerms().equalsIgnoreCase("a"))
          {adminMenu();}}
          
        }
        catch(IOException e) { System.out.println("That Account does not exist"); logIn();   }}
        
       

//Creators
public void createApp() throws IOException
{
    Account aA = new Account(activeAccount);
    int cNum = numOfApps;
    try{               
    Scanner in = new Scanner(System.in);  
    Scanner inc = new Scanner(System.in);
                    System.out.println("What is the App's name?");
                    String n = inc.nextLine();
                    System.out.println("What is the App's description?");
                    String a = in.nextLine();
                    System.out.println("What is the Developer name?");
                    String p = inc.nextLine();
                    System.out.println("What is the App's cost? (GBP)");
                    String c = in.nextLine();
                    double pt = (int)(Math.random()*10000);
                    String pop = Double.toString(pt);
                    System.out.println("What is the type of the App?");
                    String t = inc.nextLine();
                    System.out.println("Is the App for free or for purchasing? Type 1 for Free and 2 for Purchasing");
                    int ifp = in.nextInt();
                    String iff;
                    if(ifp==1){iff="Free";}
                    else {iff="Purchasing";}
                    
                    File f = new File(appDir+cNum+".txt");
                    do { cNum ++;} while(f.exists());
                    writeToFile(cNum, n, "app");
                    writeToFile(cNum, a, "app");
                    writeToFile(cNum, p, "app");
                    writeToFile(cNum, c, "app");
                    writeToFile(cNum, pop, "app");
                    writeToFile(cNum, t, "app");
                    writeToFile(cNum, iff, "app");
                    System.out.println("Your App has been created with the number "+cNum+".");
                    System.out.println("-----------------------");
                    numOfApps++;
                    if (aA.getPerms().equalsIgnoreCase("d"))
                    {devMenu();}
                    else if(aA.getPerms().equalsIgnoreCase("c"))
                    {custMenu();} 
                    else 
                    {appMng();}    
                    }
 catch(IOException e)
{
    System.out.println("Dun Goofed");
}
}
public void createAcc(boolean newacc) throws IOException
{
    Account aA = new Account(activeAccount); 
    int cNum = numOfAccounts;
                    Scanner in = new Scanner(System.in);          
                    System.out.println("What is your Full Name?");
                    String n = in.nextLine();
                    System.out.println("What is your address?");
                    String a = in.nextLine();
                    System.out.println("What is your your Occupation?");
                    String p = in.nextLine();
                    System.out.println("Is this a Developer account?(yes / no) ");
                    String cd = in.nextLine();
                    File f = new File(accDir+cNum);
                    do { cNum ++;} while(f.exists());
                    writeToFile(cNum, n, "acc");
                    writeToFile(cNum, a, "acc");
                    writeToFile(cNum, p, "acc");
                    writeToFile(cNum , "0", "acc");
                    writeToFile(cNum, "0", "acc");
                    if (cd.equalsIgnoreCase("yes"))
                    { writeToFile(cNum, "d", "acc"); }
                    else 
                    { writeToFile(cNum, "c", "acc"); }
                    System.out.println("Your account has been created with the number "+cNum+".");
                    System.out.println("-----------------------");
                    numOfAccounts++;


                    if(!newacc)
                    { accMng();}
                    else if(newacc) {System.out.println("Please log in with your new account number.");logIn(); }
                    }
                    
public void chkPrm() throws IOException
{
   Account aA = new Account(activeAccount);
    if(aA.getName().equalsIgnoreCase("admin"))
    {
    adminMenu();
    }
else if(aA.getPerms().equalsIgnoreCase("c"))
    {
        custMenu();
    }
else if(aA.getPerms().equalsIgnoreCase("d"))
{
    devMenu();
    }
}
public void writeToFile(int file, String textLine, String t) throws IOException
{
    String path;
    if(t.equalsIgnoreCase("acc"))
    {path = accDir+file+".txt";}
    else
    { path = appDir+file+".txt";}
    
       boolean append_to_file = true;
  FileWriter write = new FileWriter(path, append_to_file);
  PrintWriter print_line = new PrintWriter(write);
  print_line.printf("%s%n", new Object[] { textLine });
  
  print_line.close();
    }

//Deleters
public void deleteAcc() throws IOException
{
Scanner in = new Scanner(System.in);
    System.out.println("Which Account do you want to delete");
int ch = in.nextInt();
File x = new File(accDir+ch+".txt");
boolean delete = x.delete();
if(delete)
System.out.println("Deleted!");
else 
System.out.println("Cannot Delete");
accMng();
}

public void deleteApp() throws IOException
{
    Scanner in = new Scanner(System.in);
System.out.println("Which App do you want to delete? (App Number)");
int ch = in.nextInt();
File x = new File(appDir+ch+".txt");
boolean delete = x.delete();
if(delete)
System.out.println("Deleted!");
else 
System.out.println("Cannot Delete");
appMng();  
}

//Editors
public void editAcc() throws FileNotFoundException, IOException
{
    System.out.println("Which Account do you want to edit? (Account Number)");
    Scanner impor = new Scanner(System.in);
    String editLine = "hi";
    int ach = impor.nextInt();
    String path = accDir+ach+".txt";
    String newline = System.getProperty("line.separator");
    
            
            FileReader fr1 = new FileReader(path);
            BufferedReader br1 = new BufferedReader(fr1);
            

            int numberOfLines = 3;
            String[] textData = new String[numberOfLines];
            for (int b = 0; b < numberOfLines; b++) {        
            textData[b] = br1.readLine(); }
            Scanner in = new Scanner(System.in);
            System.out.println("-----------------------");
            System.out.println(textData[0]);
            System.out.println(textData[1]);
            System.out.println(textData[2]);
            System.out.println("-----------------------");
            br1.close();
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println("What do you want to edit?");
            System.out.println("type 1 for name");
            System.out.println("type 2 for Address");
            System.out.println("type 3 for Occupation");
            String inc = in.nextLine();
            System.out.println("What would you like to change it to?");
            String editMade = in.nextLine();
            switch (inc) {
            case "1":
                editLine = editMade + newline + textData[1] + newline + textData[2];
                break;
            case "2":
                editLine = textData[0] + newline + editMade + newline + textData[2];
                break;
            case "3":
                editLine = textData[0] + newline + textData[1] + newline + editMade;
                break;
        }
                  
           

            
            br1.close();
            
            bw.write(editLine);
            bw.flush();
            bw.close();
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            for (int b = 0; b < numberOfLines; b++) {
            textData[b] = br.readLine(); }
            System.out.println("-----------------------");
            System.out.println(textData[0]);
            System.out.println(textData[1]);
            System.out.println(textData[2]);
            System.out.println("-----------------------");
   accMng();
}

public void custEditAcc(int aa) throws FileNotFoundException, IOException
{try{
    System.out.println("Editing account number "+aa);
    Scanner i = new Scanner(System.in);
    String editLine = "hi";
    int ach = aa;
    String path = accDir+ach+".txt";
    String newline = System.getProperty("line.separator");
    
            
            FileReader fr1 = new FileReader(path);
            BufferedReader br1 = new BufferedReader(fr1);
            

            int numberOfLines = 6;
            String[] textData = new String[numberOfLines];
            for (int b = 0; b < numberOfLines; b++) {        
            textData[b] = br1.readLine(); }
            Scanner in = new Scanner(System.in);
            System.out.println("-----------------------");
            System.out.println("Name = "+textData[0]+" Address = "+textData[1]+" Occupation = "+textData[2]);
            System.out.println("-----------------------");
            br1.close();
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println("What do you want to edit?");
            System.out.println("type 1 for name");
            System.out.println("type 2 for Address");
            System.out.println("type 3 for Occupation");
            String inc = in.nextLine();
            System.out.println("What would you like to change it to?");
            String editMade = in.nextLine();
            switch (inc) {
            case "1":
                editLine = editMade + newline + textData[1] + newline + textData[2]+ newline + textData[3] + newline + textData[4] + newline + textData[5];
                break;
            case "2":
                editLine = textData[0] + newline + editMade + newline + textData[2] + newline + textData[3] + newline +textData[4] + newline + textData[5];
                break;
            case "3":
                editLine = textData[0] + newline + textData[1] + newline + editMade + newline + textData[3] + newline + textData[4]+ newline + textData[5];
                break;
        }
                  
           

            
            br1.close();
            
            bw.write(editLine);
            bw.flush();
            bw.close();
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            for (int b = 0; b < numberOfLines; b++) {
            textData[b] = br.readLine(); }
            System.out.println("-----------------------");
            System.out.println(textData[0]);
            System.out.println(textData[1]);
            System.out.println(textData[2]);
            System.out.println("-----------------------");
} catch(IOException e)
{
    custMenu();
}
chkPrm();
}

public void editApp() throws IOException
{
   System.out.println("Which App do you want to edit? (App Number)");
    Scanner impor = new Scanner(System.in);
    String editLine = "hi";
    int ach = impor.nextInt();
    String path = accDir+ach+".txt";
    String newline = System.getProperty("line.separator");
    
            
            FileReader fr1 = new FileReader(path);
            BufferedReader br1 = new BufferedReader(fr1);
            

            int numberOfLines = 5;
            String[] textData = new String[numberOfLines];
            for (int b = 0; b < numberOfLines; b++) {        
            textData[b] = br1.readLine(); }
            Scanner in = new Scanner(System.in);
            System.out.println("-----------------------");
            System.out.println(textData[0]);
            System.out.println(textData[1]);
            System.out.println(textData[2]);
            System.out.println("-----------------------");
            br1.close();
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println("What do you want to edit?");
            System.out.println("type 1 for name");
            System.out.println("type 2 for description");
            System.out.println("type 3 for cost");
            String inc = in.nextLine();
            System.out.println("What would you like to change it to?");
            String editMade = in.nextLine();
            switch (inc) {
            case "1":
                editLine = editMade + newline + textData[1] + newline + textData[2] + newline + textData[3] + newline + textData[4];
                break;
            case "2":
                editLine = textData[0] + newline + editMade + newline + textData[2] + newline + textData[3] + newline + textData[4];
                break;
            case "3":
                editLine = textData[0] + newline + textData[1] + newline + textData[2] + newline + Double.parseDouble(editMade) + newline + textData[4];
                break;
        }
                  
           

            
            br1.close();
            
            bw.write(editLine);
            bw.flush();
            bw.close();
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            for (int b = 0; b < numberOfLines; b++) {
            textData[b] = br.readLine(); }
            System.out.println("-----------------------");
            System.out.println(textData[0]);
            System.out.println(textData[1]);
            System.out.println(textData[2]);
            System.out.println("-----------------------");
chkPrm();
}


//Searchers
public void searchAcc() throws IOException
{
    try
    {
    Scanner in = new Scanner(System.in);
    System.out.println("What account are you looking for?(Account Number)");
   
    int an = in.nextInt();
    String path = accDir+an+".txt";
    
    Account ac = new Account(an);
    System.out.println("-----------------------");
    System.out.println(path);
    
    System.out.println("Name = "+ac.getName()+", Address = "+ac.getAddress()+", Occupation = "+ac.getProfession());  
chkPrm();
    } 
    
    catch (IOException e)
   {
       System.out.println("-----------------------");
       System.out.println("Doesn't exist");
       System.out.println("-----------------------");
chkPrm();
   }
   finally
    {
        System.out.println("-----------------------");
        System.out.println("Doesn't exist");
        System.out.println("-----------------------");
chkPrm();
    }
    }

public void listApps() throws IOException
{
    File folder = new File(appDir);
    File[] listOfFiles = folder.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {
    if (listOfFiles[i].isFile()) { 
    String[] textData = new String[5];
    FileReader fr = new FileReader(appDir+(listOfFiles[i].getName()));
    BufferedReader textReader = new BufferedReader(fr);
    for (int p = 0; p < 5; p++) {textData[p] = textReader.readLine(); }
        System.out.println("Name = "+textData[0]+" Description = "+textData[1]+" Cost = £"+textData[3]);
      } else if (listOfFiles[i].isDirectory()) {
        System.out.println("Directory " + listOfFiles[i].getName());
      }
    }
chkPrm();
    }


public void searchApp() throws IOException
{
     try {
    Account aA = new Account(activeAccount);
    Scanner in = new Scanner(System.in);
    Scanner inc = new Scanner(System.in);
    System.out.println("What App are you looking for?");
    int an = in.nextInt();
    App ap = new App(an);
    System.out.println("name = "+ap.getAppName()+", Description = "+ap.getDesc()+", Developer = "+ap.getDev()+", Cost = "+ap.getCost()); 
    System.out.println("-----------------------");
    System.out.println("Do you want to add this App to basket? (yes/no)");
    System.out.println("-----------------------");
    String ab = inc.nextLine();
    System.out.println("-----------------------");
    if(ab.equalsIgnoreCase("yes")){ double tc = aA.getAmountToBePaid()+ap.getCost();
    aA.setAmountToBePaid(tc, activeAccount); chkPrm();}
    else if (ab.equalsIgnoreCase("no")){ 
   chkPrm();

     }
     }
   catch(IOException e)
        {
      System.out.println("-----------------------");
      System.out.println("Doesn't exist");
      System.out.println("-----------------------"); 
          chkPrm();
        }
     finally {chkPrm();}
  
} 


public void listAccounts() throws IOException{
    File folder = new File(accDir);
    File[] listOfFiles = folder.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {
    if (listOfFiles[i].isFile()) { 
    String[] textData = new String[5];
    FileReader fr = new FileReader(accDir+(listOfFiles[i].getName()));
    BufferedReader textReader = new BufferedReader(fr);
    for (int p = 0; p < 3; p++) {textData[p] = textReader.readLine(); }
        System.out.println("Name = "+textData[0]+" Address = "+textData[1]+" Occupation = "+textData[2]);
      } else if (listOfFiles[i].isDirectory()) {
        System.out.println("Directory " + listOfFiles[i].getName());
        
    }
    }
    chkPrm();
    }
}





