
generate(FinalWord, Word, Tense, Person):-
	term(Tense,ListTerm),
	mot(Word,_,Type,_,_),
	nth1(Person,ListTerm,Term),
	conj(Type,Tense,ListRoot),
	nth1(Person,ListRoot,NumRoot),
	mot(Word,_,_,Root,NumRoot),
	atom_concat(Root,Term,FinalWord).

generate(FinalWord, Word, Tense, Person,Forme):-
	term(Tense,ListTerm),
	mot(Word,Forme,Type,_,_),
	nth1(Person,ListTerm,Term),
	conj(Type,Tense,ListRoot),
	nth1(Person,ListRoot,NumRoot),
	mot(Word,_,_,Root,NumRoot),
	atom_concat(Root,Term,FinalWord).


nom_gen(FinalWord, Word, Type, Tense, Person):-
	term(Tense,ListTerm),
	mot(Word,nom,Type,_,_),
	nth1(Person,ListTerm,Term),
	conj(Type,Tense,ListRoot),
	nth1(Person,ListRoot,NumRoot),
	mot(Word,_,_,Root,NumRoot),
	atom_concat(Root,Term,FinalWord).



adv_gen(FinalWord, Word, Tense):-
	term(Tense,ListTerm),
	mot(Word,adj,Type,_,_),
	nth1(3,ListTerm,Term),
	conj(Type,Tense,ListRoot),
	nth1(3,ListRoot,NumRoot),
	mot(Word,_,_,Root,NumRoot),
	atom_concat(Root,Term,FWord),
	atom_concat(FWord,'ment',FinalWord).
generate_pp(FinalWord,Word,Accord):-
	accord(Accord),
	atom_concat('participe_passe_',Accord,Tense),
	generate(FinalWord,Word,Tense,_).
