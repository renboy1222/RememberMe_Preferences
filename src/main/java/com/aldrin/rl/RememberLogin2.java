/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.aldrin.rl;

import com.aldrin.rl.gui.JFrameApp;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Font;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Java Programming with Aldrin
 */
public class RememberLogin2 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            FlatLightLaf.setup();
            System.setProperty("flatlaf.menuBarEmbedded", "false");
            Font fontSize16 = UIManager.getFont("h3.regular.font");
            Font newFont = fontSize16.deriveFont(16);
            UIManager.put("defaultFont", newFont);
            JFrameApp app = new JFrameApp();
            app.setVisible(true);
        });
    }
}
