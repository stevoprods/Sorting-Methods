class States
{
  String name;
  String capital;
  String Abbr;
  long population;
  String region;
  int us_house_seats;

  public States(String name,String capital,String Abbr,long population,String region,  int us_house_seats)
  {
    this.name=name;
    this.capital=capital;
    this.Abbr=Abbr;
    this.population=population;
    this.region=region;
    this.us_house_seats=us_house_seats;
  }  

  public String getName()
  {
      return name;
  }

 public void setName(String name)
 {
    this.name=name;
 }

  public String getCapital()
  {
      return capital;
  }

 public void setCapital(String capital)
 {
    this.capital=capital;
 }

 public String getAbbr()
  {
      return Abbr;
  }

 public void setAbbr(String Abbr)
 {
    this.Abbr=Abbr;
 }

  public long getPopulation()
  {
      return population;
  }

 public void setPopulation(long population)
 {
    this.population=population;
 }
   
 public String getRegion()
  {
      return region;
  }

 public void setRegion(String region)
 {
    this.region=region;
 }

 public int getUs_house_seats()
  {
      return us_house_seats;
  }

 public void setUs_house_seats(int us_house_seats)
 {
    this.us_house_seats=us_house_seats;
 }

  public boolean compare(States a)
  {
      return (this.name.equals(a.name));
  }

  public void print()
  {
     System.out.printf("%-30s   %-20s  %-5s  %-10d  %-20s  %-10d\n",name,capital,Abbr,population,region,us_house_seats);
 

  }

}