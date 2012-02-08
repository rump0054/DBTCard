package data;

import java.sql.Connection;
import entities.Target;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class TargetDB {

    protected int maxRows;
    protected final String SQL_SELECT = "SELECT targetID, rangeMax, categoryID, target, description FROM c_target";
    protected final String SQL_INSERT = "INSERT INTO c_target ( rangeMax, categoryID, target, description ) VALUES ( ?, ?, ?, ? )";
    protected final String SQL_UPDATE = "UPDATE c_target SET targetID = ?, rangeMax = ?, categoryID = ?, target = ?, description = ? WHERE targetID = ?";
    protected final String SQL_DELETE = "DELETE FROM c_target WHERE targetID = ?";
    protected static final int COLUMN_TARGET_I_D = 1;
    protected static final int COLUMN_RANGE_MAX = 2;
    protected static final int COLUMN_CATEGORY_I_D = 3;
    protected static final int COLUMN_TARGET = 4;
    protected static final int COLUMN_DESCRIPTION = 5;
    protected static final int NUMBER_OF_COLUMNS = 5;
    protected static final int PK_COLUMN_TARGET_I_D = 1;

    public Target insert(Target target) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            int index = 1;

            ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(index++, target.getRangeMax());
            ps.setLong(index++, target.getCategoryID());
            ps.setString(index++, target.getTarget());
            ps.setString(index++, target.getDescription());

            int rows = ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                target.setTargetID(rs.getLong(1));
            }

            rs.close();
            ps.close();;
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            pool.freeConnection(connection);

        }

        return target;
    }

    /**
     * Updates a single row in the c_target table.
     */
    public void update(Target target) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        try {
            int index = 1;

            ps = connection.prepareStatement(SQL_UPDATE);
            ps.setLong(index++, target.getTargetID());
            ps.setString(index++, target.getRangeMax());
            ps.setLong(index++, target.getCategoryID());
            ps.setString(index++, target.getTarget());
            ps.setString(index++, target.getDescription());
            ps.setLong(6, target.getTargetID());

            int rows = ps.executeUpdate();
            
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            pool.freeConnection(connection);
        }

    }

    /**
     * Deletes a single row in the c_target table.
     */
    public void delete(long targetID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(SQL_DELETE);
            ps.setLong(1, targetID);

            int rows = ps.executeUpdate();
            
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.freeConnection(connection);
        }
    }

    /**
     * Returns the rows from the c_target table that matches the specified
     * primary-key value.
     */
    public Target getTargetByID(Target target) {
        return getTargetByID(target.getTargetID());
    }

    /**
     * Returns all rows from the c_target table that match the criteria
     * 'targetID = :targetID'.
     */
    public Target getTargetByID(long targetID) {
        Target target = new Target();

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String SQL = SQL_SELECT + " WHERE targetID = ?";
            ps = connection.prepareStatement(SQL);
            ps.setLong(1, targetID);
            
            rs = ps.executeQuery();

            if (rs.next()) {
                target.setTargetID(rs.getLong(COLUMN_TARGET_I_D));
                target.setRangeMax(rs.getString(COLUMN_RANGE_MAX));
                target.setCategoryID(rs.getLong(COLUMN_CATEGORY_I_D));
                target.setTarget(rs.getString(COLUMN_TARGET));
                target.setDescription(rs.getString(COLUMN_DESCRIPTION));
            }

            rs.close();
            ps.close();;
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            pool.freeConnection(connection);
        }

        return target;
    }

    /**
     * Returns all rows from the c_target table that match the criteria ''.
     */
    public ArrayList<Target> findAll() {
        return findByDynamicSelect(SQL_SELECT + " ORDER BY targetID", null);
    }

    /**
     * Returns all rows from the c_target table that match the criteria
     * 'categoryID = :categoryID'.
     */
    public ArrayList<Target> getTargetsByCategory(long categoryID) {
        return findByDynamicSelect(SQL_SELECT + " WHERE categoryID = ? ORDER BY target ASC",
                new Object[]{new Long(categoryID)});
    }

    /**
     * Fetches a single row from the result set
     */
    protected Target fetchSingleResult(ResultSet rs) throws SQLException {
        if (rs.next()) {
            Target target = new Target();
            populateDto(target, rs);
            return target;
        } else {
            return null;
        }
    }

    /**
     * Fetches multiple rows from the result set
     */
    protected ArrayList<Target> fetchMultiResults(ResultSet rs) throws SQLException {
        ArrayList<Target> targets = new ArrayList<Target>();
        while (rs.next()) {
            Target target = new Target();
            populateDto(target, rs);
            targets.add(target);
        }

        return targets;
    }

    /**
     * Populates a DTO with data from a ResultSet
     */
    protected void populateDto(Target target, ResultSet rs) throws SQLException {
        target.setTargetID(rs.getLong(COLUMN_TARGET_I_D));
        target.setRangeMax(rs.getString(COLUMN_RANGE_MAX));
        target.setCategoryID(rs.getLong(COLUMN_CATEGORY_I_D));
        target.setTarget(rs.getString(COLUMN_TARGET));
        target.setDescription(rs.getString(COLUMN_DESCRIPTION));
    }

    /**
     * Returns all rows from the c_target table that match the specified
     * arbitrary SQL statement
     */
    public ArrayList<Target> findByDynamicSelect(String sql, Object[] sqlParams)
    {
        ArrayList<Target> targets = new ArrayList<Target>();
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try 
        {
            // construct the SQL statement
            final String SQL = sql;

            // prepare statement
            ps = connection.prepareStatement(SQL);

            // bind parameters
            for (int i = 0; sqlParams != null && i < sqlParams.length; i++) {
                ps.setObject(i + 1, sqlParams[i]);
            }


            rs = ps.executeQuery();

            // fetch the results
            targets = fetchMultiResults(rs);
            
            rs.close();
            ps.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            pool.freeConnection(connection);
        }
        
        return targets;
    }
}
