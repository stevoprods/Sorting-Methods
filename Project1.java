import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**Class Project1
 *@author Steven Fernandez
 *@version 1/22/2019
 */
class Project1
{
  States[] states;
  boolean flag=false;
  /**This method reads a CSV file into array of States objects
    *@param filename
    *@return number of records read
    */
  public int read(String filename)
  {
     String csvFile = filename;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
       int cnt=0;
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                //String[] data= line.split(cvsSplitBy);

               cnt++;

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
         }

         states=new States[cnt-1];
       int scnt=0;
          try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                if(scnt==0)
                 {
                   scnt++;
                   continue;
                }
                // use comma as separator
                String[] data= line.split(cvsSplitBy);

               states[scnt-1]=new States(data[0],data[1],data[2],Long.parseLong(data[3]),data[4],Integer.parseInt(data[5]));
               scnt++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
      return scnt;
      }
  

  /**This method prints States report
    *@param nothing
    *@return nothing
    */
  public void printStateReport()
  {
     for(int i=0;i<states.length;i++)
    {
         states[i].print();
    } 

  }

  /**This method sorts States by name using Bubble sort
    *@param nothing
    *@return nothing
    */
  public void sortByStateName()
  {
     flag=true;
      for(int i=0;i<states.length;i++)
      {
         for(int j=0;j<states.length-1;j++)
         {
             if((states[j].getName().compareTo(states[j+1].getName()))>0)
             {
                 String temp=states[j].getName();
                 states[j].setName(states[j+1].getName());
                 states[j+1].setName(temp);
                 temp=states[j].getCapital();
                 states[j].setCapital(states[j+1].getCapital());
                 states[j+1].setCapital(temp);
                 temp=states[j].getAbbr();
                 states[j].setAbbr(states[j+1].getAbbr());
                 states[j+1].setAbbr(temp);
                 long tmp=states[j].getPopulation();
                 states[j].setPopulation(states[j+1].getPopulation());
                 states[j+1].setPopulation(tmp);
                 temp=states[j].getRegion();
                 states[j].setRegion(states[j+1].getRegion());
                 states[j+1].setRegion(temp); 
                 int tmp1=states[j].getUs_house_seats();
                 states[j].setUs_house_seats(states[j+1].getUs_house_seats());
                 states[j+1].setUs_house_seats(tmp1);
                 
             }
          }
       }  
  }


   /**This method sorts all States by population using Selection Sort
     *
     */
   public void sortByPopulation()
  {
     flag=false;
      for(int i=0;i<states.length-1;i++)
      {
         int min_idx = i; 
            for (int j = i+1; j < states.length; j++) 
                if (states[j].getPopulation()< states[min_idx].getPopulation()) 
                    min_idx = j; 
                String temp=states[min_idx].getName();
                 states[min_idx].setName(states[i].getName());
                 states[i].setName(temp);
                 temp=states[min_idx].getCapital();
                 states[min_idx].setCapital(states[i].getCapital());
                 states[i].setCapital(temp);
                 temp=states[min_idx].getAbbr();
                 states[min_idx].setAbbr(states[i].getAbbr());
                 states[i].setAbbr(temp);
                 long tmp=states[min_idx].getPopulation();
                 states[min_idx].setPopulation(states[i].getPopulation());
                 states[i].setPopulation(tmp);
                 temp=states[min_idx].getRegion();
                 states[min_idx].setRegion(states[i].getRegion());
                 states[i].setRegion(temp); 
                 int tmp1=states[min_idx].getUs_house_seats();
                 states[min_idx].setUs_house_seats(states[i].getUs_house_seats());
                 states[i].setUs_house_seats(tmp1);
                 
             
          }
       }

  /**This method sorts all States by Region using Insertion Sort
   
  */
  public void sortByRegion()
  {
      flag=false;
      int n = states.length; 
        for (int i=1; i<n; ++i) 
        { 
            String key = states[i].getRegion(); 
            String kname=states[i].getName();
            String kabbr=states[i].getAbbr();
            long kpop=states[i].getPopulation();
            String kcap=states[i].getCapital();
            int uns=states[i].getUs_house_seats();
            int j = i-1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j>=0 && (states[j].getRegion().compareTo(key))>0) 
            { 
                //String temp=states[min_idx].getName();
                 states[j+1].setName(states[j].getName());
                
                 states[j+1].setCapital(states[j].getCapital());
                 
                 states[j+1].setAbbr(states[j].getAbbr());
                 states[j+1].setPopulation(states[j].getPopulation());
                 states[j+1].setRegion(states[j].getRegion());
                 states[j+1].setUs_house_seats(states[j].getUs_house_seats());
                
                
                j = j-1; 
            } 
            states[j+1].setName(kname);
                
                 states[j+1].setCapital(kcap);
                 
                 states[j+1].setAbbr(kabbr);
                 states[j+1].setPopulation(kpop);
                 states[j+1].setRegion(key);
                 states[j+1].setUs_house_seats(uns); 
              
           // arr[j+1] = key; 
        } 
 
  }
  
  /**This method peforms Sequential search if not sorted by states
    *@param state name
  */
  public void Seqsearch(String name)
  {
     for(int i=0;i<states.length-1;i++)
      {
          if(states[i].getName().equals(name))
          {
              System.out.println("Name: "+name);
              System.out.println("Capital City: "+states[i].getCapital()); 
              System.out.println("Abbr: "+states[i].getAbbr());
              System.out.println("Population: "+states[i].getPopulation());
              System.out.println("Region: "+states[i].getRegion());
              System.out.println("US House Seats: "+states[i].getUs_house_seats()); 
              return;
          }
      
     }
    System.out.println("Error State "+name+" not found");

  }

  /**This method peforms Binary search if sorted by states
    *@param state name
  */
   public void Binarysearch(String name)
  {
     int low=0;
     int high=states.length-1;
    while(low<high)
    {
       int mid=(low+high)/2;
       //System.out.println(mid);
        if(states[mid].getName().equals(name))
        {
            System.out.println("Name: "+name);
              System.out.println("Capital City: "+states[mid].getCapital()); 
              System.out.println("Abbr: "+states[mid].getAbbr());
              System.out.println("Population: "+states[mid].getPopulation());
              System.out.println("Region: "+states[mid].getRegion());
              System.out.println("US House Seats: "+states[mid].getUs_house_seats());
             return;
        }
       else if((states[mid].getName().compareTo(name))<0)
           low=mid+1;
       else
          high=mid-1;

    }
    System.out.println("Error State "+name+" not found"); 

  }

  /**main method
    
  */
  public static void main(String args[])
 {
    Project1 p1=new Project1();
    
    System.out.println("COP3538 Project 1");
    System.out.println("Instructor: Xudong Liu");
    System.out.println();
    System.out.println("Array Searches and Sorts");
    System.out.println("Enter the filename");
    Scanner in=new Scanner(System.in);
    String fname=in.nextLine();
    int nr=p1.read("States.csv");
    System.out.println();
    System.out.println("There are "+(nr-1)+ " states records read");
    System.out.println();
    while(true)
    {
      System.out.println();
      System.out.println("1. Print a state report");
      System.out.println("2. Sort by state name");
      System.out.println("3. Sort by Population");
      System.out.println("4. Sort by Region");
      System.out.println("5. Find and print a given state");
      System.out.println("6. Quit");
      System.out.println();
      
      System.out.print("Enter your choice: "); 
      in=new Scanner(System.in);
      int choice=in.nextInt();
    
      switch(choice)
      {
          case 1:System.out.printf("%-30s   %-20s  %-5s  %-10s  %-20s  %-10s\n","Name","Capital","Abbr","Population","Region","US House Seats");
                 //System.out.println("Name  Capital   Abbr Population  Region US House Seats"); 
                 System.out.println("---------------------------------------------------------------------------------------------------------");
                 p1.printStateReport();  
                 break;
          case 2: p1.sortByStateName();
                  System.out.println("States sorted by name");
                  break;
          case 3:p1.sortByPopulation();
                  System.out.println("States sorted by population");
                  break;
          case 4:p1.sortByRegion();
                  System.out.println("States sorted by region");
                  break;
          case 5:
                  System.out.println("Enter the state name");
                  in=new Scanner(System.in);
                  String statename=in.nextLine();
                  if(p1.flag==false)
                  {
                     System.out.println("Sequential Search");
                      p1.Seqsearch(statename);
                  }
                  else
                   {
                       System.out.println("Binary Search");
                       p1.Binarysearch(statename);
                   }
                     
                 
                   break;

          case 6:
                  System.exit(0);
                  break;

           default: System.out.println("invalid choice");
                    break;

       }

    }
 }
 
}