package addressbook.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Phone {

    @Id
    @GeneratedValue
    private Integer id;

    private String number;
    private PhoneType type;
    
    @Override
    public boolean equals(Object o){
        if (o == null)
            return false;
        else {
            Phone that = (Phone) o;
            if (!Objects.equals(number, that.number))
                return false;
        }
        
        return true;
    }
    
    @Override
    public String toString() {
        return "\n\tPhone{number:'" + number + "',type:'" + type.name() + "'}";
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
