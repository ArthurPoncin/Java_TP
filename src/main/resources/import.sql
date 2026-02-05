INSERT INTO LIVRE (ID, TITRE, AUTEUR) VALUES (1, 'Vingt mille lieues sous les mers', 'Jules Verne');
INSERT INTO LIVRE (ID, TITRE, AUTEUR) VALUES (2, 'Germinal', 'Emile Zola');
INSERT INTO LIVRE (ID, TITRE, AUTEUR) VALUES (3, 'Guerre et paix', 'Léon Tolstoï');
INSERT INTO LIVRE (ID, TITRE, AUTEUR) VALUES (4, 'Apprendre à parler aux animaux', 'Gaston Pouet');
INSERT INTO LIVRE (ID, TITRE, AUTEUR) VALUES (5, '1001 recettes de Cuisine', 'Jean-Pierre Coffe');

SELECT setval('livre_id_seq', (SELECT MAX(id) FROM LIVRE));
