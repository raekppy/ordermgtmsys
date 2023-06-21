/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodjassignment;

public class DailySalesEntry {
    private String ItemId;
    private String DailySalesId;
    private String ItemName;
    private int SalesQuantity;
    private double ItemPrice;
    private double TotalAmount;
    
    public DailySalesEntry(String Iid,String DSid, String Ina, int Squan, double Ipri, double Tamt)
    {
       ItemId = Iid;
       DailySalesId = DSid;
       ItemName = Ina;
       SalesQuantity = Squan;
       ItemPrice = Ipri;
       TotalAmount = Tamt;
    }
    public DailySalesEntry(){

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

    public int getSalesQuantity() {
        return SalesQuantity;
    }

    public void setSalesQuantity(int SalesQuantity) {
        this.SalesQuantity = SalesQuantity;
    }

    public double getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(double ItemPrice ) {
        
        this.ItemPrice = ItemPrice;
    }

    public double getTotalAmount() {
        return TotalAmount = ItemPrice * SalesQuantity;
    }

    public String getDailySalesId() {
        return DailySalesId;
    }

    public void setDailySalesId(String DailySalesId) {
        this.DailySalesId = DailySalesId;
    }
    

    public void setTotalAmount(double IP, double SQ) {
        
        this.TotalAmount = ItemPrice * SalesQuantity;
    }

    public String toString() {
        return ItemId + "," +  DailySalesId + "," +ItemName + "," + SalesQuantity + "," + ItemPrice + "," + TotalAmount;
    }
    
}
