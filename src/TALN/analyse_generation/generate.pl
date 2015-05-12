
generate(FinalWord, Word, Tense, Person):-
	term(Tense,ListTerm),
	mot(Word,_,Type,_,_),
	nth1(Person,ListTerm,Term),
	conj(Type,Tense,ListRoot),
	nth1(Person,ListRoot,NumRoot),
	mot(Word,_,_,Root,NumRoot),
	atom_concat(Root,Term,FinalWord),!.