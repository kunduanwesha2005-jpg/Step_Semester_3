package AbstractionInterface.class_problems;

public abstract class KitchenTool {
    private int speedLevel = 1;

    public int getSpeedLevel() {
        return speedLevel;
    }

    public void setSpeedLevel(int speedLevel) {
        if (speedLevel < 1 || speedLevel > 5) {
            return;
        }
        this.speedLevel = speedLevel;
    }

    public abstract String prepare();
}

interface Washable {
    String clean();
}

class Blender extends KitchenTool implements Washable {
    public Blender() {
    }

    @Override
    public String prepare() {
        return "Blending at speed " + getSpeedLevel();
    }

    @Override
    public String clean() {
        return "Blender rinsed and dried";
    }
}

class Problem4Main {
    public static void main(String[] args) {
        Blender b = new Blender();

        b.setSpeedLevel(3);
        System.out.println(b.getSpeedLevel());

        b.setSpeedLevel(9);
        System.out.println(b.getSpeedLevel());

        System.out.println(b.prepare());
        System.out.println(b.clean());
    }
}
