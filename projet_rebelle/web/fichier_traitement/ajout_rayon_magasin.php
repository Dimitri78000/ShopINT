<?php include('../fichier_web/structure/header_traitement.php'); 

	if (empty($_POST['Nom_rayon_form']) || empty($_POST['X0_form']) || empty($_POST['Y0_form']) || empty($_POST['X1_form']) || empty($_POST['Y1_form']) )
	{
		echo "Toutes les infos indispensables du formulaire ne sont pas remplies";
	}
	else{
		$Nom_rayon = $_POST['Nom_rayon_form']; 
		if ($_POST['X0_form'] > $_POST['X1_form'] ) // X1 doit être supérieur ou égal à X0
		{
			$X1 = $_POST['X0_form']; 
			$X0 = $_POST['X1_form'];
		}
		else
		{
			$X0 = $_POST['X0_form']; 
			$X1 = $_POST['X1_form'];
		}

		if ($_POST['Y0_form'] > $_POST['Y1_form'] ) // Y1 doit être supérieur ou égal à Y0
		{
			$Y1 = $_POST['Y0_form']; 
			$Y0 = $_POST['Y1_form'];
		}
		else
		{
			$Y0 = $_POST['Y0_form']; 
			$Y1 = $_POST['Y1_form'];
		}

		echo "Début du traitement...";
		?> <br/> <?php 
		echo "Donnée transmise à la base MySQL :";echo $Nom_rayon; echo $X0;echo $Y0;echo $X1;echo $Y1;
		?> <br/> <?php 

		$req = $bdd->prepare('INSERT INTO table_petit_magasin(Nom_rayon, X0, Y0, X1, Y1) VALUES(?, ?, ?, ?, ?)');
		$req->execute(array($Nom_rayon, $X0, $Y0, $X1, $Y1)); 


		echo "Fin du traitement"; 
		?> <br/> <?php 

		?>
		<a class="titre_gros" href="../plan.php"> Retour au plan </a> 
<?php } ?>
	
<?php
$page = $_SERVER["HTTP_REFERER"];
header('Refresh:1; URL='.$page);
?>

<style> .titre_gros{font-size: 1.5em;} </style> 
