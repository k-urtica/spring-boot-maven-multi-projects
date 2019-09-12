package web.com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import web.com.example.entity.Bank;

@Repository
public interface BankRepository extends CrudRepository<Bank, String> {

}
