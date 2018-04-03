package ar.edu.untref.aydoo;

public class MakerOfTeaWithMilk {

    private TeaMaker teaMaker = new TeaMaker();
    private MilkMaker milkMaker = new MilkMaker();

    public Glass load(Glass aGlass) {
        teaMaker.putTea(aGlass);
        milkMaker.putMilk(aGlass);
        return aGlass;
    }
}
