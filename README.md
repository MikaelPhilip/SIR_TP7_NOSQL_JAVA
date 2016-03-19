# SIR_TP7_NOSQL_JAVA

Ce tp permet de voir une des BDD no-SQL la plus connue: MongoDB.Ici le tp se fait en trois étapes:
-Installation,lancmeent et utilisation de MongoDB
-Utilisation d'une librairie java "Morphia" pour utiliser MongoDB dans un programme JAVA
-Utilisation de Redis

Tp7 SIR fait par PHILIP Mikaël et JELASSI Seifeddine

##Morphia

Morphia est une librairie dont le principe est proche de JPA (definision par annotation d'entité,de liens, etc..) qui permet d'utiliser MongoDB

On a donc testé cette librairie en:
-Créant des entités, des objets avec les annotations de morphia (tous les .java dans le package model).
-Manipuler la base (insertion,lecture,suppression) avec des méthode de Morphia (App.java).

###Avantage et limite du No-SQL:
+L'avantage du No-SQL est que c'est beaucoup plus simple à utiliser et à mettre en oeuvre que du SQL.
+L'autre avantage c'est que c'est fait pour pouvoir être réparti entre plusieurs machines/sources (pas comme le sql de base).
-Par contre il n'y a plus réellement de jointure ce qui peut poser probléme.
-Egalement la cohérence des données n'est plus assurées comme avec le SQL.
-Entre les différentes sources des incohérences peuvent apparaitres (si pas de synchronisation depuis un bout de temps).

Donc le No-SQL est une alternative aux SQL pour certain cas précis (si la perfomance et bien plus importante que la cohérence).

###Redis