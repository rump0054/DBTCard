package data;

import java.sql.Connection;
import entities.TemplateTarget;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TemplateTargetDB
{
    /**
     * All finder methods in this class use this SELECT constant to build their
     * queries
     */
    protected final String SQL_SELECT = "SELECT templateID, categoryID, targetID, displayOrder FROM c_template_target";
    /**
     * Finder methods will pass this value to the JDBC setMaxRows method
     */
    protected int maxRows;
    /**
     * SQL INSERT statement for this table
     */
    protected final String SQL_INSERT = "INSERT INTO c_template_target ( templateID, categoryID, targetID, displayOrder ) VALUES ( ?, ?, ?, ? )";
    /**
     * SQL UPDATE statement for this table
     */
    protected final String SQL_UPDATE = "UPDATE c_template_target SET categoryID = ?, targetID = ?, displayOrder = ? WHERE templateID = ? AND categoryID = ? AND targetID = ?";
    /**
     * SQL DELETE statement for this table
     */
    protected final String SQL_DELETE = "DELETE FROM c_template_target WHERE templateID = ? AND categoryID = ? AND targetID = ?";
    /**
     * Index of column templateID
     */
    protected static final int COLUMN_TEMPLATE_I_D = 1;
    /**
     * Index of column categoryID
     */
    protected static final int COLUMN_CATEGORY_I_D = 2;
    /**
     * Index of column targetID
     */
    protected static final int COLUMN_TARGET_I_D = 3;
    /**
     * Index of column displayOrder
     */
    protected static final int COLUMN_DISPLAY_ORDER = 4;
    /**
     * Number of columns
     */
    protected static final int NUMBER_OF_COLUMNS = 4;
    /**
     * Index of primary-key column templateID
     */
    protected static final int PK_COLUMN_TEMPLATE_I_D = 1;
    /**
     * Index of primary-key column categoryID
     */
    protected static final int PK_COLUMN_CATEGORY_I_D = 2;
    /**
     * Index of primary-key column targetID
     */
    protected static final int PK_COLUMN_TARGET_I_D = 3;

    /**
     * Inserts a new row in the c_template_target table.
     */
    public TemplateTarget insert(TemplateTarget dto)
    {
        // declare variables    
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement stmt = null;

        try
        {
            stmt = conn.prepareStatement(SQL_INSERT);

            int index = 1;
            stmt.setLong(index++, dto.getTemplateID());
            stmt.setLong(index++, dto.getCategoryID());
            stmt.setLong(index++, dto.getTargetID());
            stmt.setInt(index++, dto.getDisplayOrder());

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

        return dto;
    }

    /**
     * Updates a single row in the c_template_target table.
     */
    public void update(TemplateTarget dto)
    {
        // declare variables
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement stmt = null;

        try
        {
            stmt = conn.prepareStatement(SQL_UPDATE);

            int index = 1;
            stmt.setLong(index++, dto.getCategoryID());
            stmt.setLong(index++, dto.getTargetID());
            stmt.setInt(index++, dto.getDisplayOrder());
            stmt.setLong(5, dto.getTemplateID());
            stmt.setLong(6, dto.getCategoryID());
            stmt.setLong(7, dto.getTargetID());

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
     * Deletes a single row in the c_template_target table.
     */
    public void delete(long templateID, long categoryID, long targetID)
    {
        // declare variables
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement stmt = null;

        try
        {
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setLong(1, templateID);
            stmt.setLong(2, categoryID);
            stmt.setLong(3, targetID);

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
     * Returns all rows from the c_template_target table that match the criteria
     * 'templateID = :templateID AND categoryID = :categoryID AND targetID =
     * :targetID'.
     */
    public TemplateTarget findByPrimaryKey(long templateID, long categoryID,
            long targetID)
    {
        ArrayList<TemplateTarget> ret = findByDynamicSelect(SQL_SELECT + " WHERE templateID = ? AND categoryID = ? AND targetID = ?", new Object[]
                {
                    new Long(templateID), new Long(categoryID), new Long(targetID)
                });

        return ret.isEmpty() ? null : ret.get(0);
    }

    /**
     * Returns all rows from the c_template_target table that match the criteria
     * ''.
     */
    public ArrayList<TemplateTarget> findAll()
    {
        return findByDynamicSelect(SQL_SELECT + " ORDER BY templateID, categoryID, targetID", null);
    }

    /**
     * Returns all rows from the c_template_target table that match the criteria
     * 'categoryID = :categoryID'.
     */
    public ArrayList<TemplateTarget> findByCCategory(long categoryID)
    {
        return findByDynamicSelect(SQL_SELECT + " WHERE categoryID = ?", new Object[]
                {
                    new Long(categoryID)
                });
    }

    /**
     * Returns all rows from the c_template_target table that match the criteria
     * 'templateID = :templateID'.
     */
    public ArrayList<TemplateTarget> findByCTemplate(long templateID)
    {
        return findByDynamicSelect(SQL_SELECT + " WHERE templateID = ?", new Object[]
                {
                    new Long(templateID)
                });
    }

    /**
     * Returns all rows from the c_template_target table that match the criteria
     * 'targetID = :targetID'.
     */
    public ArrayList<TemplateTarget> findByCTarget(long targetID)
    {
        return findByDynamicSelect(SQL_SELECT + " WHERE targetID = ?", new Object[]
                {
                    new Long(targetID)
                });
    }

    /**
     * Returns all rows from the c_template_target table that match the criteria
     * 'templateID = :templateID'.
     */
    public ArrayList<TemplateTarget> findWhereTemplateIDEquals(long templateID)
    {
        return findByDynamicSelect(SQL_SELECT + " WHERE templateID = ? ORDER BY templateID", new Object[]
                {
                    new Long(templateID)
                });
    }

    /**
     * Returns all rows from the c_template_target table that match the criteria
     * 'categoryID = :categoryID'.
     */
    public ArrayList<TemplateTarget> findWhereCategoryIDEquals(long categoryID)
    {
        return findByDynamicSelect(SQL_SELECT + " WHERE categoryID = ? ORDER BY categoryID", new Object[]
                {
                    new Long(categoryID)
                });
    }

    /**
     * Returns all rows from the c_template_target table that match the criteria
     * 'targetID = :targetID'.
     */
    public ArrayList<TemplateTarget> findWhereTargetIDEquals(long targetID)
    {
        return findByDynamicSelect(SQL_SELECT + " WHERE targetID = ? ORDER BY targetID", new Object[]
                {
                    new Long(targetID)
                });
    }

    /**
     * Returns all rows from the c_template_target table that match the criteria
     * 'displayOrder = :displayOrder'.
     */
    public ArrayList<TemplateTarget> findWhereDisplayOrderEquals(
            int displayOrder)
    {
        return findByDynamicSelect(SQL_SELECT + " WHERE displayOrder = ? ORDER BY displayOrder", new Object[]
                {
                    new Integer(displayOrder)
                });
    }

    /**
     * Method 'TemplateTargetDB'
     *
     */
    public TemplateTargetDB()
    {
    }

    /**
     * Fetches a single row from the result set
     */
    protected TemplateTarget fetchSingleResult(ResultSet rs) throws SQLException
    {
        if (rs.next())
        {
            TemplateTarget dto = new TemplateTarget();
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
    protected ArrayList<TemplateTarget> fetchMultiResults(ResultSet rs) throws SQLException
    {
        ArrayList<TemplateTarget> resultList = new ArrayList<TemplateTarget>();
        while (rs.next())
        {
            TemplateTarget dto = new TemplateTarget();
            populateDto(dto, rs);
            resultList.add(dto);
        }

        return resultList;
    }

    /**
     * Populates a DTO with data from a ResultSet
     */
    protected void populateDto(TemplateTarget dto, ResultSet rs) throws SQLException
    {
        dto.setTemplateID(rs.getLong(COLUMN_TEMPLATE_I_D));
        dto.setCategoryID(rs.getLong(COLUMN_CATEGORY_I_D));
        dto.setTargetID(rs.getLong(COLUMN_TARGET_I_D));
        dto.setDisplayOrder(rs.getInt(COLUMN_DISPLAY_ORDER));
    }

    /**
     * Returns all rows from the c_template_target table that match the
     * specified arbitrary SQL statement
     */
    public ArrayList<TemplateTarget> findByDynamicSelect(String sql,
            Object[] sqlParams)
    {
        // declare variables
        ArrayList<TemplateTarget> tempTarg = new ArrayList<TemplateTarget>();

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
            tempTarg = fetchMultiResults(rs);
            
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

        return tempTarg;
    }

    /**
     * Returns all rows from the c_template_target table that match the
     * specified arbitrary SQL statement
     */
    public ArrayList<TemplateTarget> findByDynamicWhere(String sql,
            Object[] sqlParams)
    {
        // declare variables
        ArrayList<TemplateTarget> temptarg = new ArrayList<TemplateTarget>();

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
            temptarg = fetchMultiResults(rs);
            
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

        return temptarg;
    }
}
