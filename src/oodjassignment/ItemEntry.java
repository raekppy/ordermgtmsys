package oodjassignment;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric
 */
public class ItemEntry {
    private String ItemId;
    private String ItemName;
    private String SupplierId;
    private String SupplierName;
    private double ItemPrice;

    
     public ItemEntry(String Iid, String Ina, String Sid, String Suppna, double Ipri)
    {
       ItemId = Iid;
       ItemName = Ina;
       SupplierId = Sid;
       SupplierName = Suppna;
       ItemPrice = Ipri;
    }
     
    public ItemEntry(){

    }

    public String getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(String SupplierId) {
        this.SupplierId = SupplierId;
    }

    public String getItemId() {
        return ItemId;
    }

    public void setItemId(String ItemId) {
        this.ItemId = ItemId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String SupplierName) {
        this.SupplierName = SupplierName;
    }

    public double getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(double ItemPrice) {
        this.ItemPrice = ItemPrice;
    }
    
    public String toString() {
        return ItemId + "," + ItemName + "," + SupplierId + "," + SupplierName + "," + ItemPrice;
    }
}
