# JDBC_JAVA

#### *GROUPE ERP CISCO : Maël RHUIN & Adrien Chrétien*

Sujet de Travail évalué sur JDBC JAVA

## INSTALLATION

Téléchargez et décompressez l'archive du projet github ou bien clonez-le. Il vous faut un serveur web de gestion de BDD tel que WampServeur, MAMP, Laragon, XAMP... Basé en `localhost` et utilisant le port `3306`. *Pour la partie lancement, ce serveur doit être actif !*

## CODE

Ce projet comporte trois dossiers qui contiennent chacun le projet Intellij d'une des 3 versions. La version 16 de JAVA est utilisée et l'artifact est construit dans le dossier `out/artifacts/`.

<img src="https://user-images.githubusercontent.com/66364083/217632240-47402ddb-df7c-44eb-aaa1-3233491b04dd.png" height="300">

<img src="https://user-images.githubusercontent.com/66364083/217639123-9d8df40b-6edd-426d-9c4a-9a46b4de6831.png" width="300">

#### *Note : chaque <b>VERSION</b> possède sa javadoc dans un dossier respectif nommé `JavaDocs`, il faut alors lancé l'`index.html` de ce dernier.*

## LANCEMENT

L'environnement d'administration de la BDD utilisé pour le développement a été `WampServer` avec `MySQL`. Le code y accède en `localhost` sur le port `3306` via un utilisateur `root` ayant un mot de passe vide. Le code s'occupe de créer la BDD (mabd) et ses tables si elles n'existent pas.

<img src="https://user-images.githubusercontent.com/66364083/217630689-b2d38b8e-817b-43e9-9971-e474d1432746.png" width="300">

Trois fichiers `.jar` sont fournis dans le dossier spécifier précédemment `out/artifacts` de chaque <b>VERSION</b> et correspondent à chaque version packagée en tant que fichier autonome et peuvent être lancés en suivant les étapes suivantes :

 #### Etape 1 : Ouvrir un terminal
 #### Etape 2 : Se placer dans le répertoire où se trouvent les fichiers `.jar`
 
 *Assurez-vous de disposer de la version adéquate de JAVA sur votre ordinateur pour pouvoir lancer les fichiers `.jar` correctement.* 
 
 #### Etape 3 : Lancer la commande suivante : `java -jar VERSION_X.jar` où <b>X</b> est le numéro de version.

<img src="https://user-images.githubusercontent.com/66364083/217639970-c5704a74-4423-4bcc-89ad-fa65b52ae54e.png">

*N'hésitez pas à nous contacter si vous rencontrez des problèmes ou si vous avez des questions.*
