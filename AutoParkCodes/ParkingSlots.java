import java.util.Scanner;

public class ParkingSlots {
    private String Name;
    private String appearance;
    private boolean isSelected;
    private boolean occupy;
    private boolean disabledElectric;

    public ParkingSlots(String name) {
        Name = name;
        appearance = "|  " + name + "  |";
        isSelected = false;
        occupy = false;
        disabledElectric = false;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setDisabledElectric(boolean disabledElectric) {
        this.disabledElectric = disabledElectric;
        appearance = GFG.ANSI_YELLOW + appearance + GFG.ANSI_RESET;
    }



    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        if (selected){
            if (occupy){
                System.out.println("Cannot select occupy places");
                return;
            }
            appearance = GFG.ANSI_BLUE + appearance + GFG.ANSI_RESET;
        }
        else{
            appearance = appearance.replace( GFG.ANSI_BLUE,"");
            appearance = appearance.replace( GFG.ANSI_RESET,"");
        }
        isSelected = selected;
    }

    public boolean isOccupy() {
        return occupy;
    }

    public void setOccupy(boolean occupy) {
        if (occupy)
            appearance = GFG.ANSI_RED + appearance + GFG.ANSI_RESET;
        this.occupy = occupy;
    }
}
class GFG {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
}

