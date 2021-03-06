/* VideoPanel.java
 * Created on 24. April 2007, 15:00
 * @author Christian Gruber Bakk.techn.
 */

package ttt.gui.wizard.recorder;

import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 * Shows the video and let the user adjust the cam
 */
public class VideoPanel extends javax.swing.JPanel {

    /** Creates new form VideoPanel */
    public VideoPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        diplayVideoPanel1 = new ttt.gui.wizard.recorder.DiplayVideoPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        InfoTextArea = new javax.swing.JTextArea();

        setMaximumSize(new java.awt.Dimension(480, 500));
        diplayVideoPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Video"));
        diplayVideoPanel1.setMaximumSize(new java.awt.Dimension(480, 300));
        diplayVideoPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        diplayVideoPanel1.setPreferredSize(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Info"));
        jPanel1.setMaximumSize(new java.awt.Dimension(480, 200));
        jScrollPane1.setBorder(null);
        InfoTextArea.setBackground(java.awt.SystemColor.control);
        InfoTextArea.setColumns(20);
        InfoTextArea.setEditable(false);
        InfoTextArea.setFont(new java.awt.Font("Arial Unicode MS", 0, 14));
        InfoTextArea.setLineWrap(true);
        InfoTextArea.setRows(5);
        InfoTextArea
                .setText("Below you should see the video stream of the attached camera. You can adjust your camera to get an impression of the area which will be captured. If no device or stream can be found you can go on and video capturing will be disabled.");
        InfoTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(InfoTextArea);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        		.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        		.addComponent(jPanel1,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		.addComponent(diplayVideoPanel1, GroupLayout.DEFAULT_SIZE, 300,Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        				.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(diplayVideoPanel1,GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextArea InfoTextArea;
    public ttt.gui.wizard.recorder.DiplayVideoPanel diplayVideoPanel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
