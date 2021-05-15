/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.phonebook;

/**
 *
 * @author dharm
 */

import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
public class PhoneBook implements ActionListener{
    JFrame jf;
    JMenuBar jmb;
    JMenu File,Edit,Help;
    JMenuItem Exit,Clear,Search,Add,Remove,About;
    JLabel jl1,jl2,jl3;
    JPanel jpl,jpr,jprt,jprm,jprb,jl,jr;
    JTable jt;
    JScrollPane scrl;
    JCheckBox jcb;
    JTextField jtf1,jtf2,jtf3;
    JRadioButton rb1,rb2;
    ButtonGroup bg;
    JButton jb1,jb2,jb3,jb4;
    DefaultTableModel dftm;
     public PhoneBook(){
      //main frame
      jf=new JFrame("PhoneBook");
      jf.setSize(600,500);
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jf.setLayout(new GridLayout(1,2));
    
      //Menuitems
      Exit=new JMenuItem("Exit");
      Exit.setToolTipText("Exit");
      Exit.setMnemonic(KeyEvent.VK_E);
      Exit.addActionListener(this);
    
      Clear=new JMenuItem("Clear");
      Clear.setToolTipText("Clear");
      Clear.setMnemonic(KeyEvent.VK_C);
      Clear.addActionListener(this);
    
      Search=new JMenuItem("Search");
      Search.setToolTipText("Search");
      Search.setMnemonic(KeyEvent.VK_S);
      Search.addActionListener(this);
    
      Add=new JMenuItem("Add");
      Add.setToolTipText("Add column");
      Add.setMnemonic(KeyEvent.VK_A);
      Add.addActionListener(this);
    
      Remove=new JMenuItem("Remove");
      Remove.setToolTipText("Remove Column");
      Remove.setMnemonic(KeyEvent.VK_R);
      Remove.addActionListener(this);
    
      About=new JMenuItem("About");
      About.setToolTipText("About");
      About.setMnemonic(KeyEvent.VK_A);
      About.addActionListener(this);
      //Menu
      File=new JMenu("File");
      File.setMnemonic(KeyEvent.VK_F);
      //adding menuitem in menu
      File.add(Exit);
      //Menu
      Edit=new JMenu("Edit");
      Edit.setMnemonic(KeyEvent.VK_E);
      //adding menuitem in menu
      Edit.add(Clear);
      Edit.add(Search);
      Edit.add(Add);
      Edit.add(Remove);
    
      //menu
      Help=new JMenu("Help");
      Help.setMnemonic(KeyEvent.VK_H);
      Help.add(About);
    
      //menubar
      jmb=new JMenuBar();
      //adding menu in menubar
      jmb.add(File);
      jmb.add(Edit);
      jmb.add(Help);
      //adding menubar in main frame
      jf.setJMenuBar(jmb);
    
       //main panel for left side
       jpl=new JPanel(new GridLayout(1,1));
       jpl.setBorder(new TitledBorder("Name:"));
       jf.add(jpl);
       
    
       //main panel for right side 
       jpr=new JPanel(new GridLayout(3,1));
       jf.add(jpr);
    
       //top pannel inside right main panel
       jprt=new JPanel(new GridLayout(1,2));
       jprt.setBorder(new TitledBorder("Info:"));
       jpr.add(jprt);
    
       //left panel inside top pannel
       jl=new JPanel(new GridLayout(4,1));
       jprt.add(jl);
    
       //right panel inside top pannel
       jr=new JPanel(new GridLayout(4,1));
       jprt.add(jr);
    
       //mid panel inside right main panel
       jprm=new JPanel(new GridLayout(2,1));
       jprm.setBorder(new TitledBorder("File as:"));
       jpr.add(jprm);
    
       //bottom panel inside right main panel
       jprb=new JPanel(new GridLayout(2,2));
       jpr.add(jprb);
    
    
    
    
       //creation of table
       jt=new JTable();
       Object[] columns={"Forename","Surname","Phone","Status"};
       dftm=new DefaultTableModel();
       dftm.setColumnIdentifiers(columns);
       jt.setModel(dftm);
    
       //jt.setTableHeader(null);
       scrl=new JScrollPane(jt);
       jpl.add(scrl);
    
    
    
       //creation of label
       jl1=new JLabel("First Name");
       jl2=new JLabel("Second Name");
       jl3=new JLabel("Phone");
       //adding label inside jl panel
       jl.add(jl1);
       jl.add(jl2);
       jl.add(jl3);
       //creation of checkbox
       jcb=new JCheckBox("Private");
       jcb.addActionListener(this);
        //adding checkbox inside jl panel
        jl.add(jcb);
    
        //creation of textfield
        jtf1=new JTextField(20);
        //validation of text field
        jtf1.addKeyListener(new KeyAdapter() {
                        @Override
            public void keyPressed(KeyEvent EVT){
                    if (EVT.getKeyChar() >= '0' && EVT.getKeyChar() <= '9') {
                    jtf1.setEditable(false);
                                        JOptionPane.showMessageDialog(jf,"Enter only Alphabet");
                                        jtf1.setEditable(true);
                } else {
                    jtf1.setEditable(true);
                                    
                                }
            }
        });
        jtf2=new JTextField(20);
        //validation of text field
        jtf2.addKeyListener(new KeyAdapter() {
                        @Override
            public void keyPressed(KeyEvent EVT){
                if (EVT.getKeyChar() >= '0' && EVT.getKeyChar() <= '9') {
                    jtf2.setEditable(false);
                                        JOptionPane.showMessageDialog(jf,"Enter only Alphabet");
                                        jtf2.setEditable(true);
                } else {
                    jtf2.setEditable(true);
                                    
                                }
            }
        });
        jtf3=new JTextField(20);
        //validation of text field
        jtf3.addKeyListener(new KeyAdapter() {
                        @Override
            public void keyPressed(KeyEvent EVT){
                if (EVT.getKeyChar() >= 'a'&& EVT.getKeyChar() <= 'z'|| EVT.getKeyChar() >= 'A'&& EVT.getKeyChar() <= 'Z') {
                    jtf3.setEditable(false);
                                        JOptionPane.showMessageDialog(jf,"Enter only Numeric Value");
                                        jtf3.setEditable(true);
                } else {
                    jtf3.setEditable(true);
                                    
                                }
            }
        });
        //adding textfield inside jr panel
        jr.add(jtf1);
        jr.add(jtf2);
        jr.add(jtf3);
    
        //creation of radiobutton
        rb1=new JRadioButton("Forename,Surname");
        rb1.addActionListener(this);
        rb2=new JRadioButton("Surname,Forename");
        rb2.addActionListener(this);
        rb1.setSelected(true);
        rb1.setEnabled(false);
        //adding radiobutton inside jprm panel
        jprm.add(rb1);
        jprm.add(rb2);
        //grouping of button for select only one button
        bg=new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
    
        //creation of button
        jb1=new JButton("Clear");
        jb1.addActionListener(this);
        jb2=new JButton("Search");
        jb2.addActionListener(this);
        jb3=new JButton("Add");
        jb3.addActionListener(this);
        jb4=new JButton("Remove");
        jb4.addActionListener(this);
        //adding button inside jprb panel
        jprb.add(jb1);
        jprb.add(jb2);
        jprb.add(jb3);
        jprb.add(jb4);
    
        jf.setVisible(true);
    }
    @Override
    public void  actionPerformed(ActionEvent a){
      try{
      //adding into table  or for add button
      if(a.getSource()==jb3 || a.getSource()==Add) {   
     
       if(jtf1.getText().isEmpty()){
         JOptionPane.showMessageDialog(jf,"Please enter the full data.");
      }
      else if( jtf2.getText().isEmpty()){
         JOptionPane.showMessageDialog(jf,"Please enter the full data.");
      }
      else if(jtf3.getText().length()!=10){
         JOptionPane.showMessageDialog(jf,"Enter 10 digit phone Number.");
      }
      
      else if(jcb.isSelected()&&jtf3.getText().length()==10){
         dftm.addRow(new Object[]{jtf1.getText(),jtf2.getText(),jtf3.getText(),jcb.getText()});
         JOptionPane.showMessageDialog(jf,"Given data are added into table.");
      }
      
      else if(jcb.isSelected()==false&&jtf3.getText().length()==10){
         dftm.addRow(new Object[]{jtf1.getText(),jtf2.getText(),jtf3.getText(),""});
         JOptionPane.showMessageDialog(jf,"Given data are added into table.");
      }
      
     
      } 
      if(a.getSource()==rb1){
          rb1.setEnabled(false);
          rb2.setEnabled(true);
          jt.moveColumn(0,1);
      }
      if(a.getSource()==rb2){
          rb2.setEnabled(false);
          rb1.setEnabled(true);
          jt.moveColumn(1,0);
      }
      
      //for search button
      if(a.getSource()==jb2||a.getSource()==Search){
          JOptionPane.showMessageDialog(jf,"Search functionality will be supported in the professional version");
      }
      //for clear button
      if(a.getSource()==jb1||a.getSource()==Clear){
          jtf1.setText(null);
          jtf2.setText(null);
          jtf3.setText(null);
          jcb.setSelected(false);
          JOptionPane.showMessageDialog(jf,"Contents are Cleared.");
      }
      
      //for Remove Button
      if(a.getSource()==jb4||a.getSource()==Remove){
          int i=jt.getSelectedRow();
          if(i>=0){
          dftm.removeRow(i);
          JOptionPane.showMessageDialog(jf,"The selected row is removed.");
        }
        else{
            JOptionPane.showMessageDialog(jf,"There is not any selected row to remove.");
        }
      }
      
      if(a.getSource()==About){
          JOptionPane.showMessageDialog(jf,"It is still in trial version!!");
      }
      
      if(a.getSource()==Exit){
          jf.dispose();
      }
      
     }catch(Exception e){
        
       System.out.println(e);
     }
     }
    public static void main(String[]args){
        PhoneBook obj;
        obj = new PhoneBook();
    
    
    
    }
    
}
