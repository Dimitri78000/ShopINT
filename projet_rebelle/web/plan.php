<?php include('fichier_web/structure/header.php'); ?>

 <a class="titre_partie"> <li> Partie plan </li> </a> <br/> 


<div>
	On travaille pour l'instant sur un petit magasin de taille 10*10 (celui du Google Drive "Magasin Test 10*10") <br/><br/>
	<?php 

	$x_matrice=10;
	$y_matrice=10;
	$table="plan_petit_magasin_test";
	$matrice=Creer_et_rempli_matrice($x_matrice,$y_matrice,$bdd,$table);
	Afficher_matrice($x_matrice,$y_matrice,$matrice); 
	?>

</div>







<p>
	Partie modification du magasin : seulement pour les admins (partie Connexion à coder)
	<fieldset class="fieldset_rayon">
		<legend>Ajout Rayon</legend>
<form class="formulaire_ajout_rayon" method="post" action="fichier_traitement/ajout_rayon_magasin.php">
   <p>
   		<label for="Nom_rayon_form" placeholder="moutarde" > Nom du rayon : </label> <input type="text" name="Nom_rayon_form" /> <br/>
   		<label for="X0_form"  > Numéro colonne X0 : <input type="number"  name="X0_form" min="0" max= <?php echo $x_matrice ; ?>  /> <br/>
   		<label for="Y0_form" > Numéro ligne Y0 :<input type="number" name="Y0_form" min="0" max=<?php echo $x_matrice ; ?>  /> <br/>
   		<label for="X1_form"  > Numéro colonne X1 :<input type="number" name="X1_form" min="0" max=<?php echo $x_matrice ; ?>  /> <br/>
   		<label for="Y1_form"  > Numéro ligne Y1 : <input type="number" name="Y1_form" min="0" max=<?php echo $x_matrice ; ?>  /> <br/><br/>
   		<input type="submit" value="Envoyer" />
	</p>
	</form>
   	</fieldset>

<style> 
.formulaire_ajout_rayon{  
} 
.fieldset_rayon{
	max-width: 700px;
	margin-left: auto;
    margin-right: auto;
}
</style>

</p>








<?php include('fichier_web/structure/footer.php'); ?>


<!-- PARTIE FONCTION -->

<?php


function Afficher_matrice($x_matrice,$y_matrice,$matrice)
{
	?>
	<div class="representation_magasin">
	<table class="table_magasin"> <?php
	for ($i=0;$i<=$y_matrice;$i++)
	{
		?> <tr> <?php
		for($j=0;$j<=$x_matrice;$j++)
		{
			?> <td> <?php
				echo $matrice[$i][$j];
			?> </td> <?php
		}
		?> </tr> <?php
	}
	?>

	</table>
	</div>
	
	<style>
	.table_magasin{
		margin-left: auto;
   		margin-right: auto;
	}  
	.representation_magasin{
		max-width:950px;
		max-height:750px;
		height: 90%;
		overflow: auto;
	}
	</style> 
	<?php 
}




function Creer_et_rempli_matrice($x_matrice,$y_matrice,$bdd,$table){

	// Attention, matrice[ligne][colonne], ie colonne[y][x] si x est l'abscisse et y l'ordonnée

	$matrice=array();
	$matrice[0][0]="";
	for($j=1;$j<=$y_matrice;$j++)
		{
			$matrice[0][$j]=" <strong> X=$j </strong>";
		}
	for($i=1;$i<=$x_matrice;$i++){

		for($j=0;$j<=$x_matrice;$j++)
		{
			if ($j==0){
				$matrice[$i][0]="<strong> Y=$i </strong> ";
			}
			else{
				$matrice[$i][$j]="";
			}
		}
	}

	$reponse = $bdd->query('SELECT * FROM table_petit_magasin '); 
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
				$matrice[$Y0][$X0]=$nom_rayon;
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