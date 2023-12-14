 LIBRARY ieee;
USE ieee.std_logic_1164.ALL;

ENTITY memorisation IS 
PORT( 
		E								: IN STD_LOGIC_VECTOR (4 DOWNTO 0);
		ET 							: IN STD_LOGIC_VECTOR (3 DOWNTO 0);
		AP 							: IN STD_LOGIC_VECTOR (3 DOWNTO 0);
		P4d,P3d,P2d,P3m,P2m,P1m : IN STD_LOGIC;
		PortOuverte 				: IN STD_LOGIC;
		Horloge 						: IN STD_LOGIC;
		montee,descend 			: OUT STD_LOGIC; 
		unites,dizaines			: OUT STD_LOGIC_VECTOR (6 DOWNTO 0)
    ); 
END memorisation;

ARCHITECTURE ar OF memorisation IS

	CONSTANT zero   : STD_LOGIC_VECTOR (6 DOWNTO 0) := "0000001";
	CONSTANT un     : STD_LOGIC_VECTOR (6 DOWNTO 0) := "1001111";
	CONSTANT deux   : STD_LOGIC_VECTOR (6 DOWNTO 0) := "0010010";
	CONSTANT trois  : STD_LOGIC_VECTOR (6 DOWNTO 0) := "0000110";
	CONSTANT quatre : STD_LOGIC_VECTOR (6 DOWNTO 0) := "1001100";
	CONSTANT cinq   : STD_LOGIC_VECTOR (6 DOWNTO 0) := "0100100";
	CONSTANT six    : STD_LOGIC_VECTOR (6 DOWNTO 0) := "0100000";
	CONSTANT sept   : STD_LOGIC_VECTOR (6 DOWNTO 0) := "0001111";
	CONSTANT huit   : STD_LOGIC_VECTOR (6 DOWNTO 0) := "0000000";
	CONSTANT neuf   : STD_LOGIC_VECTOR (6 DOWNTO 0) := "0000100";
	CONSTANT erreur : STD_LOGIC_VECTOR (6 DOWNTO 0) := "0110000";
	CONSTANT eteint : STD_LOGIC_VECTOR (6 DOWNTO 0) := "1111111";

	TYPE M1_Etat IS (M1_Etat1,M1_Etat2,M1_Etat3,M1_Etat4,M1_Etat5,M1_Etat6,M1_Etat7,M1_Etat8,M1_Etat9,M1_Etat10,M1_Etat11,M1_Etat12,M1_Etat13,M1_Etat14,M1_Etat15,M1_Etat16,M1_Etat17,M1_Etat18,M1_Etat19);
	TYPE M2_Etat IS (M2_Etat1,M2_Etat2);
	TYPE M3_Etat IS (M3_Etat1,M3_Etat2);
	TYPE M4_Etat IS (M4_Etat1,M4_Etat2);
	TYPE M5_Etat IS (M5_Etat1,M5_Etat2);
	TYPE M6_Etat IS (M6_Etat1,M6_Etat2);
	
	SIGNAL M1_EtatPresent, M1_EtatSuivant : M1_Etat;
	SIGNAL M2_EtatPresent, M2_EtatSuivant : M2_Etat;
	SIGNAL M3_EtatPresent, M3_EtatSuivant : M3_Etat;
	SIGNAL M4_EtatPresent, M4_EtatSuivant : M4_Etat;
	SIGNAL M5_EtatPresent, M5_EtatSuivant : M5_Etat;
	SIGNAL M6_EtatPresent, M6_EtatSuivant : M6_Etat;

	SIGNAL Appel1,Appel2,Appel3,Appel4 : STD_LOGIC;
	SIGNAL finAppel1,finAppel2,finAppel3,finAppel4 : STD_LOGIC;
	SIGNAL s_Arret : STD_LOGIC;

	BEGIN

	-- DESCRIPTION DU BLOC F
	--- MAE1 pour la commande du déplacement de l’ascenseur et des portes 
	PROCESS (AP,ET,PortOuverte,Appel1,Appel2,Appel3,Appel4)
		BEGIN
		CASE M1_EtatPresent IS
			-- traitement des etages
			WHEN M1_Etat1 => IF Appel2='1' OR Appel3='1' OR Appel4='1' THEN M1_EtatSuivant<=M1_Etat6;
				ELSIF Appel1='1' THEN M1_EtatSuivant<=M1_Etat12;
				END IF;
			WHEN M1_Etat2 => IF Appel3='1' OR Appel4='1' THEN M1_EtatSuivant<=M1_Etat8;
				ELSIF Appel2='1' THEN M1_EtatSuivant<=M1_Etat14;
				ELSIF Appel1='1' THEN M1_EtatSuivant<=M1_Etat7;
				END IF;
			WHEN M1_Etat3 => IF Appel4='1' THEN M1_EtatSuivant<=M1_Etat10;
				ELSIF Appel3='1' THEN M1_EtatSuivant<=M1_Etat16;
				ELSIF Appel2='1' OR Appel1='1' THEN M1_EtatSuivant<=M1_Etat9;
				END IF;
			WHEN M1_Etat4 => IF Appel4='1' THEN M1_EtatSuivant<=M1_Etat18;
				ELSIF Appel3='1' OR Appel2='1' OR Appel1='1' THEN M1_EtatSuivant<=M1_Etat11;
				END IF;
				
			--traitement des transistion entre étages
			WHEN M1_Etat5 => IF ET(0)='1' THEN M1_EtatSuivant<=M1_Etat1; END IF;
			WHEN M1_Etat6 => IF ET(1)='1' THEN M1_EtatSuivant<=M1_Etat2; END IF;
			WHEN M1_Etat7 => IF ET(0)='1' THEN M1_EtatSuivant<=M1_Etat1; END IF;
			WHEN M1_Etat8 => IF ET(2)='1' THEN M1_EtatSuivant<=M1_Etat3; END IF;
			WHEN M1_Etat9 => IF ET(1)='1' THEN M1_EtatSuivant<=M1_Etat2; END IF;
			WHEN M1_Etat10 => IF ET(3)='1' THEN M1_EtatSuivant<=M1_Etat4; END IF;
			WHEN M1_Etat11 => IF ET(2)='1' THEN M1_EtatSuivant<=M1_Etat3; END IF;
				
			--traitement des portes
			WHEN M1_Etat12 => IF PortOuverte='1' THEN M1_EtatSuivant<=M1_Etat13; END IF; 	--etage1
			WHEN M1_Etat13 => IF PortOuverte='0' THEN M1_EtatSuivant<=M1_Etat1; END IF; 	--etage1
			WHEN M1_Etat14 => IF PortOuverte='1' THEN M1_EtatSuivant<=M1_Etat15; END IF; 	--etage2
			WHEN M1_Etat15 => IF PortOuverte='0' THEN M1_EtatSuivant<=M1_Etat2; END IF; 	--etage2
			WHEN M1_Etat16 => IF PortOuverte='1' THEN M1_EtatSuivant<=M1_Etat17; END IF; 	--etage3
			WHEN M1_Etat17 => IF PortOuverte='0' THEN M1_EtatSuivant<=M1_Etat3; END IF; 	--etage3
			WHEN M1_Etat18 => IF PortOuverte='1' THEN M1_EtatSuivant<=M1_Etat19; END IF; 	--etage4
			WHEN M1_Etat19 => IF PortOuverte='0' THEN M1_EtatSuivant<=M1_Etat4; END IF; 	--etage4
		END CASE;  
	END PROCESS;
	
	--- MAE2 d’arrêt d’urgence 
	PROCESS (E)
		BEGIN
		CASE M2_EtatPresent IS
			WHEN M2_Etat1 => IF E(1)='1' THEN M2_EtatSuivant<=M2_Etat2; END IF;
			WHEN M2_Etat2 => IF E(2)='1' THEN M2_EtatSuivant<=M2_Etat1; END IF;
		END CASE;
	END PROCESS;
	
	--- MAE3 pour la mémorisation des appels internes ou externes de l’étage 1
	PROCESS (P1m,AP,finAppel1)
		BEGIN
		CASE M3_EtatPresent IS
			WHEN M3_Etat1 => IF P1m='1' OR AP(0)='1' THEN M3_EtatSuivant<=M3_Etat2; END IF;
			WHEN M3_Etat2 => IF finAppel1='1' THEN M3_EtatSuivant<=M3_Etat1; END IF;
		END CASE;
	END PROCESS;
	
	--- MAE4 pour la mémorisation des appels internes ou externes de l’étage 2
	PROCESS (P2m,P2d,AP,finAppel2)
		BEGIN
		CASE M4_EtatPresent IS
			WHEN M4_Etat1 => IF P2m='1' OR P2d='1' OR AP(1)='1' THEN M4_EtatSuivant<=M4_Etat2; END IF;
			WHEN M4_Etat2 => IF finAppel2='1' THEN M4_EtatSuivant<=M4_Etat1; END IF;
		END CASE;
	END PROCESS;
	
	--- MAE5 pour la mémorisation des appels internes ou externes de l’étage 3
	PROCESS (P3m,P3d,AP,finAppel3)
		BEGIN
		CASE M5_EtatPresent IS
			WHEN M5_Etat1 => IF P3m='1' OR P3d='1' OR AP(2)='1' THEN M5_EtatSuivant<=M5_Etat2; END IF;
			WHEN M5_Etat2 => IF finAppel3='1' THEN M5_EtatSuivant<=M5_Etat1; END IF;
		END CASE;
	END PROCESS;
	
	--- MAE6 pour la mémorisation des appels internes ou externes de l’étage 4
	PROCESS (P4d,AP,finAppel4)
		BEGIN
		CASE M6_EtatPresent IS
			WHEN M6_Etat1 => IF P4d='1' OR AP(3)='1' THEN M6_EtatSuivant<=M6_Etat2; END IF;
			WHEN M6_Etat2 => IF finAppel3='1' THEN M6_EtatSuivant<=M6_Etat1; END IF;
		END CASE;
	END PROCESS;

	-- DESCRIPTION DU BLOC M
	PROCESS (Horloge,E) 
	 BEGIN
		-- passage à l'etat suivant
		IF ((Horloge'EVENT) AND (Horloge = '1')) THEN 	M1_EtatPresent <= M1_EtatSuivant; 
																		M2_EtatPresent <= M2_EtatSuivant; 
																		M3_EtatPresent <= M3_EtatSuivant; 
																		M4_EtatPresent <= M4_EtatSuivant; 
																		M5_EtatPresent <= M5_EtatSuivant; 
																		M6_EtatPresent <= M6_EtatSuivant; 
		END IF;
		
		-- initialisation des etats
		IF (E(0)='1') THEN 	M1_EtatPresent<=M1_Etat5; 
									M2_EtatPresent<=M2_Etat1;
									M3_EtatPresent<=M3_Etat1;
									M4_EtatPresent<=M4_Etat1;
									M5_EtatPresent<=M5_Etat1;
									M6_EtatPresent<=M6_Etat1;
		END IF;
	END PROCESS; 

	-- DESCRIPTION DU BLOC G
	-- sorties pour pilotage des afficheurs de la carte
	with M1_EtatPresent select
		unites <= 	zero   	WHEN M1_Etat10,
						un			WHEN M1_Etat1 | M1_Etat11,
						deux		WHEN M1_Etat2 | M1_Etat12,
						trois  	WHEN M1_Etat3 | M1_Etat13,
						quatre 	WHEN M1_Etat4 | M1_Etat14,
						cinq 		WHEN M1_Etat5 | M1_Etat15,
						six		WHEN M1_Etat6 | M1_Etat16,
						sept		WHEN M1_Etat7 | M1_Etat17,
						huit		WHEN M1_Etat8 | M1_Etat18,
						neuf		WHEN M1_Etat9 | M1_Etat19,
						erreur	WHEN OTHERS;
	dizaines <= 	eteint 	WHEN (M1_EtatPresent < M1_Etat10) ELSE 
						un 		WHEN (M1_EtatPresent >= M1_Etat10 AND M1_EtatPresent <= M1_Etat19)ELSE 
						erreur;
						
	-- memorisation des poussoirs d'arret d'urgence
	s_Arret<='1' WHEN M2_EtatPresent=M2_Etat2	ELSE '0';
	
	-- sorties pour pilotage de la cabine
	montee<='1' WHEN (M1_EtatPresent=M1_Etat6 OR M1_EtatPresent=M1_Etat8 OR M1_EtatPresent=M1_Etat10) AND (s_Arret='0') ELSE '0';
	descend<='1' WHEN (M1_EtatPresent=M1_Etat7 OR M1_EtatPresent=M1_Etat9 OR M1_EtatPresent=M1_Etat11) AND (s_Arret='0') ELSE '0';
	
	-- MaJ memorisation des poussoirs
	Appel1<='1' WHEN M3_EtatPresent=M3_Etat2	ELSE '0';
	Appel2<='1' WHEN M4_EtatPresent=M4_Etat2	ELSE '0';
	Appel3<='1' WHEN M5_EtatPresent=M5_Etat2	ELSE '0';
	Appel4<='1' WHEN M6_EtatPresent=M6_Etat2	ELSE '0';
	
	-- MaJ finAppel
	finAppel1<='1' WHEN M1_EtatPresent=M1_Etat13	ELSE '0';
	finAppel2<='1' WHEN M1_EtatPresent=M1_Etat15	ELSE '0';
	finAppel3<='1' WHEN M1_EtatPresent=M1_Etat17	ELSE '0';
	finAppel4<='1' WHEN M1_EtatPresent=M1_Etat19	ELSE '0';

END ar;
