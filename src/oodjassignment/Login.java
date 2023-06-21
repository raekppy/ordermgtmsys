/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodjassignment;

import java.util.Scanner;
import java.io.*;

public class Login {

    public static String srole;
    public static String prole;
    public static String sname;
    public static String pname;

    public static void main(String[] args) {
        Login ui = new Login();
        ui.UI();

    }

    public void UI() {
        int x = 1;

        PurchaseRequisition dt = new PurchaseRequisition();
        String UserId;
        String UserPw;
        int options;
        String position;
        String position2;
        Scanner sc = new Scanner(System.in);
        System.out.println("=========ORDER MANAGEMENT SYSTEM=========");
        System.out.println("Please Select Your Role: ");
        System.out.println("1: Administrator");
        System.out.println("2: Sales Manager");
        System.out.println("3: Purchase Manager");
        System.out.println("4: Exit");
        options = sc.nextInt();
        while (x == 1) {
            switch (options) {
                case 1:
                    position = ("Admin");
                    System.out.print("Please Enter Your ID: ");
                    UserId = sc.next();
                    System.out.print("Please Enter Your Password: ");
                    UserPw = sc.next();
                    try {
                        Boolean idfound = false;
                        String thisline;
                        FileReader read = new FileReader("Account.txt");
                        BufferedReader br = new BufferedReader(read);
                        while ((thisline = br.readLine()) != null) {
                            String word[] = thisline.split(",");
                            if (UserId.equals(word[0]) && UserPw.equals(word[1]) && position.equals(word[2])) {
                                br.close();
                                read.close();
                                srole = word[2];
                                sname = word[3];
                                prole = word[2];
                                pname = word[3];
                                Admin admin = new Admin();
                                idfound = true;
                                
                            } else {
                                idfound = false;

                            }
                        }

                        if (idfound == false) {
                            System.out.println("Account Not Exist.");

                        }
                        br.close();
                        read.close();
                    } catch (Exception e) {
                        System.out.println("Record Not Exist.");
                    }
                    break;
                case 2:
                    position = ("SM");
                    position2 = ("Admin");
                    System.out.print("Please Enter Your ID: ");
                    UserId = sc.next();
                    System.out.print("Please Enter Your Password: ");
                    UserPw = sc.next();
                    try {
                        Boolean idfound = false;
                        String thisline;
                        FileReader read = new FileReader("Account.txt");
                        BufferedReader br = new BufferedReader(read);
                        while ((thisline = br.readLine()) != null) {
                            String word[] = thisline.split(",");
                            if ((UserId.equals(word[0]) && UserPw.equals(word[1]) && (position.equals(word[2]))) || (UserId.equals(word[0]) && UserPw.equals(word[1]) && (position2.equals(word[2])))) {
                                idfound = true;
                                br.close();
                                read.close();
                                srole = word[2];
                                sname = word[3];
                                SalesManager sm = new SalesManager();
                            } else {
                                idfound = false;

                            }
                        }

                        if (idfound == false) {
                            System.out.println("Account Not Exist.");

                        }
                        br.close();
                        read.close();
                    } catch (Exception e) {
                        System.out.println("Record Not Exist.!!");
                    }
                    break;
                case 3:
                    position = ("PM");
                    position2 = ("Admin");
                    System.out.print("Please Enter Your ID: ");
                    UserId = sc.next();
                    System.out.print("Please Enter Your Password: ");
                    UserPw = sc.next();
                    try {
                        Boolean idfound = false;
                        String thisline;
                        FileReader read = new FileReader("Account.txt");
                        BufferedReader br = new BufferedReader(read);
                        while ((thisline = br.readLine()) != null) {
                            String word[] = thisline.split(",");
                            if ((UserId.equals(word[0]) && UserPw.equals(word[1]) && (position.equals(word[2]))) || (UserId.equals(word[0]) && UserPw.equals(word[1]) && (position2.equals(word[2])))) {
                                br.close();
                                read.close();
                                prole = word[2];
                                pname = word[3];
                                PurchaseManager pm = new PurchaseManager();
                                idfound = true;
                                break;
                            } else {
                                idfound = false;

                            }
                        }

                        if (idfound == false) {
                            System.out.println("Account Not Exist.");

                        }
                        br.close();
                        read.close();
                    } catch (Exception e) {
                        System.out.println("Record Not Exist.");
                    }
                    break;
                case 4 :
                    System.out.println("Successfully exit the program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please Select The Option Shown Above.");
                    break;
            }
        }
    }
}
