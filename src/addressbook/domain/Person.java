package addressbook.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table
public class Person implements Comparable<Person>{
    
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="firstname")
    private String firstName;
    
    @Column(name="lastname")
    private String lastName;
    
    @OneToMany(mappedBy="person", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;
    @Transient
    private List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
    
    @Override
    public String toString() {
        
        return "\n  Person{firstName:'" + firstName + "',lastName:'" + lastName + "'" +
               (!Objects.isNull(addresses) ? addresses.toString() : "no address") +
               (!Objects.isNull(phoneNumbers) ? phoneNumbers.toString() : "no phone numbers");
    }
    
    @Override
    public int hashCode() {
        return (lastName + firstName).hashCode();
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        
        Person that = (Person)o;
        
        if (!firstName.equals(that.firstName)) return false;
        if (!lastName.equals(that.lastName)) return false;
        return addresses.equals(that.addresses);
    }
    
    @Override
    public int compareTo(Person that){
        return this.lastName.compareTo(that.lastName);
    }
    
    public void addAddress(Address inAddress){
        addresses.add(inAddress);
        inAddress.setPerson(this);
    }

    public void removeAddress(Address inAddress){
        inAddress.setPerson(null);
        addresses.remove(inAddress);
    }
    
    public void addPhone(PhoneNumber number){
        phoneNumbers.add(number);
    }
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public List<Address> getAddresses() {
        return addresses;
    }
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
