package groovy.com.ruby

import com.ruby.model.User
import com.ruby.service.Producer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import spock.lang.Specification

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
}
