package sca.net.gui;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import sca.net.dao.ChatClientDao;
import sca.net.dao.ChatLogDao;
import sca.net.pojo.ChatClient;
import sca.net.pojo.ChatLog;
//import twowaychat.ServerChat;

/**
 *
 * @author sneha
 */
public class MyMultiWayChatServer extends javax.swing.JFrame {

    /**
     * Creates new form ServerFrame
     */
    Socket sock;
    ServerSocket svc;
    Random rand;
    FileWriter fw;
    PrintWriter fpw;
    SimpleDateFormat sdf;
    String name;
    ArrayList<PrintWriter> printWriters=new ArrayList<>();
    ArrayList<String> userNames=new ArrayList<>();
    String str;
    public MyMultiWayChatServer() {
        initComponents();
        rand=new Random();
        try
        {
            fw=new FileWriter("d:\\chatlogs.txt",true);
            fpw=new PrintWriter(fw,true);
            sdf=new SimpleDateFormat("HH:mm:ss,dd-MMM-yyy");
        }
        catch(Exception e)
        {
            
        }
    }

    /**
    
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtChat = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txtChat.setColumns(20);
        txtChat.setRows(5);
        jScrollPane1.setViewportView(txtChat);

        jLabel1.setText("Type your Message");

        btnStart.setText("Start Server");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnStop.setText("Stop Server");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        btnSend.setText("Send");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btnStart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                        .addComponent(btnStop))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSend)))
                .addGap(94, 94, 94))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStart)
                    .addComponent(btnStop))
                .addGap(82, 82, 82))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        
        
        
        WaitForConnectionThread my=new WaitForConnectionThread();
        txtChat.setText("Server waiting at port no 4567");
        my.start();
        btnStart.setEnabled(false);
        btnStop.setEnabled(true);
        btnSend.setEnabled(true);

        
    }                                        

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        
        
        
          try
        {
            if(sock==null)
            {
                sock=null;
            }
            else
            svc.close();
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null,"Exception in stopping server"+ex);
            ex.printStackTrace();
        }
    }                                       

    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        // TODO add your handling code here:
        try
        {
         fw.close();
            
        }
       catch(Exception e)
       {
           
       }
      
        
        
   JOptionPane.showMessageDialog(null,"chats log successfully");     
        
        
        
        
    }                                  

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyMultiWayChatServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyMultiWayChatServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyMultiWayChatServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyMultiWayChatServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyMultiWayChatServer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea txtChat;
    // End of variables declaration                   

    class WaitForConnectionThread extends Thread
    {
        Socket sock;
        public void run()
        {
            try
            {
                svc=new ServerSocket(4567);
                while(true)
                {
                    sock=svc.accept();
                    ChatHandlerThread chatHandler=new ChatHandlerThread(sock);
                    chatHandler.start();
                }
                       
                
            }
            catch(Exception ex)
            {
                
            }
        }
        
    }
    class ChatHandlerThread extends Thread
    {  Scanner cl;
    PrintWriter pw;
    Socket sock;
    
    
    public ChatHandlerThread(Socket sock)
    {
        this.sock=sock;
    }
        
        public void run()
    {
     try
     {
         pw=new PrintWriter(sock.getOutputStream(),true);
         cl=new Scanner(sock.getInputStream());
         int count=0;
         while(true)
         {
             if(count>0)
             {
                 pw.println("NAMEALREADYEXISTS");
                 pw.flush();
             }
             else
             {
                 pw.println("NAMEREQUIRED");
                 pw.flush();
             }
             name=cl.nextLine();
            if(!userNames.contains(name))//user
             {
                 userNames.add(name);
                 break;
             }
             count++;                   //user
            /*  if(!ChatClientDao.findClient(name))
             {
             userNames.add(name);
             saveClientDetailsToDB();
             break;
              }*/ 
         } 
            
       
         pw.println("NAMEACCEPTED"+name);
         pw.flush();
         if(userNames.size()==1)
             txtChat.append("Connected clients:....\n");
         txtChat.append(name+"from"+sock.getInetAddress()+"\n");
         printWriters.add(pw);
         
         while(true)
         {
            String message=cl.nextLine();
             System.out.println("Got the message from "+name+":"+message);
             if(message.equalsIgnoreCase("quit"))
             {
                 for(PrintWriter p:printWriters)
            {
               if(p.equals(pw)==false)
               {
                   p.println(name+":"+message);
                   p.flush();
               }      
            }
                 pw.close();
                 sock.close();
                 return;
             }
             synchronized(fpw)
         {
             String timeStamp=sdf.format(new java.util.Date());
             fpw.println(name+":"+message+"("+timeStamp+")");
             for(PrintWriter writer:printWriters)           //user
             {
                 if(writer.equals(pw)==false)
                 {
                     writer.println(name+":"+message);
                     writer.flush();
                 }
             }                                             //user
            /*try
             {
                 ChatLog chat=new ChatLog();
                 chat.setMessage(message);
                 chat.setMsgTime(timeStamp);
                 chat.setUsername(name);
                 boolean result=ChatLogDao.addChatLog(chat);
                 System.out.println("Result"+result);
                 if(result)
                     System.out.println("Saved to Db"+chat);
                     
             }
             catch(SQLException ex)
             {
                 ex.printStackTrace();
                 JOptionPane.showMessageDialog(null,"Exception occures in chatlogdao");
             }
              */       
         }
           
            
         }
     }
     catch(Exception ex)
     {
     ex.printStackTrace();
     
         
     }
   
    }
    
    
    
    
    }

/*private void saveClientDetailsToDB()
{
    try
    {
        ChatClient chatClient=new ChatClient();
        chatClient.setUserName(name);
        chatClient.setPassword(sock.getInetAddress().toString());
        boolean result=ChatClientDao.addClient(chatClient);
        if(result)
        JOptionPane.showMessageDialog(null, "Client details saved in Db","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
        else
        JOptionPane.showMessageDialog(null, "Client details not inserted in Db","SUCCESS",JOptionPane.INFORMATION_MESSAGE);    
                
        
        
    }
    catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null,"Exception occured in ChatClientDao ","Failure",JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
        
    }
}*/
}