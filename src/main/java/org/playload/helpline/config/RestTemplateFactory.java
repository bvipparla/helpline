package org.playload.helpline.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Configuration public class RestTemplateFactory {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Autowired private ObjectMapper objectMapper;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Bean public RestTemplate createRestTemplate() {
    RestTemplate                        restTemplate  = new RestTemplate();
    List<HttpMessageConverter<?>>       converters    = new ArrayList<>();
    MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
    jsonConverter.setObjectMapper(objectMapper);
    converters.add(jsonConverter);
    restTemplate.setMessageConverters(converters);

    return restTemplate;
  }
}
