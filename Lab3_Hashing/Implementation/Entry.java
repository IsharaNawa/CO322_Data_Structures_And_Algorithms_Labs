public class Entry {
    
    private int key;
    private String value;

    public Entry(int key,String value){
        this.key=key;
        this.value=value;
    }

    public int getKey(){
        return this.key;
    }

    public String getValue(){
        return this.value;
    }

}
