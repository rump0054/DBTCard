package entities;

public class Target{

    /**
     * This attribute maps to the column targetID in the c_target table.
     */
    protected long targetID;
    /**
     * This attribute maps to the column rangeMax in the c_target table.
     */
    protected String rangeMax;
    /**
     * This attribute maps to the column categoryID in the c_target table.
     */
    protected long categoryID;
    /**
     * This attribute maps to the column target in the c_target table.
     */
    protected String target;
    /**
     * This attribute maps to the column description in the c_target table.
     */
    protected String description;
    
    protected String username;

    /**
     * Method 'Target'
     *
     */
    public Target() {
    }

    /**
     * Method 'getTargetID'
     *
     * @return long
     */
    public long getTargetID() {
        return targetID;
    }

    /**
     * Method 'setTargetID'
     *
     * @param targetID
     */
    public void setTargetID(long targetID) {
        this.targetID = targetID;
    }

    /**
     * Method 'getRangeMax'
     *
     * @return String
     */
    public String getRangeMax() {
        return rangeMax;
    }

    /**
     * Method 'setRangeMax'
     *
     * @param rangeMax
     */
    public void setRangeMax(String rangeMax) {
        this.rangeMax = rangeMax;
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
     * Method 'getTarget'
     *
     * @return String
     */
    public String getTarget() {
        return target;
    }

    /**
     * Method 'setTarget'
     *
     * @param target
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * Method 'getDescription'
     *
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method 'setDescription'
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
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

        if (!(_other instanceof Target)) {
            return false;
        }

        final Target _cast = (Target) _other;
        if (targetID != _cast.targetID) {
            return false;
        }

        if (rangeMax == null ? _cast.rangeMax != rangeMax : !rangeMax.equals(_cast.rangeMax)) {
            return false;
        }

        if (categoryID != _cast.categoryID) {
            return false;
        }

        if (target == null ? _cast.target != target : !target.equals(_cast.target)) {
            return false;
        }

        if (description == null ? _cast.description != description : !description.equals(_cast.description)) {
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
        ret.append("dbtcard.dto.CTarget: ");
        ret.append("targetID=" + targetID);
        ret.append(", rangeMax=" + rangeMax);
        ret.append(", categoryID=" + categoryID);
        ret.append(", target=" + target);
        ret.append(", description=" + description);
        ret.append(", username=" + username);
        return ret.toString();
    }
}
