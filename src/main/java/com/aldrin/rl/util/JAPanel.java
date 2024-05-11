/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.rl.util;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author Java Programming with Aldrin
 */
public class JAPanel extends JPanel {

    private int cornerRadius = 20;

    public JAPanel() {
        super();
        this.cornerRadius = getCornerRadius();
        setOpaque(false); // Ensure panel is transparent
        setForeground(new Color(108, 108, 108));
      
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g.create();

        // Enable anti-aliasing for smoother curves
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw rounded rectangle
        graphics.setColor(getBackground()); // Background color
        graphics.fillRoundRect(0, 0, width, height, getCornerRadius(), getCornerRadius());

        // Draw border
//        graphics.setColor(getForeground()); // Border color;
        graphics.setColor(getForeground()); // Border color
        graphics.drawRoundRect(0, 0, width - 1, height - 1, getCornerRadius(), getCornerRadius());

        graphics.dispose();
    }

    /**
     * @return the cornerRadius
     */
    public int getCornerRadius() {
        return cornerRadius;
    }

    /**
     * @param cornerRadius the cornerRadius to set
     */
    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
    }
}
