package test;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


import javax.swing.ScrollPaneConstants;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import scala.collection.script.Start;

import javax.swing.ListSelectionModel;

import java.awt.Color;
import java.awt.Dimension;

public class FriendPanel extends JPanel {
	
	//public static String names[]={"duras.yhr@gmail.com","yanghrong@outlook.com","Jack","Lee","Wang"};
	public static JList list;	
	public static JScrollPane Scroller=new JScrollPane(list);
	JPanel South=new JPanel();
	public static String friendname;
	
	public FriendPanel(String names[]) {
		
		setBackground(UIManager.getColor("CheckBox.background"));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		
		list = new JList(names);
		JLabel AddFriend = new JLabel("plus");
		GridBagConstraints gbc_AddFriend = new GridBagConstraints();
		gbc_AddFriend.insets = new Insets(0, 0, 5, 0);
		gbc_AddFriend.weightx = 0.1;
		gbc_AddFriend.gridy = 0;
		gbc_AddFriend.gridx = 5;
		add(AddFriend, gbc_AddFriend);
		
		AddFriend.addMouseListener(new MouseListener(){
            public void  mouseClicked(MouseEvent e) {
            	LoginPanel.operation="add-friend?";
        		String inputValue = JOptionPane.showInputDialog("Enter the friend you want to add");
            	LoginFunction.AddAFriend(LoginPanel.operation,LoginPanel.AccessToken,inputValue,MainLayout.MainUppage);
//            	MainLayout.MainUppage.updateUI();
//            	MainLayout.MainUppage.repaint();
//            	FriendPanel FriendList = new FriendPanel();
//    			MainLayout.MainUppage.add(FriendList,"FriendList");
//            	MainLayout.MainpageCl.show(MainLayout.MainUppage, "FriendList");
             }
             public void  mouseExited(MouseEvent e) {
             }
             public void  mouseEntered(MouseEvent e) {            	
             }
             public void  mouseReleased(MouseEvent e) {            	 
             }
             public void  mousePressed(MouseEvent e) { 
             }
         });
		
		Scroller.setPreferredSize(new Dimension(600, 400));
		list.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		list.setBorder(BorderFactory.createTitledBorder("Friend Lists"));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		Scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		Scroller.setViewportView(list);
		add(Scroller);
		
		list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
            	friendname=(String) list.getSelectedValue();
            	if(friendname.equals(LoginPanel.circleAccessToken)){
            		JOptionPane.showMessageDialog(null,"you can not chat with yourself", null, JOptionPane.INFORMATION_MESSAGE);
            	}
            	else{
            	JOptionPane.showMessageDialog(null, "chat with " + friendname, null, JOptionPane.INFORMATION_MESSAGE);
            	//String UserAT = LoginPanel.circleAccessToken;
				//JOptionPane.showMessageDialog(null,LoginPanel.circleAccessToken);
//				ChattingPanel CPanel = new ChattingPanel();
//				ClientFunction.CreateClient(UserAT,CPanel,friendname);	
//				MainLayout.MainUppage.add(CPanel,"CPanel");
//				MainLayout.MainpageCl.show(MainLayout.MainUppage, "CPanel");
            	ClientFunction.CreateChatting(friendname);
            	//MainLayout.MainpageCl.show(MainLayout.MainUppage, "Chatting");
            	}
            	}
		});
		
		

//		JButton btnNewButton = new JButton("Start");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String UserAT = LoginPanel.circleAccessToken;
//				//JOptionPane.showMessageDialog(null,LoginPanel.circleAccessToken);
//				ChattingPanel CPanel = new ChattingPanel();
//				ClientFunction.CreateClient(UserAT,CPanel);	
//				MainLayout.MainUppage.add(CPanel,"CPanel");
//				
//				//CLayout.cl.show(CLayout.panelCont, "Reg");
//				
//			}
//		});
		
//		ScrollFriendList.setBounds(0, 0, 600, 400);
//		ScrollFriendList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		ScrollFriendList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//		ScrollFriendList.add(list);
//		add(ScrollFriendList);
		
		
	}
}


