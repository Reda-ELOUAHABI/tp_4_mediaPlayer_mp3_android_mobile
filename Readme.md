Mobile DEV Bah:
les Factures de revolution Mobile : p21
DGSSI DTD => les droits de filmage
application de streaming- filmage avec IA [car tout le monde film les bonnes moments, les moment rares a produire ..], au leiux de plaisiait au max

=>Specification du devloppement mobile
hardware:
utilisation de batterie doit etre calculee et minimisee [premordiale]
capteur de proximity qui eteint l'ecran e  appel lorsque on l'approche ,,
software:
**l'appel (fonction) doit etre respecter par tout application , car c'est la fonction principle .
n'importe quelle app doit avoir la loi d'appeller n'import quell app [communication entre app] , meme si on ne sait pas son nom [je veux envoyer un sms ,ouvre moi l'app, et android va cheercher ..] [dans desktop on a pas cette flexibility]
**si une app consomme les recources plus qu'un certain niveau [RAM, CPU]. OS va crahser l'app ,
on ne peut pas faire un while true , par contre en desktop c'est possible ,,


ADB = c'est l'outil qui communique android MV a anroid studio , VM c'est une processus avec un numero de port , on peut y acceder a adb par ligne de commade , apres le demarer il nous genere un cle dans un reperoire , on se connect , on fait de pull push des apk avec l emulateur ...

Emulateur Vs reel:
Variety de vesion on AVD
manque de quality de fonctionnality physique[sensor camera GPS ..]
 on generale on ne specifie pas max SDK , car android va demarer un module compatibility pour que votre app marche avec les futures vesrions
le mieux:
developpement device  reel [physique] == target sdk [One]
test compatibilty  using AVD {Multiple versions [minSDK, +oo] }

Manefest = module permission ,,,
Gradle : API level ..
resource = centraliser => centraliser la gestion de resources, creer multiple version of app from multiple resources  +  internalisation de l'app

android resources ..
//color : color , style de colors
/drawable image classique
/miomap l'icon de app [traiter particulierement les icon [height quality] ]
//layout interface
/raw = pour lire des fichiers brute [read only]

#new
/animator
/font


une app has une activity
Empty activity
db:  depend de la resolution
sp: resolution + preference de user [pour les text]



####
Manefst
uses-persmission  + permission ,,,
uses-feature: exiger certain feature pour que l app marche, like geoschope pour une MIzan delma , camera pour camera360 par exemple ,,,

les permission:
l'objective est de ne pas proteger mais aider a la protection, le telephone list les persmission dans le manfest , et l'utilisateur c'est lui qui accepte de laisser ca ou pas ,,

par default les app n ont aucun permission
4 niveau de permission: [est les permission change de dangereusity over the time ,, comme aller sur internet qui devenu normal 
]
NORMAL: changer l arriere plan , on peut la declarer , on peut non
DANGEREUX: appels - internet [declarer en manifest + demande explicit a user d y accepter]
SIGNATURE: lorsque on developpe et on vuet la poseter sur app store on la signe , il peuvent nous faire confiance avec la signature , par exemple whtsp buissness a le meme permission que wtsp sans avoir deranger les users , car c'est le meme developpeur en fin du compte [Meta /facebook ,,]
RUN TIME PERMISSION (dangereuse) / Install permission (normal + signature)


##CYCLE DE VIE
normalement le system ne doit pas tuer l'etat active , car il est le top prioritaire, sauf si on a un virus qui prend trop de resource [foregrournd==premier premier plan], meme le semi-visible process .
le changement de priority = si une process important appel un process moins prioritaire , son importance va devenir la meme du plus important ,, pour ne pas tuer un porocess par le system que a cause de la priority heirarchique

o peut implementer broadcast recevier => soit on l appel/subscribe a onstart et on se discribe pause ///////// ou onResume/onstopp [les 2 pairs qu'on a ]

il ya des donnees que le system va souvgarder automatiqueuemnt poutr nous [InputField] , et il ya des variables/comonent [TextView like<p>] que le systme ne vas pas les sauvgarder auromatiquement , il ya 3 maniere pour les faire entant que developer

OnCreate(bundle) VS OnSaveInstanceState(Bundle) : sont different que dans le debut : demarage normale, Bundle ==null a oncreate, mais onsaveInsateState(Bundle) est tjr contenir l'etat de l'app , 

parmis les 3 Methodes :
onpause (){le code ne doit pas etre lourd}
sharedPreferences == simple **fichier** oriente key/Value Geree par le SYstem

Intent:

Communication entre apps
je veux envoyer un SMS : je code ca dans entent , et laissser le processus linux liee a cette intent a faire ca
Intent explicite : call exatly the component with it's name, with Activity.class
Intent Implecite: call action , and android search who can perfume this action

[IDEE: direct Walpaper : take image , save it , and intent directly will set it at walpaper ,, good idea ]

**pour mettre une activity a la disposition des autre : Intent filter , make category DEFAULT

lorsque on appel intent: publish
android va voir est ce que il ya une activity qui peut faire ca: notify your activity that there is an app could do cela

Flag: ce qui nous permet de changer le comportement normal

3 parametres de Intent :
implicite  == sont bien defini ~ required
explicite ==

on peut specifier le type , mais c'est pas bien definis.
explicite intent == compentnet parametres
extra = les donnees a transmetre a l'intent appeler lorsque il demare [donnee de register contact .. [nom , numero ,,]]
un bundle  est un structure de donees
soit un par un avec intent.putExtra(key, value)
soit on utilise Bundle() qui est un structure {[
{key value}
{key value }
]}

et on ajoute le tout iNTENT.putBundle()

le passage d'une app a une autre => forcement il ya un intent appellee

Pour Implicite = au moins on doit specifier :
ACTION + DATA qui seront envoyer au system , et le system va nous chercher les intent qui feront cette activity , on peut choisir exactement l'intent si on a le choix,

si il trouve setData eyt setType , il va ignorer setType , car andoid peut avoir le type automatiquement , il ne te laisse pas lui faire tromper

on peut faire une action customized :
<intentFilter bonjout.ACTION >
on peut l'appe


ACTION_CALL : necessite une permission dans le manifest et un runtime permission (a partir de API level 23)
il va etre liee a un btn/function click :

if(M<23) ne fait rien
else{
if(checkself [a deja la permission]):{
faire l appel
}
else{
showDialog: give one time / forever permeesion: call

if cancel : ne fait rien
}
}

####Intent avec une resulatat a returnerL
startActivityforResults(intent,ID);
onActivityResult(ID, CODEResuklt,Intent {l intent en reponse})
// si si moi je doit dire est ce que
//ID == REQUEST CODE  : pour faire la difference lorque on appel plusieurs intent , et on va recuperer la reponse correspondant avec cette requestID

Recycle View Vs listeView:
ListView : charge tout les donnees de la BD [peut prendre trop de temps si bd big]
RecycleView : il charge les donnees ce qui est affichee dans l'ecran , et on scroll il charge plus en plus ,, [petit latente/delai , BD dynamique large]

ListView = adaptater needed pour adapterm les != types de src [BD - Resources]

@+id =listPays  //@pour acceder a un resource et + pour creer l'ID

ListView myList = (listView) findViewById(R.id.listPays);
myList.setAdapter(myAdapter);

##THREAD

le service est en e tach Arr plan , mais il ne s execute pasm sur un thread,
intent service ne peut pas etre tuee aperes la demarer.
UI main thream main process , ne peut pas etre blocker plus que 5s , on est sur resource limitee , et le telephone doit etre un telephone [calls has hight priority] ,

pour ca on cree un thread pour le tratement lourd qui va prend plus que 7s dans notre cas. et on le fait communiquer.

runable envoie le msg a main via un hundler

###BR
recepteurs de broadcast

on register dans intent filter de type event broadcast reciever, et on l'appel avec intent.
et dans le cas de broadcast , on va les executer tout ,
 l'utilisateur ne vas rien choisir , contraireemnt a intent/activity , il y a une seul activity a choisir et a executer
 il ya des evenement system ,,, changement de n'import quelle comporsant system.

BR de type = local Brodacast : pour ne pas consommer l'energie en  envoyant le broadcast vers tout les apps , on envoiejuste en local de l app
normal : tout va recevoir , Ordered: broadcast en ordre un par un
avec permeesion: A1 sendBrodcast(intent EV1, Permission Per1)
seuls qui ont la persmission de type Per1 dans leur manifest , peuvent recevoir BR,
cad Brodcast ne va pas BRODCASeTer a a tout le monde,
et aussi il y a dans le sens inverse , pour envoyer in doit avoir le parmission X , autre sens ,
 pour recevoir , on doit avoir une persmissionY
static : marche meme l app n'est pas demaree , et android a partir d'1 aPI level ,
il empeche de faire des brodcast statiquement , gasspillage de memoire ,, [exemple clock_toc 1s peer 1s ,,]
dynamique: active que lorsque app est executee , minimiser l'utilisation de system ,,

chaque BR on peut specifier la priority , ou le Ordered Brodcast va etre etablit

Asynctask depriciee pour les thread JAVA => ALTernative: Kotlin Coroutine(c'est un concept similiar un peu aux threads)


############Permission Personalisee
Premission seul si on est dans le cas d'une permission Personalisee
USESPermission persmission standard
Declarer la permission de facon cohearante
Renforcer soit au niveau de l'application tout entier(toute est protegee) , ou sur une Activity donnee dans Activity> (on protege qu'une seul activity)
on ne peut pas start entent by <intentFilter> qui demande une permission sans avoir la declarer dans Permission manifest
Service: on peut Start Service , Ou on Bind a un service (on se connect a un service donnee et on appel ses methodes ..)
Exemple de serviceK on ne peut pas appeler methode service :
il doit avoir Bind_to messageSListner(Permission to have a service[renforcer la permission]) ++ methode2
content Provider est sous forme d'un uri: Protocole/XXXXXXX/XXXX/

Content provider : on peut specifier un branche qu on le permis , comme l'exemle on a permis tous 
ce que a dans /atachement (les oieces joints du mail par exemple lorsque on clique pour voir les images
 attachee a un mail)

 Permission de broadcast R:
 1-qui envoie un message peut exige un permission pour qu'il envoie
 2-et qui recois peut exiger la permission au source des prodcast pour qu'il recois les Brodacast

TP SERVICE = ListView + service
https://www.emi.ac.ma/bah/cours/dev_mobile.html








