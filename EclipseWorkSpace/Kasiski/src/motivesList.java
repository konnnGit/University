import java.util.*;
public class motivesList {
	private Motive head;
	
	public motivesList(){
		head=null;
	}
	public Iterator<Motive> iterator() {
		// TODO Auto-generated method stub
		return null;
		}
	
	public void addToStart(String motiveName,int motivePosition){
		head=new Motive(motiveName,motivePosition,head);
	}
	public String getNewEntry(){
		return head.getMotiveName();
	}

}
