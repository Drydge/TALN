mot(venir,verbe,enir,vien,1).
mot(venir,verbe,enir,ven,2).
mot(venir,verbe,enir,vienn,3).
mot(venir,verbe,enir,vîn,4).
mot(venir,verbe,enir,vin,5).

mot(tenir,verbe,enir,tien,1).
mot(tenir,verbe,enir,ten,2).
mot(tenir,verbe,enir,tienn,3).
mot(tenir,verbe,enir,tîn,4).
mot(tenir,verbe,enir,tin,5).


mot(manger,verbe,accord_er,mang,1).
mot(manger,verbe,accord_er,mange,2).

mot(proteger,verbe,accord_er,proteg,1).
mot(proteger,verbe,accord_er,protege,2).

mot(coucher,verbe,accord_er,couch,1).
mot(coucher,verbe,accord_er,couche,2).

mot(boire,verbe,oire,bo,1).
mot(boire,verbe,oire,buv,2).

mot(joueur,nom,eur_euse,jou,1).




%Mot
mot(_mot,_type) :- mot(_mot,_type,_,_,_).

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
