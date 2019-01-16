package groovy.com.ruby

import com.ruby.Application
import com.ruby.controller.KafkaController
import com.ruby.model.User
import com.ruby.service.Producer
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Specification

import javax.validation.constraints.Null

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes={Application.class})
//@WebMvcTest(controllers = [KafkaController])
class UnitSpecification extends Specification {

  @Autowired
  KafkaTemplate kafkaTemplate = Mock(KafkaTemplate)

  @Autowired
  Producer producer = new Producer(kafkaTemplate: kafkaTemplate)

  def "creating new User object to send to consumer"() {
    given:
      def url = "testUrl"
      def button = "testButton"

    when:
      def newUser = new User(url, button)

    then:
      newUser.url.equals("testUrl")
      newUser.button.equals("testButton")
  }

  def "invalid input for User object"() {
    given:
      def url = null
      def button = null

    when:
      new User(url, button)

    then:
      thrown(NullPointerException)
  }

  def "producer user object and sends to consumer"() {
    given:
      def url = "urlTest"
      def button = "buttonTest"

    when:
      producer.sendMessage(url, button)

    then:
      1 * kafkaTemplate.send('users', new User(url, button))
  }

//  @Autowired
//  private MockMvc mvc
//
//  def "when post is performed then the response has status 200 and content is 'Hello world!'"() {
//
////    given:
////      String jsonString ="{\"url\":\"www.urlTest.com\", \"button\":\"buttonTest\"}"
//
//    given:
//      String jsonString="{\"country\": \"India\", \"currency\": \"INR\", \"president\": \"Ram Nath Kovind\" } "
//
//    when:
//      def result = mvc.perform(MockMvcRequestBuilders.post("/test").content(jsonString).header("code","12400f74dc4d8d69b713b1fe53f371c25a28a8c5fac2a91eea1f742ab4567c9c"))
//
//    then:
//      result.andExpect(status().isOk())
//      result.andReturn()
//      result.response
//      result.contentAsString == "Hello world!"
//  }


//  when:
//      def result = mvc.perform(MockMvcRequestBuilders.post("/api/kafka/publish").content(jsonString).header("Authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJ1aWQiOjEyMzQsInJvbGVzIjoiYWRtaW4td3JpdGUtYWxsLGFkbWluLXJlYWQtYWxsIiwicGxhdGZvcm1zIjoiYW0ifQ.p1_TzIeTiKsE21GCBwIoiIV9twFUj5jPQiBPGcTuWI1V57OQrTlZN-nO2JMnG1aBbPzq8sfUkCLde99CPOg8Ww"))

//    expect: "Status is 200 and the response is 'Hello world!'"
//      mvc.perform(post('/api/kafka/publish').content(toJson(request)))
//        .andExpect(status().isOk())
//        .andReturn()
//        .response
//        .contentAsString == "Hello world!"
//  }

//  @Autowired
//  User user
//  def "should pass producer details to domain component"() {
//
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
//
//  }

}
