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
		mainTitleLbl.setOpaque(true); 
		mainTitleLbl.setBackground(Color.GREEN);
		mainTitleLbl.setHorizontalAlignment(JLabel.CENTER);
		add("North", mainTitleLbl);
		
		jBtnArray=new JButton[3];
		String[] ar={"Student Management", "Student Report", "Exit"};
		listFirstPage=new JPanel(new GridLayout(3,1,4,4));
		Color darkBlue = new Color(0, 0, 139);
		for(int i=0;i<3;i++){
			jBtnArray[i]=new JButton(ar[i]);
			jBtnArray[i].setFont(new Font("",1,30));
			jBtnArray[i].setForeground(Color.WHITE);
			jBtnArray[i].setBackground(darkBlue); 
			jBtnArray[i].setOpaque(true); 
			jBtnArray[i].setBorderPainted(false); 
			jBtnArray[i].setPreferredSize(new Dimension(150, 40)); 
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
		
		jBtnArray[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		
		add("Center", listFirstPage);
	}	
}

class StudentManagement extends JFrame{
	private JLabel mainTitleLbl;
	private JButton addStudentBtn;
	private JButton updateStudentBtn;
	private JButton viewStudentBtn;
	private JButton deleteStudentBtn;
	private JButton backBtn;
	private JPanel mainBtnPanel;
	private JButton[] jBtnArray;
	private Node list;
	
	StudentManagement(Node listLocal){
		this.list=listLocal;
		setSize(900,600);
		setTitle("Student Management");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainTitleLbl=new JLabel("Student Management");
		mainTitleLbl.setHorizontalAlignment(JLabel.CENTER);
		mainTitleLbl.setFont(new Font("",1,25));
		mainTitleLbl.setOpaque(true); 
		mainTitleLbl.setBackground(Color.GREEN);
		add("North",mainTitleLbl);
		
		jBtnArray=new JButton[5];
		String ar[]={"Add Student","Update Student","View Student","Delete Student","Back"};
		mainBtnPanel=new JPanel(new GridLayout(5,1,4,4));
		Color darkBlue = new Color(0, 0, 139);
		
		for(int i=0;i<ar.length;i++){
			jBtnArray[i]=new JButton();
			jBtnArray[i].setText(ar[i]);
			jBtnArray[i].setFont(new Font("",1,20));
			jBtnArray[i].setForeground(Color.WHITE);
			jBtnArray[i].setBackground(darkBlue); 
			jBtnArray[i].setOpaque(true); 
			jBtnArray[i].setBorderPainted(false); 
			jBtnArray[i].setPreferredSize(new Dimension(150, 40)); 
			mainBtnPanel.add(jBtnArray[i]);
			add("Center",mainBtnPanel);
		}
		
		jBtnArray[4].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
				StudentManagementFirstPage s1=new StudentManagementFirstPage(list);
				s1.setVisible(true);
			}
		});
		jBtnArray[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
				AddStudent c1=new AddStudent(list);
				c1.setVisible(true);
			}
		});
		jBtnArray[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
				UpdateStudent u1=new UpdateStudent(list);
				u1.setVisible(true);
			}
		});
		jBtnArray[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
				ViewStudent u1=new ViewStudent(list);
				u1.setVisible(true);
			}
		});
		jBtnArray[3].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
				DeleteStudent u1=new DeleteStudent(list);
				u1.setVisible(true);
			}
		});
	}
}

class AddStudent extends JFrame {
    private JLabel mainTitleLbl, nicLbl, nameLbl, lecModeLbl, prfMarkLbl, dbmsMarkLbl;
    private JTextField nicTxt, nameTxt, lecModeTxt, prfMarkTxt, dbmsMarkTxt;
    private JButton addStudentBtn, cancelBtn;
    private JPanel txtNamePanel, northColorPanel, btnPanel;
    private Node list;

    public AddStudent(Node listLocal) {
        this.list = listLocal;
        setSize(900, 600);
        setTitle("Add Student");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        northColorPanel = new JPanel(new BorderLayout());
        northColorPanel.setBackground(new Color(51, 153, 255));

        mainTitleLbl = new JLabel("Add Student");
        mainTitleLbl.setHorizontalAlignment(JLabel.CENTER);
        mainTitleLbl.setFont(new Font("SansSerif", Font.BOLD, 50));
        northColorPanel.add(mainTitleLbl, BorderLayout.CENTER);
        mainTitleLbl.setOpaque(true); 
		mainTitleLbl.setBackground(new Color(0, 0, 139)); 
		mainTitleLbl.setForeground(Color.WHITE);       
        add(northColorPanel, BorderLayout.NORTH);

        txtNamePanel = new JPanel(new GridLayout(5, 2, 10, 10));
        txtNamePanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        nicLbl = new JLabel("NIC:");
        nameLbl = new JLabel("Name:");
        lecModeLbl = new JLabel("Lecture Mode (0: Online, 1: Physical):");
        prfMarkLbl = new JLabel("PRF Mark:");
        dbmsMarkLbl = new JLabel("DBMS Mark:");

        nicTxt = new JTextField();
        nameTxt = new JTextField();
        lecModeTxt = new JTextField();
        prfMarkTxt = new JTextField();
        dbmsMarkTxt = new JTextField();

        Font labelFont = new Font("SansSerif", Font.BOLD, 20);
        Font textFont = new Font("SansSerif", Font.PLAIN, 20);

        nicLbl.setFont(labelFont);
        nameLbl.setFont(labelFont);
        lecModeLbl.setFont(labelFont);
        prfMarkLbl.setFont(labelFont);
        dbmsMarkLbl.setFont(labelFont);

        nicTxt.setFont(textFont);
        nameTxt.setFont(textFont);
        lecModeTxt.setFont(textFont);
        prfMarkTxt.setFont(textFont);
        dbmsMarkTxt.setFont(textFont);

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

        add(txtNamePanel, BorderLayout.CENTER);

        addStudentBtn = new JButton("Add Student");
        cancelBtn = new JButton("Cancel");
        addStudentBtn.setFont(labelFont);
        cancelBtn.setFont(labelFont);

		addStudentBtn.setBackground(Color.GREEN);
		addStudentBtn.setForeground(Color.BLACK);

		cancelBtn.setBackground(Color.GREEN);
		cancelBtn.setForeground(Color.BLACK);

        btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        btnPanel.add(cancelBtn);
        btnPanel.add(addStudentBtn);
        add(btnPanel, BorderLayout.SOUTH);

        addStudentBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nic = nicTxt.getText().trim();
                String name = nameTxt.getText().trim();
                String lecModeStr = lecModeTxt.getText().trim();
                String prfStr = prfMarkTxt.getText().trim();
                String dbmsStr = dbmsMarkTxt.getText().trim();

                if (nic.isEmpty() || name.isEmpty() || lecModeStr.isEmpty() ||
                        prfStr.isEmpty() || dbmsStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields must be filled.");
                    return;
                }

                try {
                    int lecMode = Integer.parseInt(lecModeStr);
                    int prfMark = Integer.parseInt(prfStr);
                    int dbmsMark = Integer.parseInt(dbmsStr);

                    if (list.checkNIC(nic)) {
                        JOptionPane.showMessageDialog(null, "NIC already exists.");
                        return;
                    }

                    if (nic.length() != 12) {
                        JOptionPane.showMessageDialog(null, "NIC must be exactly 12 characters.");
                        return;
                    }

                    if (prfMark < 0 || prfMark > 100) {
                        JOptionPane.showMessageDialog(null, "PRF mark must be between 0 and 100.");
                        return;
                    }

                    if (dbmsMark < 0 || dbmsMark > 100) {
                        JOptionPane.showMessageDialog(null, "DBMS mark must be between 0 and 100.");
                        return;
                    }

                    if (lecMode < 0 || lecMode > 1) {
                        JOptionPane.showMessageDialog(null, "Lecture mode must be 0 or 1.");
                        return;
                    }

                    String prefix = (lecMode == 1) ? "PR" : "OR";
                    String id = prefix + list.generateId();

                    list.add(list.new Student(id, name, nic, prfMark, dbmsMark));

                    try (FileWriter fw = new FileWriter("Student.txt", true)) {
                        fw.write(id + "," + name + "," + nic + "," + prfMark + "," + dbmsMark + "\n");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error writing to file.");
                        return;
                    }

                    JOptionPane.showMessageDialog(null, "Student added successfully! ID: " + id);

                    nicTxt.setText("");
                    nameTxt.setText("");
                    lecModeTxt.setText("");
                    prfMarkTxt.setText("");
                    dbmsMarkTxt.setText("");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numeric values.");
                }
            }
        });

        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                StudentManagement s1 = new StudentManagement(list);
                s1.setVisible(true);
            }
        });
    }
}

class ViewStudent extends JFrame{
	private JLabel idLbl,nicLbl,nameLbl,prfMarkLbl,dbmsMarkLbl;
	private JTextField idTxt,nicTxt,nameTxt,prfMarkTxt,dbmsMarkTxt;
	private JButton searchBtn,resetBtn,cancelBtn;
	private Node list;
	
	ViewStudent(Node listLocal){
		this.list=listLocal;
		setSize(900,600);
		setTitle("View Student");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JLabel titleLbl=new JLabel("View Student");
		titleLbl.setFont(new Font("",3,20));
		titleLbl.setHorizontalAlignment(JLabel.CENTER);
		titleLbl.setOpaque(true); 
		titleLbl.setBackground(new Color(0, 0, 139)); 
		titleLbl.setForeground(Color.WHITE); 
		add("North",titleLbl);
		
		JPanel studentDetailPanel=new JPanel(new GridLayout(5,2,10,10));
		
		idLbl=new JLabel("Student ID : ");
		idTxt=new JTextField();
		idLbl.setFont(new Font("",1,20));
		idTxt.setFont(new Font("",1,20));
		
		nicLbl=new JLabel("NIC : ");
		nicTxt=new JTextField();
		nicLbl.setFont(new Font("",1,20));
		nicTxt.setFont(new Font("",1,20));
		
		nameLbl=new JLabel("Name : ");
		nameTxt=new JTextField();
		nameLbl.setFont(new Font("",1,20));
		nameTxt.setFont(new Font("",1,20));
		
		prfMarkLbl=new JLabel("PRF Mark : ");
		prfMarkTxt=new JTextField();
		prfMarkLbl.setFont(new Font("",1,20));
		prfMarkTxt.setFont(new Font("",1,20));
		
		dbmsMarkLbl=new JLabel("DBMS Mark : ");
		dbmsMarkTxt=new JTextField();
		dbmsMarkLbl.setFont(new Font("",1,20));
		dbmsMarkTxt.setFont(new Font("",1,20));
		
		studentDetailPanel.add(idLbl);
		studentDetailPanel.add(idTxt);
		studentDetailPanel.add(nicLbl);
		studentDetailPanel.add(nicTxt);
		studentDetailPanel.add(nameLbl);
		studentDetailPanel.add(nameTxt);
		studentDetailPanel.add(prfMarkLbl);
		studentDetailPanel.add(prfMarkTxt);
		studentDetailPanel.add(dbmsMarkLbl);
		studentDetailPanel.add(dbmsMarkTxt);
		
		add("Center",studentDetailPanel);
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		searchBtn=new JButton("Search");
		resetBtn=new JButton("Reset");
		cancelBtn=new JButton("Cancel");
		
		searchBtn.setBackground(Color.GREEN);
		searchBtn.setForeground(Color.BLACK);
		
		resetBtn.setBackground(Color.GREEN);
		resetBtn.setForeground(Color.BLACK);

		cancelBtn.setBackground(Color.GREEN);
		cancelBtn.setForeground(Color.BLACK);
		
		buttonPanel.add(cancelBtn);
		buttonPanel.add(resetBtn);
		buttonPanel.add(searchBtn);
		add("South",buttonPanel);
		
		searchBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String id=idTxt.getText();
				if(!list.search(id)){
					JOptionPane.showMessageDialog(null,"ID is not exsits...");
					return;
				}
				
				Node.Student index=list.get(id);
				String name=index.getName();
				nameTxt.setText(name);
				String nic=index.getNIC();
				nicTxt.setText(nic);
				int prfMark=index.getPRFMark();
				prfMarkTxt.setText(Integer.toString(prfMark));
				int dbmsMark=index.getDBMSMark();
				dbmsMarkTxt.setText(Integer.toString(dbmsMark));				
			}
		});
		
		resetBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				idTxt.setText("");
				nicTxt.setText("");
				nameTxt.setText("");
				prfMarkTxt.setText("");
				dbmsMarkTxt.setText("");
			}
		});
		
		cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                StudentManagement s1 = new StudentManagement(list);
                s1.setVisible(true);
            }
        });
	}
}

class UpdateStudent extends JFrame{
	private JLabel idLbl,nicLbl,nameLbl,prfMarkLbl,dbmsMarkLbl;
	private JTextField idTxt,nicTxt,nameTxt,prfMarkTxt,dbmsMarkTxt;
	private JButton updateStudentBtn,cancelBtn,searchBtn;
	private Node list;
	
	UpdateStudent(Node listLocal){
		this.list=listLocal;
		setSize(900,600);
		setTitle("Update Student");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JLabel titleLbl=new JLabel ("Update Student");
		titleLbl.setFont(new Font("",3,20));
		titleLbl.setHorizontalAlignment(JLabel.CENTER);
		titleLbl.setOpaque(true); 
		titleLbl.setBackground(new Color(0, 0, 139)); 
		titleLbl.setForeground(Color.WHITE); 
		add("North",titleLbl);
		
		JPanel bodyPanel=new JPanel(new GridLayout(5,2,10,10));
		searchBtn=new JButton("Search");
		idTxt=new JTextField();
		searchBtn.setFont(new Font("",1,20));
		idTxt.setFont(new Font("",1,20));
		
		nicLbl=new JLabel("NIC : ");
		nicTxt=new JTextField();
		nicLbl.setFont(new Font("",1,20));
		nicTxt.setFont(new Font("",1,20));
		
		nameLbl=new JLabel("Name : ");
		nameTxt=new JTextField();
		nameLbl.setFont(new Font("",1,20));
		nameTxt.setFont(new Font("",1,20));
		
		prfMarkLbl=new JLabel("PRF Mark : ");
		prfMarkTxt=new JTextField();
		prfMarkLbl.setFont(new Font("",1,20));
		prfMarkTxt.setFont(new Font("",1,20));
		
		dbmsMarkLbl=new JLabel("DBMS Mark : ");
		dbmsMarkTxt=new JTextField();
		dbmsMarkLbl.setFont(new Font("",1,20));
		dbmsMarkTxt.setFont(new Font("",1,20));
		
		bodyPanel.add(idTxt);
		bodyPanel.add(searchBtn);
		bodyPanel.add(nicLbl);
		bodyPanel.add(nicTxt);
		bodyPanel.add(nameLbl);
		bodyPanel.add(nameTxt);
		bodyPanel.add(prfMarkLbl);
		bodyPanel.add(prfMarkTxt);
		bodyPanel.add(dbmsMarkLbl);
		bodyPanel.add(dbmsMarkTxt);
		
		add("Center",bodyPanel);
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		updateStudentBtn=new JButton("Update Student");
		cancelBtn=new JButton("Cancel");
		
		searchBtn.setBackground(Color.GREEN);
		searchBtn.setForeground(Color.BLACK);
		
		updateStudentBtn.setBackground(Color.GREEN);
		updateStudentBtn.setForeground(Color.BLACK);
		
		cancelBtn.setBackground(Color.GREEN);
		cancelBtn.setForeground(Color.BLACK);
		
		buttonPanel.add(cancelBtn);
		buttonPanel.add(updateStudentBtn);
		
		add("South",buttonPanel);
		
		searchBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String id=idTxt.getText();
				if(!list.search(id)){
					JOptionPane.showMessageDialog(null,"ID is not exsits...");
					return;
				}
				
				Node.Student index=list.get(id);
				String name=index.getName();
				nameTxt.setText(name);
				String nic=index.getNIC();
				nicTxt.setText(nic);
				int prfMark=index.getPRFMark();
				prfMarkTxt.setText(Integer.toString(prfMark));
				int dbmsMark=index.getDBMSMark();
				dbmsMarkTxt.setText(Integer.toString(dbmsMark));
			}
		});
		
		updateStudentBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String id=idTxt.getText();
				String nic=nicTxt.getText();
				String name=nameTxt.getText();
				int prfMark=Integer.parseInt(prfMarkTxt.getText());
				int dbmsMark=Integer.parseInt(dbmsMarkTxt.getText());
				
				Node.Student index=list.get(id);
				index.setName(name);
				index.setNIC(nic);
				index.setPRFMark(prfMark);
				index.setDBMSMark(dbmsMark);
				
				File studentFile=new File("Student.txt");
				try{
					FileWriter fw1=new FileWriter(studentFile);
					fw1.close();
					studentFile.delete();
					FileWriter fw=new FileWriter(studentFile);
					
					for(int i=0;i<list.size();i++){
						String id1=list.getIndex(i).getID();
						String name1=list.getIndex(i).getName();
						String nic1=list.getIndex(i).getNIC();
						String prfMark1=Integer.toString(list.getIndex(i).getPRFMark());
						String dbmsMark1=Integer.toString(list.getIndex(i).getDBMSMark());
						fw.write(id1+","+name1+","+nic1+","+prfMark1+","+dbmsMark1+"/n");
					}
					fw.close();
				}catch(IOException ex){
					
				}
				
				JOptionPane.showMessageDialog(null,"Update successfully...");
				idTxt.setText("");
				nicTxt.setText("");
				nameTxt.setText("");
				prfMarkTxt.setText("");
				dbmsMarkTxt.setText("");
			}
		});
		
		cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                StudentManagement s1 = new StudentManagement(list);
                s1.setVisible(true);
            }
        });
	}
}

class DeleteStudent extends JFrame{
	private JLabel idLbl,nicLbl,nameLbl,prfMarkLbl,dbmsMarkLbl;
	private JTextField idTxt,nicTxt,nameTxt,prfMarkTxt,dbmsMarkTxt;
	private JButton deleteStudentBtn,cancelBtn,searchBtn;
	private Node list;
	
	DeleteStudent(Node listLocal){
		this.list=listLocal;
		setSize(900,600);
		setTitle("Delete Student");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JLabel titleLbl=new JLabel("Delete Student");
		titleLbl.setFont(new Font("",3,20));
		titleLbl.setHorizontalAlignment(JLabel.CENTER);
		titleLbl.setOpaque(true); 
		titleLbl.setBackground(new Color(0, 0, 139)); 
		titleLbl.setForeground(Color.WHITE); 
		add("North",titleLbl);
		
		JPanel bodyPanel=new JPanel(new GridLayout(5,2,10,10));
		searchBtn=new JButton("Search");
		idTxt=new JTextField();
		searchBtn.setFont(new Font("",1,20));
		idTxt.setFont(new Font("",1,20));
		
		nicLbl=new JLabel("NIC : ");
		nicTxt=new JTextField();
		nicLbl.setFont(new Font("",1,20));
		nicTxt.setFont(new Font("",1,20));
		
		nameLbl=new JLabel("Name : ");
		nameTxt=new JTextField();
		nameLbl.setFont(new Font("",1,20));
		nameTxt.setFont(new Font("",1,20));
		
		prfMarkLbl=new JLabel("PRF Mark : ");
		prfMarkTxt=new JTextField();
		prfMarkLbl.setFont(new Font("",1,20));
		prfMarkTxt.setFont(new Font("",1,20));
		
		dbmsMarkLbl=new JLabel("DBMS Mark : ");
		dbmsMarkTxt=new JTextField();
		dbmsMarkLbl.setFont(new Font("",1,20));
		dbmsMarkTxt.setFont(new Font("",1,20));
		
		bodyPanel.add(idTxt);
		bodyPanel.add(searchBtn);
		bodyPanel.add(nicLbl);
		bodyPanel.add(nicTxt);
		bodyPanel.add(nameLbl);
		bodyPanel.add(nameTxt);
		bodyPanel.add(prfMarkLbl);
		bodyPanel.add(prfMarkTxt);
		bodyPanel.add(dbmsMarkLbl);
		bodyPanel.add(dbmsMarkTxt);
		
		add("Center",bodyPanel);
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		deleteStudentBtn=new JButton("Delete Student");
		cancelBtn=new JButton("Cancel");
		
		searchBtn.setBackground(Color.GREEN);
		searchBtn.setForeground(Color.BLACK);
		
		deleteStudentBtn.setBackground(Color.GREEN);
		deleteStudentBtn.setForeground(Color.BLACK);
		
		cancelBtn.setBackground(Color.GREEN);
		cancelBtn.setForeground(Color.BLACK);
		
		buttonPanel.add(cancelBtn);
		buttonPanel.add(deleteStudentBtn);
		
		add("South",buttonPanel);
		
		searchBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String id=idTxt.getText();
				if(!list.search(id)){
					JOptionPane.showMessageDialog(null,"ID is not exsits...");
					return;
				}
				
				Node.Student index=list.get(id);
				String name=index.getName();
				nameTxt.setText(name);
				String nic=index.getNIC();
				nicTxt.setText(nic);
				int prfMark=index.getPRFMark();
				prfMarkTxt.setText(Integer.toString(prfMark));
				int dbmsMark=index.getDBMSMark();
				dbmsMarkTxt.setText(Integer.toString(dbmsMark));
			}
		});
		
		deleteStudentBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String stuID=idTxt.getText();
				int no=list.indexOf(stuID);
				list.remove(no);
				File studentFile=new File("Student.txt");
				try{
					FileWriter fw1=new FileWriter(studentFile);
					fw1.close();
					studentFile.delete();
					FileWriter fw=new FileWriter(studentFile);
					for(int i=0;i<list.size();i++){
						String id=list.getIndex(i).getID();
						String name=list.getIndex(i).getName();
						String nic=list.getIndex(i).getNIC();
						String prfMark=Integer.toString(list.getIndex(i).getPRFMark());
						String dbmsMark=Integer.toString(list.getIndex(i).getDBMSMark());
						
						fw.write(id+","+name+","+nic+","+prfMark+","+dbmsMark+"\n");
					}
					fw.close();
				}catch(IOException ex){
					
				}
				JOptionPane.showMessageDialog(null,"Deleted Successfully...");
				idTxt.setText("");
				nicTxt.setText("");
				nameTxt.setText("");
				prfMarkTxt.setText("");
				dbmsMarkTxt.setText("");
			}
		});
		
		cancelBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				StudentManagement s1=new StudentManagement(list);
				s1.setVisible(true);
			}
		});
	}
}

class StudentReport extends JFrame {
    private JLabel titleLbl;
    private JButton backBtn;
    private DefaultTableModel dtm;
    private JTable tblCustomerDetails;
    private Node list;

    StudentReport(Node listLocal) {
        this.list = listLocal;
        setSize(900, 600);
        setTitle("View Student Report");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        titleLbl = new JLabel("View Student Report");
        titleLbl.setFont(new Font("SansSerif", Font.BOLD, 35));
        titleLbl.setHorizontalAlignment(JLabel.CENTER);
        titleLbl.setOpaque(true); 
		titleLbl.setBackground(new Color(0, 0, 139)); 
		titleLbl.setForeground(Color.WHITE); 
        add(titleLbl, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backBtn = new JButton("Back");
        backBtn.setFont(new Font("SansSerif", Font.BOLD, 18));
        backBtn.setBackground(Color.GREEN);
		backBtn.setForeground(Color.BLACK);
        buttonPanel.add(backBtn);
        add(buttonPanel, BorderLayout.SOUTH);

        String[] columnsName = {"No", "Student ID", "Name", "NIC", "PRF Mark", "DBMS Mark", "GPA"};
        dtm = new DefaultTableModel(columnsName, 0);

        for (int i = 0; i < list.size(); i++) {
            Node.Student student = list.getIndex(i);
            double prf = student.getPRFMark();
            double dbms = student.getDBMSMark();
            double gpaValue = (list.searchGPA(prf) + list.searchGPA(dbms)) / 2;

            String[] rowData = {
                String.valueOf(i + 1),
                student.getID(),
                student.getName(),
                student.getNIC(),
                String.valueOf(prf),
                String.valueOf(dbms),
                String.format("%.2f", gpaValue)
            };
            dtm.addRow(rowData);
        }

        tblCustomerDetails = new JTable(dtm);
        JScrollPane tablePane = new JScrollPane(tblCustomerDetails);
        add(tablePane, BorderLayout.CENTER);

        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                StudentManagementFirstPage s1 = new StudentManagementFirstPage(list);
                s1.setVisible(true);
            }
        });
    }
}

class Demo{
	public static void main(String[] args)throws IOException{
		Node list=new Node();
		
		StudentManagementFirstPage s1=new StudentManagementFirstPage(list);
		s1.setVisible(true);
		
		File studentFile=new File("Student.txt");
		
		Scanner input=new Scanner(studentFile);
		while(input.hasNext()){
			String line=input.nextLine();
			String rowData[]=line.split(",");
			String id=rowData[0];
			String name=rowData[1];
			String nic=rowData[2];
			int prfMark=Integer.parseInt(rowData[3]);
			int dbmsMark=Integer.parseInt(rowData[4]);
			list.add(list.new Student(id,name,nic,prfMark,dbmsMark));
			System.out.println(line);
		}
	}
}
