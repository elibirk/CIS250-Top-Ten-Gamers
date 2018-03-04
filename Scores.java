
public class Scores {
	public static final int maxEntries = 10;
    protected int numEntries;
    protected GameEntry[] entries;
    public Scores(){
         entries = new GameEntry[maxEntries];
         fillArray();
         numEntries = 0;
    }
    public String toString(){
         String s = "[";
         for (int i=0; i<numEntries; i++){
             if (i>0)  s+= ", ";
             s += entries[i];
         }
          return s + "]";
    }//end toString
    
    private void fillArray(){
    	for (int i = 0; i < 10; i++){
    		GameEntry entry = new GameEntry("AAA", 0);
    		entries[i]=entry;
    	}//end for
    }//end fill Array
    
    public GameEntry getEntry(int  i){
    	return entries[i];
    }//end getEntry
    
    public void setEntry(int i, GameEntry entry){
    	entries[i] = entry;
    	if(numEntries < 10){
    		numEntries++;
    	}//end if
    }//end setEntry
}//end Scores
