import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * 登入主畫面
 * @author Belle
 */
public class LoginFrame extends javax.swing.JFrame{
    
    // 圖片
    private ImageIcon imgIcon_old , imgIcon_new;
    private Image newImg;
    // 開起登入畫面
//    private LoginFrame loginFrame = new LoginFrame();
    
    public LoginFrame(){
        imgIcon_old = new ImageIcon("靠杯.png");
        newImg = imgIcon_old.getImage().getScaledInstance(860 , 648 , java.awt.Image.SCALE_SMOOTH);
        imgIcon_new = new ImageIcon(newImg);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enterContestans = new javax.swing.JButton();
        enterAdmin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 500));
        setResizable(false);

        enterContestans.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        enterContestans.setText("開始作答");
        enterContestans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        enterAdmin.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        enterAdmin.setText("admin");
        enterAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(enterContestans, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(enterAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterContestans, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * 按鈕設定
     * @param evt 
     */
    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        if(evt.getSource().equals(enterContestans)){
            // 開始比賽按鈕
            ContestantsFrame contestantsFrame = new ContestantsFrame();
            contestantsFrame.setVisible(true);
            this.setVisible(false);
        }else if(evt.getSource().equals(enterAdmin)){
            // admin 按鈕
            AdminFrame adminFrame = new AdminFrame();
            adminFrame.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_buttonActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enterAdmin;
    private javax.swing.JButton enterContestans;
    // End of variables declaration//GEN-END:variables
}
