/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 *
 * @author USER
 */
public class CustomTableCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Tinh chỉnh giao diện của ô ở đây
        if (isSelected) {
            cellComponent.setBackground(Color.BLUE);
            cellComponent.setForeground(Color.WHITE);
        } else {
            cellComponent.setBackground(Color.WHITE);
            cellComponent.setForeground(Color.BLACK);
        }

        return cellComponent;
    }
}
