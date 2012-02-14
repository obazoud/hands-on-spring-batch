#Hands-on Spring Batch

##Employées

Ce batch permet de charger en base de données un fichier d'employées et un autre de salaires:

* la première étape charge le fichier employee.csv dans la base de données
* la deuxième charge le fichier salaries.xml dans la base de données
* et la dernière étape fait des statistiques

##Step 1: Lire les employées

La première étape permettra de lire le fichier contenant l'ensemble des employées que nous souhaitons intégrer dans la base de données.
Il s'agit d'un fichier CSV dans la structure est la suivante: id, birthDate, firstName, lastName, gender, hireDate.

Voici quelques rêgles métier à respecter:

* Il faudra être attentif à ne pas importer (Skip) des données non conformes, c'est à dire s'il existe des données ne respectant pas la structure de données si dessus
* Il faudra exclure les employées nés avant 1952
* Il faudra s'assurer que le champs "gender" ne soit que "F" ou "M"

Une fois, les données conformes, il faudra les écrire dans la base de données dans la table EMPLOYEES à l'aide JDBC.

Les tests EmployeeStep1Test permettent de vérifier que cette étape fonctionne correctement.

##Step 2: Lire les salaires

La deuxième étape permettra de lire le fichier contenant l'ensemble des salaires des employées.

Voici quelques rêgles métier à respecter:

* Vérifier que l'id de l'employée existe
* Générer un UUID comme id du salaire

Les tests EmployeeStep2Test permettent de vérifier que cette étape fonctionne correctement.

##Step 3 : masculins / féminins

Le but de cette étape est d'afficher le nombre d’employée masculins et féminins à l'aide Slf4j. 
Option: Ecrire EmployeeStep3Test afin de vérifier votre step3 ;)

##Job: Enchaîner les étapes

Les tests EmployeeJobTest permettent de vérifier que l'ensemble du batch fonctionne correctement.

## Shell

Le projet utilise le [Application Assembler Maven Plugin](http://mojo.codehaus.org/appassembler/appassembler-maven-plugin/) pour générer un script automatiquement, et ainsi pouvoir lancer le batch depuis un shell.

<pre class="terminal">
% mvn clean package -pl 03-employees
% mysql -h localhost -u xxx --password=xxx employees &lt; 03-employees/src/main/resources/employees-mysql.sql
% sh 03-employees/target/appassembler/bin/employee.sh handson/springbatch/springbatch.xml job datafileEmployees=file:///path/to/employees.csv datafileSalaries=file:///path/to/salaries.xml
</pre>

Demandes moi les fichiers se trouvent [ici](https://github.com/obazoud/hands-on-spring-batch/blob/master/samples.tar.gz)

