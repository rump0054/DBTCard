package logic;

import org.vraptor.annotations.Component;
import org.vraptor.annotations.Out;
import data.TargetDB;
import entities.Target;
import java.util.ArrayList;
import org.vraptor.annotations.Remotable;

@Component("card")
public class CardLogic
{    
    @Out
    private ArrayList<Target> targets;
    
    @Remotable
    public void targets()
    {
        String username = "erumppe";
        
        TargetDB db = new TargetDB();
        targets = new ArrayList<Target>();        
        targets = db.findAll();
    }
}
