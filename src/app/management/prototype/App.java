

package app.management.prototype;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public final class App
{
    private  String appName;
    private  String appDesc;
    private  String dev;
    private  int pop;
    private  boolean ifAppFree = false; //Does the app cost money
    private  double cost;
    private String type;
    Path currentRelativePath = Paths.get("");
    public String appDir = currentRelativePath.toAbsolutePath().toString()+"\\Apps\\";;
    
    public App(int ap) throws IOException
    {
        buildApp(ap);
    }
    public void buildApp(int fn)
    throws IOException
  {
    FileReader fr = new FileReader(appDir+fn+".txt");
    BufferedReader textReader = new BufferedReader(fr);
    
    int numberOfLines = 5;
    
    String[] textData = new String[numberOfLines];
    
    for (int i = 0; i < numberOfLines; i++) {
        
      textData[i] = textReader.readLine();
            
    }
    this.appName = textData[0];
    this.dev = textData[2];
    this.cost = Double.parseDouble(textData[3]);
    this.appDesc = textData[1];
    this.pop = Integer.parseInt(textData[4]);
    
    textReader.close();
      
  }
    
 
    
    // Everything past here is getters and setters
    // Setters

    public  void setAppName(String appN)
    {this.appName = appN;}
    public  void setDesc(String appD)
    {this.appDesc = appD + " , " + appName;}
    public  void setDev(String appDv)
    {this.dev = appDv;}
    public  void setPop(int appP)
    {this.pop = appP;}
    public  void setIfAppFree()
    {if (this.cost <= 0)
    {this.ifAppFree = true;}
    else
    {this.ifAppFree = false;}}
    public void setCost(double appC)
    {if (appC > 0)
    {this.cost = appC;}
    else
    {this.cost = 0;}}
    public  void setType(String type)
    {this.type = type;}
    //Getters
    public  String getAppName()
    { return this.appName; }
    public  String getDesc()
    { return this.appDesc; }
    public  String getDev()
    { return this.dev; }
    public  int getPop()
    { return this.pop; }
    public  boolean getIfAppFree()
    { return this.ifAppFree; }
    public  double getCost()
    { return this.cost; }
    public  String getType()
    { return this.type; }
}

