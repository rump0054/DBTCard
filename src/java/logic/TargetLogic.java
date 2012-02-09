package logic;

import java.util.ArrayList;

import org.vraptor.annotations.Component;
import org.vraptor.annotations.Out;
import org.vraptor.annotations.Parameter;
import org.vraptor.annotations.Remotable;

import data.TargetDB;
import entities.Target;

@Component("target")
public class TargetLogic
{
    @Out
    private Target target;
    
    @Out
    private ArrayList<Target> targets;
    

    public void feelings()
    {
        TargetDB db = new TargetDB();
        targets = new ArrayList<Target>();
        targets = db.getTargetsByCategory(7);
    }
    
    /*public void thoughts()
    {
        TargetDB db = new TargetDB();
        targets = new ArrayList<Target>();
        targets = db.getTargetsByCategory(6);
    }
    
    public void behaviors()
    {
        TargetDB db = new TargetDB();
        targets = new ArrayList<Target>();
        targets = db.getTargetsByCategory(5);
    }*/
}
