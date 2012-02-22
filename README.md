#Hands-on Spring Batch

##Prérequis
Sur votre machine, il faut installer :

1. maven 3.0.3
2. git 1.7.x
3. MySQL 5.1.x
4. votre IDE préféré
et quelques connaissances en shell seront nécessaires.

MySQL sera utilisé uniquement lors de l'exercice 3 lors du lancement du batch par le shell.
L'ensemble des tests intégration utilise la base de données embarquée [H2](http://www.h2database.com)

##Introduction

Le but de ce Hands-on est de faire des batchs à l'aide [Spring Batch](http://static.springsource.org/spring-batch).

En premier lieu, la prise en main se fera à travers deux batchs:

* Le premier 'Hello world tasklet' consistera à implementer une Tasklet
* Le deuxième 'Hello world chunk' sera un chunk à implementer

Enfin, le dernier batch 'Employee' permettra de faire un batch plus réaliste.


## Installation

Les sources se trouvent sur [GitHub](https://github.com/).
Si vous avez un compte GitHub, forker le projet et cloner votre fork.

Sinon:
<pre class="terminal">
% git clone git@github.com:obazoud/hands-on-spring-batch.git
</pre>

Lancer Maven afin de télécharger l'ensemble des dépendences.
<pre class="terminal">
% mvn clean package --fail-at-end
% mvn clean package -DskipTests
</pre>

