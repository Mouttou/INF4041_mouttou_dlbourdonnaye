MOUTTOUNADARADJANE Nathalie<br/>
DE LA BOURDONNAYE Benoit

<center> Programation Mobile - INF4041 </center>

#Projet Alarm MultiTask

Cette application a pour but d'utiliser les différentes notions appris au cours de ce mdule.
Elle permet de définir une alarme, d'aller sur Google et d'accéder à une liste de Biere qu'on va afficher dans une nouvel activité à l'aide d'un Recycler view.

##Specifications requises réalisées

- Recycler View
- Toolbar avec un bouton
- Faire des String EN et FR pour faciliter la traduction
- Réaliser un téléchargement (et notification) et l'afficher avec un RecyclerView (le téléharagement se fait au moment de l'appel du JSon)
- Réaliser une autre vue -> Landscape
- Appeler une autre application (Appelle de l'application Google Chrome pour accéder à un lien.
- Des éléments graphiques de base
- Au moins 2 activiés
- Des notifications (surtout des Toasts)
- Le traitement des JSon

##Actions faites (extra)

- TimePickerDialog pour choisir l'heure de l'alarme
- Nouveau logo pour l'application

#Utilisation de l'application

-Bouton + sur le toolbar: Affiche un toast
-CheckBox à côté du XX:XX permet d'afficher le TimePickerDialog qui va permettre de choisir l'heure
- Bouton Google: Appel du navigateur internet qui va afficher le lien de google
- Bouton Biere: Ouverture d'une nouvelle activity qui va télécharger les données et afficherles données JSon à l'aide d'un RecyclerView
- En tournant le téléphone en landscape on va avoir un textField qui va afficher "Landscape mode!"
