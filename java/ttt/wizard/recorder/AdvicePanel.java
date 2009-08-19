/* AdvicePanel.java
 * Created on 29. August 2007, 08:18
 * Christian Gruber Bakk.techn
 */

package ttt.wizard.recorder;

import java.awt.event.ItemListener;

public class AdvicePanel extends javax.swing.JPanel {
    
    /** Creates new form AdvicePanel */
    public AdvicePanel() {
        initComponents();
    }
    
    /**
     * Adds a listener to the checkbox which indicates 
     * if this panel is shown next time
     * @param listener
     */
    public void addCheckBoxListener(ItemListener listener) {
        showNextTimeCheckBox.addItemListener(listener);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        TaskpanelLabel = new javax.swing.JLabel();
        handlingTextArea = new javax.swing.JTextArea();
        showNextTimeCheckBox = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        vncTextArea = new javax.swing.JTextArea();
        TaskpanelLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        setMaximumSize(new java.awt.Dimension(480, 500));
        setMinimumSize(new java.awt.Dimension(480, 500));
        setPreferredSize(new java.awt.Dimension(480, 500));
        setRequestFocusEnabled(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Controls"));
        jPanel1.setMaximumSize(new java.awt.Dimension(480, 240));
        jPanel1.setMinimumSize(new java.awt.Dimension(480, 240));
        jPanel1.setPreferredSize(new java.awt.Dimension(480, 240));
        TaskpanelLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ttt/wizard/recorder/images/Taskbar_Rec.png")));
        TaskpanelLabel.setMaximumSize(new java.awt.Dimension(100, 50));
        TaskpanelLabel.setMinimumSize(new java.awt.Dimension(100, 50));
        TaskpanelLabel.setPreferredSize(new java.awt.Dimension(100, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(9, 0, 9, 0);
        jPanel1.add(TaskpanelLabel, gridBagConstraints);

        handlingTextArea.setBackground(java.awt.SystemColor.control);
        handlingTextArea.setColumns(20);
        handlingTextArea.setEditable(false);
        handlingTextArea.setFont(new java.awt.Font("Arial Unicode MS", 0, 14));
        handlingTextArea.setLineWrap(true);
        handlingTextArea.setRows(5);
        handlingTextArea.setWrapStyleWord(true);
        handlingTextArea.setBorder(null);
        handlingTextArea.setDoubleBuffered(true);
        handlingTextArea.setMaximumSize(new java.awt.Dimension(450, 120));
        handlingTextArea.setMinimumSize(new java.awt.Dimension(450, 120));
        handlingTextArea.setPreferredSize(new java.awt.Dimension(450, 120));
        jPanel1.add(handlingTextArea, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 8, 0);
        add(jPanel1, gridBagConstraints);

        showNextTimeCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        showNextTimeCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 8, 0);
        add(showNextTimeCheckBox, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("VNC Server"));
        jPanel2.setMaximumSize(new java.awt.Dimension(480, 200));
        jPanel2.setMinimumSize(new java.awt.Dimension(480, 200));
        jPanel2.setPreferredSize(new java.awt.Dimension(480, 200));
        vncTextArea.setBackground(java.awt.SystemColor.control);
        vncTextArea.setColumns(20);
        vncTextArea.setEditable(false);
        vncTextArea.setFont(new java.awt.Font("Arial Unicode MS", 0, 14));
        vncTextArea.setLineWrap(true);
        vncTextArea.setRows(5);
        vncTextArea.setWrapStyleWord(true);
        vncTextArea.setBorder(null);
        vncTextArea.setDoubleBuffered(true);
        vncTextArea.setMaximumSize(new java.awt.Dimension(450, 100));
        vncTextArea.setMinimumSize(new java.awt.Dimension(450, 100));
        vncTextArea.setPreferredSize(new java.awt.Dimension(450, 100));
        jPanel2.add(vncTextArea, new java.awt.GridBagConstraints());

        TaskpanelLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ttt/wizard/recorder/images/Taskbar_VNC.png")));
        TaskpanelLabel1.setMaximumSize(new java.awt.Dimension(100, 50));
        TaskpanelLabel1.setMinimumSize(new java.awt.Dimension(100, 50));
        TaskpanelLabel1.setPreferredSize(new java.awt.Dimension(100, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(9, 0, 9, 0);
        jPanel2.add(TaskpanelLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 8, 0);
        add(jPanel2, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TaskpanelLabel;
    private javax.swing.JLabel TaskpanelLabel1;
    public javax.swing.JTextArea handlingTextArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JCheckBox showNextTimeCheckBox;
    public javax.swing.JTextArea vncTextArea;
    // End of variables declaration//GEN-END:variables
    
}
