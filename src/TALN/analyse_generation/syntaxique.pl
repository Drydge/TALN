%% les phrases sont de type :
%% SUJET + VERBE d'ACTION
%% SUJET + VERBE d'ÉTAT + ADJECTIF
%% SUJET + VERBE d'ÉTAT +ADVERBE + ADJECTIF
%% SUJET + VERBE d'ACTION + ADVERBE
%% SUJET + VERBE d'ACTION + ADVERBE + ADVERBE
%% SUJET + VERBE + COMPLEMENT d'OBJET
%% SUJET + VERBE + COMPLÉMENT CIRCONSTANCIEL

prop --> base_verbal(_).
prop --> base_verbal_etat(X),adj(X).
prop --> base_verbal(X),adv,adj(X).
prop --> base_verbal(_),adv.
prop --> base_verbal(_),adv,adv.
prop --> base_verbal(_),gn(_,_).
phrase --> prop,compl_obj(_).

analyse_phrase(P):- atomic_list_concat(L,' ',P),phrase(L,[]),!.



%% BASE VERBAL
base_verbal(Type) -->sujet(P,Type),verbal(P,Type).
base_verbal(Type) -->sujet(P,Type),verbal(P,Type).
base_verbal_etat(Type) -->sujet(P,Type),verbe_etat(P).


%% GROUPE NOMINAL
gn(X,Y)		--> groupe_nominal(X,Y),compl_obj(_).
gn(X,Y)		--> groupe_nominal(X,Y),adj(Y).
gn(X,Y)		--> groupe_nominal(X,Y).
compl_obj(X)-->gn(_,X).
compl_obj(_)-->infinif.
compl_obj(_)-->proposition(_).

proposition(X)--> subordonne_relative(X).

subordonne_relative(_)		--> pronom(_),base_verbal(_).

subordonne_relative(X)		--> verbal(_,X).
subordonne_relative(_)		--> pronom(_),gn(_,_).
%% subordonne_completive(_)		--> .
%% subordonne_circonstatielle(_)--> .
pronom(_)-->{mot(Pronom,pronom,relatif,_,_)},[Pronom].


adj(masculinS)	--> {generate(Adj,_,_,1,adj)},[Adj].
adj(masculinP)	--> {generate(Adj,_,_,2,adj)},[Adj].
adj(femininS)	--> {generate(Adj,_,_,3,adj)},[Adj].
adj(femininP)	--> {generate(Adj,_,_,4,adj)},[Adj].

infinif	--> {mot(Verbe,verbe,_,_,_)},[Verbe].
groupe_nominal(3,femininS)	--> {nom_gen(Mot,_,Type,_,3),not(Type = masculin),mot(Pronom,pronom,Relatif,femininS,_),not(Relatif=relatif)},[Pronom],[Mot].
groupe_nominal(3,masculinS)	--> {nom_gen(Mot,_,Type,_,1),not(Type = feminin),mot(Pronom,pronom,Relatif,masculinS,_),not(Relatif=relatif)},[Pronom],[Mot].
groupe_nominal(6,femininP)	--> {nom_gen(Mot,_,Type,_,4),not(Type = masculin),mot(Pronom,pronom,_,femininP,_)},[Pronom],[Mot].
groupe_nominal(6,masculinP)	--> {nom_gen(Mot,_,Type,_,2),not(Type = feminin),mot(Pronom,pronom,_,masculinP,_)},[Pronom],[Mot].


sujet(3,femininS)	--> gn(3,femininS).
sujet(3,masculinS)	--> gn(3,masculinS).

sujet(6,femininP)	--> gn(6,femininP).
sujet(6,masculinP)	--> gn(6,masculinP).
sujet(_,_)			--> [].
sujet(1,_)		 	--> [je].
sujet(2,_)		 	--> [tu].
sujet(3,masculinS) 	--> [on].
sujet(3,masculinS) 	--> [il].
sujet(3,femininS) 	--> [elle].
sujet(4,_)		 	--> [nous].
sujet(5,_)		 	--> [vous].
sujet(6,masculinP) 	--> [ils].
sujet(6,femininP) 	--> [elles].

adv --> {mot(F,adv,T,_,0),not(T = negation_ne)},[F].

verbal(Person,Accord)-->{generate(Avoir,avoir,_,Person,verbe),generate_pp(Verbe,_,Accord)},[Avoir],[Verbe].
verbal(Person,_)--> verbe(Person).
verbal(Person,_)--> pronom,verbe(Person).
verbal(Person,_)--> verbe_etat(Person).
verbal(Person,_)--> pronom,verbe_etat(Person).
verbe(Person)-->{generate(Verbe,_,_,Person,verbe)},[Verbe].
verbe_etat(Person)-->{generate(Verbe,_,_,Person,verbe_etat)},[Verbe].

pronom-->{mot(Pronom,pronom,Relatif,_,_),not(Relatif=relatif)},[Pronom].