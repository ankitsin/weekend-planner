package com.practo.wp.data.dao;

import com.practo.wp.data.entity.DestinationEntity;
import com.practo.wp.data.entity.TripEntity;
import com.practo.wp.data.entity.UserEntity;
import com.practo.wp.model.TripFilter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Repository
public class TripDaoImpl implements TripDao {
  @Autowired
  private HibernateTemplate template;
  @Autowired
  private DestinationDao destinationDao;
  @Autowired
  private UserDao userDao;

  @Transactional
  public TripEntity findTrip(int tripId) {
    return template.load(TripEntity.class, tripId);
  }

  // @Transactional
  // public Iterable<TripEntity> getAllTrip() {
  // return template.loadAll(TripEntity.class);
  // }

  @Transactional
  public void createTrip(TripEntity obj) {
    System.out.println("#### In the create object part#######");
    template.save(obj);
  }

  @Transactional
  public void updateTrip(TripEntity obj) {
    template.update(obj);
  }

  // @Transactional
  // public void deleteTrip(int tripId) {
  // TripEntity obj = template.load(TripEntity.class, tripId);
  // template.delete(obj);
  // }

  /**
   * Find the trips which have been not deleted and going date is greater than todays date and if
   * user logged in then don't show trips posted by him.
   * 
   * @param email emailId of logged in user
   * @param pageable {@link Pageable}
   * @return {@link TripEntity}
   */
  @SuppressWarnings("unchecked")
  @Transactional
  public Iterable<TripEntity> findTripAndNotDeleted(String email, Pageable pageable) {
    DetachedCriteria criteria = DetachedCriteria.forClass(TripEntity.class);
    criteria = criteria.add(Restrictions.eq("isDeleted", (byte) 0));
    if (email != null && email != "") {
      UserEntity entity = userDao.findUserByEmail(email);
      criteria =
          criteria.createAlias("user", "u").add(Restrictions.ne("u.userId", entity.getUserId()));
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String date = dateFormat.format(new Date());
    try {
      Date today = dateFormat.parse(date);
      criteria = criteria.add(Restrictions.ge("goingDate", today)).addOrder(Order.asc("goingDate"));
    } catch (ParseException exc) {
      exc.printStackTrace();
    }
    System.out.println(pageable.getOffset());
    return (Iterable<TripEntity>) template.findByCriteria(criteria, pageable.getOffset(),
        pageable.getPageSize());

  }

  /**
   * Find trips based on the filter provided.
   * 
   * @param filter {@link TripEntity}
   * @param pageable {@link Pageable}
   * @return {@link TripEntity}
   */
  @SuppressWarnings("unchecked")
  @Transactional
  public Iterable<TripEntity> findTripOnFilter(String email, TripFilter filter, Pageable pageable) {
    DetachedCriteria criteria = DetachedCriteria.forClass(TripEntity.class);
    criteria =
        criteria.add(Restrictions.eq("isDeleted", (byte) 0)).addOrder(Order.asc("goingDate"));
    if (email != null && email != "") {
      UserEntity entity = userDao.findUserByEmail(email);
      criteria =
          criteria.createAlias("user", "u").add(Restrictions.ne("u.userId", entity.getUserId()));
    }
    if (filter.getSpaceLeft() != null && filter.getSpaceLeft().length > 0) {
      criteria = criteria.add(Restrictions.in("spaceLeft", filter.getSpaceLeft()));
    }
    if (filter.getDestinationName() != null && filter.getDestinationName().length > 0) {
      criteria = criteria.createAlias("destination", "dest").add(
          Restrictions.in("dest.destinationId", fetchDestinationIdByNameOrType(filter, "name")));
    }
    if (filter.getDestinationType() != null && filter.getDestinationType().length > 0) {
      criteria = criteria.createAlias("destination", "dest").add(
          Restrictions.in("dest.destinationId", fetchDestinationIdByNameOrType(filter, "type")));
    }
    if (filter.getStartDate() != null && filter.getEndDate() != null) {
      DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      try {
        Date start = df.parse(filter.getStartDate());
        Date end = df.parse(filter.getEndDate());
        if (start.after(end)) {
          criteria = criteria.add(Restrictions.between("goingDate", start, end));
        } else {
          criteria = criteria.add(Restrictions.between("goingDate", end, start));
        }

      } catch (ParseException exc) {
        exc.printStackTrace();
      }

    }
    if (filter.getNumOfDays() != null && filter.getNumOfDays().length > 0) {
      criteria = criteria.add(Restrictions.in("numOfDay", filter.getNumOfDays()));
    }
    if (filter.getAverageCost() != null && filter.getAverageCost() != 0) {
      criteria = criteria.add(Restrictions.between("averageCost", 0, filter.getAverageCost()));
    }
    return (Iterable<TripEntity>) template.findByCriteria(criteria);
  }

  @SuppressWarnings("unused")
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
    for (DestinationEntity temp : entity) {
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
}
