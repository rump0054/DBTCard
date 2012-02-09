package logic;

import java.util.ArrayList;

import org.vraptor.annotations.Component;
import org.vraptor.annotations.Out;
import org.vraptor.annotations.Parameter;

import data.CategoryDB;
import data.TargetDB;
import data.TemplateDB;
import data.TemplateTargetDB;

import entities.Category;
import entities.Target;
import entities.Template;
import entities.TemplateTarget;

@Component("template")
public class TemplateLogic
{    
    @Out
    private Template template;
    
    @Out
    private ArrayList<Target> feelings, thoughts, behaviors;
    
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
    
    public void create(Template t)
    {
        t.setUid("erumppe");
        
        TemplateDB db = new TemplateDB();
        template = db.insert(t);
    }
    
    public void addTargets(Target target)
    {
        TargetDB db = new TargetDB();
    }
}
