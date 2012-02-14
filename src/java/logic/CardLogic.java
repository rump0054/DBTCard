package logic;

import data.TargetDB;
import data.TemplateDB;
import entities.Template;
import entities.Target;
import java.util.ArrayList;
import org.vraptor.annotations.Component;
import org.vraptor.annotations.Out;
import org.vraptor.annotations.Parameter;

@Component("card")
public class CardLogic
{    
    @Parameter
    private long templateID;
    
    @Out
    private Template template;
    
    public void generate()
    {
        ArrayList<Target> targets = new ArrayList<Target>();
        TemplateDB tempDB = new TemplateDB();
        TargetDB targDB = new TargetDB();
        
        template = new Template();
        template = tempDB.findByPrimaryKey(templateID);
        
        //targets = targDB.
        
    }
}
