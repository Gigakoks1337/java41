public class Student {

  private String Name;
  private String Surname;
  private int Age;
  private String Dataurodzin;

  public Student(String name,String surname, int age, String dataurodzin) {
    Name = name;
    Surname = surname;
    Age = age;
    Dataurodzin = dataurodzin;
  }

  public String GetName() {return Name;}
  public String GetSurname() {return Surname;}
  public int GetAge() {return Age;}
  public String GetDataurodzin() {return Dataurodzin;}

  public String ToString() {
    return Name + " "+ Surname + " " + Integer.toString(Age)+ " " + Dataurodzin;
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if(data.length != 4) 
      return new Student("Parse Error", "Error", -1, "Error");
    return new Student(data[0], data[1], Integer.parseInt(data[2]), data[3]);
  }
}