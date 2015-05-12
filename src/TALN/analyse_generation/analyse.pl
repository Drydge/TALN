%% recherche dan la liste de terminsaison la terminaison X
searchTerm(X,[X|_]).
searchTerm(X,[_|_queue]):-
	searchTerm(X,_queue).

%% cherche si la terminaison existe et renvoie son type dans Term
analyseTerm(X,Term) :- 
	term(Term,List),
	searchTerm(X,List).

%% recherche si la racine existe
analyseRoot(Root,Mot,Cat) :-
	mot(Mot,Cat,_,Root,_).

%% etabli une relation pour savoir si le numero de racine correspond a la terminaison par la conjugaison
analyseConj(Root,Term,Index,NomTerm):-
	mot(_,_,Type,Root,NumRoot),
	analyseTerm(Term,NomTerm),
	term(NomTerm,ListTerm),
	nth1(Index,ListTerm,Term),
	conj(Type,NomTerm,ListRoot),
	nth1(Index,ListRoot,NumRoot).

%% analyse le mot lettre a lettre en mettant a chaque foix la derniere lettre du mot dans la terminaison pour analyser la racine

analyseWord(X,Y,Mot,Cat,Groupe,Person) :- 
	analyseRoot(X,Mot,Cat),
	analyseConj(X,Y,Person,Groupe).

analyseWord(X,Z,_1,_2,_3,_4):-
	sub_atom(X,Length,1,0,Term),
	sub_atom(X,0,Length,1,Root),
	atom_concat(Term,Z,TermWord),
	analyseWord(Root,TermWord,_1,_2,_3,_4).

analyse(X) :- 
	analyseWord(X,'',Mot,Cat,Groupe,Person),
	person(Person,Cat,NPers),
	write(X),write('->'),write(Cat),tab(1),
	write(Mot),tab(1),
	write(NPers),tab(1),
	write(Groupe).
analyse(X,Mot,Cat,Groupe,Person):-
	analyseWord(X,'',Mot,Cat,Groupe,Person).
