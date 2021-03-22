
# linuxSensors
le code C pour la communication avec l'arduino/traitement des infos 
# Installation
prendre la dernière release sur ce github

dézipper le zip 

copier le Dossier USBFake (vous pouvez le renomer si vous voulez) sur la clé 
*si vous avez pas de clé USB bha faudra télécharger le dossier depuis le PC sur github directement*

ensuite pluggez la clé dans le PC à installer et exécutez le script preinstallPC.sh

> Comment faire ?

pour cela il faut ouvrire un terminal dans le bon dossier -> le dossier USBFake 

![comment ouvrir un terminal](https://i.ibb.co/3Rd97vB/tuto-linux.png)
puis entrez la commande : (si vous ne pouvez pas essayez de faire un "chmod +x *.sh" avant) 

    sudo ./preinstallPC.sh
Cette commande fait dans l'ordre :

 - une update de tout les packages, si besoin
 - ajout d'un utilisateur "kiosk"
 - enlève le mot de passe de kiosk
 - install les packages : "chromium-browser unclutter xdotool"
 - ajout de l'auto log dans kiosk
 - ajout du autoStart qui va lancer le script kiosk.sh après chaque démarrage de "kiosk"
 - ajout du script kiosk.sh qui lance automatiquement chromium sur la page d'accueil
 
 

> pour changer la page en fonction de la mairie il faudra modifier le fichier kiosk.sh et plus particulièrement l'url présent.
> cette commande ouvrira le fichier :

    sudo -H gedit /home/kiosk/kiosk.sh

ensuite cela une fois fait il vous faudra changer d'utilisateur via l'interface graphique de base et chosir l'utilisateur kiosk
![comment changer utilisateur](https://i.ibb.co/tPgFz7m/tuto-linux-2.png)Puis ré-ouvrez un terminal DANS LE FICHIER USBFake 
ensuite faite la commande 

    sudo ./install_script_YN.sh
ce script fait dans l'ordre :

 - un copie de ma clé SSH (grosso merdo un accès a mon compte github pour pouvoir copier le code) dans le répertoir associé sur le root
 - update les packages si besoin
 - install les packages suivant : "build-essential git libx11-dev minicom libxml-xpath-perl npm telegraf"
 - 
 - 

 

<!--stackedit_data:
eyJoaXN0b3J5IjpbMjExNjcyMzA4NiwtMTcwMTcxOTI1NSwtMT
g4OTkzNTQ4MywxODYzMDY1NTQsLTUyOTM3MTc5OCwtMTY3NTc0
ODc2NywtNDAwNjgxMTcwLDM5NjE0MjU3OSwtMTUzNzc4MDkxNS
wxMTk4ODg1MzA1LC01NDEyMTI1LDk5MTUzMzU3NSwtMTcwMjEw
ODc4NF19
-->