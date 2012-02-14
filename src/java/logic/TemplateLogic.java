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
import javax.servlet.http.HttpServletRequest;
import org.vraptor.annotations.*;

@Component("template")
public class TemplateLogic
{
    @In
    private HttpServletRequest request;
    
    @Parameter(key="ids")
    private Long[] ids;
    
    @Parameter
    private long cID;
    
    @Parameter
    private String cardname, targetName, targetDesc, range; 
    
    @Out
    private Target target;
    
    @Out
    private ArrayList<Target> feelings, thoughts, behaviors;
    
    @Out
    private ArrayList<Target> targets;
    
    @Out
    private long templateID;
    
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
    
    public void create()
    {
        String username = request.getRemoteUser();
        
        feelings = new ArrayList<Target>();
        thoughts = new ArrayList<Target>();
        behaviors = new ArrayList<Target>();
        
        TemplateDB tempDB = new TemplateDB();
        TargetDB targDB = new TargetDB();
        TemplateTargetDB ttDB = new TemplateTargetDB();
        
        Template template = new Template();
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
        
        templateID = template.getTemplateID();
    }
}
