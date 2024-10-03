/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pages;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Fachry Ghifary
 */
public class MatchingGame extends javax.swing.JPanel {
    static JFrame frame_mg = new JFrame();
    static JLabel[] lblAnimals = new JLabel[36];
    static ArrayList<Integer> al = new ArrayList<>();
    static HashMap<Integer, String[]> hmAnimalName = new HashMap<>();
    static int rndmidx = 1;
    static int score = 0;
    static int LANG = 0;
    static final int ENG = 0;
    static final int ID = 1;
    static {
        hmAnimalName.put(1, new String[]{"ANT", "SEMUT"});
        hmAnimalName.put(2, new String[]{"BEAR", "BERUANG"});
        hmAnimalName.put(3, new String[]{"ROOSTER", "AYAM JANTAN"});
        hmAnimalName.put(4, new String[]{"SCORPION", "KALAJENGKING"});
        hmAnimalName.put(5, new String[]{"TUNA", "TUNA"});
        hmAnimalName.put(6, new String[]{"STARFISH", "BINTANG LAUT"});
        hmAnimalName.put(7, new String[]{"TURTLE", "PENYU"});
        hmAnimalName.put(8, new String[]{"CROW", "GAGAK"});
        hmAnimalName.put(9, new String[]{"CAMEL", "UNTA"});
        hmAnimalName.put(10, new String[]{"SWAN", "ANGSA"});
        hmAnimalName.put(11, new String[]{"KILLER WHALE", "PAUS PEMBUNUH"});
        hmAnimalName.put(12, new String[]{"GECKO", "TOKEK"});
        hmAnimalName.put(13, new String[]{"ELEPHANT", "GAJAH"});
        hmAnimalName.put(14, new String[]{"SPARROW", "BURUNG PIPIT"});
        hmAnimalName.put(15, new String[]{"FISH", "IKAN"});
        hmAnimalName.put(16, new String[]{"CAT", "KUCING"});
        hmAnimalName.put(17, new String[]{"DOG", "ANJING"});
        hmAnimalName.put(18, new String[]{"PANDA", "PANDA"});
        hmAnimalName.put(19, new String[]{"PENGUIN", "PENGUIN"});
        hmAnimalName.put(20, new String[]{"PIG", "BABI"});
        hmAnimalName.put(21, new String[]{"MONKEY", "MONYET"});
        hmAnimalName.put(22, new String[]{"LION", "SINGA"});
        hmAnimalName.put(23, new String[]{"CROCODILE", "BUAYA"});
        hmAnimalName.put(24, new String[]{"GIRAFFE", "JERAPAH"});
        hmAnimalName.put(25, new String[]{"OCTOPUS", "GURITA"});
        hmAnimalName.put(26, new String[]{"SEA URCHIN", "BABI LAUT"});
        hmAnimalName.put(27, new String[]{"JELLYFISH", "UBUR UBUR"});
        hmAnimalName.put(28, new String[]{"HEN", "AYAM BETINA"});
        hmAnimalName.put(29, new String[]{"CHAMELEON", "BUNGLON"});
        hmAnimalName.put(30, new String[]{"COW", "SAPI"});
        hmAnimalName.put(31, new String[]{"RAT", "TIKUS"});
        hmAnimalName.put(32, new String[]{"SHRIMP", "UDANG"});
        hmAnimalName.put(33, new String[]{"CRAB", "KEPITING"});
        hmAnimalName.put(34, new String[]{"TIGER", "HARIMAU"});
        hmAnimalName.put(35, new String[]{"SHEEP", "DOMBA"});
        hmAnimalName.put(36, new String[]{"GOAT", "KAMBING"});
        for (int i = 0; i < 36; i++) {
            al.add(i+1);
        }
        Collections.shuffle(al);
    }
    
    public static void main(String[] args) {
        run(ENG);
//        run(ID);
    }
    
    public static void run(int LANG){
        frame_mg = new JFrame(LANG == ID ? "Mencocokkan Gambar" : "Matching Games");
        frame_mg.setIconImage(new ImageIcon(System.getProperty("user.dir")+"\\assets\\image\\logoMatchingGames2.png").getImage());
        MatchingGame mg = new MatchingGame(LANG);
        frame_mg.add(mg);
        frame_mg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame_mg.setResizable(false);
        frame_mg.pack();
        frame_mg.setLocationRelativeTo(null);
        frame_mg.setVisible(true);
    }
    /**
     * Creates new form Matching
     * @param LANG
     */
    public MatchingGame(int LANG) {
        initComponents();
        MatchingGame.LANG = LANG;
        defaultLanguageSet();
        shuffleAnimal();
        pnlAnimalList.repaint();
    }
    
    private void defaultLanguageSet(){
        btnBack.setText(LANG == ID ? "Kembali" : "Back");
        btnLangSwitch.setText(LANG == ID ? "Id" : "Eng");
        lblTitle.setText(LANG == ID ? "Cocokkan Hewan yang Tepat!!" : "Match the Same Animal!!");
        lblRound.setText(LANG == ID ? "Ronde : 1" : "Round : 1");
        lblCorrect.setText(LANG == ID ? "Benar : 0" : "Correct : 0");
        lblWrong.setText(LANG == ID ? "Salah : 0" : "Wrong : 0");
    }
    
    private void shuffleAnimal(){
        pnlAnimalList.removeAll();
        Collections.shuffle(al);
        rndmidx = (int)(Math.random()*36+1);
        lblChosenAnimal.setIcon(new ImageIcon(System.getProperty("user.dir")+String.format("\\assets\\image\\%d.png", rndmidx)));
        lblChosenAnimalName.setText(MatchingGame.LANG == ID ? hmAnimalName.get(rndmidx)[ID] : hmAnimalName.get(rndmidx)[ENG]);
        for (int i = 0; i < lblAnimals.length; i++) {
            lblAnimals[i] = new JLabel(new ImageIcon(System.getProperty("user.dir")+String.format("\\assets\\image\\%d.png", al.get(i))));
            JLabel lblDummy  = new JLabel(new ImageIcon(System.getProperty("user.dir")+String.format("\\assets\\image\\%d.png", al.get(i))));
            lblAnimals[i].addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    lblAnimalListMouseClicked(evt, lblDummy.getIcon());
                }
            });
            pnlAnimalList.add(lblAnimals[i]);
//            System.out.println(lblAnimals[i].getIcon().toString());
        }
    }
    
    private void lblAnimalListMouseClicked(java.awt.event.MouseEvent evt, Icon icon) {                                     
        // TODO add your handling code here:
        if (lblChosenAnimal.getIcon().toString().equals(icon.toString())){
            score++;
            System.out.println("benar, score = " + score);
        } else {
            System.out.println("salah, score = " + score);
        }
        setRoundCorrectWrong();
        System.out.println(lblChosenAnimal.getIcon().toString());
        System.out.println(icon.toString());
        shuffleAnimal();
        this.repaint();
    }  
    
    private int[] checkRound(int round, int correct, int wrong){
        if (round == 11){
            String text = String.format(
                    LANG == ID
                    ? "<html>Ronde berakhir!<br>Benar : %d<br> Salah : %d<br>Ronde akan mengulang.<html>"
                    : "<html>Round over!<br>Correct : %d<br> Wrong : %d<br>Round will reset.<html>"
                    , correct, wrong
            );
            JOptionPane.showMessageDialog(null, text, LANG == ID ? "Ronde berakhir!" : "Round over!", JOptionPane.INFORMATION_MESSAGE);
            round = 1;
            correct = 0;
            wrong = 0;
        }
        return new int[]{round, correct, wrong};
    }
    
    private void setRoundCorrectWrong(){
        String[] roundstr = lblRound.getText().split(" : ");
        int round = Integer.parseInt(roundstr[1])+1;
        
        String[] correctstr = lblCorrect.getText().split(" : ");
        int correct = score;
        
        String[] wrongstr = lblWrong.getText().split(" : ");
        int wrong = round-correct-1;
        
        int[] info = checkRound(round, correct, wrong);
        lblRound.setText(roundstr[0]+" : "+info[0]);
        lblCorrect.setText(correctstr[0]+" : "+info[1]);
        lblWrong.setText(wrongstr[0]+" : "+info[2]);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblChosenAnimal = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblChosenAnimalName = new javax.swing.JLabel();
        pnlAnimalList = new javax.swing.JPanel();
        lblRound = new javax.swing.JLabel();
        lblCorrect = new javax.swing.JLabel();
        lblWrong = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnLangSwitch = new javax.swing.JButton();

        setBackground(new java.awt.Color(171, 205, 239));

        lblChosenAnimal.setIcon(new javax.swing.ImageIcon("D:\\NETBEANS\\PemVis\\Project\\MatchingGames\\assets\\image\\1.png")); // NOI18N

        lblTitle.setBackground(new java.awt.Color(18, 52, 86));
        lblTitle.setFont(new java.awt.Font("Comic Sans MS", 3, 32)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(18, 52, 86));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Match the Same Animal!!");
        lblTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblChosenAnimalName.setBackground(new java.awt.Color(18, 52, 86));
        lblChosenAnimalName.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        lblChosenAnimalName.setForeground(new java.awt.Color(18, 52, 86));
        lblChosenAnimalName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChosenAnimalName.setText("ANT");
        lblChosenAnimalName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        pnlAnimalList.setBackground(new java.awt.Color(171, 205, 239));
        pnlAnimalList.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(18, 52, 86), 3, true));
        pnlAnimalList.setLayout(new java.awt.GridLayout(6, 6));

        lblRound.setBackground(new java.awt.Color(18, 52, 86));
        lblRound.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        lblRound.setForeground(new java.awt.Color(18, 52, 86));
        lblRound.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRound.setText("Round : 10");
        lblRound.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblCorrect.setBackground(new java.awt.Color(18, 52, 86));
        lblCorrect.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        lblCorrect.setForeground(new java.awt.Color(18, 52, 86));
        lblCorrect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrect.setText("Correct : 10");
        lblCorrect.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblWrong.setBackground(new java.awt.Color(18, 52, 86));
        lblWrong.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        lblWrong.setForeground(new java.awt.Color(18, 52, 86));
        lblWrong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWrong.setText("Wrong : 10");
        lblWrong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnBack.setBackground(new java.awt.Color(18, 52, 86));
        btnBack.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(171, 205, 239));
        btnBack.setText("Back");
        btnBack.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 204), 1, true));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnLangSwitch.setBackground(new java.awt.Color(18, 52, 86));
        btnLangSwitch.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnLangSwitch.setForeground(new java.awt.Color(171, 205, 239));
        btnLangSwitch.setText("Eng");
        btnLangSwitch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 204), 1, true));
        btnLangSwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLangSwitchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pnlAnimalList, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblRound, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36)
                                    .addComponent(lblCorrect, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(38, 38, 38)
                                    .addComponent(lblWrong, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblChosenAnimalName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLangSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblChosenAnimal)
                .addGap(227, 227, 227))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLangSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle)
                .addGap(24, 24, 24)
                .addComponent(lblChosenAnimal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblChosenAnimalName)
                .addGap(18, 18, 18)
                .addComponent(pnlAnimalList, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorrect)
                    .addComponent(lblWrong)
                    .addComponent(lblRound))
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Lobby.main(new String[]{});
        frame_mg.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnLangSwitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLangSwitchActionPerformed
        MatchingGame.LANG = MatchingGame.LANG == ENG ? ID : ENG;
        btnBack.setText(LANG == ID ? "Kembali" : "Back");
        btnLangSwitch.setText(LANG == ID ? "Id" : "Eng");
        lblTitle.setText(LANG == ID ? "Cocokkan Hewan yang Tepat!!" : "Match the Same Animal!!");
        lblChosenAnimalName.setText(LANG == ID ? hmAnimalName.get(rndmidx)[ID] : hmAnimalName.get(rndmidx)[ENG]);
        lblRound.setText(LANG == ID ? "Ronde : 1" : "Round : 1");
        lblCorrect.setText(LANG == ID ? "Benar : 0" : "Correct : 0");
        lblWrong.setText(LANG == ID ? "Salah : 0" : "Wrong : 0");
    }//GEN-LAST:event_btnLangSwitchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLangSwitch;
    private javax.swing.JLabel lblChosenAnimal;
    private javax.swing.JLabel lblChosenAnimalName;
    private javax.swing.JLabel lblCorrect;
    private javax.swing.JLabel lblRound;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblWrong;
    private javax.swing.JPanel pnlAnimalList;
    // End of variables declaration//GEN-END:variables
}
