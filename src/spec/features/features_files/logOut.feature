@testCase
Feature: Je souhaite tester la deconnexion de la page Swag Labs
  En tant que utilisateur je souhaite tester la deconnexion de la page Swag Labs
  
 Background:
    Given je suis sur la page de connexion Swag Labs
    When je saisie le username valide "error_user"
    And je saisie le password valide "secret_sauce"
    And je clique sur le boutton login
    And Je clique sur le menu burger

  @loginOut
  Scenario: Deconnexion reussie de la page Swag Labs
    And Je clique surle bouton Logout
    Then Je me redirige vers la page d authentification "Swag Labs"
    
    
    @about
  Scenario: Je souhaite tester le bouton about
    And Je clique surle bouton About
    Then Je me redirige vers la page About "https://saucelabs.com/"
    