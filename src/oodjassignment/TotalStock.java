/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodjassignment;


public class TotalStock {
    private String ItemName;
    private int StockRemain;
    
     public TotalStock(String in, int sr)
    {
       ItemName = in;
       StockRemain = sr;
    }
     
    public TotalStock(){

    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public int getStockRemain() {
        return StockRemain;
    }

    public void setStockRemain(int StockRemain) {
        this.StockRemain = StockRemain;
    }

    public String toString() {
        return ItemName + "," + StockRemain;
    }
    
    
}
