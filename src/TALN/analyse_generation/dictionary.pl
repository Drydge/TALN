%% verbe d'etat

mot(être,verbe_etat,être,'',1).
mot(être,verbe_etat,être,ét,2).
mot(être,verbe_etat,être,se,3).
mot(être,verbe_etat,être,fu,4).
mot(être,verbe_etat,être,fû,5).
mot(être,verbe_etat,être,f,6).

mot(devenir,verbe_etat,enir,devien,1).
mot(devenir,verbe_etat,enir,deven,2).
mot(devenir,verbe_etat,enir,devienn,3).
mot(devenir,verbe_etat,enir,devîn,4).
mot(devenir,verbe_etat,enir,devin,5).
mot(devenir,verbe_etat,enir,deviend,5).

mot(paraître,verbe_etat,aitre,paraî,1).
mot(paraître,verbe_etat,aitre,paraî,2).
mot(paraître,verbe_etat,aitre,paru,3).
mot(paraître,verbe_etat,aitre,par,4).
mot(paraître,verbe_etat,aitre,paraiss,5).
mot(paraître,verbe_etat,aitre,paraîtr,6).

mot(sembler,verbe_etat,simple_er,sembl,1).
mot(sembler,verbe_etat,simple_er,semble,2).
mot(demeurer,verbe_etat,simple_er,demeur,1).
mot(demeurer,verbe_etat,simple_er,demeure,2).
mot(rester,verbe_etat,simple_er,rest,1).
mot(rester,verbe_etat,simple_er,reste,2).
%% 

%% verbe avoir
mot(avoir,verbe,avoir,'',0).

%% Verbe d'action 

mot(venir,verbe,enir,vien,1).
mot(venir,verbe,enir,ven,2).
mot(venir,verbe,enir,vienn,3).
mot(venir,verbe,enir,vîn,4).
mot(venir,verbe,enir,vin,5).
mot(venir,verbe,enir,viend,5).

mot(tenir,verbe,enir,tien,1).
mot(tenir,verbe,enir,ten,2).
mot(tenir,verbe,enir,tienn,3).
mot(tenir,verbe,enir,tîn,4).
mot(tenir,verbe,enir,tin,5).
mot(tenir,verbe,enir,tiend,5).



mot(manger,verbe,accord_er,mang,1).
mot(manger,verbe,accord_er,mange,2).

mot(proteger,verbe,accord_er,proteg,1).
mot(proteger,verbe,accord_er,protege,2).

mot(coucher,verbe,accord_er,couch,1).
mot(coucher,verbe,accord_er,couche,2).

mot(manquer,verbe,accord_er,manqu,1).
mot(manquer,verbe,accord_er,manque,2).

mot(aimer,verbe,accord_er,aim,1).
mot(aimer,verbe,accord_er,aime,2).

mot(parler,verbe,accord_er,parl,1).
mot(parler,verbe,accord_er,parle,2).

mot(chercher,verbe,accord_er,cherch,1).
mot(chercher,verbe,accord_er,cherche,2).

mot(boire,verbe,oire,bo,1).
mot(boire,verbe,oire,buv,2).
%% 


%% nom
mot(joueur,nom,eur_euse,jou,1).

mot(homme,nom,masculin,homme,1).
mot(femme,nom,feminin,femm,1).
mot(neige,nom,feminin,neig,1).
mot(chat,nom,t,chat,1).
mot(beurre,nom,masculin,beurre,1).
mot(ordinateur,nom,masculin,ordinateur,1).
mot(souris,nom,feminin,souris,0).
%% 
%% ajectif
mot(jaune,adj,accord_e,jaune,1).
mot(jaune,adj,accord_e,jaun,2).
mot(blanc,adj,accord_e,blanc,1).
mot(blanc,adj,accord_e,blanch,2).

mot(courageux,adj,eux_euse,courageu,1).
mot(sérieux,adj,eux_euse,sérieu,1).
%% 
%Mot
mot(F,adv,maniere,F,0) :- adv_gen(F,_,_).


%% adverbe
%% lieu

mot(ailleurs,adv,lieu,ailleurs,0).
mot(autour,adv,lieu,autour,0).
mot(avant,adv,lieu,avant,0).
mot(dedans,adv,lieu,dedans,0).
mot(dehors,adv,lieu,dehors,0).
mot(derrière,adv,lieu,derrière,0).
mot(dessous,adv,lieu,dessous,0).
mot(dessus,adv,lieu,dessus,0).
mot(devant,adv,lieu,devant,0).
mot(ici,adv,lieu,ici,0).
mot(là,adv,lieu,là,0).
mot(loin,adv,lieu,loin,0).
mot(partout,adv,lieu,partout,0).
mot(près,adv,lieu,près,0).

%% temps

mot(alors,adv,temps,alors,0).
mot(après,adv,temps,après,0).
mot(après-demain,adv,temps,après,0).
mot(aujourdhui,adv,temps,aujourdhui,0).
mot(aussitôt,adv,temps,aussitôt,0).
mot(avant,adv,temps,avant,0).
mot(avant-hier,adv,temps,avant,0).
mot(bientôt,adv,temps,bientôt,0).
mot(déjà,adv,temps,déjà,0).
mot(demain,adv,temps,demain,0).
mot(depuis,adv,temps,depuis,0).
mot(encore,adv,temps,encore,0).
mot(enfin,adv,temps,enfin,0).
mot(ensuite,adv,temps,ensuite,0).
mot(hier,adv,temps,hier,0).
mot(jamais,adv,temps,jamais,0).
mot(longtemps,adv,temps,longtemps,0).
mot(maintenant,adv,temps,maintenant,0).
mot(parfois,adv,temps,parfois,0).
mot(puis,adv,temps,puis,0).
mot(quelquefois,adv,temps,quelquefois,0).
mot(soudain,adv,temps,soudain,0).
mot(souvent,adv,temps,souvent,0).
mot(tard,adv,temps,tard,0).
mot(tôt,adv,temps,tôt,0).
mot(toujours,adv,temps,toujours,0).

%% maniere

mot(ainsi,adv,maniere,ainsi,0).
mot(bien,adv,maniere,bien,0).
mot(comme,adv,maniere,comme,0).
mot(debout,adv,maniere,debout,0).
mot(ensemble,adv,maniere,ensemble,0).
mot(exprès,adv,maniere,exprès,0).
mot(gratis,adv,maniere,gratis,0).
mot(mal,adv,maniere,mal,0).
mot(mieux,adv,maniere,mieux,0).
mot(plutôt,adv,maniere,plutôt,0).
mot(vite,adv,maniere,vite,0).



%% quantitatif

mot(assez,adv,quantite,assez,0).
mot(aussi,adv,quantite,aussi,0).
mot(autant,adv,quantite,autant,0).
mot(beaucoup,adv,quantite,beaucoup,0).
mot(moins,adv,quantite,moins,0).
mot(peu,adv,quantite,peu,0).
mot(plus,adv,quantite,plus,0).
mot(presque,adv,quantite,presque,0).
mot(tout,adv,quantite,tout,0).
mot(très,adv,quantite,très,0).

%% negation

mot(oui,adv,negation,oui,0).
mot(peut-être,adv,negation,peut,0).
mot(non,adv,negation,non,0).
mot(si,adv,negation,si,0).
mot(vraiment,adv,negation,vraiment,0).

mot(pas,adv,negation_ne,pas,0).
mot(plus,adv,negation_ne,plus,0).
mot(rien,adv,negation_ne,rien,0).
mot(jamais,adv,negation_ne,jamais,0).

%% pronom

mot(qui,pronom,relatif,invariable,0).
mot(que,pronom,relatif,invariable,0).
mot(quoi,pronom,relatif,invariable,0).
mot(dont,pronom,relatif,invariable,0).
mot(où,pronom,relatif,invariable,0).

mot('lequel',pronom,relatif,masculinS,0).
mot('auquel',pronom,relatif,masculinS,0).
mot('duquel',pronom,relatif,masculinS,0).
mot('laquelle',pronom,relatif,femininS,0).
mot('à laquelle',pronom,relatif,femininS,0).
mot('de laquelle',pronom,relatif,femininS,0).
mot('lesquels',pronom,relatif,masculinP,0).
mot('lesquels',pronom,relatif,femininP,0).
mot('auxquels',pronom,relatif,masculinP,0).
mot('auxquels',pronom,relatif,femininP,0).
mot('desquels',pronom,relatif,masculinP,0).
mot('desquels',pronom,relatif,femininP,0).
mot('lesquelles',pronom,relatif,masculinP,0).
mot('lesquelles',pronom,relatif,femininP,0).
mot('auxquelles',pronom,relatif,masculinP,0).
mot('auxquelles',pronom,relatif,femininP,0).
mot('desquelles',pronom,relatif,masculinP,0).
mot('desquelles',pronom,relatif,femininP,0).




mot(je,pronom,personnel,masculinS,0).
mot(tu,pronom,personnel,masculinS,0).
mot(il,pronom,personnel,masculinS,0).
mot(nous,pronom,personnel,masculinP,0).
mot(vous,pronom,personnel,masculinP,0).
mot(nous,pronom,personnel,femininP,0).
mot(vous,pronom,personnel,femininP,0).
mot(ils,pronom,personnel,masculinP,0).
mot(elle,pronom,personnel,femininS,0).
mot(elles,pronom,personnel,femininP,0).

mot(mon,pronom,possessif,masculinS,0).
mot(ma,pronom,possessif,femininS,0).
mot(ton,pronom,possessif,masculinS,0).
mot(ta,pronom,possessif,femininS,0).
mot(son,pronom,possessif,masculinS,0).
mot(sa,pronom,possessif,femininS,0).
mot(notre,pronom,possessif,femininS,0).
mot(notre,pronom,possessif,masculinS,0).
mot(nos,pronom,possessif,femininP,0).
mot(nos,pronom,possessif,masculinP,0).
mot(votre,pronom,possessif,femininS,0).
mot(votre,pronom,possessif,masculinS,0).
mot(vos,pronom,possessif,femininP,0).
mot(vos,pronom,possessif,masculinP,0).
mot(leur,pronom,possessif,femininS,0).
mot(leur,pronom,possessif,masculinS,0).
mot(leurs,pronom,possessif,femininP,0).
mot(leurs,pronom,possessif,masculinP,0).
mot(le,pronom,personnel,masculinS,0).
mot(lui,pronom,personnel,masculinS,0).
mot(la,pronom,personnel,femininS,0).
mot(une,pronom,indefinis,femininS,0).
mot(un,pronom,indefinis,masculinS,0).
mot(les,pronom,personnel,masculinP,0).
mot(les,pronom,personnel,femininP,0).
mot(des,pronom,indefinis,masculinP,0).
mot(des,pronom,indefinis,femininP,0).
%Verbe
verbe(_mot) :- 
	mot(_mot,verbe).


%Nom
nom(_mot):- 
	mot(_mot,nom).


person(1,verbe,'première personne du singulier') .
person(2,verbe,'deuxième personne du singulier') .
person(3,verbe,'troisième personne du singulier') .
person(4,verbe,'première personne du pluriel') .
person(5,verbe,'deuxième personne du pluriel') .
person(6,verbe,'troisième personne du pluriel') .

person(1,nom,'masculin singulier') .
person(2,nom,'masculin pluriel') .
person(3,nom,'féminin singulier') .
person(4,nom,'féminin pluriel') .

accord(femininS).
accord(masculinS).
accord(femininP).
accord(masculinP).