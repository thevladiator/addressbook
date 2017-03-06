package addressbook.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Address implements Cloneable, Comparable<Address>{
    
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column
    private String streetAddress;
    @Column
    private String city;
    @Column
    private String county;
    @Column
    private String country;
    
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "personId")
    private Person person;
    
    @Override
    public String toString() {
        
        return "\n\tAddress{street:'" + streetAddress + "',city:'" + city + "'}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        
        Address that = (Address)o;
        
        if (!Objects.equals(this.streetAddress, that.streetAddress)) return false;
        if (!Objects.equals(this.city, that.city)) return false;
        if (!Objects.equals(this.county, that.county)) return false;
        return Objects.equals(this.country, that.country);
    }
    @Override
    public Address clone() {
        Address addressClone = new Address();
        
        addressClone.streetAddress = streetAddress;
        addressClone.city = city;
        addressClone.county = county;
        addressClone.country = country;
        
        return addressClone;
    }
    
    @Override
    public int compareTo(Address that){
        return this.city.compareTo(that.city);
    }
    
    public String getStreetAddress() {
        return streetAddress;
    }
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCounty() {
        return county;
    }
    public void setCounty(String county) {
        this.county = county;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
