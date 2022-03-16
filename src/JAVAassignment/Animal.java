package JAVAassignment;

public class Animal {
    public static void main(String[] args){
        Animals obj1=new Animals();
        obj1.setCarnivorous("Lion");
        Animals obj2=new Animals();
        obj2.setHerbivorous("Deer");
        Animals obj3=new Animals();
        obj3.setOmnivorous("Bear");
        System.out.println(obj1.getCarnivorous());
        System.out.println(obj2.getHerbivorous());
        System.out.println(obj3.getOmnivorous());
    }
}
class Animals
{
    private String carnivorous;
    public String getCarnivorous(){
    return carnivorous;
    }
    public void setCarnivorous(String C){
        this.carnivorous=C;
    }
    private String herbivorous;
    public String getHerbivorous(){
        return herbivorous;
    }
    public void setHerbivorous(String H){
        this.herbivorous=H;
    }
    private String omnivorous;
    public String getOmnivorous(){
        return omnivorous;
    }
    public void setOmnivorous(String O){
        this.omnivorous=O;
    }
}