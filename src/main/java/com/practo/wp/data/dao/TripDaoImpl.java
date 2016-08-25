package com.practo.wp.data.dao;

import com.practo.wp.data.entity.DestinationEntity;
import com.practo.wp.data.entity.TripEntity;
import com.practo.wp.model.TripFilter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
  public void createTrip(TripEntity obj) {
    template.save(obj);
  }

  @Transactional
  public void updateTrip(TripEntity obj) {
    template.update(obj);
  }

  /**
   * .
   * 
   * @return ()
   */
  @SuppressWarnings("unchecked")
  @Transactional
  public Iterable<TripEntity> findTripAndNotDeleted(Pageable pageable) {
    DetachedCriteria criteria = DetachedCriteria.forClass(TripEntity.class);
    criteria = criteria.add(Restrictions.eq("isDeleted", (byte) 0));
    System.out.println(pageable.getOffset());
    return (Iterable<TripEntity>) template.findByCriteria(criteria, pageable.getOffset(),
        pageable.getPageSize());
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
  @Transactional
  public Iterable<TripEntity> findTripOnFilter(TripFilter filter, Pageable pageable) {
    DetachedCriteria criteria = DetachedCriteria.forClass(TripEntity.class);
    criteria = criteria.add(Restrictions.eq("isDeleted", (byte) 0));
    if (filter.getSpaceLeft() != null) {
      criteria = criteria.add(Restrictions.in("spaceLeft", filter.getSpaceLeft()));
    }
    if (filter.getDestinationName() != null) {
      criteria = criteria.createAlias("destination", "dest").add(
          Restrictions.in("dest.destinationId", fetchDestinationIdByNameOrType(filter, "name")));
    }
    if (filter.getDestinationType() != null) {
      criteria = criteria.createAlias("destination", "dest").add(
          Restrictions.in("dest.destinationId", fetchDestinationIdByNameOrType(filter, "type")));
    }
    if (filter.getStartDate() != null && filter.getEndDate() != null) {
      DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      try {
        Date start = df.parse(filter.getStartDate());
        Date end = df.parse(filter.getEndDate());
        criteria = criteria.add(Restrictions.between("goingDate", start, end));
      } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    if (filter.getNumOfDays() != null) {
      criteria = criteria.add(Restrictions.in("numOfDay", filter.getNumOfDays()));
    }
    if (filter.getAverageCost() != null) {
      criteria = criteria.add(Restrictions.in("averageCost", filter.getAverageCost()));
    }
    return (Iterable<TripEntity>) template.findByCriteria(criteria);
  }

  @Transactional
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
    for (@SuppressWarnings("unused")
    DestinationEntity temp : entity) {
      size++;
    }

    Integer[] id = new Integer[size];
    int iter = 0;
    for (DestinationEntity temp : entity) {
      id[iter] = temp.getDestinationId();
      System.out.println(id[iter]);
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
