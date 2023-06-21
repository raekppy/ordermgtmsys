/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodjassignment;


public class SupplierEntry {
    private String SupplierId;
    private String SupplierName;
    private int ContactNo;
    private String Address;
    private String SupplierItem;
    private double ItemPrice;
    
    public SupplierEntry(String Sid, String Sna, int No, String Loc, String Sitem, double Ip)
    {
       SupplierId = Sid;
       SupplierName = Sna;
       ContactNo = No;
       Address = Loc;
       SupplierItem = Sitem;
       ItemPrice = Ip;
    }
    public SupplierEntry(){

    }

    public double getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(double ItemPrice) {
        this.ItemPrice = ItemPrice;
    }

    public String getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(String SupplierId) {
        this.SupplierId = SupplierId;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String SupplierName) {
        this.SupplierName = SupplierName;
    }

    public int getContactNo() {
        return ContactNo;
    }

    public void setContactNo(int ContactNo) {
        this.ContactNo = ContactNo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getSupplierItem() {
        return SupplierItem;
    }

    public void setSupplierItem(String SupplierItem) {
        this.SupplierItem = SupplierItem;
    }

    public String toString() {
        return SupplierId + "," + SupplierName + "," + ContactNo + "," + Address + "," + SupplierItem + "," + ItemPrice;
    }

}
