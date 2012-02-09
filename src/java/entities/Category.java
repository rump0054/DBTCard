package entities;

public class Category {

    /**
     * This attribute maps to the column categoryID in the c_category table.
     */
    protected long categoryID;
    /**
     * This attribute maps to the column category in the c_category table.
     */
    protected String category;

    /**
     * Method 'Category'
     *
     */
    public Category() {
    }

    /**
     * Method 'getCategoryID'
     *
     * @return long
     */
    public long getCategoryID() {
        return categoryID;
    }

    /**
     * Method 'setCategoryID'
     *
     * @param categoryID
     */
    public void setCategoryID(long categoryID) {
        this.categoryID = categoryID;
    }

    /**
     * Method 'getCategory'
     *
     * @return String
     */
    public String getCategory() {
        return category;
    }

    /**
     * Method 'setCategory'
     *
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Method 'equals'
     *
     * @param _other
     * @return boolean
     */
    public boolean equals(Object _other) {
        if (_other == null) {
            return false;
        }

        if (_other == this) {
            return true;
        }

        if (!(_other instanceof Category)) {
            return false;
        }

        final Category _cast = (Category) _other;
        if (categoryID != _cast.categoryID) {
            return false;
        }

        if (category == null ? _cast.category != category : !category.equals(_cast.category)) {
            return false;
        }

        return true;
    }

    /**
     * Method 'toString'
     *
     * @return String
     */
    public String toString() {
        StringBuffer ret = new StringBuffer();
        ret.append("dbtcard.dto.CCategory: ");
        ret.append("categoryID=" + categoryID);
        ret.append(", category=" + category);
        return ret.toString();
    }
}
