Feature: zigwheels

  Scenario: Naviagting to upcoming bikes page
    Given The user is on zigwheels Homepage
    When the user moves the mouse to the NewBikes
    Then Select UpcomingCars

  Scenario: Getting upcoming honda bikes list
    Given the user is on upcoming bikes page
    When Select honda brand in manufacturer dropdown
    And click Readmore
    Then print the bikes names,price,launched dates whose price less than 4lakhs

  Scenario: getting used cars popular models in chennai
    Given navigating to Homepage
    When the user moves mouse to the used cars
    And Select Chennai in city section
    And scroll down to the popular models
    Then print popular models list

  Scenario: Checking user credintials
    Given login/sinup page is opened
    When Select login/signup
    And Select google
    And enter Invalid Email-Id
    Then get the error messgae
