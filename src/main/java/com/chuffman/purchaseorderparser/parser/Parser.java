/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chuffman.purchaseorderparser.parser;

import com.chuffman.purchaseorderparser.pojo.PurchaseOrder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Reads the CSV file and generates a HashSet of PurchaseOrder objects.
 * 
 * @author chuffman
 */
public class Parser {
    
    private ArrayList<PurchaseOrder> contents;
    private ArrayList<PurchaseOrder> duplicates;
    
    public Parser() {
        contents = new ArrayList<PurchaseOrder>();
        duplicates = new ArrayList<PurchaseOrder>();
    }
    
    public void readFile(File f) throws FileNotFoundException, IOException {
        try {
            BufferedReader in = new BufferedReader(new FileReader(f));
            String line;
            while ((line = in.readLine()) != null) {
                contents.add(parse(line));
            }
        } catch (FileNotFoundException error) {
            throw error;
        } catch (IOException error) {
            throw error;
        }
    }
    
    public PurchaseOrder parse(String line) {
        String[] items = line.split(",");
        if (items.length > 10) {
            return new PurchaseOrder(
                    Integer.valueOf(items[1]), // PO No.
                    Integer.valueOf(items[5]), // PO Line
                    items[0],                  // PO Unit
                    items[2],                  // Voucher Unit
                    items[3],                  // Voucher
                    items[4],                  // Invoice
                    items[10]);                // Description
        } else {
            return null;
        }
    }
    
    public ArrayList<PurchaseOrder> findDuplicates() {
        duplicates.clear();
        HashMap<Integer, PurchaseOrder> orders = new HashMap<Integer, PurchaseOrder>();
        Iterator it = contents.iterator();
        while (it.hasNext()) {
            PurchaseOrder po = (PurchaseOrder) it.next();
            if (orders.containsValue(po)) {
                duplicates.add(po);
                duplicates.add(orders.get(po.hashCode()));
            } else {
                orders.put(po.hashCode(),po);
            }
        }
        return duplicates;
    }

    public ArrayList<PurchaseOrder> getContents() {
        return contents;
    }

    public void setContents(ArrayList<PurchaseOrder> contents) {
        this.contents = contents;
    }

    public ArrayList<PurchaseOrder> getDuplicates() {
        return duplicates;
    }

    public void setDuplicates(ArrayList<PurchaseOrder> duplicates) {
        this.duplicates = duplicates;
    }

    
}
