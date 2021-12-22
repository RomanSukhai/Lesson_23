package Project;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Schedule {
     ArrayList<Seance> seances ;

    public Schedule() {
        this.seances = new ArrayList<>();
    }

    public ArrayList<Seance> getSeances() {
        return seances;
    }

    public void setSeances(ArrayList<Seance> seances) {
        this.seances = seances;
    }

    public Schedule addSeance(Seance seance){
         seances.add(seance);
        return null;
    }
    public void removeSeances(Seance seance)    {
        seances.remove(seance);
    }
    @Override
    public String toString() {
        return "Schedule{" +
                "seances=" + seances +
                '}';
    }
}
