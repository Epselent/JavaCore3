public class Counter {
    private int i = 0;
    private int numb;

    public Counter(int numb) {
        this.numb = numb;
    }

    public Integer increm(){
        return i++;
    }
    public void info() {
        System.out.println("Количество элементов " + numb + " равно " + i);;
    }

    public int getNumb() {
        return numb;
    }
}
