import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class SomeSettings{
    // 題目數量
    private int questionAccount;
    // 不能讓 ArrayList 每次執行就歸零
    private final ArrayList<Integer> al_questionNumber = new ArrayList<>();
    // 原始檔匯入
    ArrayList<String> al_allContens = new ArrayList<>();
//    private HashMap<String, Integer> hm_rawdata = new HashMap<>();
    // 執行時必須做的動作
    
    public SomeSettings(String url){
        // 讀取檔案
        importAllContens(url);
        // 回傳數字
        getQuestionAccount();
    }
    
    /**
     * 匯入全部的題目
     * @param url 
     */
    public void importAllContens(String url){//<editor-fold defaultstate="collapsed" desc="...">
        // url : D:\NetBeans\ForNarlabs\question_0723.txt
        questionAccount = 0;
        // 舊式寫法
//        try(BufferedReader br = new BufferedReader(new FileReader(url))){
        // 新式寫法 : 防止編碼問題
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(url), "UTF-8"))){
            while(br.ready()){
                questionAccount++;
                al_allContens.add(br.readLine());
            }           
        }catch(FileNotFoundException ex){
            System.err.println("**Error**");
            System.err.println("SomeSettings > importAllContens > FileNotFoundException : " + ex.toString());
        }catch(IOException ex){
            System.err.println("**Error**");
            System.err.println("SomeSettings > importAllContens > IOException : " + ex.toString());
        }
    }//</editor-fold>
    
    /**
     * 選擇隨機題號
     * @return 題號
     */
    public int[] randomNumber(){//<editor-fold defaultstate="collapsed" desc="...">
        int[] random = new int[questionAccount];
        for(int i = 0 ; i < questionAccount ; i++){
            random[i] = (int) Math.floor(Math.random()*questionAccount+1);
            for (int j = 0 ; j < i ; j++) {
                if(random[i] == random[j]){
                    i--;
                    break;
                }
            }
        }
        return random;
    }//</editor-fold>
    
    /**
     * 回傳題號
     * @return 題號
     */
    public int getQuestionAccount(){//<editor-fold defaultstate="collapsed" desc="...">
        return questionAccount;
    }//</editor-fold>
    
    
    /**
     * 顯示題目
     * @throws FileNotFoundException
     * @throws IOException 
     */
//    public void showQuestion() throws FileNotFoundException, IOException{
//        // 前置作業：題目數量、隨機題型
//        int questionAccount = 6;
//        int[] questionNumberList = randomNumber(questionAccount);
//        // 開始選題目
//        for(int i : questionNumberList){
//            // 按鈕1：按下題目按鈕
//            String rawdata = al_allContens.get(i-1);
//            // 顯示題目
//            String question = rawdata.split(",")[2];
//            System.out.println(i + "," + question);
//            // 考慮題型差異
//            String questionStyle = rawdata.split(",")[1];
//            if("CH".equals(questionStyle)){
//                // 如果是選擇題，則顯示選項
//                String items = rawdata.split(",")[3];
//                System.out.println("選項:" + items);
//            }else{
//                // 其餘題型不顯示內容
//            }
//            // 按鈕2：按下解答按鈕
//            String answer = rawdata.split(",")[4];
//            System.out.println(answer);
//        }
//    }
}
