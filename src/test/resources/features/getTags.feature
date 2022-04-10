Feature: validating response
  as systems admin
  want to get a resource
  for validate the response

  Scenario:
    Given I am in the web
    When I do a Get solicitation
    Then I obtain a http response of the business flow
