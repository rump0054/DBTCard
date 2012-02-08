package data;

import java.sql.Connection;
import entities.Category;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDB
{
    /**
     * All finder methods in this class use this SELECT constant to build their
     * queries
     */
    protected final String SQL_SELECT = "SELECT categoryID, category FROM c_category";
    /**
     * SQL INSERT statement for this table
     */
    protected final String SQL_INSERT = "INSERT INTO c_category ( category ) VALUES ( ? )";
    /**
     * SQL UPDATE statement for this table
     */
    protected final String SQL_UPDATE = "UPDATE c_category SET category = ? WHERE categoryID = ?";
    /**
     * SQL DELETE statement for this table
     */
    protected final String SQL_DELETE = "DELETE FROM c_category WHERE categoryID = ?";
    /**
     * Index of column categoryID
     */
    protected static final int COLUMN_CATEGORY_I_D = 1;
    /**
     * Index of column category
     */
    protected static final int COLUMN_CATEGORY = 2;
    /**
     * Number of columns
     */
    protected static final int NUMBER_OF_COLUMNS = 2;
    /**
     * Index of primary-key column categoryID
     */
    protected static final int PK_COLUMN_CATEGORY_I_D = 1;

    /**
     * Inserts a new row in the c_category table.
     */
    public Category insert(Category dto)
    {
        // declare variables
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            stmt = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, dto.getCategory());

            int rows = stmt.executeUpdate();

            // retrieve values from auto-increment columns
            rs = stmt.getGeneratedKeys();
            if (rs != null && rs.next())
            {
                dto.setCategoryID(rs.getLong(1));
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
     * Updates a single row in the c_category table.
     */
    public void update(Category dto)
    {

        // declare variables

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement stmt = null;

        try
        {
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;

            stmt.setString(index++, dto.getCategory());
            stmt.setLong(index++, dto.getCategoryID());

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
     * Deletes a single row in the c_category table.
     */
    public void delete(long id)
    {
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
     * Returns all rows from the c_category table that match the criteria
     * 'categoryID = :categoryID'.
     */
    public Category findByPrimaryKey(long categoryID)
    {
        ArrayList<Category> ret = findByDynamicSelect(SQL_SELECT + " WHERE categoryID = ?", new Object[]
                {
                    new Long(categoryID)
                });

        return ret.isEmpty() ? null : ret.get(0);
    }

    /**
     * Returns all rows from the c_category table that match the criteria ''.
     */
    public ArrayList<Category> findAll()
    {
        return findByDynamicSelect(SQL_SELECT + " ORDER BY category", null);
    }

    /**
     * Returns all rows from the c_category table that match the criteria
     * 'categoryID = :categoryID'.
     */
    public ArrayList<Category> findWhereCategoryIDEquals(long categoryID)
    {
        return findByDynamicSelect(SQL_SELECT + " WHERE categoryID = ? ORDER BY categoryID", new Object[]
                {
                    new Long(categoryID)
                });
    }

    /**
     * Returns all rows from the c_category table that match the criteria
     * 'category = :category'.
     */
    public ArrayList<Category> findWhereCategoryEquals(String category)
    {
        return findByDynamicSelect(SQL_SELECT + " WHERE category = ? ORDER BY category", new Object[]
                {
                    category
                });
    }

    /**
     * Method 'CategoryDB'
     *
     */
    public CategoryDB()
    {
    }

    /**
     * Fetches a single row from the result set
     */
    protected Category fetchSingleResult(ResultSet rs) throws SQLException
    {
        if (rs.next())
        {
            Category dto = new Category();
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
    protected ArrayList<Category> fetchMultiResults(ResultSet rs) throws SQLException
    {
        ArrayList<Category> resultList = new ArrayList<Category>();
        while (rs.next())
        {
            Category dto = new Category();
            populateDto(dto, rs);
            resultList.add(dto);
        }

        return resultList;
    }

    /**
     * Populates a DTO with data from a ResultSet
     */
    protected void populateDto(Category dto, ResultSet rs) throws SQLException
    {
        dto.setCategoryID(rs.getLong(COLUMN_CATEGORY_I_D));
        dto.setCategory(rs.getString(COLUMN_CATEGORY));
    }

    /**
     * Returns all rows from the c_category table that match the specified
     * arbitrary SQL statement
     */
    public ArrayList<Category> findByDynamicSelect(String sql,
            Object[] sqlParams)
    {
        // declare variables
        ArrayList<Category> categories = new ArrayList<Category>();
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
            categories = fetchMultiResults(rs);
            
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

        return categories;
    }

    /**
     * Returns all rows from the c_category table that match the specified
     * arbitrary SQL statement
     */
    public ArrayList<Category> findByDynamicWhere(String sql, Object[] sqlParams)
    {
        // declare variables
        ArrayList<Category> categories = new ArrayList<Category>();

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
            categories = fetchMultiResults(rs);
            
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

        return categories;
    }
}
