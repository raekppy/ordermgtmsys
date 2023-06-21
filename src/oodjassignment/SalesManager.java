/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodjassignment;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SalesManager extends User {

    SalesManager() {
        int options;
        boolean x = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("1: Item Entry");
        System.out.println("2: Supplier Entry");
        System.out.println("3: Daily Item-wise Sales Entry");
        System.out.println("4: Create a Purchase Requisition");
        System.out.println("5: Display Requisition");
        System.out.println("6: List Of Purchase Order");
        System.out.println("7: List of Stock");
        System.out.println("8: Logout");
        options = sc.nextInt();
        FileWriter writer;
        boolean exist = true;

        try {
            switch (options) {
                case 1:
                    ItemEntry();
                    break;
                case 2:
                    SupplierEntry();
                    break;
                case 3:
                    DailySalesEntry();
                    break;
                case 4:
                    PurchaseRequisition();
                    break;
                case 5:
                    DisplayRequisition();
                    break;
                case 6:
                    DisplayPurchaseOrder();
                    break;
                case 7:
                    DisplayStock();
                    break;
                case 8:
                    Login ui = new Login();
                    ui.UI();
                    break;
                default:
                    System.out.println("Please Select The Option Shown Above.");
                    break;
            }

        } catch (Exception e) {

        }
    }

    public void ItemEntry() {
        FileWriter writer;
        int result;
        int options;
        boolean idfound = false;
        String choice;
        String exitemid = "test";
        boolean exist = true;
        int Iid = 1000;
        String Sid = null;
        ItemEntry dt = new ItemEntry();
        SupplierEntry k = new SupplierEntry();

        File b = new File("ItemEntry.txt");
        File v = new File("SupplierEntry.txt");

        Scanner sc = new Scanner(System.in);

        System.out.println("1: Add Item Entry \n2: Delete Item Entry \n3: Edit Item Entry \n4: Back \n5: Logout");
        options = sc.nextInt();

        while (options == 1) {
            try {
                Scanner c = new Scanner(v);
                if (b.exists()) {
                    exist = true;
                } else {
                    exist = false;
                    b.createNewFile();
                }
                boolean x = false;
                boolean itemexist = false;
                boolean supplierexist = false;
                System.out.println("Please Enter Supplier ID: ");
                Sid = sc.next();
                while (c.hasNextLine()) {
                    String nl = c.nextLine();
                    String column[] = nl.split(",");

                    if (column[0].equals(Sid)) {
                        x = true;
                        dt.setSupplierId(Sid);
                        dt.setSupplierName(column[1]);
                        dt.setItemName(column[4]);
                    }
                }

                c.close();

                if (x == true) {

                    FileReader fradd = new FileReader("ItemEntry.txt");
                    BufferedReader bradd = new BufferedReader(fradd);
                    String thisline;

                    while ((thisline = bradd.readLine()) != null) {
                        String word[] = thisline.split(",");
                        result = Integer.parseInt(word[0]);
                        if (dt.getItemName().equals(word[1]) && Sid.equals(word[2])) {
                            itemexist = true;
                            supplierexist = true;
                            exitemid = word[0];
                        } else if (dt.getItemName().equals(word[1]) && !Sid.equals(word[2])) {
                            itemexist = true;
                            exitemid = word[0];
                        } else {
                            Iid = result + 1;
                        }
                    }

                    if (itemexist == true && supplierexist == false) {
                        System.out.print("Your Item ID: " + exitemid);
                        dt.setItemId(String.valueOf(exitemid));
                        System.out.println("Item Name: " + dt.getItemName());
                        System.out.println("Please Enter Item Price: ");
                        dt.setItemPrice(sc.nextDouble());
                        System.out.println(dt);
                        int loop = 1;
                        while (loop == 1) {
                            System.out.println("Do you want to save the record? y/n");
                            choice = sc.next();
                            if (choice.equals("y")) {
                                System.out.println("Record Saved");
                                break;
                            } else if (choice.equals("n")) {
                                SalesManager sm = new SalesManager();
                            } else {
                                System.out.println("Please enter Y or N only!");
                            }
                        }
                        try {
                            writer = new FileWriter("ItemEntry.txt", true);
                            writer.write(dt.toString());
                            writer.write("\r" + "\n");
                            writer.close();
                            System.out.println(dt.toString());
                            SalesManager sm = new SalesManager();
                        } catch (IOException ex) {
                            System.out.println("File Not Found.");
                            SalesManager sm = new SalesManager();
                        }

                    } else if (supplierexist == true) {
                        System.out.println("Item already exist");
                        SalesManager hehe = new SalesManager();
                    } else if (itemexist == false) {

                        System.out.print("Your Item ID: " + Iid);
                        dt.setItemId(String.valueOf(Iid));
                        System.out.println("Item Name: " + dt.getItemName());
                        System.out.println("Please Enter Item Price: ");
                        dt.setItemPrice(sc.nextDouble());
                        System.out.println(dt);
                        int loop = 1;
                        while (loop == 1) {
                            System.out.println("Do you want to save the record? y/n");
                            choice = sc.next();
                            if (choice.equals("y")) {
                                System.out.println("Record Saved");
                                break;
                            } else if (choice.equals("n")) {
                                SalesManager sm = new SalesManager();
                            } else {
                                System.out.println("Please enter Y or N only!");
                            }

                        }

                        try {
                            writer = new FileWriter("ItemEntry.txt", true);
                            writer.write(dt.toString());
                            writer.write("\r" + "\n");
                            writer.close();
                            System.out.println(dt.toString());
                            SalesManager sm = new SalesManager();
                        } catch (IOException ex) {
                            System.out.println("File Not Found.");
                            SalesManager sm = new SalesManager();
                        }
                    }
                    fradd.close();
                    bradd.close();

                } else if (x == false) {
                    System.out.println("Supplier ID Not found !");
                    SalesManager haha = new SalesManager();
                }
            } catch (Exception e) {

            }

        }

        while (options == 2) {
            try {
                boolean idfound2 = false;
                String thisline;
                String rec;
                FileReader fr = new FileReader("ItemEntry.txt");
                BufferedReader br = new BufferedReader(fr);
                File item = new File("ItemEntry.txt");
                File temp = new File("Temp.txt");
                System.out.println("Please Enter Item ID: ");
                rec = sc.next();
                while ((thisline = br.readLine()) != null) {
                    String word[] = thisline.split(",");
                    if (rec.equals(word[0])) {
                        idfound = true;
                        int loop = 1;
                        while (loop == 1) {
                            System.out.println("Do you want to delete the record? y/n");
                            choice = sc.next();
                            if (choice.equals("y")) {
                                System.out.println("Record Deleted");
                                break;
                            } else if (choice.equals("n")) {
                                idfound2 = false;
                                temp.delete();
                                SalesManager sm = new SalesManager();
                            } else {
                                System.out.println("Please enter Y or N only!");
                            }
                        }
                    } else {
                        writer = new FileWriter("Temp.txt", true);
                        writer.write(thisline);
                        writer.write("\r" + "\n");
                        writer.close();

                    }

                }
                if (idfound == false) {
                    System.out.println("Item ID Not Exist");
                    fr.close();
                    br.close();

                }

                fr.close();
                br.close();
                item.delete();
                temp.renameTo(item);
                SalesManager sm = new SalesManager();

            } catch (Exception e) {
                System.out.println("File Not Found.");
                SalesManager sm = new SalesManager();
            }

        }
        while (options == 3) {
            try {
                String thisline;
                String rec;
                FileReader f = new FileReader("ItemEntry.txt");
                BufferedReader br = new BufferedReader(f);
                File item = new File("ItemEntry.txt");
                File temp = new File("Temp.txt");
                System.out.print("Please Enter Supplier ID: ");
                rec = sc.next();
                while ((thisline = br.readLine()) != null) {
                    String word[] = thisline.split(",");
                    if (rec.equals(word[2])) {
                        idfound = true;
                        writer = new FileWriter("Temp.txt", true);
                        dt.setItemId(word[0]);
                        dt.setItemName(word[1]);
                        dt.setSupplierId(word[2]);
                        dt.setSupplierName(word[3]);
                        System.out.println("Enter New Item's Price: ");
                        dt.setItemPrice(sc.nextDouble());
                        int loop = 1;
                        while (loop == 1) {
                            System.out.println("Do you want to modify the record? y/n");
                            choice = sc.next();
                            if (choice.equals("y")) {
                                System.out.println("Record Modified");
                                break;
                            } else if (choice.equals("n")) {
                                SalesManager sm = new SalesManager();
                            } else {
                                System.out.println("Please enter Y or N only!");
                            }
                        }
                        writer.write(dt.toString());
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
                    System.out.println("Supplier ID Not Exist");

                }

                br.close();
                f.close();
                item.delete();
                temp.renameTo(item);
                SalesManager sm = new SalesManager();

            } catch (Exception e) {
                System.out.println("File Not Found.");
                SalesManager sm = new SalesManager();
            }
        }

        while (options == 4) {
            SalesManager go = new SalesManager();

        }
        while (options == 5) {
            Login ui = new Login();
            ui.UI();
        }
    }

    public void SupplierEntry() {
        FileWriter writer;
        FileWriter writer2;
        Scanner sc = new Scanner(System.in);
        int options;
        boolean idfound = false;
        String choice;
        boolean x = false;
        boolean exist = true;
        int supid = 5000;

        File f = new File("SupplierEntry.txt");

        if (f.exists()) {
            exist = true;
        } else {
            exist = false;
            try {
                f.createNewFile();
            } catch (IOException ex) {

            }
        }

        Scanner r = null;
        try {
            r = new Scanner(f);
        } catch (FileNotFoundException ex) {

        }
        SupplierEntry tada = new SupplierEntry();
        System.out.println("1: Add Supplier Entry \n2: Delete Supplier Entry \n3: Edit Supplier Entry \n4: Back \n5: Logout");
        options = sc.nextInt();
        while (options == 1) {
            try {
                if (exist == false) {

                } else {

                    FileReader fradd = new FileReader("SupplierEntry.txt");
                    BufferedReader bradd = new BufferedReader(fradd);
                    String thisline;
                    thisline = bradd.readLine();

                    do {
                        String word[] = thisline.split(",");
                        int result = Integer.parseInt(word[0]);
                        result = result + 1;
                        supid = result;

                    } while ((thisline = bradd.readLine()) != null);
                    fradd.close();
                    bradd.close();
                }
                System.out.print("Your Supplier ID: " + supid);
                System.out.println("\nPlease Enter Supplier Name: ");
                tada.setSupplierName(sc.next());
                System.out.println("Please Enter Contact Number: ");
                tada.setContactNo(sc.nextInt());
                System.out.println("Please Enter Supplier Address: ");
                tada.setAddress(sc.next());
                System.out.println("Please Enter Supplier Item: ");
                tada.setSupplierItem(sc.next());
                System.out.println("Please Enter Item Price: ");
                tada.setItemPrice(sc.nextDouble());
                tada.setSupplierId(String.valueOf(supid));

                while (r.hasNextLine()) {
                    String nl = r.nextLine();
                    String column[] = nl.split(",");

                    if (column[0].equals(tada.getSupplierId())) {
                        x = true;
                        break;
                    } else {
                        x = false;
                    }
                }
                r.close();
                if (x == true) {
                    System.out.println("ID already exists.");
                } else {
                    int loop = 1;
                    while (loop == 1) {
                        System.out.println("Do you want to save the record? y/n");
                        choice = sc.next();
                        if (choice.equals("y")) {
                            System.out.println("Record Saved");
                            break;
                        } else if (choice.equals("n")) {
                            SalesManager sm = new SalesManager();
                        } else {
                            System.out.println("Please enter Y or N only!");
                        }
                    }
                    try {
                        writer = new FileWriter("SupplierEntry.txt", true);
                        writer.write(tada.toString());
                        writer.write("\r" + "\n");
                        writer.close();

                        writer2 = new FileWriter("TotalStock.txt", true);
                        writer2.write(tada.getSupplierItem() + "," + "0");
                        writer2.write("\r" + "\n");
                        writer2.close();

                        SalesManager sm = new SalesManager();
                    } catch (IOException ex) {
                        System.out.println("File Not Found.");
                        SalesManager sm = new SalesManager();
                    }
                }
            } catch (Exception e) {
                System.out.println("File Not Found.");
                SalesManager sm = new SalesManager();
            }
        }
        while (options == 2) {
            try {
                String thisline;
                String rec;
                FileReader fr = new FileReader("SupplierEntry.txt");
                BufferedReader br = new BufferedReader(fr);
                File sup = new File("SupplierEntry.txt");
                File temp = new File("Temp.txt");
                System.out.println("Please Enter Supplier ID: ");
                rec = sc.next();
                while ((thisline = br.readLine()) != null) {
                    String word[] = thisline.split(",");
                    if (rec.equals(word[0])) {
                        idfound = true;
                        int loop = 1;
                        while (loop == 1) {
                            System.out.println("Do you want to delete the record? y/n");
                            choice = sc.next();
                            if (choice.equals("y")) {
                                System.out.println("Record Deleted");
                                break;
                            } else if (choice.equals("n")) {
                                SalesManager sm = new SalesManager();
                            } else {
                                System.out.println("Please enter Y or N only!");
                            }
                        }
                    } else {
                        writer = new FileWriter("Temp.txt", true);
                        writer.write(thisline);
                        writer.write("\r" + "\n");
                        writer.close();
                    }
                }

                if (idfound == false) {
                    System.out.println("Supplier ID Not Exist");
                    fr.close();
                    br.close();
                }

                fr.close();
                br.close();
                r.close();
                sup.delete();
                temp.renameTo(sup);

            } catch (Exception e) {
                System.out.println("File Not Found.");
                SalesManager sm = new SalesManager();
            }

        }
        while (options == 3) {
            try {
                String thisline;
                String rec;
                FileReader b = new FileReader("SupplierEntry.txt");
                BufferedReader br = new BufferedReader(b);
                File sup = new File("SupplierEntry.txt");
                File temp = new File("Temp.txt");
                System.out.print("Please Enter Supplier ID: ");
                rec = sc.next();
                while ((thisline = br.readLine()) != null) {
                    String word[] = thisline.split(",");
                    if (rec.equals(word[0])) {
                        idfound = true;
                        writer = new FileWriter("Temp.txt", true);
                        tada.setSupplierId(word[0]);
                        tada.setSupplierName(word[1]);
                        tada.setSupplierItem(word[4]);
                        System.out.println("Enter New Contact Number: ");
                        tada.setContactNo(sc.nextInt());
                        System.out.println("Enter New Supplier Address: ");
                        tada.setAddress(sc.next());
                        System.out.println("Enter New Item Price: ");
                        tada.setItemPrice(sc.nextDouble());
                        int loop = 1;
                        while (loop == 1) {
                            System.out.println("Do you want to modify the record? y/n");
                            choice = sc.next();
                            if (choice.equals("y")) {
                                System.out.println("Record Modified");
                                break;
                            } else if (choice.equals("n")) {
                                SalesManager sm = new SalesManager();
                            } else {
                                System.out.println("Please enter Y or N only!");
                            }
                        }
                        writer.write(tada.toString());
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
                    System.out.println("Supplier ID Not Exist");
                }

                br.close();
                b.close();
                r.close();
                sup.delete();
                temp.renameTo(sup);
                SalesManager sm = new SalesManager();

            } catch (Exception e) {
                System.out.println("File Not Found.");
                SalesManager sm = new SalesManager();
            }
        }
        while (options
                == 4) {
            SalesManager go = new SalesManager();

        }
        while (options
                == 5) {
            Login ui = new Login();
            ui.UI();
        }
    }

    public void DailySalesEntry() {
        int result;
        int stockremain;
        FileWriter writer;
        int options;
        String Iid = null;
        String choice;
        int DSid = 8000;
        boolean x = false;
        boolean exist = true;
        boolean idfound = false;

        DailySalesEntry dt = new DailySalesEntry();
        ItemEntry k = new ItemEntry();
        TotalStock tsv = new TotalStock();

        File b = new File("DailySalesEntry.txt");
        File v = new File("ItemEntry.txt");

        Scanner sc = new Scanner(System.in);

        System.out.println("1: Add Daily Sales Entry \n2: Delete Daily Sales Entry \n3: Edit Daily Sales Entry \n4: Back \n5: Logout");
        options = sc.nextInt();
        while (options == 1) {
            try {
                Scanner c = new Scanner(v);
                if (b.exists()) {
                    exist = true;
                } else {
                    exist = false;
                    b.createNewFile();
                }
                System.out.println("Please Enter Item ID: ");
                Iid = sc.next();
                while (c.hasNextLine()) {
                    String nl = c.nextLine();
                    String column[] = nl.split(",");

                    if (column[0].equals(Iid)) {
                        x = true;
                        dt.setItemId(Iid);
                        dt.setItemName(column[1]);
                        dt.setItemPrice(Double.parseDouble(column[4]));

                    }
                }
                c.close();

                if (x == true) {
                    System.out.println("Item Name: " + dt.getItemName());
                    FileReader fradd = new FileReader("DailySalesEntry.txt");
                    BufferedReader bradd = new BufferedReader(fradd);
                    String thisline;

                    while ((thisline = bradd.readLine()) != null) {
                        String word[] = thisline.split(",");
                        result = Integer.parseInt(word[1]);
                        DSid = result + 1;

                    }
                    fradd.close();
                    bradd.close();
                    System.out.println("Your Daily Sales ID: " + DSid);
                    System.out.print("Please Enter Sales Quantity: ");
                    dt.setSalesQuantity(sc.nextInt());

                    try {
                        String tsl;
                        FileReader tsrd = new FileReader("TotalStock.txt");
                        BufferedReader tsbr = new BufferedReader(tsrd);
                        while ((tsl = tsbr.readLine()) != null) {
                            String wordts[] = tsl.split(",");
                            if (wordts[0].equals(dt.getItemName())) {
                                tsv.setStockRemain(Integer.parseInt(wordts[1]));
                            }
                        }
                        tsrd.close();
                    } catch (Exception e) {

                    }
                    if (dt.getSalesQuantity() <= tsv.getStockRemain()) {
                        dt.setDailySalesId(String.valueOf(DSid));
                        dt.setTotalAmount(dt.getItemPrice(), dt.getSalesQuantity());
                        System.out.println(dt);
                        int loop = 1;
                        while (loop == 1) {
                            System.out.println("Do you want to save the record? y/n");
                            choice = sc.next();
                            if (choice.equals("y")) {
                                System.out.println("Record saved");
                                break;
                            } else if (choice.equals("n")) {
                                SalesManager sm = new SalesManager();
                            } else {
                                System.out.println("Please enter Y or N only!");
                            }
                        }

                        try {
                            writer = new FileWriter("DailySalesEntry.txt", true);
                            writer.write(dt.toString());
                            writer.write("\r" + "\n");
                            writer.close();
                            System.out.println(dt.toString());

                            String tl2;
                            FileReader rd2 = new FileReader("TotalStock.txt");
                            BufferedReader br3 = new BufferedReader(rd2);
                            File ts2 = new File("TotalStock.txt");
                            File temp2 = new File("Temp.txt");
                            while ((tl2 = br3.readLine()) != null) {
                                String word3[] = tl2.split(",");
                                if (dt.getItemName().equals(word3[0])) {
                                    stockremain = Integer.parseInt(word3[1]);
                                    writer = new FileWriter("Temp.txt", true);
                                    stockremain = stockremain - dt.getSalesQuantity();
                                    writer.write(word3[0] + "," + stockremain);
                                    writer.write("\r" + "\n");
                                    writer.close();
                                } else {
                                    writer = new FileWriter("Temp.txt", true);
                                    writer.write(tl2);
                                    writer.write("\r" + "\n");
                                    writer.close();

                                }
                            }

                            rd2.close();
                            br3.close();
                            ts2.delete();
                            temp2.renameTo(ts2);
                            SalesManager sm = new SalesManager();

                        } catch (IOException ex) {
                            System.out.println("File Not Found.");
                            SalesManager sm = new SalesManager();
                        }

                    } else {
                        System.out.println("Not Enough Stock");
                        SalesManager sm = new SalesManager();
                    }

                } else if (x == false) {
                    System.out.println("Item ID Not found !");
                }
            } catch (Exception e) {

            }
        }
        while (options == 2) {
            try {
                TotalStock dt2 = new TotalStock();
                String thisline;
                String thisline2;
                String rec;
                FileReader fr = new FileReader("DailySalesEntry.txt");
                BufferedReader br = new BufferedReader(fr);
                File dse = new File("DailySalesEntry.txt");
                File temp = new File("Temp.txt");
                File temp2 = new File("Temp2.txt");
                System.out.println("Please Enter Daily Sales ID: ");
                rec = sc.next();
                while ((thisline = br.readLine()) != null) {
                    String word[] = thisline.split(",");
                    dt.setItemName(word[2]);
                    dt.setSalesQuantity(Integer.parseInt(word[3]));
                    if (rec.equals(word[1])) {
                        idfound = true;
                        FileReader c2 = new FileReader("TotalStock.txt");
                        BufferedReader br2 = new BufferedReader(c2);
                        File ts = new File("TotalStock.txt");
                        while ((thisline2 = br2.readLine()) != null) {
                            String word2[] = thisline2.split(",");

                            if (dt.getItemName().equals(word2[0])) {
                                dt2.setStockRemain(Integer.parseInt(word2[1]));
                                writer = new FileWriter("Temp2.txt", true);
                                dt2.setStockRemain(dt2.getStockRemain() + dt.getSalesQuantity());
                                dt2.setItemName(word2[0]);
                                int loop = 1;
                                while (loop == 1) {
                                    System.out.println("Do you want to delete the record? y/n");
                                    choice = sc.next();
                                    if (choice.equals("y")) {
                                        System.out.println("Record Deleted");
                                        break;
                                    } else if (choice.equals("n")) {
                                        SalesManager sm = new SalesManager();
                                    } else {
                                        System.out.println("Please enter Y or N only!");
                                    }
                                }
                                writer.write(dt2.toString());
                                writer.write("\r" + "\n");
                                writer.close();

                            } else {
                                writer = new FileWriter("Temp2.txt", true);
                                writer.write(thisline2);
                                writer.write("\r" + "\n");
                                writer.close();
                            }

                        }
                        br2.close();
                        c2.close();
                        ts.delete();
                        temp2.renameTo(ts);
                    } else {
                        writer = new FileWriter("Temp.txt", true);
                        writer.write(thisline);
                        writer.write("\r" + "\n");
                        writer.close();

                    }

                }

                if (idfound == false) {
                    System.out.println("Daily Sales ID Not Exist");

                }

                fr.close();
                br.close();
                dse.delete();
                temp.renameTo(dse);
                SalesManager sm = new SalesManager();

            } catch (Exception e) {
                System.out.println("File Not Found.");
                SalesManager sm = new SalesManager();
            }

        }
        while (options == 3) {
            try {
                TotalStock dt2 = new TotalStock();
                String thisline;
                String thisline2;
                String rec;
                File z = new File("ItemEntry.txt");
                FileReader c = new FileReader("DailySalesEntry.txt");
                BufferedReader br = new BufferedReader(c);
                File dse = new File("DailySalesEntry.txt");
                File temp = new File("Temp.txt");
                File temp2 = new File("Temp2.txt");
                System.out.print("Please Enter Daily Sales ID: ");
                rec = sc.next();

                while ((thisline = br.readLine()) != null) {
                    int rec2;
                    int minus;
                    String word[] = thisline.split(",");

                    if (rec.equals(word[1])) {
                        idfound = true;
                        writer = new FileWriter("Temp.txt", true);
                        dt.setDailySalesId(word[1]);
                        dt.setSalesQuantity(Integer.parseInt(word[3]));
                        System.out.println("Enter New Sales Quantity: ");
                        rec2 = sc.nextInt();
                        minus = (dt.getSalesQuantity() * -1) + rec2;
                        dt.setSalesQuantity(rec2);
                        dt.setItemId(word[0]);
                        dt.setItemName(word[2]);
                        dt.setItemPrice(Double.parseDouble(word[4]));
                        dt.setTotalAmount(dt.getItemPrice(), dt.getSalesQuantity());
                        int loop = 1;
                        while (loop == 1) {
                            System.out.println("Do you want to modify the record? y/n");
                            choice = sc.next();
                            if (choice.equals("y")) {
                                System.out.println("Record Modified");
                                break;
                            } else if (choice.equals("n")) {
                                SalesManager sm = new SalesManager();
                            } else {
                                System.out.println("Please enter Y or N only!");
                            }
                        }
                        writer.write(dt.toString());
                        writer.write("\r" + "\n");
                        writer.close();

                        FileReader c2 = new FileReader("TotalStock.txt");
                        BufferedReader br2 = new BufferedReader(c2);
                        File ts = new File("TotalStock.txt");
                        while ((thisline2 = br2.readLine()) != null) {
                            String word2[] = thisline2.split(",");
                            if (dt.getItemName().equals(word2[0])) {
                                dt2.setStockRemain(Integer.parseInt(word2[1]));
                                writer = new FileWriter("Temp2.txt", true);
                                dt2.setStockRemain(dt2.getStockRemain() - minus);
                                dt2.setItemName(word2[0]);
                                writer.write(dt2.toString());
                                writer.write("\r" + "\n");
                                writer.close();

                            } else {
                                writer = new FileWriter("Temp2.txt", true);
                                writer.write(thisline2);
                                writer.write("\r" + "\n");
                                writer.close();
                            }
                        }
                        br2.close();
                        c2.close();
                        ts.delete();
                        temp2.renameTo(ts);

                    } else {

                        writer = new FileWriter("Temp.txt", true);
                        writer.write(thisline);
                        writer.write("\r" + "\n");
                        writer.close();

                    }
                }

                if (idfound == false) {
                    System.out.println("Supplier ID Not Exist");

                }

                br.close();
                c.close();
                dse.delete();
                temp.renameTo(dse);
                SalesManager sm = new SalesManager();

            } catch (Exception e) {
                System.out.println("File Not Found.");
                SalesManager sm = new SalesManager();
            }
        }
        while (options == 4) {
            SalesManager go = new SalesManager();

        }
        while (options == 5) {
            Login ui = new Login();
            ui.UI();
        }
    }

    public void PurchaseRequisition() {
        FileWriter writer;
        int sel = 0;
        int options;
        int result;
        String Iid;
        String choice;
        int PRid = 9000;
        boolean x = false;
        boolean exist = true;
        boolean idfound = false;
        String today;
        Date tdy = new Date();
        SimpleDateFormat frt = new SimpleDateFormat("dd-MM-yyyy");
        today = (frt.format(tdy));

        PurchaseRequisition dt = new PurchaseRequisition();
        ItemEntry k = new ItemEntry();
        User s = new User();

        File b = new File("PurchaseRequisition.txt");
        File v = new File("ItemEntry.txt");

        Scanner sc = new Scanner(System.in);

        System.out.println("1: Add Purchase Requisition \n2: Delete Purchase Requisition \n3: Edit Purchase Requisition \n4: Back \n5: Logout");
        options = sc.nextInt();
        while (options == 1) {
            try {
                Scanner c = new Scanner(v);
                if (b.exists()) {
                    exist = true;
                } else {
                    exist = false;
                    b.createNewFile();
                }
                System.out.println("Please Enter Item ID: ");
                Iid = sc.next();
                while (c.hasNextLine()) {
                    String nl = c.nextLine();
                    String column[] = nl.split(",");

                    if (column[0].equals(Iid)) {
                        x = true;
                        dt.setItemId(Iid);
                        dt.setItemName(column[1]);

                    }
                }
                c.close();

                if (x == true) {
                    FileReader fradd = new FileReader("PurchaseRequisition.txt");
                    BufferedReader bradd = new BufferedReader(fradd);
                    String thisline;

                    while ((thisline = bradd.readLine()) != null) {
                        String word[] = thisline.split(",");
                        result = Integer.parseInt(word[0]);
                        PRid = result + 1;

                    }
                    fradd.close();
                    bradd.close();
                    System.out.println("Your Purchase Requisition ID: " + PRid);
                    dt.setPurchaseRequisitionID(String.valueOf(PRid));
                    System.out.println("Item Name: " + dt.getItemName());
                    System.out.println("Please Enter Item Quantity: ");
                    dt.setItemQuantity(sc.nextInt());
                    dt.setStatus("Pending");
                    dt.setDate(today);
                    dt.setSrole(Login.srole);
                    dt.setSMname(Login.sname);
                    dt.setProle("Pending");
                    dt.setPMname("Pending");

                    int loop = 1;
                    while (loop == 1) {
                        System.out.println("Do you want to save the record? y/n");
                        choice = sc.next();
                        if (choice.equals("y")) {
                            System.out.println("Record Saved");
                            break;
                        } else if (choice.equals("n")) {
                            SalesManager sm = new SalesManager();
                        } else {
                            System.out.println("Please enter Y or N only!");
                        }
                    }

                    try {
                        writer = new FileWriter("PurchaseRequisition.txt", true);
                        writer.write(dt.toString());
                        writer.write("\r" + "\n");
                        writer.close();
                        System.out.println(dt.toString());
                        SalesManager sm = new SalesManager();
                    } catch (IOException ex) {
                        System.out.println("File Not Found.");
                    }

                } else if (x == false) {
                    System.out.println("Item ID Not found !");
                }
            } catch (Exception e) {
                System.out.println("File Not Found.");
                SalesManager sm = new SalesManager();
            }
        }
        while (options == 2) {
            try {
                String thisline;
                String rec;
                FileReader fr = new FileReader("PurchaseRequisition.txt");
                BufferedReader br = new BufferedReader(fr);
                File pr = new File("PurchaseRequisition.txt");
                File temp = new File("Temp.txt");
                System.out.println("Please Enter Purchase Requisition ID: ");
                rec = sc.next();
                while ((thisline = br.readLine()) != null) {
                    String word[] = thisline.split(",");
                    if ((rec.equals(word[0])) && (word[4].equals("Pending"))) {
                        idfound = true;
                        int loop = 1;
                        while (loop == 1) {
                            System.out.println("Do you want to delete the record? y/n");
                            choice = sc.next();
                            if (choice.equals("y")) {
                                System.out.println("Record Deleted");
                                break;
                            } else if (choice.equals("n")) {
                                SalesManager sm = new SalesManager();
                            } else {
                                System.out.println("Please enter Y or N only!");
                            }
                        }

                    } else {
                        writer = new FileWriter("Temp.txt", true);
                        writer.write(thisline);
                        writer.write("\r" + "\n");
                        writer.close();
                    }

                }

                if (idfound == false) {
                    System.out.println("PR ID Not Exist");
                    fr.close();
                    br.close();
                }

                fr.close();
                br.close();
                pr.delete();
                temp.renameTo(pr);
                SalesManager sm = new SalesManager();

            } catch (Exception e) {
                System.out.println("File Not Found.");
                SalesManager sm = new SalesManager();
            }
        }
        while (options == 3) {
            try {
                String thisline;
                String thisline2;
                String rec;
                FileReader c = new FileReader("PurchaseRequisition.txt");
                BufferedReader br = new BufferedReader(c);
                BufferedReader br2 = new BufferedReader(c);
                File pr = new File("PurchaseRequisition.txt");
                File temp = new File("Temp.txt");
                System.out.print("Please Enter Purchase Requisition ID: ");
                rec = sc.next();
                while ((thisline = br.readLine()) != null) {
                    String word[] = thisline.split(",");
                    if ((rec.equals(word[0])) && (word[4].equals("Pending"))) {
                        idfound = true;
                        writer = new FileWriter("Temp.txt", true);
                        dt.setPurchaseRequisitionID(word[0]);
                        System.out.println("Enter New Item Quantity: ");
                        dt.setItemQuantity(sc.nextInt());
                        dt.setStatus("Pending");
                        dt.setDate(today);
                        dt.setItemId(word[1]);
                        dt.setItemName(word[2]);
                        dt.setSrole(word[6]);
                        dt.setSMname(word[7]);
                        dt.setProle(word[8]);
                        dt.setPMname(word[9]);
                        int loop = 1;
                        while (loop == 1) {
                            System.out.println("Do you want to modify the record? y/n");
                            choice = sc.next();
                            if (choice.equals("y")) {
                                System.out.println("Record Modified");
                                break;
                            } else if (choice.equals("n")) {
                                SalesManager sm = new SalesManager();
                            } else {
                                System.out.println("Please enter Y or N only!");
                            }
                        }
                        writer.write(dt.toString());
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
                    System.out.println("PR ID Not Exist");
                    br.close();
                    c.close();
                }
                br.close();
                c.close();
                pr.delete();
                temp.renameTo(pr);
                SalesManager sm = new SalesManager();

            } catch (Exception e) {
                System.out.println("File Not Found.");
                SalesManager sm = new SalesManager();
            }
        }
        while (options == 4) {
            SalesManager go = new SalesManager();

        }
        while (options == 5) {
            Login ui = new Login();
            ui.UI();
        }
    }

    public void DisplayRequisition() {
        try {
            String thisline;
            FileReader read = new FileReader("PurchaseRequisition.txt");
            BufferedReader br = new BufferedReader(read);
            File pr = new File("PurchaseRequisition");
            while ((thisline = br.readLine()) != null) {
                String[] tmp = thisline.split(",");
                if (tmp[4].equals("Pending")) {
                    System.out.println(thisline);
                }
            }
            read.close();
            SalesManager sm = new SalesManager();

        } catch (Exception e) {
            System.out.println("File Not Found.");
            SalesManager sm = new SalesManager();
        }
    }

    public void DisplayPurchaseOrder() {
        try {
            String thisline;
            FileReader read = new FileReader("PurchaseRequisition.txt");
            BufferedReader br = new BufferedReader(read);
            File ie = new File("PurchaseRequisition");
            while ((thisline = br.readLine()) != null) {
                String[] tmp = thisline.split(",");

                if (tmp[4].equals("Approved")) {
                    System.out.println(thisline);
                }
            }
            read.close();
            SalesManager sm = new SalesManager();

        } catch (Exception e) {
            System.out.println("File Not Found.");
            SalesManager sm = new SalesManager();
        }
    }

    public void DisplayStock() {
        try {
            String thisline;
            FileReader read = new FileReader("TotalStock.txt");
            BufferedReader br = new BufferedReader(read);
            File ie = new File("TotalStock");
            while ((thisline = br.readLine()) != null) {
                String[] tmp = thisline.split(",");
                System.out.println(thisline);
            }
            read.close();
            SalesManager sm = new SalesManager();

        } catch (Exception e) {
            System.out.println("File Not Found.");
            SalesManager sm = new SalesManager();
        }
    }
}
