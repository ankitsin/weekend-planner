package com.practo.wp.service;

import javax.print.attribute.standard.Destination;
import javax.transaction.Transactional;

public interface DestinationService {
  
  @Transactional
  Destination get(Integer id);

}
