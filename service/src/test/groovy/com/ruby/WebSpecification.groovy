package groovy.com.ruby

import com.google.gson.Gson
import com.ruby.Application
import com.ruby.controller.KafkaController
import com.ruby.service.Producer
import com.ruby.util.config.KafkaConfiguration
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.BootstrapWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.http.HttpStatus.*
import spock.lang.Specification

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ActiveProfiles("local")
//@WebAppConfiguration
//@ContextConfiguration(classes = KafkaConfiguration.class)
//@WebMvcTest(KafkaController.class)
//@AutoConfigureMockMvc
class WebSpecification extends Specification {

//  @Autowired
//  def producer = Mock(Producer)
//
//  @Autowired
//  def kafkaController = new KafkaController(producer)
//
//  @Autowired
//  MockMvc mvc = standaloneSetup(kafkaController).build()
//
//  @Autowired
//  Gson gson = new Gson()
//
//  def setup() {
//
//  }
//
//  def "sendMessage recieves POST request"() {
//    given:
//      def object = gson.toJson("{\"url\": \"urlTest\", \"button\": \"buttonTest\"")
//
//    when:
//      def results = mvc.perform(post('/api/kafka/publish').contentType(MediaType.APPLICATION_JSON).content(object)).andReturn().response
//
//    then:
//      results.status.equals(OK.value())
//
//  }


//  @Autowired
//  User user
//  def "when post is performed the url and buttons are set"() {
//    given:
//      Map request = [
//        url     : 'https://www.spockUrlTest.com',
//        button  : 'spockButtonTest'
//      ]
//
//    and:
//      new User('https://www.spockUrlTest.com', 'spockButtonTest') >> producer.sendMessage('https://www.spockUrlTest.com', 'spockButtonTest')
//
//    when:
//      def results = mvc.perform(post('/api/kafka/publish').contentType(APPLICATION_JSON).content(toJson(request)))
//
//    then:
//      results.andExpect(jsonPath('$.url').value('https://www.spockUrlTest.com'))
//      results.andExpect(jsonPath('$.button').value('spockButtonTest'))
//  }

}
