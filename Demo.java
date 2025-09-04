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

class Demo{
	public static void main(String[] args){
		
	}
}
