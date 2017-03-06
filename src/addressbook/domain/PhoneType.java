package addressbook.domain;

public enum PhoneType {
    CELL("Cell", "Mobile"),
    FIXED("Fixed", "Home");
    
    public String type;
    public String displayString;
    
    PhoneType(String inType, String inDisplay){
        type = inType;
        displayString = inDisplay;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
