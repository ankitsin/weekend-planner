package com.practo.wp.data.dao;

import com.practo.wp.data.entity.SignedupEntity;

public interface SignedupDao {

  SignedupEntity findById(int id);

  Iterable<SignedupEntity> search(int tripId, int userId);

  void create(SignedupEntity obj);

}
