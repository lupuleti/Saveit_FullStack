package com.studenthackv;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScan
public class ProjectApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProjectApplication.class, args);
  }

  @Bean
  public ObjectMapper jacksonObjectMapper()
  {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setPropertyNamingStrategy(propertyNamingStrategy());
    //objectMapper.configure(
        //DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    return objectMapper;
  }

  @Bean
  public PropertyNamingStrategy propertyNamingStrategy()
  {
    return new UpperCaseUnderscoreStrategy();
  }

  @Bean
  public RestTemplate restTemplate() {
    RestTemplate restTemplate = new RestTemplate();
    List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
    MappingJackson2HttpMessageConverter jsonMessageConverter =
        new MappingJackson2HttpMessageConverter();
    jsonMessageConverter.setObjectMapper(jacksonObjectMapper());
    messageConverters.add(jsonMessageConverter);
    restTemplate.setMessageConverters(messageConverters);

    return restTemplate;

  }

  public static class UpperCaseUnderscoreStrategy extends PropertyNamingStrategy.PropertyNamingStrategyBase {
    /**
     * Converts camelCase to under_score and
     * visa versa.  The idea is that this
     * name strategy can be used for both
     * marshalling and unmarshaling.
     *
     * For example, "userName" would be converted to
     * "user_name" and conversely "user_name" would
     * be converted to "userName".
     *
     * @param input formatted as camelCase or under_score string
     * @return input converted to opposite format
     */
    @Override
    public String translate(String input) {
      if (input == null || input.length() == 0) {
        return input; // garbage in, garbage out
      }

      //
      // we always take the first character;
      // this preserves initial underscore
      //
      StringBuilder sb = new StringBuilder();

      final int length = input.length();
      int i = 0;

      //
      // skip initial underscores
      //
      while ((i < length) && ('_' == input.charAt(i))) {
        sb.append(input.charAt(i));
        i += 1;
      }

      while (i < length) {
        //
        // find underscores, remove and capitalize next letter
        //
        while ((i < length) && ('_' != input.charAt(i)) &&
               !Character.isUpperCase(input.charAt(i))) {
          sb.append(input.charAt(i));
          i += 1;
        }

        if (i < length) {
          if ('_' == input.charAt(i)) {
            // underscore to uppercase

            //
            // skip underscores
            //
            while ((i < length) && ('_' == input.charAt(i))) {
              // skip underscores
              i += 1;
            }

            //
            // capitalize
            //
            if (i < length) {
              sb.append(Character.toUpperCase(input.charAt(i)));
              i += 1;
            }
          } else // uppercase to unscore + lowercase
          {
            sb.append('_');
            sb.append(Character.toLowerCase(input.charAt(i)));
            i += 1;
          }
        }
      }
      return sb.toString();
    }
  }
}
