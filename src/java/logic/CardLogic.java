package logic;

import data.CardDB;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.vraptor.annotations.Component;
import org.vraptor.annotations.In;
import org.vraptor.annotations.Out;
import utils.DateUtils;

@Component("card")
public class CardLogic
{    
    @In
    private HttpServletRequest request;
    
    @Out
    private ArrayList<String> dates;
    
    public String check()
    {
        String template = "";
        String username = request.getRemoteUser();
        long weekStart = DateUtils.getWeekStart();
        
        if (CardDB.hasCard(username, weekStart))
        {
            template="ok";
        }
        else
        {
            template="no";
        }
        
        return template;        
    }
    
    public void generate()
    {
        dates = new ArrayList<String>();
        dates = DateUtils.getWeekDays();
    }
}
