<<<<<<< HEAD
package com.maybanktask.user_management.service;

import com.maybanktask.user_management.dao.Booksource;
import com.maybanktask.user_management.dao.CustomerDetailsEntity;
import com.maybanktask.user_management.dto.BooksourceDto;
import com.maybanktask.user_management.dto.CustomerDetails;
import com.maybanktask.user_management.repository.DataSourceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(propagation=Propagation.REQUIRED, rollbackFor = Exception.class)
public class DataSourceServiceImpl implements DataSourceService {

    private static final Logger logger= LoggerFactory.getLogger(DataSourceServiceImpl.class);
    @Autowired
    DataSourceRepository dataSourceRepository;

    @Override
    public void save(BooksourceDto booksourceDto) {
        Booksource getMappedSource=mapToDataSource("1", booksourceDto);
        dataSourceRepository.save(getMappedSource);
    }

    @Override
    @Transactional(propagation=Propagation.NEVER)
    public Page<Booksource> getAllData(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return dataSourceRepository.findAll(pageable);
    }



    @Override
    @Transactional(propagation=Propagation.NEVER)
    public Page<Booksource> getById(int pageNo, int pageSize, String customerId) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return dataSourceRepository.getByCustomerId(customerId,pageable);
    }


    @Override
    public void deleteData(String id) {
        dataSourceRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public void updateById(String id, BooksourceDto booksourceDto) {
        Optional<Booksource> sourceOpt=dataSourceRepository.findById(Long.valueOf(id));
        if(sourceOpt.isPresent()){
            Booksource source=sourceOpt.get();
            source.setDescription(booksourceDto.getDescription());
            source.setTrxAmmount(booksourceDto.getTrxAmmount());
            source.setTrxDate(booksourceDto.getTrxDate());
            source.setCustomerDetailsEntity(new CustomerDetailsEntity(source.getCustomerDetailsEntity().getId(),booksourceDto.getCustomerDetails().getName(),booksourceDto.getCustomerDetails().getTitle(),booksourceDto.getCustomerDetails().getAge()));
        }
    }

    private Booksource mapToDataSource(String id, BooksourceDto booksourceDto) {

        CustomerDetailsEntity entityCustomerDetails = mapToCustomerDetails(booksourceDto.getCustomerDetails());
        return new Booksource(booksourceDto.getAccountNumber(), booksourceDto.getTrxAmmount(), booksourceDto.getDescription(), booksourceDto.getTrxDate(), booksourceDto.getTime(),id, entityCustomerDetails);
    }

    private CustomerDetailsEntity mapToCustomerDetails(CustomerDetails customerDetails) {
        CustomerDetailsEntity entity=new CustomerDetailsEntity();
        entity.setAge(customerDetails.getAge());
        entity.setName(customerDetails.getName());
        entity.setTitle(customerDetails.getTitle());
        return entity;
    }

}
=======
package com.maybanktask.user_management.service;

import com.maybanktask.user_management.dao.Booksource;
import com.maybanktask.user_management.dao.CustomerDetailsEntity;
import com.maybanktask.user_management.dto.BooksourceDto;
import com.maybanktask.user_management.dto.CustomerDetails;
import com.maybanktask.user_management.repository.DataSourceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(propagation=Propagation.REQUIRED, rollbackFor = Exception.class)
public class DataSourceServiceImpl implements DataSourceService {

    private static final Logger logger= LoggerFactory.getLogger(DataSourceServiceImpl.class);
    @Autowired
    DataSourceRepository dataSourceRepository;

    @Override
    public void save(BooksourceDto booksourceDto) {
        Booksource getMappedSource=mapToDataSource("1", booksourceDto);
        dataSourceRepository.save(getMappedSource);
    }

    @Override
    @Transactional(propagation=Propagation.NEVER)
    public Page<Booksource> getAllData(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return dataSourceRepository.findAll(pageable);
    }



    @Override
    @Transactional(propagation=Propagation.NEVER)
    public Page<Booksource> getById(int pageNo, int pageSize, String customerId) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return dataSourceRepository.getByCustomerId(customerId,pageable);
    }


    @Override
    public void deleteData(String id) {
        dataSourceRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public void updateById(String id, BooksourceDto booksourceDto) {
        Optional<Booksource> sourceOpt=dataSourceRepository.findById(Long.valueOf(id));
        if(sourceOpt.isPresent()){
            Booksource source=sourceOpt.get();
            source.setDescription(booksourceDto.getDescription());
            source.setTrxAmmount(booksourceDto.getTrxAmmount());
            source.setTrxDate(booksourceDto.getTrxDate());
            source.setCustomerDetailsEntity(new CustomerDetailsEntity(source.getCustomerDetailsEntity().getId(),booksourceDto.getCustomerDetails().getName(),booksourceDto.getCustomerDetails().getTitle(),booksourceDto.getCustomerDetails().getAge()));
        }
    }

    private Booksource mapToDataSource(String id, BooksourceDto booksourceDto) {

        CustomerDetailsEntity entityCustomerDetails = mapToCustomerDetails(booksourceDto.getCustomerDetails());
        return new Booksource(booksourceDto.getAccountNumber(), booksourceDto.getTrxAmmount(), booksourceDto.getDescription(), booksourceDto.getTrxDate(), booksourceDto.getTime(),id, entityCustomerDetails);
    }

    private CustomerDetailsEntity mapToCustomerDetails(CustomerDetails customerDetails) {
        CustomerDetailsEntity entity=new CustomerDetailsEntity();
        entity.setAge(customerDetails.getAge());
        entity.setName(customerDetails.getName());
        entity.setTitle(customerDetails.getTitle());
        return entity;
    }

}
>>>>>>> origin/main
