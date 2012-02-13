package logic;


import org.vraptor.annotations.Component;
import org.vraptor.annotations.Out;
import data.TargetDB;
import data.TemplateDB;
import data.TemplateTargetDB;
import entities.Target;
import entities.Template;
import entities.TemplateTarget;
import java.util.ArrayList;
import org.vraptor.annotations.Parameter;
import org.vraptor.annotations.Remotable;

@Component("template")
public class TemplateLogic
{
    @Parameter(key="ids")
    private Long[] ids;
    
    @Parameter
    private String cardname;
    
    @Out
    private ArrayList<Target> feelings, thoughts, behaviors;
    
    @Out
    private ArrayList<Target> targets;
    
    @Out
    private Template template;
    
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
    
    public void create()
    {
        String username = "erumppe";
        feelings = new ArrayList<Target>();
        thoughts = new ArrayList<Target>();
        behaviors = new ArrayList<Target>();
        
        TemplateDB tempDB = new TemplateDB();
        TargetDB targDB = new TargetDB();
        TemplateTargetDB ttDB = new TemplateTargetDB();
        
        template = new Template();
        template.setUid(username);  
        template.setName(cardname);
        template = tempDB.insert(template);
        
        for(long l : ids)
        {
            Target target = new Target();
            target = targDB.getTargetByID(l);
            
            if(target.getCategoryID() == 7)
                feelings.add(target);
            else if(target.getCategoryID() == 6)
                thoughts.add(target);
            else if(target.getCategoryID() == 5)
                behaviors.add(target);
            
            TemplateTarget tt = new TemplateTarget();
            tt.setCategoryID(target.getCategoryID());
            tt.setDisplayOrder(1);
            tt.setTargetID(target.getTargetID());
            tt.setTemplateID(template.getTemplateID());
            
            tt = ttDB.insert(tt);
        }
    }
}
