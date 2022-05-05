package source.UI.source;

public class LinkNote {
    //值域
    public int value;
    //地址域
    public LinkNote next;

    public LinkNote(){}
    public LinkNote(int value){
        this.value = value;
    }
    public  LinkNote(int value,LinkNote next){
        this.value = value;
        this.next = next;
    }
}
