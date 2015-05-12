%% les phrases sont de type :
%% SUJET + VERBE d'ACTION
%% SUJET + VERBE d'ÉTAT + ADJECTIF
%% SUJET + VERBE d'ÉTAT +ADVERBE + ADJECTIF
%% SUJET + VERBE d'ACTION + ADVERBE
%% SUJET + VERBE d'ACTION + ADVERBE + ADVERBE
%% SUJET + VERBE + COMPLEMENT d'OBJET
%% SUJET + VERBE + COMPLÉMENT CIRCONSTANCIEL

phrase --> sujet,verbe(action).
phrase --> sujet,verbe(etat),adj.
phrase --> sujet,verbe(etat),adv,adj.
phrase --> sujet,verbe(action),adv.
phrase --> sujet,verbe,adv,adv.
phrase --> sujet,verbe,compl_obj.
phrase --> sujet,verbe,compl_circ.
