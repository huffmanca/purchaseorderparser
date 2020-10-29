/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chuffman.purchaseorderparser.main;

import com.chuffman.purchaseorderparser.gui.ParserUI;
import com.chuffman.purchaseorderparser.pojo.PurchaseOrder;
import com.chuffman.purchaseorderparser.parser.Parser;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author chuffman
 */
public class Main {
    public static void main(String[] args){
        ParserUI gui = new ParserUI();
        gui.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent winEvet) {
                System.exit(0);
            }
        });
        gui.setTitle("Purchase Order Duplicate Parser");
        gui.setVisible(true);
    }
}
