/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gui;

/**
 *
 * @author USER
 */
import GUI.*;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Cursor;
import javax.swing.JLabel;
public class svgImage extends JLabel {
    private FlatSVGIcon svgIcon;

    public svgImage() {
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    public void setSVGImage(String image, int width, int height) {
        svgIcon = new FlatSVGIcon(image, width, height);
        setIcon(svgIcon);
    }
}
