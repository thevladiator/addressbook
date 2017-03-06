package addressbook.domain;

import java.util.Objects;

public class PhoneNumber {
    private String number;
    private PhoneType type;
    
    @Override
    public boolean equals(Object o){
        PhoneNumber that = (PhoneNumber)o;
        
        if (!Objects.equals(this.number, that.number)) return false;
        return Objects.equals(this.type, that.type);
    }
    
    @Override
    public String toString() {
        return "\n\tPhoneNumber{number:'" + number + "',type:'" + type.name() + "'}";
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }
}
