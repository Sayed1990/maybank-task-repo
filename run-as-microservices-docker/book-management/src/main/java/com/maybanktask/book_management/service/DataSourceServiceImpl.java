package com.maybanktask.book_management.service;

import com.maybanktask.book_management.DAO.Booksource;
import com.maybanktask.book_management.DAO.CustomerDetailsEntity;
import com.maybanktask.book_management.dto.BooksourceDto;
import com.maybanktask.book_management.dto.CustomerDetails;
import com.maybanktask.book_management.exception.DataSourceException;
import com.maybanktask.book_management.repository.DataSourceRepository;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class DataSourceServiceImpl implements DataSourceService {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceServiceImpl.class);
    @Autowired
    DataSourceRepository dataSourceRepository;

    @Override
    public void save(BooksourceDto booksourceDto) {
        Booksource getMappedSource = mapToDataSource("1", booksourceDto);
        dataSourceRepository.save(getMappedSource);
    }

    @Override
    @Transactional(propagation = Propagation.NEVER)
    public Page<Booksource> getAllData(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return dataSourceRepository.findAll(pageable);
    }


    @Override
    @Transactional(propagation = Propagation.NEVER)
    public Page<Booksource> getById(int pageNo, int pageSize, String customerId) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return dataSourceRepository.getByCustomerId(customerId, pageable);
    }


    @Override
    public void deleteData(String id) {
        dataSourceRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public void updateById(String id, BooksourceDto booksourceDto) throws DataSourceException {
        Optional<Booksource> sourceOpt = dataSourceRepository.findById(Long.valueOf(id));
        if (sourceOpt.isPresent()) {
            Booksource source = sourceOpt.get();
            source.setDescription(booksourceDto.getDescription());
            source.setTrxAmmount(booksourceDto.getTrxAmmount());
            source.setTrxDate(booksourceDto.getTrxDate());
            source.setCustomerDetailsEntity(new CustomerDetailsEntity(source.getCustomerDetailsEntity().getId(), booksourceDto.getCustomerDetails().getName(), booksourceDto.getCustomerDetails().getTitle(), booksourceDto.getCustomerDetails().getAge()));
            try {
                dataSourceRepository.save(source);
            } catch (DataAccessException dae) {
                logger.error("Error occured during accessing database due to:{}", ExceptionUtils.getStackTrace(dae));
            }

        }else{
            logger.error("The data you are trying to access is not found for id:{}",id);
            throw new DataSourceException("The data you are trying to access is not found");
        }

    }
    private Booksource mapToDataSource(String id, BooksourceDto booksourceDto) {

        CustomerDetailsEntity entityCustomerDetails = mapToCustomerDetails(booksourceDto.getCustomerDetails());
        return new Booksource(booksourceDto.getAccountNumber(), booksourceDto.getTrxAmmount(), booksourceDto.getDescription(), booksourceDto.getTrxDate(), booksourceDto.getTime(), id, entityCustomerDetails);
    }

    private CustomerDetailsEntity mapToCustomerDetails(CustomerDetails customerDetails) {
        CustomerDetailsEntity entity = new CustomerDetailsEntity();
        entity.setAge(customerDetails.getAge());
        entity.setName(customerDetails.getName());
        entity.setTitle(customerDetails.getTitle());
        return entity;
    }
}
