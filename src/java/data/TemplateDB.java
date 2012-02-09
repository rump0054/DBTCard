package data;

import java.sql.Connection;
import entities.Template;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TemplateDB
{
    /**
     * All finder methods in this class use this SELECT constant to build their
     * queries
     */
    protected final String SQL_SELECT = "SELECT templateID, name, uid FROM c_Template";
    /**
     * Finder methods will pass this value to the JDBC setMaxRows method
     */
    protected int maxRows;
    /**
     * SQL INSERT statement for this table
     */
    protected final String SQL_INSERT = "INSERT INTO c_Template ( name, uid ) VALUES ( ?, ? )";
    /**
     * SQL UPDATE statement for this table
     */
    protected final String SQL_UPDATE = "UPDATE c_Template SET name = ?, uid = ? WHERE templateID = ?";
    /**
     * SQL DELETE statement for this table
     */
    protected final String SQL_DELETE = "DELETE FROM c_Template WHERE templateID = ?";
    /**
     * Index of column templateID
     */
    protected static final int COLUMN_TEMPLATE_I_D = 1;
    /**
     * Index of column name
     */
    protected static final int COLUMN_NAME = 2;
    /**
     * Index of column uid
     */
    protected static final int COLUMN_UID = 3;
    /**
     * Number of columns
     */
    protected static final int NUMBER_OF_COLUMNS = 3;
    /**
     * Index of primary-key column templateID
     */
    protected static final int PK_COLUMN_TEMPLATE_I_D = 1;

    /**
     * Inserts a new row in the c_template table.
     */
    public Template insert(Template dto)
    {  
        // declare variables
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            stmt = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            int index = 1;
            stmt.setString(index++, dto.getName());
            stmt.setString(index++, dto.getUid());
            
            int rows = stmt.executeUpdate();
            
            // retrieve values from auto-increment columns
            rs = stmt.getGeneratedKeys();
            if (rs != null && rs.next())
            {
                dto.setTemplateID(rs.getLong(1));
            }

            rs.close();
            stmt.close();
        }
        catch (Exception _e)
        {
            _e.printStackTrace();
            
        }
        finally
        {
            pool.freeConnection(conn);
        }
        
        return dto;
    }

    /**
     * Updates a single row in the c_template table.
     */
    public void update(Template dto)
    {
        // declare variables
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement stmt = null;

        try
        {
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            int index = 1;
            stmt.setLong(index++, dto.getTemplateID());
            stmt.setString(index++, dto.getName());
            stmt.setString(index++, dto.getUid());
            stmt.setLong(4, dto.getTemplateID());
            
            int rows = stmt.executeUpdate();
            
            stmt.close();
        }
        catch (Exception _e)
        {
            _e.printStackTrace();  
        }
        finally
        {
            pool.freeConnection(conn);
        }
    }

    /**
     * Deletes a single row in the c_template table.
     */
    public void delete(long id)
    {      
        // declare variables
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement stmt = null;

        try
        {
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setLong(1, id);
            int rows = stmt.executeUpdate();
            
            stmt.close();
        }
        catch (Exception _e)
        {
            _e.printStackTrace();
        }
        finally
        {
            pool.freeConnection(conn);
        }
    }

    /**
     * Returns all rows from the c_template table that match the criteria
     * 'templateID = :templateID'.
     */
    public Template findByPrimaryKey(long templateID)
    {
        ArrayList<Template> ret = findByDynamicSelect(SQL_SELECT + " WHERE templateID = ?",
                                    new Object[] {
                                        new Long(templateID)
        });
        
        return ret.isEmpty() ? null : ret.get(0);
    }

    /**
     * Returns all rows from the c_template table that match the criteria ''.
     */
    public ArrayList<Template> findAll()
    {
        return findByDynamicSelect(SQL_SELECT + " ORDER BY templateID", null);
    }

    /**
     * Returns all rows from the c_template table that match the criteria
     * 'templateID = :templateID'.
     */
    public ArrayList<Template> findWhereTemplateIDEquals(long templateID)
    {
        return findByDynamicSelect(SQL_SELECT + " WHERE templateID = ? ORDER BY templateID", new Object[]
                {
                    new Long(templateID)
                });
    }

    /**
     * Returns all rows from the c_template table that match the criteria 'name
     * = :name'.
     */
    public ArrayList<Template> findWhereNameEquals(String name)
    {
        return findByDynamicSelect(SQL_SELECT + " WHERE name = ? ORDER BY name", new Object[]
                {
                    name
                });
    }

    /**
     * Returns all rows from the c_template table that match the criteria 'uid =
     * :uid'.
     */
    public ArrayList<Template> findWhereUidEquals(String uid)
    {
        return findByDynamicSelect(SQL_SELECT + " WHERE uid = ? ORDER BY uid", new Object[]
                {
                    uid
                });
    }

    /**
     * Method 'TemplateDB'
     *
     */
    public TemplateDB()
    {
    }

    /**
     * Gets the value of maxRows
     */
    public int getMaxRows()
    {
        return maxRows;
    }

    /**
     * Fetches a single row from the result set
     */
    protected Template fetchSingleResult(ResultSet rs) throws SQLException
    {
        if (rs.next())
        {
            Template dto = new Template();
            populateDto(dto, rs);
            return dto;
        }
        else
        {
            return null;
        }

    }

    /**
     * Fetches multiple rows from the result set
     */
    protected ArrayList<Template> fetchMultiResults(ResultSet rs) throws SQLException
    {
        ArrayList<Template> resultList = new ArrayList<Template>();
        while (rs.next())
        {
            Template dto = new Template();
            populateDto(dto, rs);
            resultList.add(dto);
        }

        return resultList;
    }

    /**
     * Populates a DTO with data from a ResultSet
     */
    protected void populateDto(Template dto, ResultSet rs) throws SQLException
    {
        dto.setTemplateID(rs.getLong(COLUMN_TEMPLATE_I_D));
        dto.setName(rs.getString(COLUMN_NAME));
        dto.setUid(rs.getString(COLUMN_UID));
    }

    /**
     * Returns all rows from the c_template table that match the specified
     * arbitrary SQL statement
     */
    public ArrayList<Template> findByDynamicSelect(String sql, Object[] sqlParams)
    {
        // declare variables
        ArrayList<Template> temp = new ArrayList<Template>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            // construct the SQL statement
            final String SQL = sql;

            // prepare statement
            stmt = conn.prepareStatement(SQL);

            // bind parameters
            for (int i = 0; sqlParams != null && i < sqlParams.length; i++)
            {
                stmt.setObject(i + 1, sqlParams[i]);
            }

            rs = stmt.executeQuery();

            // fetch the results
            temp = fetchMultiResults(rs);
        }
        catch (Exception _e)
        {
            _e.printStackTrace();          
        }
        finally
        {
            pool.freeConnection(conn);
        }

        return temp;
    }

    /**
     * Returns all rows from the c_template table that match the specified
     * arbitrary SQL statement
     */
    public ArrayList<Template> findByDynamicWhere(String sql, Object[] sqlParams)
    {
        // declare variables
        ArrayList<Template> temp = new ArrayList<Template>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            // construct the SQL statement
            final String SQL = SQL_SELECT + " WHERE " + sql;

            // prepare statement
            stmt = conn.prepareStatement(SQL);

            // bind parameters
            for (int i = 0; sqlParams != null && i < sqlParams.length; i++)
            {
                stmt.setObject(i + 1, sqlParams[i]);
            }

            rs = stmt.executeQuery();

            // fetch the results
            temp = fetchMultiResults(rs);
        }
        catch (Exception _e)
        {
            _e.printStackTrace();    
        }
        finally
        {
            pool.freeConnection(conn);
        }
        
        return temp;
    }
}
