package com.practo.wp.data.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.practo.wp.data.entity.DestinationEntity;

public interface DestinationDao extends CrudRepository<DestinationEntity,Integer>{

}
