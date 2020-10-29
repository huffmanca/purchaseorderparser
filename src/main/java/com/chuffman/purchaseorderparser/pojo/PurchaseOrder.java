/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chuffman.purchaseorderparser.pojo;

/**
 * Represents a PurchaseOrder.
 * Equality is determine if a PONumber and POLine are identical. Other
 * fields can be different as needed.
 * 
 * @author chuffman
 */
public class PurchaseOrder implements Comparable {
    private int Number;
    private int Line;
    private String Unit;
    private String VoucherUnit;
    private String Voucher;
    private String Invoice;
    private String Description;
    
    public PurchaseOrder(int number, int line){
        this.Number = number;
        this.Line = line;
        this.Unit = "";
        this.VoucherUnit = "";
        this.Voucher = "";
        this.Invoice = "";
        this.Description = "";
    }
    
    public PurchaseOrder(int number, int line, String unit, String voucherUnit, String voucher,
            String invoice, String description){
        this.Number = number;
        this.Line = line;
        this.Unit = unit;
        this.VoucherUnit = voucherUnit;
        this.Voucher = voucher;
        this.Invoice = invoice;
        this.Description = description;
    }
    
    public String toString() {
        return Unit + "," + Number + "," + VoucherUnit + "," +
                Voucher + "," + Invoice + "," + Line +
                "," + Description;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this){
            return true;
        }
        
        /* Check if o is an instance of PurchaseOrder */
        if (!(o instanceof PurchaseOrder)) {
            return false;
        }
        
        PurchaseOrder po = (PurchaseOrder) o;
        if (po.Number == this.Number &&
                po.Line == this.Line) {
            return true;
        }
        return false;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public int getLine() {
        return Line;
    }

    public void setLine(int Line) {
        this.Line = Line;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    public String getVoucherUnit() {
        return VoucherUnit;
    }

    public void setVoucherUnit(String VoucherUnit) {
        this.VoucherUnit = VoucherUnit;
    }
    
    public String getVoucher() {
        return Voucher;
    }

    public void setVoucher(String Voucher) {
        this.Voucher = Voucher;
    }

    public String getInvoice() {
        return Invoice;
    }

    public void setInvoice(String Invoice) {
        this.Invoice = Invoice;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    @Override
    public int hashCode() {
        return Number + Line;
    }

    public int compareTo(PurchaseOrder po) {
        return hashCode() - po.hashCode();
    }
    
    @Override
    public int compareTo(Object po) {
        return hashCode() - po.hashCode();
    }
}
