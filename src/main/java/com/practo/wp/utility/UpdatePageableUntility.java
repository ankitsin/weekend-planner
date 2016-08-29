package com.practo.wp.utility;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * funtion for setting the page size to 10.
 * 
 * @author ankit
 *
 */
public class UpdatePageableUntility {

  public static Pageable updatePageable(final Pageable source, final int size) {
    return new PageRequest(source.getPageNumber(), size, source.getSort());
  }
}
