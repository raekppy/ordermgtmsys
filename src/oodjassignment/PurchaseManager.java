/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodjassignment;

import java.io.*;
import java.util.Scanner;

public class PurchaseManager extends User {

    PurchaseManager() {
        int options;
        Scanner sc = new Scanner(System.in);
        System.out.println("1: List of Items");
        System.out.println("2: List of Suppliers");
        System.out.println("3: Display Requisition");
        System.out.println("4: Generate Purchase Order");
        System.out.println("5: List of Purchaser Orders");
        System.out.println("6: List of Stock");
        System.out.println("7: Logout");
        options = sc.nextInt();

        try {
            switch (options) {
                case 1:
                    ItemList();
                    break;
                case 2:
                    SupplierList();
                    break;
                case 3:
                    DisplayRequisition();
                    break;
                case 4:
                    PurchaseOrder();
                    break;
                case 5:
                    DisplayPurchaseOrder();
                    break;
                case 6:
                    DisplayStock();
                    break;
                case 7:
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

    public void ItemList() {
        try {
            String thisline;
            FileReader read = new FileReader("ItemEntry.txt");
            BufferedReader br = new BufferedReader(read);
            File ie = new File("ItemEntry");
            while ((thisline = br.readLine()) != null) {
                System.out.println(thisline);
            }
            read.close();
            PurchaseManager pm = new PurchaseManager();

        } catch (Exception e) {
            System.out.println("File Not Found.");
            PurchaseManager pm = new PurchaseManager();
        }
    }

    public void SupplierList() {
        try {
            String thisline;
            FileReader read = new FileReader("SupplierEntry.txt");
            BufferedReader br = new BufferedReader(read);
            File ie = new File("SupplierEntry");
            while ((thisline = br.readLine()) != null) {
                System.out.println(thisline);
            }
            read.close();
            PurchaseManager pm = new PurchaseManager();

        } catch (Exception e) {
            System.out.println("File Not Found.");
            PurchaseManager pm = new PurchaseManager();
        }
    }

    public void DisplayRequisition() {
        try {
            String thisline;
            FileReader read = new FileReader("PurchaseRequisition.txt");
            BufferedReader br = new BufferedReader(read);
            File ie = new File("PurchaseRequisition");
            while ((thisline = br.readLine()) != null) {
                String[] tmp = thisline.split(",");
                if (tmp[4].equals("Pending")) {
                    System.out.println(thisline);
                }
            }
            read.close();
            PurchaseManager pm = new PurchaseManager();

        } catch (Exception e) {
            System.out.println("File Not Found.");
            PurchaseManager pm = new PurchaseManager();
        }
    }

    public void PurchaseOrder() {
        String itemname = null;
        String in;
        int stockremain;
        boolean pridfound = false;
        boolean idfound = false;
        double totalprice = 0;
        String thisline;
        String itname = null;
        String itid = null;
        int itquantity = 0;
        String sel;
        String rec;
        String choice;
        int opt;
        FileWriter writer;
        Scanner sc = new Scanner(System.in);
        PurchaseRequisition dt = new PurchaseRequisition();
        SupplierEntry k = new SupplierEntry();
        boolean exist = true;
        boolean sidfound = false;
        String Iid;
        int option;
        File b = new File("PurchaseRequisition.txt");
        File v = new File("SupplierEntry.txt");
        File ts = new File("TotalStock.txt");
        System.out.println("1: Add Purchase Order \n2: Delete Purchase Order \n3: Edit Purchase Order \n4: Back \n5: Logout");
        opt = sc.nextInt();
        while (opt == 1) {
            try {
                FileReader read = new FileReader("PurchaseRequisition.txt");
                BufferedReader br = new BufferedReader(read);
                PurchaseRequisition PR = new PurchaseRequisition();
                System.out.print("Please Enter Purchase Requisition ID: ");
                rec = sc.next();
                while ((thisline = br.readLine()) != null) {
                    String word[] = thisline.split(",");
                    if (rec.equals(word[0]) && word[4].equals("Pending")) {
                        pridfound = true;
                        itid = word[1];
                        itname = word[2];
                        itquantity = Integer.parseInt(word[3]);

                    } else {

                    }

                }

                br.close();
                read.close();
                if (pridfound == true) {
                    int j = -1;
                    Scanner c = new Scanner(v);
                    if (b.exists()) {
                        exist = true;
                    } else {
                        exist = false;
                        b.createNewFile();
                    }
                    while (c.hasNextLine()) {
                        j = j + 1;
                        String nl = c.nextLine();
                        String column[] = nl.split(",");
                        if (column[4].equals(itname)) {
                            totalprice = Double.parseDouble(column[5]) * itquantity;
                            System.out.println(column[0] + "|" + column[1] + "|" + column[4] + "|" + column[5] + " " + "x" + " " + itquantity + " " + "=" + " " + totalprice);

                        }
                    }

                    System.out.println("Select Supplier ID: ");
                    sel = sc.next();

                    if (ts.exists()) {
                        exist = true;
                    } else {
                        exist = false;
                        ts.createNewFile();
                    }

                    Scanner sids = new Scanner(v);
                    while (sids.hasNextLine()) {
                        String nl = sids.nextLine();
                        String column[] = nl.split(",");

                        if (sel.equals(column[0])) {

                            sidfound = true;
                        }
                    }
                    if (sidfound == true) {
                        try {
                            System.out.println("Total Amount = RM" + totalprice);
                            String tl;
                            PurchaseRequisition r = new PurchaseRequisition();
                            FileReader rd = new FileReader("PurchaseRequisition.txt");
                            BufferedReader br2 = new BufferedReader(rd);
                            File pr = new File("PurchaseRequisition.txt");
                            File temp = new File("Temp.txt");
                            while ((tl = br2.readLine()) != null) {
                                String word2[] = tl.split(",");
                                if (rec.equals(word2[0])) {
                                    writer = new FileWriter("Temp.txt", true);
                                    r.setStatus("Approved");
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
                                    writer.write(word2[0] + "," + word2[1] + "," + word2[2] + "," + word2[3] + "," + r.getStatus() + "," + word2[5] + "," + word2[6] + "," + word2[7] + "," + Login.prole + "," + Login.pname);
                                    writer.write("\r" + "\n");
                                    writer.close();
                                } else {
                                    writer = new FileWriter("Temp.txt", true);
                                    writer.write(tl);
                                    writer.write("\r" + "\n");
                                    writer.close();

                                }
                            }

                            rd.close();
                            br2.close();
                            pr.delete();
                            temp.renameTo(pr);

                            String tl2;
                            FileReader rd2 = new FileReader("TotalStock.txt");
                            BufferedReader br3 = new BufferedReader(rd2);
                            File ts2 = new File("TotalStock.txt");
                            File temp2 = new File("Temp.txt");
                            while ((tl2 = br3.readLine()) != null) {
                                String word3[] = tl2.split(",");
                                if (itname.equals(word3[0])) {
                                    stockremain = Integer.parseInt(word3[1]);
                                    writer = new FileWriter("Temp.txt", true);
                                    stockremain = stockremain + itquantity;
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
                            PurchaseManager pm = new PurchaseManager();

                        } catch (Exception e) {
                            System.out.println("Record Not Exist.");
                        }
                    }
                    c.close();
                } else {
                    System.out.println("Invalid PR ID!");
                }

                PurchaseManager pm = new PurchaseManager();

            } catch (Exception e) {
                System.out.println("File Not Found.");
                PurchaseManager pm = new PurchaseManager();
            }
        }
        while (opt == 2) {
            try {
                boolean prfound = false;
                TotalStock dt2 = new TotalStock();
                PurchaseRequisition pr2 = new PurchaseRequisition();
                String line;
                String rc;
                String thisline2;
                FileReader fr = new FileReader("PurchaseRequisition.txt");
                BufferedReader br = new BufferedReader(fr);
                File pr = new File("PurchaseRequisition.txt");
                File temp = new File("Temp.txt");
                System.out.println("Please Purchase Requisition ID: ");
                rc = sc.next();
                while ((line = br.readLine()) != null) {
                    String word[] = line.split(",");
                    pr2.setItemQuantity(Integer.parseInt(word[3]));
                    pr2.setItemName(word[2]);
                    if (rc.equals(word[0]) && word[4].equals("Approved")) {
                        prfound = true;
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
                        writer.write(line);
                        writer.write("\r" + "\n");
                        writer.close();

                    }

                }

                if (prfound == true) {
                    String tl2;
                    FileReader rd2 = new FileReader("TotalStock.txt");
                    BufferedReader br3 = new BufferedReader(rd2);
                    File ts2 = new File("TotalStock.txt");
                    File temp3 = new File("Temp2.txt");
                    while ((tl2 = br3.readLine()) != null) {
                        String word3[] = tl2.split(",");
                        if (pr2.getItemName().equals(word3[0])) {
                            stockremain = Integer.parseInt(word3[1]);
                            writer = new FileWriter("Temp2.txt", true);
                            stockremain = stockremain - pr2.getItemQuantity();
                            writer.write(word3[0] + "," + stockremain);
                            writer.write("\r" + "\n");
                            writer.close();
                        } else {
                            writer = new FileWriter("Temp2.txt", true);
                            writer.write(tl2);
                            writer.write("\r" + "\n");
                            writer.close();

                        }
                    }
                    br3.close();
                    rd2.close();
                    ts2.delete();
                    temp3.renameTo(ts2);
                } else {
                    System.out.println("Purchase Requisition ID Not Exist");
                    fr.close();
                    br.close();
                }

                fr.close();
                br.close();
                pr.delete();
                temp.renameTo(pr);
                PurchaseManager pm = new PurchaseManager();

            } catch (Exception e) {
                System.out.println("File Not Found.");
                PurchaseManager pm = new PurchaseManager();
            }
        }
        while (opt == 3) {
            try {
                TotalStock dt2 = new TotalStock();
                String ln;
                String re;
                String thisline2;
                FileReader f = new FileReader("PurchaseRequisition.txt");
                BufferedReader br = new BufferedReader(f);
                File pr = new File("PurchaseRequisition.txt");
                File temp = new File("Temp.txt");
                File temp2 = new File("Temp2.txt");
                System.out.print("Please Purchase Requisition ID: ");
                re = sc.next();
                while ((ln = br.readLine()) != null) {
                    String word[] = ln.split(",");
                    if (re.equals(word[0]) && word[4].equals("Approved")) {
                        idfound = true;
                        writer = new FileWriter("Temp.txt", true);
                        dt.setStatus("Pending");
                        dt.setProle("Pending");
                        dt.setPMname("Pending");
                        dt.setPurchaseRequisitionID(word[0]);
                        dt.setItemId(word[1]);
                        dt.setItemName(word[2]);
                        dt.setDate(word[5]);
                        dt.setItemQuantity(Integer.parseInt(word[3]));
                        dt.setSrole(word[6]);
                        dt.setSMname(word[7]);
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
                        File ts1 = new File("TotalStock.txt");
                        while ((thisline2 = br2.readLine()) != null) {
                            String word2[] = thisline2.split(",");

                            if (dt.getItemName().equals(word2[0])) {
                                dt2.setStockRemain(Integer.parseInt(word2[1]));
                                writer = new FileWriter("Temp2.txt", true);
                                dt2.setStockRemain(dt2.getStockRemain() - dt.getItemQuantity());
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
                        ts1.delete();
                        temp2.renameTo(ts1);

                    } else {
                        writer = new FileWriter("Temp.txt", true);
                        writer.write(ln);
                        writer.write("\r" + "\n");
                        writer.close();
                    }
                }
                if (idfound == false) {
                    System.out.println("PR ID Not Exist");
                    br.close();
                    f.close();
                }

                br.close();
                f.close();
                pr.delete();
                temp.renameTo(pr);
                PurchaseManager sm = new PurchaseManager();

            } catch (Exception e) {
                System.out.println("File Not Found.");
                PurchaseManager pm = new PurchaseManager();
            }
        }
        while (opt == 4) {
            PurchaseManager go = new PurchaseManager();

        }
        while (opt == 5) {
            Login ui = new Login();
            ui.UI();
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
            PurchaseManager pm = new PurchaseManager();

        } catch (Exception e) {
            System.out.println("File Not Found.");
            PurchaseManager pm = new PurchaseManager();
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
