/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodjassignment;

import java.util.Scanner;
import java.io.*;

public class Admin extends User {

    int options;
    boolean idfound = false;
    boolean x = false;
    Scanner sc = new Scanner(System.in);
    String con;
    FileWriter writer;

    Admin() {

        System.out.println("1: Add Account");
        System.out.println("2: Delete Account");
        System.out.println("3: Modify Account");
        System.out.println("4: View Account");
        System.out.println("5: Logout");
        options = sc.nextInt();

        File foa = new File("Account.txt");

        switch (options) {
            case 1:
                AddAccount();
                break;
            case 2:
                DeleteAccount();
                break;
            case 3:
                EditAccount();
                break;
            case 4:
                ViewAccount();
                break;
            case 5:
                Login ui = new Login();
                ui.UI();
                break;
            default:
                System.out.println("Please Select The Option Shown Above.");
                break;
        }
    }

    public void AddAccount() {

        System.out.println("1: Purchase Manager \n2: Sales Manager \n3: Administrator");
        options = sc.nextInt();

        while (options == 1) {

            setRole("PM");
            System.out.print("Please Enter Your ID: ");
            setUserId(sc.next());
            try {
                File db = new File("Account.txt");
                Scanner read = new Scanner(db);
                while (read.hasNextLine()) {
                    String nl = read.nextLine();
                    String column[] = nl.split(",");
                    if (column[0].equals(getUserId())) {
                        x = true;
                        break;
                    } else {
                        x = false;
                    }
                }
                if (x == true) {
                    System.out.println("Account already exists.");
                } else {
                    System.out.print("Please Enter Your Password: ");
                    setUserPw(sc.next());
                    System.out.print("Please Enter Your Name: ");
                    setName(sc.next());
                    System.out.print("Please Enter Your Handphone Number: ");
                    setTelNumber(sc.nextInt());
                    System.out.print("Please Enter Your Email: ");
                    setEmail(sc.next());
                    int loop = 1;
                    while (loop == 1) {
                        System.out.println("Do you want to save the record? y/n");
                        con = sc.next();
                        if (con.equals("y")) {
                            break;
                        } else if (con.equals("n")) {
                            Admin admin = new Admin();
                        } else {
                            System.out.println("Please enter Y or N only!");
                        }
                    }
                    try {
                        writer = new FileWriter("Account.txt", true);
                        writer.write(toString());
                        writer.write("\r" + "\n");
                        writer.close();
                        read.close();
                        Admin admin = new Admin();
                    } catch (IOException ex) {
                        System.out.println("File Not Found.");
                        read.close();
                        Admin admin = new Admin();
                    }
                    
                }

            } catch (Exception e) {
            }
        }
        while (options == 2) {
            setRole("SM");
            System.out.print("Please Enter Your ID: ");
            setUserId(sc.next());
            try {
                File db = new File("Account.txt");
                Scanner read = new Scanner(db);
                while (read.hasNextLine()) {
                    String nl = read.nextLine();
                    String column[] = nl.split(",");
                    if (column[0].equals(getUserId())) {
                        x = true;
                        break;
                    } else {
                        x = false;
                    }
                }
                if (x == true) {
                    System.out.println("Account already exists.");
                } else {
                    System.out.print("Please Enter Your Password: ");
                    setUserPw(sc.next());
                    System.out.print("Please Enter Your Name: ");
                    setName(sc.next());
                    System.out.print("Please Enter Your Handphone Number: ");
                    setTelNumber(sc.nextInt());
                    System.out.print("Please Enter Your Email: ");
                    setEmail(sc.next());

                    int loop = 1;
                    while (loop == 1) {
                        System.out.println("Do you want to save the record? y/n");
                        con = sc.next();
                        if (con.equals("y")) {
                            break;
                        } else if (con.equals("n")) {
                            Admin admin = new Admin();
                        } else {
                            System.out.println("Please enter Y or N only!");
                        }
                    }
                    try {
                        writer = new FileWriter("Account.txt", true);
                        writer.write(toString());
                        writer.write("\r" + "\n");
                        writer.close();
read.close();
                        Admin admin = new Admin();
                    } catch (IOException ex) {
                        System.out.println("File Not Found.");read.close();
                        Admin admin = new Admin();
                    }
                  //  read.close();
                }
            } catch (Exception e) {
            }
        }
        
        while (options == 3) {
            setRole("Admin");
            System.out.print("Please Enter Your ID: ");
            setUserId(sc.next());
            try {
                File db = new File("Account.txt");
                Scanner read = new Scanner(db);
                while (read.hasNextLine()) {
                    String nl = read.nextLine();
                    String column[] = nl.split(",");
                    if (column[0].equals(getUserId())) {
                        x = true;
                        break;
                    } else {
                        x = false;
                    }
                }
                if (x == true) {
                    System.out.println("Account already exists.");
                } else {
                    System.out.print("Please Enter Your Password: ");
                    setUserPw(sc.next());
                    System.out.print("Please Enter Your Name: ");
                    setName(sc.next());
                    System.out.print("Please Enter Your Handphone Number: ");
                    setTelNumber(sc.nextInt());
                    System.out.print("Please Enter Your Email: ");
                    setEmail(sc.next());

                    int loop = 1;
                    while (loop == 1) {
                        System.out.println("Do you want to save the record? y/n");
                        con = sc.next();
                        if (con.equals("y")) {
                            break;
                        } else if (con.equals("n")) {
                            Admin admin = new Admin();
                        } else {
                            System.out.println("Please enter Y or N only!");
                        }
                    }
                    try {
                        writer = new FileWriter("Account.txt", true);
                        writer.write(toString());
                        writer.write("\r" + "\n");
                        writer.close();read.close();
                        Admin admin = new Admin();
                    } catch (IOException ex) {
                        System.out.println("File Not Found.");read.close();
                        Admin admin = new Admin();
                    }
                 //   read.close();
                }

            } catch (Exception e) {

            }
        }

    }

    public void DeleteAccount() {

        try {
            boolean idfound2 = false;
            String thisline;
            String rec;
            FileReader read = new FileReader("Account.txt");
            BufferedReader br = new BufferedReader(read);
            File acc = new File("Account.txt");
            File temp = new File("Temp.txt");
            System.out.println("Please Enter Your User ID: ");
            rec = sc.next();
            while ((thisline = br.readLine()) != null) {
                String word[] = thisline.split(",");
                if (rec.equals(word[0])) {
                    idfound2 = true;
                    int loop = 1;
                    while (loop == 1) {
                        System.out.println("Do you want to delete the record? y/n");
                        con = sc.next();
                        if (con.equals("y")) {
                    //        idfound2 = true;
                            System.out.println("Deleted"); br.close();
                read.close();
                acc.delete();
                temp.renameTo(acc);
                Admin admin = new Admin();
    //                        Admin admin = new Admin();
                        } else if (con.equals("n")) {
                            br.close();
                read.close();
                temp.delete();
                           // idfound2 = false;
                            //temp.delete();
      //                      Admin admin = new Admin();
                        } else {
                            System.out.println("Please enter Y or N only!");
                        }
                    }

                } else {
                    writer = new FileWriter("Temp.txt", true);
                    writer.write(thisline+"\r" + "\n");
                    writer.close();
                }

            }
            if (idfound2 == false) {
                System.out.println("Invalid User ID");
                br.close();
                read.close();
                temp.delete();
            }

            Admin admin = new Admin();
        } catch (Exception e) {
            System.out.println("File Not Exist.");
            Admin admin = new Admin();
        }
    }

    public void EditAccount() {
        try {
            String thisline;
            String rec;
            FileReader read = new FileReader("Account.txt");
            BufferedReader br = new BufferedReader(read);
            File acc = new File("Account.txt");
            File temp = new File("Temp.txt");
            System.out.println("Please Enter Your User ID: ");
            rec = sc.next();
            while ((thisline = br.readLine()) != null) {
                String word[] = thisline.split(",");
                if (rec.equals(word[0])) {
                    idfound = true;
                    writer = new FileWriter("Temp.txt", true);
                    setUserId(word[0]);
                    setRole(word[2]);
                    setName(word[3]);
                    System.out.println("Enter Your New Password: ");
                    setUserPw(sc.next());
                    System.out.println("Enter Your New Handphone Number: ");
                    setTelNumber(sc.nextInt());
                    System.out.println("Enter Your New Email: ");
                    setEmail(sc.next());
                    writer.write(toString());
                    writer.write("\r" + "\n");
                    writer.close();
                } else {
                    writer = new FileWriter("Temp.txt", true);
                    writer.write(thisline);
                    writer.write("\r" + "\n");
                    writer.close();
                }
            }

            if (idfound == false) {
                System.out.println("Invalid User ID");
            }
            read.close();
            acc.delete();
            temp.renameTo(acc);
            Admin admin = new Admin();
        } catch (Exception e) {
            System.out.println("File Not Exist.");
            Admin admin = new Admin();
        }
    }

    public void ViewAccount() {
        try {
            String thisline;

            FileReader read = new FileReader("Account.txt");
            BufferedReader br = new BufferedReader(read);
            File acc = new File("Account.txt");

            while ((thisline = br.readLine()) != null) {
                System.out.println(thisline);
            }
            read.close();

            Admin admion = new Admin();
        } catch (Exception e) {
            System.out.println("File Not Exist.");
            Admin admin = new Admin();
        }
    }
}
