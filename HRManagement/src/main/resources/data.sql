insert into FUNCTIE(ID, NUME) values ('105', 'Director general');
insert into FUNCTIE(ID, NUME) values ('106', 'Recruiter');
insert into FUNCTIE(ID, NUME) values ('107', 'Business manager');
insert into FUNCTIE(ID, NUME) values ('108', 'Project manager');
insert into FUNCTIE(ID, NUME) values ('109', 'Dezvoltator');

insert into ANGAJAT(ID, COD, NUME, PRENUME, TELEFON, EMAIL, FUNCTIE_ID) values ('1', 'DST', 'Stefan', 'Dumitru', '0735532645', 'stefan.dumitru@yahoo.com', '106');
insert into ANGAJAT(ID, COD, NUME, PRENUME, TELEFON, EMAIL, FUNCTIE_ID) values ('2', 'PMI', 'Mihai', 'Popescu', '0733552465', 'mihai.popescu@gmail.com', '108');

insert into COMPETENTA(ID, NUME, DESCRIERE) values ('1', 'Java SE', 'Java SE');
insert into COMPETENTA(ID, NUME, DESCRIERE) values ('2', '.NET', '.NET');

insert into CANDIDAT(ID, NUME, PRENUME, TELEFON, EMAIL, RECRUITER_ID) values ('1', 'Ioana', 'Popa', '0726316473', 'popa.ioana@yahoo.com', '1');

insert into CANDIDAT_COMPETENTA(CANDIDAT_ID, COMPETENTA_ID) values ('1', '2');

insert into EVALUARE(ID, DESCRIERE, CANDIDAT_ID, RESPONSABIL_ID) values ('1', 'Cunostinte de middle level', '1', '2');