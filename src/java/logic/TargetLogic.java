package logic;

import java.util.ArrayList;

import org.vraptor.annotations.Component;
import org.vraptor.annotations.Out;

import data.TargetDB;
import entities.Target;
import javax.servlet.http.HttpServletRequest;
import org.vraptor.annotations.*;

@Component("target")
public class TargetLogic
{
    @In
    private HttpServletRequest request;
    
    @Out
    private Target target;
    
    @Out
    private ArrayList<Target> feelings, thoughts, behaviors;
 
    public void form()
    {
        String username = request.getRemoteUser();
        
        TargetDB db = new TargetDB();
        feelings = new ArrayList<Target>();
        thoughts = new ArrayList<Target>();
        behaviors = new ArrayList<Target>();
        
        feelings = db.getTargetsByCategory(7, username);
        thoughts = db.getTargetsByCategory(6, username);
        behaviors = db.getTargetsByCategory(5, username);
        
    }
 
    @Parameter
    private long cID;
    
    @Parameter
    private String targetName, targetDesc, range; 
    
    @Remotable
    public void addtarget()
    {
        String username = request.getRemoteUser();
        
        target = new Target();
        target.setCategoryID(cID);
        target.setTarget(targetName);
        target.setDescription(targetDesc);
        target.setRangeMax(range);
        target.setUsername(username);
        
        TargetDB db = new TargetDB();
        target = db.insert(target);
    }
}
