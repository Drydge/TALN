%% les phrases sont de type :
%% SUJET + VERBE d'ACTION
%% SUJET + VERBE d'ÉTAT + ADJECTIF
%% SUJET + VERBE d'ÉTAT +ADVERBE + ADJECTIF
%% SUJET + VERBE d'ACTION + ADVERBE
%% SUJET + VERBE d'ACTION + ADVERBE + ADVERBE
%% SUJET + VERBE + COMPLEMENT d'OBJET
%% SUJET + VERBE + COMPLÉMENT CIRCONSTANCIEL

phrase --> sujet(),verbeaction().
phrase --> sujet(),verbeetat(),adj.
phrase --> sujet(),verbeetat(),adv,adj.
phrase --> sujet(),verbeaction(),adv.
phrase --> sujet(),verbeaction(),adv,adv.
phrase --> sujet(),verbe(),compl_obj().
phrase --> sujet(),verbe(),compl_circ().
