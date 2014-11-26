import java.io.*;
import java.util.*;


public class KasiskiMethod {
	 public static void main(String[] args) {
		 	int j=0;
	        int test=0;	        
	        boolean ok=false;
	        int mot=0;
	        int i=0;
	        int boundU=0;
	        int boundD=0;
	    	boundU=boundD+3;	        
	        Scanner fileScanner =null;
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String tempMotive=null;
	        int dev=1;
	        boolean sysExit=true;
	        try{
	            fileScanner = new Scanner(new FileInputStream("vAll"));
	            
	        }
	        catch (FileNotFoundException e){
	        	System.out.println("error while openning..");
	            System.exit(0);
	        }
	        
	        String str="";  
	        
	        String scanner=null;	      
	        while(fileScanner.hasNext()){
	        	scanner=fileScanner.next();
	        	str=str+scanner;	        
	        }
	        
	        str=str.replaceAll("\\W+", "");//remove all no-letters
	        //System.out.println(str);
	        int strL=str.length(); 
	        str=str.toUpperCase();
	        char[] s=new char[strL];
	        s=str.toCharArray();//convert the string to char[] in order to manipulate	    
	        
	   //short in order to find the freq of each letter 
	        Arrays.sort(s);
	       // System.out.println(s);
	        int h=0;
	        int dd=0;	     
	        int g=0;
	        char ch='A';
	        while(ch<='Z'){
	        	h=0;dd=0;
	        	while( h<strL){
		        	if(s[h]==ch) dd++;
		        	h++;
		        }
	        	 System.out.println(ch+"="+dd);
	        	ch++;	        	
	        }
	       
	    //A new string which in each place has a string of three letters    
	        String[] strTrimmed=new String[strL];
	        i=0;
	        while(i<strL/4 && boundU+3<strL){	        
	        	strTrimmed[i]=str.substring(boundD,boundU);
	        	boundD=boundD+3;
	        	boundU=boundU+3;
	        	i++;	        	
	        }	      
	       
	        String[] motives=new String[strL/3] ;//The division protects system from overflow.Though motive should have found until now.
	        int[] motivesCount=new int[strL/3] ;
	        
	        for( i=0;i<(strL/3);i++) motivesCount[i]=1;//initialing to 1 every motive found
	        
	        int[][] motivesPos=new int[strL/3][strL/3];//The 2-D array stores the "id" of each motive and the positions found
	       
	  //Start find motives and their positions
	        
	        for(i=0;i<(strL/4)-2;i++){	        	
	        	for(test=0;test<i;test++){
    				if(!strTrimmed[test].matches(strTrimmed[i])){//eliminates double seeks
    					ok=true;
    				}
    				else{ ok=false; break;}
    				}
	        	if(ok){
	        		mot++;//a new motive found   			        	
	        		motivesPos[mot][motivesCount[mot]-1]=i;//store the new position that the motive appeared
	        		for( j=i+3;j<(strL/4)-3;j++){	
	        		//check for new matches of the new motive found above
	        			if ( strTrimmed[i].matches(strTrimmed[j])){           		
	        			motives[mot]=strTrimmed[i];
	        			motivesCount[mot]++;
	        			motivesPos[mot][motivesCount[mot]-1]=j;
	        		
	        			}    	
	        		}	
	        	}      	
	        }
	        //Start find distances and common factors(mot is already to its max value).
	        int [][] motivesDist=new int[mot][100];
	        int pos=0;
	      //  int [][] motiveDistFactors=new int [mot][50];
	        for (i=0;i<mot;i++){
	        	for(j=0,pos=0 ;j<strL/3&& pos<100;j++){
	        		if(motivesPos[i][j]!=0&&motivesPos[i][j+1]!=0){
	        			motivesDist[i][pos++]=motivesPos[i][j+1]-motivesPos[i][j];
	        			System.out.print("Dist " +motivesDist[i][pos-1]+" factors :");
	        			 for ( dev=1;dev<=motivesDist[i][pos-1];dev++)
		    				   if(motivesDist[i][pos-1]%dev==0) System.out.print(dev+"," );
	        		}
	        		
	        	}
	        	
	        }
	        
	        //End find motives and their positions
	        
	        //Print
	        
	      /*  	for(i=0;i<mot;i++){
	        	if(motives[i]!=null){
	        	System.out.print("motive No "+i+":");
	        	System.out.print(motives[i]);
	        	System.out.print(" exists :"+motivesCount[i]+"times in ");
	        	for(j=0;j<=200;j++){
	        		if(motivesPos[i][j]!=0)
	        		C(motivesPos[i][j]+",");	        		
	        	}
	        	
	        	System.out.println();
	        	}
	        	
	        }*/
	        	
	        ///---!Print	
	        
	        int r=0;
	        
	        System.out.println("What motive you want to find factors ?");   
	       
	       
	       
	       try {
	           tempMotive = br.readLine();
	        } catch (IOException ioe) {
	           System.out.println("IO error trying to read !");
	        }
	       
	      do{  
	           if(tempMotive=="exit"){
	        	   sysExit=false; 
	        	   continue;	        	  
	           }
	           else{
	        	   for(i=0;i<mot;i++)	    	   
	    	    	   if(motives[i]==tempMotive){
	    	    		   r=i;
	    	    		   continue;
	    	    	   }
	    	       
	    	       for(j=0;j<100;j++){ 
	    	    	   System.out.println("Motive ("+motives[r]+") distance  "+motivesDist[r][j]+" factrors:");
	    	    	   for ( dev=1;dev<=motivesDist[r][j];dev++)
	    				   if(motivesDist[r][j]%dev==0) System.out.print(dev+"," );
	    	       }
	           }
	        
	           System.out.println("What motive you want to find factors(Write exit to loop out) ?");   
		       
		       
		       
		       try {
		           tempMotive = br.readLine();
		        } catch (IOException ioe) {
		           System.out.println("IO error trying to read !");
		        }
		       if(tempMotive=="exit")
	        	   sysExit=false; 
	        	   	        	  
	           
	       
	      }	 while(!sysExit);   
				   
				   
	    	   
       		 
	       
	      /* 
	       do{
	    	   int k=0;
	    	   int dev=0;
	       System.out.println("What motive you want to find factors(Write exit to loop out) ?");
	       try {
	           tempMotive = br.readLine();
	        } catch (IOException ioe) {
	           System.out.println("IO error trying to read your name!");
	           if(tempMotive=="exit"){ sysExit=false; break; }
	        	  // System.exit(sysExit);
	        }
	       int[][] distToFct=new int[1][100]; 	   
	     
	       
	       for(i=0;i<mot;i++){	    	   
	    	   if(motives[i]==tempMotive){
	    		   //findFactors(motivesDist[i][k],i,k);
	    		   
	    		   break;
	    	   }
	    	   
	       }
	       for(k=0;k<=motivesDist.length;k++){
	    	   System.out.println("Fact of "+motives[i]);
	    	   		for(dev=1,j=0;dev<=motivesDist[i][j];j++)
	    	   			if(motivesDist[i][j]%j==0) System.out.print(j+",");
	       }
	        
	       } while(sysExit)   ;    */
	 
	 }

}
	    
	 

