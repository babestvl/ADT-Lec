public class State {
    private String name;
    private String county;
    private int FIPS;
    private int obama;
    private int romney;

    public State(String name, String county, int FIPS, int obama, int romney) {
        this.name = name;
        this.county = county;
        this.FIPS = FIPS;
        this.obama = obama;
        this.romney = romney;
    }

    public double percent(int top) {
        double sum;
        sum = obama+romney;
        if (sum <= 0) {
            sum = 1;
        }
        return (top/sum) * 100;
    }

    public String getName() {
        return name;
    }

    public String getCounty() {
        return county;
    }

    public int getFIPS() {
        return FIPS;
    }

    public int getObama() {
        return obama;
    }

    public int getRomney() {
        return romney;
    }

    public double getObamaPercentage() {
        return percent(obama);
    }

    @Override
    public String toString() {
        return String.format("%-35s %12d %10d %8.3f %9.3f",county+ " (" +name+ ")",obama,romney,percent(obama),percent(romney));
    }
}
