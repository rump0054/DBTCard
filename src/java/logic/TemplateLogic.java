package logic;

import data.CardDB;
import org.vraptor.annotations.Component;
import javax.servlet.http.HttpServletRequest;
import utils.DateUtils;
import org.vraptor.annotations.*;

@Component("template")
public class TemplateLogic
{
    @In
    private HttpServletRequest request;
    
    @Parameter(key="ids")
    private Long[] ids;
    
    public void create()
    {
        String username = request.getRemoteUser();
        long weekStart = DateUtils.getWeekStart();
        long cardID = CardDB.insertCard(username, weekStart);
        
        for(Long id : ids)
        {
            CardDB.insertCardTargets(cardID, id);
        }
    }
}