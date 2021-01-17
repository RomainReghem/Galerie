-- Initialisation spécifiques pour un jeu de test
INSERT INTO Galerie(id, nom, adresse) VALUES (1, 'Saatchi', 'King\''s Road, Londres');

-- Dans Exposition
INSERT INTO Exposition(id, debut, intitule, duree) VALUES
(1, TO_DATE('2020-08-28', 'YYYY-MM-DD'), 'Meilleure Exposition et de loin', 200),
(2, TO_DATE('2021-05-12', 'YYYY-MM-DD'), 'Exposition de malade', 120);

-- Dans Personne

INSERT INTO Personne(id, nom, adresse) VALUES
(1, 'Changpeng Zhao', '13 rue des jetons'), 
(2, 'Chris Larsen', '28 rue de la chute'), 
(3, 'Elon Musk', '189 avenue Nicolas Tesla');

-- Dans Transaction

INSERT INTO Transaction VALUES 
(1, 50000, TO_DATE('2020-09-28', 'YYYY-MM-DD'), 1, 1, 1), 
(2, 120000, TO_DATE('2020-09-29', 'YYYY-MM-DD'), 1, 2, 2), 
(3, 10000, TO_DATE('2020-09-23', 'YYYY-MM-DD'), 1, 3, 3);*/
