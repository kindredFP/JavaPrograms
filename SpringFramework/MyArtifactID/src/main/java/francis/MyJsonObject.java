package francis;

public class MyJsonObject {

    private final long id;
    private final String content;

    public MyJsonObject(long id, String content) {
        this.id = id;
        this.content = content;
    }
    public MyJsonObject() {
    	this.id = 0;
    	this.content ="";
    }    

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
