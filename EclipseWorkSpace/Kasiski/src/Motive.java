
public class Motive {
	private String motiveName;
	private int position;
	private Motive link;
	
	public Motive(){
		link=null;
		motiveName=null;
		position=0;
	}
	
	public Motive(String aNewMotive,int aNewPosition,Motive linkValue){
		newMotive(aNewMotive,aNewPosition);
		link=linkValue;
	}
	 public void newMotive(String aNewMotive,int aNewPosition){
		 motiveName=aNewMotive;
		 position=aNewPosition;
		 
	 }
	 public void setLink(Motive newLink){
		 link=newLink;
	 }
	 
	 public String getMotiveName(){
		 return motiveName;
	 }
	 public int getPosition(){
		 return position;
	 }

}
