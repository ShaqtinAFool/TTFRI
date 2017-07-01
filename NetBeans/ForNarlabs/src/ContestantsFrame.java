import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.ImageIcon;

public class ContestantsFrame extends javax.swing.JFrame {
    // 讀檔路徑
    private final String userName;
    private final String url , url2;
    private final SomeSettings setting;
    private Thread thread_nextQuestionKeyPress;
    private final AtomicBoolean pause = new AtomicBoolean(true);
    // 前置作業：題目數量、隨機題型、題目按鈕限制區
//    private final int[] questionNumberList;
    private int pressAccount = 0;
    private int qNumber;
    // 設定表格以及表格內成績
    private String input = "";
    // 圖片
    private ImageIcon imgIcon;
    // 第一個頁面
//    private LoginPanel loginPanel;
    
    public ContestantsFrame(){
        // 本機的GUI路徑
//        imgIcon = new ImageIcon("D:\\NetBeans\\ForNarlabs\\TTFRILogo.png");
        // 非本機的GUI路徑
//        imgIcon = new ImageIcon("brain.png");
//        getPicture();
        userName = System.getProperty("user.name");
        // 本機的GUI路徑
        url = "D:\\NetBeans\\ForNarlabs\\question_SamanthaNew_txt.txt";
//        url = "C:\\Users\\" + userName + ".TTFRI\\Desktop\\question_小玉_txt.txt";
//        url = "C:\\Users\\" + userName + "\\Desktop\\question_小玉_txt.txt";
//        url2 = "D:\\NetBeans\\ForNarlabs\\question_SamanthaNew2_txt.txt";
        // 非本機的GUI路徑
        url2 = "question_SamanthaNew3_txt.txt";
//        url = "question_SamanthaNew_txt";
        setting = new SomeSettings(url);
//        questionNumberList = setting.randomNumber();
        qNumber = 1;
        setTitle("國研金頭腦");
        initComponents();
        // 放後面則沒問題
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        label_questionStyle = new javax.swing.JLabel();
        showAnswerAndNextQuestion = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        label_questionNumber = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea_question = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea_items = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 24)); // NOI18N
        jLabel2.setText("題目：");

        jLabel3.setFont(new java.awt.Font("微軟正黑體", 0, 24)); // NOI18N
        jLabel3.setText("選項：");

        label_questionStyle.setFont(new java.awt.Font("微軟正黑體", 0, 36)); // NOI18N
        label_questionStyle.setForeground(new java.awt.Color(0, 0, 255));
        label_questionStyle.setText("選擇題");

        showAnswerAndNextQuestion.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        showAnswerAndNextQuestion.setText("start");
        showAnswerAndNextQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });
        showAnswerAndNextQuestion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buttonKeyPressed(evt);
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
        textArea_question.setFont(new java.awt.Font("微軟正黑體", 0, 36)); // NOI18N
        textArea_question.setLineWrap(true);
        textArea_question.setRows(5);
        textArea_question.setText("今年(2016)NBA總冠軍哪隊由1:3落後逆轉奪冠?");
        textArea_question.setAutoscrolls(false);
        jScrollPane1.setViewportView(textArea_question);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        textArea_items.setEditable(false);
        textArea_items.setColumns(20);
        textArea_items.setLineWrap(true);
        textArea_items.setFont(new java.awt.Font("微軟正黑體", 0, 32)); // NOI18N
        textArea_items.setLineWrap(true);
        textArea_items.setRows(5);
        textArea_items.setText("(1)騎士隊(2)勇士隊");
        textArea_items.setAutoscrolls(false);
        textArea_items.setSelectionEnd(27);
        textArea_items.setSelectionStart(27);
        jScrollPane2.setViewportView(textArea_items);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_questionStyle)
                        .addGap(210, 210, 210)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_questionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 23, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showAnswerAndNextQuestion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(showAnswerAndNextQuestion)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_S){
            showAnswerAndNextQuestion.setVisible(true);
            // 開始作答
            thread_nextQuestionKeyPress = new Thread(new Runnable(){//<editor-fold defaultstate="collapsed" desc="節省空間">
                @Override
                public void run(){
                    // 土法煉鋼，先匯出題目(只能用一次...)
//                    try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\NetBeans\\ForNarlabs\\question_SamanthaNew2_txt.txt"), "UTF-8"))){
//                        for(int i : questionNumberList){
//                            String rawdata = setting.al_allContens.get(i-1);
//                            bw.write(rawdata);
//                            bw.newLine();
//                        }
//                    }catch(FileNotFoundException ex){
//                        System.err.println("BufferedWriter error: " + ex.toString());
//                    }catch(IOException ex){
//                        System.err.println("BufferedWriter error: " + ex.toString());
//                    }
                    // 自動排序並選題目
                    try(BufferedReader br = new BufferedReader(new FileReader(url2))){
                        while(br.ready()){
//                            for(int i : questionNumberList){
                            System.out.println("***********************");
                            System.out.println("第 " + qNumber + " 題(qNumber)");
                            // 隨機出題適用
//                            String rawdata = setting.al_allContens.get(i-1);
                            // 土法煉鋼出題適用
                            String rawdata = br.readLine();
                            // 顯示題號、題目
                            String questionNumber = rawdata.split(",")[0];
                            String question = rawdata.split(",")[2];
                            label_questionNumber.setText(qNumber + "");
                            textArea_question.setText(question);
                            // 考慮題型差異
                            String questionStyle = rawdata.split(",")[1];
                            label_questionStyle.setText(questionStyle);
                            if("選擇題".equals(questionStyle)){
                                // 如果是選擇題，則顯示選項
                                String items = rawdata.split(",")[3];
                                textArea_items.setText(items);
                            }else{
                                // 其餘題型不顯示內容
                                textArea_items.setText("");
                            }
                            synchronized(thread_nextQuestionKeyPress){
                                try{
                                    thread_nextQuestionKeyPress.wait();
                                    // 按鈕2：按下「解答」按鈕
                                    // 確認紐，防止亂按(不過目前有一些問題...)
                                    // 按鈕名稱顯示解答
                                    // 說明顯示時機
                                    showAnswerAndNextQuestion.setText("下一題");
                                    pressAccount++;
                                    // 按鈕2：按下「下一題」按鈕
                                    // 先別顯示題目 wait()
                                    // 將按鈕名稱改為解答
                                    // 同時答案欄位空白話
                                    // 限制次數歸零
                                    // 紀錄上一次分數
                                    thread_nextQuestionKeyPress.wait();
                                    // 舊式寫法
//                                    showAnswerAndNextQuestion.setText("解答");
                                    // 不顯示解答寫法
                                    showAnswerAndNextQuestion.setText("下一題");
//                                    pressRestrict = 0;
                                    System.out.println("儲存第 " + qNumber + " 題分數(qNumber)");
//                                    tempScore = String.format("%s,%s,%s,%s,%s,%s,%s,%s" ,
//                                        score[0] , score[1] , score[2] , score[3] , score[4] , score[5] , score[6] , score[7]);
//                                    al_score.add(tempScore);
//                                    System.out.println("startPlay : \t" + qNumber + ":" + tempScore);
                                    // radioButtonRestrict 次數歸零
//                                    radioButtonRestrict = 0;
                                    // 題號+1 : qNumber++
                                    qNumber++;
                                    // 選完後關閉 radio button
//                                        buttonGroup.clearSelection();
                                    // 關閉說明欄位
                                }catch(InterruptedException ex){
                                    System.err.println(ex.getLocalizedMessage());
                                }
                            }
                        }
                    }catch(IOException ex){
                        System.err.println(ex.getLocalizedMessage());
                    }
                }
            });//</editor-fold>
            thread_nextQuestionKeyPress.start();
        }else if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            // 下一題、顯示解答
            if(pressAccount < setting.getQuestionAccount()){//<editor-fold defaultstate="collapsed" desc="節省空間">
                // 按鈕2：按下解答按鈕
                synchronized(thread_nextQuestionKeyPress){
                    thread_nextQuestionKeyPress.notify();
                }
            }else{
                // 按鈕2：答題完畢
                synchronized(thread_nextQuestionKeyPress){
                    thread_nextQuestionKeyPress.notify();
                }
                showAnswerAndNextQuestion.setText("全部完成!!");
                System.out.println("全部完成!!");
            }//</editor-fold>
        }
    }//GEN-LAST:event_buttonKeyPressed

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        
    }//GEN-LAST:event_buttonActionPerformed

    /**
     * 匯入圖片
     * @param imgIcon 
     */
    private void getPicture(){
//        label_ttfri_logo = new javax.swing.JLabel(imgIcon);
//        add(label_picture , BorderLayout.CENTER);
//        setVisible(true);
//        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
//        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_questionNumber;
    private javax.swing.JLabel label_questionStyle;
    private javax.swing.JButton showAnswerAndNextQuestion;
    private javax.swing.JTextArea textArea_items;
    private javax.swing.JTextArea textArea_question;
    // End of variables declaration//GEN-END:variables
}
