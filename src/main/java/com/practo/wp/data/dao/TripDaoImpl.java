package com.practo.wp.data.dao;

import com.practo.wp.data.entity.DestinationEntity;
import com.practo.wp.data.entity.TripEntity;
import com.practo.wp.model.TripFilter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public class TripDaoImpl implements TripDao {
  @Autowired
  private HibernateTemplate template;
  @Autowired
  private DestinationDao destinationDao;

  @Transactional
  public TripEntity findTrip(int tripId) {
    return template.load(TripEntity.class, tripId);
  }

  @Transactional
  public Iterable<TripEntity> getAllTrip() {
    return template.loadAll(TripEntity.class);
  }

  @Transactional
  public TripEntity createTrip(TripEntity obj) {
    return (TripEntity) template.save(obj);
  }

  @Transactional
  public TripEntity updateTrip(TripEntity obj) {
    template.update(obj);
    return obj;
  }

  /**
   * .
   * 
   * @return ()
   */
  @SuppressWarnings("unchecked")
  @Transactional
  public Iterable<TripEntity> findTripAndNotDeleted() {
    DetachedCriteria criteria = DetachedCriteria.forClass(TripEntity.class);
    criteria = criteria.add(Restrictions.eq("isDeleted", (byte) 0));
    return (Iterable<TripEntity>) template.findByCriteria(criteria);
    // return null;

  }

  /**
   * .
   * 
   * @param filter ()
   * @param pageable ()
   * @return ()
   */
  @SuppressWarnings("unchecked")
  public Iterable<TripEntity> findTripOnFilter(TripFilter filter, Pageable pageable) {
    DetachedCriteria criteria = DetachedCriteria.forClass(TripEntity.class);
    criteria = criteria.add(Restrictions.eq("isDeleted", (byte) 0));
    if (filter.getSpaceLeft() != null) {
      criteria = criteria.add(Restrictions.in("spaceLeft", filter.getSpaceLeft()));
    }
    if (filter.getDestinationName() != null) {
      criteria = criteria.add(Restrictions.in("destination.destinationId",
          fetchDestinationIdByNameOrType(filter, "name")));
    }
    if (filter.getDestinationType() != null) {
      criteria = criteria.add(Restrictions.in("destination.destinationId",
          fetchDestinationIdByNameOrType(filter, "type")));
    }
    // if (numOfDays != null) {
    // System.out.println(numOfDays);
    // predicate = predicate.and(b1.numOfDay.in(numOfDays));
    // }
    // if (averageCost != null) {
    // System.out.println(averageCost[0] + " " + averageCost[1]);
    // predicate = predicate.and(b1.averageCost.between(averageCost[0], averageCost[1]));
    // }
    if (filter.getNumOfDays() != null) {
      criteria = criteria.add(Restrictions.in("numOfDay", filter.getNumOfDays()));
    }
    if (filter.getAverageCost() != null) {
      criteria = criteria.add(Restrictions.in("averageCost", filter.getAverageCost()));
    }
    return (Iterable<TripEntity>) template.findByCriteria(criteria);
  }

  private Integer[] fetchDestinationIdByNameOrType(TripFilter filter, String flag) {
    Iterable<DestinationEntity> entity = null;
    if (flag == "name") {
      String[] name = filter.getDestinationName();
      entity = destinationDao.fetchIdByName(name);
    } else if (flag == "type") {
      String[] type = filter.getDestinationType();
      entity = destinationDao.fetchIdByType(type);
    }
    int size = 0;
    for (@SuppressWarnings("unused") DestinationEntity temp : entity) {
      size++;
    }

    Integer[] id = new Integer[size];
    int iter = 0;
    for (DestinationEntity temp : entity) {
      id[iter] = temp.getDestinationId();
      iter++;
    }
    return id;
  }
  //
  // @Transactional
  // Iterable<TripEntity> findByGoingPeopleAndSpaceLeft(int goingdate, int space);
  //
  // @Transactional
  // Iterable<TripEntity> findByUserUserIdAndIsDeleted(int id, byte isDel);
  //
  // @Transactional
  // Iterable<TripEntity> findByTripName(String name);
}
