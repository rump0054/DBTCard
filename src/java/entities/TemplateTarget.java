package entities;

public class TemplateTarget
{
    /**
     * This attribute maps to the column templateID in the c_template_target
     * table.
     */
    protected long templateID;
    /**
     * This attribute maps to the column categoryID in the c_template_target
     * table.
     */
    protected long categoryID;
    /**
     * This attribute maps to the column targetID in the c_template_target
     * table.
     */
    protected long targetID;
    /**
     * This attribute maps to the column displayOrder in the c_template_target
     * table.
     */
    protected int displayOrder;

    /**
     * Method 'TemplateTarget'
     *
     */
    public TemplateTarget()
    {
    }

    /**
     * Method 'getTemplateID'
     *
     * @return long
     */
    public long getTemplateID()
    {
        return templateID;
    }

    /**
     * Method 'setTemplateID'
     *
     * @param templateID
     */
    public void setTemplateID(long templateID)
    {
        this.templateID = templateID;
    }

    /**
     * Method 'getCategoryID'
     *
     * @return long
     */
    public long getCategoryID()
    {
        return categoryID;
    }

    /**
     * Method 'setCategoryID'
     *
     * @param categoryID
     */
    public void setCategoryID(long categoryID)
    {
        this.categoryID = categoryID;
    }

    /**
     * Method 'getTargetID'
     *
     * @return long
     */
    public long getTargetID()
    {
        return targetID;
    }

    /**
     * Method 'setTargetID'
     *
     * @param targetID
     */
    public void setTargetID(long targetID)
    {
        this.targetID = targetID;
    }

    /**
     * Method 'getDisplayOrder'
     *
     * @return int
     */
    public int getDisplayOrder()
    {
        return displayOrder;
    }

    /**
     * Method 'setDisplayOrder'
     *
     * @param displayOrder
     */
    public void setDisplayOrder(int displayOrder)
    {
        this.displayOrder = displayOrder;
    }

    /**
     * Method 'equals'
     *
     * @param _other
     * @return boolean
     */
    public boolean equals(Object _other)
    {
        if (_other == null)
        {
            return false;
        }

        if (_other == this)
        {
            return true;
        }

        if (!(_other instanceof TemplateTarget))
        {
            return false;
        }

        final TemplateTarget _cast = (TemplateTarget) _other;
        if (templateID != _cast.templateID)
        {
            return false;
        }

        if (categoryID != _cast.categoryID)
        {
            return false;
        }

        if (targetID != _cast.targetID)
        {
            return false;
        }

        if (displayOrder != _cast.displayOrder)
        {
            return false;
        }

        return true;
    }

    /**
     * Method 'toString'
     *
     * @return String
     */
    public String toString()
    {
        StringBuffer ret = new StringBuffer();
        ret.append("dbtcard.dto.CTemplateTarget: ");
        ret.append("templateID=" + templateID);
        ret.append(", categoryID=" + categoryID);
        ret.append(", targetID=" + targetID);
        ret.append(", displayOrder=" + displayOrder);
        return ret.toString();
    }
}
