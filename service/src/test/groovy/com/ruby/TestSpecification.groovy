package com.ruby

import spock.lang.Specification

class TestSpecification extends Specification {

  def "Should add correctly"() {
    given:
      def x = 1
      def y = 2
    when:
      def result = x + y
    then:
      result == 3
  }
}
