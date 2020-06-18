public class Cat {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSitost() {
        return sitost;
    }

    public void setSitost(boolean sitost) {
        this.sitost = sitost;
    }

    private int appetite;
    private boolean sitost;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public boolean eat(Plate p) {
       if (p.decreaseFood(appetite)){
           sitost = true;
       } else {
           sitost = false;
       }
       return sitost;
    }
}