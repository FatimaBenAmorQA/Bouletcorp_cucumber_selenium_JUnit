#language: fr

Fonctionnalité: Je souhaite pouvoir naviguer sur le site bouletcorp
  En tant que utilisateur je souhaite pouvoir naviguer sur le site bouletcorp 

  @bouletcorp
  Scénario: Je souhaite tester le changement de page et l affichage des widgets sur le site
    Etant donnée je me rends sur le site boulecorp "url"
    Quand je clique sur Apropos
    Alors la page a changé
    Et les widgets facebook, twitter et tumblr sont bien affichés

