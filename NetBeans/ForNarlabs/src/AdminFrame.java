import java.awt.BorderLayout;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.ImageIcon;

public class AdminFrame extends javax.swing.JFrame{
    // 讀檔路徑
    private final Properties prop = new Properties();
    private final String url1, url2;
    private final SomeSettings setting;
    private Thread thread_nextQuestionButton, thread_showTeamScore;
    private final AtomicBoolean pause = new AtomicBoolean(true);
    // 前置作業：題目數量、隨機題型、題目按鈕限制區
    private final int[] questionNumberList;
    private int pressAccount = 0;
    private int qNumber;
    // 設定表格以及表格內成績
    private String input = "";
    // 共 8 個中心
    private int[] score;
    // 限制 button 次數
    private int pressRestrict, restoreRestrict, radioButtonRestrict;
    // 暫存分數
    private final ArrayList<String> al_score;
    // 各個中心編號
    private int centerNumber;
    // 暫存成績
    private String tempScore;
    // 圖片
    private ImageIcon imgIcon;
    // 第一個頁面
//    private LoginPanel loginPanel;
    
    public AdminFrame(){
//        loginPanel.setVisible(true);
        // 本機的GUI路徑
//        imgIcon = new ImageIcon("D:\\NetBeans\\ForNarlabs\\TTFRILogo.png");
        // 非本機的GUI路徑
//        imgIcon = new ImageIcon("brain.png");
//        getPicture();
        // 本機的GUI路徑
        try{
//            prop.load(new FileReader("./src/app.properties"));
            prop.load(new FileReader("./app.properties"));
//            URL propertiesCompilePath = getClass().getProtectionDomain().getCodeSource().getLocation();
//            URL propertiesFile = new URL(propertiesCompilePath , "app.properties");
//            prop.load(propertiesFile.openStream());
        }catch(FileNotFoundException ex){
            System.err.println("**Error**");
            System.err.println("AdminFrame > FileNotFoundException : " + ex.toString());
        }catch(IOException ex){
            System.err.println("**Error**");
            System.err.println("AdminFrame > IOException : " + ex.toString());
        }
        url1 = prop.getProperty("filePath1");
        // 非本機的GUI路徑
        url2 = prop.getProperty("filePath2");
//        url2 = "question_new.txt";
        setting = new SomeSettings(url1);
        questionNumberList = setting.randomNumber();
        qNumber = 1;
        score = new int[8];
        al_score = new ArrayList<>();
        al_score.add("0,0,0,0,0,0,0,0");
        restoreRestrict = 0;
        setTitle("國研金頭腦");
        // 如果沒有先宣告變數，則出現此錯誤 : Exception in thread "AWT-EventQueue-0" java.lang.NullPointerException
//        buttonGroup.clearSelection();
        initComponents();
        // 放後面則沒問題
        buttonGroup.clearSelection();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        label_questionStyle = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        startPlay = new javax.swing.JButton();
        showAnswerAndNextQuestion = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        label_questionNumber = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea_question = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea_items = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        textArea_answerAndExplain = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 24)); // NOI18N
        jLabel2.setText("題目：");

        jLabel3.setFont(new java.awt.Font("微軟正黑體", 0, 24)); // NOI18N
        jLabel3.setText("選項：");

        label_questionStyle.setFont(new java.awt.Font("微軟正黑體", 0, 36)); // NOI18N
        label_questionStyle.setForeground(new java.awt.Color(0, 0, 255));
        label_questionStyle.setText("選擇題");

        jLabel5.setFont(new java.awt.Font("微軟正黑體", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("答案：");

        startPlay.setFont(new java.awt.Font("微軟正黑體", 0, 24)); // NOI18N
        startPlay.setText("start");
        startPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        showAnswerAndNextQuestion.setFont(new java.awt.Font("微軟正黑體", 0, 36)); // NOI18N
        showAnswerAndNextQuestion.setText("解答");
        showAnswerAndNextQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("微軟正黑體", 0, 36)); // NOI18N
        jLabel4.setText("題號：");

        label_questionNumber.setFont(new java.awt.Font("微軟正黑體", 0, 36)); // NOI18N
        label_questionNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_questionNumber.setText("0");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        textArea_question.setEditable(false);
        textArea_question.setColumns(20);
        textArea_question.setLineWrap(true);
        textArea_question.setFont(new java.awt.Font("微軟正黑體", 0, 24)); // NOI18N
        textArea_question.setLineWrap(true);
        textArea_question.setRows(5);
        textArea_question.setText("2016年NBA總冠軍哪隊由1:3落後逆轉奪冠?");
        textArea_question.setAutoscrolls(false);
        jScrollPane1.setViewportView(textArea_question);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        textArea_items.setEditable(false);
        textArea_items.setColumns(20);
        textArea_items.setLineWrap(true);
        textArea_items.setFont(new java.awt.Font("微軟正黑體", 0, 24)); // NOI18N
        textArea_items.setLineWrap(true);
        textArea_items.setRows(5);
        textArea_items.setText("(1)騎士隊(2)勇士隊");
        textArea_items.setAutoscrolls(false);
        textArea_items.setSelectionEnd(27);
        textArea_items.setSelectionStart(27);
        jScrollPane2.setViewportView(textArea_items);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane3.setAutoscrolls(false);

        textArea_answerAndExplain.setEditable(false);
        textArea_answerAndExplain.setColumns(20);
        textArea_question.setLineWrap(true);
        textArea_answerAndExplain.setFont(new java.awt.Font("微軟正黑體", 0, 24)); // NOI18N
        textArea_answerAndExplain.setForeground(new java.awt.Color(255, 51, 0));
        textArea_answerAndExplain.setLineWrap(true);
        textArea_answerAndExplain.setRows(5);
        textArea_answerAndExplain.setText("騎士隊，總冠軍史上第一支");
        textArea_answerAndExplain.setAutoscrolls(false);
        textArea_answerAndExplain.setSelectionEnd(27);
        textArea_answerAndExplain.setSelectionStart(27);
        jScrollPane3.setViewportView(textArea_answerAndExplain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(startPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(showAnswerAndNextQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label_questionStyle)
                                    .addGap(210, 210, 210)
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label_questionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane3))))))
                .addGap(0, 22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(label_questionNumber)
                    .addComponent(label_questionStyle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(startPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showAnswerAndNextQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        if(evt.getSource().equals(startPlay)){
            // 隱藏開始按鈕、顯示下題按鈕
            startPlay.setVisible(false);
            showAnswerAndNextQuestion.setVisible(true);
            // 開始作答
            startPlay.setText("問答中...");
            thread_nextQuestionButton = new Thread(new Runnable(){
                @Override
                public void run(){
                    textArea_answerAndExplain.setText("");
                    // 土法煉鋼，先匯出題目(只能用一次...)
                    try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(url2), "utf8"))){
                        for(int i : questionNumberList){
                            String rawdata = setting.al_allContens.get(i-1); 
                            bw.write(rawdata);
                            bw.newLine();
                        }
                    }catch(FileNotFoundException ex){
                        System.err.println("**Error**");
                        System.err.println("AdminFrame > buttonActionPerformed > run > FileNotFoundException : " + ex.toString());
                    }catch(IOException ex){
                        System.err.println("**Error**");
                        System.err.println("AdminFrame > buttonActionPerformed > run > IOException : " + ex.toString());
                    }
                    // 自動排序並選題目
//                    try(BufferedReader br = new BufferedReader(new FileReader(url2))){
                    try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(url2), "utf8"))){
                        while(br.ready()){
//                        for(int i : questionNumberList){
//                            System.out.println("***********************");
//                            System.out.println("第 " + qNumber + " 題(qNumber)");
                            // 隨機出題適用
//                            String rawdata = setting.al_allContens.get(i-1);   
                            // 土法煉鋼出題適用
                            String rawdata = br.readLine();
//                            System.out.println("rawdata = " + rawdata);
                            // 顯示題號、題目
                            String questionNumber = rawdata.split(",")[0];
                            String question = rawdata.split(",")[2];
                            label_questionNumber.setText(qNumber + "");
                            textArea_question.setText(question);
                            // 考慮題型差異
                            String questionStyle = rawdata.split(",")[1];
                            label_questionStyle.setText(questionStyle);
                            
                            if("生活".equals(questionStyle) ||
                               "歷史".equals(questionStyle) ||
                               "地理".equals(questionStyle) ||
                               "天文".equals(questionStyle) ||
                               "數學".equals(questionStyle) ||
                               "物理".equals(questionStyle) ||    
                               "國文".equals(questionStyle)){
                                // 生活 歷史 地理 音樂 天文 數學 物理 國文
                                // 如果是以上類型，則顯示選項
                                String items = rawdata.split(",")[3];
                                textArea_items.setText(items);
                            }else{
                                // 其餘題型不顯示內容
                                textArea_items.setText("");
                            }
                            synchronized(thread_nextQuestionButton){
                                try{
                                    thread_nextQuestionButton.wait();
                                    // 按鈕2：按下「解答」按鈕
                                    // 確認紐，防止亂按(不過目前有一些問題...)
                                    // 按鈕名稱顯示解答
                                    // 說明顯示時機
                                    showAnswerAndNextQuestion.setText("下一題");
                                    String answer , explain = "";
                                    if("音樂".equals(questionStyle)){
                                        // 音樂題型
                                        answer = "請放音樂";
                                        explain = "";
                                    }else{
                                        // 其他題型
                                        answer = rawdata.split(",")[4];
//                                        System.out.println(rawdata.split(",").length);
                                        if(rawdata.split(",").length >= 6){
                                            // 有說明時，才增加在答案後面
                                            explain = rawdata.split(",")[5];
                                        }
                                        answer = answer + "；" + explain;
                                    }
                                    textArea_answerAndExplain.setText(answer);
                                    pressAccount++;
                                    // 按鈕2：按下「下一題」按鈕
                                    // 先別顯示題目 wait()
                                    // 將按鈕名稱改為解答
                                    // 同時答案欄位空白話
                                    // 限制次數歸零
                                    // 紀錄上一次分數
                                    thread_nextQuestionButton.wait();
                                    showAnswerAndNextQuestion.setText("解答");
                                    textArea_answerAndExplain.setText("");
                                    pressRestrict = 0;
//                                    System.out.println("儲存第 " + qNumber + " 題分數(qNumber)");
                                    tempScore = String.format("%s,%s,%s,%s,%s,%s,%s,%s", 
                                            score[0], score[1], score[2], score[3], score[4], score[5], score[6], score[7]);                                
                                    al_score.add(tempScore);
//                                    System.out.println("startPlay : \t" + qNumber + ":" + tempScore);
                                    // radioButtonRestrict 次數歸零
                                    radioButtonRestrict = 0;
                                    // 題號+1 : qNumber++
                                    qNumber++;
                                    // 選完後關閉 radio button
                                    buttonGroup.clearSelection();
                                    // 關閉說明欄位
//                                    label_explainTitle.setVisible(false);
//                                    textArea_answerAndExplain.setVisible(false);
//                                    textArea_answerAndExplain.setAutoscrolls(false);
                                }catch(InterruptedException ex){
                                    System.err.println("**Error**");
                                    System.err.println("AdminFrame > buttonActionPerformed > run > InterruptedException : " + ex.toString());
                                }
                            }
                        }
                    }catch(IOException ex){
                        System.err.println("**Error**");
                        System.err.println("AdminFrame > buttonActionPerformed > IOException : " + ex.toString());
                    }
                }
            });
            thread_nextQuestionButton.start();
        }else if(evt.getSource().equals(showAnswerAndNextQuestion)){
            // 下一題、顯示解答
            if(pressAccount < setting.getQuestionAccount()){//<editor-fold defaultstate="collapsed" desc="...">
                // 按鈕2：按下解答按鈕
//                pause.set(false);
                synchronized(thread_nextQuestionButton){
                    thread_nextQuestionButton.notify();
                }
            }else{
                // 按鈕2：答題完畢
                synchronized(thread_nextQuestionButton){
                    thread_nextQuestionButton.notify();
                }
                startPlay.setText("全部完成!!");
                showAnswerAndNextQuestion.setText("全部完成!!");
                System.out.println("全部完成!!");
            }//</editor-fold>
        }
    }//GEN-LAST:event_buttonActionPerformed

    /**
     * 匯入圖片
     * @param imgIcon 
     */
    private void getPicture(){
//        label_ttfri_logo = new javax.swing.JLabel(imgIcon);
//        add(label_picture, BorderLayout.CENTER);
//        setVisible(true);
//        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
//        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }
    
//    public static void main(String args[]) {
//        MainFrame mainFrame = new MainFrame();
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Metal".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run(){
////                loginPanel.setVisible(true);
//                mainFrame.setVisible(true);
////                mainFrame.getContentPane().add(new MainFrame());
//                
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_questionNumber;
    private javax.swing.JLabel label_questionStyle;
    private javax.swing.JButton showAnswerAndNextQuestion;
    private javax.swing.JButton startPlay;
    private javax.swing.JTextArea textArea_answerAndExplain;
    private javax.swing.JTextArea textArea_items;
    private javax.swing.JTextArea textArea_question;
    // End of variables declaration//GEN-END:variables
}
