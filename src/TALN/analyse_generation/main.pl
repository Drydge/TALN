consult(dictionary).
%% include(analyse).
%% include(generate).


mot(_,_) :- mot(_,_,_,_,_).

%Verbe

verbe(_mot) :- 
	mot(_mot,verbe).

%Nom

nom(_mot):- 
	mot(_mot,nom).