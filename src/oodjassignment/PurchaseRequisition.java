/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodjassignment;

public class PurchaseRequisition {

    private String PurchaseRequisitionID;
    private String ItemId;
    private String ItemName;
    private double ItemPrice;
    private int ItemQuantity;
    private String SupplierName;
    private String Status;
    private String Date;
    private String SMname;
    private String PMname;
    private String Srole;
    private String Prole;
    
    public PurchaseRequisition(String PRid, String Iid, String Ina, double Ipri, int Iquan, String Supna, String Sts, String today , String Sr, String Sname, String Pr, String Pname) {
        PurchaseRequisitionID = PRid;
        ItemId = Iid;
        ItemName = Ina;
        ItemPrice = Ipri;
        ItemQuantity = Iquan;
        SupplierName = Supna;
        Status = Sts;
        Date = today;
        Srole = Sr;
        SMname = Sname;
        Prole = Pr;
        PMname = Pname;
    }

    public PurchaseRequisition() {

    }

    public String getPurchaseRequisitionID() {
        return PurchaseRequisitionID;
    }

    public void setPurchaseRequisitionID(String PurchaseRequisitionID) {
        this.PurchaseRequisitionID = PurchaseRequisitionID;
    }

    public String getItemId() {
        return ItemId;
    }

    public void setItemId(String ItemId) {
        this.ItemId = ItemId;
    }

    public int getItemQuantity() {
        return ItemQuantity;
    }

    public void setItemQuantity(int ItemQuantity) {
        this.ItemQuantity = ItemQuantity;
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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public double getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(double ItemPrice) {
        this.ItemPrice = ItemPrice;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getSMname() {
        return SMname;
    }

    public void setSMname(String SMname) {
        this.SMname = SMname;
    }

    public String getPMname() {
        return PMname;
    }

    public void setPMname(String PMname) {
        this.PMname = PMname;
    }

    public String getSrole() {
        return Srole;
    }

    public void setSrole(String Srole) {
        this.Srole = Srole;
    }

    public String getProle() {
        return Prole;
    }

    public void setProle(String Prole) {
        this.Prole = Prole;
    }
        
    public String toString() {
        return PurchaseRequisitionID + "," + ItemId + "," + ItemName + "," + ItemQuantity + "," + Status + "," + Date + "," + Srole + "," + SMname + "," + Prole + "," + PMname;
    }

}
