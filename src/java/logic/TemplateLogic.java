package logic;


import org.vraptor.annotations.Component;
import org.vraptor.annotations.Out;
import data.TargetDB;
import entities.Target;
import java.util.ArrayList;
import org.vraptor.annotations.Remotable;

@Component("template")
public class TemplateLogic
{    
    /*@Out
    private Template template;*/
    
    @Out
    private ArrayList<Target> feelings, thoughts, behaviors;
    
    @Out
    private ArrayList<Target> targets;
    
    /*@Out
    private List<Target> targets;*/
    
    public void form()
    {
        String username = "erumppe";
        
        TargetDB db = new TargetDB();
        feelings = new ArrayList<Target>();
        thoughts = new ArrayList<Target>();
        behaviors = new ArrayList<Target>();
        
        feelings = db.getTargetsByCategory(7, username);
        thoughts = db.getTargetsByCategory(6, username);
        behaviors = db.getTargetsByCategory(5, username);
        
    }
 
    @Remotable
     public void targets()
    {
        String username = "erumppe";
        
        TargetDB db = new TargetDB();
        //targets = new ArrayList<ArrayList<Target>>();
        feelings = new ArrayList<Target>();
        thoughts = new ArrayList<Target>();
        behaviors = new ArrayList<Target>();
        
        feelings = db.getTargetsByCategory(7, username);
        thoughts = db.getTargetsByCategory(6, username);
        behaviors = db.getTargetsByCategory(5, username);
        
        targets = db.findAll();
    }
    
    /*public void create(Template t)
    {
        t.setUid("erumppe");
        
        TemplateDB db = new TemplateDB();
        template = db.insert(t);
    }
    
    public void addTargets(Target target)
    {
        TargetDB db = new TargetDB();
    }*/
}
