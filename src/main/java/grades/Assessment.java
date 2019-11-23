package grades;

public class Assessment {
    private String name;
    private int mark;
    private int maxMark;
    private int weighting;

    public Assessment(String name, int maxMark, int mark, int weighting) {
        this.name = name;
        this.mark = mark;
        this.maxMark = maxMark;
        this.weighting = weighting;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setMaxMark(int maxMark) {
        this.maxMark = maxMark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeighting(int weighting) {
        this.weighting = weighting;
    }

    public int getMark() {
        return mark;
    }

    public int getWeighting() {
        return weighting;
    }

    public String getName() {
        return name;
    }

    public int getMaxMark() {
        return maxMark;
    }

    public double markNormalised() {
        double markAttained = mark / maxMark;
        markAttained = markAttained * (weighting / 100);
        return markAttained;
    }

    @Override
    public String toString() {
        String str = name + ": " + mark + "/" + maxMark + "(weighting: " + weighting + "%)";
        return str;
    }
}
