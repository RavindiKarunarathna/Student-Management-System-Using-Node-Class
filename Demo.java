import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

class Node{
	private Student first;
	
	public int size(){
		Student temp=first;
		int count=0;
		while(temp!=null){
			temp=temp.next;
			count++;
		}
		return count;
	}
	
	public void addLast(Student student){
		Student temp=first;
		if(first==null){
			first=student;
		}else{
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next=student;
		}
	}
	
	public void addFirst(Student student){
		if(first==null){
			first=student;
		}else{
			student.next=first;
			first=student;
		}
	}
	
	public void add(Student student){
		addFirst(student);
	}
	
	public boolean add(int index,Student student){
		Student temp=first;
		if(index>=0 && index<=size()){
			if(index==0){
				addFirst(student);
				return true;
			}
			if(index==size()){
				addLast(student);
				return true;
			}
			int count=0;
			while(count<index-1){
				temp=temp.next;
				count++;
			}
			student.next=temp.next;
			temp.next=student;
			return true;
		}
		return false;
	}
	
	public String printList(){
		if(first==null){
			return "Empty";
		}
		Student temp=first;
		String ar="";
		while(temp!=null){
			ar+=temp.id+""+temp.name+""+temp.nic+""+temp.prfMark+""+temp.dbmsMark+"\n";
			temp=temp.next;
		}
		return ar;
	}
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public void removeFirst(){
		if(!isEmpty()){
			first=first.next;
		}
	}
	
	public void removeLast(){
		if(!isEmpty()){
			if(first.next==null){
				removeFirst();
			}else{
				Student temp=first;
				while(temp.next.next!=null){
					temp=temp.next;
				}
				temp.next=null;
			}
		}
	}
	
	public boolean remove(int index){
		if(index>=0 && index<size()){
			if(index==0){
				removeFirst();
				return true;
			}
			if(index==size()){
				removeLast();
				return true;
			}
			Student temp=first;
			int count=0;
			while(count<index-1){
				temp=temp.next;
				count++;
			}
			temp.next=temp.next.next;
			return true;
		}
		return false;
	}
	
	public int indexOf(String id){
		Student temp=first;
		int count=0;
		while(temp!=null){
			if((temp.id).equals(id)){
				return count;
			}
			temp=temp.next;
			return count++;
		}
		return -1;
	}
	
	public boolean search(String id){
		return indexOf(id)!=-1;
	}
	
	public Student get(String id){
		Student temp=first;
		int count=0;
		while(count<indexOf(id)){
			temp=temp.next;
			count++;
		}
		return temp;
	}
	
	public Student getIndex(int index){
		Student temp=first;
		int count=0;
		while(count<index){
			temp=temp.next;
			count++;
		}
		return temp;
	}
	
	public boolean checkNIC(String nic){
		Student temp=first;
		while(temp!=null){
			int lastNo=Integer.parseInt(temp.id.substring(7));
			if(temp.nic.equals(nic)){
				return true;
			}
			temp=temp.next;
		}
		return false;
	}
	
	public String generateId(){
		Student temp=first;
		int max=0;
		if(first==null){
			return "24110001";
		}
		while(temp!=null){
			int lastNo=Integer.parseInt(temp.id.substring(7));
			if(lastNo>max){
				max=lastNo;
			}
			temp=temp.next;
		}
		max+=1;
		String lastNoString="24110";
		if(max<10){
			lastNoString=lastNoString+"00"+max;
		}else if(max<100){
			lastNoString=lastNoString+"0"+max;
		}else{
			lastNoString=lastNoString+""+max;
		}
		return lastNoString;
	}
	
	class Student{
		private String id;
		private String name;
		private String nic;
		private int prfMark;
		private int dbmsMark;
		private Student next;
		
		Student(String id, String name,String nic, int prfMark,int dbmsMark){
			this.id=id;
			this.name=name;
			this.nic=nic;
			this.prfMark=prfMark;
			this.dbmsMark=dbmsMark;
		}
		
		public void setID(String id){
			this.id=id;
		}
		
		public void setName(String name){
			this.name=name;
		}
		
		public void setNIC(String nic){
			this.nic=nic;
		}
		
		public void setPRFMark(int prfMark){
			this.prfMark=prfMark;
		}
		
		public void setDBMSMark(int dbmsMark){
			this.dbmsMark=dbmsMark;
		}
		
		public String getID(){
			return id;
		}
		
		public String getName(){
			return name;
		}
		
		public String getNIC(){
			return nic;
		}
		
		public int getPRFMark(){
			return prfMark;
		}
		
		public int getDBMSMark(){
			return dbmsMark;
		}
	}
	
	public double searchGPA(double x){
		double num=0;
		if(x>=90 && x<=100){
			num=4.25;
		}else if(x>=80 && x<90){
			num=4.00;
		}else if(x>=75 && x<80){
			num=3.70;
		}else if(x>=70 && x<75){
			num=3.30;
		}else if(x>=65 && x<70){
			num=3.00;
		}else if(x>=60 && x<65){
			num=2.70;
		}else if(x>=55 && x<60){
			num=2.30;
		}else if(x>=50 && x<55){
			num=2.00;
		}else if(x>=45 && x<50){
			num=1.70;
		}else if(x>=40 && x<45){
			num=1.30;
		}else if(x>=30 && x<40){
			num=1.00;
		}else if(x>=20 && x<30){
			num=0.70;
		}
		return num;
	}
}

class AddStudent extends JFrame{
	private JLabel mainTitleLbl, nicLbl, nameLbl, lecModeLbl, prfMarkLbl, dbmsMarkLbl;
	private JTextField nicTxt, nameTxt, lecModeTxt, prfMarkTxt, dbmsMarkTxt;
	private JButton addStudentBtn, cancelBtn;
	private JPanel txtNamePanel, northColorPanel, btnPanel;
	private Node list;
	
	AddStudent(Node listLocal){
		this.list=listLocal;
		setSize(900,600);
		setTitle("Add Student");
		setLocationRelativeTo(null);
		
		northColorPanel=new JPanel(new BorderLayout());
		northColorPanel.setBackground(new Color(51, 153, 255));
		
		mainTitleLbl=new JLabel("Add Student");
		mainTitleLbl.setHorizontalAlignment(JLabel.CENTER);
		mainTitleLbl.setFont(new Font("", Font.BOLD, 50));
		northColorPanel.add(mainTitleLbl,BorderLayout.CENTER);
		add("North", northColorPanel);
		
		txtNamePanel=new JPanel(new GridLayout(5,2));
		
		nicLbl=new JLabel("NIC : ");
		nameLbl=new JLabel("Name : ");
		lecModeLbl=new JLabel("Lec Mode(online-0 physical-1) : ");
		prfMarkLbl=new JLabel("PRF Mark : ");
		dbmsMarkLbl=new JLabel("DBMS Mark : ");
		
		nicTxt=new JTextField();
		nameTxt=new JTextField();
		lecModeTxt=new JTextField();
		prfMarkTxt=new JTextField();
		dbmsMarkTxt=new JTextField();
		
		nicTxt.setFont(new Font("",1,20));
		nameTxt.setFont(new Font("",1,20));
		lecModeTxt.setFont(new Font("",1,20));
		prfMarkTxt.setFont(new Font("",1,20));
		dbmsMarkTxt.setFont(new Font("",1,20));
		
		nicLbl.setFont(new Font("",1,20));
		nameLbl.setFont(new Font("",1,20));
		lecModeLbl.setFont(new Font("",1,20));
		prfMarkLbl.setFont(new Font("",1,20));
		dbmsMarkLbl.setFont(new Font("",1,20));
		
		txtNamePanel.add(nicLbl);
		txtNamePanel.add(nicTxt);
		txtNamePanel.add(nameLbl);
		txtNamePanel.add(nameTxt);
		txtNamePanel.add(lecModeLbl);
		txtNamePanel.add(lecModeTxt);
		txtNamePanel.add(prfMarkLbl);
		txtNamePanel.add(prfMarkTxt);
		txtNamePanel.add(dbmsMarkLbl);
		txtNamePanel.add(dbmsMarkTxt);
		
		addStudentBtn=new JButton("Add Student");
		cancelBtn=new JButton("Cancel");
		btnPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnPanel.add(cancelBtn);
		btnPanel.add(addStudentBtn);
		add("South",btnPanel);
		
		addStudentBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String nic=nicTxt.getText();
				String name=nameTxt.getText();
				int lecMode=Integer.parseInt(lecModeTxt.getText());
				int prfMark=Integer.parseInt(prfMarkTxt.getText());
				int dbmsMark=Integer.parseInt(dbmsMarkTxt.getText());
				
				if(list.checkNIC(nic)){
					JOptionPane.showMessageDialog(null,"NIC All Ready Exsits...");
					return;
				}
				if(nic.length()!=12){
					JOptionPane.showMessageDialog(null,"NIC Not Valid...");
					return;
				}
				if(prfMark<0 || prfMark>100){
					JOptionPane.showMessageDialog(null,"PRF Mark Not Valid...");
					return;
				}
				if(dbmsMark<0 || dbmsMark>100){
					JOptionPane.showMessageDialog(null,"DBMS Mark Not Valid");
					return;
				}
				if(lecMode<0 || lecMode>1){
					JOptionPane.showMessageDialog(null,"Lecture Mode Not Valid");
					return;
				}
				String id="";
				if(lecMode==1){
					id=id+"PR"+list.generateId();
				}else if(lecMode==0){
					id=id+"OR"+list.generateId();
				}
				list.add(list.new Student(id,name,nic,prfMark,dbmsMark));
				
				try{
					FileWriter fw=new FileWriter("Student.txt",true);
					fw.write(id+", "+name+", "+nic+", "+prfMark+", "+dbmsMark+"\n");
					fw.close();
				}catch(IOException ex){
					
				}
				JOptionPane.showMessageDialog(null,"Successfully ID is "+id);
				nicTxt.setText("");
				nameTxt.setText("");
				lecModeTxt.setText("");
				prfMarkTxt.setText("");
				dbmsMarkTxt.setText("");
			}
		});
		
		cancelBtn.addActionListener(new ActionListener(){
			public void  actionPerformed(ActionEvent e){
				dispose();
				StudentManagement s1=new StudentManagement(list);
				s1.setVisible(true);
			}
		});
	}
}

class StudentManagementFirstPage extends JFrame{
	private JLabel mainTitleLbl;
	private JLabel westLbl;
	private JButton studentMngBtn;
	private JButton batchMngBtn;
	private JButton gradeMngBtn;
	private JButton reportMngBtn;
	private JPanel listFirstPage;
	private JButton[] jBtnArray;
	private Node list;
	
	StudentManagementFirstPage(Node listLocal){
		this.list=listLocal;
		setSize(900,600);
		setTitle("Student Management System");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		mainTitleLbl=new JLabel("iCET Student Management System");
		mainTitleLbl.setFont(new Font("",1,30));
		mainTitleLbl.setHorizontalAlignment(JLabel.CENTER);
		add("North", mainTitleLbl);
		
		jBtnArray=new JButton[3];
		String[] ar={"Student Management", "Student Report", "Exit"};
		listFirstPage=new JPanel(new GridLayout(3,1,4,4));
		for(int i=0;i<3;i++){
			jBtnArray[i]=new JButton(ar[i]);
			jBtnArray[i].setFont(new Font("",1,30));
			jBtnArray[i].setForeground(Color.BLACK);
			listFirstPage.add(jBtnArray[i]);
		}
		
		jBtnArray[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				StudentManagement s1=new StudentManagement(list);
				s1.setVisible(true);
			}
		});
		
		jBtnArray[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				StudentReport b1=new StudentReport(list);
				b1.setVisible(true);
			}
		});
		
		jBtnArray[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		
		add("Center", listFirstPage);
	}	
}



class Demo{
	public static void main(String[] args){
		
	}
}
