INSERT INTO personne(typePersonne,numero,prenom,nom,email) VALUES('Personne',1,'olie','Condor','olie.condor@gmail.com');
INSERT INTO personne(typePersonne,numero,prenom,nom,email) VALUES('Personne',2,'alain','Therieur','at@gmail.com');
INSERT INTO personne(typePersonne,numero,prenom,nom,email,password) VALUES('Client',3,'jean','Bon','jb@gmail.com','pwd');

INSERT INTO compte(numero,label,solde,numClient) VALUES(1,'compte 1',50.0,3);
INSERT INTO compte(numero,label,solde,numClient) VALUES(2,'compte 2',70.0,3);

INSERT INTO t_option(id,label) VALUES(1,'decouvert autorisé 300euros');
INSERT INTO t_option(id,label) VALUES(2,'option 2');

INSERT INTO compte_option(numCompte,numOption) VALUES(1,1);
INSERT INTO compte_option(numCompte,numOption) VALUES(1,2);
INSERT INTO compte_option(numCompte,numOption) VALUES(2,2);