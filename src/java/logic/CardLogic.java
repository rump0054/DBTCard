package logic;

import org.vraptor.annotations.Component;
import data.TargetDB;
import entities.Target;
import java.util.ArrayList;
import org.vraptor.annotations.Parameter;
import org.vraptor.annotations.Remotable;

@Component("card")
public class CardLogic
{    
    @Parameter
    private long templateID;
    
    public void generate()
    {
        
    }
}
