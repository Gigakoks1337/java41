/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);
      boolean wybor = true;

      while (wybor) {
        System.out.println("Menu:");
        System.out.println("1. Dodaj nowego studenta");
        System.out.println("2. Wypisz wszystkich studentów");
        System.out.println("3. Wyszukanie po nazwisku");
        System.out.println("4. Wyjście");
        System.out.print("Wybierz opcję: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
          case 1:
            System.out.println("Dodaj nowego studenta:");
            System.out.print("Imię: ");
            String name = scanner.next();
            System.out.print("Nazwisko: ");
            String surname = scanner.next();
            System.out.print("Wiek: ");
            int age = scanner.nextInt();
            System.out.print("Dataurodzin: ");
            String dataurodzin = scanner.next();
            scanner.nextLine(); 
            s.addStudent(new Student(name, surname, age, dataurodzin));
            break;
          case 2:
            System.out.println("Lista studentów:");
            var students = s.getStudents();
            for (Student current : students) {
              System.out.println(current.ToString());
            }
            break;
          case 3:
            System.out.println("Podaj nazwisko do wyszukania:");
            String surnameToFind = scanner.nextLine();
            Student foundStudent = s.findStudentByName(surnameToFind);
            if (foundStudent != null){
              System.out.println(foundStudent.ToString());
            }
            else
            System.out.println("Nie znaleziono studenta. Spróbuj ponownie.");
            break;
          case 4:
            wybor = false;
            break;
          default:
            System.out.println("Niepoprawny wybór. Spróbuj ponownie.");
            break;
        }
      }
    } catch (IOException e) {

    }
  }
}