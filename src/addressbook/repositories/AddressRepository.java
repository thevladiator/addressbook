package addressbook.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import addressbook.domain.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer>{
    void delete(Address deleted);
    
    List<Address> findAll();
 
    Address findOne(Integer id);
 
    Address save(Address persisted);

}
