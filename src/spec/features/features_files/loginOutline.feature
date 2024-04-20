# language: en
@moduleLogin
Feature: Je souhaite tester la connexion de la page Swag Labs
  En tant que utilisateur je souhaite tester la connexion de la page Swag Labs

  Background: 
    Given je suis sur la page de connexion Swag Labs

  @logincasPassant
  Scenario Outline: Connexion reussie avec des informations d identification correctes
    When je saisie le username valide "<login>"
    And je saisie le password valide "<password>"
    And je clique sur le boutton login
    Then Je me redirige vers la page home "<message>"

    Examples: 
      | login         | password     | message  |
      | standard_user | secret_sauce | Products |

  @logincasNonPassant_usernameInvalide
  Scenario Outline: Connexion echouee avec username invalide
    When je saisie le username invalide "<login>"
    And je saisie le password valide "<password>"
    And je clique sur le boutton login
    Then Je me redirige vers un message d erreur "<message>"

    Examples: 
      | login  | password     | message                                                                   |
      | fatima | secret_sauce | Epic sadface: Username and password do not match any user in this service |

  @logincasNonPassant_passwordInvalide
  Scenario Outline: Connexion echouee avec password invalide
    When je saisie le username valide "<login>"
    And je saisie le password invalide "<password>"
    And je clique sur le boutton login
    Then Je me redirige vers un message d erreur "<message>"

    Examples: 
      | login         | password | message                                                                   |
      | standard_user | fatima   | Epic sadface: Username and password do not match any user in this service |

  @logincasNonPassant_passwordVide
  Scenario Outline: Connexion echouee avec password vide
    When je saisie le username valide "<login>"
    And je laisse le password vide ""
    And je clique sur le boutton login
    Then Je me redirige vers un message d erreur "<message>"

    Examples: 
      | login         | password | message                            |
      | standard_user |          | Epic sadface: Password is required |

  @logincasNonPassant_usernamedVide
  Scenario Outline: Connexion echouee avec username vide
    When je laisse le username vide ""
    And je saisie le password valide "<password>"
    And je clique sur le boutton login
    Then Je me redirige vers un message d erreur "<message>"

    Examples: 
      | login | password     | message                            |
      |       | secret_sauce | Epic sadface: Username is required |

  @logincasNonPassant_usernamedAndPasswordVides
  Scenario Outline: Connexion echouee avec username et password vide
    When je laisse le username vide ""
    And je laisse le password vide ""
    And je clique sur le boutton login
    Then Je me redirige vers un message d erreur "<message>"

    Examples: 
      | login | password | message                            |
      |       |          | Epic sadface: Username is required |
