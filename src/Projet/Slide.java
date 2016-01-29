package Projet;

public class Slide implements Comparable{
    private int id;
    
    public Slide(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    @Override
    public int compareTo(Object t) {
        Slide other = (Slide)t;
        int currentId = this.getId();
        int otherId = other.getId();
        if(currentId < otherId) {
            return -1;
        }
        else if(currentId > otherId) {
            return 1;
        }
        else {
            return 0;
        }
    }
    
}
