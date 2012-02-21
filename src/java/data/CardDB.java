package data;

import java.sql.*;

public class CardDB
{
    public static boolean hasCard(String username, long weekStart)
    {
        boolean needCard = false;
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String q = "SELECT * FROM u_card WHERE username=? AND weekStart=?";

        try {
            
            ps = connection.prepareStatement(q);
            ps.setString(1, username);
            ps.setDate(2, new java.sql.Date(weekStart));
            
            rs = ps.executeQuery();

            if (rs != null && rs.next()) {
                needCard = true;
            }

            rs.close();
            ps.close();;
        } catch (SQLException e) {
           e.printStackTrace();

        } finally {
            pool.freeConnection(connection);

        }

        return needCard;
    }
        
    public static long insertCard(String username, long weekStart)
    {
        long id = 0;
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String q = "INSERT INTO u_card(`username`, `weekStart`) VALUES (?,?)";

        try {
            
            ps = connection.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, username);
            ps.setDate(2, new java.sql.Date(weekStart));
            
            System.out.println(ps.toString());

            int rows = ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                id = rs.getLong(1);
            }

            rs.close();
            ps.close();;
        } catch (SQLException e) {
           e.printStackTrace();

        } finally {
            pool.freeConnection(connection);

        }

        return id;
    }  
    
    public static void insertCardTargets(long cardID, long targetID)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String q = "INSERT INTO u_card_template ( cardID, targetID ) VALUES (?,?)";
        try {
            
            ps = connection.prepareStatement(q);
            ps.setLong(1, cardID);
            ps.setLong(2, targetID);

            int rows = ps.executeUpdate();

            ps.close();;
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            pool.freeConnection(connection);

        }
    }
}
