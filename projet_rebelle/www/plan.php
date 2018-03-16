<?php include('fichier_web/structure/header.php'); ?>
<br/> <a> Partie plan </a>
<br/>

<div>
	On travaille pour l'instant sur un petit magasin de taille 10*10 (celui du Google Drive "Magasin Test 10*10") <br/><br/>
	<?php 

	$matrice=Creer_et_rempli_matrice($bdd);
	Afficher_matrice($matrice); 
	?>

</div>







<p>
	Partie modification du magasin : seulement pour les admins (partie Connexion à coder)
<form class="formulaire_ajout_rayon" method="post" action="fichier_traitement/ajout_rayon_magasin.php">
   <p>
   		<label for="Nom_rayon_form" placeholder="moutarde" > Nom du rayon : </label> <input type="text" name="Nom_rayon_form" /> <br/>
   		<label for="X0_form"  > Numéro abscisse (colonne) point 1 : <input type="number"  name="X0_form" min="0" max="9"  /> <br/>
   		<label for="Y0_form" > Numéro ordonnée (ligne) point 1 :<input type="number" name="Y0_form" min="0" max="9"  /> <br/>
   		<label for="X1_form"  > Numéro abscisse (colonne) point 2 :<input type="number" name="X1_form" min="0" max="9"  /> <br/>
   		<label for="Y1_form"  > Numéro ordonnée (ligne) point 2 : <input type="number" name="Y1_form" min="0" max="9"  /> <br/>
   			Les lignes et colonnes commencent à 0 ! <br/>
   		<input type="submit" value="Envoyer" />

   </p>
</form>
<style> .formulaire_ajout_rayon{ border: 2px black solid; border-radius: 4px; padding: 5px 20px 5px 20px; margin: 0px 20px 0px 20px; width:600px;} </style>

</p>








<?php include('fichier_web/structure/footer.php'); ?>


<!-- PARTIE FONCTION -->

<?php


function Afficher_matrice($matrice)
{
	?>
	<table> <?php
	for ($i=0;$i<10;$i++)
	{
		?> <tr> <?php
		for($j=0;$j<10;$j++)
		{
			?> <td> <?php
				echo $matrice[$i][$j];
			?> </td> <?php
		}
		?> </tr> <?php
	}
	?>

	</table>
	<style>  </style> <!--Une partie du style est dans le style.css -->
	<?php 
}




function Creer_et_rempli_matrice($bdd){

	// Attention, matrice[ligne][colonne], ie colonne[y][x] si x est l'abscisse et y l'ordonnée

	$matrice=array();
	for($i=0;$i<10;$i++){
		for($j=0;$j<10;$j++)
		{
			$matrice[$i][$j]="";
		}
	}

	$reponse = $bdd->query('SELECT * FROM table_petit_magasin'); 
	while ($donnees = $reponse->fetch())
	{

		if (is_null($donnees['X2'])==1) // Le rayon est un rayon standard, et non un carré
		{

			$nom_rayon = $donnees['Nom_rayon'];
			$X0 = $donnees['X0'];
			$Y0 = $donnees['Y0'];
			$X1 = $donnees['X1'];
			$Y1 = $donnees['Y1'];

			if (($X0 == $X1 ) AND ($Y0 == $Y1) ) // Le rayon est un rayon d'une seule case
			{
				$matrice[$X0][$Y0]=$nom_rayon;
			}
			elseif ($X0 == $X1 ) // Le rayon est un rayon "horizontal"
			{
				for($y=$Y0;$y<=$Y1;$y++)
				{
					$matrice[$y][$X0]=$nom_rayon;
				}

			}
			elseif ($Y0 == $Y1) // Le rayon est un rayon "vertical"
			{
				for($x=$X0;$x<=$X1;$x++)
				{
					$matrice[$Y0][$x]=$nom_rayon;
				}
			}
			else // erreur
			{
				echo "Problème 1 : problème de coordonnée";
			}
		}
		else // Le rayon est un rayon carré
		{

		}


	}
	return $matrice;
}


?> 